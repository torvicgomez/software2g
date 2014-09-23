package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Acudiente;

/**
 * The DAO interface for the Acudiente entity.
 */
public interface IAcudienteDao {
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
	public Acudiente findAcudienteById(long id);
	/**
	 * Return all persistent instances of the <code>Acudiente</code> entity.
	 */
	public List<Acudiente> findAllAcudientes();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAcudiente(Acudiente acudiente);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAcudiente(Acudiente acudiente);
}