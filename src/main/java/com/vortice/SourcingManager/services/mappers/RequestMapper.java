package com.vortice.SourcingManager.services.mappers;

import java.util.ArrayList;
import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.entities.LanguagesRequest;
import com.vortice.SourcingManager.entities.ReqTechnical;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.services.dto.CvDTO;
import com.vortice.SourcingManager.services.dto.LanguagesRequestDTO;
import com.vortice.SourcingManager.services.dto.ReqTechnicalDTO;
import com.vortice.SourcingManager.services.dto.RequestDTO;

public class RequestMapper {
	
	public static RequestDTO requestToDTO(Request request) {
		RequestDTO newDTO = new RequestDTO();
		newDTO.setId(request.getId());
		newDTO.setPetitionerId(request.getPetitioner().getId());
		newDTO.setTitle(request.getTitle());
		newDTO.setReason(request.getReason());
		newDTO.setSubstitution(request.getSubstitution());
		newDTO.setSuggestedService(request.getSuggestedService());
		newDTO.setObservations(request.getObservations());
		newDTO.setLimitRate(request.getLimitRate());
		newDTO.setnResources(request.getnResources());
		newDTO.setProfile(request.getProfile());
		newDTO.setTechnology(request.getTechnology());
		newDTO.setStartDate(request.getStartDate());
		newDTO.setEndDate(request.getEndDate());
		newDTO.setArea(request.getArea());
		newDTO.setDepartment(request.getDepartment());
		newDTO.setManagement(request.getManagement());
		newDTO.setUnity(request.getUnity());
		newDTO.setDescTask(request.getDescTask());
		newDTO.setLocation(request.getLocation());
		newDTO.setFloor(request.getFloor());
		newDTO.setPlace(request.getPlace());
		newDTO.setTypeAccess(request.getTypeAccess());
		newDTO.setPlatEquip(request.getPlatEquip());
		newDTO.setContact(request.getContact());
		
		if(request.getLanguages() != null && request.getLanguages().size() > 0) 
		{
			newDTO.setLanguages(new ArrayList<LanguagesRequestDTO>());
			for(LanguagesRequest l : request.getLanguages())
			{
				newDTO.getLanguages().add(LanguagesRequestMapper.languagesRequestToDTO(l));
			}
		}
		if(request.getReqTechs() != null && request.getReqTechs().size() > 0)
		{
			newDTO.setReqTechs(new ArrayList<ReqTechnicalDTO>());
			for(ReqTechnical r: request.getReqTechs())
			{
				newDTO.getReqTechs().add(ReqTechnicalMapper.reqTechnicalToDTO(r));
			}
		}
		if(request.getCvs() != null && request.getCvs().size() > 0)
		{
			newDTO.setCvs(new ArrayList<CvDTO>());
			for(Cv cv: request.getCvs())
			{
				newDTO.getCvs().add(CvMapper.cvToDTO(cv));
			}
		}
		
		return newDTO;
	}

}
