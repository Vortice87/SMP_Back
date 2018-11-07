package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Candidate;

/**
 * The Interface CandidateDao.
 */
public interface CandidateDao extends CrudRepository<Candidate, Integer> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the candidate
	 */
	public Candidate findByName(String name);
	
	/**
	 * Find by candidate id.
	 *
	 * @param id the id
	 * @return the candidate
	 */
	public Candidate findByCandidateId(Integer id);

}
