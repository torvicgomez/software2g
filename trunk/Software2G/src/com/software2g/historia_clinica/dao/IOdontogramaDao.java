package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Odontograma;

/**
 * The DAO interface for the Odontograma entity.
 */
public interface IOdontogramaDao {
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
	public Odontograma findOdontogramaById(long id);
	/**
	 * Return all persistent instances of the <code>Odontograma</code> entity.
	 */
	public List<Odontograma> findAllOdontogramas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOdontograma(Odontograma odontograma);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOdontograma(Odontograma odontograma);
}