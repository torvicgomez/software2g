package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tipovirtuallink;

/**
 * The service interface for the Tipovirtuallink entity.
 */
public interface ITipoVirtualLinkService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipovirtuallink findTipovirtuallinkById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipovirtuallink</code> entity.
	 */
	public List<Tipovirtuallink> findAllTipovirtuallinks() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception;
	/**
	 * Service method for named queries
	 */
}