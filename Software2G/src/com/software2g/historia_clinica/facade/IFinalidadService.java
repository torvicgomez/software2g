package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Finalidad;

/**
 * The service interface for the Finalidad entity.
 */
public interface IFinalidadService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Finalidad findFinalidadById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Finalidad</code> entity.
	 */
	public List<Finalidad> findAllFinalidads() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFinalidad(Finalidad finalidad) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFinalidad(Finalidad finalidad) throws Exception;
	/**
	 * Service method for named queries
	 */
}