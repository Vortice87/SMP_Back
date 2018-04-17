package com.vortice.SourcingManager.entities;

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
	private Integer id;
	
	@Column(unique = true, nullable = false )
	private String functScope;
	
	private String others;
	
	@Column(nullable = false )
	private int exp;
	
	@Column(nullable = false )
	private String reqdes;

	@ManyToOne(targetEntity = Request.class)
	@JoinColumn(name = "req_functional", referencedColumnName = "id")
	private Request request;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunctScope() {
		return functScope;
	}

	public void setFunctScope(String functScope) {
		this.functScope = functScope;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getReqdes() {
		return reqdes;
	}

	public void setReqdes(String reqdes) {
		this.reqdes = reqdes;
	}

}


