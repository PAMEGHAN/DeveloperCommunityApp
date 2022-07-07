package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	
	public User findByUserIdAndPasswordAndRole(String id,String password,String role);

	public User findByUserIdAndPassword(int userId, String password);

	public void deleteById(int id);

	

}