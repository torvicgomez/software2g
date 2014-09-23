package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Ubicacionvirtual;

/**
 * The service interface for the Ubicacionvirtual entity.
 */
public interface IUbicacionVirtualService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ubicacionvirtual findUbicacionvirtualById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ubicacionvirtual</code> entity.
	 */
	public List<Ubicacionvirtual> findAllUbicacionvirtuals() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception;
	/**
	 * Service method for named queries
	 */
}