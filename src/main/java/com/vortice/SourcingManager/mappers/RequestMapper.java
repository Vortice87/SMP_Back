package com.vortice.SourcingManager.mappers;

import java.util.ArrayList;

import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.dto.ReqTechnicalDTO;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.entities.ReqTechnical;
import com.vortice.SourcingManager.entities.Request;

public class RequestMapper {

	public static RequestDTO ToDTO(Request request) {
		RequestDTO newDTO = new RequestDTO();
		newDTO.setId(request.getId());
		newDTO.setPetitionerId(request.getPetitioner().getId());
		newDTO.setCreationDate(request.getCreationDate());
		newDTO.setProfile(request.getProfile());
		newDTO.setnResources(request.getnResources());
		newDTO.setStartDate(request.getStartDate());
		newDTO.setDescTask(request.getDescTask());

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
		request.setCreationDate(dto.getCreationDate());
		request.setProfile(dto.getProfile());
		request.setnResources(dto.getnResources());
		request.setStartDate(dto.getStartDate());
		request.setDescTask(dto.getDescTask());

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
