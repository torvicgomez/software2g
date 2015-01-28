package com.software2g.agenda.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Agenda;
import com.software2g.vo.Profesional;
import com.software2g.agenda.dao.IProfesionalDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Profesional entity.
 */
@Repository
public class ProfesionalDAOImpl implements IProfesionalDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public ProfesionalDAOImpl() {
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
	public Profesional findProfesionalById(long id) {
		return (Profesional)em.find(Profesional.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Profesional</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Profesional> findAllProfesionals() {
        try {
    		String jpqlString = "select profesional from " + Profesional.class.getSimpleName() + " profesional";
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
	public List<Profesional> findAllProfesionalAgenda() {
        try {
    		String jpqlString = " select agenda.profesional from " + Agenda.class.getSimpleName() + " agenda ";
            Query query = em.createQuery( jpqlString );
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	public Profesional findProfesionalIdPersona(long idPersona) {
        try {
    		String jpqlString = "select profesional from " + Profesional.class.getSimpleName() + " profesional" +
    				" where profesional.persona.idPers =:idPersona ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idPersona", idPersona);
            return (Profesional) query.getSingleResult();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	public boolean validoBackgroundProf(String background) {
        try {
    		String jpqlString = "select profesional from " + Profesional.class.getSimpleName() + " profesional" +
    				" where profesional.profBackgroundcoloragen =:background ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("background", background);
            Profesional obj = (Profesional) query.getSingleResult();
            return (obj!=null&&obj.getProfBackgroundcoloragen().equals(background))?false:true;
        } catch(Exception e){
        	return true;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	public Profesional findProfesionalBackground(String background) {
        try {
    		String jpqlString = "select profesional from " + Profesional.class.getSimpleName() + " profesional" +
    				" where profesional.profBackgroundcoloragen =:background ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("background", background);
            return (Profesional)query.getSingleResult();
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
	public void persistProfesional(Profesional profesional) {
		em.persist(em.merge(profesional));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProfesional(Profesional profesional) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(profesional));
	}
	
	@SuppressWarnings("unchecked")
	public List<Profesional> findAllProfesionalXIdPersona(long idPersona) {
        try {
    		String jpqlString = "select profesional from " + Profesional.class.getSimpleName() + " profesional " +
    				" where profesional.persona.idPers =:idPersona ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idPersona", idPersona);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
}