package com.software2g.niif.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Ordencompra;
import com.software2g.niif.dao.IOrdenCompraDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Ordencompra entity.
 */
@Repository
public class OrdenCompraDAOImpl implements IOrdenCompraDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public OrdenCompraDAOImpl() {
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
	public Ordencompra findOrdencompraById(long id) {
		return (Ordencompra)em.find(Ordencompra.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Ordencompra</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Ordencompra> findAllOrdencompras() {
        try {
    		String jpqlString = "select ordencompra from " + Ordencompra.class.getSimpleName() + " ordencompra";
            Query query = em.createQuery( jpqlString );
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
	public void persistOrdencompra(Ordencompra ordencompra) {
		em.persist(em.merge(ordencompra));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOrdencompra(Ordencompra ordencompra) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(ordencompra));
	}
}