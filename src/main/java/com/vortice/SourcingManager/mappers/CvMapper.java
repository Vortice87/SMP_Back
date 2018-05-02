package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.entities.Cv;

public class CvMapper {
	
	public static CvDTO ToDTO(Cv cv) {
		CvDTO newDTO = new CvDTO();
		newDTO.setCvId(cv.getCvId());
		newDTO.setDni(cv.getDni());
		newDTO.setName(cv.getName());
		newDTO.setRequestId(cv.getRequest().getId());
		
		return newDTO;
	}
	
	public static Cv DTOto(CvDTO dto) {
		Cv cv = new Cv();
		cv.setCvId(dto.getCvId());
		cv.setDni(dto.getDni());
		cv.setName(dto.getName());
		return cv;
	}

}
