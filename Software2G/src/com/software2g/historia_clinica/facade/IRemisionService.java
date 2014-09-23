package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Remision;

/**
 * The service interface for the Remision entity.
 */
public interface IRemisionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Remision findRemisionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Remision</code> entity.
	 */
	public List<Remision> findAllRemisions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRemision(Remision remision) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRemision(Remision remision) throws Exception;
	/**
	 * Service method for named queries
	 */
}