package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Registroexamen;
import com.software2g.historia_clinica.facade.IRegistroExamenService;
import com.software2g.historia_clinica.dao.IRegistroExamenDao;

/**
 * The service class for the Registroexamen entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class RegistroExamenSpringService implements IRegistroExamenService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IRegistroExamenDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public RegistroExamenSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IRegistroExamenService</code> instance.
	 */
	public static IRegistroExamenService getInstance(ApplicationContext context) {
		return (IRegistroExamenService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroexamen findRegistroexamenById(long id) throws Exception {
		try {
			return getDao().findRegistroexamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroexamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroexamen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroexamen> findAllRegistroexamens() throws Exception {
		try {
			return getDao().findAllRegistroexamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroexamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroexamen(Registroexamen registroexamen) throws Exception {
		try {
			getDao().persistRegistroexamen(registroexamen);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroexamen(Registroexamen registroexamen) throws Exception {
		try {
			getDao().removeRegistroexamen(registroexamen);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IRegistroExamenDao dao) {
		this.dao = dao;
	}
	public IRegistroExamenDao getDao() {
		return this.dao;
	}
}