package com.software2g.portal.dao;

import java.util.List;

import com.software2g.vo.Usuario;

/**
 * The DAO interface for the Usuario entity.
 */
public interface IUsuarioDao {
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
	public Usuario findUsuarioById(java.lang.String id);
	/**
	 * Return all persistent instances of the <code>Usuario</code> entity.
	 */
	public List<Usuario> findAllUsuarios();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUsuario(Usuario usuario);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUsuario(Usuario usuario);
	
	//Metodos propios
	/**
	 * Metodo de busqueda de usuario segun estado y login
	 * @param login
	 * @param estado
	 * @return
	 */
	public Usuario findUsuarioById(String login, String password, String estado);
}