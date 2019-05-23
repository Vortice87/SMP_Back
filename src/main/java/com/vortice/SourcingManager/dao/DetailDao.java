package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Detalle;

/**
 * The Interface DetailDao.
 */
public interface DetailDao extends CrudRepository<Detalle, Integer>{
	
	/**
	 * Find by nombre detalle.
	 *
	 * @param detailname the detailname
	 * @return the detalle
	 */
	public Detalle findByNombreDetalle(String detailname);
	
	/**
	 * Find by detalle id.
	 *
	 * @param id the id
	 * @return the detalle
	 */
	public Detalle findByDetalleId(Integer id);
	
}
