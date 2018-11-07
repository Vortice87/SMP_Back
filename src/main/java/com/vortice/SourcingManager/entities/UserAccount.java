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

import lombok.Getter;
import lombok.Setter;

/**
 * The Class UserAccount.
 */
@Getter
@Setter
@Entity(name = "USER")
public class UserAccount {
	
	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	/** The name. */
	private String name;
	
	/** The last name. */
	private String lastName;
	
	/** The username. */
	@Column(name = "username", unique = true, nullable = false )
	private String username;
	
	/** The password. */
	@Column(name = "password", nullable = false)
	private String password;
	
	/** The profile. */
	@Column(name = "profile", nullable = false)
	private String profile;
	
	/** The requests. */
	@OneToMany(targetEntity = Request.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name ="petitioner", referencedColumnName= "id")
	private List<Request> requests;

}
