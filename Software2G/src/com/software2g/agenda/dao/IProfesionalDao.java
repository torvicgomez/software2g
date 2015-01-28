package com.software2g.agenda.dao;

import java.util.List;

import com.software2g.vo.Profesional;

/**
 * The DAO interface for the Profesional entity.
 */
public interface IProfesionalDao {
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
	public Profesional findProfesionalById(long id);
	public Profesional findProfesionalIdPersona(long idPersona);
	public boolean validoBackgroundProf(String background);
	public Profesional findProfesionalBackground(String background);
	
	/**
	 * Return all persistent instances of the <code>Profesional</code> entity.
	 */
	public List<Profesional> findAllProfesionals();
	public List<Profesional> findAllProfesionalAgenda();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProfesional(Profesional profesional);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProfesional(Profesional profesional);
	public List<Profesional> findAllProfesionalXIdPersona(long idPersona);
}