package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DeveloperService ds;
	
	public String validateUser(int userId ,String password){
	  if( userRepository.findByUserIdAndPassword(userId, password) != null) {
		  return "Valid user";
	  }
      return "Invalid user,Please Register";
	}
	
	public List<User> addUser(User user) 
	  {
		userRepository.save(user);
		return userRepository.findAll();
		}
	
	public List<User> removeUser(int id)
	{
		userRepository.deleteById(id);
		return userRepository.findAll();
	}
	
	public String SignOut(String message) {
	   if(message.equals("SignOut")) {
		   return "signed out succesfully";
	   }
	   return "Still Signed in";
	}

	

	

	

	

}
