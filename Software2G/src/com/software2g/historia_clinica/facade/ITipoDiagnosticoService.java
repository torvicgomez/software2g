package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tipodiagnostico;

/**
 * The service interface for the Tipodiagnostico entity.
 */
public interface ITipoDiagnosticoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipodiagnostico findTipodiagnosticoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipodiagnostico</code> entity.
	 */
	public List<Tipodiagnostico> findAllTipodiagnosticos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception;
	/**
	 * Service method for named queries
	 */
}