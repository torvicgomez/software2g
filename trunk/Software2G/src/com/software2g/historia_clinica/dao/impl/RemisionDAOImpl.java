package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Remision;
import com.software2g.historia_clinica.dao.IRemisionDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Remision entity.
 */
@Repository
public class RemisionDAOImpl implements IRemisionDao {
    @PersistenceContext
    private EntityManager em;

	public RemisionDAOImpl() {
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
	public Remision findRemisionById(long id) {
		return (Remision)em.find(Remision.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Remision</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Remision> findAllRemisions() {
        try {
    		String jpqlString = "select remision from " + Remision.class.getSimpleName() + " remision";
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
	public void persistRemision(Remision remision) {
		em.persist(em.merge(remision));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRemision(Remision remision) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(remision));
	}
}