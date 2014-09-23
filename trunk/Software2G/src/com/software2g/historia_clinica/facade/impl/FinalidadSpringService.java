package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Finalidad;
import com.software2g.historia_clinica.facade.IFinalidadService;
import com.software2g.historia_clinica.dao.IFinalidadDao;

/**
 * The service class for the Finalidad entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class FinalidadSpringService implements IFinalidadService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IFinalidadDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public FinalidadSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IFinalidadService</code> instance.
	 */
	public static IFinalidadService getInstance(ApplicationContext context) {
		return (IFinalidadService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Finalidad findFinalidadById(long id) throws Exception {
		try {
			return getDao().findFinalidadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFinalidadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Finalidad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Finalidad> findAllFinalidads() throws Exception {
		try {
			return getDao().findAllFinalidads();
		} catch (RuntimeException e) {
			throw new Exception("findAllFinalidads failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFinalidad(Finalidad finalidad) throws Exception {
		try {
			getDao().persistFinalidad(finalidad);
		} catch (RuntimeException e) {
			throw new Exception("persistFinalidad failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFinalidad(Finalidad finalidad) throws Exception {
		try {
			getDao().removeFinalidad(finalidad);
		} catch (RuntimeException e) {
			throw new Exception("removeFinalidad failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IFinalidadDao dao) {
		this.dao = dao;
	}
	public IFinalidadDao getDao() {
		return this.dao;
	}
}