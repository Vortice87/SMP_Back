package com.vortice.SourcingManager.mappers;

import com.vortice.SourcingManager.dto.DetalleDTO;
import com.vortice.SourcingManager.entities.Detalle;

public class DetalleMapper {
	
	public static DetalleDTO toDTO(Detalle detalle) {
		DetalleDTO newDto = new DetalleDTO();
		newDto.setDetalleId(detalle.getDetalleId());
		newDto.setNombreDetalle(detalle.getNombreDetalle());
		newDto.setAreaId(detalle.getArea().getAreaId());
		return newDto;
	}
	
	public static Detalle DTOto(DetalleDTO detalleDto) {
		Detalle detalle = new Detalle();
		detalle.setDetalleId(detalleDto.getDetalleId());
		detalle.setNombreDetalle(detalleDto.getNombreDetalle());
		return detalle;
	}

}
