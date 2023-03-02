package com.example.demo.servces;

import com.example.demo.daos.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.daos.TrainDao;
import com.example.demo.pojos.Train;
import com.example.demo.pojos.TrainClass;
import com.example.demo.pojos.User;

@Service
public class AdminServiceImpl implements AdminService
{
	
	@Autowired
	private TrainDao TrainDao;
	
	@Autowired
	private UserDao UserDao;
	
	@Autowired
	private TrainClassDao TrainClassDao;
	
	

	@Override
	public Train addTrainDetail(Train train) 
	{
		
		return TrainDao.save(train);
		
	}

	@Override
	public Train findTrainByName(String name) 
	{
		return TrainDao.findByTrainName( name);
		
	}

	@Override
	public void removeTrainById(Long Id) 
	{
		TrainDao.deleteById(Id);
		
	}

	@Override
	public List<Train> getTrains() {
		
		return TrainDao.findAll();
	}

	@Override
	public Train updateTrainDetail(Train train) {
		
		return TrainDao.save(train);
		
	}

	@Override
	public List<User> getUser() {
		return UserDao.findAll();
	}

	@Override
	public void addtrainclass(TrainClass Trainclass) {
		
		TrainClassDao.save(Trainclass);
	}

	

}
