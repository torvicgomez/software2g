package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Opcionrespuesta;

/**
 * The DAO interface for the Opcionrespuesta entity.
 */
public interface IOpcionRespuestaDao {
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
	public Opcionrespuesta findOpcionrespuestaById(long id);
	/**
	 * Return all persistent instances of the <code>Opcionrespuesta</code> entity.
	 */
	public List<Opcionrespuesta> findAllOpcionrespuestas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOpcionrespuesta(Opcionrespuesta opcionrespuesta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOpcionrespuesta(Opcionrespuesta opcionrespuesta);
}