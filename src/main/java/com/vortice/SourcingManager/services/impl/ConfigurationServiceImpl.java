package com.vortice.SourcingManager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.ConfigurationDao;
import com.vortice.SourcingManager.entities.Configuration;
import com.vortice.SourcingManager.services.ConfigurationService;

/**
 * The Class ConfigurationServiceImpl.
 */
@Service
public class ConfigurationServiceImpl implements ConfigurationService{
	
	/** The configuration. */
	@Autowired
	private ConfigurationDao configuration;

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.ConfigurationService#findByConfigId(java.lang.Integer)
	 */
	@Override
	public Configuration findByConfigId(Integer id) {
		return this.configuration.findByConfigId(id);
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.ConfigurationService#saveConfig(com.vortice.SourcingManager.entities.Configuration)
	 */
	@Override
	public boolean saveConfig(Configuration config) {
		if(this.configuration.save(config) != null) {
			return true;
		}
		return false;
	}

}
