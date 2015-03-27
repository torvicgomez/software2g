package com.software2g.agenda.facade;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public Agenda findIdAgenda(String background) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAgenda(Agenda agenda) throws Exception;
	public long persistAgendaId(Agenda agenda) throws Exception;
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
	public List<Evento> findAllEventosxAgenda(long idAgenda) throws Exception;
	public List<Agenda> findAllEventosAgendas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEvento(Evento evento) throws Exception;
	public long persistEventoId(Evento evento) throws Exception;
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
	public Profesional findProfesionalIdPersona(long idPersona) throws Exception;
	public boolean validoBackgroundProf(String background) throws Exception;
	public Profesional findProfesionalBackground(String background) throws Exception;
	/**
	 * Return all persistent instances of the <code>Profesional</code> entity.
	 */
	public List<Profesional> findAllProfesionals() throws Exception;
	public List<Profesional> findAllProfesionalAgenda() throws Exception;
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
	public Persona findPersona(String documento, String abrevTidoc) throws Exception;
	public List<Persona> findAllPersonas() throws Exception;
	public void persistPersona(Persona persona) throws Exception;
	public long persistPersonaId(Persona persona) throws Exception;
	public void removePersona(Persona persona) throws Exception;
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
	public Participante findParticipanteById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Participante</code> entity.
	 */
	public List<Participante> findAllParticipantes() throws Exception;
	public List<Participante> findAllParticipantes(long idEvento) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParticipante(Participante participante) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParticipante(Participante participante) throws Exception;
	//-----------------------------------------------------------------------
	// FIN Participante
	//-----------------------------------------------------------------------

	//-----------------------------------------------------------------------
	// Procedimiento
	//-----------------------------------------------------------------------
	public Procedimiento findProcedimientoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Procedimiento</code> entity.
	 */
	public List<Procedimiento> findAllProcedimientos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistProcedimiento(Procedimiento procedimiento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeProcedimiento(Procedimiento procedimiento) throws Exception;
	//-----------------------------------------------------------------------
	// FIN Procedimiento
	//-----------------------------------------------------------------------
	
	//-----------------------------------------------------------------------
	// Tipo Procedimiento
	//-----------------------------------------------------------------------
	public Tipoprocedimiento findTipoprocedimientoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoprocedimiento</code> entity.
	 */
	public List<Tipoprocedimiento> findAllTipoprocedimientos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoprocedimiento(Tipoprocedimiento tipoprocedimiento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoprocedimiento(Tipoprocedimiento tipoprocedimiento) throws Exception;
	//-----------------------------------------------------------------------
	// FIN Tipo Procedimiento
	//-----------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad TipoDocumento
	public Tipodocumento findTipodocumentoById(java.lang.Integer id) throws Exception;
	public Tipodocumento findTipodocumentoAbrev(String abrevTidoc) throws Exception;
	public List<Tipodocumento> findAllTipodocumentos() throws Exception;
	public void persistTipodocumento(Tipodocumento tipodocumento) throws Exception;
	public void removeTipodocumento(Tipodocumento tipodocumento) throws Exception;
	//FIN --- Metodos Entidad TipoDocumento
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Pais
	public Pais findPaisById(long id) throws Exception;
	public List<Pais> findAllPaiss() throws Exception;
	//FIN --- Metodos Entidad Pais
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Departamento
	public Departamento findDepartamentoById(long id) throws Exception;
	public List<Departamento> findAllDepartamentos() throws Exception;
	//FIN --- Metodos Entidad Departamento
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Metodos Entidad Municipio
	public Municipio findMunicipioById(long id) throws Exception;
	public List<Municipio> findAllMunicipios() throws Exception;
	public List<Municipio> findAllMunicipios(long idDpto) throws Exception;
	//FIN --- Metodos Entidad Municipio
	//--------------------------------------------------------------------------
	
	public boolean crearFile(String path, String nameFile, String ext, String tipoFile, String infoFind) throws Exception;
	public Persona findPacienteAtencionServicio(long evenId)throws Exception;
}
