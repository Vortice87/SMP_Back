package com.vortice.SourcingManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DetalleDTO {

	private Integer detalleId;
	
	private String nombreDetalle;
	
	private Integer areaId;

	public Integer getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(Integer detalleId) {
		this.detalleId = detalleId;
	}

	public String getNombreDetalle() {
		return nombreDetalle;
	}

	public void setNombreDetalle(String nombreDetalle) {
		this.nombreDetalle = nombreDetalle;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	
}
