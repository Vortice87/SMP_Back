package com.vortice.SourcingManager.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.dto.RequestDTO;
import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.services.CvService;
import com.vortice.SourcingManager.services.impl.RequestServiceImpl;
import com.vortice.SourcingManager.services.impl.UserAccountServiceImpl;

@Controller
@RequestMapping("/requests")
@CrossOrigin(origins = "*")
public class RequestController {
	
	@Autowired
	private RequestServiceImpl requestService;
	
	@Autowired
	private UserAccountServiceImpl userAccountService;
	
	@Autowired
	private CvService cvService;
	
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
	
	@PostMapping("/addcv")
	@ResponseBody
	public boolean addCandidate(@RequestBody CvDTO dto) {
		if(this.cvService.findByCandidate(dto.getCandidate())){
			return false;
		}

		dto.setFilePath(this.cvService.saveCv(dto.getFileName(), dto.getFileType(), dto.getFileData()));
		return this.cvService.createCandidate(dto);
	}
	
	@GetMapping("/findCvById/{cvId}")
	@ResponseBody
	public ResponseEntity<byte[]> downloadDocument(@PathVariable("cvId") Integer cvId) {
		
		Cv candidate = this.cvService.findByCandidateById(cvId);
		File cv = this.cvService.getFileFromURL(candidate.getFilePath());
		byte[] doc = null;
		try {
			doc = Files.readAllBytes(cv.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        // Adding required headers for file conversion
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(candidate.getFileType()));
		headers.setContentLength(doc.length);
		headers.setContentDispositionFormData("inline",candidate.getFileName());
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma","no-cache");
		headers.add("Expires", "0");
		return  new ResponseEntity<byte[]>(doc, headers, HttpStatus.OK);
	}
	
}
