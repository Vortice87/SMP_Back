package com.vortice.SourcingManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="CONFIGURATION")
public class Configuration {
	
	@Id
	@GeneratedValue
	private Integer configId;
	
	@Column(nullable = false)
	private boolean notificationRequest; 
	
	@Column(nullable = false)
	private boolean notificationCandidate;
	
	@Column(nullable = false)
	private boolean notificationInterview;
	
}
