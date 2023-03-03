package com.example.demo.servces;

import java.util.List;

import com.example.demo.pojos.Train;
import com.example.demo.pojos.TrainClass;
import com.example.demo.pojos.User;

public interface UserService 
{
	public User userRegister(User user);
	
	public String updateUserPasswordByEmail(String password, String email);
	
	public User loginAuthentication(String password,String email);

	User checkEmail(String email);
	User restPass(User validuser, String password);

	public List<Train> getTrainsByStations(String string, String string2);

}
