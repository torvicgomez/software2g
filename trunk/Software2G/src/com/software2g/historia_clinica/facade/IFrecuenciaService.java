package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Frecuencia;

/**
 * The service interface for the Frecuencia entity.
 */
public interface IFrecuenciaService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Frecuencia findFrecuenciaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Frecuencia</code> entity.
	 */
	public List<Frecuencia> findAllFrecuencias() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFrecuencia(Frecuencia frecuencia) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFrecuencia(Frecuencia frecuencia) throws Exception;
	/**
	 * Service method for named queries
	 */
}