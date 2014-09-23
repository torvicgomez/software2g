package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipodocumentoinst;

/**
 * The DAO interface for the Tipodocumentoinst entity.
 */
public interface ITipoDocumentoInstitucionDao {
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
	public Tipodocumentoinst findTipodocumentoinstById(long id);
	/**
	 * Return all persistent instances of the <code>Tipodocumentoinst</code> entity.
	 */
	public List<Tipodocumentoinst> findAllTipodocumentoinsts();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumentoinst(Tipodocumentoinst tipodocumentoinst);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumentoinst(Tipodocumentoinst tipodocumentoinst);
}