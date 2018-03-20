package com.vortice.SourcingManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vortice.SourcingManager.entities.User;
import com.vortice.SourcingManager.services.UserService;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/authentication")
	@ResponseBody
	public User loginAuth(@RequestBody User user) {
		
		User userAuth = userService.loginAuth(user.getUsername(), user.getPassword());

		return userAuth;

	}
	
	@PostMapping("/create")
	@ResponseBody
	public boolean createUser(@RequestBody User user) {
		
		boolean success = userService.createUser(user);
		return success;
		
	}
	
	@GetMapping("/exists/{username:.+}")
	@ResponseBody
	public boolean userExists(@PathVariable String username) {
		
		if(userService.userExists(username)) {
			return true;
		}
		
		return false;
		
	}
	
	@GetMapping("/delete/{id}")
	@ResponseBody
	public boolean deleteUser(@PathVariable int id) {
		
		boolean success = userService.deleteUser(id);
		return success;
		
	}
	
	@PostMapping("/update")
	@ResponseBody
	public boolean modifyUser(@RequestBody User user) {
		
		boolean success = userService.updateUser(user);
		return success;
		
	}	
	
	@GetMapping("/all")
	@ResponseBody
	public List<User> getAllUsers(){
		
		List<User> userList = userService.getAllUsers();
		
		return userList;
		
	}

}
