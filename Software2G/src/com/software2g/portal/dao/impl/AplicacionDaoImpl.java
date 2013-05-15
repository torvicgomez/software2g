package com.software2g.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.IAplicacionDao;
import com.software2g.vo.Aplicacion;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Aplicacion entity.
 */
@Repository
public class AplicacionDaoImpl implements IAplicacionDao {
    @PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public AplicacionDaoImpl() {
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
	public Aplicacion findAplicacionById(java.lang.Integer id) {
		return (Aplicacion)em.find(Aplicacion.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Aplicacion> findAllAplicacions() {
        try {
    		String jpqlString = "select aplicacion from " + Aplicacion.class.getSimpleName() + " aplicacion";
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
	public void persistAplicacion(Aplicacion aplicacion) {
		em.persist(em.merge(aplicacion));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAplicacion(Aplicacion aplicacion) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(aplicacion));
	}
}