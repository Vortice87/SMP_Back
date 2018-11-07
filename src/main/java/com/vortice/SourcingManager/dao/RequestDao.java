package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Request;

/**
 * The Interface RequestDao.
 */
public interface RequestDao extends CrudRepository<Request, Integer>{
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the request
	 */
	public Request findById(Integer id);
	
}
