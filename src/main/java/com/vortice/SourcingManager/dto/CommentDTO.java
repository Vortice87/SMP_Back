package com.vortice.SourcingManager.dto;

import java.sql.Date;

public class CommentDTO {
	
	private Integer commentId;
	
	private String comment;
	
	private Date creationDate;
	
	private Integer cvId;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCvId() {
		return cvId;
	}

	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}

}