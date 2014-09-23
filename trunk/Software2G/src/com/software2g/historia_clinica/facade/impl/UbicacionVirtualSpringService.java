package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Ubicacionvirtual;
import com.software2g.historia_clinica.facade.IUbicacionVirtualService;
import com.software2g.historia_clinica.dao.IUbicacionVirtualDao;

/**
 * The service class for the Ubicacionvirtual entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UbicacionVirtualSpringService implements IUbicacionVirtualService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IUbicacionVirtualDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public UbicacionVirtualSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IUbicacionVirtualService</code> instance.
	 */
	public static IUbicacionVirtualService getInstance(ApplicationContext context) {
		return (IUbicacionVirtualService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ubicacionvirtual findUbicacionvirtualById(long id) throws Exception {
		try {
			return getDao().findUbicacionvirtualById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUbicacionvirtualById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ubicacionvirtual</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ubicacionvirtual> findAllUbicacionvirtuals() throws Exception {
		try {
			return getDao().findAllUbicacionvirtuals();
		} catch (RuntimeException e) {
			throw new Exception("findAllUbicacionvirtuals failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception {
		try {
			getDao().persistUbicacionvirtual(ubicacionvirtual);
		} catch (RuntimeException e) {
			throw new Exception("persistUbicacionvirtual failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception {
		try {
			getDao().removeUbicacionvirtual(ubicacionvirtual);
		} catch (RuntimeException e) {
			throw new Exception("removeUbicacionvirtual failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IUbicacionVirtualDao dao) {
		this.dao = dao;
	}
	public IUbicacionVirtualDao getDao() {
		return this.dao;
	}
}