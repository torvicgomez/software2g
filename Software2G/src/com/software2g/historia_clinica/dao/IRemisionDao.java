package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Remision;

/**
 * The DAO interface for the Remision entity.
 */
public interface IRemisionDao {
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
	public Remision findRemisionById(long id);
	/**
	 * Return all persistent instances of the <code>Remision</code> entity.
	 */
	public List<Remision> findAllRemisions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRemision(Remision remision);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRemision(Remision remision);
}