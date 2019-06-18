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

import com.vortice.SourcingManager.dto.ContextEmailDTO;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.dto.RequestFilterDTO;
import com.vortice.SourcingManager.services.EmailService;
import com.vortice.SourcingManager.services.impl.RequestServiceImpl;

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
	
	/** The email service. */
	@Autowired
	private EmailService emailService;
		
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
	 * Find requests.
	 *
	 * @param filtro the filtro
	 * @return the list
	 */
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
	 * Gets the request DTO by id with out relationships.
	 *
	 * @param requestId the request id
	 * @return the request DTO by id with out relationships
	 */
	@GetMapping("/requestByIdWithOutRelationships/{requestId}")
	@ResponseBody
	public RequestDTO getRequestDTOByIdWithOutRelationships(@PathVariable("requestId") Integer requestId) {
		return this.requestService.getRequestDTOByIdWithOutRelationships(requestId);
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
		
	/**
	 * Count by requests filter.
	 *
	 * @param filtro the filtro
	 * @return the integer
	 */
	@PostMapping("/countByRequestsFilter")
	@ResponseBody
	public Integer countByRequestsFilter(@RequestBody RequestFilterDTO filtro) {
		return this.requestService.countByRequestsFilter(filtro);
	}
	
	/**
	 * Send email.
	 *
	 * @param context the context
	 */
	@PostMapping("/sendEmail")
	@ResponseBody
	public void sendEmail(@RequestBody ContextEmailDTO context) {
		this.emailService.sendSimpleMessage(context.getFrom(), context.getTo(), context.getSubject(), context.getText());
	}
}
