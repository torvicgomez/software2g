package com.software2g.contable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.contable.dao.IDonacionDao;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Donacion;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Donacion entity.
 */
@Repository
public class DonacionDaoImpl implements IDonacionDao {
    @PersistenceContext
    private EntityManager em;

	public DonacionDaoImpl() {
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
	public Donacion findDonacionById(long id) {
		return (Donacion)em.find(Donacion.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Donacion</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Donacion> findAllDonacions() {
        try {
    		String jpqlString = "select donacion from " + Donacion.class.getSimpleName() + " donacion";
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
	public Donacion findIdDonacion(String fecha, String hora) {
        try {
    		String jpqlString = "select donacion from " + Donacion.class.getSimpleName() + " donacion " +
    				" where donacion.donaFechamodificacion=:fecha and donacion.donaHora=:hora ";
    		System.out.println("fecha: ["+fecha+"]");
    		System.out.println("hora: ["+hora+"]");
            Query query = em.createQuery( jpqlString );
            query.setParameter("fecha", fecha);
            query.setParameter("hora", hora);
            return (Donacion)query.getSingleResult();
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
	public void persistDonacion(Donacion donacion) {
		em.persist(em.merge(donacion));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDonacion(Donacion donacion) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(donacion));
	}
	
	@SuppressWarnings("unchecked")
	public List<Donacion> findDonacionIdEntidad(long idEntidad) {
        try {
    		String jpqlString = "select donacion from " + Donacion.class.getSimpleName() + " donacion " +
    				" where donacion.entidaddonante.endoId=:idEntidad " +
    				" and donacion.donaEstado=:estado " +
    				" order by donacion.donaDescripcion asc ";
    		System.out.println("idEntidad: ["+idEntidad+"]");
            Query query = em.createQuery( jpqlString );
            query.setParameter("idEntidad", idEntidad);
            query.setParameter("estado", ConstantesAplicativo.estadoDonacion);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
}