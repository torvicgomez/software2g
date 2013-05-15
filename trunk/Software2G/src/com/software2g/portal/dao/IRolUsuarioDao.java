package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Rolusuario;

/**
 * The DAO interface for the Rolusuario entity.
 */
public interface IRolUsuarioDao {
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
	public Rolusuario findRolusuarioById(com.software2g.vo.RolusuarioPK id);
	/**
	 * Return all persistent instances of the <code>Rolusuario</code> entity.
	 */
	public List<Rolusuario> findAllRolusuarios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRolusuario(Rolusuario rolusuario);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRolusuario(Rolusuario rolusuario);
	
	//***************************************************
	// Nuevos Metodos									*
	//***************************************************
	/**
	 * Meotodo que obtine los roles asociados a un respectivo usuario
	 * @param login
	 * @return
	 */
	public List<Rolusuario> findAllRolusuarios(String login);
}