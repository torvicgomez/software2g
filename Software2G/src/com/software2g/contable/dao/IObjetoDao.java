package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Objeto;

/**
 * The DAO interface for the Objeto entity.
 */
public interface IObjetoDao {
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
	public Objeto findObjetoById(long id);
	/**
	 * Return all persistent instances of the <code>Objeto</code> entity.
	 */
	public List<Objeto> findAllObjetos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistObjeto(Objeto objeto);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeObjeto(Objeto objeto);
}