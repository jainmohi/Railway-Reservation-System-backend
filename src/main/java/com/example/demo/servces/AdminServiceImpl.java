package com.example.demo.servces;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.daos.AdminDao;
import com.example.demo.pojos.Train;

@Service
public class AdminServiceImpl implements AdminService
{
	
	@Autowired
	private AdminDao AdminDao;

	@Override
	public Train addTrainDetail(Train train) 
	{
		
		return AdminDao.save(train);
		
	}

	@Override
	public Train findTrainByName(String name) 
	{
		return AdminDao.findByTrainName( name);
		
	}

	@Override
	public void removeTrainById(Long Id) 
	{
		AdminDao.deleteById(Id);
		
	}

	@Override
	public List<Train> getTrains() {
		// TODO Auto-generated method stub
		return AdminDao.findAll();
	}

	

}
