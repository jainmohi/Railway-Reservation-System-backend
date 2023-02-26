package com.example.demo.servces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.daos.*;
import com.example.demo.pojos.*;

@Transactional
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userdao;

public User userRegister(User user){
		
		return userdao.save(user);
	}

@Override
public String updateUserPasswordByEmail(String password, String email) {
	
	userdao.updateUserPasswordByEmail(password, email);
	return "Password updated successfully";
	
	
}

@Override
public User loginAuthentication(String password, String email) {
	
	return userdao.findByEmailAndPassword( email, password);
}


@Override
public User checkEmail(String email) {
	User validuser=userdao.findByEmail(email);
	return validuser;
}


@Override
public User restPass(User validuser, String password) {
	System.out.println("inside userservice");
	System.out.println(validuser);
	validuser.setPassword(password);
	User persistentUser=userdao.save(validuser);
	return persistentUser;
}

	
}
