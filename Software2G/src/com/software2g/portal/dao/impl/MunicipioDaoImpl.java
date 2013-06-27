package com.software2g.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.software2g.portal.dao.IMunicipioDao;
import com.software2g.vo.Departamento;
import com.software2g.vo.Municipio;

@Repository
public class MunicipioDaoImpl implements IMunicipioDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public MunicipioDaoImpl() {
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
	public Municipio findMunicipioById(long id) {
		return (Municipio)em.find(Municipio.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Municipio</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Municipio> findAllMunicipios() {
        try {
    		String jpqlString = "select municipio from " + Municipio.class.getSimpleName() + " municipio";
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
	public List<Municipio> findAllMunicipios(long idDpto) {
        try {
    		String jpqlString = "select municipio from " + Municipio.class.getSimpleName() + " municipio " +
    				" where municipio.departamento.dptoId =:idDpto " +
    				" order by municipio.nommunicipio asc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idDpto", idDpto);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findDatosMunicipio(long idMcpo) {
        try {
    		String sqlString = "select mcpo.nommunicipio||'-'||dpto.nomdpto||'-'||pais.nompais as ubicacion," +
    				" dpto.id_dpto, pais.id_pais " +
    				" from portal.municipio mcpo " +
    				" inner join portal.departamento dpto on (dpto.id_dpto = mcpo.id_dpto) " +
    				" inner join portal.pais pais on (pais.id_pais =dpto.id_pais) " +
    				" where id_mcpo = "+idMcpo+" ";
            Query query = em.createNativeQuery( sqlString );
            @SuppressWarnings("unchecked")
            List<Object[]> result = query.getResultList();
            return result;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}
