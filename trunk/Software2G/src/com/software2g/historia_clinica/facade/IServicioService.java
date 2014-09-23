package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Servicio;

/**
 * The service interface for the Servicio entity.
 */
public interface IServicioService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Servicio findServicioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Servicio</code> entity.
	 */
	public List<Servicio> findAllServicios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistServicio(Servicio servicio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeServicio(Servicio servicio) throws Exception;
	/**
	 * Service method for named queries
	 */
}