package com.vortice.SourcingManager.services.mappers;

import java.util.ArrayList;

import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.services.dto.RequestDTO;
import com.vortice.SourcingManager.services.dto.UserAccountDTO;

public class UserAccountMapper {
	
	public static UserAccountDTO userAccountToDTO(UserAccount userAccount) {
		UserAccountDTO newDTO = new UserAccountDTO();
		newDTO.setId(userAccount.getId());
		newDTO.setName(userAccount.getName());
		newDTO.setLastName(userAccount.getLastName());
		newDTO.setUsername(userAccount.getUsername());
		newDTO.setPassword(userAccount.getPassword());
		newDTO.setProfile(userAccount.getProfile());
		if(userAccount.getRequests() != null && userAccount.getRequests().size() > 0) {
			newDTO.setRequests(new ArrayList<RequestDTO>());
			for(Request r: userAccount.getRequests())
			{
				newDTO.getRequests().add(RequestMapper.requestToDTO(r));
			}
		}
		return newDTO;
	}

}
