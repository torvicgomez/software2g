package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Detalleventa;

/**
 * The DAO interface for the Detalleventa entity.
 */
public interface IDetalleVentaDao {
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
	public Detalleventa findDetalleventaById(com.software2g.vo.DetalleventaPK id);
	/**
	 * Return all persistent instances of the <code>Detalleventa</code> entity.
	 */
	public List<Detalleventa> findAllDetalleventas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDetalleventa(Detalleventa detalleventa);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetalleventa(Detalleventa detalleventa);
}