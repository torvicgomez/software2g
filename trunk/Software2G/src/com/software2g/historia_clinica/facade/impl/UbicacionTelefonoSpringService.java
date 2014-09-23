package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Ubicaciontelefono;
import com.software2g.historia_clinica.facade.IUbicacionTelefonoService;
import com.software2g.historia_clinica.dao.IUbicacionTelefonoDao;

/**
 * The service class for the Ubicaciontelefono entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UbicacionTelefonoSpringService implements IUbicacionTelefonoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IUbicacionTelefonoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public UbicacionTelefonoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IUbicacionTelefonoService</code> instance.
	 */
	public static IUbicacionTelefonoService getInstance(ApplicationContext context) {
		return (IUbicacionTelefonoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ubicaciontelefono findUbicaciontelefonoById(long id) throws Exception {
		try {
			return getDao().findUbicaciontelefonoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUbicaciontelefonoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ubicaciontelefono</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ubicaciontelefono> findAllUbicaciontelefonos() throws Exception {
		try {
			return getDao().findAllUbicaciontelefonos();
		} catch (RuntimeException e) {
			throw new Exception("findAllUbicaciontelefonos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception {
		try {
			getDao().persistUbicaciontelefono(ubicaciontelefono);
		} catch (RuntimeException e) {
			throw new Exception("persistUbicaciontelefono failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception {
		try {
			getDao().removeUbicaciontelefono(ubicaciontelefono);
		} catch (RuntimeException e) {
			throw new Exception("removeUbicaciontelefono failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IUbicacionTelefonoDao dao) {
		this.dao = dao;
	}
	public IUbicacionTelefonoDao getDao() {
		return this.dao;
	}
}