package com.vortice.SourcingManager.mappers;

import java.util.ArrayList;

import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.dto.LanguagesRequestDTO;
import com.vortice.SourcingManager.dto.ReqTechnicalDTO;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.entities.LanguagesRequest;
import com.vortice.SourcingManager.entities.ReqTechnical;
import com.vortice.SourcingManager.entities.Request;

public class RequestMapper {

	public static RequestDTO ToDTO(Request request) {
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

		if (request.getLanguages() != null && request.getLanguages().size() > 0) {
			newDTO.setLanguages(new ArrayList<LanguagesRequestDTO>());
			for (LanguagesRequest l : request.getLanguages()) {
				newDTO.getLanguages().add(LanguagesRequestMapper.ToDTO(l));
			}
		}
		if (request.getReqTechs() != null && request.getReqTechs().size() > 0) {
			newDTO.setReqTechs(new ArrayList<ReqTechnicalDTO>());
			for (ReqTechnical r : request.getReqTechs()) {
				newDTO.getReqTechs().add(ReqTechnicalMapper.ToDTO(r));
			}
		}
		if (request.getCvs() != null && request.getCvs().size() > 0) {
			newDTO.setCvs(new ArrayList<CvDTO>());
			for (Cv cv : request.getCvs()) {
				newDTO.getCvs().add(CvMapper.ToDTO(cv));
			}
		}

		return newDTO;
	}

	public static Request DTOto(RequestDTO dto) {

		Request request = new Request();
		request.setId(dto.getId());
		request.setPetitioner(null);
		request.setTitle(dto.getTitle());
		request.setReason(dto.getReason());
		request.setSubstitution(dto.getSubstitution());
		request.setSuggestedService(dto.getSuggestedService());
		request.setObservations(dto.getObservations());
		request.setLimitRate(dto.getLimitRate());
		request.setnResources(dto.getnResources());
		request.setProfile(dto.getProfile());
		request.setTechnology(dto.getTechnology());
		request.setStartDate(dto.getStartDate());
		request.setEndDate(dto.getEndDate());
		request.setArea(dto.getArea());
		request.setDepartment(dto.getDepartment());
		request.setManagement(dto.getManagement());
		request.setUnity(dto.getUnity());
		request.setDescTask(dto.getDescTask());
		request.setLocation(dto.getLocation());
		request.setFloor(dto.getFloor());
		request.setPlace(dto.getPlace());
		request.setTypeAccess(dto.getTypeAccess());
		request.setPlatEquip(dto.getPlatEquip());
		request.setContact(dto.getContact());

		if (dto.getLanguages() != null && dto.getLanguages().size() > 0) {
			request.setLanguages(new ArrayList<LanguagesRequest>());
			for (LanguagesRequestDTO lang : dto.getLanguages()) {
				request.getLanguages().add(LanguagesRequestMapper.DTOto(lang));
			}
		}
		if (dto.getReqTechs() != null && dto.getReqTechs().size() > 0) {
			request.setReqTechs(new ArrayList<ReqTechnical>());
			for (ReqTechnicalDTO r : dto.getReqTechs()) {
				request.getReqTechs().add(ReqTechnicalMapper.DTOto(r));
			}
		}
		if (dto.getCvs() != null && dto.getCvs().size() > 0) {
			request.setCvs(new ArrayList<Cv>());
			for (CvDTO cv : dto.getCvs()) {
				request.getCvs().add(CvMapper.DTOto(cv));
			}
		}

		return request;
	}

}
