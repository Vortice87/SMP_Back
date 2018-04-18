package com.vortice.SourcingManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="CV")
public class Cv {
	
	@Id
	@GeneratedValue
    private Integer id_cv;
	
    private String dni;
	
    private String name;
	
	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name ="req_cv", referencedColumnName = "id")
	private Request request;

	public Integer getId_cv() {
		return id_cv;
	}

	public void setId_cv(Integer id_cv) {
		this.id_cv = id_cv;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

////	public Request getRequest() {
////		return request;
////	}
////
////	public void setRequest(Request request) {
////		this.request = request;
////	}
//	

}
