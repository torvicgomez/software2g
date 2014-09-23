package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Listaexamenconsulta;

/**
 * The service interface for the Listaexamenconsulta entity.
 */
public interface IListaExamenConsultaService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Listaexamenconsulta findListaexamenconsultaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Listaexamenconsulta</code> entity.
	 */
	public List<Listaexamenconsulta> findAllListaexamenconsultas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception;
	/**
	 * Service method for named queries
	 */
}