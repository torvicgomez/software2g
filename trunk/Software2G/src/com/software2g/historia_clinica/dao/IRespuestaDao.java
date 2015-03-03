package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Respuesta;

/**
 * The DAO interface for the Respuesta entity.
 */
public interface IRespuestaDao {
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
	public Respuesta findRespuestaById(long id);
	/**
	 * Return all persistent instances of the <code>Respuesta</code> entity.
	 */
	public List<Respuesta> findAllRespuestas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRespuesta(Respuesta respuesta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRespuesta(Respuesta respuesta);
}