package com.vortice.SourcingManager.services;

import java.util.List;

import com.vortice.SourcingManager.dto.RequestDTO;

/**
 * The Interface RequestService.
 */
public interface RequestService {
	
	/**
	 * Gets the request by id.
	 *
	 * @param id the id
	 * @return the request by id
	 */
	public RequestDTO getRequestById(Integer id);
	
	/**
	 * Creates the request.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean createRequest(RequestDTO request);
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<RequestDTO> getAll();

}
