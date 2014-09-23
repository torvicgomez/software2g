package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Especificacionformula;

/**
 * The service interface for the Especificacionformula entity.
 */
public interface IEspecificacionFormulaService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Especificacionformula findEspecificacionformulaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Especificacionformula</code> entity.
	 */
	public List<Especificacionformula> findAllEspecificacionformulas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionformula(Especificacionformula especificacionformula) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionformula(Especificacionformula especificacionformula) throws Exception;
	/**
	 * Service method for named queries
	 */
}