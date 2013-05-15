package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Tipodocumento;

/**
 * The DAO interface for the Tipodocumento entity.
 */
public interface ITipoDocumentoDao {
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
	public Tipodocumento findTipodocumentoById(java.lang.Integer id);
	/**
	 * Return all persistent instances of the <code>Tipodocumento</code> entity.
	 */
	public List<Tipodocumento> findAllTipodocumentos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumento(Tipodocumento tipodocumento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumento(Tipodocumento tipodocumento);
}