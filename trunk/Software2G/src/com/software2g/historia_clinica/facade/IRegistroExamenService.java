package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Registroexamen;

/**
 * The service interface for the Registroexamen entity.
 */
public interface IRegistroExamenService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroexamen findRegistroexamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroexamen</code> entity.
	 */
	public List<Registroexamen> findAllRegistroexamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroexamen(Registroexamen registroexamen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroexamen(Registroexamen registroexamen) throws Exception;
	/**
	 * Service method for named queries
	 */
}