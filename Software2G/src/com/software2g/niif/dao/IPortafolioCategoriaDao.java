package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Portafoliocategoria;

/**
 * The DAO interface for the Portafoliocategoria entity.
 */
public interface IPortafolioCategoriaDao {
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
	public Portafoliocategoria findPortafoliocategoriaById(long id);
	/**
	 * Return all persistent instances of the <code>Portafoliocategoria</code> entity.
	 */
	public List<Portafoliocategoria> findAllPortafoliocategorias();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPortafoliocategoria(Portafoliocategoria portafoliocategoria);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafoliocategoria(Portafoliocategoria portafoliocategoria);
}