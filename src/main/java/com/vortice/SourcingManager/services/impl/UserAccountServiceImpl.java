package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.vortice.SourcingManager.dao.UserDao;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.services.UserService;
import com.vortice.SourcingManager.services.dto.RequestDTO;
import com.vortice.SourcingManager.services.dto.UserAccountDTO;
import com.vortice.SourcingManager.services.mappers.UserAccountMapper;

@Service
public class UserAccountServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public UserAccountDTO loginAuth(String username, String password) {

		UserAccount user = dao.findByUsernameAndPassword(username, password);

		UserAccountDTO userDTO = UserAccountMapper.userAccountToDTO(user);
		if (userDTO != null) {
			return userDTO;
		}

		return null;
	}

	@Override
	public List<UserAccountDTO> getAllUsers() {

		List<UserAccount> userList = Lists.newArrayList(this.dao.findAll());
		List<UserAccountDTO> listDTO = new ArrayList<UserAccountDTO>();
		
		if(userList != null && userList.size() > 0) {
			for(UserAccount userAccount: userList) {
				listDTO.add(UserAccountMapper.userAccountToDTO(userAccount));
			}
			return listDTO;
		}
		return null;
	}

	@Override
	public boolean createUser(UserAccountDTO userDTO) {
		
		UserAccount user = new UserAccount();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setLastName(user.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setProfile(userDTO.getProfile());
		user.setRequests(new ArrayList<Request>());
		this.dao.save(user);
		boolean success = this.dao.exists(user.getId());

		return success;
	}

	@Override
	public boolean userExists(String username) {

		if (this.dao.findByUsername(username) != null) {
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteUser(int id) {
		this.dao.delete(id);
		boolean success = this.dao.exists(id);
		return success;
	}

	@Override
	public boolean updateUser(UserAccountDTO userDTO) {
		
		UserAccount user = new UserAccount();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setLastName(user.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setProfile(userDTO.getProfile());
		
		List<Request> list = new ArrayList<Request>();
		if(userDTO.getRequests() != null && userDTO.getRequests().size() > 0) {
			for(RequestDTO dto: userDTO.getRequests()) {
				Request r = new Request();
				r.setId(dto.getId());
				user.getRequests().add(r);
			}
		}
		
		
		this.dao.save(user);
		boolean success = this.dao.exists(user.getId());
		return success;
	}

	@Override
	public UserAccountDTO findById(Integer id) {
		
		UserAccount user = this.dao.findById(id);
		UserAccountDTO userDTO = UserAccountMapper.userAccountToDTO(user);
		return userDTO;
	}



}
