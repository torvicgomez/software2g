package com.software2g.niif.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Detallecompra;
import com.software2g.niif.dao.IDetalleCompraDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Detallecompra entity.
 */
@Repository
public class DetalleCompraDAOImpl implements IDetalleCompraDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public DetalleCompraDAOImpl() {
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
	public Detallecompra findDetallecompraById(com.software2g.vo.DetallecompraPK id) {
		return (Detallecompra)em.find(Detallecompra.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Detallecompra</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Detallecompra> findAllDetallecompras() {
        try {
    		String jpqlString = "select detallecompra from " + Detallecompra.class.getSimpleName() + " detallecompra";
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
	public List<Detallecompra> findAllDetallecompras(long orcoId) {
        try {
    		String jpqlString = "select detallecompra from " + Detallecompra.class.getSimpleName() + " detallecompra " +
    				" where detallecompra.ordencompra.orcoId =:orcoId ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("orcoId", orcoId);
            return query.getResultList();
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
	public void persistDetallecompra(Detallecompra detallecompra) {
		em.persist(em.merge(detallecompra));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDetallecompra(Detallecompra detallecompra) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(detallecompra));
	}
}