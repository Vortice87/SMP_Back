package com.vortice.SourcingManager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortice.SourcingManager.dao.AreaDao;
import com.vortice.SourcingManager.dao.DetailDao;
import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.dto.DetalleDTO;
import com.vortice.SourcingManager.entities.Area;
import com.vortice.SourcingManager.entities.Detail;
import com.vortice.SourcingManager.mappers.AreaMapper;
import com.vortice.SourcingManager.mappers.DetalleMapper;
import com.vortice.SourcingManager.services.DetalleService;

/**
 * The Class DetalleServiceImpl.
 */
@Service
public class DetalleServiceImpl implements DetalleService{
	
	/** The detail dao. */
	@Autowired
	private DetailDao detailDao;
	
	@Autowired
	private AreaDao areaDao;

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.DetalleService#deleteDetalle(java.lang.Integer)
	 */
	@Override
	public boolean deleteDetalle(Integer id) {
		this.detailDao.delete(id);
		boolean success = this.detailDao.exists(id);
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.DetalleService#createDetalle(com.vortice.SourcingManager.dto.DetalleDTO)
	 */
	@Override
	public boolean createDetalle(DetalleDTO detalleDto) {
		Detail detalle = DetalleMapper.DTOto(detalleDto);
		Area area = this.areaDao.findByAreaId(detalleDto.getAreaId());
		detalle.setArea(area);
		this.detailDao.save(detalle);
		boolean success = this.detailDao.exists(detalle.getDetalleId());
		return success;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.DetalleService#detalleExists(java.lang.String)
	 */
	@Override
	public boolean detalleExists(String detailname) {
		if (this.detailDao.findByNombreDetalle(detailname) != null) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vortice.SourcingManager.services.DetalleService#findByDetalleId(java.lang.Integer)
	 */
	@Override
	public DetalleDTO findByDetalleId(Integer id) {
		return DetalleMapper.toDTO(this.detailDao.findByDetalleId(id));
	}

}
