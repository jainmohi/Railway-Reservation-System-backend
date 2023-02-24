package com.example.demo.servces;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Train;
import com.example.demo.userdao.AdminDao;

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
		return AdminDao.findBytrainName( name);
		
	}

	@Override
	public void removeTrainById(Long Id) 
	{
		AdminDao.deleteById(Id);
		
	}

	

}
