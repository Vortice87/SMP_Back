package com.vortice.SourcingManager.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.vortice.SourcingManager.entities.Request;

/**
 * The Interface RequestDao.
 */
public interface RequestDao extends CrudRepository<Request, Integer>, PagingAndSortingRepository<Request, Integer> {

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the request
	 */
	public Request findById(Integer id);
		
	@Query(value = "SELECT distinct * FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and r.petitioner = ?2 and rt.techscope like ?3 and r.start_date BETWEEN ?4 and ?5"
			+ " and r.desc_task like ?6 and r.status like ?7 group by r.id limit ?8, ?9", nativeQuery = true)
	public List<Request> findRequestWithDateAndRequester(String perfil, int solicitante, String tecnologia, Date fechaDesde,
			Date fechaHata, String descripcion, String estado, Integer index, Integer limit);
		
	@Query(value = "SELECT distinct * FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and r.petitioner = ?2 and rt.techscope like ?3 "
			+ " and r.desc_task like ?4 and r.status like ?5 group by r.id limit ?6, ?7", nativeQuery = true)
	public List<Request> findRequestWithOutDateWithRequester(String perfil, int solicitante, String tecnologia, String descripcion, String estado, Integer index, Integer limit);
	
	@Query(value = "SELECT distinct * FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and rt.techscope like ?2 "
			+ " and r.desc_task like ?3 and r.status like ?4 group by r.id limit ?5, ?6", nativeQuery = true)
	public List<Request> findRequestWithOutDateAndRequester(String perfil, String tecnologia, String descripcion, String estado, Integer index, Integer limit);

	@Query(value = "SELECT distinct * FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and rt.techscope like ?2 and r.start_date BETWEEN ?3 and ?4"
			+ " and r.desc_task like ?5 and r.status like ?6 group by r.id limit ?7, ?8", nativeQuery = true)
	public List<Request> findRequestWithDateWithOutRequester(String perfil, String tecnologia, Date fechaDesde,
			Date fechaHata, String descripcion, String estado, Integer index, Integer limit);
	
	// PARA LOS CONTADORES DEL FILTRO
	@Query(value = "SELECT count(DISTINCT r.id) FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and r.petitioner = ?2 and rt.techscope like ?3 and r.start_date BETWEEN ?4 and ?5"
			+ " and r.desc_task like ?6 and r.status like ?7", nativeQuery = true)
	public Integer countRequestWithDateAndRequester(String perfil, int solicitante, String tecnologia, Date fechaDesde,
			Date fechaHata, String descripcion, String estado);
		
	@Query(value = "SELECT count(DISTINCT r.id) FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and r.petitioner = ?2 and rt.techscope like ?3 "
			+ " and r.desc_task like ?4 and r.status like ?5", nativeQuery = true)
	public Integer countRequestWithOutDateWithRequester(String perfil, int solicitante, String tecnologia, String descripcion, String estado);
	
	@Query(value = "SELECT count(DISTINCT r.id) FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and rt.techscope like ?2 "
			+ " and r.desc_task like ?3 and r.status like ?4", nativeQuery = true)
	public Integer countRequestWithOutDateAndRequester(String perfil, String tecnologia, String descripcion, String estado);

	@Query(value = "SELECT count(DISTINCT r.id) FROM REQUEST r, REQTECHNICAL rt WHERE r.id = rt.request_id and r.profile like ?1 and rt.techscope like ?2 and r.start_date BETWEEN ?3 and ?4"
			+ " and r.desc_task like ?5 and r.status like ?6", nativeQuery = true)
	public Integer countRequestWithDateWithOutRequester(String perfil, String tecnologia, Date fechaDesde,
			Date fechaHata, String descripcion, String estado);

	
}
