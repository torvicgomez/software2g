package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Sucursal;

/**
 * The DAO interface for the Sucursal entity.
 */
public interface ISucursalDao {
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
	public Sucursal findSucursalById(long id);
	/**
	 * Return all persistent instances of the <code>Sucursal</code> entity.
	 */
	public List<Sucursal> findAllSucursals();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSucursal(Sucursal sucursal);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSucursal(Sucursal sucursal);
}