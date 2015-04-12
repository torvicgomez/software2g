package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Servicio;

/**
 * The DAO interface for the Servicio entity.
 */
public interface IServicioDao {
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
	public Servicio findServicioById(long id);
	/**
	 * Return all persistent instances of the <code>Servicio</code> entity.
	 */
	public List<Servicio> findAllServicios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistServicio(Servicio servicio);
	public long persistServicioId(Servicio servicio);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeServicio(Servicio servicio);
}