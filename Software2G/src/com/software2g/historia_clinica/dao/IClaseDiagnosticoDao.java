package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Clasediagnostico;

/**
 * The DAO interface for the Clasediagnostico entity.
 */
public interface IClaseDiagnosticoDao {
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
	public Clasediagnostico findClasediagnosticoById(long id);
	/**
	 * Return all persistent instances of the <code>Clasediagnostico</code> entity.
	 */
	public List<Clasediagnostico> findAllClasediagnosticos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistClasediagnostico(Clasediagnostico clasediagnostico);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeClasediagnostico(Clasediagnostico clasediagnostico);
}