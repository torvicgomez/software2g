package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Sintoma;

/**
 * The DAO interface for the Sintoma entity.
 */
public interface ISintomaDao {
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
	public Sintoma findSintomaById(long id);
	/**
	 * Return all persistent instances of the <code>Sintoma</code> entity.
	 */
	public List<Sintoma> findAllSintomas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintoma(Sintoma sintoma);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintoma(Sintoma sintoma);
}