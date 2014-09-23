package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Registroformulacion;

/**
 * The service interface for the Registroformulacion entity.
 */
public interface IRegistroFormulacionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroformulacion findRegistroformulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroformulacion</code> entity.
	 */
	public List<Registroformulacion> findAllRegistroformulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroformulacion(Registroformulacion registroformulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroformulacion(Registroformulacion registroformulacion) throws Exception;
	/**
	 * Service method for named queries
	 */
}