package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Motivo;

/**
 * The DAO interface for the Motivo entity.
 */
public interface IMotivoDao {
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
	public Motivo findMotivoById(long id);
	/**
	 * Return all persistent instances of the <code>Motivo</code> entity.
	 */
	public List<Motivo> findAllMotivos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMotivo(Motivo motivo);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMotivo(Motivo motivo);
}