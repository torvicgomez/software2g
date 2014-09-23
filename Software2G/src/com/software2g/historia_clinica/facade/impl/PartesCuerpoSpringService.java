package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Partescuerpo;
import com.software2g.historia_clinica.facade.IPartesCuerpoService;
import com.software2g.historia_clinica.dao.IPartesCuerpoDao;

/**
 * The service class for the Partescuerpo entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class PartesCuerpoSpringService implements IPartesCuerpoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IPartesCuerpoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public PartesCuerpoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IPartesCuerpoService</code> instance.
	 */
	public static IPartesCuerpoService getInstance(ApplicationContext context) {
		return (IPartesCuerpoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Partescuerpo findPartescuerpoById(long id) throws Exception {
		try {
			return getDao().findPartescuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPartescuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Partescuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Partescuerpo> findAllPartescuerpos() throws Exception {
		try {
			return getDao().findAllPartescuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllPartescuerpos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartescuerpo(Partescuerpo partescuerpo) throws Exception {
		try {
			getDao().persistPartescuerpo(partescuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistPartescuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartescuerpo(Partescuerpo partescuerpo) throws Exception {
		try {
			getDao().removePartescuerpo(partescuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removePartescuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IPartesCuerpoDao dao) {
		this.dao = dao;
	}
	public IPartesCuerpoDao getDao() {
		return this.dao;
	}
}