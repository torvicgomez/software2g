package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Examenespecialidad;

/**
 * The DAO interface for the Examenespecialidad entity.
 */
public interface IExamenEspecialidadDao {
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
	public Examenespecialidad findExamenespecialidadById(long id);
	/**
	 * Return all persistent instances of the <code>Examenespecialidad</code> entity.
	 */
	public List<Examenespecialidad> findAllExamenespecialidads();
	public List<Examenespecialidad> findAllExamenespecialidads(long tipoEspecialidad);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenespecialidad(Examenespecialidad examenespecialidad);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenespecialidad(Examenespecialidad examenespecialidad);
}