package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Listaexamenconsulta;

/**
 * The DAO interface for the Listaexamenconsulta entity.
 */
public interface IListaExamenConsultaDao {
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
	public Listaexamenconsulta findListaexamenconsultaById(long id);
	/**
	 * Return all persistent instances of the <code>Listaexamenconsulta</code> entity.
	 */
	public List<Listaexamenconsulta> findAllListaexamenconsultas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistListaexamenconsulta(Listaexamenconsulta listaexamenconsulta);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeListaexamenconsulta(Listaexamenconsulta listaexamenconsulta);
}