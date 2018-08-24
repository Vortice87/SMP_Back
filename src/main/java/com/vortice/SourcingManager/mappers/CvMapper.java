package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.entities.Cv;

public class CvMapper {
	
	public static CvDTO ToDTO(Cv cv) {
		CvDTO newDTO = new CvDTO();
		newDTO.setCvId(cv.getCvId());
		newDTO.setRequestId(cv.getRequest().getId());
		newDTO.setCandidate(cv.getCandidate());
		newDTO.setCreatedDate(cv.getCreatedDate());
		newDTO.setFilePath(cv.getFilePath());
		newDTO.setComment(cv.getComment());
		newDTO.setStatus(cv.getStatus());
		newDTO.setFileName(cv.getFileName());
		newDTO.setFileType(cv.getFileType());
		return newDTO;
	}
	
	public static Cv DTOto(CvDTO dto) {
		Cv cv = new Cv();
		cv.setCvId(dto.getCvId());
		cv.setCandidate(dto.getCandidate());
		cv.setCreatedDate(dto.getCreatedDate());
		cv.setFilePath(dto.getFilePath());
		cv.setComment(dto.getComment());
		cv.setStatus(dto.getStatus());
		cv.setFileName(dto.getFileName());
		cv.setFileType(dto.getFileType());
		return cv;
	}

}
