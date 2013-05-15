package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Rol;

/**
 * The DAO interface for the Rol entity.
 */
public interface IRolDao {
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
	public Rol findRolById(java.lang.Integer id);
	/**
	 * Return all persistent instances of the <code>Rol</code> entity.
	 */
	public List<Rol> findAllRols();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRol(Rol rol);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRol(Rol rol);
}