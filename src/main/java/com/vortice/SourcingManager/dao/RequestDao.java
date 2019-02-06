package com.vortice.SourcingManager.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vortice.SourcingManager.entities.Request;

/**
 * The Interface RequestDao.
 */
public interface RequestDao extends CrudRepository<Request, Integer>{
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the request
	 */
	public Request findById(Integer id);
	
	@Query(value = "SELECT distinct * FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and r.petitioner = ?2 and rt.techscope like ?3 and r.start_date BETWEEN ?4 and ?5" +
			   " and r.desc_task like ?6 and r.status like ?7 group by r.id",
			   nativeQuery = true)
		public List<Request> FindAllWithDescriptionQuery(String perfil, int solicitante, String tecnologia, Date fechaDesde, Date fechaHata, String descripcion, String estado);;
	
}
