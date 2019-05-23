package com.vortice.SourcingManager.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.AreaDao;
import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.entities.Area;
import com.vortice.SourcingManager.entities.UserAccount;
import com.vortice.SourcingManager.mappers.AreaMapper;
import com.vortice.SourcingManager.mappers.UserAccountMapper;
import com.vortice.SourcingManager.services.AreaService;

/**
 * The Class AreaServiceImpl.
 */
@Service
public class AreaServiceImpl implements AreaService{
	
	/** The area dao. */
	@Autowired
	private AreaDao areaDao;

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.AreaService#findAll()
	 */
	@Override
	public List<AreaDTO> findAll() {
		
		Iterator<Area> iterator = areaDao.findAll().iterator();
		List<AreaDTO> list = new ArrayList<AreaDTO>();
		while(iterator.hasNext()) {
			list.add(AreaMapper.toDTO(iterator.next()));
		}
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.AreaService#findAllwithNoRelationship()
	 */
	@Override
	public List<AreaDTO> findAllwithNoRelationship() {
		Iterator<Area> iterator = areaDao.findAll().iterator();
		List<AreaDTO> list = new ArrayList<AreaDTO>();
		while(iterator.hasNext()) {
			list.add(AreaMapper.toDTOwithNoRelationship(iterator.next()));
		}
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.AreaService#deleteArea(java.lang.Integer)
	 */
	@Override
	public boolean deleteArea(Integer id) {
		this.areaDao.delete(id);
		boolean success = this.areaDao.exists(id);
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.AreaService#createArea(com.vortice.SourcingManager.dto.AreaDTO)
	 */
	@Override
	public boolean createArea(AreaDTO dto) {
		Area area = AreaMapper.DTOtoWithNoRelationship(dto);
		this.areaDao.save(area);
		boolean success = this.areaDao.exists(area.getAreaId());
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.AreaService#areaExists(java.lang.String)
	 */
	@Override
	public boolean areaExists(String areaName) {
		if (this.areaDao.findByNombreArea(areaName) != null) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.AreaService#findByAreaId(java.lang.Integer)
	 */
	@Override
	public AreaDTO findByAreaId(Integer id) {
		return AreaMapper.toDTO(this.areaDao.findByAreaId(id));
	}
}
