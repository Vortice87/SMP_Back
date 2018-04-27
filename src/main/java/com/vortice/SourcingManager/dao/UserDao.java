package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.UserAccount;

public interface UserDao extends CrudRepository<UserAccount, Integer>{
	
	public UserAccount findByUsernameAndPassword(String username,String password);
	public UserAccount findByUsername(String username);
	public UserAccount findById(Integer id);

}
