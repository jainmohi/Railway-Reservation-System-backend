package com.example.demo.pojos;

import javax.persistence.CascadeType;
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
@Table(name = "TrainClass")

public class TrainClass 
{
	
	
	public TrainClass()
	{
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "class_Type", length = 10)
	private String classType;

	@Column(name = "Seat_Available")
	private int seatAvailable ;
	
	@Column(name = "Fair")
	private int Fair ;
	



	public TrainClass(String classType, int seatAvailable, int fair, long trainCode) {
		super();
		this.classType = classType;
		this.seatAvailable = seatAvailable;
		Fair = fair;
		this.trainCode = trainCode;
	}


	@Column(name="train_code")
	private long trainCode;
	
	

}
