package com.software2g.agenda.facade.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.agenda.dao.IAgendaDao;
import com.software2g.agenda.dao.IEventoDao;
import com.software2g.agenda.dao.IJornadaLaboralDao;
import com.software2g.agenda.dao.IParametroCalendarioDao;
import com.software2g.agenda.dao.IParticipanteDao;
import com.software2g.agenda.dao.IProcedimientoDao;
import com.software2g.agenda.dao.IProfesionalDao;
import com.software2g.agenda.dao.ITiempoNoDisponibleDao;
import com.software2g.agenda.dao.ITipoProcedimientoDao;
import com.software2g.agenda.facade.IGestionFacadeAgenda;
import com.software2g.portal.dao.IDepartamentoDao;
import com.software2g.portal.dao.IMunicipioDao;
import com.software2g.portal.dao.IPaisDao;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.portal.dao.ITipoDocumentoDao;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Agenda;
import com.software2g.vo.Departamento;
import com.software2g.vo.Evento;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Municipio;
import com.software2g.vo.Pais;
import com.software2g.vo.Parametroscalendario;
import com.software2g.vo.Participante;
import com.software2g.vo.Persona;
import com.software2g.vo.Procedimiento;
import com.software2g.vo.Profesional;
import com.software2g.vo.Tiemponodisponible;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Tipoprocedimiento;

