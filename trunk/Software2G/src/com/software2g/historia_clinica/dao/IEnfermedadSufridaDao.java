package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Enfermedadsufrida;

/**
 * The DAO interface for the Enfermedadsufrida entity.
 */
public interface IEnfermedadSufridaDao {
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
	public Enfermedadsufrida findEnfermedadsufridaById(long id);
	/**
	 * Return all persistent instances of the <code>Enfermedadsufrida</code> entity.
	 */
	public List<Enfermedadsufrida> findAllEnfermedadsufridas();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEnfermedadsufrida(Enfermedadsufrida enfermedadsufrida);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEnfermedadsufrida(Enfermedadsufrida enfermedadsufrida);
}