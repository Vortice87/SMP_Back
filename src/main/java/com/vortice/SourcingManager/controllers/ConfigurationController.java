package com.vortice.SourcingManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.services.impl.AreaServiceImpl;

@Controller
@RequestMapping("/configuration")
@CrossOrigin("*")
public class ConfigurationController {
	
	@Autowired
	private AreaServiceImpl areaService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<AreaDTO> findAll() {
		
		List<AreaDTO> list = this.areaService.findAll();
		return list;
	}

}
