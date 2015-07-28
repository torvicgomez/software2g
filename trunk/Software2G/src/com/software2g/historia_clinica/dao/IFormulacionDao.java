package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Formulacion;

/**
 * The DAO interface for the Formulacion entity.
 */
public interface IFormulacionDao {
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
	public Formulacion findFormulacionById(long id);
	/**
	 * Return all persistent instances of the <code>Formulacion</code> entity.
	 */
	public List<Formulacion> findAllFormulacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormulacion(Formulacion formulacion);
	public long persistFormulacionId(Formulacion formulacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormulacion(Formulacion formulacion);
}