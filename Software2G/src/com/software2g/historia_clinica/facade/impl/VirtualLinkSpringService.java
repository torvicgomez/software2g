package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Virtuallink;
import com.software2g.historia_clinica.facade.IVirtualLinkService;
import com.software2g.historia_clinica.dao.IVirtualLinkDao;

/**
 * The service class for the Virtuallink entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class VirtualLinkSpringService implements IVirtualLinkService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IVirtualLinkDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public VirtualLinkSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IVirtualLinkService</code> instance.
	 */
	public static IVirtualLinkService getInstance(ApplicationContext context) {
		return (IVirtualLinkService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Virtuallink findVirtuallinkById(long id) throws Exception {
		try {
			return getDao().findVirtuallinkById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVirtuallinkById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Virtuallink</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Virtuallink> findAllVirtuallinks() throws Exception {
		try {
			return getDao().findAllVirtuallinks();
		} catch (RuntimeException e) {
			throw new Exception("findAllVirtuallinks failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVirtuallink(Virtuallink virtuallink) throws Exception {
		try {
			getDao().persistVirtuallink(virtuallink);
		} catch (RuntimeException e) {
			throw new Exception("persistVirtuallink failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVirtuallink(Virtuallink virtuallink) throws Exception {
		try {
			getDao().removeVirtuallink(virtuallink);
		} catch (RuntimeException e) {
			throw new Exception("removeVirtuallink failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IVirtualLinkDao dao) {
		this.dao = dao;
	}
	public IVirtualLinkDao getDao() {
		return this.dao;
	}
}