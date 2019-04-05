package com.vortice.SourcingManager.services;

import java.util.List;

import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.dto.RequestFilterDTO;

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
	 * Gets the request DTO by id with out relationships.
	 *
	 * @param id the id
	 * @return the request DTO by id with out relationships
	 */
	public RequestDTO getRequestDTOByIdWithOutRelationships(Integer id);
	
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
	 * Count by requests filter.
	 *
	 * @param filtro the filtro
	 * @return the integer
	 */
	public Integer countByRequestsFilter(RequestFilterDTO filtro);
	
	/**
	 * Find requests.
	 *
	 * @param filtro the filtro
	 * @return the list
	 */
	public List<RequestDTO> findRequests(RequestFilterDTO filtro);

}
