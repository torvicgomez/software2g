package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Detallecompra;

/**
 * The DAO interface for the Detallecompra entity.
 */
public interface IDetalleCompraDao {
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
	public Detallecompra findDetallecompraById(com.software2g.vo.DetallecompraPK id);
	/**
	 * Return all persistent instances of the <code>Detallecompra</code> entity.
	 */
	public List<Detallecompra> findAllDetallecompras();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDetallecompra(Detallecompra detallecompra);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetallecompra(Detallecompra detallecompra);
}