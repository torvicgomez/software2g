package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Parametroscalendario;

/**
 * The DAO interface for the Parametroscalendario entity.
 */
public interface IParametroCalendarioDao {
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
	public Parametroscalendario findParametroscalendarioById(long id);
	/**
	 * Return all persistent instances of the <code>Parametroscalendario</code> entity.
	 */
	public List<Parametroscalendario> findAllParametroscalendarios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParametroscalendario(Parametroscalendario parametroscalendario);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParametroscalendario(Parametroscalendario parametroscalendario);
}