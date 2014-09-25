package com.software2g.contable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.contable.dao.IPagareDao;
import com.software2g.vo.Credito;
import com.software2g.vo.Pagare;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Pagare entity.
 */
@Repository
public class PagareDaoImpl implements IPagareDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public PagareDaoImpl() {
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
	public Pagare findPagareById(long id) {
		return (Pagare)em.find(Pagare.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Pagare</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Pagare> findAllPagares() {
        try {
    		String jpqlString = "select pagare from " + Pagare.class.getSimpleName() + " pagare";
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
	public void persistPagare(Pagare pagare) {
		em.persist(em.merge(pagare));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePagare(Pagare pagare) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(pagare));
	}
	
	@SuppressWarnings("unchecked")
	public List<Pagare> findAllTitularesCredito(String datoFind, String tipoFind) {
        try {
    		String jpqlString = "select pagare from " + Pagare.class.getSimpleName() + " pagare ";
    		if(tipoFind.equals("0"))
    			jpqlString += " where pagare.pagaId not in (select credito.pagare.pagaId from  " + Credito.class.getSimpleName() + " credito )  " +
    					  " and ( lower(pagare.persona.pnombrePers) like :datoFind " +
						  " or  lower(pagare.persona.snombrePers) like :datoFind " +
						  " or  lower(pagare.persona.papellidoPers) like :datoFind " +
						  " or  lower(pagare.persona.sapellidoPers) like :datoFind ) " ;
    		else if(tipoFind.equals("1"))
    			jpqlString += " where pagare.pagaId = :datoFind and pagare.pagaId not in (select credito.pagare.pagaId from  " + Credito.class.getSimpleName() + " credito )  ";
    		jpqlString += " order by pagare.persona.pnombrePers, pagare.persona.snombrePers, pagare.persona.papellidoPers, pagare.persona.sapellidoPers asc ";
            Query query = em.createQuery( jpqlString );
            if(tipoFind.equals("0"))
            	query.setParameter("datoFind", "%"+datoFind.toLowerCase()+"%");
            else if(tipoFind.equals("1"))
            	query.setParameter("datoFind", Long.parseLong(datoFind));
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	public String verificarPagosPagare(long idPagare) {
        try {
    		String sqlString = "select case when count(pag.paga_id)<= 0 then 'S' else 'N' end as isAnulable " +
    				" from contable.pagare pag " +
    				" inner join contable.credito cre on (pag.paga_id = cre.paga_id) " +
    				" inner join contable.abono abo on (cre.cred_id = abo.cred_id) " +
    				" where pag.paga_id = "+idPagare+" ";
            Query query = em.createNativeQuery( sqlString );
            return query.getSingleResult().toString();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}