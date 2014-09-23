package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Virtuallink;

/**
 * The service interface for the Virtuallink entity.
 */
public interface IVirtualLinkService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Virtuallink findVirtuallinkById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Virtuallink</code> entity.
	 */
	public List<Virtuallink> findAllVirtuallinks() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVirtuallink(Virtuallink virtuallink) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVirtuallink(Virtuallink virtuallink) throws Exception;
	/**
	 * Service method for named queries
	 */
}