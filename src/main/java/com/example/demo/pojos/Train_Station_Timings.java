package com.example.demo.pojos;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Train_Station_Timings")
@Setter
@Getter
@ToString
public class Train_Station_Timings
{
	
	
	public Train_Station_Timings ()
	{
		System.out.println("");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "Arrival_time", length = 5)
	private String arrivalTime;

	@Column(name = "Departure_time", length = 5)
	private String departureTime ;

	@Column(name = "Distance", length = 20)
	private int distance ;
	
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn(name="train_code",nullable=false)
	private Train train;
	
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn(name="station_code",nullable=false)
	private Station station;

}
