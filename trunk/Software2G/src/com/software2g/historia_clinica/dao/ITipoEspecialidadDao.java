package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipoespecialidad;

/**
 * The DAO interface for the Tipoespecialidad entity.
 */
public interface ITipoEspecialidadDao {
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
	public Tipoespecialidad findTipoespecialidadById(long id);
	/**
	 * Return all persistent instances of the <code>Tipoespecialidad</code> entity.
	 */
	public List<Tipoespecialidad> findAllTipoespecialidads();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoespecialidad(Tipoespecialidad tipoespecialidad);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoespecialidad(Tipoespecialidad tipoespecialidad);
}