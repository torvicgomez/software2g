package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Ubicaciondireccion;

/**
 * The service interface for the Ubicaciondireccion entity.
 */
public interface IUbicacionDireccionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ubicaciondireccion findUbicaciondireccionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ubicaciondireccion</code> entity.
	 */
	public List<Ubicaciondireccion> findAllUbicaciondireccions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception;
	/**
	 * Service method for named queries
	 */
}