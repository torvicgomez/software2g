package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Virtuallink;

/**
 * The DAO interface for the Virtuallink entity.
 */
public interface IVirtualLinkDao {
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
	public Virtuallink findVirtuallinkById(long id);
	/**
	 * Return all persistent instances of the <code>Virtuallink</code> entity.
	 */
	public List<Virtuallink> findAllVirtuallinks();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVirtuallink(Virtuallink virtuallink);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVirtuallink(Virtuallink virtuallink);
}