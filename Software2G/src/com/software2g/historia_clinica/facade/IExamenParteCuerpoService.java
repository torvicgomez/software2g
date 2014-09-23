package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Examenpartecuerpo;

/**
 * The service interface for the Examenpartecuerpo entity.
 */
public interface IExamenParteCuerpoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Examenpartecuerpo findExamenpartecuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Examenpartecuerpo</code> entity.
	 */
	public List<Examenpartecuerpo> findAllExamenpartecuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception;
	/**
	 * Service method for named queries
	 */
}