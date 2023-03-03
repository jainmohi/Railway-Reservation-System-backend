package com.app.dto;

import java.util.List;

import com.example.demo.pojos.Train;
import com.example.demo.pojos.TrainClass;

import lombok.Data;

@Data
public class TrainClassDetails 
{
	


	private Train train;
	
	private List<TrainClass> Trainclasslist; 
	
public TrainClassDetails(Train train, List<TrainClass> trainclasslist) 
    {
		
		this.train = train;
		Trainclasslist = trainclasslist;
	}

public TrainClassDetails()
{
	
}

	
	
	
	
	
}
