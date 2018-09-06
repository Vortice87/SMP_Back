package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Candidate;

public interface CandidateDao extends CrudRepository<Candidate, Integer> {
	
	public Candidate findByName(String name);
	public Candidate findByCandidateId(Integer id);

}
