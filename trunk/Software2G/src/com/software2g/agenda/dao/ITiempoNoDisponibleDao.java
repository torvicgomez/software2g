package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Tiemponodisponible;

/**
 * The DAO interface for the Tiemponodisponible entity.
 */
public interface ITiempoNoDisponibleDao {
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
	public Tiemponodisponible findTiemponodisponibleById(long id);
	/**
	 * Return all persistent instances of the <code>Tiemponodisponible</code> entity.
	 */
	public List<Tiemponodisponible> findAllTiemponodisponibles();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiemponodisponible(Tiemponodisponible tiemponodisponible);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiemponodisponible(Tiemponodisponible tiemponodisponible);
}