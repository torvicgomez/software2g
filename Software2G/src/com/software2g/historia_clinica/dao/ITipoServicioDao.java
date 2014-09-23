package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tiposervicio;

/**
 * The DAO interface for the Tiposervicio entity.
 */
public interface ITipoServicioDao {
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
	public Tiposervicio findTiposervicioById(long id);
	/**
	 * Return all persistent instances of the <code>Tiposervicio</code> entity.
	 */
	public List<Tiposervicio> findAllTiposervicios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposervicio(Tiposervicio tiposervicio);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposervicio(Tiposervicio tiposervicio);
}