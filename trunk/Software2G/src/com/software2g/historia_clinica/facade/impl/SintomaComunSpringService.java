package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Sintomacomun;
import com.software2g.historia_clinica.facade.ISintomaComunService;
import com.software2g.historia_clinica.dao.ISintomaComunDao;

/**
 * The service class for the Sintomacomun entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class SintomaComunSpringService implements ISintomaComunService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ISintomaComunDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public SintomaComunSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ISintomaComunService</code> instance.
	 */
	public static ISintomaComunService getInstance(ApplicationContext context) {
		return (ISintomaComunService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Sintomacomun findSintomacomunById(long id) throws Exception {
		try {
			return getDao().findSintomacomunById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSintomacomunById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Sintomacomun</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Sintomacomun> findAllSintomacomuns() throws Exception {
		try {
			return getDao().findAllSintomacomuns();
		} catch (RuntimeException e) {
			throw new Exception("findAllSintomacomuns failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintomacomun(Sintomacomun sintomacomun) throws Exception {
		try {
			getDao().persistSintomacomun(sintomacomun);
		} catch (RuntimeException e) {
			throw new Exception("persistSintomacomun failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintomacomun(Sintomacomun sintomacomun) throws Exception {
		try {
			getDao().removeSintomacomun(sintomacomun);
		} catch (RuntimeException e) {
			throw new Exception("removeSintomacomun failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ISintomaComunDao dao) {
		this.dao = dao;
	}
	public ISintomaComunDao getDao() {
		return this.dao;
	}
}