package com.vortice.SourcingManager.controllers;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.dto.DocumentDTO;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Candidate;
import com.vortice.SourcingManager.services.CandidateService;
import com.vortice.SourcingManager.services.impl.RequestServiceImpl;

@RestController
@RequestMapping("/requests")
@CrossOrigin(origins = "*")
public class RequestController {
	
	@Autowired
	private RequestServiceImpl requestService;
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("/create")
	@ResponseBody
	public boolean createRequest(@RequestBody RequestDTO dto) {
		boolean success = this.requestService.createRequest(dto);
		return success;
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<RequestDTO> getAll() {
		List<RequestDTO> list = requestService.getAll();
		return list;
	}
	
	@GetMapping("/requestById/{requestId}")
	@ResponseBody
	public RequestDTO getRequestByID(@PathVariable("requestId") Integer requestId) {
		return this.requestService.getRequestById(requestId);
	}
	
	@PostMapping("/addCandidate")
	@ResponseBody
	public boolean addCandidate(@RequestBody CandidateDTO dto) {
		if(this.candidateService.findByCandidateName(dto.getName())){
			return false;
		}
		return this.candidateService.createCandidate(dto);
	}
	
	@PutMapping("/updatecv")
	@ResponseBody
	public boolean updateCandidate(@RequestBody CandidateDTO dto) {
		return false;
	}
	
	@GetMapping("/findCvById/{candidateId}")
	@ResponseBody
	public ResponseEntity<DocumentDTO> downloadDocument(@PathVariable("candidateId") Integer candidateId) {
		Candidate candidate = this.candidateService.findByCandidateId(candidateId);
		DocumentDTO document = new DocumentDTO(); 
		document.setDocumentBase64(Base64.getEncoder().encodeToString(candidate.getDocument()));
		return  new ResponseEntity<DocumentDTO>(document,HttpStatus.OK);
	}
	
}
