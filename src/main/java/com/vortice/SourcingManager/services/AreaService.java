package com.vortice.SourcingManager.services;

import java.util.List;

import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.entities.Area;

/**
 * The Interface AreaService.
 */
public interface AreaService {
	
	/**
	 * Find by area id.
	 *
	 * @param id the id
	 * @return the area
	 */
	public AreaDTO findByAreaId(Integer id);
		
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<AreaDTO> findAll();
	
	/**
	 * Find allwith no relationship.
	 *
	 * @return the list
	 */
	public List<AreaDTO> findAllwithNoRelationship();
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteArea(Integer id);
	
	/**
	 * Creates the.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	public boolean createArea(AreaDTO dto);
		
	/**
	 * Area exists.
	 *
	 * @param areaName the area name
	 * @return true, if successful
	 */
	public boolean areaExists(String areaName);


}
