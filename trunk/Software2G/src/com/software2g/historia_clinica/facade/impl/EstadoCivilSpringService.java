package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Estadocivil;
import com.software2g.historia_clinica.facade.IEstadoCivilService;
import com.software2g.historia_clinica.dao.IEstadoCivilDao;

/**
 * The service class for the Estadocivil entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class EstadoCivilSpringService implements IEstadoCivilService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IEstadoCivilDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public EstadoCivilSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IEstadoCivilService</code> instance.
	 */
	public static IEstadoCivilService getInstance(ApplicationContext context) {
		return (IEstadoCivilService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Estadocivil findEstadocivilById(long id) throws Exception {
		try {
			return getDao().findEstadocivilById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEstadocivilById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Estadocivil</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Estadocivil> findAllEstadocivils() throws Exception {
		try {
			return getDao().findAllEstadocivils();
		} catch (RuntimeException e) {
			throw new Exception("findAllEstadocivils failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadocivil(Estadocivil estadocivil) throws Exception {
		try {
			getDao().persistEstadocivil(estadocivil);
		} catch (RuntimeException e) {
			throw new Exception("persistEstadocivil failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadocivil(Estadocivil estadocivil) throws Exception {
		try {
			getDao().removeEstadocivil(estadocivil);
		} catch (RuntimeException e) {
			throw new Exception("removeEstadocivil failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IEstadoCivilDao dao) {
		this.dao = dao;
	}
	public IEstadoCivilDao getDao() {
		return this.dao;
	}
}