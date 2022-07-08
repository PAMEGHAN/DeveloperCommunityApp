package com.cg.service;

import java.util.List;

import com.cg.entity.User;

public interface IUserService {
	public String validateUser(int userId ,String password);
	public List<User> addUser(User user) ;
	public List<User> removeUser(int id);
	public String SignOut(String message);

}
