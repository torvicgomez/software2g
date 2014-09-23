package com.software2g.historia_clinica.facade.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.software2g.vo.Paciente;
import com.software2g.historia_clinica.facade.IPacienteService;
import com.software2g.historia_clinica.dao.IPacienteDao;

/**
 * The service class for the Paciente entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class PacienteSpringService implements IPacienteService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IPacienteDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "VirtualLinkService";
	
	public PacienteSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IPacienteService</code> instance.
	 */
	public static IPacienteService getInstance(ApplicationContext context) {
		return (IPacienteService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Paciente findPacienteById(long id) throws Exception {
		try {
			return getDao().findPacienteById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPacienteById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Paciente</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Paciente> findAllPacientes() throws Exception {
		try {
			return getDao().findAllPacientes();
		} catch (RuntimeException e) {
			throw new Exception("findAllPacientes failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPaciente(Paciente paciente) throws Exception {
		try {
			getDao().persistPaciente(paciente);
		} catch (RuntimeException e) {
			throw new Exception("persistPaciente failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePaciente(Paciente paciente) throws Exception {
		try {
			getDao().removePaciente(paciente);
		} catch (RuntimeException e) {
			throw new Exception("removePaciente failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IPacienteDao dao) {
		this.dao = dao;
	}
	public IPacienteDao getDao() {
		return this.dao;
	}
}