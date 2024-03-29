package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Articulo;

/**
 * The DAO interface for the Articulo entity.
 */
public interface IArticuloDao {
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
	public Articulo findArticuloById(long id);
	/**
	 * Return all persistent instances of the <code>Articulo</code> entity.
	 */
	public List<Articulo> findAllArticulos();
	public List<Articulo> findAllArticulos(String datoFind);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArticulo(Articulo articulo);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArticulo(Articulo articulo);
}