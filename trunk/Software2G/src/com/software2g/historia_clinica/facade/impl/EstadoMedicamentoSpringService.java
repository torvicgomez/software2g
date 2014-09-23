package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Estadomedicamento;
import com.software2g.historia_clinica.facade.IEstadoMedicamentoService;
import com.software2g.historia_clinica.dao.IEstadoMedicamentoDao;

/**
 * The service class for the Estadomedicamento entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class EstadoMedicamentoSpringService implements IEstadoMedicamentoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IEstadoMedicamentoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public EstadoMedicamentoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IEstadoMedicamentoService</code> instance.
	 */
	public static IEstadoMedicamentoService getInstance(ApplicationContext context) {
		return (IEstadoMedicamentoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Estadomedicamento findEstadomedicamentoById(long id) throws Exception {
		try {
			return getDao().findEstadomedicamentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEstadomedicamentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Estadomedicamento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Estadomedicamento> findAllEstadomedicamentos() throws Exception {
		try {
			return getDao().findAllEstadomedicamentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllEstadomedicamentos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception {
		try {
			getDao().persistEstadomedicamento(estadomedicamento);
		} catch (RuntimeException e) {
			throw new Exception("persistEstadomedicamento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception {
		try {
			getDao().removeEstadomedicamento(estadomedicamento);
		} catch (RuntimeException e) {
			throw new Exception("removeEstadomedicamento failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IEstadoMedicamentoDao dao) {
		this.dao = dao;
	}
	public IEstadoMedicamentoDao getDao() {
		return this.dao;
	}
}