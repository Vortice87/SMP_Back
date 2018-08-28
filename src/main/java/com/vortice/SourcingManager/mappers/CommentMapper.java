package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.entities.Comment;

public class CommentMapper {
	
	public static CommentDTO toDTO(Comment comment) {
		CommentDTO newDTO = new CommentDTO();
		newDTO.setCommentId(comment.getCommentId());
		newDTO.setComment(comment.getComment());
		newDTO.setCreationDate(comment.getCreationDate());
		newDTO.setCvId(comment.getCv().getCvId());
		return newDTO;
	}
	
	public static Comment DTOto(CommentDTO dto) {
		Comment comment = new Comment();
		comment.setCommentId(dto.getCommentId());
		comment.setComment(dto.getComment());
		comment.setCreationDate(dto.getCreationDate());
		return comment;
	}

}
