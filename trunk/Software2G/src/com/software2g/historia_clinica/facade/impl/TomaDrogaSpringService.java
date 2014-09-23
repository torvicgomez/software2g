package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tomasinodroga;
import com.software2g.historia_clinica.facade.ITomaDrogaService;
import com.software2g.historia_clinica.dao.ITomaDrogaDao;

/**
 * The service class for the Tomasinodroga entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TomaDrogaSpringService implements ITomaDrogaService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITomaDrogaDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TomaDrogaSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITomaDrogaService</code> instance.
	 */
	public static ITomaDrogaService getInstance(ApplicationContext context) {
		return (ITomaDrogaService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tomasinodroga findTomasinodrogaById(long id) throws Exception {
		try {
			return getDao().findTomasinodrogaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTomasinodrogaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tomasinodroga</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tomasinodroga> findAllTomasinodrogas() throws Exception {
		try {
			return getDao().findAllTomasinodrogas();
		} catch (RuntimeException e) {
			throw new Exception("findAllTomasinodrogas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTomasinodroga(Tomasinodroga tomasinodroga) throws Exception {
		try {
			getDao().persistTomasinodroga(tomasinodroga);
		} catch (RuntimeException e) {
			throw new Exception("persistTomasinodroga failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTomasinodroga(Tomasinodroga tomasinodroga) throws Exception {
		try {
			getDao().removeTomasinodroga(tomasinodroga);
		} catch (RuntimeException e) {
			throw new Exception("removeTomasinodroga failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITomaDrogaDao dao) {
		this.dao = dao;
	}
	public ITomaDrogaDao getDao() {
		return this.dao;
	}
}