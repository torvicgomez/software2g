package com.software2g.agenda.facade;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.vo.Agenda;
import com.software2g.vo.Evento;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Parametroscalendario;
import com.software2g.vo.Persona;
import com.software2g.vo.Profesional;
import com.software2g.vo.Tiemponodisponible;

public interface IGestionFacadeAgenda {

	//-----------------------------------------------------------------------
	// Agenda
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Agenda findAgendaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Agenda</code> entity.
	 */
	public List<Agenda> findAllAgendas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAgenda(Agenda agenda) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAgenda(Agenda agenda) throws Exception;
	//-----------------------------------------------------------------------
	// Fin Agenda
	//-----------------------------------------------------------------------
	//-----------------------------------------------------------------------
	// Fin Evento
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Evento findEventoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Evento</code> entity.
	 */
	public List<Evento> findAllEventos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEvento(Evento evento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEvento(Evento evento) throws Exception;
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
	public Jorandalaboral findJorandalaboralById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Jorandalaboral</code> entity.
	 */
	public List<Jorandalaboral> findAllJorandalaborals() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistJorandalaboral(Jorandalaboral jorandalaboral) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeJorandalaboral(Jorandalaboral jorandalaboral) throws Exception;
	//-----------------------------------------------------------------------
	// Fin Jornada Laboral
	//-----------------------------------------------------------------------	
	//-----------------------------------------------------------------------
	// Prametros Calendario
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Parametroscalendario findParametroscalendarioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Parametroscalendario</code> entity.
	 */
	public List<Parametroscalendario> findAllParametroscalendarios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParametroscalendario(Parametroscalendario parametroscalendario) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParametroscalendario(Parametroscalendario parametroscalendario) throws Exception;
	//-----------------------------------------------------------------------
	// Fin Prametros Calendario
	//-----------------------------------------------------------------------	
	//-----------------------------------------------------------------------
	// Profesional
	//-----------------------------------------------------------------------
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Profesional findProfesionalById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Profesional</code> entity.
	 */
	public List<Profesional> findAllProfesionals() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProfesional(Profesional profesional) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProfesional(Profesional profesional) throws Exception;
	public List<Profesional> findAllProfesionalXIdPersona(long idPersona) throws Exception;
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
	public Tiemponodisponible findTiemponodisponibleById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tiemponodisponible</code> entity.
	 */
	public List<Tiemponodisponible> findAllTiemponodisponibles() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiemponodisponible(Tiemponodisponible tiemponodisponible) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiemponodisponible(Tiemponodisponible tiemponodisponible) throws Exception;
	//-----------------------------------------------------------------------
	// Fin Tiempo No Disponible
	//-----------------------------------------------------------------------	
	//-----------------------------------------------------------------------
	// Persona
	//-----------------------------------------------------------------------
	public List<Persona> findAllPersonasProfesionales(String datoFind) throws Exception;
	public Persona findPersonaById(java.lang.Long id) throws Exception;
	public List<Persona> findAllPersonas() throws Exception;
	public void persistPersona(Persona persona) throws Exception;
	public void removePersona(Persona persona) throws Exception;
	//-----------------------------------------------------------------------
	// FIN Persona
	//-----------------------------------------------------------------------
	
}
