package com.vortice.SourcingManager.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CommentDTO.
 */
@Getter
@Setter
public class CommentDTO {
	
	/** The comment id. */
	private Integer commentId;
	
	/** The description. */
	private String description;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The candidate id. */
	private Integer candidateId;
}
