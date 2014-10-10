package com.software2g.historia_clinica.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Especificaexamen;
import com.software2g.historia_clinica.dao.IEspecificaExamenDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Especificaexamen entity.
 */
@Repository
public class EspecificaExamenDAOImpl implements IEspecificaExamenDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public EspecificaExamenDAOImpl() {
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
	public Especificaexamen findEspecificaexamenById(long id) {
		return (Especificaexamen)em.find(Especificaexamen.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Especificaexamen</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Especificaexamen> findAllEspecificaexamens() {
        try {
    		String jpqlString = "select especificaexamen from " + Especificaexamen.class.getSimpleName() + " especificaexamen";
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
	public void persistEspecificaexamen(Especificaexamen especificaexamen) {
		em.persist(em.merge(especificaexamen));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificaexamen(Especificaexamen especificaexamen) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(especificaexamen));
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findExamenesConsultaEspecialidad(long idInstitucion, long idEspecialidad) {
        try {
    		String sqlString = " select distinct " +
    				" espe.id_especiexam, espe.abreviatura, esex_orden " +
    				" ,vaex.nomvarexam, vaex.abrevaexamen, vaex.vaex_orden " +
    				" ,vale.valorexamen, vale.valx_orden " +
    				" from public.especificaexamen espe " +
    				" inner join public.variableexamen vaex on (vaex.id_especiexam = espe.id_especiexam and vaex.estadovarexam = true ) " +
    				" left outer join public.valorexamen vale on (vale.id_varexamen = vaex.id_varexamen) " +
    				" where espe.id_tipoconsulta =:idEspecialidad " +
    				" and espe.examenactivo = true " +
    				" and id_institucion =:idInstitucion " +
    				" order by esex_orden, vaex.vaex_orden, vale.valx_orden asc ";
            Query query = em.createNativeQuery( sqlString );
            query.setParameter("idInstitucion", idInstitucion);
            query.setParameter("idEspecialidad", idEspecialidad);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}