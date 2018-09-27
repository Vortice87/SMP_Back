package com.vortice.SourcingManager.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "REQUEST")
public class Request {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(targetEntity = UserAccount.class, cascade = CascadeType.ALL)
	@JoinColumn(name ="petitioner", referencedColumnName= "id")
	private UserAccount petitioner;
	
	@Column(nullable = false)
	private Date creationDate;
	
	@Column(nullable = false)
	private String profile;

	@Column(nullable = false)
	private String nResources;

	@Column(nullable = false)
	private Date startDate;

	@Column(nullable = false)
	private String descTask;

	@OneToMany(targetEntity = ReqTechnical.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private List<ReqTechnical> reqTechs;

	@OneToMany(targetEntity = Candidate.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private List<Candidate> candidates;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserAccount getPetitioner() {
		return petitioner;
	}

	public void setPetitioner(UserAccount petitioner) {
		this.petitioner = petitioner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public List<ReqTechnical> getReqTechs() {
		return reqTechs;
	}

	public void setReqTechs(List<ReqTechnical> reqTechs) {
		this.reqTechs = reqTechs;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	
		
}
