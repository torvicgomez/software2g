package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Examenpartecuerpo;

/**
 * The DAO interface for the Examenpartecuerpo entity.
 */
public interface IExamenParteCuerpoDao {
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
	public Examenpartecuerpo findExamenpartecuerpoById(long id);
	/**
	 * Return all persistent instances of the <code>Examenpartecuerpo</code> entity.
	 */
	public List<Examenpartecuerpo> findAllExamenpartecuerpos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo);
}