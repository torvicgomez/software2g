package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Sintoma;
import com.software2g.historia_clinica.facade.ISintomaService;
import com.software2g.historia_clinica.dao.ISintomaDao;

/**
 * The service class for the Sintoma entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class SintomaSpringService implements ISintomaService {
	/**
	 * The dao instance injected by Spring.
	 */
	private ISintomaDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public SintomaSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>ISintomaService</code> instance.
	 */
	public static ISintomaService getInstance(ApplicationContext context) {
		return (ISintomaService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Sintoma findSintomaById(long id) throws Exception {
		try {
			return getDao().findSintomaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSintomaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Sintoma</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Sintoma> findAllSintomas() throws Exception {
		try {
			return getDao().findAllSintomas();
		} catch (RuntimeException e) {
			throw new Exception("findAllSintomas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintoma(Sintoma sintoma) throws Exception {
		try {
			getDao().persistSintoma(sintoma);
		} catch (RuntimeException e) {
			throw new Exception("persistSintoma failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintoma(Sintoma sintoma) throws Exception {
		try {
			getDao().removeSintoma(sintoma);
		} catch (RuntimeException e) {
			throw new Exception("removeSintoma failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(ISintomaDao dao) {
		this.dao = dao;
	}
	public ISintomaDao getDao() {
		return this.dao;
	}
}