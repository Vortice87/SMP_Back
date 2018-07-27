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

import com.vortice.SourcingManager.dto.UserAccountDTO;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.mappers.UserAccountMapper;
import com.vortice.SourcingManager.services.impl.UserAccountServiceImpl;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserAccountServiceImpl userService;
	
	@PostMapping("/authentication")
	@ResponseBody
	public UserAccountDTO loginAuth(@RequestBody UserAccountDTO user) {
		
		UserAccountDTO userAuthdto= userService.loginAuth(user.getUsername(), user.getPassword());

		return userAuthdto;

	}
	
	@PostMapping("/create")
	@ResponseBody
	public boolean createUser(@RequestBody UserAccountDTO user) {
		
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
	public boolean modifyUser(@RequestBody UserAccountDTO user) {
		
		boolean success = userService.updateUser(user);
		return success;
		
	}	
	
	@GetMapping("/all")
	@ResponseBody
	public List<UserAccountDTO> getAllUsers(){
		
		List<UserAccountDTO> userList = userService.getAllUsers();
		return userList;
		
	}
	
	@GetMapping("/user/{userId}")
	@ResponseBody
	public UserAccountDTO getUserById(@PathVariable("userId") int userId) {
		return this.userService.findById(userId);
	}

}
