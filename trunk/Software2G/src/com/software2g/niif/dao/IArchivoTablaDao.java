package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Archivotabla;

/**
 * The DAO interface for the Archivotabla entity.
 */
public interface IArchivoTablaDao {
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
	public Archivotabla findArchivotablaById(long id);
	/**
	 * Return all persistent instances of the <code>Archivotabla</code> entity.
	 */
	public List<Archivotabla> findAllArchivotablas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArchivotabla(Archivotabla archivotabla);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivotabla(Archivotabla archivotabla);
	/**
	 * Consulta el ultimo registro de archivo tabla por desc tabla y idregistro
	 * @param tabla
	 * @param idRegistro
	 * @return
	 */
	public Archivotabla findArchivotablaByTablaIdRegistro(String tabla, String idRegistro);
	
	/**
	 * Consulta todos los archivos de tabla por desc tabla y idregistro
	 * @param tabla
	 * @param idRegistro
	 * @return
	 */
	public List<Archivotabla> findAllArchivotablasByTablaIdRegistro(String tabla, String idRegistro);
}