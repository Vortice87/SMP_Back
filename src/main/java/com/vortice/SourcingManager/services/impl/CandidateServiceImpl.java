package com.vortice.SourcingManager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vortice.SourcingManager.dao.CandidateDao;
import com.vortice.SourcingManager.dao.CommentDao;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.entities.Candidate;
import com.vortice.SourcingManager.entities.Comment;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.mappers.CandidateMapper;
import com.vortice.SourcingManager.mappers.CommentMapper;
import com.vortice.SourcingManager.services.CandidateService;

/**
 * The Class CandidateServiceImpl.
 */
@Service
public class CandidateServiceImpl implements CandidateService {

	/** The candidate dao. */
	@Autowired
	private CandidateDao candidateDao;

	/** The request dao. */
	@Autowired
	private RequestDao requestDao;

	/** The comment dao. */
	@Autowired
	private CommentDao commentDao;
	
	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.CandidateService#createCandidate(com.vortice.SourcingManager.dto.CandidateDTO)
	 */
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

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.CandidateService#updateCandidate(com.vortice.SourcingManager.dto.CandidateDTO)
	 */
	@Override
	public boolean updateCandidate(CandidateDTO dto) {
		Candidate candidate = CandidateMapper.DTOto(dto);
		Request request = this.requestDao.findById(dto.getRequestId());
		if(candidate.getComments() != null) {
		for(Comment comment : candidate.getComments()) {
			comment.setCandidate(candidate);
		}
		}
		candidate.setRequest(request);
		if(this.candidateDao.save(candidate) != null) {
			return true;
		}
		return false;
	}	

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.CandidateService#findByCandidateName(java.lang.String)
	 */
	@Override
	public boolean findByCandidateName(String name) {
		Candidate candidate = this.candidateDao.findByName(name);
		if (candidate != null) {
			return true;
		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.CandidateService#findByCandidateId(java.lang.Integer)
	 */
	@Override
	public CandidateDTO findByCandidateId(Integer id) {
		return CandidateMapper.ToDTO(this.candidateDao.findByCandidateId(id));
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.CandidateService#createComment(com.vortice.SourcingManager.dto.CommentDTO)
	 */
	@Override
	public boolean createComment(CommentDTO commentDTO) {
		boolean success = true;
		Comment comment = CommentMapper.DTOto(commentDTO);
		Candidate candidate = this.candidateDao.findByCandidateId(commentDTO.getCandidateId());
		comment.setCandidate(candidate);
		this.commentDao.save(comment);
		success = this.commentDao.exists(comment.getCommentId());
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.CandidateService#deleteComment(java.lang.Integer)
	 */
	@Override
	public boolean deleteComment(Integer id) {
		if(this.commentDao.exists(id)) {
			this.commentDao.delete(id);
			return true;
		} 
		return false;
	}

}
