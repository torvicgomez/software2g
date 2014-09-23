package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Especificacionformula;

/**
 * The DAO interface for the Especificacionformula entity.
 */
public interface IEspecificacionFormulaDao {
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
	public Especificacionformula findEspecificacionformulaById(long id);
	/**
	 * Return all persistent instances of the <code>Especificacionformula</code> entity.
	 */
	public List<Especificacionformula> findAllEspecificacionformulas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionformula(Especificacionformula especificacionformula);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionformula(Especificacionformula especificacionformula);
}