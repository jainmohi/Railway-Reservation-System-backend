package com.example.demo.servces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojos.Train_Station_Timings;


public interface PassengerService 
{
	public Long findStaionIdByName(String name);
	
	public List<Train_Station_Timings> getTrainStaionTimmingDataByStationId(Long Id);
	
	public List<Train_Station_Timings> getTrainStaionDataByTrainId(Long id);
	

}
