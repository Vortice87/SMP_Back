package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.ReqTechnicalDTO;
import com.vortice.SourcingManager.entities.ReqTechnical;

public class ReqTechnicalMapper {
	
	public static ReqTechnicalDTO ToDTO(ReqTechnical rt) {
		
		ReqTechnicalDTO newDTO = new ReqTechnicalDTO();
		newDTO.setTechId(rt.getTechId());
		newDTO.setTechscope(rt.getTechscope());
		newDTO.setExp(rt.getExp());
		newDTO.setReqdes(rt.getReqdes());
		newDTO.setRequestId(rt.getRequest().getId());
		
		return newDTO;
	}
	
	public static ReqTechnical DTOto(ReqTechnicalDTO dto) {
		
		ReqTechnical rt = new ReqTechnical();
		rt.setTechId(dto.getRequestId());
		rt.setTechscope(dto.getTechscope());
		rt.setExp(dto.getExp());
		rt.setReqdes(dto.getReqdes());
		
		return rt;
	}

}
