package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Partescuerpo;

/**
 * The service interface for the Partescuerpo entity.
 */
public interface IPartesCuerpoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Partescuerpo findPartescuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Partescuerpo</code> entity.
	 */
	public List<Partescuerpo> findAllPartescuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartescuerpo(Partescuerpo partescuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartescuerpo(Partescuerpo partescuerpo) throws Exception;
	/**
	 * Service method for named queries
	 */
}