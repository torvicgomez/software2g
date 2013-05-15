package com.software2g.contable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.contable.dao.IDonacionObjetoDao;
import com.software2g.vo.Donacionobjeto;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Donacionobjeto entity.
 */
@Repository
public class DonacionObjetoDaoImpl implements IDonacionObjetoDao {
    @PersistenceContext
    private EntityManager em;

	public DonacionObjetoDaoImpl() {
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
	public Donacionobjeto findDonacionobjetoById(com.software2g.vo.DonacionobjetoPK id) {
		return (Donacionobjeto)em.find(Donacionobjeto.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Donacionobjeto</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Donacionobjeto> findAllDonacionobjetos() {
        try {
    		String jpqlString = "select donacionobjeto from " + Donacionobjeto.class.getSimpleName() + " donacionobjeto";
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
	public List<Donacionobjeto> findAllDonacionobjetos(long idDona) {
        try {
    		String jpqlString = "select donacionobjeto from " + Donacionobjeto.class.getSimpleName() + " donacionobjeto where id.donaId=:idDona";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idDona", idDona);
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
	public void persistDonacionobjeto(Donacionobjeto donacionobjeto) {
		em.persist(em.merge(donacionobjeto));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacionobjeto(Donacionobjeto donacionobjeto) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(donacionobjeto));
	}
}