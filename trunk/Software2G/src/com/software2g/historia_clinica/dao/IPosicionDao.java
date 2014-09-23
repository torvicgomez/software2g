package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Posicion;

/**
 * The DAO interface for the Posicion entity.
 */
public interface IPosicionDao {
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
	public Posicion findPosicionById(long id);
	/**
	 * Return all persistent instances of the <code>Posicion</code> entity.
	 */
	public List<Posicion> findAllPosicions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPosicion(Posicion posicion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePosicion(Posicion posicion);
}