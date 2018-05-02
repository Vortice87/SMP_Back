package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.LanguagesRequestDTO;
import com.vortice.SourcingManager.entities.LanguagesRequest;

public class LanguagesRequestMapper {
	
	public static LanguagesRequestDTO ToDTO(LanguagesRequest lr) {
		
		LanguagesRequestDTO newDTO = new LanguagesRequestDTO();
		newDTO.setLangId(lr.getLangId());
		newDTO.setLanguage(lr.getLanguage());
		newDTO.setLevel(lr.getLevel());
		newDTO.setReqdes(lr.getReqdes());
		newDTO.setRequestId(lr.getRequest().getId());
		
		return newDTO;
	}
	
	public static LanguagesRequest DTOto(LanguagesRequestDTO lang) {
		LanguagesRequest lr = new LanguagesRequest();
		lr.setLangId(lang.getLangId());
		lr.setLanguage(lang.getLanguage());
		lr.setLevel(lang.getLevel());
		lr.setReqdes(lang.getReqdes());
		
		return lr;
	}

}
