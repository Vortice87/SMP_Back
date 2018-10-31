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

@Entity(name="CANDIDATE")
public class Candidate {
	
	@Id
	@GeneratedValue
    private Integer candidateId;
	
	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name ="requestId", referencedColumnName = "id")
	private Request request;
		
	@Column(nullable = false)
    private String name;
    
	@Column(nullable = false)
    private Date createdDate;
		
	@OneToMany(targetEntity=Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name="candidateId", referencedColumnName="candidateId")
	private List<Comment> comments;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false, length=100000)
	private byte[] document;

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	
}
