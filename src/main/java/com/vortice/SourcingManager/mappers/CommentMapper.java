package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.entities.Comment;

/**
 * The Class CommentMapper.
 */
public class CommentMapper {
	
	/**
	 * To DTO.
	 *
	 * @param comment the comment
	 * @return the comment DTO
	 */
	public static CommentDTO toDTO(Comment comment) {
		CommentDTO newDTO = new CommentDTO();
		newDTO.setCommentId(comment.getCommentId());
		newDTO.setDescription(comment.getDescription());
		newDTO.setCreationDate(comment.getCreationDate());
		newDTO.setCandidateId(comment.getCandidate().getCandidateId());
		return newDTO;
	}
	
	/**
	 * DT oto.
	 *
	 * @param dto the dto
	 * @return the comment
	 */
	public static Comment DTOto(CommentDTO dto) {
		Comment comment = new Comment();
		comment.setCommentId(dto.getCommentId());
		comment.setDescription(dto.getDescription());
		comment.setCreationDate(dto.getCreationDate());
		return comment;
	}

}
