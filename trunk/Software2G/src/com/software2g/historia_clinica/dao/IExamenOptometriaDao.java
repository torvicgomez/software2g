package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Examenoptometria;

/**
 * The DAO interface for the Examenoptometria entity.
 */
public interface IExamenOptometriaDao {
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
	public Examenoptometria findExamenoptometriaById(long id);
	/**
	 * Return all persistent instances of the <code>Examenoptometria</code> entity.
	 */
	public List<Examenoptometria> findAllExamenoptometrias();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenoptometria(Examenoptometria examenoptometria);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenoptometria(Examenoptometria examenoptometria);
}