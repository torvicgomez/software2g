package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Ubicacionvirtual;

/**
 * The DAO interface for the Ubicacionvirtual entity.
 */
public interface IUbicacionVirtualDao {
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
	public Ubicacionvirtual findUbicacionvirtualById(long id);
	/**
	 * Return all persistent instances of the <code>Ubicacionvirtual</code> entity.
	 */
	public List<Ubicacionvirtual> findAllUbicacionvirtuals();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicacionvirtual(Ubicacionvirtual ubicacionvirtual);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicacionvirtual(Ubicacionvirtual ubicacionvirtual);
}