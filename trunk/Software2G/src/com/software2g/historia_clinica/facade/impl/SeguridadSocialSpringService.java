package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Seguridadsocial;
import com.software2g.historia_clinica.facade.ISeguridadSocialService;
import com.software2g.historia_clinica.dao.ISeguridadSocialDao;

/**
 * The service class for the Seguridadsocial entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class SeguridadSocialSpringService implements ISeguridadSocialService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ISeguridadSocialDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public SeguridadSocialSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ISeguridadSocialService</code> instance.
	 */
	public static ISeguridadSocialService getInstance(ApplicationContext context) {
		return (ISeguridadSocialService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Seguridadsocial findSeguridadsocialById(long id) throws Exception {
		try {
			return getDao().findSeguridadsocialById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSeguridadsocialById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Seguridadsocial</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Seguridadsocial> findAllSeguridadsocials() throws Exception {
		try {
			return getDao().findAllSeguridadsocials();
		} catch (RuntimeException e) {
			throw new Exception("findAllSeguridadsocials failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception {
		try {
			getDao().persistSeguridadsocial(seguridadsocial);
		} catch (RuntimeException e) {
			throw new Exception("persistSeguridadsocial failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception {
		try {
			getDao().removeSeguridadsocial(seguridadsocial);
		} catch (RuntimeException e) {
			throw new Exception("removeSeguridadsocial failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ISeguridadSocialDao dao) {
		this.dao = dao;
	}
	public ISeguridadSocialDao getDao() {
		return this.dao;
	}
}