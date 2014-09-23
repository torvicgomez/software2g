package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Telefono;

/**
 * The service interface for the Telefono entity.
 */
public interface ITelefonoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Telefono findTelefonoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Telefono</code> entity.
	 */
	public List<Telefono> findAllTelefonos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTelefono(Telefono telefono) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTelefono(Telefono telefono) throws Exception;
	/**
	 * Service method for named queries
	 */
}