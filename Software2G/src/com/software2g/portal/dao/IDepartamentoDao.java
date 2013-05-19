package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Departamento;

public interface IDepartamentoDao {
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
	public Departamento findDepartamentoById(long id);
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	public List<Departamento> findAllDepartamentos();
}
