package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tipoespecialidad;
import com.software2g.historia_clinica.facade.ITipoEspecialidadService;
import com.software2g.historia_clinica.dao.ITipoEspecialidadDao;

/**
 * The service class for the Tipoespecialidad entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoEspecialidadSpringService implements ITipoEspecialidadService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoEspecialidadDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoEspecialidadSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoEspecialidadService</code> instance.
	 */
	public static ITipoEspecialidadService getInstance(ApplicationContext context) {
		return (ITipoEspecialidadService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoespecialidad findTipoespecialidadById(long id) throws Exception {
		try {
			return getDao().findTipoespecialidadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoespecialidadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoespecialidad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoespecialidad> findAllTipoespecialidads() throws Exception {
		try {
			return getDao().findAllTipoespecialidads();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoespecialidads failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception {
		try {
			getDao().persistTipoespecialidad(tipoespecialidad);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoespecialidad failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception {
		try {
			getDao().removeTipoespecialidad(tipoespecialidad);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoespecialidad failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoEspecialidadDao dao) {
		this.dao = dao;
	}
	public ITipoEspecialidadDao getDao() {
		return this.dao;
	}
}