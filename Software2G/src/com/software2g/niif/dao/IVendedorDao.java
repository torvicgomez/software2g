package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Vendedor;

/**
 * The DAO interface for the Vendedor entity.
 */
public interface IVendedorDao {
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
	public Vendedor findVendedorById(long id);
	/**
	 * Return all persistent instances of the <code>Vendedor</code> entity.
	 */
	public List<Vendedor> findAllVendedors();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVendedor(Vendedor vendedor);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVendedor(Vendedor vendedor);
}