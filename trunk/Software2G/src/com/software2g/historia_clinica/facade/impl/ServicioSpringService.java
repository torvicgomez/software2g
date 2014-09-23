package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Servicio;
import com.software2g.historia_clinica.facade.IServicioService;
import com.software2g.historia_clinica.dao.IServicioDao;

/**
 * The service class for the Servicio entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ServicioSpringService implements IServicioService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IServicioDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public ServicioSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IServicioService</code> instance.
	 */
	public static IServicioService getInstance(ApplicationContext context) {
		return (IServicioService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Servicio findServicioById(long id) throws Exception {
		try {
			return getDao().findServicioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findServicioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Servicio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Servicio> findAllServicios() throws Exception {
		try {
			return getDao().findAllServicios();
		} catch (RuntimeException e) {
			throw new Exception("findAllServicios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistServicio(Servicio servicio) throws Exception {
		try {
			getDao().persistServicio(servicio);
		} catch (RuntimeException e) {
			throw new Exception("persistServicio failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeServicio(Servicio servicio) throws Exception {
		try {
			getDao().removeServicio(servicio);
		} catch (RuntimeException e) {
			throw new Exception("removeServicio failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IServicioDao dao) {
		this.dao = dao;
	}
	public IServicioDao getDao() {
		return this.dao;
	}
}