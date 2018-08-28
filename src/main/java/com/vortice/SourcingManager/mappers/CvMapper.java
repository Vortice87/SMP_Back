package com.vortice.SourcingManager.mappers;

import java.util.ArrayList;

import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.entities.Comment;
import com.vortice.SourcingManager.entities.Cv;

public class CvMapper {
	
	public static CvDTO ToDTO(Cv cv) {
		CvDTO newDTO = new CvDTO();
		newDTO.setCvId(cv.getCvId());
		newDTO.setRequestId(cv.getRequest().getId());
		newDTO.setCandidate(cv.getCandidate());
		newDTO.setCreatedDate(cv.getCreatedDate());
		newDTO.setFilePath(cv.getFilePath());
		if(cv.getComments() != null && cv.getComments().size() >0) {
			newDTO.setComments(new ArrayList<CommentDTO>());
			for(Comment comment: cv.getComments()) {
				newDTO.getComments().add(CommentMapper.toDTO(comment));
			}
		}
		newDTO.setStatus(cv.getStatus());
		newDTO.setFileName(cv.getFileName());
		newDTO.setFileType(cv.getFileType());
		return newDTO;
	}
	
	public static Cv DTOto(CvDTO dto) {
		Cv cv = new Cv();
		cv.setCvId(dto.getCvId());
		cv.setCandidate(dto.getCandidate());
		cv.setCreatedDate(dto.getCreatedDate());
		cv.setFilePath(dto.getFilePath());
		if(dto.getComments() != null && dto.getComments().size() > 0) {
			cv.setComments(new ArrayList<Comment>());
			for(CommentDTO commentDTO: dto.getComments()) {
				cv.getComments().add(CommentMapper.DTOto(commentDTO) );
			}
		}
		cv.setStatus(dto.getStatus());
		cv.setFileName(dto.getFileName());
		cv.setFileType(dto.getFileType());
		return cv;
	}

}
