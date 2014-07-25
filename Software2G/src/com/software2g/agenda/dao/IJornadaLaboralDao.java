package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Jorandalaboral;

/**
 * The DAO interface for the Jorandalaboral entity.
 */
public interface IJornadaLaboralDao {
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
	public Jorandalaboral findJorandalaboralById(long id);
	/**
	 * Return all persistent instances of the <code>Jorandalaboral</code> entity.
	 */
	public List<Jorandalaboral> findAllJorandalaborals();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistJorandalaboral(Jorandalaboral jorandalaboral);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeJorandalaboral(Jorandalaboral jorandalaboral);
}