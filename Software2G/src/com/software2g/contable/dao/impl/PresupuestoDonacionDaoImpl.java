package com.software2g.contable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.contable.dao.IPresupuestoDonacionDao;
import com.software2g.vo.Presupuestodonacion;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Presupuestodonacion entity.
 */
@Repository
public class PresupuestoDonacionDaoImpl implements IPresupuestoDonacionDao {
    @PersistenceContext
    private EntityManager em;

	public PresupuestoDonacionDaoImpl() {
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
	public Presupuestodonacion findPresupuestodonacionById(com.software2g.vo.PresupuestodonacionPK id) {
		return (Presupuestodonacion)em.find(Presupuestodonacion.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Presupuestodonacion</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Presupuestodonacion> findAllPresupuestodonacions() {
        try {
    		String jpqlString = "select presupuestodonacion from " + Presupuestodonacion.class.getSimpleName() + " presupuestodonacion";
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
	public List<Presupuestodonacion> findAllPresupuestodonacions(long forengKey, int tipo) {
        try {
    		String jpqlString = "select presupuestodonacion from " + Presupuestodonacion.class.getSimpleName() + " presupuestodonacion ";
    		jpqlString += tipo==0?" where presupuestodonacion.id.presId=:forengKey ":tipo==1?" where presupuestodonacion.id.donaId=:forengKey ":""; 
            Query query = em.createQuery( jpqlString );
            query.setParameter("forengKey", forengKey);
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
	public void persistPresupuestodonacion(Presupuestodonacion presupuestodonacion) {
		em.persist(em.merge(presupuestodonacion));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePresupuestodonacion(Presupuestodonacion presupuestodonacion) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(presupuestodonacion));
	}
}