package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Finalidad;

/**
 * The DAO interface for the Finalidad entity.
 */
public interface IFinalidadDao {
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
	public Finalidad findFinalidadById(long id);
	/**
	 * Return all persistent instances of the <code>Finalidad</code> entity.
	 */
	public List<Finalidad> findAllFinalidads();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFinalidad(Finalidad finalidad);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFinalidad(Finalidad finalidad);
}