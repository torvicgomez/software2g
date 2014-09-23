package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Variableformulacion;

/**
 * The service interface for the Variableformulacion entity.
 */
public interface IVariableFormulacionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Variableformulacion findVariableformulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Variableformulacion</code> entity.
	 */
	public List<Variableformulacion> findAllVariableformulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableformulacion(Variableformulacion variableformulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableformulacion(Variableformulacion variableformulacion) throws Exception;
	/**
	 * Service method for named queries
	 */
}