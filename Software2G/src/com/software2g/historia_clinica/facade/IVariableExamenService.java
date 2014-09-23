package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Variableexamen;

/**
 * The service interface for the Variableexamen entity.
 */
public interface IVariableExamenService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Variableexamen findVariableexamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Variableexamen</code> entity.
	 */
	public List<Variableexamen> findAllVariableexamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableexamen(Variableexamen variableexamen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableexamen(Variableexamen variableexamen) throws Exception;
	/**
	 * Service method for named queries
	 */
}