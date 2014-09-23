package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tipodato;
import com.software2g.historia_clinica.facade.ITipoDatoService;
import com.software2g.historia_clinica.dao.ITipoDatoDao;

/**
 * The service class for the Tipodato entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoDatoSpringService implements ITipoDatoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoDatoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoDatoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoDatoService</code> instance.
	 */
	public static ITipoDatoService getInstance(ApplicationContext context) {
		return (ITipoDatoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodato findTipodatoById(long id) throws Exception {
		try {
			return getDao().findTipodatoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodatoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodato</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodato> findAllTipodatos() throws Exception {
		try {
			return getDao().findAllTipodatos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodatos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodato(Tipodato tipodato) throws Exception {
		try {
			getDao().persistTipodato(tipodato);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodato failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodato(Tipodato tipodato) throws Exception {
		try {
			getDao().removeTipodato(tipodato);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodato failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoDatoDao dao) {
		this.dao = dao;
	}
	public ITipoDatoDao getDao() {
		return this.dao;
	}
}