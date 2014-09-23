package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Frecuencia;

/**
 * The DAO interface for the Frecuencia entity.
 */
public interface IFrecuenciaDao {
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
	public Frecuencia findFrecuenciaById(long id);
	/**
	 * Return all persistent instances of the <code>Frecuencia</code> entity.
	 */
	public List<Frecuencia> findAllFrecuencias();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFrecuencia(Frecuencia frecuencia);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFrecuencia(Frecuencia frecuencia);
}