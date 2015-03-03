package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tiposegmento;

/**
 * The DAO interface for the Tiposegmento entity.
 */
public interface ITipoSegmentoDao {
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
	public Tiposegmento findTiposegmentoById(long id);
	/**
	 * Return all persistent instances of the <code>Tiposegmento</code> entity.
	 */
	public List<Tiposegmento> findAllTiposegmentos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposegmento(Tiposegmento tiposegmento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposegmento(Tiposegmento tiposegmento);
}