package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Institucion;

/**
 * The DAO interface for the Institucion entity.
 */
public interface IInstitucionDao {
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
	public Institucion findInstitucionById(java.lang.Integer id);
	/**
	 * Return all persistent instances of the <code>Institucion</code> entity.
	 */
	public List<Institucion> findAllInstitucions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistInstitucion(Institucion institucion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeInstitucion(Institucion institucion);
}