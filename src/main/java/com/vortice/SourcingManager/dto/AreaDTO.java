package com.vortice.SourcingManager.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vortice.SourcingManager.entities.Detail;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class AreaDTO.
 */
@Getter
@Setter
public class AreaDTO {
	
	/** The Area id. */
	private Integer AreaId;
	
	/** The nombre area. */
	private String nombreArea;
	
	/** The detalles. */
	private List<DetalleDTO> detalles;

}
