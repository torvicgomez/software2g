package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Tipoexamenopt;

/**
 * The DAO interface for the Tipoexamenopt entity.
 */
public interface ITipoExamenOptDao {
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
	public Tipoexamenopt findTipoexamenoptById(long id);
	/**
	 * Return all persistent instances of the <code>Tipoexamenopt</code> entity.
	 */
	public List<Tipoexamenopt> findAllTipoexamenopts();
	public Tipoexamenopt findTipoexamenoptAbreviatura(String abreviatura);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoexamenopt(Tipoexamenopt tipoexamenopt);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoexamenopt(Tipoexamenopt tipoexamenopt);
}