package com.software2g.niif.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Archivotabla;
import com.software2g.niif.dao.IArchivoTablaDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Archivotabla entity.
 */
@Repository
public class ArchivoTablaDaoImpl implements IArchivoTablaDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public ArchivoTablaDaoImpl() {
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
	public Archivotabla findArchivotablaById(long id) {
		return (Archivotabla)em.find(Archivotabla.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Archivotabla</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Archivotabla> findAllArchivotablas() {
        try {
    		String jpqlString = "select archivotabla from " + Archivotabla.class.getSimpleName() + " archivotabla";
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
	public void persistArchivotabla(Archivotabla archivotabla) {
		em.persist(em.merge(archivotabla));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivotabla(Archivotabla archivotabla) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(archivotabla));
	}
	
	/**
	 * Consulta el ultimo registro de archivo tabla por desc tabla y idregistro
	 * @param tabla
	 * @param idRegistro
	 * @return
	 */
	public Archivotabla findArchivotablaByTablaIdRegistro(String tabla, String idRegistro) {
        try {
    		String jpqlString = "select archivotabla from " + Archivotabla.class.getSimpleName() + " archivotabla " +
    							"where archivotabla.artaTabla=:tabla " +
    							"and archivotabla.artaIdtabla=:idRegistro " +
    							"order by archivotabla.artaFechacambio desc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("tabla", tabla);
            query.setParameter("idRegistro", idRegistro);
            return (Archivotabla)query.getSingleResult();
        }
        catch (NoResultException nre) {
			System.out.println("NORESULT ::> ArchivoTablaDAOImpl ::> findArchivotablaByTablaIdRegistro ::> "+nre.getMessage());
			return null;
		}
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	
	/**
	 * Consulta todos los archivos de tabla por desc tabla y idregistro
	 * @param tabla
	 * @param idRegistro
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Archivotabla> findAllArchivotablasByTablaIdRegistro(String tabla, String idRegistro) {
        try {
    		String jpqlString = "select archivotabla from " + Archivotabla.class.getSimpleName() + " archivotabla " +
    							"where archivotabla.artaTabla=:tabla " +
    							"and archivotabla.artaIdtabla=:idRegistro " +
    							"order by archivotabla.artaFechacambio desc ";
            Query query = em.createQuery( jpqlString );
            query.setParameter("tabla", tabla);
            query.setParameter("idRegistro", idRegistro);
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
}