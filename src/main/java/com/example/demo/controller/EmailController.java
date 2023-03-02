package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Credential;
import com.app.dto.EmialDTO;
import com.app.dto.Response;
import com.app.dto.resultDto;
import com.example.demo.pojos.User;
import com.example.demo.servces.EmailService;
import com.example.demo.servces.UserService;




@CrossOrigin(origins = "*")
@RestController


public class EmailController{
	Random random=new Random(1000);
	
	@Autowired
	private EmailService emailservice;
	
    @Autowired
    private  UserService userService;
	
	@PostMapping("/sendotp")
	public resultDto Signup(@RequestBody EmialDTO req) {	
		
		
		resultDto resultdto=null;
		String result="";
		
		System.out.println("EMAIL"+req.getEmail());
		
		User validuser = new User();
		System.out.println(req.getEmail());
		if(validuser!=null) {
			System.out.println("yupp baby");
			
			int otp=random.nextInt(999999);
			String subject ="OTP from Railway reservation System";
			String message="your Reset password message OTP  "+otp+" ";
			String to=req.getEmail();
			boolean flag=this.emailservice.sendEmail(subject, message, to);		
			if(flag) {
				resultdto=new resultDto("success",otp);
			}else {
				resultdto=new resultDto("failure",otp);
			}
		}
		else{
			System.out.println("Ohhh sorrry ");
		}
				 
		return resultdto;
	}
	
	
	@PostMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody Credential cred){
		System.out.println(cred.toString());
		System.out.println("inside passwordreset");
		System.out.println(cred.getEmail());
		System.out.println(cred.getPassword());
		User validuser=userService.checkEmail(cred.getEmail());
		System.out.println(validuser);
		User persistentUser=userService.restPass(validuser,cred.getPassword());
		if(persistentUser!=null) {
			System.out.println("successfully changed the password");
			return Response.success("Password changed sucessfully");
		}else {
			return Response.error("Password Not changed");
		}
		
	}
	
	
	
	

}
