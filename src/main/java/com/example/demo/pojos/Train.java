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
	
	@Column(name = "Start_Station", length = 20)
	private String startStation ;
	
<<<<<<< HEAD
	@Column(name = "End_Station", length = 20)
	private String endStation;
=======
	@Column(name = "Start_Staion", length = 20)
	private String startStation ;
	
	@Column(name = "End_Staion", length = 20)
	private String endStation ;
>>>>>>> 0f917cce68bc559b95523f0d4844602d5e4f4259
	
	@Column(name = "Distance",nullable=true)
	private int distance;
	
	
	
	
}
