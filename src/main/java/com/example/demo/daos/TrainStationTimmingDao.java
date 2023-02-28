package com.example.demo.daos;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Train_Station_Timings;

@Repository
@Transactional
public class TrainStationTimmingDao 
{
	@Autowired
	private EntityManager manager;
	
	public List<Train_Station_Timings> getTrainDataByTrainCode(long TrainId) {
		String jpql = "select p from Train_Station_Timings p where p.train.Train_code=:id";
		return manager.createQuery(jpql, Train_Station_Timings.class).setParameter("id", TrainId).getResultList();
	}
	
	public List<Train_Station_Timings> getTrainDataByStationCode(long StationId) {
		String jpql = "select p from Train_Station_Timings p where p.station.Station_code=:id";
		return manager.createQuery(jpql, Train_Station_Timings.class).setParameter("id", StationId).getResultList();
	}

}
