package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Variableformulacion;

/**
 * The DAO interface for the Variableformulacion entity.
 */
public interface IVariableFormulacionDao {
	/**
	 * Return the persistent entities returned from a named query.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName);
	/**
	 * Return the persistent entities returned from a named query with named parameters.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName, String[] paramNames, Object[] paramValues);
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Variableformulacion findVariableformulacionById(long id);
	/**
	 * Return all persistent instances of the <code>Variableformulacion</code> entity.
	 */
	public List<Variableformulacion> findAllVariableformulacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableformulacion(Variableformulacion variableformulacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableformulacion(Variableformulacion variableformulacion);
}