package com.vortice.SourcingManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="REQTECHNICAL")
public class ReqTechnical {

	
	@Id
	@GeneratedValue
	private Integer id_tech;
	
	private String techscope;
	
	private String others;
	
	private String exp;
	
	private String reqdes;
	
	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "req_tech", referencedColumnName = "id")
	private Request request;

	public Integer getId_tech() {
		return id_tech;
	}

	public void setId_tech(Integer id_tech) {
		this.id_tech = id_tech;
	}

	public String getTechscope() {
		return techscope;
	}

	public void setTechscope(String techscope) {
		this.techscope = techscope;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
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
