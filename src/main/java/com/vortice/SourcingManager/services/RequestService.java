package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.entities.Request;

public interface RequestService {
	
	public Request getRequestById(Integer id);
	
	public boolean createRequest(Request request);

}
