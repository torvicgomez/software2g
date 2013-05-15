package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Donacionobjeto;

/**
 * The DAO interface for the Donacionobjeto entity.
 */
public interface IDonacionObjetoDao {
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
	public Donacionobjeto findDonacionobjetoById(com.software2g.vo.DonacionobjetoPK id);
	/**
	 * Return all persistent instances of the <code>Donacionobjeto</code> entity.
	 */
	public List<Donacionobjeto> findAllDonacionobjetos();
	public List<Donacionobjeto> findAllDonacionobjetos(long idDona);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDonacionobjeto(Donacionobjeto donacionobjeto);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacionobjeto(Donacionobjeto donacionobjeto);
}