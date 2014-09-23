package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipodiagnostico;

/**
 * The DAO interface for the Tipodiagnostico entity.
 */
public interface ITipoDiagnosticoDao {
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
	public Tipodiagnostico findTipodiagnosticoById(long id);
	/**
	 * Return all persistent instances of the <code>Tipodiagnostico</code> entity.
	 */
	public List<Tipodiagnostico> findAllTipodiagnosticos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodiagnostico(Tipodiagnostico tipodiagnostico);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodiagnostico(Tipodiagnostico tipodiagnostico);
}