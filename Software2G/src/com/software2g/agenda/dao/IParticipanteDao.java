package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Participante;

/**
 * The DAO interface for the Participante entity.
 */
public interface IParticipanteDao {
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
	public Participante findParticipanteById(long id);
	/**
	 * Return all persistent instances of the <code>Participante</code> entity.
	 */
	public List<Participante> findAllParticipantes();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParticipante(Participante participante);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParticipante(Participante participante);
}