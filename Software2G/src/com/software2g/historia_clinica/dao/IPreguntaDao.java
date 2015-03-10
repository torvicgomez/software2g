package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Pregunta;

/**
 * The DAO interface for the Pregunta entity.
 */
public interface IPreguntaDao {
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
	public Pregunta findPreguntaById(long id);
	/**
	 * Return all persistent instances of the <code>Pregunta</code> entity.
	 */
	public List<Pregunta> findAllPreguntas();
	public List<Pregunta> findAllPreguntasXSegmentoAna(long seanId);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPregunta(Pregunta pregunta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePregunta(Pregunta pregunta);
}