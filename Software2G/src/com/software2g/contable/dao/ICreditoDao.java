package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Credito;

/**
 * The DAO interface for the Credito entity.
 */
public interface ICreditoDao {
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
	public Credito findCreditoById(long id);
	/**
	 * Return all persistent instances of the <code>Credito</code> entity.
	 */
	public List<Credito> findAllCreditos();
	public List<Credito> findAllCreditosXCliente(String documentoPers, Integer idTipoDoc);
	public Credito findCreditosXPagare(long idPagare);
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCredito(Credito credito);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCredito(Credito credito);
}