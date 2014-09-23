package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tipovirtuallink;
import com.software2g.historia_clinica.facade.ITipoVirtualLinkService;
import com.software2g.historia_clinica.dao.ITipoVirtualLinkDao;

/**
 * The service class for the Tipovirtuallink entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoVirtualLinkSpringService implements ITipoVirtualLinkService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoVirtualLinkDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoVirtualLinkSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoVirtualLinkService</code> instance.
	 */
	public static ITipoVirtualLinkService getInstance(ApplicationContext context) {
		return (ITipoVirtualLinkService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipovirtuallink findTipovirtuallinkById(long id) throws Exception {
		try {
			return getDao().findTipovirtuallinkById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipovirtuallinkById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipovirtuallink</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipovirtuallink> findAllTipovirtuallinks() throws Exception {
		try {
			return getDao().findAllTipovirtuallinks();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipovirtuallinks failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception {
		try {
			getDao().persistTipovirtuallink(tipovirtuallink);
		} catch (RuntimeException e) {
			throw new Exception("persistTipovirtuallink failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception {
		try {
			getDao().removeTipovirtuallink(tipovirtuallink);
		} catch (RuntimeException e) {
			throw new Exception("removeTipovirtuallink failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoVirtualLinkDao dao) {
		this.dao = dao;
	}
	public ITipoVirtualLinkDao getDao() {
		return this.dao;
	}
}