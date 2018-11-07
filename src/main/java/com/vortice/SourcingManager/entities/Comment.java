package com.vortice.SourcingManager.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Comment.
 */
@Getter
@Setter
@Entity(name="COMMENT")
public class Comment {
	
	/** The comment id. */
	@Id
	@GeneratedValue
	private Integer commentId;
	
	/** The description. */
	@Column(nullable=false)
	private String description;
	
	/** The creation date. */
	@Column(nullable=false)
	private Date creationDate;
	
	/** The candidate. */
	@ManyToOne(targetEntity=Candidate.class)
	@JoinColumn(name="candidateId", referencedColumnName="candidateId")
	private Candidate candidate;

}
