package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Presupuesto;

/**
 * The DAO interface for the Presupuesto entity.
 */
public interface IPresupuestoDao {
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
	public Presupuesto findPresupuestoById(long id);
	/**
	 * Return all persistent instances of the <code>Presupuesto</code> entity.
	 */
	public List<Presupuesto> findAllPresupuestos();
	public Presupuesto findPresupuestos(String fecha, String hora);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPresupuesto(Presupuesto presupuesto);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuesto(Presupuesto presupuesto);
}