package com.vortice.SourcingManager.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="COMMENT")
public class Comment {
	
	@Id
	@GeneratedValue
	private Integer commentId;
	
	@Column(nullable=false)
	private String comment;
	
	@Column(nullable=false)
	private Date creationDate;
	
	@ManyToOne(targetEntity=Cv.class, cascade = CascadeType.ALL)
	@JoinColumn(name="cvId", referencedColumnName="cvId")
	private Cv cv;

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

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}
	
}
