package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Donacion;

/**
 * The DAO interface for the Donacion entity.
 */
public interface IDonacionDao {
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
	public Donacion findDonacionById(long id);
	/**
	 * Return all persistent instances of the <code>Donacion</code> entity.
	 */
	public List<Donacion> findAllDonacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDonacion(Donacion donacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacion(Donacion donacion);
	public Donacion findIdDonacion(String fecha, String hora);
	public List<Donacion> findDonacionIdEntidad(long idEntidad);
}