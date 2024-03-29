package com.software2g.contable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.contable.dao.ICreditoDao;
import com.software2g.vo.Credito;
import com.software2g.vo.Persona;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Credito entity.
 */
@Repository
public class CreditoDaoImpl implements ICreditoDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public CreditoDaoImpl() {
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
	public Credito findCreditoById(long id) {
		return (Credito)em.find(Credito.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Credito</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Credito> findAllCreditos() {
        try {
    		String jpqlString = "select credito from " + Credito.class.getSimpleName() + " credito";
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
	public List<Credito> findAllCreditosXCliente(String documentoPers, Integer idTipoDoc) {
        try {
    		String jpqlString = "select credito from " + Credito.class.getSimpleName() + " credito " +
    				" JOIN credito.tipocredito tcre " +
    				" JOIN credito.pagare pag " +
    				" JOIN pag.persona pers " +
    				" JOIN pers.municipio mcp " +
    				" JOIN mcp.departamento dpt " +
    				" JOIN dpt.pais pais " +
    				" where pers.documentoPers =:documentoPers and pers.tipodocumento.idTidoc =:idTipoDoc " +
    				" order by credito.credEstado desc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("documentoPers", documentoPers);
            query.setParameter("idTipoDoc", idTipoDoc);
            return query.getResultList();
        }catch  (Exception e){
        	e.printStackTrace();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public Credito findCreditosXPagare(long idPagare) {
        try {
    		String jpqlString = "select credito from " + Credito.class.getSimpleName() + " credito " +
    				" where credito.pagare.pagaId =:idPagare ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("idPagare", idPagare);
            return (Credito)query.getSingleResult();
        }catch  (Exception e){
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
	public void persistCredito(Credito credito) {
		em.persist(em.merge(credito));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCredito(Credito credito) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(credito));
	}
}