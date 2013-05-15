package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Personainstitucion;

/**
 * The DAO interface for the Personainstitucion entity.
 */
public interface IPersonaInstitucionDao {
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
	public Personainstitucion findPersonainstitucionById(com.software2g.vo.PersonainstitucionPK id);
	/**
	 * Return all persistent instances of the <code>Personainstitucion</code> entity.
	 */
	public List<Personainstitucion> findAllPersonainstitucions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonainstitucion(Personainstitucion personainstitucion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonainstitucion(Personainstitucion personainstitucion);
}