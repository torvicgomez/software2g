package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Telefono;
import com.software2g.historia_clinica.facade.ITelefonoService;
import com.software2g.historia_clinica.dao.ITelefonoDao;

/**
 * The service class for the Telefono entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TelefonoSpringService implements ITelefonoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITelefonoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TelefonoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITelefonoService</code> instance.
	 */
	public static ITelefonoService getInstance(ApplicationContext context) {
		return (ITelefonoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Telefono findTelefonoById(long id) throws Exception {
		try {
			return getDao().findTelefonoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTelefonoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Telefono</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Telefono> findAllTelefonos() throws Exception {
		try {
			return getDao().findAllTelefonos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTelefonos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTelefono(Telefono telefono) throws Exception {
		try {
			getDao().persistTelefono(telefono);
		} catch (RuntimeException e) {
			throw new Exception("persistTelefono failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTelefono(Telefono telefono) throws Exception {
		try {
			getDao().removeTelefono(telefono);
		} catch (RuntimeException e) {
			throw new Exception("removeTelefono failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITelefonoDao dao) {
		this.dao = dao;
	}
	public ITelefonoDao getDao() {
		return this.dao;
	}
}