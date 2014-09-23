package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Parentesco;
import com.software2g.historia_clinica.facade.IParentescoService;
import com.software2g.historia_clinica.dao.IParentescoDao;

/**
 * The service class for the Parentesco entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ParentescoSpringService implements IParentescoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IParentescoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public ParentescoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IParentescoService</code> instance.
	 */
	public static IParentescoService getInstance(ApplicationContext context) {
		return (IParentescoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Parentesco findParentescoById(long id) throws Exception {
		try {
			return getDao().findParentescoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findParentescoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Parentesco</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Parentesco> findAllParentescos() throws Exception {
		try {
			return getDao().findAllParentescos();
		} catch (RuntimeException e) {
			throw new Exception("findAllParentescos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParentesco(Parentesco parentesco) throws Exception {
		try {
			getDao().persistParentesco(parentesco);
		} catch (RuntimeException e) {
			throw new Exception("persistParentesco failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParentesco(Parentesco parentesco) throws Exception {
		try {
			getDao().removeParentesco(parentesco);
		} catch (RuntimeException e) {
			throw new Exception("removeParentesco failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IParentescoDao dao) {
		this.dao = dao;
	}
	public IParentescoDao getDao() {
		return this.dao;
	}
}