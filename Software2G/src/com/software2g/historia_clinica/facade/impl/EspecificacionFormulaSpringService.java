package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Especificacionformula;
import com.software2g.historia_clinica.facade.IEspecificacionFormulaService;
import com.software2g.historia_clinica.dao.IEspecificacionFormulaDao;

/**
 * The service class for the Especificacionformula entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class EspecificacionFormulaSpringService implements IEspecificacionFormulaService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IEspecificacionFormulaDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public EspecificacionFormulaSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IEspecificacionFormulaService</code> instance.
	 */
	public static IEspecificacionFormulaService getInstance(ApplicationContext context) {
		return (IEspecificacionFormulaService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificacionformula findEspecificacionformulaById(long id) throws Exception {
		try {
			return getDao().findEspecificacionformulaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificacionformulaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Especificacionformula</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Especificacionformula> findAllEspecificacionformulas() throws Exception {
		try {
			return getDao().findAllEspecificacionformulas();
		} catch (RuntimeException e) {
			throw new Exception("findAllEspecificacionformulas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionformula(Especificacionformula especificacionformula) throws Exception {
		try {
			getDao().persistEspecificacionformula(especificacionformula);
		} catch (RuntimeException e) {
			throw new Exception("persistEspecificacionformula failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionformula(Especificacionformula especificacionformula) throws Exception {
		try {
			getDao().removeEspecificacionformula(especificacionformula);
		} catch (RuntimeException e) {
			throw new Exception("removeEspecificacionformula failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IEspecificacionFormulaDao dao) {
		this.dao = dao;
	}
	public IEspecificacionFormulaDao getDao() {
		return this.dao;
	}
}