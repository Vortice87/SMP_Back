package com.vortice.SourcingManager.services;

import java.io.File;

import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.entities.Cv;

public interface CvService {
	
	public boolean createCandidate(CvDTO cv);
	public boolean findByCandidate(String name);
	public Cv findByCandidateById(Integer id);
	public String saveCv(String fileName, String fileType, String fileDate);
	public File getFileFromURL(String path);

}
