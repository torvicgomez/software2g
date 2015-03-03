package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipoformulacion;

/**
 * The DAO interface for the Tipoformulacion entity.
 */
public interface ITipoFormulacionDao {
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
	public Tipoformulacion findTipoformulacionById(long id);
	/**
	 * Return all persistent instances of the <code>Tipoformulacion</code> entity.
	 */
	public List<Tipoformulacion> findAllTipoformulacions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoformulacion(Tipoformulacion tipoformulacion);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoformulacion(Tipoformulacion tipoformulacion);
}