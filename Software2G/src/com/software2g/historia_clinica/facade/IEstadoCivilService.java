package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Estadocivil;

/**
 * The service interface for the Estadocivil entity.
 */
public interface IEstadoCivilService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Estadocivil findEstadocivilById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Estadocivil</code> entity.
	 */
	public List<Estadocivil> findAllEstadocivils() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadocivil(Estadocivil estadocivil) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadocivil(Estadocivil estadocivil) throws Exception;
	/**
	 * Service method for named queries
	 */
}