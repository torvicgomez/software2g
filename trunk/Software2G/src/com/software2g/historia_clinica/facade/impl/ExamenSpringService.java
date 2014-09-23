package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Examen;
import com.software2g.historia_clinica.facade.IExamenService;
import com.software2g.historia_clinica.dao.IExamenDao;

/**
 * The service class for the Examen entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ExamenSpringService implements IExamenService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IExamenDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public ExamenSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IExamenService</code> instance.
	 */
	public static IExamenService getInstance(ApplicationContext context) {
		return (IExamenService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Examen findExamenById(long id) throws Exception {
		try {
			return getDao().findExamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findExamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Examen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examen> findAllExamens() throws Exception {
		try {
			return getDao().findAllExamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllExamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamen(Examen examen) throws Exception {
		try {
			getDao().persistExamen(examen);
		} catch (RuntimeException e) {
			throw new Exception("persistExamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamen(Examen examen) throws Exception {
		try {
			getDao().removeExamen(examen);
		} catch (RuntimeException e) {
			throw new Exception("removeExamen failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IExamenDao dao) {
		this.dao = dao;
	}
	public IExamenDao getDao() {
		return this.dao;
	}
}