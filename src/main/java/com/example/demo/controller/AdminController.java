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

import com.example.demo.daos.TrainClassDao;
import com.example.demo.daos.TrainDao;
import com.example.demo.pojos.Train;
import com.example.demo.pojos.TrainClass;
import com.example.demo.pojos.User;
import com.example.demo.servces.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController
{
	
	@Autowired
	private AdminService AdminService;
	
	@Autowired
	private TrainDao trainDao;
	
	@Autowired
	private TrainClassDao trainClassDao;
	
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
		
		Train t1 = AdminService.addTrainDetail(train);
		
		
//		Train t = trainDao.findById(t1.getTrain_code()).get();
//		System.out.println(t);
		Long id = t1.getTrain_code();
		
		
		TrainClass  c1 = new TrainClass("Class-A",90,id);
		
		trainClassDao.save(c1);
		TrainClass  c2 = new TrainClass("Class-B",90,id);
		trainClassDao.save(c2);
		TrainClass  c3 = new TrainClass("Class-C",90,id);
		trainClassDao.save(c3);
		
		return new ResponseEntity<>(t1,HttpStatus.OK);
	}
	
	public Train findTrainByName(String name)
	{
		return AdminService.findTrainByName(name);
	}
	
	
	@DeleteMapping("/deletetrain/{id}")
	public void removeTrain(@PathVariable Long id)
	{
		AdminService.deleteclasstrainbytrainid(id);
		
		AdminService.removeTrainById(id);
	}
	
	@GetMapping("/getClassesByTrain/{id}")
	public List<TrainClass> getClassesByTrain(@PathVariable Long id)
	{
		System.out.println("in getClassesByTrain method");
		return AdminService.getClassesByTrain(id);
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
