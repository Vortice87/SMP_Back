package com.vortice.SourcingManager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="AREA")
public class Area {
	
	@Id
	@GeneratedValue
    private Integer areaId;
	
	private String nombreArea;
	
	@OneToMany(targetEntity = Detalle.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "area", referencedColumnName = "areaId")
	private List<Detalle> detalles;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
}
