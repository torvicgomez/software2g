package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Funcionalidadrol;

/**
 * The DAO interface for the Funcionalidadrol entity.
 */
public interface IFuncionalidadRolDao {
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
	public Funcionalidadrol findFuncionalidadrolById(com.software2g.vo.FuncionalidadrolPK id);
	/**
	 * Return all persistent instances of the <code>Funcionalidadrol</code> entity.
	 */
	public List<Funcionalidadrol> findAllFuncionalidadrols();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFuncionalidadrol(Funcionalidadrol funcionalidadrol);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFuncionalidadrol(Funcionalidadrol funcionalidadrol);
	
	//*******************************************************************************
	// Metodos 																		*			
	//*******************************************************************************
	/**
	 * Metodo que obtiene las funcionalidades asociadas a un rol en especifico. 
	 * @param idRol
	 * @return
	 */
	public List<Funcionalidadrol> findAllFuncionalidadrols(Integer idRol);
}