package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Creditotipodescuento;

/**
 * The DAO interface for the Creditotipodescuento entity.
 */
public interface ICreditoTipoDescuentoDao {
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
	public Creditotipodescuento findCreditotipodescuentoById(com.software2g.vo.CreditotipodescuentoPK id);
	/**
	 * Return all persistent instances of the <code>Creditotipodescuento</code> entity.
	 */
	public List<Creditotipodescuento> findAllCreditotipodescuentos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCreditotipodescuento(Creditotipodescuento creditotipodescuento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCreditotipodescuento(Creditotipodescuento creditotipodescuento);
}