package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Unidade;

/**
 * The service interface for the Unidade entity.
 */
public interface IUnidadesService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Unidade findUnidadeById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Unidade</code> entity.
	 */
	public List<Unidade> findAllUnidades() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUnidade(Unidade unidade) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUnidade(Unidade unidade) throws Exception;
	/**
	 * Service method for named queries
	 */
}