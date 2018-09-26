package com.vortice.SourcingManager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "USER")
public class UserAccount {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String lastName;
	
	@Column(name = "username", unique = true, nullable = false )
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "profile", nullable = false)
	private String profile;
	
	@OneToMany(targetEntity = Request.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name ="petitioner", referencedColumnName= "id")
	private List<Request> requests;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	



	
}
