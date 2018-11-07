package com.vortice.SourcingManager.services;

import java.util.List;

import com.vortice.SourcingManager.dto.AreaDTO;

/**
 * The Interface AreaService.
 */
public interface AreaService {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<AreaDTO> findAll();

}
