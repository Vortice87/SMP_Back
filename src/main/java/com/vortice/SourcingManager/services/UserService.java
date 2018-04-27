package com.vortice.SourcingManager.services;


import java.util.List;

import com.vortice.SourcingManager.services.dto.UserAccountDTO;

public interface UserService {
	
	public UserAccountDTO loginAuth(String username,String password);
	public List<UserAccountDTO> getAllUsers();
	public boolean createUser(UserAccountDTO user);
	public boolean userExists(String username);
	public boolean deleteUser(int id);
	public boolean updateUser(UserAccountDTO user);
	public UserAccountDTO findById(Integer id);

	
}
