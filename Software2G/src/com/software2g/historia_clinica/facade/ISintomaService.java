package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Sintoma;

/**
 * The service interface for the Sintoma entity.
 */
public interface ISintomaService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Sintoma findSintomaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Sintoma</code> entity.
	 */
	public List<Sintoma> findAllSintomas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintoma(Sintoma sintoma) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintoma(Sintoma sintoma) throws Exception;
	/**
	 * Service method for named queries
	 */
}