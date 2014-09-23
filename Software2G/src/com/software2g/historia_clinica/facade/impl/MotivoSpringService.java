package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Motivo;
import com.software2g.historia_clinica.facade.IMotivoService;
import com.software2g.historia_clinica.dao.IMotivoDao;

/**
 * The service class for the Motivo entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class MotivoSpringService implements IMotivoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IMotivoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public MotivoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IMotivoService</code> instance.
	 */
	public static IMotivoService getInstance(ApplicationContext context) {
		return (IMotivoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Motivo findMotivoById(long id) throws Exception {
		try {
			return getDao().findMotivoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findMotivoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Motivo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Motivo> findAllMotivos() throws Exception {
		try {
			return getDao().findAllMotivos();
		} catch (RuntimeException e) {
			throw new Exception("findAllMotivos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMotivo(Motivo motivo) throws Exception {
		try {
			getDao().persistMotivo(motivo);
		} catch (RuntimeException e) {
			throw new Exception("persistMotivo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMotivo(Motivo motivo) throws Exception {
		try {
			getDao().removeMotivo(motivo);
		} catch (RuntimeException e) {
			throw new Exception("removeMotivo failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IMotivoDao dao) {
		this.dao = dao;
	}
	public IMotivoDao getDao() {
		return this.dao;
	}
}