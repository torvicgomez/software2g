package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Registrorxuso;

/**
 * The DAO interface for the Registrorxuso entity.
 */
public interface IRegistroRxUsoDao {
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
	public Registrorxuso findRegistrorxusoById(long id);
	/**
	 * Return all persistent instances of the <code>Registrorxuso</code> entity.
	 */
	public List<Registrorxuso> findAllRegistrorxusos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistrorxuso(Registrorxuso registrorxuso);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrorxuso(Registrorxuso registrorxuso);
}