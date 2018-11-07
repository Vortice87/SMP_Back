package com.vortice.SourcingManager.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ReqTechnicalDTO.
 */
@Getter
@Setter
public class ReqTechnicalDTO {
	
	/** The tech id. */
	private Integer techId;
	
	/** The techscope. */
	private String techscope;
	
	/** The area. */
	private String area;
		
	/** The exp. */
	private String exp;
	
	/** The reqdes. */
	private String reqdes;

	/** The request id. */
	private Integer requestId;

	/**
	 * Gets the tech id.
	 *
	 * @return the tech id
	 */
	public Integer getTechId() {
		return techId;
	}

	/**
	 * Sets the tech id.
	 *
	 * @param techId the new tech id
	 */
	public void setTechId(Integer techId) {
		this.techId = techId;
	}

	/**
	 * Gets the techscope.
	 *
	 * @return the techscope
	 */
	public String getTechscope() {
		return techscope;
	}

	/**
	 * Sets the techscope.
	 *
	 * @param techscope the new techscope
	 */
	public void setTechscope(String techscope) {
		this.techscope = techscope;
	}

	/**
	 * Gets the exp.
	 *
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * Sets the exp.
	 *
	 * @param exp the new exp
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * Gets the reqdes.
	 *
	 * @return the reqdes
	 */
	public String getReqdes() {
		return reqdes;
	}

	/**
	 * Sets the reqdes.
	 *
	 * @param reqdes the new reqdes
	 */
	public void setReqdes(String reqdes) {
		this.reqdes = reqdes;
	}

	/**
	 * Gets the request id.
	 *
	 * @return the request id
	 */
	public Integer getRequestId() {
		return requestId;
	}

	/**
	 * Sets the request id.
	 *
	 * @param requestId the new request id
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Sets the area.
	 *
	 * @param area the new area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	

}
