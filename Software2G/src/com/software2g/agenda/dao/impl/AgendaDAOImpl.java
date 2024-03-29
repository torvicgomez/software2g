package com.software2g.agenda.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.util.ConstantesAplicativo;
import com.software2g.vo.Agenda;
import com.software2g.agenda.dao.IAgendaDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Agenda entity.
 */
@Repository
public class AgendaDAOImpl implements IAgendaDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public AgendaDAOImpl() {
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
	public Agenda findAgendaById(long id) {
		return (Agenda)em.find(Agenda.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Agenda</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Agenda> findAllAgendas() {
        try {
    		String jpqlString = "select agenda from " + Agenda.class.getSimpleName() + " agenda";
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
	public List<Agenda> findAllAgendas(String tipo) {
        try {
    		String jpqlString = "select agenda from " + Agenda.class.getSimpleName() + " agenda ";
    		if(tipo.equals(ConstantesAplicativo.constanteAgendaMedica))
    			jpqlString += " where agenda.profesional is not null ";
    		else if(tipo.equals(ConstantesAplicativo.constanteAgendaCategoria))
    			jpqlString += " where agenda.portafolioCategoria is not null ";
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
	public Agenda findIdAgenda(String background) {
        try {
        	String jpqlString = " select agenda from " + Agenda.class.getSimpleName() + " agenda " +
        						" where agenda.profesional.profBackgroundcoloragen =:background  ";
            Query query = em.createQuery( jpqlString );
            System.out.println("background: ["+background+"]");
            query.setParameter("background", background);
            return (Agenda) query.getSingleResult();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public Agenda findIdAgenda(String background, String tipo) {
        try {
        	String jpqlString = " select agenda from " + Agenda.class.getSimpleName() + " agenda ";
        	if(tipo.equals(ConstantesAplicativo.constanteAgendaMedica))
        		jpqlString += " where agenda.profesional.profBackgroundcoloragen =:background  ";
        	else if(tipo.equals(ConstantesAplicativo.constanteAgendaCategoria))
        		jpqlString += " where agenda.portafolioCategoria.pocaBackgroundcolor =:background  ";
            Query query = em.createQuery( jpqlString );
            System.out.println("background: ["+background+"]");
            query.setParameter("background", background);
            return (Agenda) query.getSingleResult();
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
	public void persistAgenda(Agenda agenda) {
		em.persist(em.merge(agenda));
	}
	
	public long persistAgendaId(Agenda agenda) {
		Agenda obj = em.merge(agenda); 
		em.persist(obj); 
		return obj.getAgenId();
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAgenda(Agenda agenda) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(agenda));
	}
}