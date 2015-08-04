package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Ordencompra;

/**
 * The DAO interface for the Ordencompra entity.
 */
public interface IOrdenCompraDao {
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
	public Ordencompra findOrdencompraById(long id);
	/**
	 * Return all persistent instances of the <code>Ordencompra</code> entity.
	 */
	public List<Ordencompra> findAllOrdencompras();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOrdencompra(Ordencompra ordencompra);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOrdencompra(Ordencompra ordencompra);
}