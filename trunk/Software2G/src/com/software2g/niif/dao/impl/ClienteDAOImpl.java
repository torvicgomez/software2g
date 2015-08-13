package com.software2g.niif.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Cliente;
import com.software2g.niif.dao.IClienteDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Cliente entity.
 */
@Repository
public class ClienteDAOImpl implements IClienteDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public ClienteDAOImpl() {
		super();
	}
	/**
	 * Return the persistent entities returned from a named query.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName) {
		Query queryObject = em.createNamedQuery(queryName);
		return queryObject.getResultList();
	}
	/**
	 * Return the persistent entities returned from a named query with named parameters.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName, String[] paramNames, Object[] paramValues) {
		if (paramNames.length != paramValues.length) {
			throw new IllegalArgumentException();
		}
		Map<String, Object> params = new java.util.HashMap<String, Object>(paramNames.length);
		for (int i = 0; i < paramNames.length; ++i) {
			params.put(paramNames[i], paramValues[i]);
		}
		
		Query queryObject = em.createNamedQuery(queryName);
		if (params != null) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				queryObject.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return queryObject.getResultList();

	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Cliente findClienteById(long id) {
		return (Cliente)em.find(Cliente.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Cliente</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Cliente> findAllClientes() {
        try {
    		String jpqlString = "select cliente from " + Cliente.class.getSimpleName() + " cliente";
            Query query = em.createQuery( jpqlString );
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public Cliente findAllClienteIdPers(long idPers) {
        try {
    		String jpqlString = "select cliente from " + Cliente.class.getSimpleName() + " cliente " +
    				" where cliente.persona.idPers =:idPers ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idPers", idPers);
            return (Cliente)query.getSingleResult();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCliente(Cliente cliente) {
		em.persist(em.merge(cliente));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCliente(Cliente cliente) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(cliente));
	}
}