package com.vortice.SourcingManager.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RequestDTO {
	
	private Integer id;

	private Integer petitionerId;
	
	private String profile;

	private String nResources;

	private Date startDate;
	
	private String descTask;

	private List<ReqTechnicalDTO> reqTechs;

	private List<CvDTO> cvs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPetitionerId() {
		return petitionerId;
	}

	public void setPetitionerId(Integer petitionerId) {
		this.petitionerId = petitionerId;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getnResources() {
		return nResources;
	}

	public void setnResources(String nResources) {
		this.nResources = nResources;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDescTask() {
		return descTask;
	}

	public void setDescTask(String descTask) {
		this.descTask = descTask;
	}

	public List<ReqTechnicalDTO> getReqTechs() {
		return reqTechs;
	}

	public void setReqTechs(List<ReqTechnicalDTO> reqTechs) {
		this.reqTechs = reqTechs;
	}

	public List<CvDTO> getCvs() {
		return cvs;
	}

	public void setCvs(List<CvDTO> cvs) {
		this.cvs = cvs;
	}
	
	


}
