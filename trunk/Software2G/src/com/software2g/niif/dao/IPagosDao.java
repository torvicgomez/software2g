package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Pago;

/**
 * The DAO interface for the Pago entity.
 */
public interface IPagosDao {
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
	public Pago findPagoById(long id);
	/**
	 * Return all persistent instances of the <code>Pago</code> entity.
	 */
	public List<Pago> findAllPagos();
	public List<Pago> findAllPagosVenta(long ventId);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPago(Pago pago);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePago(Pago pago);
}