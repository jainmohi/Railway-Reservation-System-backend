package com.example.demo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.Train;


public interface AdminDao extends JpaRepository<Train, Long>
{
	public Train findByTrainName(String name);

}
