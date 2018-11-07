package com.vortice.SourcingManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class DocumentDTO.
 */

/**
 * Gets the document base 64.
 *
 * @return the document base 64
 */
@Getter

/**
 * Sets the document base 64.
 *
 * @param documentBase64 the new document base 64
 */
@Setter
public class DocumentDTO {
	
    /** The document name. */
    private String documentName;
    
    /** The document extension. */
    private String documentExtension;
    
    /** The document base 64. */
    private String documentBase64;
    
    

}
