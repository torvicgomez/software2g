package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Consulta;

/**
 * The DAO interface for the Consulta entity.
 */
public interface IConsultaDao {
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
	public Consulta findConsultaById(long id);
	/**
	 * Return all persistent instances of the <code>Consulta</code> entity.
	 */
	public List<Consulta> findAllConsultas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConsulta(Consulta consulta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConsulta(Consulta consulta);
}