package com.software2g.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.IRolUsuarioDao;
import com.software2g.vo.Rolusuario;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Rolusuario entity.
 */
@Repository
public class RolUsuarioDaoImpl implements IRolUsuarioDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public RolUsuarioDaoImpl() {
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
	public Rolusuario findRolusuarioById(com.software2g.vo.RolusuarioPK id) {
		return (Rolusuario)em.find(Rolusuario.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Rolusuario</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Rolusuario> findAllRolusuarios() {
        try {
    		String jpqlString = "select rolusuario from " + Rolusuario.class.getSimpleName() + " rolusuario";
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
	public void persistRolusuario(Rolusuario rolusuario) {
		em.persist(em.merge(rolusuario));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRolusuario(Rolusuario rolusuario) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(rolusuario));
	}
	
	
	//*******************************************************************************
	// Metodos 																		*			
	//*******************************************************************************
	@SuppressWarnings("unchecked")
	public List<Rolusuario> findAllRolusuarios(String login) {
        try {
    		String jpqlString = "select rolusuario from " + Rolusuario.class.getSimpleName() + " rolusuario where rolusuario.id.loginUsua = :login";
            Query query = em.createQuery( jpqlString );
            query.setParameter("login", login);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}