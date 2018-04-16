package com.vortice.SourcingManager.entities;

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
    private Integer id;
	
	@Column(unique = true, nullable = false )
    private String dni;
	
	@Column(unique = true, nullable = false )
    private String name;
	
	@ManyToOne(targetEntity = Request.class)
	@JoinColumn(name = "id_cv", referencedColumnName = "id")
	private Request request;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	

}
