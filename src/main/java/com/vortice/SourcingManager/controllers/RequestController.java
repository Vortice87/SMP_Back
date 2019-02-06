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

import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.dto.RequestFilterDTO;
import com.vortice.SourcingManager.services.impl.RequestServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestController.
 */
@RestController
@RequestMapping("/requests")
@CrossOrigin(origins = "*")
public class RequestController {
	
	/** The request service. */
	@Autowired
	private RequestServiceImpl requestService;
		
	/**
	 * Creates the request.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	@PostMapping("/create")
	@ResponseBody
	public boolean createRequest(@RequestBody RequestDTO dto) {
		boolean success = this.requestService.createRequest(dto);
		return success;
	}
	
	/**
	 * Delete request.
	 *
	 * @param requestId the request id
	 * @return true, if successful
	 */
	@GetMapping("/deleteRequest/{requestId}")
	@ResponseBody
	public boolean deleteRequest(@PathVariable("requestId") Integer requestId) {
		return this.requestService.deleteRequest(requestId);
	}
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping("/all")
	@ResponseBody
	public List<RequestDTO> getAll() {
		List<RequestDTO> list = requestService.getAll();
		return list;
	}
	
	@PostMapping("/findRequests")
	@ResponseBody
	public List<RequestDTO> findRequests(@RequestBody RequestFilterDTO filtro){
		
		return this.requestService.findRequests(filtro);
	}
	
	/**
	 * Gets the request by ID.
	 *
	 * @param requestId the request id
	 * @return the request by ID
	 */
	@GetMapping("/requestById/{requestId}")
	@ResponseBody
	public RequestDTO getRequestByID(@PathVariable("requestId") Integer requestId) {
		return this.requestService.getRequestDTOById(requestId);
	}
	
	/**
	 * Close request.
	 *
	 * @param requestId the request id
	 * @return true, if successful
	 */
	@GetMapping("/closeRequest/{requestId}")
	@ResponseBody
	public boolean closeRequest(@PathVariable("requestId") Integer requestId) {
		return this.requestService.changeRequestStatus(requestId, "Cerrada");
	}
	
	/**
	 * Open request.
	 *
	 * @param requestId the request id
	 * @return true, if successful
	 */
	@GetMapping("/openRequest/{requestId}")
	@ResponseBody
	public boolean openRequest(@PathVariable("requestId") Integer requestId) {
		return this.requestService.changeRequestStatus(requestId, "Abierta");
	}
}
