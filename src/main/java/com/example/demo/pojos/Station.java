package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Station")
@Setter
@Getter
@ToString
public class Station 
{

	
	public Station()
	{
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Station_code;

	@Column(name = "Station_name", length = 30)
	private String stationName;
}
