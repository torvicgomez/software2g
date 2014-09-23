package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tipoespecialidad;

/**
 * The service interface for the Tipoespecialidad entity.
 */
public interface ITipoEspecialidadService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipoespecialidad findTipoespecialidadById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoespecialidad</code> entity.
	 */
	public List<Tipoespecialidad> findAllTipoespecialidads() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception;
	/**
	 * Service method for named queries
	 */
}