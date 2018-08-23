package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.dto.CvDTO;

public interface CvService {
	
	public boolean createCv(CvDTO cv);
	public boolean findByCandidate(String name);

}
