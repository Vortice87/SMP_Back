package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.entities.Candidate;

public interface CandidateService {
	
	boolean createCandidate(CandidateDTO candidateDTO);
	boolean findByCandidateName(String name);
	Candidate findByCandidateId(Integer id);

}
