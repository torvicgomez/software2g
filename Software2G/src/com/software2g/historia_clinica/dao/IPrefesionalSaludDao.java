package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Profesionalsalud;

/**
 * The DAO interface for the Profesionalsalud entity.
 */
public interface IPrefesionalSaludDao {
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
	public Profesionalsalud findProfesionalsaludById(long id);
	/**
	 * Return all persistent instances of the <code>Profesionalsalud</code> entity.
	 */
	public List<Profesionalsalud> findAllProfesionalsaluds();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProfesionalsalud(Profesionalsalud profesionalsalud);
	public long persistProfesionalsaludId(Profesionalsalud profesionalsalud);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProfesionalsalud(Profesionalsalud profesionalsalud);
}