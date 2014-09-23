package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Unidade;
import com.software2g.historia_clinica.facade.IUnidadesService;
import com.software2g.historia_clinica.dao.IUnidadesDao;

/**
 * The service class for the Unidade entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UnidadesSpringService implements IUnidadesService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IUnidadesDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public UnidadesSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IUnidadesService</code> instance.
	 */
	public static IUnidadesService getInstance(ApplicationContext context) {
		return (IUnidadesService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Unidade findUnidadeById(long id) throws Exception {
		try {
			return getDao().findUnidadeById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUnidadeById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Unidade</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Unidade> findAllUnidades() throws Exception {
		try {
			return getDao().findAllUnidades();
		} catch (RuntimeException e) {
			throw new Exception("findAllUnidades failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUnidade(Unidade unidade) throws Exception {
		try {
			getDao().persistUnidade(unidade);
		} catch (RuntimeException e) {
			throw new Exception("persistUnidade failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUnidade(Unidade unidade) throws Exception {
		try {
			getDao().removeUnidade(unidade);
		} catch (RuntimeException e) {
			throw new Exception("removeUnidade failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IUnidadesDao dao) {
		this.dao = dao;
	}
	public IUnidadesDao getDao() {
		return this.dao;
	}
}