package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Registrocovertest;

/**
 * The DAO interface for the Registrocovertest entity.
 */
public interface IRegistroCoverTestDao {
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
	public Registrocovertest findRegistrocovertestById(long id);
	/**
	 * Return all persistent instances of the <code>Registrocovertest</code> entity.
	 */
	public List<Registrocovertest> findAllRegistrocovertests();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistrocovertest(Registrocovertest registrocovertest);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrocovertest(Registrocovertest registrocovertest);
}