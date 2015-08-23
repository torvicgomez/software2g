package com.software2g.niif.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.software2g.vo.Ordencompra;
import com.software2g.vo.Venta;
import com.software2g.niif.dao.IVentaDao;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Venta entity.
 */
@Repository
public class VentaDAOImpl implements IVentaDao {
	@PersistenceContext(unitName="entityManagerFactoryPostgres")
    private EntityManager em;

	public VentaDAOImpl() {
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
	public Venta findVentaById(long id) {
		return (Venta)em.find(Venta.class, new Long(id));
	}
	/**
	 * Return all persistent instances of the <code>Venta</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Venta> findAllVentas() {
        try {
    		String jpqlString = "select venta from " + Venta.class.getSimpleName() + " venta " +
    				"order by venta.ventEstado desc, venta.ventFecha asc ";
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
	public void persistVenta(Venta venta) {
		em.persist(em.merge(venta));
	}
	
	public long persistVentaId(Venta venta) {
		Venta obj = em.merge(venta); 
		em.persist(obj); 
		return obj.getVentId();
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVenta(Venta venta) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(venta));
	}
	
	@SuppressWarnings("unchecked")
	public List<Venta> findAllVentasReport() {
        try {
    		String sqlString = " select case substring(t.fecha_venta from 6 for 2)" +
    				"	when '01' then 'Enero de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '02' then 'Febrero de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '03' then 'Marzo de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '04' then 'Abril de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '05' then 'Mayo de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '06' then 'Junio de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '07' then 'Julio de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '08' then 'Agosto de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '09' then 'Septiembre de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '10' then 'Octubre de '||substring(t.fecha_venta from 0 for 5)" +
    				"	when '11' then 'Noviembre de '||substring(t.fecha_venta from 0 for 5)" +
    				"	else 'Diciembre de '||substring(t.fecha_venta from 0 for 5)" +
    				"	end as formatFecha," +
    				"	t.fecha_venta, sum(t.vent_totalpag) as total_venta_mes " +
    				" from (select substring(vent_fecha from 0 for 8) as fecha_venta, substring(vent_fecha from 6 for 2), vent_totalpag from niif.venta) as t" +
    				" group by t.fecha_venta, formatFecha " +
    				" order by t.fecha_venta asc ";
    		System.out.println("SQL:["+sqlString+"]");
            Query query = em.createNativeQuery( sqlString );
            List<Object[]> list = query.getResultList();
            System.out.println("list:["+list+"]");
            List<Venta> listVentaReport = new ArrayList<Venta>();
            if(list!=null&&list.size()>0){
            	System.out.println("Entra este Ciclo!!!!");
            	for(Object[] elem:list){
            		Venta venta = new Venta();
            		venta.setFormatoFechaReport(elem[0].toString());
            		venta.setFechaReport(elem[1].toString());
            		venta.setTotalMesVentaReport(Double.parseDouble(elem[2].toString()));
            		listVentaReport.add(venta);
            	}
            }
            return listVentaReport;
        }catch(Exception e){
        	e.printStackTrace();
        	return null;	
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}

	public List<Venta> findAllVentas(String fechaMesVenta) {
        try {
    		String jpqlString = "select venta from " + Venta.class.getSimpleName() + " venta " +
    				" where venta.ventFecha like :fechaMesVenta " +
    				" order by venta.ventFecha asc "; 
    		System.out.println("fechaMesVenta:["+fechaMesVenta+"]");
            Query query = em.createQuery( jpqlString );
            query.setParameter("fechaMesVenta", fechaMesVenta+"%");
            return query.getResultList();
        }catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
}