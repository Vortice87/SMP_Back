package com.vortice.SourcingManager.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vortice.SourcingManager.entities.Detalle;

@JsonInclude(Include.NON_NULL)
public class AreaDTO {
	
	private Integer AreaId;
	
	private String nombreArea;
	
	private List<DetalleDTO> detalles;

	public Integer getAreaId() {
		return AreaId;
	}

	public void setAreaId(Integer areaId) {
		AreaId = areaId;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public List<DetalleDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleDTO> detalles) {
		this.detalles = detalles;
	}
	

}
