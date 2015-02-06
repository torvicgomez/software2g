package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Procedimiento;

/**
 * The DAO interface for the Procedimiento entity.
 */
public interface IProcedimientoDao {
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
	public Procedimiento findProcedimientoById(long id);
	/**
	 * Return all persistent instances of the <code>Procedimiento</code> entity.
	 */
	public List<Procedimiento> findAllProcedimientos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProcedimiento(Procedimiento procedimiento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProcedimiento(Procedimiento procedimiento);
}