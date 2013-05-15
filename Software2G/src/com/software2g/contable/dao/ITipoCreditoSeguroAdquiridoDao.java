package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Tipocreditoseguroadquirido;

/**
 * The DAO interface for the Tipocreditoseguroadquirido entity.
 */
public interface ITipoCreditoSeguroAdquiridoDao {
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
	public Tipocreditoseguroadquirido findTipocreditoseguroadquiridoById(com.software2g.vo.TipocreditoseguroadquiridoPK id);
	/**
	 * Return all persistent instances of the <code>Tipocreditoseguroadquirido</code> entity.
	 */
	public List<Tipocreditoseguroadquirido> findAllTipocreditoseguroadquiridos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipocreditoseguroadquirido(Tipocreditoseguroadquirido tipocreditoseguroadquirido);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipocreditoseguroadquirido(Tipocreditoseguroadquirido tipocreditoseguroadquirido);
	public List<Tipocreditoseguroadquirido> findAllTipocreditoseguroadquiridos(long idTipoCredito);
}