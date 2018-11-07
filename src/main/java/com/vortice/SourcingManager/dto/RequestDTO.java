package com.vortice.SourcingManager.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class RequestDTO.
 */
@Getter
@Setter
public class RequestDTO {
	
	/** The id. */
	private Integer id;

	/** The petitioner. */
	private UserAccountDTO petitioner;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The profile. */
	private String profile;

	/** The n resources. */
	private String nResources;

	/** The start date. */
	private Date startDate;
	
	/** The desc task. */
	private String descTask;

	/** The req techs. */
	private List<ReqTechnicalDTO> reqTechs;

	/** The candidates. */
	private List<CandidateDTO> candidates;

	
}
