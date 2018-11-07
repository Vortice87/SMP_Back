package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.entities.Candidate;

/**
 * The Interface CandidateService.
 */
public interface CandidateService {
	
	/**
	 * Find by candidate id.
	 *
	 * @param id the id
	 * @return the candidate DTO
	 */
	CandidateDTO findByCandidateId(Integer id);
	
	/**
	 * Update candidate.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	boolean updateCandidate(CandidateDTO dto);
	
	/**
	 * Creates the candidate.
	 *
	 * @param candidateDTO the candidate DTO
	 * @return true, if successful
	 */
	boolean createCandidate(CandidateDTO candidateDTO);
	
	/**
	 * Find by candidate name.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	boolean findByCandidateName(String name);
	
	/**
	 * Creates the comment.
	 *
	 * @param commentDTO the comment DTO
	 * @return true, if successful
	 */
	boolean createComment(CommentDTO commentDTO);
	
	/**
	 * Delete comment.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean deleteComment(Integer id);
	
}
