package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Seguridadsocial;
import com.software2g.historia_clinica.dao.ISeguridadSocialDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Seguridadsocial entity.
 */
@Repository
public class SeguridadSocialDAOImpl implements ISeguridadSocialDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public SeguridadSocialDAOImpl() {
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
	public Seguridadsocial findSeguridadsocialById(long id) {
		return (Seguridadsocial)em.find(Seguridadsocial.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Seguridadsocial</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Seguridadsocial> findAllSeguridadsocials() {
        try {
    		String jpqlString = "select seguridadsocial from " + Seguridadsocial.class.getSimpleName() + " seguridadsocial " +
    				" order by seguridadsocial.nomsegur asc ";
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
	public void persistSeguridadsocial(Seguridadsocial seguridadsocial) {
		em.persist(em.merge(seguridadsocial));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeguridadsocial(Seguridadsocial seguridadsocial) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(seguridadsocial));
	}
}