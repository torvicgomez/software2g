package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Examenpartecuerpo;
import com.software2g.historia_clinica.facade.IExamenParteCuerpoService;
import com.software2g.historia_clinica.dao.IExamenParteCuerpoDao;

/**
 * The service class for the Examenpartecuerpo entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ExamenParteCuerpoSpringService implements IExamenParteCuerpoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IExamenParteCuerpoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public ExamenParteCuerpoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IExamenParteCuerpoService</code> instance.
	 */
	public static IExamenParteCuerpoService getInstance(ApplicationContext context) {
		return (IExamenParteCuerpoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Examenpartecuerpo findExamenpartecuerpoById(long id) throws Exception {
		try {
			return getDao().findExamenpartecuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findExamenpartecuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Examenpartecuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examenpartecuerpo> findAllExamenpartecuerpos() throws Exception {
		try {
			return getDao().findAllExamenpartecuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllExamenpartecuerpos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception {
		try {
			getDao().persistExamenpartecuerpo(examenpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistExamenpartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception {
		try {
			getDao().removeExamenpartecuerpo(examenpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removeExamenpartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IExamenParteCuerpoDao dao) {
		this.dao = dao;
	}
	public IExamenParteCuerpoDao getDao() {
		return this.dao;
	}
}