package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Train;
import com.example.demo.pojos.User;
import com.example.demo.servces.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController
{
	
	@Autowired
	private AdminService AdminService;

	public AdminController()
	{
		System.out.println("In admin controller");
	}
	
	@PostMapping("/updatetrain")
	public ResponseEntity<?> updateTrain(@RequestBody Train train)
	{
		System.out.println("in updatetrain method");
		
	return new ResponseEntity<>(AdminService.updateTrainDetail(train), HttpStatus.OK);
	}
	
	@PostMapping("/addtrain")
	public ResponseEntity<?> addTrain(@RequestBody Train train)
	{
		System.out.println("in addtrain method");
		return new ResponseEntity<>(AdminService.addTrainDetail(train), HttpStatus.OK);
	}
	
	public Train findTrainByName(String name)
	{
		return AdminService.findTrainByName(name);
	}
	
	
	@DeleteMapping("/deletetrain/{id}")
	public void removeTrain(@PathVariable Long id)
	{
		System.out.println("in removetrain method");
		AdminService.removeTrainById(id);
	}
	
	@GetMapping("/trainsList")
	public List<Train> getAllTrains()
	{
		System.out.println("in get trains method");
		List<Train> allTrains = AdminService.getTrains();
		return allTrains;	
	}
	
	@GetMapping("/getTrain/{id}")
	public Train getTrainById(@PathVariable int id)
	{
		System.out.println("in get trains method");
		if(AdminService.getTrainById(id).isPresent())
			return AdminService.getTrainById(id).get();
		else
			return null;
	}
	
	@GetMapping("/getuser")
	public List<User> getAllUser()
	{
		System.out.println("in get user method");
		List<User> allUser = AdminService.getUser();
		return allUser;
		
		
	}
	
	
	
	
}
