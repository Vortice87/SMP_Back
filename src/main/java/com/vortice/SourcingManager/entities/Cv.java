package com.vortice.SourcingManager.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity(name="CV")
public class Cv {
	
	@Id
	@GeneratedValue
    private Integer cvId;
	
	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name ="requestId", referencedColumnName = "id")
	private Request request;
		
	@Column(nullable = false)
    private String candidate;
    
	@Column(nullable = false)
    private Date createdDate;
	
	private String filePath; 
	
	private String comment;
	
	@Column(nullable = false)
	private String status;
	
	private String fileName;
	
	private String fileType;
	

	public Integer getCvId() {
		return cvId;
	}

	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	
}
