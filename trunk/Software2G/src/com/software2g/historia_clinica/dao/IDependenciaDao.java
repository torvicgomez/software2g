package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Dependencia;

/**
 * The DAO interface for the Dependencia entity.
 */
public interface IDependenciaDao {
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
	public Dependencia findDependenciaById(long id);
	/**
	 * Return all persistent instances of the <code>Dependencia</code> entity.
	 */
	public List<Dependencia> findAllDependencias();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDependencia(Dependencia dependencia);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDependencia(Dependencia dependencia);
}