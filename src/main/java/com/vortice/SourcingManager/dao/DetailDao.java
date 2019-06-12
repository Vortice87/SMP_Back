package com.vortice.SourcingManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Detail;

/**
 * The Interface DetailDao.
 */
public interface DetailDao extends CrudRepository<Detail, Integer>{
	
	/**
	 * Find by nombre detalle.
	 *
	 * @param detailname the detailname
	 * @return the detalle
	 */
	public Detail findByNombreDetalle(String detailname);
	
	/**
	 * Find by detalle id.
	 *
	 * @param id the id
	 * @return the detalle
	 */
	public Detail findByDetalleId(Integer id);
	
}
