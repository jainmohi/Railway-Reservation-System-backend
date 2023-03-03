package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TrainClassDetails;
import com.example.demo.pojos.*;
import com.example.demo.servces.AdminService;
import com.example.demo.servces.UserService;

@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userservice;
	
	@Autowired
	private AdminService AdminService;

	public UserController() 
	{
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginAuthenticaion(@RequestBody Map<String,String> u)
	{
		System.out.println("in logn authenticaton method");
		System.out.println("email and passwrd" +u.get("password") + u.get("email"));
	User user = userservice.loginAuthentication(u.get("password"), u.get("email"));
		System.out.println("user" + user);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@PostMapping("/registration")
	public ResponseEntity<?> userRegistration(@RequestBody User user)
	{
		System.out.println("in registration method");
		
	return new ResponseEntity<>(userservice.userRegister(user), HttpStatus.OK);
	}
	
	@PutMapping("/forgotpassword")
	public String updateUserPasswordByEmail(@RequestBody Map<String,String>  mp) {	
		System.out.println("in password update method");
		return userservice.updateUserPasswordByEmail(mp.get("password"),mp.get("email"));
	}
	
	
	@PostMapping("/getTrainsByStations")
	public List<TrainClassDetails> getTrainsByStations(@RequestBody Map<String,String>  mp) {	
		System.out.println("in getTrainsByStations method");
		List<Train> trainlist = userservice.getTrainsByStations(mp.get("fromStation"),mp.get("toStation"));
		List<TrainClassDetails>  TrainClassDetailslist = new ArrayList<>();
		List<TrainClass> TrainClassList = new  ArrayList<>();
		
		for(Train train :trainlist )
		{
			Long trainid = train.getTrain_code();
			TrainClassList = AdminService.gettrainclassdetailsbyid(trainid);
			TrainClassDetails TrainClassDetail = new TrainClassDetails(train,TrainClassList);
			TrainClassDetailslist.add(TrainClassDetail);
			
			
		}
		return TrainClassDetailslist;
		
	}

	
	@DeleteMapping("/deleteuser/{id}")
	public void removeTrain(@PathVariable Long id)
	{
		
		
		userservice.deleteuserbyid(id);
	}
	
	
	
}
