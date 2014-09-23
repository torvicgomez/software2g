package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tipoubicacion;
import com.software2g.historia_clinica.facade.ITipoUbicacionService;
import com.software2g.historia_clinica.dao.ITipoUbicacionDao;

/**
 * The service class for the Tipoubicacion entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoUbicacionSpringService implements ITipoUbicacionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoUbicacionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoUbicacionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoUbicacionService</code> instance.
	 */
	public static ITipoUbicacionService getInstance(ApplicationContext context) {
		return (ITipoUbicacionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoubicacion findTipoubicacionById(long id) throws Exception {
		try {
			return getDao().findTipoubicacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoubicacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoubicacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoubicacion> findAllTipoubicacions() throws Exception {
		try {
			return getDao().findAllTipoubicacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoubicacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoubicacion(Tipoubicacion tipoubicacion) throws Exception {
		try {
			getDao().persistTipoubicacion(tipoubicacion);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoubicacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoubicacion(Tipoubicacion tipoubicacion) throws Exception {
		try {
			getDao().removeTipoubicacion(tipoubicacion);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoubicacion failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoUbicacionDao dao) {
		this.dao = dao;
	}
	public ITipoUbicacionDao getDao() {
		return this.dao;
	}
}