package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Sintomacomun;

/**
 * The service interface for the Sintomacomun entity.
 */
public interface ISintomaComunService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Sintomacomun findSintomacomunById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Sintomacomun</code> entity.
	 */
	public List<Sintomacomun> findAllSintomacomuns() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintomacomun(Sintomacomun sintomacomun) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintomacomun(Sintomacomun sintomacomun) throws Exception;
	/**
	 * Service method for named queries
	 */
}