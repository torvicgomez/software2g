package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Categoria;

/**
 * The DAO interface for the Categoria entity.
 */
public interface ICategoriaDao {
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
	public Categoria findCategoriaById(long id);
	/**
	 * Return all persistent instances of the <code>Categoria</code> entity.
	 */
	public List<Categoria> findAllCategorias();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCategoria(Categoria categoria);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCategoria(Categoria categoria);
}