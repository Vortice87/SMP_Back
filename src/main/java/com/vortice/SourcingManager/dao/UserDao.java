package com.vortice.SourcingManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
	
//	@Query(value="SELECT * FROM USER WHERE PROFILE != 'rrhh'", nativeQuery= true)
//	public List<UserAccount> findAllRequester();

}
