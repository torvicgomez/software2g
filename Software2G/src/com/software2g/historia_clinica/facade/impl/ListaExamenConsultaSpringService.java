package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Listaexamenconsulta;
import com.software2g.historia_clinica.facade.IListaExamenConsultaService;
import com.software2g.historia_clinica.dao.IListaExamenConsultaDao;

/**
 * The service class for the Listaexamenconsulta entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ListaExamenConsultaSpringService implements IListaExamenConsultaService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IListaExamenConsultaDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public ListaExamenConsultaSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IListaExamenConsultaService</code> instance.
	 */
	public static IListaExamenConsultaService getInstance(ApplicationContext context) {
		return (IListaExamenConsultaService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Listaexamenconsulta findListaexamenconsultaById(long id) throws Exception {
		try {
			return getDao().findListaexamenconsultaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findListaexamenconsultaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Listaexamenconsulta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Listaexamenconsulta> findAllListaexamenconsultas() throws Exception {
		try {
			return getDao().findAllListaexamenconsultas();
		} catch (RuntimeException e) {
			throw new Exception("findAllListaexamenconsultas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception {
		try {
			getDao().persistListaexamenconsulta(listaexamenconsulta);
		} catch (RuntimeException e) {
			throw new Exception("persistListaexamenconsulta failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception {
		try {
			getDao().removeListaexamenconsulta(listaexamenconsulta);
		} catch (RuntimeException e) {
			throw new Exception("removeListaexamenconsulta failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IListaExamenConsultaDao dao) {
		this.dao = dao;
	}
	public IListaExamenConsultaDao getDao() {
		return this.dao;
	}
}