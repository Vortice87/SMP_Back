package com.vortice.SourcingManager.services.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RequestDTO {
	
	private Integer id;

	private Integer petitionerId;
	
	private String title;

	private String reason;

	private String substitution;

	private String suggestedService;

	private String observations;

	private int limitRate;

	private String nResources;

	private String profile;

	private String technology;

	private Date startDate;

	private Date endDate;

	private String area;

	private String department;

	private String management;

	private String unity;

	private String descTask;

	private String location;

	private int floor;

	private String place;

	private String typeAccess;

	private String platEquip;

	private String contact;

	private List<LanguagesRequestDTO> languages;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSubstitution() {
		return substitution;
	}

	public void setSubstitution(String substitution) {
		this.substitution = substitution;
	}

	public String getSuggestedService() {
		return suggestedService;
	}

	public void setSuggestedService(String suggestedService) {
		this.suggestedService = suggestedService;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public int getLimitRate() {
		return limitRate;
	}

	public void setLimitRate(int limitRate) {
		this.limitRate = limitRate;
	}

	public String getnResources() {
		return nResources;
	}

	public void setnResources(String nResources) {
		this.nResources = nResources;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public String getDescTask() {
		return descTask;
	}

	public void setDescTask(String descTask) {
		this.descTask = descTask;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTypeAccess() {
		return typeAccess;
	}

	public void setTypeAccess(String typeAccess) {
		this.typeAccess = typeAccess;
	}

	public String getPlatEquip() {
		return platEquip;
	}

	public void setPlatEquip(String platEquip) {
		this.platEquip = platEquip;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<LanguagesRequestDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguagesRequestDTO> languages) {
		this.languages = languages;
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
