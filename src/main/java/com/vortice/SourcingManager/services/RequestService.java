package com.vortice.SourcingManager.services;

import java.util.List;

import com.vortice.SourcingManager.dto.RequestDTO;

// TODO: Auto-generated Javadoc
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
	public RequestDTO getRequestDTOById(Integer id);
	
	/**
	 * Change request status.
	 *
	 * @param id the id
	 * @param status the status
	 * @return true, if successful
	 */
	public boolean changeRequestStatus(Integer id, String status);
	
	/**
	 * Creates the request.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean createRequest(RequestDTO request);
	
	/**
	 * Delete request.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteRequest(Integer id);
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<RequestDTO> getAll();

}
