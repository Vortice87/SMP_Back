package com.vortice.SourcingManager.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the estado.
 *
 * @return the estado
 */
@Getter

/**
 * Sets the estado.
 *
 * @param estado the new estado
 */
@Setter
public class RequestFilterDTO {

	/** The perfil. */
	private String perfil;
	
	/** The solicitante. */
	private int solicitante;
	
	/** The tecnologia. */
	private String tecnologia;
	
	/** The descripcion. */
	private String descripcion;
	
	/** The fecha deste. */
	private Date fechaDesde;
	
	/** The fecha hasta. */
	private Date fechaHasta;
	
	/** The estado. */
	private String estado;
}
