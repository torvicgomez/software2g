package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tomasinodroga;

/**
 * The DAO interface for the Tomasinodroga entity.
 */
public interface ITomaDrogaDao {
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
	public Tomasinodroga findTomasinodrogaById(long id);
	/**
	 * Return all persistent instances of the <code>Tomasinodroga</code> entity.
	 */
	public List<Tomasinodroga> findAllTomasinodrogas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTomasinodroga(Tomasinodroga tomasinodroga);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTomasinodroga(Tomasinodroga tomasinodroga);
}