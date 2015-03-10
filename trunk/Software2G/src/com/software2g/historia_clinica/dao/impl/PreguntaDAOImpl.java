package com.software2g.historia_clinica.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Pregunta;
import com.software2g.historia_clinica.dao.IPreguntaDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Pregunta entity.
 */
@Repository
public class PreguntaDAOImpl implements IPreguntaDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public PreguntaDAOImpl() {
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
	public Pregunta findPreguntaById(long id) {
		return (Pregunta)em.find(Pregunta.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Pregunta</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Pregunta> findAllPreguntas() {
        try {
    		String jpqlString = "select pregunta from " + Pregunta.class.getSimpleName() + " pregunta";
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
	public List<Pregunta> findAllPreguntasXSegmentoAna(long seanId) {
        try {
    		String jpqlString = "select pregunta from " + Pregunta.class.getSimpleName() + " pregunta " +
    				" where pregunta.segmentoanamnesi.seanId =:seanId ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("seanId", seanId);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, String> findPreguntasXTipoEspecialidad(long tiesId) {
        try {
    		String sqlString = " select sean.sean_id, preg.preg_id, opre.opre_id, " +
    				" case when sean.tisa_id is not null then (select tisa.tisa_abreviatura from \"HISCLINICA\".\"TIPOSEGMENTO\" as tisa where tisa.tisa_id = sean.tisa_id) else '---' end as tiposegana," +
					" sean.sean_nombre, sean.sean_etiqueta, sean.sean_mensajeayuda," +
					" case when preg.tipr_id is not null then ( select tipr.tipr_etiqueta from \"HISCLINICA\".\"TIPOPREGUNTA\" as tipr where tipr.tipr_id = preg.tipr_id ) else '---' end as tipopreg," +
					" preg.preg_pregunta, preg.preg_mensajeayuda, preg.preg_tipodato, preg.preg_orden, " +
					" opre.opre_etiqueta, opre.opre_valor, opre.opre_valor, opre.opre_orden " +
					" from \"HISCLINICA\".\"PREGUNTA\" as preg " +
					" inner join \"HISCLINICA\".\"SEGMENTOANAMNESIS\" as sean on (sean.sean_id = preg.sean_id and sean.ties_id =:tiesId )-- Especialidad Tipo Optometria " +
					" left outer join \"HISCLINICA\".\"OPCIONRESPUESTA\" AS opre  on (opre.preg_id = preg.preg_id) " +
					" order by preg.preg_id, preg.preg_orden, opre.opre_orden asc ";
            Query query = em.createQuery( sqlString );
            query.setParameter("tiesId", tiesId);
            List<List<HashMap<String, String>>> a = null;
            List<Object[]> list = query.getResultList();
            HashMap<String, String> listResult = new HashMap<String, String>(); 
            for(Object[] elem:list){
            	listResult.put("sean_id", elem[0].toString());
            	listResult.put("preg_id", elem[1].toString());
            	listResult.put("opre_id", elem[2].toString());
            	listResult.put("tiposegana", elem[3].toString());
            	listResult.put("sean_nombre", elem[4].toString());
            	listResult.put("sean_etiqueta", elem[5].toString());
            	listResult.put("sean_mensajeayuda", elem[6].toString());
            	listResult.put("tipopreg", elem[7].toString());
            	listResult.put("preg_pregunta", elem[8].toString());
            	listResult.put("preg_mensajeayuda", elem[9].toString());
            	listResult.put("preg_tipodato", elem[10].toString());
            	listResult.put("preg_orden", elem[11].toString());
            	listResult.put("opre_etiqueta", elem[12].toString());
            	listResult.put("opre_valor", elem[13].toString());
            	listResult.put("opre_valor", elem[14].toString());
            	listResult.put("opre_orden", elem[15].toString());
            }
            return listResult;
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
	public void persistPregunta(Pregunta pregunta) {
		em.persist(em.merge(pregunta));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePregunta(Pregunta pregunta) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(pregunta));
	}
}