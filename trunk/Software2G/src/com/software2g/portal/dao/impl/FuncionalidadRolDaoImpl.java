package com.software2g.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.IFuncionalidadRolDao;
import com.software2g.vo.Funcionalidadrol;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Funcionalidadrol entity.
 */
@Repository
public class FuncionalidadRolDaoImpl implements IFuncionalidadRolDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public FuncionalidadRolDaoImpl() {
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
	public Funcionalidadrol findFuncionalidadrolById(com.software2g.vo.FuncionalidadrolPK id) {
		return (Funcionalidadrol)em.find(Funcionalidadrol.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Funcionalidadrol</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionalidadrol> findAllFuncionalidadrols() {
        try {
    		String jpqlString = "select funcionalidadrol from " + Funcionalidadrol.class.getSimpleName() + " funcionalidadrol";
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
	public void persistFuncionalidadrol(Funcionalidadrol funcionalidadrol) {
		em.persist(em.merge(funcionalidadrol));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFuncionalidadrol(Funcionalidadrol funcionalidadrol) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(funcionalidadrol));
	}
	
	//*******************************************************************************
	// Metodos 																		*			
	//*******************************************************************************
	@SuppressWarnings("unchecked")
	public List<Funcionalidadrol> findAllFuncionalidadrols(Integer idRol) {
        try {
    		String jpqlString = "select funcionalidadrol from " + Funcionalidadrol.class.getSimpleName() + " funcionalidadrol " +
    				"where funcionalidadrol.id.idRol =:idRol ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idRol", idRol);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
}