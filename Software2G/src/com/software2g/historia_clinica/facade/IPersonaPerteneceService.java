package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Personapertenece;

/**
 * The service interface for the Personapertenece entity.
 */
public interface IPersonaPerteneceService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Personapertenece findPersonaperteneceById(com.software2g.vo.PersonapertenecePK id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Personapertenece</code> entity.
	 */
	public List<Personapertenece> findAllPersonaperteneces() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonapertenece(Personapertenece personapertenece) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonapertenece(Personapertenece personapertenece) throws Exception;
	/**
	 * Service method for named queries
	 */
}