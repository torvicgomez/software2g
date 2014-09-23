package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Remision;
import com.software2g.historia_clinica.facade.IRemisionService;
import com.software2g.historia_clinica.dao.IRemisionDao;

/**
 * The service class for the Remision entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class RemisionSpringService implements IRemisionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IRemisionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public RemisionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IRemisionService</code> instance.
	 */
	public static IRemisionService getInstance(ApplicationContext context) {
		return (IRemisionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Remision findRemisionById(long id) throws Exception {
		try {
			return getDao().findRemisionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRemisionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Remision</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Remision> findAllRemisions() throws Exception {
		try {
			return getDao().findAllRemisions();
		} catch (RuntimeException e) {
			throw new Exception("findAllRemisions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRemision(Remision remision) throws Exception {
		try {
			getDao().persistRemision(remision);
		} catch (RuntimeException e) {
			throw new Exception("persistRemision failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRemision(Remision remision) throws Exception {
		try {
			getDao().removeRemision(remision);
		} catch (RuntimeException e) {
			throw new Exception("removeRemision failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IRemisionDao dao) {
		this.dao = dao;
	}
	public IRemisionDao getDao() {
		return this.dao;
	}
}