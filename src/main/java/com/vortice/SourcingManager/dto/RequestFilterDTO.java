package com.vortice.SourcingManager.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the estado.
 *
 * @return the estado
 */

/**
 * Gets the limit.
 *
 * @return the limit
 */
@Getter

/**
 * Sets the estado.
 *
 * @param estado the new estado
 */

/**
 * Sets the limit.
 *
 * @param limit the new limit
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
	
	/** The index. */
	private Integer index;
	
	/** The limit. */
	private Integer limit;
}
