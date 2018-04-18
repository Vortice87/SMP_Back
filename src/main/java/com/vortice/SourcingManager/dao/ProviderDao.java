package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Provider;

public interface ProviderDao extends CrudRepository<Provider, Integer>{
	
	public Provider findById(Integer id);
}
