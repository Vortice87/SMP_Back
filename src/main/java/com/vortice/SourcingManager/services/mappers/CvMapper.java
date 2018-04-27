package com.vortice.SourcingManager.services.mappers;

import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.services.dto.CvDTO;

public class CvMapper {
	
	public static CvDTO cvToDTO(Cv cv) {
		CvDTO newDTO = new CvDTO();
		newDTO.setCvId(cv.getCvId());
		newDTO.setDni(cv.getDni());
		newDTO.setName(cv.getName());
		newDTO.setRequestId(cv.getRequest().getId());
		
		return newDTO;
	}

}
