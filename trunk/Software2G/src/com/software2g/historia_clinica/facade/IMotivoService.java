package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Motivo;

/**
 * The service interface for the Motivo entity.
 */
public interface IMotivoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Motivo findMotivoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Motivo</code> entity.
	 */
	public List<Motivo> findAllMotivos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMotivo(Motivo motivo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMotivo(Motivo motivo) throws Exception;
	/**
	 * Service method for named queries
	 */
}