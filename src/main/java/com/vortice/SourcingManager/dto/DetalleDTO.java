package com.vortice.SourcingManager.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class DetalleDTO.
 */
@Getter
@Setter
public class DetalleDTO {

	/** The detalle id. */
	private Integer detalleId;
	
	/** The nombre detalle. */
	private String nombreDetalle;
	
	/** The area id. */
	private Integer areaId;

	/**
	 * Gets the detalle id.
	 *
	 * @return the detalle id
	 */
	public Integer getDetalleId() {
		return detalleId;
	}

	/**
	 * Sets the detalle id.
	 *
	 * @param detalleId the new detalle id
	 */
	public void setDetalleId(Integer detalleId) {
		this.detalleId = detalleId;
	}

	/**
	 * Gets the nombre detalle.
	 *
	 * @return the nombre detalle
	 */
	public String getNombreDetalle() {
		return nombreDetalle;
	}

	/**
	 * Sets the nombre detalle.
	 *
	 * @param nombreDetalle the new nombre detalle
	 */
	public void setNombreDetalle(String nombreDetalle) {
		this.nombreDetalle = nombreDetalle;
	}

	/**
	 * Gets the area id.
	 *
	 * @return the area id
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * Sets the area id.
	 *
	 * @param areaId the new area id
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	
}
