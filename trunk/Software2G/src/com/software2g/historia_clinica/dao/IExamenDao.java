package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Examen;

/**
 * The DAO interface for the Examen entity.
 */
public interface IExamenDao {
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
	public Examen findExamenById(long id);
	/**
	 * Return all persistent instances of the <code>Examen</code> entity.
	 */
	public List<Examen> findAllExamens();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamen(Examen examen);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamen(Examen examen);
}