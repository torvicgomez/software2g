package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Telefono;

/**
 * The DAO interface for the Telefono entity.
 */
public interface ITelefonoDao {
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
	public Telefono findTelefonoById(long id);
	/**
	 * Return all persistent instances of the <code>Telefono</code> entity.
	 */
	public List<Telefono> findAllTelefonos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTelefono(Telefono telefono);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTelefono(Telefono telefono);
}