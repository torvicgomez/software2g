package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Direccion;

/**
 * The DAO interface for the Direccion entity.
 */
public interface IDireccionDao {
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
	public Direccion findDireccionById(long id);
	/**
	 * Return all persistent instances of the <code>Direccion</code> entity.
	 */
	public List<Direccion> findAllDireccions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDireccion(Direccion direccion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDireccion(Direccion direccion);
}