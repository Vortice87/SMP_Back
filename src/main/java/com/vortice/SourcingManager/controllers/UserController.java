package com.vortice.SourcingManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vortice.SourcingManager.dto.UserAccountDTO;
import com.vortice.SourcingManager.services.impl.UserAccountServiceImpl;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	/** The user service. */
	@Autowired
	private UserAccountServiceImpl userService;
	
	/**
	 * Login auth.
	 *
	 * @param user the user
	 * @return the user account DTO
	 */
	@PostMapping("/authentication")
	@ResponseBody
	public UserAccountDTO loginAuth(@RequestBody UserAccountDTO user) {
		
		UserAccountDTO userAuthdto= userService.loginAuth(user.getUsername(), user.getPassword());

		return userAuthdto;

	}
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@PostMapping("/create")
	@ResponseBody
	public boolean createUser(@RequestBody UserAccountDTO user) {
		
		boolean success = userService.createUser(user);
		return success;
		
	}
	
	/**
	 * User exists.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	@GetMapping("/exists/{username:.+}")
	@ResponseBody
	public boolean userExists(@PathVariable String username) {
		
		if(userService.userExists(username)) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@GetMapping("/delete/{id}")
	@ResponseBody
	public boolean deleteUser(@PathVariable int id) {
		
		boolean success = userService.deleteUser(id);
		return success;
		
	}
	
	/**
	 * Modify user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@PostMapping("/update")
	@ResponseBody
	public boolean modifyUser(@RequestBody UserAccountDTO user) {
		
		boolean success = userService.updateUser(user);
		return success;
		
	}	
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping("/all")
	@ResponseBody
	public List<UserAccountDTO> getAllUsers(){
		
		List<UserAccountDTO> userList = userService.getAllUsers();
		return userList;
		
	}
	
	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 */
	@GetMapping("/user/{userId}")
	@ResponseBody
	public UserAccountDTO getUserById(@PathVariable("userId") int userId) {
		return this.userService.findById(userId);
	}

}
