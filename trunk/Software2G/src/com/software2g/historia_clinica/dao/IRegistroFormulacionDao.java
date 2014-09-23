package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Registroformulacion;

/**
 * The DAO interface for the Registroformulacion entity.
 */
public interface IRegistroFormulacionDao {
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
	public Registroformulacion findRegistroformulacionById(long id);
	/**
	 * Return all persistent instances of the <code>Registroformulacion</code> entity.
	 */
	public List<Registroformulacion> findAllRegistroformulacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroformulacion(Registroformulacion registroformulacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroformulacion(Registroformulacion registroformulacion);
}