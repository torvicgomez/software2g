package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Seccionodon;

/**
 * The DAO interface for the Seccionodon entity.
 */
public interface ISeccionOdonDao {
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
	public Seccionodon findSeccionodonById(long id);
	/**
	 * Return all persistent instances of the <code>Seccionodon</code> entity.
	 */
	public List<Seccionodon> findAllSeccionodons();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeccionodon(Seccionodon seccionodon);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeccionodon(Seccionodon seccionodon);
}