package com.vortice.SourcingManager.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.CvDao;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.mappers.CvMapper;
import com.vortice.SourcingManager.services.CvService;

@Service
public class CvServiceImpl implements CvService{

	@Autowired
	private CvDao cvDao;
	
	@Autowired
	private RequestDao requestDao;
	
	@Override
	public boolean createCv(CvDTO cvDTO) {
		
		boolean success = true;
		Cv cv = CvMapper.DTOto(cvDTO);
		Request request = this.requestDao.findById(cvDTO.getRequestId());
		cv.setRequest(request);
		this.cvDao.save(cv);
		
		success = this.cvDao.exists(cv.getCvId());
		
		return success;
	}

	@Override
	public boolean findByCandidate(String name) {
		Cv cv = this.cvDao.findByCandidate(name);
		if(cv != null) {
			return true;
		} else {
			return false;
		}
		 
	}

}
