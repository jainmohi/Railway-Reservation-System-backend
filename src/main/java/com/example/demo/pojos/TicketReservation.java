package com.example.demo.pojos;

import java.time.LocalDate;

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
@Table(name = "TicketReservation")
public class TicketReservation 
{
	public TicketReservation()
	{
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PNRNO;

	@Column(name = "Date")
	private LocalDate Date;

	
	@ManyToOne 
	@JoinColumn(name = "UserId" ,nullable = false ) 
	private User userId;
	
	@ManyToOne 
	@JoinColumn(name = "TrainId" ,nullable = false ) 
	private Train trainId;
	

}
