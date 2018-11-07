package com.vortice.SourcingManager.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Request.
 */
@Getter
@Setter
@Entity(name = "REQUEST")
public class Request {

	/** The id. */
	@Id
	@GeneratedValue
	private Integer id;

	/** The petitioner. */
	@ManyToOne(targetEntity = UserAccount.class)
	@JoinColumn(name ="petitioner", referencedColumnName= "id")
	private UserAccount petitioner;
	
	/** The creation date. */
	@Column(nullable = false)
	private Date creationDate;
	
	/** The profile. */
	@Column(nullable = false)
	private String profile;

	/** The n resources. */
	@Column(nullable = false)
	private String nResources;

	/** The start date. */
	@Column(nullable = false)
	private Date startDate;

	/** The desc task. */
	@Column(nullable = false)
	private String descTask;

	/** The req techs. */
	@OneToMany(targetEntity = ReqTechnical.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private List<ReqTechnical> reqTechs;

	/** The candidates. */
	@OneToMany(targetEntity = Candidate.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private List<Candidate> candidates;	
		
}
