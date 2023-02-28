package com.example.demo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.pojos.Station;


public interface PassengerDao extends JpaRepository<Station, Integer>
{
	public Station findByStationName(String name);
	
	

}
