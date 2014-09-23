package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Estadocivil;

/**
 * The DAO interface for the Estadocivil entity.
 */
public interface IEstadoCivilDao {
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
	public Estadocivil findEstadocivilById(long id);
	/**
	 * Return all persistent instances of the <code>Estadocivil</code> entity.
	 */
	public List<Estadocivil> findAllEstadocivils();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadocivil(Estadocivil estadocivil);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadocivil(Estadocivil estadocivil);
}