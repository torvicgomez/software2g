package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Personapertenece;

/**
 * The DAO interface for the Personapertenece entity.
 */
public interface IPersonaPerteneceDao {
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
	public Personapertenece findPersonaperteneceById(com.software2g.vo.PersonapertenecePK id);
	/**
	 * Return all persistent instances of the <code>Personapertenece</code> entity.
	 */
	public List<Personapertenece> findAllPersonaperteneces();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonapertenece(Personapertenece personapertenece);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonapertenece(Personapertenece personapertenece);
}