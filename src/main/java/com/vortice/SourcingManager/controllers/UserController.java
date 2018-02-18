package com.vortice.SourcingManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		
		if(userAuth != null) {
			return userAuth;
		}
		
		return null;
	}

}
