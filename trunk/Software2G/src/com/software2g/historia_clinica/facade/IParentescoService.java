package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Parentesco;

/**
 * The service interface for the Parentesco entity.
 */
public interface IParentescoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Parentesco findParentescoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Parentesco</code> entity.
	 */
	public List<Parentesco> findAllParentescos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParentesco(Parentesco parentesco) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParentesco(Parentesco parentesco) throws Exception;
	/**
	 * Service method for named queries
	 */
}