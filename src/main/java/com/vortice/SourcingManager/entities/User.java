package com.vortice.SourcingManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "USER")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "username", unique = true, nullable = false )
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "profile", nullable = false)
	private String profile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
