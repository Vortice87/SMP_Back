package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.entities.Configuration;

/**
 * The Interface ConfigurationService.
 */
public interface ConfigurationService {
	
	/**
	 * Find by config id.
	 *
	 * @param id the id
	 * @return the configuration
	 */
	public Configuration findByConfigId(Integer id);
	
	
	/**
	 * Save config.
	 *
	 * @param config the config
	 * @return true, if successful
	 */
	public boolean saveConfig(Configuration config);

}
