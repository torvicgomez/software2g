package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Portafolio;

/**
 * The DAO interface for the Portafolio entity.
 */
public interface IPortafolioDao {
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
	public Portafolio findPortafolioById(long id);
	/**
	 * Return all persistent instances of the <code>Portafolio</code> entity.
	 */
	public List<Portafolio> findAllPortafolios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPortafolio(Portafolio portafolio);
	public long persistPortafolioId(Portafolio portafolio);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafolio(Portafolio portafolio);
	
	public  List<Portafolio> findAllPortafolioByCatalogoIdRegistro(long idRegistro);
	
}