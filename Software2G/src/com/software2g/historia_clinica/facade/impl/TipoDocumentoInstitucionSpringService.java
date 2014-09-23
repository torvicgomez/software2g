package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Tipodocumentoinst;
import com.software2g.historia_clinica.facade.ITipoDocumentoInstitucionService;
import com.software2g.historia_clinica.dao.ITipoDocumentoInstitucionDao;

/**
 * The service class for the Tipodocumentoinst entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class TipoDocumentoInstitucionSpringService implements ITipoDocumentoInstitucionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ITipoDocumentoInstitucionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public TipoDocumentoInstitucionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ITipoDocumentoInstitucionService</code> instance.
	 */
	public static ITipoDocumentoInstitucionService getInstance(ApplicationContext context) {
		return (ITipoDocumentoInstitucionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodocumentoinst findTipodocumentoinstById(long id) throws Exception {
		try {
			return getDao().findTipodocumentoinstById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodocumentoinstById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodocumentoinst</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodocumentoinst> findAllTipodocumentoinsts() throws Exception {
		try {
			return getDao().findAllTipodocumentoinsts();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodocumentoinsts failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception {
		try {
			getDao().persistTipodocumentoinst(tipodocumentoinst);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodocumentoinst failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception {
		try {
			getDao().removeTipodocumentoinst(tipodocumentoinst);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodocumentoinst failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ITipoDocumentoInstitucionDao dao) {
		this.dao = dao;
	}
	public ITipoDocumentoInstitucionDao getDao() {
		return this.dao;
	}
}