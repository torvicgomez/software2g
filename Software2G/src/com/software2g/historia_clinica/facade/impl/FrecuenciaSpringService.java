package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Frecuencia;
import com.software2g.historia_clinica.facade.IFrecuenciaService;
import com.software2g.historia_clinica.dao.IFrecuenciaDao;

/**
 * The service class for the Frecuencia entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class FrecuenciaSpringService implements IFrecuenciaService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IFrecuenciaDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public FrecuenciaSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IFrecuenciaService</code> instance.
	 */
	public static IFrecuenciaService getInstance(ApplicationContext context) {
		return (IFrecuenciaService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Frecuencia findFrecuenciaById(long id) throws Exception {
		try {
			return getDao().findFrecuenciaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFrecuenciaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Frecuencia</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Frecuencia> findAllFrecuencias() throws Exception {
		try {
			return getDao().findAllFrecuencias();
		} catch (RuntimeException e) {
			throw new Exception("findAllFrecuencias failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFrecuencia(Frecuencia frecuencia) throws Exception {
		try {
			getDao().persistFrecuencia(frecuencia);
		} catch (RuntimeException e) {
			throw new Exception("persistFrecuencia failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFrecuencia(Frecuencia frecuencia) throws Exception {
		try {
			getDao().removeFrecuencia(frecuencia);
		} catch (RuntimeException e) {
			throw new Exception("removeFrecuencia failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IFrecuenciaDao dao) {
		this.dao = dao;
	}
	public IFrecuenciaDao getDao() {
		return this.dao;
	}
}