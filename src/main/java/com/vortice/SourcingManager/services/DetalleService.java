package com.vortice.SourcingManager.services;

import com.vortice.SourcingManager.dto.DetalleDTO;

/**
 * The Interface DetalleService.
 */
public interface DetalleService {
	
	/**
	 * Delete detalle.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteDetalle(Integer id);
	

	/**
	 * Creates the detalle.
	 *
	 * @param detalleDto the detalle dto
	 * @return true, if successful
	 */
	public boolean createDetalle(DetalleDTO detalleDto);

	/**
	 * Detalle exists.
	 *
	 * @param detailname the detailname
	 * @return true, if successful
	 */
	public boolean detalleExists(String detailname);
	
	/**
	 * Find by detalle id.
	 *
	 * @param id the id
	 * @return the detalle DTO
	 */
	public DetalleDTO findByDetalleId(Integer id);

}
