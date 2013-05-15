package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Tipodescuento;

/**
 * The DAO interface for the Tipodescuento entity.
 */
public interface ITipoDescuentoDao {
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
	public Tipodescuento findTipodescuentoById(long id);
	/**
	 * Return all persistent instances of the <code>Tipodescuento</code> entity.
	 */
	public List<Tipodescuento> findAllTipodescuentos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodescuento(Tipodescuento tipodescuento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodescuento(Tipodescuento tipodescuento);
}