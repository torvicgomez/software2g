package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipopregunta;

/**
 * The DAO interface for the Tipopregunta entity.
 */
public interface ITipoPreguntaDao {
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
	public Tipopregunta findTipopreguntaById(long id);
	/**
	 * Return all persistent instances of the <code>Tipopregunta</code> entity.
	 */
	public List<Tipopregunta> findAllTipopreguntas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipopregunta(Tipopregunta tipopregunta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipopregunta(Tipopregunta tipopregunta);
}