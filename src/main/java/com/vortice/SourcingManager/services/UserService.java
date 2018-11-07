package com.vortice.SourcingManager.services;


import java.util.List;

import com.vortice.SourcingManager.dto.UserAccountDTO;

/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Login auth.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user account DTO
	 */
	public UserAccountDTO loginAuth(String username,String password);
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<UserAccountDTO> getAllUsers();
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean createUser(UserAccountDTO user);
	
	/**
	 * User exists.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean userExists(String username);
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteUser(int id);
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean updateUser(UserAccountDTO user);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user account DTO
	 */
	public UserAccountDTO findById(int id);

	
}
