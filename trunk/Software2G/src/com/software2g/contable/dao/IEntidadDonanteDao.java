package com.software2g.contable.dao;

import java.util.List;

import com.software2g.vo.Entidaddonante;

/**
 * The DAO interface for the Entidaddonante entity.
 */
public interface IEntidadDonanteDao {
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
	public Entidaddonante findEntidaddonanteById(long id);
	/**
	 * Return all persistent instances of the <code>Entidaddonante</code> entity.
	 */
	public List<Entidaddonante> findAllEntidaddonantes();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEntidaddonante(Entidaddonante entidaddonante);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEntidaddonante(Entidaddonante entidaddonante);
}