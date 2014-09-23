package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Posicion;
import com.software2g.historia_clinica.facade.IPosicionService;
import com.software2g.historia_clinica.dao.IPosicionDao;

/**
 * The service class for the Posicion entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class PosicionSpringService implements IPosicionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IPosicionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public PosicionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IPosicionService</code> instance.
	 */
	public static IPosicionService getInstance(ApplicationContext context) {
		return (IPosicionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Posicion findPosicionById(long id) throws Exception {
		try {
			return getDao().findPosicionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPosicionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Posicion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Posicion> findAllPosicions() throws Exception {
		try {
			return getDao().findAllPosicions();
		} catch (RuntimeException e) {
			throw new Exception("findAllPosicions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPosicion(Posicion posicion) throws Exception {
		try {
			getDao().persistPosicion(posicion);
		} catch (RuntimeException e) {
			throw new Exception("persistPosicion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePosicion(Posicion posicion) throws Exception {
		try {
			getDao().removePosicion(posicion);
		} catch (RuntimeException e) {
			throw new Exception("removePosicion failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IPosicionDao dao) {
		this.dao = dao;
	}
	public IPosicionDao getDao() {
		return this.dao;
	}
}