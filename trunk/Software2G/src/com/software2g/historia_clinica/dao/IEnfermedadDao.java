package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Enfermedad;

/**
 * The DAO interface for the Enfermedad entity.
 */
public interface IEnfermedadDao {
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
	public Enfermedad findEnfermedadById(long id);
	/**
	 * Return all persistent instances of the <code>Enfermedad</code> entity.
	 */
	public List<Enfermedad> findAllEnfermedads();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEnfermedad(Enfermedad enfermedad);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEnfermedad(Enfermedad enfermedad);
}