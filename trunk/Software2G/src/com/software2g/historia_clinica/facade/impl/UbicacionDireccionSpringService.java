package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Ubicaciondireccion;
import com.software2g.historia_clinica.facade.IUbicacionDireccionService;
import com.software2g.historia_clinica.dao.IUbicacionDireccionDao;

/**
 * The service class for the Ubicaciondireccion entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UbicacionDireccionSpringService implements IUbicacionDireccionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IUbicacionDireccionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public UbicacionDireccionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IUbicacionDireccionService</code> instance.
	 */
	public static IUbicacionDireccionService getInstance(ApplicationContext context) {
		return (IUbicacionDireccionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ubicaciondireccion findUbicaciondireccionById(long id) throws Exception {
		try {
			return getDao().findUbicaciondireccionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUbicaciondireccionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ubicaciondireccion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ubicaciondireccion> findAllUbicaciondireccions() throws Exception {
		try {
			return getDao().findAllUbicaciondireccions();
		} catch (RuntimeException e) {
			throw new Exception("findAllUbicaciondireccions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception {
		try {
			getDao().persistUbicaciondireccion(ubicaciondireccion);
		} catch (RuntimeException e) {
			throw new Exception("persistUbicaciondireccion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception {
		try {
			getDao().removeUbicaciondireccion(ubicaciondireccion);
		} catch (RuntimeException e) {
			throw new Exception("removeUbicaciondireccion failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IUbicacionDireccionDao dao) {
		this.dao = dao;
	}
	public IUbicacionDireccionDao getDao() {
		return this.dao;
	}
}