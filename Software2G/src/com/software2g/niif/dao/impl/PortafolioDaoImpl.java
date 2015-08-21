package com.software2g.niif.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Archivotabla;
import com.software2g.vo.Portafolio;
import com.software2g.vo.Portafoliocategoria;
import com.software2g.niif.dao.IPortafolioDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Portafolio entity.
 */
@Repository
public class PortafolioDaoImpl implements IPortafolioDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public PortafolioDaoImpl() {
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
	public Portafolio findPortafolioById(long id) {
		return (Portafolio)em.find(Portafolio.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Portafolio</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Portafolio> findAllPortafolios() {
        try {
    		String jpqlString = "select portafolio from " + Portafolio.class.getSimpleName() + " portafolio";
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
	public void persistPortafolio(Portafolio portafolio) {
		em.persist(em.merge(portafolio));
	}
	
	public long persistPortafolioId(Portafolio portafolio) {
		Portafolio obj = em.merge(portafolio); 
		em.persist(obj);
		return obj.getPortId();
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePortafolio(Portafolio portafolio) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(portafolio));
	}
	
	@SuppressWarnings("unchecked")
	public List<Portafolio> findAllPortafolioByCatalogoIdRegistro(long idRegistro) {
        try {
    		String jpqlString = "select portafolio from " + Portafolio.class.getSimpleName() + " portafolio " +
    							"where portafolio.portafoliocategoria.pocaId=:idRegistro " +
    							"order by portafolio.portReferencia desc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idRegistro", idRegistro);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
}