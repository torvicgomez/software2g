package com.software2g.historia_clinica.dao;

import java.util.List;

import com.software2g.vo.Medicamento;

/**
 * The DAO interface for the Medicamento entity.
 */
public interface IMedicamentoDao {
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
	public Medicamento findMedicamentoById(long id);
	/**
	 * Return all persistent instances of the <code>Medicamento</code> entity.
	 */
	public List<Medicamento> findAllMedicamentos();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMedicamento(Medicamento medicamento);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMedicamento(Medicamento medicamento);
}