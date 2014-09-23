package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Antecesentesflia;

/**
 * The DAO interface for the Antecesentesflia entity.
 */
public interface IAntecedentesFliaDao {
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
	public Antecesentesflia findAntecesentesfliaById(long id);
	/**
	 * Return all persistent instances of the <code>Antecesentesflia</code> entity.
	 */
	public List<Antecesentesflia> findAllAntecesentesflias();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAntecesentesflia(Antecesentesflia antecesentesflia);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAntecesentesflia(Antecesentesflia antecesentesflia);
}