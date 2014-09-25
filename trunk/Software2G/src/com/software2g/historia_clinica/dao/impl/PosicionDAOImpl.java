package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Posicion;
import com.software2g.historia_clinica.dao.IPosicionDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Posicion entity.
 */
@Repository
public class PosicionDAOImpl implements IPosicionDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgresOptica")
    private EntityManager em;

	public PosicionDAOImpl() {
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
	public Posicion findPosicionById(long id) {
		return (Posicion)em.find(Posicion.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Posicion</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Posicion> findAllPosicions() {
        try {
    		String jpqlString = "select posicion from " + Posicion.class.getSimpleName() + " posicion";
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
	public void persistPosicion(Posicion posicion) {
		em.persist(em.merge(posicion));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePosicion(Posicion posicion) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(posicion));
	}
}