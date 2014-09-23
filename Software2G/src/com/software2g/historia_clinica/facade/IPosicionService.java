package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Posicion;

/**
 * The service interface for the Posicion entity.
 */
public interface IPosicionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Posicion findPosicionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Posicion</code> entity.
	 */
	public List<Posicion> findAllPosicions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPosicion(Posicion posicion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePosicion(Posicion posicion) throws Exception;
	/**
	 * Service method for named queries
	 */
}