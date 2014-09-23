package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Paciente;

/**
 * The service interface for the Paciente entity.
 */
public interface IPacienteService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Paciente findPacienteById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Paciente</code> entity.
	 */
	public List<Paciente> findAllPacientes() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPaciente(Paciente paciente) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePaciente(Paciente paciente) throws Exception;
	/**
	 * Service method for named queries
	 */
}