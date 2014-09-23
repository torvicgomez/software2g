package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Estadomedicamento;

/**
 * The service interface for the Estadomedicamento entity.
 */
public interface IEstadoMedicamentoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Estadomedicamento findEstadomedicamentoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Estadomedicamento</code> entity.
	 */
	public List<Estadomedicamento> findAllEstadomedicamentos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception;
	/**
	 * Service method for named queries
	 */
}