package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Formulacion;
import com.software2g.historia_clinica.facade.IFormulacionService;
import com.software2g.historia_clinica.dao.IFormulacionDao;

/**
 * The service class for the Formulacion entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class FormulacionSpringService implements IFormulacionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IFormulacionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public FormulacionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IFormulacionService</code> instance.
	 */
	public static IFormulacionService getInstance(ApplicationContext context) {
		return (IFormulacionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Formulacion findFormulacionById(long id) throws Exception {
		try {
			return getDao().findFormulacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFormulacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Formulacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Formulacion> findAllFormulacions() throws Exception {
		try {
			return getDao().findAllFormulacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllFormulacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormulacion(Formulacion formulacion) throws Exception {
		try {
			getDao().persistFormulacion(formulacion);
		} catch (RuntimeException e) {
			throw new Exception("persistFormulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormulacion(Formulacion formulacion) throws Exception {
		try {
			getDao().removeFormulacion(formulacion);
		} catch (RuntimeException e) {
			throw new Exception("removeFormulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IFormulacionDao dao) {
		this.dao = dao;
	}
	public IFormulacionDao getDao() {
		return this.dao;
	}
}