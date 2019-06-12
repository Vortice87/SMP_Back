package com.vortice.SourcingManager.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Detalle.
 */
@Getter
@Setter
@Entity(name="DETALLE")
public class Detail {
	
	/** The detalle id. */
	@Id
	@GeneratedValue
	private Integer detalleId;
	
	/** The nombre detalle. */
	private String nombreDetalle;
	
	/** The area. */
	@ManyToOne(targetEntity = Area.class)
	@JoinColumn(name = "area", referencedColumnName = "areaId")
	private Area area;

}
