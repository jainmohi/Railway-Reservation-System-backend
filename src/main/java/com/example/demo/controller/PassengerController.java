package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.servces.*;
import com.example.demo.pojos.*;

@CrossOrigin
@RestController
@RequestMapping("/Passenger")
public class PassengerController 
{
	@Autowired
	private PassengerService PassengerService;

	public PassengerController() {
		System.out.println("in passenger controller");
	}

	
	@PostMapping("/traindata")
	public List<Train> getTrainDetails(@RequestBody Map<String,String> mp)
	{
		ArrayList<Train> Finalist = new ArrayList<>();
		Long Fromstaion = findStaionIdByName(mp.get("fromstation"));
		Long Tostaion = findStaionIdByName(mp.get("tostation"));
		
		List<Train_Station_Timings> data = getTrainStaionTimmingDataByStationId(Fromstaion);
		
		for(Train_Station_Timings list :data)
		{
			List<Train_Station_Timings> l = getTrainStaionTimmingDataByTrainId(list.getTrain().getTrain_code());
			
			for(Train_Station_Timings list1: l)
			{
				if(list1.getStation().getStation_code()==Tostaion)
				{
					Finalist.add(list1.getTrain());
				}
				
			}
			
			
			
			
		}
		
		
		return Finalist;
		
		
		
	}
	
	
	public List<Train_Station_Timings> getTrainStaionTimmingDataByTrainId(Long id)
	{
		return PassengerService.getTrainStaionDataByTrainId(id);
		
	}
	
	public List<Train_Station_Timings> getTrainStaionTimmingDataByStationId(Long Id)
	{
		return PassengerService.getTrainStaionTimmingDataByStationId(Id);
		
	}
	
	
	
	
	public Long findStaionIdByName(String sname)
	{
		
		return PassengerService.findStaionIdByName(sname);
	}
	
	
	
	
	
}
