package com.vortice.SourcingManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.services.impl.RequestServiceImpl;

@Controller
@RequestMapping("/requests")
@CrossOrigin(origins = "*")
public class RequestController {
	
	@Autowired
	private RequestServiceImpl requestService;
	
	@PostMapping("/create")
	@ResponseBody
	public boolean createRequest(@RequestBody Request request) {
		
		boolean success = this.requestService.createRequest(request);
		return success;
		
	}

}
