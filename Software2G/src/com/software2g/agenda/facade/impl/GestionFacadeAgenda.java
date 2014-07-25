package com.software2g.agenda.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.agenda.dao.IAgendaDao;
import com.software2g.agenda.dao.IEventoDao;
import com.software2g.agenda.dao.IJornadaLaboralDao;
import com.software2g.agenda.dao.IParametroCalendarioDao;
import com.software2g.agenda.dao.IProfesionalDao;
import com.software2g.agenda.dao.ITiempoNoDisponibleDao;
import com.software2g.agenda.facade.IGestionFacadeAgenda;
import com.software2g.vo.Agenda;
import com.software2g.vo.Evento;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Parametroscalendario;
import com.software2g.vo.Profesional;
import com.software2g.vo.Tiemponodisponible;

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

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAgenda(Agenda agenda) throws Exception {
		try {
			getAgendaDao().persistAgenda(agenda);
		} catch (RuntimeException e) {
			throw new Exception("persistAgenda failed: " + e.getMessage());
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
}