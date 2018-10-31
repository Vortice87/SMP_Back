package com.vortice.SourcingManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class DocumentDTO {
	
    private String documentName;
    
    private String documentExtension;
    
    private String documentBase64;
    
    

}
