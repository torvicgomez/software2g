package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Agenda;

/**
 * The DAO interface for the Agenda entity.
 */
public interface IAgendaDao  {
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
	public Agenda findAgendaById(long id);
	/**
	 * Return all persistent instances of the <code>Agenda</code> entity.
	 */
	public List<Agenda> findAllAgendas();
	public List<Agenda> findAllAgendas(String tipo);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAgenda(Agenda agenda);
	public long persistAgendaId(Agenda agenda);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAgenda(Agenda agenda);
	public Agenda findIdAgenda(String background);
}