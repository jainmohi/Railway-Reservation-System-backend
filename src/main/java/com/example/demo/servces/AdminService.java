package com.example.demo.servces;



import com.example.demo.pojos.Train;

public interface AdminService
{
	public Train addTrainDetail(Train train);
	
	public Train findTrainByName(String name);
	
	public void removeTrainById(Long Id);
	
}