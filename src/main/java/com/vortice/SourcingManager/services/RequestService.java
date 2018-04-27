package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.services.dto.RequestDTO;

public interface RequestService {
	
	public RequestDTO getRequestById(Integer id);
	
	public boolean createRequest(RequestDTO request);

}
