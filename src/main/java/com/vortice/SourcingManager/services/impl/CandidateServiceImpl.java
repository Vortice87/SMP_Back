package com.vortice.SourcingManager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vortice.SourcingManager.dao.CandidateDao;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.entities.Candidate;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.mappers.CandidateMapper;
import com.vortice.SourcingManager.services.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private RequestDao requestDao;

	@Override
	public boolean createCandidate(CandidateDTO candidateDTO) {

		boolean success = true;
		Candidate candidate = CandidateMapper.DTOto(candidateDTO);
		Request request = this.requestDao.findById(candidateDTO.getRequestId());
		candidate.setRequest(request);
		this.candidateDao.save(candidate);

		success = this.candidateDao.exists(candidate.getCandidateId());

		return success;
	}

	@Override
	public boolean findByCandidateName(String name) {
		Candidate candidate = this.candidateDao.findByName(name);
		if (candidate != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Candidate findByCandidateId(Integer id) {
		return this.candidateDao.findByCandidateId(id);
	}

}
