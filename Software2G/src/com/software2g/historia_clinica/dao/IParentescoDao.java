package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Parentesco;

/**
 * The DAO interface for the Parentesco entity.
 */
public interface IParentescoDao {
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
	public Parentesco findParentescoById(long id);
	/**
	 * Return all persistent instances of the <code>Parentesco</code> entity.
	 */
	public List<Parentesco> findAllParentescos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParentesco(Parentesco parentesco);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParentesco(Parentesco parentesco);
}