package com.vortice.SourcingManager.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CandidateDTO {
	
    private Integer candidateId;
    
    private Integer requestId;

    private String name;

    private Date createdDate;

	private List<CommentDTO> comments;

	private String status;
	
	private String documentBase64;
	
}
