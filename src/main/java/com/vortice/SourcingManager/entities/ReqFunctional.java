package com.vortice.SourcingManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="REQFUNCTIONAL")
public class ReqFunctional {
	
	@Id
	@GeneratedValue
	private Integer id_funct;
	
	private String functscope;
	
	private String others;
	
	private String exp;
	
	private String reqdes;

	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "req_funct", referencedColumnName = "id")
	private Request request;

	public Integer getId_funct() {
		return id_funct;
	}

	public void setId_funct(Integer id_funct) {
		this.id_funct = id_funct;
	}


	public String getFunctscope() {
		return functscope;
	}

	public void setFunctscope(String functscope) {
		this.functscope = functscope;
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


