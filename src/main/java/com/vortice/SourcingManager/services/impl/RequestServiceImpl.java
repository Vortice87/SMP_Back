package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.dao.UserDao;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.dto.RequestFilterDTO;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.mappers.RequestMapper;
import com.vortice.SourcingManager.services.RequestService;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestServiceImpl.
 */
@Service
public class RequestServiceImpl implements RequestService{
	
	/** The request dao. */
	@Autowired
	private RequestDao requestDao;
	
	/** The user dao. */
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.RequestService#getRequestById(java.lang.Integer)
	 */
	@Override
	public RequestDTO getRequestDTOById(Integer id) {
		
		Request request = this.requestDao.findById(id);
		RequestDTO dto = RequestMapper.ToDTOwithRelationships(request);
		
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.RequestService#createRequest(com.vortice.SourcingManager.dto.RequestDTO)
	 */
	@Override
	public boolean createRequest(RequestDTO requestDTO) {

		Request request = RequestMapper.DTOto(requestDTO);
		UserAccount petitioner = userDao.findById(requestDTO.getPetitioner().getId());
		request.setPetitioner(petitioner);
		this.requestDao.save(request);
		boolean success = this.requestDao.exists(request.getId());
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.RequestService#getAll()
	 */
	@Override
	public List<RequestDTO> getAll() {
		
		Pageable pageable = new PageRequest(1,5);
		Iterator<Request> iterator = requestDao.findAll(pageable).iterator();
		List<RequestDTO> requestDtoList = new ArrayList<RequestDTO>();
		
		while(iterator.hasNext()) {
			
			requestDtoList.add(RequestMapper.ToDTOwithoutRelationships(iterator.next()));
		}
		
		return requestDtoList;
	}
	
	@Override
	public List<RequestDTO> findRequests(RequestFilterDTO filtro) {
		
		// FindAllWithDescriptionQuery
		List<Request> requestList = null;

		if(filtro.getFechaDesde() == null && filtro.getFechaHasta() == null && filtro.getSolicitante() != 0) {
			requestList = requestDao.findRequestWithOutDateWithRequester("%"+filtro.getPerfil()+"%",filtro.getSolicitante(),"%"+filtro.getTecnologia()+"%" ,"%"+filtro.getDescripcion()+"%","%"+filtro.getEstado()+"%");
		} 
		if(filtro.getFechaDesde() == null && filtro.getFechaHasta() == null && filtro.getSolicitante() == 0) {
			requestList = requestDao.findRequestWithOutDateAndRequester("%"+filtro.getPerfil()+"%","%"+filtro.getTecnologia()+"%" ,"%"+filtro.getDescripcion()+"%","%"+filtro.getEstado()+"%");
		} 
		if (filtro.getFechaDesde() != null && filtro.getFechaHasta() != null && filtro.getSolicitante() != 0){
			requestList = requestDao.findRequestWithDateAndRequester("%"+filtro.getPerfil()+"%",filtro.getSolicitante(),"%"+filtro.getTecnologia()+"%" ,filtro.getFechaDesde(), filtro.getFechaHasta() ,"%"+filtro.getDescripcion()+"%","%"+filtro.getEstado()+"%");
		}
		if (filtro.getFechaDesde() != null && filtro.getFechaHasta() != null && filtro.getSolicitante() == 0){
			requestList = requestDao.findRequestWithDateWithOutRequester("%"+filtro.getPerfil()+"%","%"+filtro.getTecnologia()+"%" ,filtro.getFechaDesde(), filtro.getFechaHasta() ,"%"+filtro.getDescripcion()+"%","%"+filtro.getEstado()+"%");
		}

		List<RequestDTO> requestDtoList = new ArrayList<RequestDTO>();
		
		for(Request request: requestList) {
			requestDtoList.add(RequestMapper.ToDTOwithoutRelationships(request));
		}
		
		return requestDtoList;
	}
	
	

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.RequestService#changeRequestStatus(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean changeRequestStatus(Integer id, String status) {
		Request request = this.requestDao.findById(id);
		request.setStatus(status);
		if(this.requestDao.save(request) != null) {
			return true;			
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.RequestService#deleteRequest(java.lang.Integer)
	 */
	@Override
	public boolean deleteRequest(Integer id) {
		this.requestDao.delete(id);
		if(this.requestDao.exists(id)) {
			return false;
		}
		return true;
	}


}
