package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Profesionalsalud;
import com.software2g.historia_clinica.dao.IPrefesionalSaludDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Profesionalsalud entity.
 */
@Repository
public class PrefesionalSaludDAOImpl implements IPrefesionalSaludDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public PrefesionalSaludDAOImpl() {
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
	public Profesionalsalud findProfesionalsaludById(long id) {
		return (Profesionalsalud)em.find(Profesionalsalud.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Profesionalsalud</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Profesionalsalud> findAllProfesionalsaluds() {
        try {
    		String jpqlString = "select profesionalsalud from " + Profesionalsalud.class.getSimpleName() + " profesionalsalud";
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
	public void persistProfesionalsalud(Profesionalsalud profesionalsalud) {
		em.persist(em.merge(profesionalsalud));
	}
	
	public long persistProfesionalsaludId(Profesionalsalud profesionalsalud) {
		Profesionalsalud obj = em.merge(profesionalsalud);
		System.out.println("0. Id:["+obj.getPrfsId()+"]");
		try{
			em.persist(obj);
		}catch(Exception e){
			System.out.println("Entra a esta excepcion del persist!!!!!!!");
			e.printStackTrace();
		}
		System.out.println("1. Id:["+obj.getPrfsId()+"]");
		return obj.getPrfsId();
		//em.persist(em.merge(profesionalsalud));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProfesionalsalud(Profesionalsalud profesionalsalud) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(profesionalsalud));
	}
}