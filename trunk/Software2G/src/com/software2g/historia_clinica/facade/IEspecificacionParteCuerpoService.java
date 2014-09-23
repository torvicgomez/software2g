package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Especificacionpartecuerpo;

/**
 * The service interface for the Especificacionpartecuerpo entity.
 */
public interface IEspecificacionParteCuerpoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Especificacionpartecuerpo findEspecificacionpartecuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Especificacionpartecuerpo</code> entity.
	 */
	public List<Especificacionpartecuerpo> findAllEspecificacionpartecuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception;
	/**
	 * Service method for named queries
	 */
}