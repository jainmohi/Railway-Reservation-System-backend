package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Train;
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
	
	
	@PostMapping("/removetrain")
	public void removeTrain(@RequestBody Map<String,String> mp)
	{
		System.out.println("in removetrain method");
		Train train = findTrainByName(mp.get("trainName"));
		
		AdminService.removeTrainById(train.getTrain_code());
		
	}
	
	@GetMapping("/trainsList")
	public List<Train> getAllTrains()
	{
		System.out.println("in get trains method");
		List<Train> allTrains = AdminService.getTrains();
		return allTrains;
		
		
	}
	
	
	
	
}
