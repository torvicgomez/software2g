package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Especificaexamen;

/**
 * The service interface for the Especificaexamen entity.
 */
public interface IEspecificaExamenService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Especificaexamen findEspecificaexamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Especificaexamen</code> entity.
	 */
	public List<Especificaexamen> findAllEspecificaexamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificaexamen(Especificaexamen especificaexamen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificaexamen(Especificaexamen especificaexamen) throws Exception;
	/**
	 * Service method for named queries
	 */
}