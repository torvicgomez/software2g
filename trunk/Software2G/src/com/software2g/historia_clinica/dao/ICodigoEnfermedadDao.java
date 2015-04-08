package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Codigoenfermedade;

/**
 * The DAO interface for the Codigoenfermedade entity.
 */
public interface ICodigoEnfermedadDao {
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
	public Codigoenfermedade findCodigoenfermedadeById(long id);
	/**
	 * Return all persistent instances of the <code>Codigoenfermedade</code> entity.
	 */
	public List<Codigoenfermedade> findAllCodigoenfermedades();
	public List<Codigoenfermedade> findAllCodigoenfermedadesEspecialidad(String datoFind, long especialidad);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCodigoenfermedade(Codigoenfermedade codigoenfermedade);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCodigoenfermedade(Codigoenfermedade codigoenfermedade);
}