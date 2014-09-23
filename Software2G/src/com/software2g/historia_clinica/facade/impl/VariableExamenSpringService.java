package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Variableexamen;
import com.software2g.historia_clinica.facade.IVariableExamenService;
import com.software2g.historia_clinica.dao.IVariableExamenDao;

/**
 * The service class for the Variableexamen entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class VariableExamenSpringService implements IVariableExamenService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IVariableExamenDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public VariableExamenSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IVariableExamenService</code> instance.
	 */
	public static IVariableExamenService getInstance(ApplicationContext context) {
		return (IVariableExamenService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Variableexamen findVariableexamenById(long id) throws Exception {
		try {
			return getDao().findVariableexamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVariableexamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Variableexamen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Variableexamen> findAllVariableexamens() throws Exception {
		try {
			return getDao().findAllVariableexamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllVariableexamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableexamen(Variableexamen variableexamen) throws Exception {
		try {
			getDao().persistVariableexamen(variableexamen);
		} catch (RuntimeException e) {
			throw new Exception("persistVariableexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableexamen(Variableexamen variableexamen) throws Exception {
		try {
			getDao().removeVariableexamen(variableexamen);
		} catch (RuntimeException e) {
			throw new Exception("removeVariableexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IVariableExamenDao dao) {
		this.dao = dao;
	}
	public IVariableExamenDao getDao() {
		return this.dao;
	}
}