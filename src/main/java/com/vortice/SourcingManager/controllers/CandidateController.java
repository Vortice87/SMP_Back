package com.vortice.SourcingManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vortice.SourcingManager.dto.CandidateDTO;
import com.vortice.SourcingManager.dto.CommentDTO;
import com.vortice.SourcingManager.dto.DocumentDTO;
import com.vortice.SourcingManager.services.CandidateService;

@RestController
@RequestMapping("/candidates")
@CrossOrigin("*")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping("/getCandidateById/{candidateId}")
	@ResponseBody
	public CandidateDTO getCandidateById(@PathVariable("candidateId") Integer candidateId) {
		return this.candidateService.findByCandidateId(candidateId);
	}
		
	@PostMapping("/addCandidate")
	@ResponseBody
	public boolean addCandidate(@RequestBody CandidateDTO dto) {
		if(this.candidateService.findByCandidateName(dto.getName())){
			return false;
		}
		return this.candidateService.createCandidate(dto);
	}
	
	@PostMapping("/addComment")
	@ResponseBody
	public boolean addComment(@RequestBody CommentDTO dto) {
		return this.candidateService.createComment(dto);
	}
	
	@DeleteMapping("/deleteComment/{commentId}")
	@ResponseBody
	public boolean deleteComment(@PathVariable("commentId") Integer commentId) {
		return this.candidateService.deleteComment(commentId);
	}

	@GetMapping("/findCvById/{candidateId}")
	@ResponseBody
	public ResponseEntity<DocumentDTO> downloadDocument(@PathVariable("candidateId") Integer candidateId) {
		CandidateDTO candidateDTO = this.candidateService.findByCandidateId(candidateId);
		DocumentDTO document = new DocumentDTO(); 
		document.setDocumentBase64(candidateDTO.getDocumentBase64());
		return  new ResponseEntity<DocumentDTO>(document,HttpStatus.OK);
	}
}
