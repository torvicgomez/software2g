package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Presupuestodonacion;

/**
 * The DAO interface for the Presupuestodonacion entity.
 */
public interface IPresupuestoDonacionDao {
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
	public Presupuestodonacion findPresupuestodonacionById(com.software2g.vo.PresupuestodonacionPK id);
	/**
	 * Return all persistent instances of the <code>Presupuestodonacion</code> entity.
	 */
	public List<Presupuestodonacion> findAllPresupuestodonacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPresupuestodonacion(Presupuestodonacion presupuestodonacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuestodonacion(Presupuestodonacion presupuestodonacion);
	
	public List<Presupuestodonacion> findAllPresupuestodonacions(long forengKey, int tipo);
}