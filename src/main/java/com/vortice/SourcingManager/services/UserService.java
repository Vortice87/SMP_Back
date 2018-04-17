package com.vortice.SourcingManager.services;


import java.util.List;

import com.vortice.SourcingManager.entities.User;

public interface UserService {
	
	public User loginAuth(String username,String password);
	public List<User> getAllUsers();
	public boolean createUser(User user);
	public boolean userExists(String username);
	public boolean deleteUser(int id);
	public boolean updateUser(User user);
	
}
