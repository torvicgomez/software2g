package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tiposervicio;

/**
 * The service interface for the Tiposervicio entity.
 */
public interface ITipoServicioService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tiposervicio findTiposervicioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tiposervicio</code> entity.
	 */
	public List<Tiposervicio> findAllTiposervicios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposervicio(Tiposervicio tiposervicio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposervicio(Tiposervicio tiposervicio) throws Exception;
	/**
	 * Service method for named queries
	 */
}