package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Archivoservicio;

/**
 * The DAO interface for the Archivoservicio entity.
 */
public interface IArchivoServicioDao {
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
	public Archivoservicio findArchivoservicioById(long id);
	/**
	 * Return all persistent instances of the <code>Archivoservicio</code> entity.
	 */
	public List<Archivoservicio> findAllArchivoservicios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArchivoservicio(Archivoservicio archivoservicio);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivoservicio(Archivoservicio archivoservicio);
}