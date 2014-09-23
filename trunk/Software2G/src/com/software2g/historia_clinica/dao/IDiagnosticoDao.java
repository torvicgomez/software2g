package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Diagnostico;

/**
 * The DAO interface for the Diagnostico entity.
 */
public interface IDiagnosticoDao {
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
	public Diagnostico findDiagnosticoById(long id);
	/**
	 * Return all persistent instances of the <code>Diagnostico</code> entity.
	 */
	public List<Diagnostico> findAllDiagnosticos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDiagnostico(Diagnostico diagnostico);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDiagnostico(Diagnostico diagnostico);
}