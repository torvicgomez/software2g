package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Pagare;

/**
 * The DAO interface for the Pagare entity.
 */
public interface IPagareDao {
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
	public Pagare findPagareById(long id);
	/**
	 * Return all persistent instances of the <code>Pagare</code> entity.
	 */
	public List<Pagare> findAllPagares();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPagare(Pagare pagare);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePagare(Pagare pagare);
	
	public List<Pagare> findAllTitularesCredito(String datoFind, String tipoFind);
	public String verificarPagosPagare(long idPagare);
}