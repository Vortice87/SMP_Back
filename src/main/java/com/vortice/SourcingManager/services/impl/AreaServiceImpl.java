package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.AreaDao;
import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.entities.Area;
import com.vortice.SourcingManager.mappers.AreaMapper;
import com.vortice.SourcingManager.services.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<AreaDTO> findAll() {
		
		Iterator<Area> iterator = areaDao.findAll().iterator();
		List<AreaDTO> list = new ArrayList<AreaDTO>();
		while(iterator.hasNext()) {
			list.add(AreaMapper.toDTO(iterator.next()));
		}
		
		return list;
	}

}
