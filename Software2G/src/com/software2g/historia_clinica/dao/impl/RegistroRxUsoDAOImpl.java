package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Registrorxuso;
import com.software2g.historia_clinica.dao.IRegistroRxUsoDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Registrorxuso entity.
 */
@Repository
public class RegistroRxUsoDAOImpl implements IRegistroRxUsoDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public RegistroRxUsoDAOImpl() {
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
	public Registrorxuso findRegistrorxusoById(long id) {
		return (Registrorxuso)em.find(Registrorxuso.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Registrorxuso</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Registrorxuso> findAllRegistrorxusos() {
        try {
    		String jpqlString = "select registrorxuso from " + Registrorxuso.class.getSimpleName() + " registrorxuso";
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
	public void persistRegistrorxuso(Registrorxuso registrorxuso) {
		em.persist(em.merge(registrorxuso));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrorxuso(Registrorxuso registrorxuso) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(registrorxuso));
	}
}