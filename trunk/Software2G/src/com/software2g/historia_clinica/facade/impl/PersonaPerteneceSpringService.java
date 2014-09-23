package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Personapertenece;
import com.software2g.historia_clinica.facade.IPersonaPerteneceService;
import com.software2g.historia_clinica.dao.IPersonaPerteneceDao;

/**
 * The service class for the Personapertenece entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class PersonaPerteneceSpringService implements IPersonaPerteneceService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IPersonaPerteneceDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public PersonaPerteneceSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IPersonaPerteneceService</code> instance.
	 */
	public static IPersonaPerteneceService getInstance(ApplicationContext context) {
		return (IPersonaPerteneceService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Personapertenece findPersonaperteneceById(com.software2g.vo.PersonapertenecePK id) throws Exception {
		try {
			return getDao().findPersonaperteneceById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonaperteneceById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Personapertenece</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Personapertenece> findAllPersonaperteneces() throws Exception {
		try {
			return getDao().findAllPersonaperteneces();
		} catch (RuntimeException e) {
			throw new Exception("findAllPersonaperteneces failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonapertenece(Personapertenece personapertenece) throws Exception {
		try {
			getDao().persistPersonapertenece(personapertenece);
		} catch (RuntimeException e) {
			throw new Exception("persistPersonapertenece failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonapertenece(Personapertenece personapertenece) throws Exception {
		try {
			getDao().removePersonapertenece(personapertenece);
		} catch (RuntimeException e) {
			throw new Exception("removePersonapertenece failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IPersonaPerteneceDao dao) {
		this.dao = dao;
	}
	public IPersonaPerteneceDao getDao() {
		return this.dao;
	}
}