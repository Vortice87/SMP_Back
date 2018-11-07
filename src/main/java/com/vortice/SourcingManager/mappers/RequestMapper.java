package com.vortice.SourcingManager.mappers;

import java.util.ArrayList;

import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.dto.ReqTechnicalDTO;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Candidate;
import com.vortice.SourcingManager.entities.ReqTechnical;
import com.vortice.SourcingManager.entities.Request;

/**
 * The Class RequestMapper.
 */
public class RequestMapper {

	/**
	 * To DT owith relationships.
	 *
	 * @param request the request
	 * @return the request DTO
	 */
	public static RequestDTO ToDTOwithRelationships(Request request) {
		RequestDTO newDTO = new RequestDTO();
		newDTO.setId(request.getId());
		newDTO.setPetitioner(UserAccountMapper.ToDTO(request.getPetitioner()));
		newDTO.setCreationDate(request.getCreationDate());
		newDTO.setProfile(request.getProfile());
		newDTO.setNResources(request.getNResources());
		newDTO.setStartDate(request.getStartDate());
		newDTO.setDescTask(request.getDescTask());

		if (request.getReqTechs() != null && request.getReqTechs().size() > 0) {
			newDTO.setReqTechs(new ArrayList<ReqTechnicalDTO>());
			for (ReqTechnical r : request.getReqTechs()) {
				newDTO.getReqTechs().add(ReqTechnicalMapper.ToDTO(r));
			}
		}
		
		if (request.getCandidates() != null && request.getCandidates().size() > 0) {
			newDTO.setCandidates(new ArrayList<CandidateDTO>());
			for (Candidate candidate : request.getCandidates()) {
				newDTO.getCandidates().add(CandidateMapper.ToDTO(candidate));
			}
		}

		return newDTO;
	}

	/**
	 * To DT owithout relationships.
	 *
	 * @param request the request
	 * @return the request DTO
	 */
	public static RequestDTO ToDTOwithoutRelationships(Request request) {
		RequestDTO newDTO = new RequestDTO();
		newDTO.setId(request.getId());
		newDTO.setPetitioner(UserAccountMapper.ToDTO(request.getPetitioner()));
		newDTO.setCreationDate(request.getCreationDate());
		newDTO.setProfile(request.getProfile());
		newDTO.setNResources(request.getNResources());
		newDTO.setStartDate(request.getStartDate());
		newDTO.setDescTask(request.getDescTask());
		return newDTO;
	}
	
	/**
	 * DT oto.
	 *
	 * @param dto the dto
	 * @return the request
	 */
	public static Request DTOto(RequestDTO dto) {

		Request request = new Request();
		request.setId(dto.getId());
		request.setPetitioner(null);
		request.setCreationDate(dto.getCreationDate());
		request.setProfile(dto.getProfile());
		request.setNResources(dto.getNResources());
		request.setStartDate(dto.getStartDate());
		request.setDescTask(dto.getDescTask());

		if (dto.getReqTechs() != null && dto.getReqTechs().size() > 0) {
			request.setReqTechs(new ArrayList<ReqTechnical>());
			for (ReqTechnicalDTO r : dto.getReqTechs()) {
				request.getReqTechs().add(ReqTechnicalMapper.DTOto(r));
			}
		}
		if (dto.getCandidates() != null && dto.getCandidates().size() > 0) {
			request.setCandidates(new ArrayList<Candidate>());
			for (CandidateDTO candidate : dto.getCandidates()) {
				request.getCandidates().add(CandidateMapper.DTOto(candidate));
			}
		}

		return request;
	}

}
