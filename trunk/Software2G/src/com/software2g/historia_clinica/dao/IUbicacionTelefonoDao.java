package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Ubicaciontelefono;

/**
 * The DAO interface for the Ubicaciontelefono entity.
 */
public interface IUbicacionTelefonoDao {
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
	public Ubicaciontelefono findUbicaciontelefonoById(long id);
	/**
	 * Return all persistent instances of the <code>Ubicaciontelefono</code> entity.
	 */
	public List<Ubicaciontelefono> findAllUbicaciontelefonos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciontelefono(Ubicaciontelefono ubicaciontelefono);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciontelefono(Ubicaciontelefono ubicaciontelefono);
}