package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Direccion;
import com.software2g.historia_clinica.dao.IDireccionDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Direccion entity.
 */
@Repository
public class DireccionDAOImpl implements IDireccionDao {
    @PersistenceContext
    private EntityManager em;

	public DireccionDAOImpl() {
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
	public Direccion findDireccionById(long id) {
		return (Direccion)em.find(Direccion.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Direccion</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Direccion> findAllDireccions() {
        try {
    		String jpqlString = "select direccion from " + Direccion.class.getSimpleName() + " direccion";
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
	public void persistDireccion(Direccion direccion) {
		em.persist(em.merge(direccion));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDireccion(Direccion direccion) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(direccion));
	}
}