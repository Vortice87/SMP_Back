package com.vortice.SourcingManager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Area.
 */
@Getter
@Setter
@Entity(name="AREA")
public class Area {
	
	/** The area id. */
	@Id
	@GeneratedValue
    private Integer areaId;
	
	/** The nombre area. */
	private String nombreArea;
	
	/** The detalles. */
	@OneToMany(targetEntity = Detalle.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "area", referencedColumnName = "areaId")
	private List<Detalle> detalles;
}
