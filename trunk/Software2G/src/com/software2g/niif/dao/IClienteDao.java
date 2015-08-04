package com.software2g.niif.dao;

import java.util.List;

import com.software2g.vo.Cliente;

/**
 * The DAO interface for the Cliente entity.
 */
public interface IClienteDao {
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
	public Cliente findClienteById(long id);
	/**
	 * Return all persistent instances of the <code>Cliente</code> entity.
	 */
	public List<Cliente> findAllClientes();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCliente(Cliente cliente);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCliente(Cliente cliente);
}