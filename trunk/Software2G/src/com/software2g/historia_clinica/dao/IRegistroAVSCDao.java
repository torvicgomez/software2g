package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Registroavsc;

/**
 * The DAO interface for the Registroavsc entity.
 */
public interface IRegistroAVSCDao {
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
	public Registroavsc findRegistroavscById(long id);
	/**
	 * Return all persistent instances of the <code>Registroavsc</code> entity.
	 */
	public List<Registroavsc> findAllRegistroavscs();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroavsc(Registroavsc registroavsc);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroavsc(Registroavsc registroavsc);
}