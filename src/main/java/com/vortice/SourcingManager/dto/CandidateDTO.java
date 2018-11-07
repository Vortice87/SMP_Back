package com.vortice.SourcingManager.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateDTO {
	
    /** The candidate id. */
    private Integer candidateId;
    
    /** The request id. */
    private Integer requestId;

    /** The name. */
    private String name;

    /** The created date. */
    private Date createdDate;

	/** The comments. */
	private List<CommentDTO> comments;

	/** The status. */
	private String status;
	
	/** The document base 64. */
	private String documentBase64;
	
}
