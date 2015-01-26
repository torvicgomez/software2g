package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Evento;

/**
 * The DAO interface for the Evento entity.
 */
public interface IEventoDao {
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
	public Evento findEventoById(long id);
	/**
	 * Return all persistent instances of the <code>Evento</code> entity.
	 */
	public List<Evento> findAllEventos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEvento(Evento evento);
	public long persistEventoId(Evento evento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEvento(Evento evento);
}