package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.ReqTechnicalDTO;
import com.vortice.SourcingManager.entities.ReqTechnical;

/**
 * The Class ReqTechnicalMapper.
 */
public class ReqTechnicalMapper {
	
	/**
	 * To DTO.
	 *
	 * @param rt the rt
	 * @return the req technical DTO
	 */
	public static ReqTechnicalDTO ToDTO(ReqTechnical rt) {
		
		ReqTechnicalDTO newDTO = new ReqTechnicalDTO();
		newDTO.setTechId(rt.getTechId());
		newDTO.setArea(rt.getArea());
		newDTO.setTechscope(rt.getTechscope());
		newDTO.setExp(rt.getExp());
		newDTO.setReqdes(rt.getReqdes());
		newDTO.setRequestId(rt.getRequest().getId());
		
		return newDTO;
	}
	
	/**
	 * DT oto.
	 *
	 * @param dto the dto
	 * @return the req technical
	 */
	public static ReqTechnical DTOto(ReqTechnicalDTO dto) {
		
		ReqTechnical rt = new ReqTechnical();
		rt.setTechId(dto.getRequestId());
		rt.setArea(dto.getArea());
		rt.setTechscope(dto.getTechscope());
		rt.setExp(dto.getExp());
		rt.setReqdes(dto.getReqdes());
		
		return rt;
	}

}
