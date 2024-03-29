package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Registroodontograma;

/**
 * The DAO interface for the Registroodontograma entity.
 */
public interface IRegistroOdontogramaDao {
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
	public Registroodontograma findRegistroodontogramaById(long id);
	/**
	 * Return all persistent instances of the <code>Registroodontograma</code> entity.
	 */
	public List<Registroodontograma> findAllRegistroodontogramas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroodontograma(Registroodontograma registroodontograma);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroodontograma(Registroodontograma registroodontograma);
}