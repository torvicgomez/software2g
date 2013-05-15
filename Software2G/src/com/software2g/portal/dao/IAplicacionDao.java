package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Aplicacion;

/**
 * The DAO interface for the Aplicacion entity.
 */
public interface IAplicacionDao {
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
	public Aplicacion findAplicacionById(java.lang.Integer id);
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	public List<Aplicacion> findAllAplicacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAplicacion(Aplicacion aplicacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAplicacion(Aplicacion aplicacion);
}