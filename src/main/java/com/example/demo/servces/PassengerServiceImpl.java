package com.example.demo.servces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.daos.*;
import com.example.demo.pojos.Station;
import com.example.demo.pojos.Train_Station_Timings;

@Service
public class PassengerServiceImpl implements PassengerService
{
	@Autowired
	private StationDao PassengerDao;
	
//	@Autowired
//	private TrainStationDao TrainStationDao;
	
	@Autowired
	private TrainStationTimmingDao TrainStationTimmingDao;

	@Override
	public Long findStaionIdByName(String name) 
	{
		Station s = PassengerDao.findByStationName(name);
		return s.getStation_code();
		
		
	}

	@Override
	public List<Train_Station_Timings> getTrainStaionTimmingDataByStationId(Long Id) 
	{
		
		//TrainStationDao.getTrainDataByStationCode(Id);
		
		
		return TrainStationTimmingDao.getTrainDataByStationCode(Id);
				
				
		
	}

	@Override
	public List<Train_Station_Timings> getTrainStaionDataByTrainId(Long id) 
	{
		return TrainStationTimmingDao.getTrainDataByTrainCode(id);
				//TrainStationDao.getTrainDataByTrainCode(id);
		
	}

	
	

}
