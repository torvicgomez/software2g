package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Seguridadsocial;

/**
 * The service interface for the Seguridadsocial entity.
 */
public interface ISeguridadSocialService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Seguridadsocial findSeguridadsocialById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Seguridadsocial</code> entity.
	 */
	public List<Seguridadsocial> findAllSeguridadsocials() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception;
	/**
	 * Service method for named queries
	 */
}