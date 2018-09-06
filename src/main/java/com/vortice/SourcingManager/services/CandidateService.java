package com.vortice.SourcingManager.services;

import java.io.File;

import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.entities.Candidate;

public interface CandidateService {
	
	public boolean createCandidate(CandidateDTO candidateDTO);
	public boolean findByCandidateName(String name);
	public Candidate findByCandidateId(Integer id);
	public String saveCv(String fileName, String fileType, String fileDate);
	public File getFileFromURL(String path);

}
