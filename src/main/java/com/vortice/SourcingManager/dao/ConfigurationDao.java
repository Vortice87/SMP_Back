package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;
import com.vortice.SourcingManager.entities.Configuration;

/**
 * The Interface ConfigurationDao.
 */
public interface ConfigurationDao extends CrudRepository<Configuration, Integer>{
	

	/**
	 * Find by config id.
	 *
	 * @param id the id
	 * @return the configuration
	 */
	public Configuration findByConfigId(Integer id);
	
}
