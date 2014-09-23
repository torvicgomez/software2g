package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Especificaexamen;
import com.software2g.historia_clinica.facade.IEspecificaExamenService;
import com.software2g.historia_clinica.dao.IEspecificaExamenDao;

/**
 * The service class for the Especificaexamen entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class EspecificaExamenSpringService implements IEspecificaExamenService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IEspecificaExamenDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public EspecificaExamenSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IEspecificaExamenService</code> instance.
	 */
	public static IEspecificaExamenService getInstance(ApplicationContext context) {
		return (IEspecificaExamenService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificaexamen findEspecificaexamenById(long id) throws Exception {
		try {
			return getDao().findEspecificaexamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificaexamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Especificaexamen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Especificaexamen> findAllEspecificaexamens() throws Exception {
		try {
			return getDao().findAllEspecificaexamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllEspecificaexamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificaexamen(Especificaexamen especificaexamen) throws Exception {
		try {
			getDao().persistEspecificaexamen(especificaexamen);
		} catch (RuntimeException e) {
			throw new Exception("persistEspecificaexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificaexamen(Especificaexamen especificaexamen) throws Exception {
		try {
			getDao().removeEspecificaexamen(especificaexamen);
		} catch (RuntimeException e) {
			throw new Exception("removeEspecificaexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IEspecificaExamenDao dao) {
		this.dao = dao;
	}
	public IEspecificaExamenDao getDao() {
		return this.dao;
	}
}