package com.vortice.SourcingManager.mappers;

import java.util.ArrayList;

import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.dto.UserAccountDTO;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.entities.UserAccount;

public class UserAccountMapper {

	public static UserAccountDTO ToDTO(UserAccount userAccount) {

		UserAccountDTO newDTO = new UserAccountDTO();
		newDTO.setId(userAccount.getId());
		newDTO.setName(userAccount.getName());
		newDTO.setLastName(userAccount.getLastName());
		newDTO.setUsername(userAccount.getUsername());
		newDTO.setPassword(userAccount.getPassword());
		newDTO.setProfile(userAccount.getProfile());
		if (userAccount.getRequests() != null && userAccount.getRequests().size() > 0) {
			newDTO.setRequests(new ArrayList<RequestDTO>());
			for (Request r : userAccount.getRequests()) {
				newDTO.getRequests().add(RequestMapper.ToDTO(r));
			}
		}
		return newDTO;
	}

	public static UserAccount DTOto(UserAccountDTO dto) {

		UserAccount user = new UserAccount();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setLastName(dto.getLastName());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setProfile(dto.getProfile());
		if(dto.getRequests() != null && dto.getRequests().size() >0) {
			user.setRequests(new ArrayList<Request>());
			for(RequestDTO r: dto.getRequests()) {
				user.getRequests().add(RequestMapper.DTOto(r));
			}
		}

		return user;
	}

}
