package com.vortice.SourcingManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="DETALLE")
public class Detalle {
	
	@Id
	@GeneratedValue
	private Integer detalleId;
	
	private String nombreDetalle;
	
	@ManyToOne(targetEntity = Area.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "area", referencedColumnName = "areaId")
	private Area area;

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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
