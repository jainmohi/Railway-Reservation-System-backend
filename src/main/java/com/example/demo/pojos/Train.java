package com.example.demo.pojos;

import java.time.LocalTime;

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
@Table(name = "Train")
@Setter
@Getter
@ToString
public class Train 
{
	public Train ()
	{
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Train_code;

	@Column(name = "Train_name", length = 20)
	private String trainName;

	@Column(name = "Start_time", length = 20)
private String startTime ;

	@Column(name = "End_time", length = 20)
private String endTime ;
	
	
}
