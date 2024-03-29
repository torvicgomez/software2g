package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Especificacionpartecuerpo;

/**
 * The DAO interface for the Especificacionpartecuerpo entity.
 */
public interface IEspecificacionParteCuerpoDao {
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
	public Especificacionpartecuerpo findEspecificacionpartecuerpoById(long id);
	/**
	 * Return all persistent instances of the <code>Especificacionpartecuerpo</code> entity.
	 */
	public List<Especificacionpartecuerpo> findAllEspecificacionpartecuerpos();
	public Especificacionpartecuerpo findEspecificacionpartecuerposXEtiqueta(String etiqueta);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo);
}