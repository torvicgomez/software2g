package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Ubicaciontelefono;

/**
 * The service interface for the Ubicaciontelefono entity.
 */
public interface IUbicacionTelefonoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ubicaciontelefono findUbicaciontelefonoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ubicaciontelefono</code> entity.
	 */
	public List<Ubicaciontelefono> findAllUbicaciontelefonos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception;
	/**
	 * Service method for named queries
	 */
}