package com.software2g.agenda.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Parametroscalendario;
import com.software2g.agenda.dao.IParametroCalendarioDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Parametroscalendario entity.
 */
@Repository
public class ParametroCalendarioDAOImpl implements IParametroCalendarioDao {
    @PersistenceContext
    private EntityManager em;

	public ParametroCalendarioDAOImpl() {
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
	public Parametroscalendario findParametroscalendarioById(long id) {
		return (Parametroscalendario)em.find(Parametroscalendario.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Parametroscalendario</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Parametroscalendario> findAllParametroscalendarios() {
        try {
    		String jpqlString = "select parametroscalendario from " + Parametroscalendario.class.getSimpleName() + " parametroscalendario";
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
	public void persistParametroscalendario(Parametroscalendario parametroscalendario) {
		em.persist(em.merge(parametroscalendario));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParametroscalendario(Parametroscalendario parametroscalendario) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(parametroscalendario));
	}
}