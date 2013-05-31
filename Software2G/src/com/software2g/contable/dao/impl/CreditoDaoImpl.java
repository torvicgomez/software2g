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
    @PersistenceContext
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
	public List<Credito> findAllCreditosXCliente(String documentoPers) {
        try {
        	System.out.println("Entra esta metodo");
    		String jpqlString = "select credito from " + Credito.class.getSimpleName() + " credito " +
    				" JOIN credito.tipocredito tcre " +
    				" JOIN credito.pagare pag " +
    				" JOIN pag.persona pers " +
    				" where pers.documentoPers =: documentoPers ";
    		/*
    		select per.pnombre_pers||' '||per.snombre_pers||' '||per.papellido_pers||' '||per.sapellido_pers as nombreCompl,
			cred.cred_id, tcre.ticr_descripcion, pag.paga_id,
			cred.cred_nrocheque, cred.cred_montocredito, cred.cred_saldo, 
			cred.cred_fechaultimopago, cred.cred_estado
			from portal.persona per
			inner join contable.pagare pag on (pag.id_pers = per.id_pers)
			inner join contable.credito cred on (cred.paga_id = pag.paga_id)
			inner join contable.tipocredito tcre on (tcre.ticr_id = cred.ticr_id)
			where per.documento_pers = '75106199';
    		*/
    		
    		System.out.println("jpqlString: ["+jpqlString+"]");
            Query query = em.createQuery( jpqlString );
            query.setParameter("documentoPers", documentoPers);
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