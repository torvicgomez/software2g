package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Sintomacomun;
import com.software2g.historia_clinica.dao.ISintomaComunDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Sintomacomun entity.
 */
@Repository
public class SintomaComunDAOImpl implements ISintomaComunDao {
    @PersistenceContext
    private EntityManager em;

	public SintomaComunDAOImpl() {
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
	public Sintomacomun findSintomacomunById(long id) {
		return (Sintomacomun)em.find(Sintomacomun.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Sintomacomun</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Sintomacomun> findAllSintomacomuns() {
        try {
    		String jpqlString = "select sintomacomun from " + Sintomacomun.class.getSimpleName() + " sintomacomun";
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
	public void persistSintomacomun(Sintomacomun sintomacomun) {
		em.persist(em.merge(sintomacomun));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintomacomun(Sintomacomun sintomacomun) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(sintomacomun));
	}
}