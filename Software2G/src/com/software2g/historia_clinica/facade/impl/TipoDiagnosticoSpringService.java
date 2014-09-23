package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tipodiagnostico;
import com.software2g.historia_clinica.facade.ITipoDiagnosticoService;
import com.software2g.historia_clinica.dao.ITipoDiagnosticoDao;

/**
 * The service class for the Tipodiagnostico entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoDiagnosticoSpringService implements ITipoDiagnosticoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoDiagnosticoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoDiagnosticoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoDiagnosticoService</code> instance.
	 */
	public static ITipoDiagnosticoService getInstance(ApplicationContext context) {
		return (ITipoDiagnosticoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodiagnostico findTipodiagnosticoById(long id) throws Exception {
		try {
			return getDao().findTipodiagnosticoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodiagnosticoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodiagnostico</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodiagnostico> findAllTipodiagnosticos() throws Exception {
		try {
			return getDao().findAllTipodiagnosticos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodiagnosticos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception {
		try {
			getDao().persistTipodiagnostico(tipodiagnostico);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodiagnostico failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception {
		try {
			getDao().removeTipodiagnostico(tipodiagnostico);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodiagnostico failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoDiagnosticoDao dao) {
		this.dao = dao;
	}
	public ITipoDiagnosticoDao getDao() {
		return this.dao;
	}
}