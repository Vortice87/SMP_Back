package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.vortice.SourcingManager.dao.UserDao;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.dto.UserAccountDTO;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.mappers.UserAccountMapper;
import com.vortice.SourcingManager.services.UserService;

/**
 * The Class UserAccountServiceImpl.
 */
@Service
public class UserAccountServiceImpl implements UserService {

	/** The dao. */
	@Autowired
	private UserDao dao;

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#loginAuth(java.lang.String, java.lang.String)
	 */
	@Override
	public UserAccountDTO loginAuth(String username, String password) {

		UserAccount user = dao.findByUsernameAndPassword(username, password);

		if (user != null) {
			UserAccountDTO userDTO = UserAccountMapper.ToDTO(user);

			return userDTO;
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#getAllUsers()
	 */
	@Override
	public List<UserAccountDTO> getAllUsers() {

		List<UserAccount> userList = Lists.newArrayList(this.dao.findAll());
		List<UserAccountDTO> listDTO = new ArrayList<>();
		
		if(userList != null && userList.size() > 0) {
			for(UserAccount userAccount: userList) {
				listDTO.add(UserAccountMapper.ToDTO(userAccount));
			}
			return listDTO;
		}
		return listDTO;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#createUser(com.vortice.SourcingManager.dto.UserAccountDTO)
	 */
	@Override
	public boolean createUser(UserAccountDTO userDTO) {
		
		UserAccount user = UserAccountMapper.DTOto(userDTO);
		this.dao.save(user);
		boolean success = this.dao.exists(user.getId());

		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#userExists(java.lang.String)
	 */
	@Override
	public boolean userExists(String username) {

		if (this.dao.findByUsername(username) != null) {
			return true;
		}
		return false;

	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(int id) {
		this.dao.delete(id);
		boolean success = this.dao.exists(id);
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#updateUser(com.vortice.SourcingManager.dto.UserAccountDTO)
	 */
	@Override
	public boolean updateUser(UserAccountDTO userDTO) {
		
		UserAccount user = UserAccountMapper.DTOto(userDTO);		
		this.dao.save(user);
		boolean success = this.dao.exists(user.getId());
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.UserService#findById(int)
	 */
	@Override
	public UserAccountDTO findById(int id) {
		
		UserAccount user = this.dao.findById(id);
		UserAccountDTO userDTO = UserAccountMapper.ToDTO(user);
		return userDTO;
	}



}
