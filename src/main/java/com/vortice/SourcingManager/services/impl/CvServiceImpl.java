package com.vortice.SourcingManager.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.CvDao;
import com.vortice.SourcingManager.dao.RequestDao;
import com.vortice.SourcingManager.dto.CvDTO;
import com.vortice.SourcingManager.entities.Cv;
import com.vortice.SourcingManager.entities.Request;
import com.vortice.SourcingManager.mappers.CvMapper;
import com.vortice.SourcingManager.services.CvService;

@Service
public class CvServiceImpl implements CvService {

	@Autowired
	private CvDao cvDao;

	@Autowired
	private RequestDao requestDao;

	@Override
	public boolean createCandidate(CvDTO cvDTO) {

		boolean success = true;
		Cv cv = CvMapper.DTOto(cvDTO);
		Request request = this.requestDao.findById(cvDTO.getRequestId());
		cv.setRequest(request);
		this.cvDao.save(cv);

		success = this.cvDao.exists(cv.getCvId());

		return success;
	}

	@Override
	public boolean findByCandidate(String name) {
		Cv cv = this.cvDao.findByCandidate(name);
		if (cv != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public File getFileFromURL(String path) {

		File file = null;
		file = new File(path);
		return file;

	}

	@Override
	public String saveCv(String fileName, String fileType, String fileDate) {

        byte[] doc = Base64.getDecoder().decode(fileDate);
        String pathBase =  "C:\\Users\\victor.bedmarlam\\Documents\\requests\\";
        String filePath = pathBase + fileName;
        File file = null;
		file = new File(filePath);
		FileOutputStream fos=null;
				
		try {
			fos=new FileOutputStream(file);
			fos.write(doc);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	@Override
	public Cv findByCandidateById(Integer id) {
		return this.cvDao.findByCvId(id);
	}

}
