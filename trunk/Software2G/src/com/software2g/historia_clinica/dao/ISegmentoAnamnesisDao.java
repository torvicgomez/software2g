package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Segmentoanamnesi;

/**
 * The DAO interface for the Segmentoanamnesi entity.
 */
public interface ISegmentoAnamnesisDao {
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
	public Segmentoanamnesi findSegmentoanamnesiById(long id);
	/**
	 * Return all persistent instances of the <code>Segmentoanamnesi</code> entity.
	 */
	public List<Segmentoanamnesi> findAllSegmentoanamnesis();
	public List<Segmentoanamnesi> findAllSegmentoanamnesis(long tiesId);
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi);
}