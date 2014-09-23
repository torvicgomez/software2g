package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Formulacion;

/**
 * The service interface for the Formulacion entity.
 */
public interface IFormulacionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Formulacion findFormulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Formulacion</code> entity.
	 */
	public List<Formulacion> findAllFormulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormulacion(Formulacion formulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormulacion(Formulacion formulacion) throws Exception;
	/**
	 * Service method for named queries
	 */
}