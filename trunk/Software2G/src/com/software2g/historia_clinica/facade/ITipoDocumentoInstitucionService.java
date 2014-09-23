package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Tipodocumentoinst;

/**
 * The service interface for the Tipodocumentoinst entity.
 */
public interface ITipoDocumentoInstitucionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipodocumentoinst findTipodocumentoinstById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipodocumentoinst</code> entity.
	 */
	public List<Tipodocumentoinst> findAllTipodocumentoinsts() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception;
	/**
	 * Service method for named queries
	 */
}