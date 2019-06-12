package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.DetalleDTO;
import com.vortice.SourcingManager.entities.Detail;

/**
 * The Class DetalleMapper.
 */
public class DetalleMapper {
	
	/**
	 * To DTO.
	 *
	 * @param detalle the detalle
	 * @return the detalle DTO
	 */
	public static DetalleDTO toDTO(Detail detalle) {
		DetalleDTO newDto = new DetalleDTO();
		newDto.setDetalleId(detalle.getDetalleId());
		newDto.setNombreDetalle(detalle.getNombreDetalle());
		newDto.setAreaId(detalle.getArea().getAreaId());
		return newDto;
	}
	
	/**
	 * DT oto.
	 *
	 * @param detalleDto the detalle dto
	 * @return the detalle
	 */
	public static Detail DTOto(DetalleDTO detalleDto) {
		Detail detalle = new Detail();
		detalle.setDetalleId(detalleDto.getDetalleId());
		detalle.setNombreDetalle(detalleDto.getNombreDetalle());
		return detalle;
	}

}
