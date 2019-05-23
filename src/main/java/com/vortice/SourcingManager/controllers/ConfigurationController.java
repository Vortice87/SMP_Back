package com.vortice.SourcingManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.dto.DetalleDTO;
import com.vortice.SourcingManager.services.AreaService;
import com.vortice.SourcingManager.services.DetalleService;

/**
 * The Class ConfigurationController.
 */
@RestController
@RequestMapping("/configuration")
@CrossOrigin("*")
public class ConfigurationController {
	
	/** The area service. */
	@Autowired
	private AreaService areaService;
	
	/** The detalle service. */
	@Autowired
	private DetalleService detalleService;
	
	/**
	 * Find area by id.
	 *
	 * @param id the id
	 * @return the area DTO
	 */
	@GetMapping("/findAreaById/{areaId}")
	@ResponseBody
	public AreaDTO findAreaById(@PathVariable("areaId") Integer id) {
		return this.areaService.findByAreaId(id);
	}
	
	/**
	 * Find detalle by id.
	 *
	 * @param id the id
	 * @return the detalle DTO
	 */
	@GetMapping("/findDetalleById/{detalleId}")
	@ResponseBody
	public DetalleDTO findDetalleById(@PathVariable("detalleId") Integer id) {
		return this.detalleService.findByDetalleId(id);
	}
		
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@GetMapping("/all")
	@ResponseBody
	public List<AreaDTO> findAll() {
		
		List<AreaDTO> list = this.areaService.findAll();
		return list;
	}
	
	/**
	 * Find allwith no relationship.
	 *
	 * @return the list
	 */
	@GetMapping("/allwithNoRelationship")
	@ResponseBody
	public List<AreaDTO> findAllwithNoRelationship() {
		
		List<AreaDTO> list = this.areaService.findAllwithNoRelationship();
		return list;
	}
	
	/**
	 * Delete area.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@GetMapping("/delete/{id}")
	@ResponseBody
	public boolean deleteArea(@PathVariable("id") Integer id) {
		return this.areaService.deleteArea(id);
	}
	
	/**
	 * Delete detail.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@GetMapping("/deleteDetail/{id}")
	@ResponseBody
	public boolean deleteDetail(@PathVariable("id") Integer id) {
		return this.detalleService.deleteDetalle(id);
	}
	
	/**
	 * Creates the area.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	@PostMapping("/create")
	@ResponseBody
	public boolean createArea(@RequestBody AreaDTO dto) {
		return this.areaService.createArea(dto);
	}
	
	/**
	 * Creates the detail.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	@PostMapping("/createDetail")
	@ResponseBody
	public boolean createDetail(@RequestBody DetalleDTO dto) {
		return this.detalleService.createDetalle(dto);
	}
		
	/**
	 * User exists.
	 *
	 * @param areaname the areaname
	 * @return true, if successful
	 */
	@GetMapping("/exists/{areaname}")
	@ResponseBody
	public boolean userExists(@PathVariable String areaname) {
		if(this.areaService.areaExists(areaname)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Detail exists.
	 *
	 * @param detailname the detailname
	 * @return true, if successful
	 */
	@GetMapping("/detailExists/{detailname}")
	@ResponseBody
	public boolean detailExists(@PathVariable String detailname) {
		if(this.detalleService.detalleExists(detailname)) {
			return true;
		}
		return false;
	}

}
