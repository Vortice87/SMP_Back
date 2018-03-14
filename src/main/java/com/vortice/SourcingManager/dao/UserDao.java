package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.User;

public interface UserDao extends CrudRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username,String password);
	public User findByUsername(String username);

}
