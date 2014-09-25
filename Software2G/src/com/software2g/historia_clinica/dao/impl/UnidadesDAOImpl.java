package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Unidade;
import com.software2g.historia_clinica.dao.IUnidadesDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Unidade entity.
 */
@Repository
public class UnidadesDAOImpl implements IUnidadesDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgresOptica")
    private EntityManager em;

	public UnidadesDAOImpl() {
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
	public Unidade findUnidadeById(long id) {
		return (Unidade)em.find(Unidade.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Unidade</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Unidade> findAllUnidades() {
        try {
    		String jpqlString = "select unidade from " + Unidade.class.getSimpleName() + " unidade";
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
	public void persistUnidade(Unidade unidade) {
		em.persist(em.merge(unidade));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUnidade(Unidade unidade) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(unidade));
	}
}