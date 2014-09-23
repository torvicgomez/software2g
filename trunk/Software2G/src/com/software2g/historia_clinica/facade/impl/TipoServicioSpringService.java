package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tiposervicio;
import com.software2g.historia_clinica.facade.ITipoServicioService;
import com.software2g.historia_clinica.dao.ITipoServicioDao;

/**
 * The service class for the Tiposervicio entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoServicioSpringService implements ITipoServicioService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoServicioDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoServicioSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoServicioService</code> instance.
	 */
	public static ITipoServicioService getInstance(ApplicationContext context) {
		return (ITipoServicioService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tiposervicio findTiposervicioById(long id) throws Exception {
		try {
			return getDao().findTiposervicioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTiposervicioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tiposervicio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tiposervicio> findAllTiposervicios() throws Exception {
		try {
			return getDao().findAllTiposervicios();
		} catch (RuntimeException e) {
			throw new Exception("findAllTiposervicios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposervicio(Tiposervicio tiposervicio) throws Exception {
		try {
			getDao().persistTiposervicio(tiposervicio);
		} catch (RuntimeException e) {
			throw new Exception("persistTiposervicio failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposervicio(Tiposervicio tiposervicio) throws Exception {
		try {
			getDao().removeTiposervicio(tiposervicio);
		} catch (RuntimeException e) {
			throw new Exception("removeTiposervicio failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoServicioDao dao) {
		this.dao = dao;
	}
	public ITipoServicioDao getDao() {
		return this.dao;
	}
}