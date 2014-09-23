package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Convenio;

/**
 * The DAO interface for the Convenio entity.
 */
public interface IConvenioDao {
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
	public Convenio findConvenioById(com.software2g.vo.ConvenioPK id);
	/**
	 * Return all persistent instances of the <code>Convenio</code> entity.
	 */
	public List<Convenio> findAllConvenios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConvenio(Convenio convenio);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConvenio(Convenio convenio);
}