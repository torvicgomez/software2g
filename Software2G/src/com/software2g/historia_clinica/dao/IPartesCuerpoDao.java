package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Partescuerpo;

/**
 * The DAO interface for the Partescuerpo entity.
 */
public interface IPartesCuerpoDao {
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
	public Partescuerpo findPartescuerpoById(long id);
	/**
	 * Return all persistent instances of the <code>Partescuerpo</code> entity.
	 */
	public List<Partescuerpo> findAllPartescuerpos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartescuerpo(Partescuerpo partescuerpo);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartescuerpo(Partescuerpo partescuerpo);
}