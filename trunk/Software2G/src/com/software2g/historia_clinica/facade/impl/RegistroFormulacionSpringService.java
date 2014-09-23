package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Registroformulacion;
import com.software2g.historia_clinica.facade.IRegistroFormulacionService;
import com.software2g.historia_clinica.dao.IRegistroFormulacionDao;

/**
 * The service class for the Registroformulacion entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class RegistroFormulacionSpringService implements IRegistroFormulacionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IRegistroFormulacionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public RegistroFormulacionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IRegistroFormulacionService</code> instance.
	 */
	public static IRegistroFormulacionService getInstance(ApplicationContext context) {
		return (IRegistroFormulacionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroformulacion findRegistroformulacionById(long id) throws Exception {
		try {
			return getDao().findRegistroformulacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroformulacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroformulacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroformulacion> findAllRegistroformulacions() throws Exception {
		try {
			return getDao().findAllRegistroformulacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroformulacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroformulacion(Registroformulacion registroformulacion) throws Exception {
		try {
			getDao().persistRegistroformulacion(registroformulacion);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroformulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroformulacion(Registroformulacion registroformulacion) throws Exception {
		try {
			getDao().removeRegistroformulacion(registroformulacion);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroformulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IRegistroFormulacionDao dao) {
		this.dao = dao;
	}
	public IRegistroFormulacionDao getDao() {
		return this.dao;
	}
}