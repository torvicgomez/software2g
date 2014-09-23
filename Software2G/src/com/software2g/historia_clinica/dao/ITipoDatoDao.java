package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipodato;

/**
 * The DAO interface for the Tipodato entity.
 */
public interface ITipoDatoDao {
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
	public Tipodato findTipodatoById(long id);
	/**
	 * Return all persistent instances of the <code>Tipodato</code> entity.
	 */
	public List<Tipodato> findAllTipodatos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodato(Tipodato tipodato);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodato(Tipodato tipodato);
}