@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadeAgenda implements IGestionFacadeAgenda{
	@Autowired
	IAgendaDao agendaDao;
	@Autowired
	IEventoDao eventoDao;
	@Autowired
	IJornadaLaboralDao jornadaLaboralDao;
	@Autowired
	IParametroCalendarioDao parametroCalendarioDao;
	@Autowired
	IProfesionalDao profesionalDao;
	@Autowired
	ITiempoNoDisponibleDao tiempoNoDisponibleDao;
	@Autowired
	IPersonaDao personaDao;
	@Autowired
	IParticipanteDao participanteDao;
	@Autowired
	IProcedimientoDao procedimientoDao;
	@Autowired
	ITipoProcedimientoDao tipoProcedimientoDao;
	@Autowired
	ITipoDocumentoDao tipoDocumentoDao;
	@Autowired
	IPaisDao paisDao;
	@Autowired
	IDepartamentoDao departamentoDao;
	@Autowired
	IMunicipioDao municipioDao;
	
	public IAgendaDao getAgendaDao() {return agendaDao;}
	public void setAgendaDao(IAgendaDao agendaDao) {this.agendaDao = agendaDao;}
	public IEventoDao getEventoDao() {return eventoDao;}
	public void setEventoDao(IEventoDao eventoDao) {this.eventoDao = eventoDao;}
	public IJornadaLaboralDao getJornadaLaboralDao() {return jornadaLaboralDao;}
	public void setJornadaLaboralDao(IJornadaLaboralDao jornadaLaboralDao) {this.jornadaLaboralDao = jornadaLaboralDao;}
	public IParametroCalendarioDao getParametroCalendarioDao() {return parametroCalendarioDao;}
	public void setParametroCalendarioDao(IParametroCalendarioDao parametroCalendarioDao) {this.parametroCalendarioDao = parametroCalendarioDao;}
	public IProfesionalDao getProfesionalDao() {return profesionalDao;}
	public void setProfesionalDao(IProfesionalDao profesionalDao) {this.profesionalDao = profesionalDao;}
	public ITiempoNoDisponibleDao getTiempoNoDisponibleDao() {return tiempoNoDisponibleDao;}
	public void setTiempoNoDisponibleDao(ITiempoNoDisponibleDao tiempoNoDisponibleDao) {this.tiempoNoDisponibleDao = tiempoNoDisponibleDao;}
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	public IParticipanteDao getParticipanteDao() {return participanteDao;}
	public void setParticipanteDao(IParticipanteDao participanteDao) {this.participanteDao = participanteDao;}
	public IProcedimientoDao getProcedimientoDao() {return procedimientoDao;}
	public void setProcedimientoDao(IProcedimientoDao procedimientoDao) {this.procedimientoDao = procedimientoDao;}
	public ITipoProcedimientoDao getTipoProcedimientoDao() {return tipoProcedimientoDao;}
	public void setTipoProcedimientoDao(ITipoProcedimientoDao tipoProcedimientoDao) {this.tipoProcedimientoDao = tipoProcedimientoDao;}
	public ITipoDocumentoDao getTipoDocumentoDao() {return tipoDocumentoDao;}
	public void setTipoDocumentoDao(ITipoDocumentoDao tipoDocumentoDao) {this.tipoDocumentoDao = tipoDocumentoDao;}
	public IPaisDao getPaisDao() {return paisDao;}
	public void setPaisDao(IPaisDao paisDao) {this.paisDao = paisDao;}
	public IDepartamentoDao getDepartamentoDao() {return departamentoDao;}
	public void setDepartamentoDao(IDepartamentoDao departamentoDao) {this.departamentoDao = departamentoDao;}
	public IMunicipioDao getMunicipioDao() {return municipioDao;}
	public void setMunicipioDao(IMunicipioDao municipioDao) {this.municipioDao = municipioDao;}
	
	//-----------------------------------------------------------------------
	// Agenda
	//-----------------------------------------------------------------------	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Agenda findAgendaById(long id) throws Exception {
		try {
			return getAgendaDao().findAgendaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findAgendaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Agenda</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Agenda> findAllAgendas() throws Exception {
		try {
			return getAgendaDao().findAllAgendas();
		} catch (RuntimeException e) {
			throw new Exception("findAllAgendas failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Agenda findIdAgenda(String background) throws Exception {
		try {
			System.out.println("background:["+background+"]");
			return getAgendaDao().findIdAgenda(background);
		} catch (RuntimeException e) {
			//throw new Exception("findIdAgenda failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAgenda(Agenda agenda) throws Exception {
		try {
			getAgendaDao().persistAgenda(agenda);
		} catch (RuntimeException e) {
			//throw new Exception("persistAgenda failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public long persistAgendaId(Agenda agenda) throws Exception {
		try {
			return getAgendaDao().persistAgendaId(agenda);
		} catch (RuntimeException e) {
			//throw new Exception("persistAgenda failed: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAgenda(Agenda agenda) throws Exception {
		try {
			getAgendaDao().removeAgenda(agenda);
		} catch (RuntimeException e) {
			throw new Exception("removeAgenda failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Fin Agenda
	//-----------------------------------------------------------------------
	
	//-----------------------------------------------------------------------
	// Evento
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Evento findEventoById(long id) throws Exception {
		try {
			return getEventoDao().findEventoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEventoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Evento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Evento> findAllEventos() throws Exception {
		try {
			return getEventoDao().findAllEventos();
		} catch (RuntimeException e) {
			throw new Exception("findAllEventos failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Evento> findAllEventosxAgenda(long idAgenda) throws Exception {
		try {
			return getEventoDao().findAllEventosxAgenda(idAgenda);
		} catch (RuntimeException e) {
			//throw new Exception("findAllEventosxAgenda failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Agenda> findAllEventosAgendas() throws Exception {
		try {
			return getEventoDao().findAllEventosAgendas();
		} catch (RuntimeException e) {
			//throw new Exception("findAllEventosxAgenda failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEvento(Evento evento) throws Exception {
		try {
			getEventoDao().persistEvento(evento);
		} catch (RuntimeException e) {
			throw new Exception("persistEvento failed: " + e.getMessage());
		}
	}
	
	public long persistEventoId(Evento evento) throws Exception {
		try {
			return getEventoDao().persistEventoId(evento);
		} catch (RuntimeException e) {
			//throw new Exception("persistEventoId failed: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEvento(Evento evento) throws Exception {
		try {
			getEventoDao().removeEvento(evento);
		} catch (RuntimeException e) {
			throw new Exception("removeEvento failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Fin Evento
	//-----------------------------------------------------------------------
	//-----------------------------------------------------------------------
	// Jornada Laboral
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Jorandalaboral findJorandalaboralById(long id) throws Exception {
		try {
			return getJornadaLaboralDao().findJorandalaboralById(id);
		} catch (RuntimeException e) {
			throw new Exception("findJorandalaboralById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Jorandalaboral</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Jorandalaboral> findAllJorandalaborals() throws Exception {
		try {
			return getJornadaLaboralDao().findAllJorandalaborals();
		} catch (RuntimeException e) {
			throw new Exception("findAllJorandalaborals failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistJorandalaboral(Jorandalaboral jorandalaboral) throws Exception {
		try {
			getJornadaLaboralDao().persistJorandalaboral(jorandalaboral);
		} catch (RuntimeException e) {
			throw new Exception("persistJorandalaboral failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeJorandalaboral(Jorandalaboral jorandalaboral) throws Exception {
		try {
			getJornadaLaboralDao().removeJorandalaboral(jorandalaboral);
		} catch (RuntimeException e) {
			throw new Exception("removeJorandalaboral failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Fin Jornada Laborar
	//-----------------------------------------------------------------------
	//-----------------------------------------------------------------------
	// Parametros Calendario
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Parametroscalendario findParametroscalendarioById(long id) throws Exception {
		try {
			return getParametroCalendarioDao().findParametroscalendarioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findParametroscalendarioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Parametroscalendario</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Parametroscalendario> findAllParametroscalendarios() throws Exception {
		try {
			return getParametroCalendarioDao().findAllParametroscalendarios();
		} catch (RuntimeException e) {
			throw new Exception("findAllParametroscalendarios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParametroscalendario(Parametroscalendario parametroscalendario) throws Exception {
		try {
			getParametroCalendarioDao().persistParametroscalendario(parametroscalendario);
		} catch (RuntimeException e) {
			throw new Exception("persistParametroscalendario failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParametroscalendario(Parametroscalendario parametroscalendario) throws Exception {
		try {
			getParametroCalendarioDao().removeParametroscalendario(parametroscalendario);
		} catch (RuntimeException e) {
			throw new Exception("removeParametroscalendario failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Fin Parametros Calendario
	//-----------------------------------------------------------------------
	//-----------------------------------------------------------------------
	// Profesional
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Profesional findProfesionalById(long id) throws Exception {
		try {
			return getProfesionalDao().findProfesionalById(id);
		} catch (RuntimeException e) {
			throw new Exception("findProfesionalById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Profesional findProfesionalIdPersona(long idPersona) throws Exception {
		try {
			return getProfesionalDao().findProfesionalIdPersona(idPersona);
		} catch (RuntimeException e) {
			throw new Exception("findProfesionalIdPersona failed with the idPersona " + idPersona + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public boolean validoBackgroundProf(String background) throws Exception {
		try {
			return getProfesionalDao().validoBackgroundProf(background);
		} catch (RuntimeException e) {
			//throw new Exception("validoBackgroundProf failed with the background " + background + ": " + e.getMessage());
			e.printStackTrace();
			return false;	
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Profesional findProfesionalBackground(String background) throws Exception {
		try {
			return getProfesionalDao().findProfesionalBackground(background);
		} catch (RuntimeException e) {
			throw new Exception("findProfesionalBackground failed with the background " + background + ": " + e.getMessage());
		}
	}
	
	/**
	 * Return all persistent instances of the <code>Profesional</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Profesional> findAllProfesionals() throws Exception {
		try {
			return getProfesionalDao().findAllProfesionals();
		} catch (RuntimeException e) {
			throw new Exception("findAllProfesionals failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Profesional> findAllProfesionalAgenda() throws Exception {
		try {
			return getProfesionalDao().findAllProfesionalAgenda();
		} catch (RuntimeException e) {
			//throw new Exception("findAllProfesionalAgenda failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Profesional> findAllProfesionalXIdPersona(long idPersona) throws Exception {
		try {
			return getProfesionalDao().findAllProfesionalXIdPersona(idPersona);
		} catch (RuntimeException e) {
			throw new Exception("findAllProfesionalXIdPersona failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProfesional(Profesional profesional) throws Exception {
		try {
			getProfesionalDao().persistProfesional(profesional);
		} catch (RuntimeException e) {
			throw new Exception("persistProfesional failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProfesional(Profesional profesional) throws Exception {
		try {
			getProfesionalDao().removeProfesional(profesional);
		} catch (RuntimeException e) {
			throw new Exception("removeProfesional failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Fin Profesional
	//-----------------------------------------------------------------------
	//-----------------------------------------------------------------------
	// Tiempo No Disponible
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tiemponodisponible findTiemponodisponibleById(long id) throws Exception {
		try {
			return getTiempoNoDisponibleDao().findTiemponodisponibleById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTiemponodisponibleById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tiemponodisponible</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tiemponodisponible> findAllTiemponodisponibles() throws Exception {
		try {
			return getTiempoNoDisponibleDao().findAllTiemponodisponibles();
		} catch (RuntimeException e) {
			throw new Exception("findAllTiemponodisponibles failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiemponodisponible(Tiemponodisponible tiemponodisponible) throws Exception {
		try {
			getTiempoNoDisponibleDao().persistTiemponodisponible(tiemponodisponible);
		} catch (RuntimeException e) {
			throw new Exception("persistTiemponodisponible failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiemponodisponible(Tiemponodisponible tiemponodisponible) throws Exception {
		try {
			getTiempoNoDisponibleDao().removeTiemponodisponible(tiemponodisponible);
		} catch (RuntimeException e) {
			throw new Exception("removeTiemponodisponible failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Fin Tiempo No Disponible
	//-----------------------------------------------------------------------
	//-----------------------------------------------------------------------
	// Persona
	//-----------------------------------------------------------------------
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Persona> findAllPersonasProfesionales(String datoFind) throws Exception {
		try {
			return getPersonaDao().findAllPersonasProfesionales(datoFind);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
			//throw new Exception("findAllPersonasProfesionales failed: " + e.getMessage());
		}
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Persona findPersonaById(java.lang.Long id) throws Exception {
		try {
			return getPersonaDao().findPersonaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Persona</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Persona> findAllPersonas() throws Exception {
		try {
			return getPersonaDao().findAllPersonas();
		} catch (RuntimeException e) {
			throw new Exception("findAllPersonas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersona(Persona persona) throws Exception {
		try {
			getPersonaDao().persistPersona(persona);
		} catch (RuntimeException e) {
			throw new Exception("persistPersona failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersona(Persona persona) throws Exception {
		try {
			getPersonaDao().removePersona(persona);
		} catch (RuntimeException e) {
			throw new Exception("removePersona failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// FIN Persona
	//-----------------------------------------------------------------------

	//-----------------------------------------------------------------------
	// Participante
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Participante findParticipanteById(long id) throws Exception {
		try {
			return getParticipanteDao().findParticipanteById(id);
		} catch (RuntimeException e) {
			throw new Exception("findParticipanteById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Participante</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Participante> findAllParticipantes() throws Exception {
		try {
			return getParticipanteDao().findAllParticipantes();
		} catch (RuntimeException e) {
			throw new Exception("findAllParticipantes failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Participante> findAllParticipantes(long idEvento) throws Exception {
		try {
			System.out.println("idEvento:["+idEvento+"]");
			return getParticipanteDao().findAllParticipantes(idEvento);
		} catch (RuntimeException e) {
			//throw new Exception("findAllParticipantes failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParticipante(Participante participante) throws Exception {
		try {
			getParticipanteDao().persistParticipante(participante);
		} catch (RuntimeException e) {
			throw new Exception("persistParticipante failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParticipante(Participante participante) throws Exception {
		try {
			getParticipanteDao().removeParticipante(participante);
		} catch (RuntimeException e) {
			throw new Exception("removeParticipante failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// FIN Participante
	//-----------------------------------------------------------------------

	//-----------------------------------------------------------------------
	// Procedimiento
	//-----------------------------------------------------------------------
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Procedimiento findProcedimientoById(long id) throws Exception {
		try {
			return getProcedimientoDao().findProcedimientoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findProcedimientoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Procedimiento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Procedimiento> findAllProcedimientos() throws Exception {
		try {
			return getProcedimientoDao().findAllProcedimientos();
		} catch (RuntimeException e) {
			throw new Exception("findAllProcedimientos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProcedimiento(Procedimiento procedimiento) throws Exception {
		try {
			getProcedimientoDao().persistProcedimiento(procedimiento);
		} catch (RuntimeException e) {
			throw new Exception("persistProcedimiento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProcedimiento(Procedimiento procedimiento) throws Exception {
		try {
			getProcedimientoDao().removeProcedimiento(procedimiento);
		} catch (RuntimeException e) {
			throw new Exception("removeProcedimiento failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// FIN Procedimiento
	//-----------------------------------------------------------------------
	
	//-----------------------------------------------------------------------
	// FIN Tipo Procedimiento
	//-----------------------------------------------------------------------
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoprocedimiento findTipoprocedimientoById(long id) throws Exception {
		try {
			return getTipoProcedimientoDao().findTipoprocedimientoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoprocedimientoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoprocedimiento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoprocedimiento> findAllTipoprocedimientos() throws Exception {
		try {
			return getTipoProcedimientoDao().findAllTipoprocedimientos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoprocedimientos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoprocedimiento(Tipoprocedimiento tipoprocedimiento) throws Exception {
		try {
			getTipoProcedimientoDao().persistTipoprocedimiento(tipoprocedimiento);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoprocedimiento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoprocedimiento(Tipoprocedimiento tipoprocedimiento) throws Exception {
		try {
			getTipoProcedimientoDao().removeTipoprocedimiento(tipoprocedimiento);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoprocedimiento failed: " + e.getMessage());
		}
	}
	//-----------------------------------------------------------------------
	// Tipo Procedimiento
	//-----------------------------------------------------------------------
	
	//-------------------------------------------------------------------------------------
	//Implementacion de Metodos de la Entidad TipoDocumento
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception {
		try {
			return getTipoDocumentoDao().findTipodocumentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodocumentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodocumento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodocumento> findAllTipodocumentos() throws Exception {
		try {
			System.out.println("Entra esta parte de implementacion del mentodo: [List<Tipodocumento> findAllTipodocumentos()]!!!!!!!!!!!");
			List<Tipodocumento> lista = getTipoDocumentoDao().findAllTipodocumentos();
			return lista;
		} catch (Exception ee){
			System.out.println("metod de la GestionFacadePortalSpringService !!!!!!!!!!!!!");
			ee.printStackTrace();
		}/* catch (RuntimeException e) {
			throw new Exception("findAllTipodocumentos failed: " + e.getMessage());
		}*/
		return null;
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception {
		try {
			getTipoDocumentoDao().persistTipodocumento(tipodocumento);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodocumento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception {
		try {
			getTipoDocumentoDao().removeTipodocumento(tipodocumento);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodocumento failed: " + e.getMessage());
		}
	}
	//FIN ------ Implementacion de Metodos de la Entidad TipoDocumento
	//-------------------------------------------------------------------------------------
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Pais findPaisById(long id) throws Exception {
		try {
			return getPaisDao().findPaisById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPaisById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Aplicacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pais> findAllPaiss() throws Exception {
		try {
			return getPaisDao().findAllPaiss();
		} catch (RuntimeException e) {
			throw new Exception("findAllPaiss failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Departamento findDepartamentoById(long id) throws Exception {
		try {
			return getDepartamentoDao().findDepartamentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDepartamentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Departamento> findAllDepartamentos() throws Exception {
		try {
			return getDepartamentoDao().findAllDepartamentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllDepartamentos failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Municipio findMunicipioById(long id) throws Exception {
		try {
			return getMunicipioDao().findMunicipioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findMunicipioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Municipio> findAllMunicipios() throws Exception {
		try {
			return getMunicipioDao().findAllMunicipios();
		} catch (RuntimeException e) {
			throw new Exception("findAllMunicipios failed: " + e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Municipio> findAllMunicipios(long idDpto) throws Exception {
		try {
			return getMunicipioDao().findAllMunicipios(idDpto);
		} catch (RuntimeException e) {
			throw new Exception("findAllMunicipios failed: " + e.getMessage());
		}
	}
	
	public boolean crearFile(String path, String nameFile, String ext, String tipoFile, String infoFind) throws Exception{
		boolean result = true;
		try {
//			System.out.println("archivo: ["+path+nameFile+ext+"]");
			File file = new File(path+nameFile+ext);
			if(file.exists())
				file.delete();
//			System.out.println("Continua!!!!!!!");
			FileWriter createFile = new FileWriter(path+nameFile+ext);
//			System.out.println("tipo file: ["+tipoFile+"]");
			if(tipoFile.equals(ConstantesAplicativo.constanteTipoFileJSConstantesAgenda)){
				this.crearJSConstantesAgenda(createFile, infoFind);
			}else if(tipoFile.equals(ConstantesAplicativo.constanteTipoFileJSConstantesEventos)){
				this.crearJSAllEventos(createFile, ConstantesAplicativo.constanteCrearFileJSEventosAll);
			}else if(tipoFile.equals(ConstantesAplicativo.constanteTipoFileJSConstantesEventosxAgenda)){ 
				this.crearJSAllEventos(createFile, infoFind+ConstantesAplicativo.constanteSplit+ConstantesAplicativo.constanteCrearFileJSEventosxAgenda);
			}
			createFile.close();
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		} 
		return result;
	} 
	
	private boolean crearJSConstantesAgenda(FileWriter file, String infoFind) throws Exception{
		boolean result = true;
		try {
			Agenda agenda = findAgendaById(Long.parseLong(infoFind));
			String constantes = "";
			if(agenda!=null){
				constantes += "var paca_slotduration = \'"+agenda.getAgenDuracionevento()+"\';\n";
				constantes += "var paca_scrolltime = \'"+agenda.getAgenScrolltime()+"\';\n";
				constantes += "var paca_mitime = \'"+agenda.getAgenMintime()+"\';\n";
				constantes += "var paca_maxtime = \'"+agenda.getAgenMaxtime()+"\';\n";
				constantes += "var paca_sloteventover = false;\n";
				constantes += "var paca_alldayslot = "+(agenda.getAgenAlldayslot().equals("1")?"true":"false")+";\n";
				constantes += "var paca_alldaytext = \'"+agenda.getAgenAlldaytext()+"\';\n";
				constantes += "var paca_editable = false;\n";
				constantes += "var paca_selectable = true;\n";
				file.write(constantes);
			}
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//			System.out.println("constantes: ["+constantes+"]");
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		} catch (RuntimeException e) {
			e.printStackTrace();
			result = false;
		} 
		return result;
	}
	
	private boolean crearJSAllEventos(FileWriter file, String infoFind) throws Exception{
		boolean result = true;
		try {
			List<Evento> listEventos = new ArrayList<Evento>();
			String[] datos = infoFind.split(ConstantesAplicativo.constanteSplit);
			if(datos!=null&&datos.length>1){
				if(datos[1].equals(ConstantesAplicativo.constanteCrearFileJSEventosxAgenda))
					listEventos = this.findAllEventosxAgenda(Long.parseLong(datos[0].toString()));
			}else if(infoFind!=null&&infoFind.equals(ConstantesAplicativo.constanteCrearFileJSEventosAll))
				listEventos = this.findAllEventos();
//			System.out.println("listEventos: ["+listEventos.size()+"]");
			String constantes = "var eventos = [\n";
			if(listEventos!=null&&listEventos.size()>0){
				for(Evento elem:listEventos){
					constantes += "{\n";
					constantes += "  id: "+elem.getEvenId()+",\n";
					constantes += "  title: '"+elem.getEvenTitle()+"',\n";
					constantes += "  start: '"+elem.getEvenStart()+"',\n";
					constantes += "  end: '"+elem.getEvenEnd()+"',\n";
					constantes += "  url: '"+elem.getEvenUrl()+elem.getEvenId()+"',\n";
					constantes += "  backgroundColor: '"+elem.getAgenda().getProfesional().getProfBackgroundcoloragen()+"'\n";
					constantes += "},";
				}
				constantes = constantes.substring(0,constantes.length()-1)+"];";
			}else
				constantes += "];";
			file.write(constantes);
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//			System.out.println("constantes: ["+constantes+"]");
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		} catch (RuntimeException e) {
			e.printStackTrace();
			result = false;
		} 
		return result;
	}
	
	public Persona findPacienteAtencionServicio(long evenId) throws Exception{
		Persona persona = null; 
		try {
			List<Participante> listParticipantes = this.findAllParticipantes(evenId);
			if(listParticipantes!=null&&listParticipantes.size()==1){
				Participante participante = (Participante)listParticipantes.get(0);
				System.out.println("getPartDocumento:["+participante.getPartDocumento()+"]");
				System.out.println("getPartTipodocumento:["+participante.getPartTipodocumento()+"]");
				persona = getPersonaDao().findPersona(participante.getPartDocumento(), participante.getPartTipodocumento());
				System.out.println("persona:["+persona+"]");
				if(persona==null){
					persona = new Persona();
					Tipodocumento tipoDocumento = (Tipodocumento)getTipoDocumentoDao().findTipodocumentoAbrev(participante.getPartTipodocumento()); 
					ValidaString.imprimirObject(tipoDocumento);
					persona.setTipodocumento(tipoDocumento);
					persona.setDocumentoPers(participante.getPartDocumento());
					persona.setPnombrePers(participante.getPartPnombre());
					persona.setSnombrePers(participante.getPartSnombre());
					persona.setPapellidoPers(participante.getPartPapellido());
					persona.setSapellidoPers(participante.getPartSapellido());
					persona.setTelefonoPers(participante.getPartTelefono());
					persona.setEmailPers(participante.getPartEmail());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return persona;
	}
}

