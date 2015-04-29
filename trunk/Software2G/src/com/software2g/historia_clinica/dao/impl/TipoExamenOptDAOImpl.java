package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Tipoexamenopt;
import com.software2g.historia_clinica.dao.ITipoExamenOptDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Tipoexamenopt entity.
 */
@Repository
public class TipoExamenOptDAOImpl implements ITipoExamenOptDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public TipoExamenOptDAOImpl() {
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
	public Tipoexamenopt findTipoexamenoptById(long id) {
		return (Tipoexamenopt)em.find(Tipoexamenopt.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Tipoexamenopt</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Tipoexamenopt> findAllTipoexamenopts() {
        try {
    		String jpqlString = "select tipoexamenopt from " + Tipoexamenopt.class.getSimpleName() + " tipoexamenopt";
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
	public Tipoexamenopt findTipoexamenoptAbreviatura(String abreviatura) {
        try {
    		String jpqlString = "select tipoexamenopt from " + Tipoexamenopt.class.getSimpleName() + " tipoexamenopt " +
    				" where tipoexamenopt.tiexAbreviatura =:abreviatura ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("abreviatura", abreviatura);
            return (Tipoexamenopt)query.getSingleResult();
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
	public void persistTipoexamenopt(Tipoexamenopt tipoexamenopt) {
		em.persist(em.merge(tipoexamenopt));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoexamenopt(Tipoexamenopt tipoexamenopt) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(tipoexamenopt));
	}
}