package com.vortice.SourcingManager.services;

import java.util.List;

import com.vortice.SourcingManager.dto.RequestDTO;

public interface RequestService {
	
	public RequestDTO getRequestById(Integer id);
	
	public boolean createRequest(RequestDTO request);
	
	public List<RequestDTO> getAll();

}
