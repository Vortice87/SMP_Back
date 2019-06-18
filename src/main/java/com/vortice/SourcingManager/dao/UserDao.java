package com.vortice.SourcingManager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.UserAccount;

/**
 * The Interface UserDao.
 */
public interface UserDao extends CrudRepository<UserAccount, Integer>{
	
	/**
	 * Find by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user account
	 */
	public UserAccount findByUsernameAndPassword(String username,String password);
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user account
	 */
	public UserAccount findByUsername(String username);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user account
	 */
	public UserAccount findById(Integer id);
	

	/**
	 * Find by profile.
	 *
	 * @param profile the profile
	 * @return the user account
	 */
	public List<UserAccount> findByProfile(String profile);
}
