package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Especificaexamen;

/**
 * The DAO interface for the Especificaexamen entity.
 */
public interface IEspecificaExamenDao {
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
	public Especificaexamen findEspecificaexamenById(long id);
	/**
	 * Return all persistent instances of the <code>Especificaexamen</code> entity.
	 */
	public List<Especificaexamen> findAllEspecificaexamens();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificaexamen(Especificaexamen especificaexamen);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificaexamen(Especificaexamen especificaexamen);
}