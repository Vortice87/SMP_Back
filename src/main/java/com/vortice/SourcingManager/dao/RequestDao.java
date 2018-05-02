package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Request;

public interface RequestDao extends CrudRepository<Request, Integer>{
	
	public Request findById(Integer id);
	public boolean createRequest(RequestDTO requestDTO);

}
