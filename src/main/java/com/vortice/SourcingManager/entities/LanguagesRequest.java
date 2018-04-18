package com.vortice.SourcingManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="LANGUAGESREQUEST")
public class LanguagesRequest {

	@Id
	@GeneratedValue
	private Integer id_lang;
	
	private String language;
	
    private String level;
    
    private String reqdes;

	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "req_lang", referencedColumnName = "id")
	private Request request;

	public Integer getId_lang() {
		return id_lang;
	}

	public void setId_lang(Integer id_lang) {
		this.id_lang = id_lang;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getReqdes() {
		return reqdes;
	}

	public void setReqdes(String reqdes) {
		this.reqdes = reqdes;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	

}
