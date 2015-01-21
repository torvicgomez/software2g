package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Persona;

/**
 * The DAO interface for the Persona entity.
 */
public interface IPersonaDao {
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
	public Persona findPersonaById(java.lang.Long id);
	/**
	 * Return all persistent instances of the <code>Persona</code> entity.
	 */
	public List<Persona> findAllPersonas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersona(Persona persona);
	public long persistPersonaId(Persona persona);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersona(Persona persona);
	
	public List<Persona> findAllPersonas(String datoFind, String tipoFind);
	public List<Persona> findAllPersonas(String datoFind);
	public List<Persona> findAllPersonasProfesionales(String datoFind);
}