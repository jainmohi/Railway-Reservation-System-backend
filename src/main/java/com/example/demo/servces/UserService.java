package com.example.demo.servces;

import com.example.demo.pojos.User;

public interface UserService 
{
	public User userRegister(User user);
	
	public String updateUserPasswordByEmail(String password, String email);
	
	public User loginAuthentication(String password,String email);

	User checkEmail(String email);
	User restPass(User validuser, String password);
}
