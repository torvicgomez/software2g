package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipoubicacion;

/**
 * The DAO interface for the Tipoubicacion entity.
 */
public interface ITipoUbicacionDao {
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
	public Tipoubicacion findTipoubicacionById(long id);
	/**
	 * Return all persistent instances of the <code>Tipoubicacion</code> entity.
	 */
	public List<Tipoubicacion> findAllTipoubicacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoubicacion(Tipoubicacion tipoubicacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoubicacion(Tipoubicacion tipoubicacion);
}