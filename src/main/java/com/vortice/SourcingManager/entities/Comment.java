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

@Entity(name="COMMENT")
@Getter
@Setter
public class Comment {
	
	@Id
	@GeneratedValue
	private Integer commentId;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private Date creationDate;
	
	@ManyToOne(targetEntity=Candidate.class)
	@JoinColumn(name="candidateId", referencedColumnName="candidateId")
	private Candidate candidate;

}
