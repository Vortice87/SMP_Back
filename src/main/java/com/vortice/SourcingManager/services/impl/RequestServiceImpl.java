package com.vortice.SourcingManager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RequestDao dao;

	@Override
	public Request getRequestById(Integer id) {
		return null;
	}

	@Override
	public boolean createRequest(Request request) {

		this.dao.save(request);
		boolean success = this.dao.exists(request.getId());
		return success;
	}
	

}
