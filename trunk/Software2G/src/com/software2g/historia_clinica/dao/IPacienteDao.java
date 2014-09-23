package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Paciente;

/**
 * The DAO interface for the Paciente entity.
 */
public interface IPacienteDao {
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
	public Paciente findPacienteById(long id);
	/**
	 * Return all persistent instances of the <code>Paciente</code> entity.
	 */
	public List<Paciente> findAllPacientes();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPaciente(Paciente paciente);
	/**
	 * Remove the given persistent instance.
	 */
	public void removePaciente(Paciente paciente);
}