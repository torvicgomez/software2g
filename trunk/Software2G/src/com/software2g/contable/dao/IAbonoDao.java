package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Abono;

/**
 * The DAO interface for the Abono entity.
 */
public interface IAbonoDao {
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
	public Abono findAbonoById(long id);
	/**
	 * Return all persistent instances of the <code>Abono</code> entity.
	 */
	public List<Abono> findAllAbonos();
	
	public List<Abono> findAllAbonos(long idCredito);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAbono(Abono abono);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAbono(Abono abono);
}