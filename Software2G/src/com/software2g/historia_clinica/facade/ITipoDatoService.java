package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tipodato;

/**
 * The service interface for the Tipodato entity.
 */
public interface ITipoDatoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipodato findTipodatoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipodato</code> entity.
	 */
	public List<Tipodato> findAllTipodatos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodato(Tipodato tipodato) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodato(Tipodato tipodato) throws Exception;
	/**
	 * Service method for named queries
	 */
}