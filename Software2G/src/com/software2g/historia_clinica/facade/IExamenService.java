package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Examen;

/**
 * The service interface for the Examen entity.
 */
public interface IExamenService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Examen findExamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Examen</code> entity.
	 */
	public List<Examen> findAllExamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamen(Examen examen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamen(Examen examen) throws Exception;
	/**
	 * Service method for named queries
	 */
}