package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Presupuestosucursal;

/**
 * The DAO interface for the Presupuestosucursal entity.
 */
public interface IPresupuestoSucursalDao {
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
	public Presupuestosucursal findPresupuestosucursalById(long id);
	/**
	 * Return all persistent instances of the <code>Presupuestosucursal</code> entity.
	 */
	public List<Presupuestosucursal> findAllPresupuestosucursals();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPresupuestosucursal(Presupuestosucursal presupuestosucursal);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuestosucursal(Presupuestosucursal presupuestosucursal);
}