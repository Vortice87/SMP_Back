package com.vortice.SourcingManager.mappers;

import java.util.ArrayList;
import java.util.Base64;

import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.entities.Comment;
import com.vortice.SourcingManager.entities.Candidate;

/**
 * The Class CandidateMapper.
 */
public class CandidateMapper {
	
	/**
	 * To DTO.
	 *
	 * @param candidate the candidate
	 * @return the candidate DTO
	 */
	public static CandidateDTO ToDTO(Candidate candidate) {
		CandidateDTO newDTO = new CandidateDTO();
		newDTO.setCandidateId(candidate.getCandidateId());
		newDTO.setRequestId(candidate.getRequest().getId());
		newDTO.setName(candidate.getName());
		newDTO.setCreatedDate(candidate.getCreatedDate());
		if(candidate.getComments() != null && candidate.getComments().size() >0) {
			newDTO.setComments(new ArrayList<CommentDTO>());
			for(Comment comment: candidate.getComments()) {
				newDTO.getComments().add(CommentMapper.toDTO(comment));
			}
		}
		newDTO.setStatus(candidate.getStatus());
		newDTO.setDocumentBase64(Base64.getEncoder().encodeToString(candidate.getDocument()));
		return newDTO;
	}
	
	/**
	 * DT oto.
	 *
	 * @param dto the dto
	 * @return the candidate
	 */
	public static Candidate DTOto(CandidateDTO dto) {
		Candidate candidate = new Candidate();
		candidate.setCandidateId(dto.getCandidateId());
		candidate.setName(dto.getName());
		candidate.setCreatedDate(dto.getCreatedDate());
		if(dto.getComments() != null && dto.getComments().size() > 0) {
			candidate.setComments(new ArrayList<Comment>());
			for(CommentDTO commentDTO: dto.getComments()) {
				candidate.getComments().add(CommentMapper.DTOto(commentDTO) );
			}
		}
		candidate.setStatus(dto.getStatus());
		byte[] docDecoded = Base64.getDecoder().decode(dto.getDocumentBase64());
		candidate.setDocument(docDecoded);
		return candidate;
	}

}
