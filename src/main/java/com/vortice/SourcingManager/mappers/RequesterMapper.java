package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.RequesterDTO;
import com.vortice.SourcingManager.dto.UserAccountDTO;

/**
 * The Class RequesterMapper.
 */
public class RequesterMapper {
	
	/**
	 * User DT oto requester DTO.
	 *
	 * @param userDTO the user DTO
	 * @return the requester DTO
	 */
	public static RequesterDTO UserDTOtoRequesterDTO(UserAccountDTO userDTO) {
		
		RequesterDTO requester = new RequesterDTO();
		requester.setId(userDTO.getId());
		requester.setRequester(userDTO.getLastName() + ", " + userDTO.getName());
		return requester;
		
	}

}
