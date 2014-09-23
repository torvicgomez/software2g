package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tipoubicacion;

/**
 * The service interface for the Tipoubicacion entity.
 */
public interface ITipoUbicacionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipoubicacion findTipoubicacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoubicacion</code> entity.
	 */
	public List<Tipoubicacion> findAllTipoubicacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoubicacion(Tipoubicacion tipoubicacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoubicacion(Tipoubicacion tipoubicacion) throws Exception;
	/**
	 * Service method for named queries
	 */
}