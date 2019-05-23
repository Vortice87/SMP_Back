package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Area;
import com.vortice.SourcingManager.entities.UserAccount;

/**
 * The Interface AreaDao.
 */
public interface AreaDao extends CrudRepository<Area, Integer>{
	
	/**
	 * Find by nombre area.
	 *
	 * @param areaName the area name
	 * @return the area
	 */
	public Area findByNombreArea(String areaName);
	
	/**
	 * Find by area id.
	 *
	 * @param id the id
	 * @return the area
	 */
	public Area findByAreaId(Integer id);

}
