package com.vortice.SourcingManager.services.mappers;

import com.vortice.SourcingManager.entities.LanguagesRequest;
import com.vortice.SourcingManager.services.dto.LanguagesRequestDTO;

public class LanguagesRequestMapper {
	
	public static LanguagesRequestDTO languagesRequestToDTO(LanguagesRequest lr) {
		
		LanguagesRequestDTO newDTO = new LanguagesRequestDTO();
		newDTO.setLangId(lr.getLangId());
		newDTO.setLanguage(lr.getLanguage());
		newDTO.setLevel(lr.getLevel());
		newDTO.setReqdes(lr.getReqdes());
		newDTO.setRequestId(lr.getRequest().getId());
		return newDTO;
	}

}
