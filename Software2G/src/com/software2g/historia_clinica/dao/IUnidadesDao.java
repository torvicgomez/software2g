package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Unidade;

/**
 * The DAO interface for the Unidade entity.
 */
public interface IUnidadesDao {
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
	public Unidade findUnidadeById(long id);
	/**
	 * Return all persistent instances of the <code>Unidade</code> entity.
	 */
	public List<Unidade> findAllUnidades();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUnidade(Unidade unidade);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUnidade(Unidade unidade);
}