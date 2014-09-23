package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Variableexamen;

/**
 * The DAO interface for the Variableexamen entity.
 */
public interface IVariableExamenDao {
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
	public Variableexamen findVariableexamenById(long id);
	/**
	 * Return all persistent instances of the <code>Variableexamen</code> entity.
	 */
	public List<Variableexamen> findAllVariableexamens();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableexamen(Variableexamen variableexamen);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableexamen(Variableexamen variableexamen);
}