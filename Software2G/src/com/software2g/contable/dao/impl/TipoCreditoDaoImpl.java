package com.software2g.contable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.contable.dao.ITipoCreditoDao;
import com.software2g.vo.Tipocredito;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Tipocredito entity.
 */
@Repository
public class TipoCreditoDaoImpl implements ITipoCreditoDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public TipoCreditoDaoImpl() {
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
	public Tipocredito findTipocreditoById(long id) {
		return (Tipocredito)em.find(Tipocredito.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Tipocredito</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Tipocredito> findAllTipocreditos() {
        try {
    		String jpqlString = "select tipocredito from " + Tipocredito.class.getSimpleName() + " tipocredito";
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
	public void persistTipocredito(Tipocredito tipocredito) {
		em.persist(em.merge(tipocredito));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipocredito(Tipocredito tipocredito) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(tipocredito));
	}
}