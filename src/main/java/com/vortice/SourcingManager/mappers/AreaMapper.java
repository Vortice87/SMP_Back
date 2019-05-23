package com.vortice.SourcingManager.mappers;


import java.util.ArrayList;

import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.dto.DetalleDTO;
import com.vortice.SourcingManager.entities.Area;
import com.vortice.SourcingManager.entities.Detalle;

/**
 * The Class AreaMapper.
 */
public class AreaMapper {

	/**
	 * To DTO.
	 *
	 * @param area the area
	 * @return the area DTO
	 */
	public static AreaDTO toDTO(Area area) {
		AreaDTO newdto = new AreaDTO();
		newdto.setAreaId(area.getAreaId());
		newdto.setNombreArea(area.getNombreArea());
		if(area.getDetalles() != null &&  area.getDetalles().size() > 0) {
			newdto.setDetalles(new ArrayList<DetalleDTO>());
			for(Detalle d: area.getDetalles()) {
				newdto.getDetalles().add(DetalleMapper.toDTO(d));
			}
		} else {
			newdto.setDetalles(new ArrayList<DetalleDTO>());
		}
		
		return newdto;
	}
	
	/**
	 * DT oto.
	 *
	 * @param dto the dto
	 * @return the area
	 */
	public static Area DTOto(AreaDTO dto) {
		
		Area area = new Area();
		area.setAreaId(dto.getAreaId());
		area.setNombreArea(dto.getNombreArea());
		if(dto.getDetalles() != null && dto.getDetalles().size() > 0) {
			area.setDetalles(new ArrayList<Detalle>());
			for(DetalleDTO detalleDto: dto.getDetalles()) {
				area.getDetalles().add(DetalleMapper.DTOto(detalleDto));
			}
		}
		return area;
	}
	
	public static AreaDTO toDTOwithNoRelationship(Area area) {
		AreaDTO newdto = new AreaDTO();
		newdto.setAreaId(area.getAreaId());
		newdto.setNombreArea(area.getNombreArea());	
		return newdto;
	}
	
	public static Area DTOtoWithNoRelationship(AreaDTO dto) {
		Area area = new Area();
		area.setAreaId(dto.getAreaId());
		area.setNombreArea(dto.getNombreArea());
		return area;
	}
}
