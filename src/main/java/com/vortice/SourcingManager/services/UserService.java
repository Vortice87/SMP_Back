package com.vortice.SourcingManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void createUser(User user) {
		this.dao.save(user);
	}
	
	public void deleteUser(User user) {
		this.dao.delete(user.getId());
	}

}
