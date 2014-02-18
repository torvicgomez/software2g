package com.software2g.portal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.portal.dao.IFuncionalidadDao;
import com.software2g.vo.Funcionalidad;
import com.software2g.vo.Funcionalidadrol;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Funcionalidad entity.
 */
@Repository
public class FuncionalidadDaoImpl implements IFuncionalidadDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public FuncionalidadDaoImpl() {
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
	public Funcionalidad findFuncionalidadById(java.lang.Integer id) {
		return (Funcionalidad)em.find(Funcionalidad.class, id);
	}
	/**
	 * Return all persistent instances of the <code>Funcionalidad</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionalidad> findAllFuncionalidads() {
        try {
    		String jpqlString = "select funcionalidad from " + Funcionalidad.class.getSimpleName() + " funcionalidad";
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
	public void persistFuncionalidad(Funcionalidad funcionalidad) {
		em.persist(em.merge(funcionalidad));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFuncionalidad(Funcionalidad funcionalidad) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(funcionalidad));
	}
	
	public List<Funcionalidad> getFunctionApplication(String funcIdPadre, String funcId, long rolId){
		List<Funcionalidad> funcionalidades = null;
		try {
    		String sqlString = " select func.id_func, func.id_func_padre, func.nombre_func, " +
    				" func.etiqueta_func, func.estado_func, " +
    				" case when funr.id_rol is not null then 'S' else 'N' end as existe " +
    				" from portal.funcionalidad func" +
    				" left outer join portal.funcionalidadrol funr on (func.id_func = funr.id_func and funr.id_rol = "+rolId+") " +
    				" where func.id_func_padre "+(funcIdPadre!=null&&!funcIdPadre.equals("")?" = "+funcIdPadre:"is null ")+" " +
					" "+(funcId!=null&&!funcId.equals("")?"and func.id_func = "+funcId+"":"")+" " + 
					" order by func.etiqueta_func asc ";
//    		System.out.println("********************************************");
//    		System.out.println("SQL:["+sqlString+"]");
//    		System.out.println("rolId: ["+rolId+"]");
//    		System.out.println("********************************************");
            Query query = em.createNativeQuery( sqlString ); 
            List<Object[]> listFunctionApl = query.getResultList();
            if(listFunctionApl!=null&&listFunctionApl.size()>0){
            	funcionalidades = new ArrayList<Funcionalidad>();
            	for(Object[] elem:listFunctionApl){
            		Funcionalidad dato = new Funcionalidad();
            		dato.setIdFunc(Integer.parseInt(elem[0].toString()));
            		//Creacion de objeto padre
            		if(elem[1]!=null){
            			Funcionalidad datoPadre = new Funcionalidad();
            			datoPadre.setIdFunc(Integer.parseInt(elem[1].toString()));
            			dato.setFuncionalidad(datoPadre);
            		}
            		//Fin creacion objeto padre
            		dato.setNombreFunc((String)elem[2]);
            		dato.setEtiquetaFunc((String)elem[3]);
            		dato.setEstadoFunc((String)elem[4]);
            		dato.setChecked((String)elem[5]);
            		dato.setFuncionalidads(getFunctionApplication(String.valueOf(dato.getIdFunc()),null,rolId));
            		funcionalidades.add(dato);
            	}
            }
            return funcionalidades;
        }
        finally {
            if (em != null) {
                em.close();
            }
        } 
	}
	
	
	
	
}