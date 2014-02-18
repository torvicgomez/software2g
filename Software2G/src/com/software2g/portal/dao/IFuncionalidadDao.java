package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Funcionalidad;

/**
 * The DAO interface for the Funcionalidad entity.
 */
public interface IFuncionalidadDao {
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
	public Funcionalidad findFuncionalidadById(java.lang.Integer id);
	/**
	 * Return all persistent instances of the <code>Funcionalidad</code> entity.
	 */
	public List<Funcionalidad> findAllFuncionalidads();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFuncionalidad(Funcionalidad funcionalidad);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFuncionalidad(Funcionalidad funcionalidad);
	public List<Funcionalidad> getFunctionApplication(String funcIdPadre, String funcId, long rolId);
}