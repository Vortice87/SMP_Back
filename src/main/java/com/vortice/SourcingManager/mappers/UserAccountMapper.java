package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.UserAccountDTO;
import com.vortice.SourcingManager.entities.UserAccount;

/**
 * The Class UserAccountMapper.
 */
public class UserAccountMapper {

	/**
	 * To DTO.
	 *
	 * @param userAccount the user account
	 * @return the user account DTO
	 */
	public static UserAccountDTO ToDTO(UserAccount userAccount) {

		UserAccountDTO newDTO = new UserAccountDTO();
		newDTO.setId(userAccount.getId());
		newDTO.setName(userAccount.getName());
		newDTO.setLastName(userAccount.getLastName());
		newDTO.setUsername(userAccount.getUsername());
		newDTO.setProfile(userAccount.getProfile());
		return newDTO;
	}

	/**
	 * DT oto.
	 *
	 * @param dto the dto
	 * @return the user account
	 */
	public static UserAccount DTOto(UserAccountDTO dto) {

		UserAccount user = new UserAccount();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setLastName(dto.getLastName());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setProfile(dto.getProfile());
		return user;
	}

}
