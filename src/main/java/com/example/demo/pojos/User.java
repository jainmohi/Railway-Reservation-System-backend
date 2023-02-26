package com.example.demo.pojos;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "User")
@Setter
@Getter
@ToString
public class User 
{
	
	public User() 
	{
		
		
	}


	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int User_id;
	
	
	@Column(name = "First_Name", length = 20)
	private String firstName;
	
	@Column(name = "Last_name", length = 20)
	private String lastName;
	

	@Column(length = 100,name="Email", unique = true)
	private String email;
	
	@Column(name = "phone_no")
	private String phone;
	
	@Column(name = "password")
	private String password;

	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@NotNull(message = "Role must be supplied")
	private Role role ;
	
	
	
}
