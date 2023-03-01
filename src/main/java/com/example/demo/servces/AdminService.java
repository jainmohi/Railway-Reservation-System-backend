package com.example.demo.servces;



import java.util.List;

import com.example.demo.pojos.Train;
import com.example.demo.pojos.User;

public interface AdminService
{
	public Train addTrainDetail(Train train);
	
	public Train findTrainByName(String name);
	
	public void removeTrainById(Long Id);

	public List<Train> getTrains();
	
	public Train updateTrainDetail(Train train);
	
	public List<User> getUser();
	
}