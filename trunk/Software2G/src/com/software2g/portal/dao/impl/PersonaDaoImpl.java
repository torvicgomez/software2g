package com.software2g.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.IPersonaDao;
import com.software2g.util.ValidaString;
import com.software2g.vo.Persona;
import com.software2g.vo.Profesional;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Persona entity.
 */
@Repository
public class PersonaDaoImpl implements IPersonaDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public PersonaDaoImpl() {
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
	public Persona findPersonaById(java.lang.Long id) {
		return (Persona)em.find(Persona.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Persona</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas() {
        try {
    		String jpqlString = "select persona from " + Persona.class.getSimpleName() + " persona" +
    				" order by persona.pnombrePers, persona.snombrePers, persona.papellidoPers, persona.sapellidoPers asc";
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
	public void persistPersona(Persona persona) {
		persona.setFechacambio(ValidaString.fechaSystem());
		persona.setHoracambio(ValidaString.horaSystem());
		persona.setPnombrePers(ValidaString.toUpperCase(persona.getPnombrePers()));
		persona.setSnombrePers(ValidaString.toUpperCase(persona.getSnombrePers()));
		persona.setPapellidoPers(ValidaString.toUpperCase(persona.getPapellidoPers()));
		persona.setSapellidoPers(ValidaString.toUpperCase(persona.getSapellidoPers()));
		//persona.setFechaexpdocPers(ValidaString.formatoFecha(persona.getFechaexpdocPers()));
		//persona.setFechanacimientoPers(ValidaString.formatoFecha(persona.getFechanacimientoPers()));
		//ValidaString.imprimirObject(persona);
		em.persist(em.merge(persona));
	}
	
	public long persistPersonaId(Persona persona) {
		persona.setFechacambio(ValidaString.fechaSystem());
		persona.setHoracambio(ValidaString.horaSystem());
		persona.setPnombrePers(ValidaString.toUpperCase(persona.getPnombrePers()));
		persona.setSnombrePers(ValidaString.toUpperCase(persona.getSnombrePers()));
		persona.setPapellidoPers(ValidaString.toUpperCase(persona.getPapellidoPers()));
		persona.setSapellidoPers(ValidaString.toUpperCase(persona.getSapellidoPers()));
		//persona.setFechaexpdocPers(ValidaString.formatoFecha(persona.getFechaexpdocPers()));
		//persona.setFechanacimientoPers(ValidaString.formatoFecha(persona.getFechanacimientoPers()));
		//ValidaString.imprimirObject(persona);
		//em.persist(em.merge(persona));
		Persona obj = em.merge(persona); 
		em.persist(obj); 
		return obj.getIdPers();
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersona(Persona persona) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(persona));
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas(String datoFind, String tipoFind) {
        try {
    		String jpqlString = "select persona from " + Persona.class.getSimpleName() + " persona ";
    		if(tipoFind.equals("0"))
    			jpqlString += " where lower(persona.pnombrePers) like :datoFind " +
    						  " or  lower(persona.snombrePers) like :datoFind " +
    						  " or  lower(persona.papellidoPers) like :datoFind " +
    						  " or  lower(persona.sapellidoPers) like :datoFind ";
    		else if(tipoFind.equals("1"))
    			jpqlString += " where persona.documentoPers like :datoFind ";
    		jpqlString += " order by persona.pnombrePers, persona.snombrePers, persona.papellidoPers, persona.sapellidoPers asc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("datoFind", "%"+datoFind.toLowerCase()+"%");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas(String datoFind) {
        try {
    		String jpqlString = "select persona from " + Persona.class.getSimpleName() + " persona ";
    			jpqlString += " where upper(persona.pnombrePers)||' '||upper(persona.snombrePers)||' '||upper(persona.papellidoPers)||' '||upper(persona.sapellidoPers) like :datoFind " +
    						  " or upper(persona.pnombrePers)||' '||upper(persona.papellidoPers) like :datoFind " +
    						  " or upper(persona.emailPers) like :datoFind " +
    						  " or persona.documentoPers like :datoFind " +
    						  " order by persona.pnombrePers, persona.snombrePers, persona.papellidoPers, persona.sapellidoPers asc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("datoFind", "%"+datoFind.toUpperCase().trim()+"%");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonasProfesional(String datoFind) {
        try {
    		String jpqlString = "select persona from " + Persona.class.getSimpleName() + " persona " +
    							" join persona.profesional ";
    			jpqlString += " where upper(persona.pnombrePers)||' '||upper(persona.snombrePers)||' '||upper(persona.papellidoPers)||' '||upper(persona.sapellidoPers) like :datoFind " +
    						  " or upper(persona.pnombrePers)||' '||upper(persona.papellidoPers) like :datoFind " +
    						  " or upper(persona.emailPers) like :datoFind " +
    						  " or persona.documentoPers like :datoFind " +
    						  " order by persona.pnombrePers, persona.snombrePers, persona.papellidoPers, persona.sapellidoPers asc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("datoFind", "%"+datoFind.toUpperCase().trim()+"%");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonasProfesionales(String datoFind) {
        try {
    		String sqlString = " select distinct persona from " + Persona.class.getSimpleName() + " persona " +
    				" join persona.profesional profesional " +
    				" where lower(persona.pnombrePers) like :datoFind " +
    				" or lower(persona.snombrePers) like :datoFind " +
    				" or lower(persona.papellidoPers) like :datoFind " +
    				" or lower(persona.sapellidoPers) like :datoFind " +
    				" or persona.documentoPers like :datoFind " +
    				" or persona.emailPers like :datoFind " +
    				" or persona.telefonoPers like :datoFind " +
    				" order by persona.pnombrePers, persona.snombrePers, persona.papellidoPers, persona.sapellidoPers asc ";
			Query query = em.createQuery( sqlString );
            query.setParameter("datoFind", "%"+datoFind.toLowerCase()+"%");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}