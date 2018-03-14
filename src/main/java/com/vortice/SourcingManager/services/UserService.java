package com.vortice.SourcingManager.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.vortice.SourcingManager.dao.UserDao;
import com.vortice.SourcingManager.entities.User;
import com.vortice.SourcingManager.services.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

	@Autowired
	private UserDao dao;

	@Override
	public User loginAuth(String username, String password) {

		User user = dao.findByUsernameAndPassword(username, password);

		if (user != null) {
			return user;
		}

		return null;
	}
	
	public List<User> getAllUsers(){
		
		List<User> userList = Lists.newArrayList(this.dao.findAll());
		
		if(userList != null) {
			return userList;
		}
		return null;
		
	}

	public boolean createUser(User user) {
				
		this.dao.save(user);
		boolean success = this.dao.exists(user.getId());

		return success;
	}
	
	public boolean userExists(String username) {
		
		if(this.dao.findByUsername(username) != null) {
			return true;
		}
		return false;
		
	}
	
	public boolean deleteUser(int id) {
		this.dao.delete(id);
		boolean success = this.dao.exists(id);
		return success;
	}
	
	public boolean updateUser(User user) {
		this.dao.save(user);
		boolean success = this.dao.exists(user.getId());
		return success;
	}

}
