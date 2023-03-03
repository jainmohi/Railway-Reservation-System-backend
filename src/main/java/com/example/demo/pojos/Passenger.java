package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Passenger")
public class Passenger 
{
	public Passenger()
	{
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passengerId;

	@Column(name = "passengerName", length = 30)
	private String passengerName;
	
	@Column(name = "gender", length = 30)
	private String gender;
	
	@Column(name = "age")
	private int age;
	
	@ManyToOne 
	@JoinColumn(name = "PNRNO" ,nullable = false ) 
	private TicketReservation PNRNO;
	
	
	

}
