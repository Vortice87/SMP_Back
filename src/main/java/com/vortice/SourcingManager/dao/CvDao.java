package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Cv;

public interface CvDao extends CrudRepository<Cv, Integer> {
	
	public Cv findByCandidate(String name);
	public Cv findByCvId(Integer id);

}
