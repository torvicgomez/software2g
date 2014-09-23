package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Especificacionpartecuerpo;
import com.software2g.historia_clinica.facade.IEspecificacionParteCuerpoService;
import com.software2g.historia_clinica.dao.IEspecificacionParteCuerpoDao;

/**
 * The service class for the Especificacionpartecuerpo entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class EspecificacionParteCuerpoSpringService implements IEspecificacionParteCuerpoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IEspecificacionParteCuerpoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public EspecificacionParteCuerpoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IEspecificacionParteCuerpoService</code> instance.
	 */
	public static IEspecificacionParteCuerpoService getInstance(ApplicationContext context) {
		return (IEspecificacionParteCuerpoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificacionpartecuerpo findEspecificacionpartecuerpoById(long id) throws Exception {
		try {
			return getDao().findEspecificacionpartecuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificacionpartecuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Especificacionpartecuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Especificacionpartecuerpo> findAllEspecificacionpartecuerpos() throws Exception {
		try {
			return getDao().findAllEspecificacionpartecuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllEspecificacionpartecuerpos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception {
		try {
			getDao().persistEspecificacionpartecuerpo(especificacionpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistEspecificacionpartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception {
		try {
			getDao().removeEspecificacionpartecuerpo(especificacionpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removeEspecificacionpartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IEspecificacionParteCuerpoDao dao) {
		this.dao = dao;
	}
	public IEspecificacionParteCuerpoDao getDao() {
		return this.dao;
	}
}