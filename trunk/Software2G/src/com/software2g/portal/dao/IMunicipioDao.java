package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Municipio;

public interface IMunicipioDao {
	/**
	 * Return the persistent entities returned from a named query.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName);
	/**
	 * Return the persistent entities returned from a named query with named parameters.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName, String[] paramNames, Object[] paramValues);
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Municipio findMunicipioById(long id);
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	public List<Municipio> findAllMunicipios();
	public List<Municipio> findAllMunicipios(long idDpto);
	public List<Object[]> findDatosMunicipio(long idMcpo);
}
