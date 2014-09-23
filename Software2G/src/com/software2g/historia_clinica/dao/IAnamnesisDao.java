package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Anamnesi;

/**
 * The DAO interface for the Anamnesi entity.
 */
public interface IAnamnesisDao {
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
	public Anamnesi findAnamnesiById(long id);
	/**
	 * Return all persistent instances of the <code>Anamnesi</code> entity.
	 */
	public List<Anamnesi> findAllAnamnesis();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAnamnesi(Anamnesi anamnesi);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAnamnesi(Anamnesi anamnesi);
}