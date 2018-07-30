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
	private Integer techId;
	
	private String area;
	
	private String techscope;
		
	private String exp;
	
	private String reqdes;
	
	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private Request request;

	public Integer getTechId() {
		return techId;
	}

	public void setTechId(Integer techId) {
		this.techId = techId;
	}

	public String getTechscope() {
		return techscope;
	}

	public void setTechscope(String techscope) {
		this.techscope = techscope;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	
	
}
