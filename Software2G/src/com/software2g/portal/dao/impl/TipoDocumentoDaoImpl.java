package com.software2g.portal.dao.impl;

import  java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.ITipoDocumentoDao;
import com.software2g.vo.Tipodocumento;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Tipodocumento entity.
 */
@Repository
public class TipoDocumentoDaoImpl implements ITipoDocumentoDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public TipoDocumentoDaoImpl() {
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
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) {
		return (Tipodocumento)em.find(Tipodocumento.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Tipodocumento</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Tipodocumento> findAllTipodocumentos() {
        try {
    		String jpqlString = "select tipodocumento from " + Tipodocumento.class.getSimpleName() + " tipodocumento";
            Query query = em.createQuery( jpqlString );
            return query.getResultList();
        }catch (Exception e){
        	e.printStackTrace();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
		return null;
	}
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumento(Tipodocumento tipodocumento) {
		em.persist(em.merge(tipodocumento));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumento(Tipodocumento tipodocumento) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(tipodocumento));
	}
}