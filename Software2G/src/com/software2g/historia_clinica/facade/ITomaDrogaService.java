package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tomasinodroga;

/**
 * The service interface for the Tomasinodroga entity.
 */
public interface ITomaDrogaService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tomasinodroga findTomasinodrogaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tomasinodroga</code> entity.
	 */
	public List<Tomasinodroga> findAllTomasinodrogas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTomasinodroga(Tomasinodroga tomasinodroga) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTomasinodroga(Tomasinodroga tomasinodroga) throws Exception;
	/**
	 * Service method for named queries
	 */
}