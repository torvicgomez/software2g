package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Formapago;

/**
 * The DAO interface for the Formapago entity.
 */
public interface IFormaPagoDao {
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
	public Formapago findFormapagoById(long id);
	/**
	 * Return all persistent instances of the <code>Formapago</code> entity.
	 */
	public List<Formapago> findAllFormapagos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormapago(Formapago formapago);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormapago(Formapago formapago);
}