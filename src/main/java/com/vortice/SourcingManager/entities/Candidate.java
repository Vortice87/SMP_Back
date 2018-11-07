package com.vortice.SourcingManager.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Candidate.
 */
@Getter
@Setter
@Entity(name="CANDIDATE")
public class Candidate {
	
	/** The candidate id. */
	@Id
	@GeneratedValue
    private Integer candidateId;
	
	/** The request. */
	@ManyToOne(targetEntity = Request.class)
	@JoinColumn(name ="requestId", referencedColumnName = "id")
	private Request request;
		
	/** The name. */
	@Column(nullable = false)
    private String name;
    
	/** The created date. */
	@Column(nullable = false)
    private Date createdDate;
		
	/** The comments. */
	@OneToMany(targetEntity=Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name="candidateId", referencedColumnName="candidateId")
	private List<Comment> comments;
	
	/** The status. */
	@Column(nullable = false)
	private String status;
	
	/** The document. */
	@Column(nullable = false, length=100000)
	private byte[] document;
	
}
