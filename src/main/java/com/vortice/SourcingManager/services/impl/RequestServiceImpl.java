package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RequestDao requestDao;
	

	@Override
	public Request getRequestById(Integer id) {
		return null;
	}

	@Override
	public boolean createRequest(Request request) {

		
		this.requestDao.save(request);
		boolean success = this.requestDao.exists(request.getId());
		return success;
	}
	

}
