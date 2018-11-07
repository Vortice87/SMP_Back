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

/**
 * The Class CandidateController.
 */
@RestController
@RequestMapping("/candidates")
@CrossOrigin("*")
public class CandidateController {
	
	/** The candidate service. */
	@Autowired
	private CandidateService candidateService;
	
	/**
	 * Gets the candidate by id.
	 *
	 * @param candidateId the candidate id
	 * @return the candidate by id
	 */
	@RequestMapping("/getCandidateById/{candidateId}")
	@ResponseBody
	public CandidateDTO getCandidateById(@PathVariable("candidateId") Integer candidateId) {
		return this.candidateService.findByCandidateId(candidateId);
	}
		
	/**
	 * Adds the candidate.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	@PostMapping("/addCandidate")
	@ResponseBody
	public boolean addCandidate(@RequestBody CandidateDTO dto) {
		if(this.candidateService.findByCandidateName(dto.getName())){
			return false;
		}
		return this.candidateService.createCandidate(dto);
	}
	
	/**
	 * Update candidate.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	@PostMapping("/updateCandidate")
	public boolean updateCandidate(@RequestBody CandidateDTO dto) {
		return this.candidateService.updateCandidate(dto);
	}
	
	/**
	 * Adds the comment.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	@PostMapping("/addComment")
	@ResponseBody
	public boolean addComment(@RequestBody CommentDTO dto) {
		return this.candidateService.createComment(dto);
	}
	
	/**
	 * Delete comment.
	 *
	 * @param commentId the comment id
	 * @return true, if successful
	 */
	@DeleteMapping("/deleteComment/{commentId}")
	@ResponseBody
	public boolean deleteComment(@PathVariable("commentId") Integer commentId) {
		return this.candidateService.deleteComment(commentId);
	}

	/**
	 * Download document.
	 *
	 * @param candidateId the candidate id
	 * @return the response entity
	 */
	@GetMapping("/findCvById/{candidateId}")
	@ResponseBody
	public ResponseEntity<DocumentDTO> downloadDocument(@PathVariable("candidateId") Integer candidateId) {
		CandidateDTO candidateDTO = this.candidateService.findByCandidateId(candidateId);
		DocumentDTO document = new DocumentDTO(); 
		document.setDocumentBase64(candidateDTO.getDocumentBase64());
		return  new ResponseEntity<DocumentDTO>(document,HttpStatus.OK);
	}
}
