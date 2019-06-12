package com.vortice.SourcingManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ReqTechnical.
 */
@Getter
@Setter
@Entity(name="REQTECHNICAL")
public class ReqTechnical {

	
	/** The tech id. */
	@Id
	@GeneratedValue
	private Integer techId;
	
	/** The area. */
	private String area;
	
	/** The techscope. */
	private String techscope;
		
	/** The exp. */
	private String exp;
	
	/** The reqdes. */
	private String reqdes;
	
	/** The request. */
	@ManyToOne(targetEntity = Request.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private Request request;
}
