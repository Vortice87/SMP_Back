package com.vortice.SourcingManager.mappers;


import java.util.ArrayList;

import com.vortice.SourcingManager.dto.AreaDTO;
import com.vortice.SourcingManager.dto.DetalleDTO;
import com.vortice.SourcingManager.entities.Area;
import com.vortice.SourcingManager.entities.Detalle;

public class AreaMapper {

	public static AreaDTO toDTO(Area area) {
		AreaDTO newdto = new AreaDTO();
		newdto.setAreaId(area.getAreaId());
		newdto.setNombreArea(area.getNombreArea());
		if(area.getDetalles() != null &&  area.getDetalles().size() > 0) {
			newdto.setDetalles(new ArrayList<DetalleDTO>());
			for(Detalle d: area.getDetalles()) {
				newdto.getDetalles().add(DetalleMapper.toDTO(d));
			}
		}
		
		return newdto;
	}
	
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
}
