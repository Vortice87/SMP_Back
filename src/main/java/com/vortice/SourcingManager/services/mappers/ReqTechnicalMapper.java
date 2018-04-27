package com.vortice.SourcingManager.services.mappers;

import com.vortice.SourcingManager.entities.ReqTechnical;
import com.vortice.SourcingManager.services.dto.ReqTechnicalDTO;

public class ReqTechnicalMapper {
	
	public static ReqTechnicalDTO reqTechnicalToDTO(ReqTechnical rt) {
		
		ReqTechnicalDTO newDTO = new ReqTechnicalDTO();
		newDTO.setTechId(rt.getTechId());
		newDTO.setTechscope(rt.getTechscope());
		newDTO.setOthers(rt.getOthers());
		newDTO.setExp(rt.getExp());
		newDTO.setReqdes(rt.getReqdes());
		newDTO.setRequestId(rt.getRequest().getId());
		return null;
		
	}

}
