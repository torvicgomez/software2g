package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Venta;

/**
 * The DAO interface for the Venta entity.
 */
public interface IVentaDao {
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
	public Venta findVentaById(long id);
	/**
	 * Return all persistent instances of the <code>Venta</code> entity.
	 */
	public List<Venta> findAllVentas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVenta(Venta venta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVenta(Venta venta);
}