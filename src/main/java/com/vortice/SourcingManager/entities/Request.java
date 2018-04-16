package com.vortice.SourcingManager.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="REQUEST")
public class Request {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
    private String petitioner;
    
	@Column(nullable = false)
    private String reason;
    
    private String  substitution;
    
    private String suggestedService;
    
	@OneToMany(targetEntity = Provider.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prov", referencedColumnName = "id")
    private List<Provider> provider;
    
    private String sugSerJust;
    
    private String observations;
    
	@Column(nullable = false)
    private String categoryFunc;
    
    private int limitRate;
    
	@Column(nullable = false)
    private String nResources;
    
	@Column(nullable = false)
    private String profile;
    
	@Column(nullable = false)
    private String technology;
    
	@Column(nullable = false)
    private Date startDate;
    
    private Date endDate;
    
	@Column(nullable = false)
    private String area;
    
	@Column(nullable = false)
    private String department;
    
	@Column(nullable = false)
    private String management;
    
    private String unity;
    
	@Column(nullable = false)
    private String code;
    
	@Column(nullable = false)
    private String descProject;
    
	@OneToMany(targetEntity = ReqFunctional.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_funct", referencedColumnName = "id")
    private List<ReqFunctional> reqFuncts;
    
	@OneToMany(targetEntity = ReqTechnical.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tech", referencedColumnName = "id")
    private List<ReqTechnical> reqTechs;
    
	@Column(nullable = false)
    private String descTask;
    
	@Column(nullable = false)
    private String location;
    
	@Column(nullable = false)
    private int floor;
    
	@Column(nullable = false)
    private String place;
    
    private String typeAccess;
    
    private String platEquip;
    
    private String contact;
    
    private String mobile;
    
    private String reasonDotation;
    
	@OneToMany(targetEntity = LanguagesRequest.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_lang", referencedColumnName = "id")
    private List<LanguagesRequest> languages;
    
    private String guards;
      
    
	@OneToMany(targetEntity = Cv.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cv", referencedColumnName = "id")
    private List<Cv> cvs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetitioner() {
		return petitioner;
	}

	public void setPetitioner(String petitioner) {
		this.petitioner = petitioner;
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



	public String getSugSerJust() {
		return sugSerJust;
	}

	public void setSugSerJust(String sugSerJust) {
		this.sugSerJust = sugSerJust;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getCategoryFunc() {
		return categoryFunc;
	}

	public void setCategoryFunc(String categoryFunc) {
		this.categoryFunc = categoryFunc;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescProject() {
		return descProject;
	}

	public void setDescProject(String descProject) {
		this.descProject = descProject;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getReasonDotation() {
		return reasonDotation;
	}

	public void setReasonDotation(String reasonDotation) {
		this.reasonDotation = reasonDotation;
	}


	public String getGuards() {
		return guards;
	}

	public void setGuards(String guards) {
		this.guards = guards;
	}

	public List<Provider> getProvider() {
		return provider;
	}

	public void setProvider(List<Provider> provider) {
		this.provider = provider;
	}

	public List<ReqFunctional> getReqFuncts() {
		return reqFuncts;
	}

	public void setReqFuncts(List<ReqFunctional> reqFuncts) {
		this.reqFuncts = reqFuncts;
	}

	public List<ReqTechnical> getReqTechs() {
		return reqTechs;
	}

	public void setReqTechs(List<ReqTechnical> reqTechs) {
		this.reqTechs = reqTechs;
	}

	public List<LanguagesRequest> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguagesRequest> languages) {
		this.languages = languages;
	}

	public List<Cv> getCvs() {
		return cvs;
	}

	public void setCvs(List<Cv> cvs) {
		this.cvs = cvs;
	}




	
	


}
