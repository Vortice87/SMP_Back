package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.ProviderDao;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.entities.Provider;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private ProviderDao providerDao;
	

	@Override
	public Request getRequestById(Integer id) {
		return null;
	}

	@Override
	public boolean createRequest(Request request) {

		List<Provider> providersAux = new ArrayList<Provider>();
		List<Request> requestAux = new ArrayList<Request>();
		requestAux.add(request);
		
	
		for (Provider provider : request.getProvider()) {
			Provider prov = this.providerDao.findById(provider.getId());
			providersAux.add(prov);
		}
		
		
		for (Provider provider : providersAux) {
			if(provider.getRequests() != null) {
				provider.getRequests().add(request);
			}else {
				provider.setRequests(requestAux);
			}
		}		
		request.setProvider(providersAux);
		
		this.requestDao.save(request);
		
		this.providerDao.save(providersAux);
		
		boolean success = this.requestDao.exists(request.getId());
		return success;
	}
	

}
