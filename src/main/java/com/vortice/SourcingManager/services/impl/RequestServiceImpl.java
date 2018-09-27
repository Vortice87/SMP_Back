package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.dao.UserDao;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.mappers.RequestMapper;
import com.vortice.SourcingManager.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public RequestDTO getRequestById(Integer id) {
		
		Request request = this.requestDao.findById(id);
		RequestDTO dto = RequestMapper.ToDTOwithRelationships(request);
		
		return dto;
	}

	@Override
	public boolean createRequest(RequestDTO requestDTO) {

		Request request = RequestMapper.DTOto(requestDTO);
		UserAccount petitioner = userDao.findById(requestDTO.getPetitioner().getId());
		request.setPetitioner(petitioner);
		this.requestDao.save(request);
		boolean success = this.requestDao.exists(request.getId());
		return success;
	}

	@Override
	public List<RequestDTO> getAll() {
		
		Iterator<Request> iterator = requestDao.findAll().iterator();
		List<RequestDTO> requestDtoList = new ArrayList<RequestDTO>();
		
		while(iterator.hasNext()) {
			
			requestDtoList.add(RequestMapper.ToDTOwithoutRelationships(iterator.next()));
		}
		
		return requestDtoList;
	}
	

}
