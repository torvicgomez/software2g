package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Acudiente;
import com.software2g.vo.Archivoservicio;
import com.software2g.vo.Clasediagnostico;
import com.software2g.vo.Codigoenfermedade;
import com.software2g.vo.Diagnostico;
import com.software2g.vo.Especificacionpartecuerpo;
import com.software2g.vo.Examenespecialidad;
import com.software2g.vo.Examenoptometria;
import com.software2g.vo.Finalidad;
import com.software2g.vo.Formulacion;
import com.software2g.vo.Gafa;
import com.software2g.vo.Medicamento;
import com.software2g.vo.Motivo;
import com.software2g.vo.Odontograma;
import com.software2g.vo.Opcionrespuesta;
import com.software2g.vo.Paciente;
import com.software2g.vo.Parentesco;
import com.software2g.vo.Partecuerpo;
import com.software2g.vo.Persona;
import com.software2g.vo.Posicion;
import com.software2g.vo.Pregunta;
import com.software2g.vo.Registroavsc;
import com.software2g.vo.Registrocovertest;
import com.software2g.vo.Registroexamensimple;
import com.software2g.vo.Registroodontograma;
import com.software2g.vo.Registrorxuso;
import com.software2g.vo.Respuesta;
import com.software2g.vo.Seccionodon;
import com.software2g.vo.Segmentoanamnesi;
import com.software2g.vo.Seguridadsocial;
import com.software2g.vo.Servicio;
import com.software2g.vo.Tipodiagnostico;
import com.software2g.vo.Tipoespecialidad;
import com.software2g.vo.Tipoexamenopt;
import com.software2g.vo.Tipoformulacion;
import com.software2g.vo.Tipopregunta;
import com.software2g.vo.Tiposegmento;
import com.software2g.vo.Tiposervicio;

public interface IGestionFacadeHistoriaClinica {

	//******************************************************************
	// Acudiente
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Acudiente findAcudienteById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Acudiente</code> entity.
	 */
	public List<Acudiente> findAllAcudientes() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAcudiente(Acudiente acudiente) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAcudiente(Acudiente acudiente) throws Exception;
	//******************************************************************
	// FIN Acudiente
	//******************************************************************
	//******************************************************************
	// Archivo Servicio
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Archivoservicio findArchivoservicioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Archivoservicio</code> entity.
	 */
	public List<Archivoservicio> findAllArchivoservicios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArchivoservicio(Archivoservicio archivoservicio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivoservicio(Archivoservicio archivoservicio) throws Exception;
	//******************************************************************
	// FIN Archivo Servicio
	//******************************************************************
	//******************************************************************
	// Clase Diagnostico
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Clasediagnostico findClasediagnosticoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Clasediagnostico</code> entity.
	 */
	public List<Clasediagnostico> findAllClasediagnosticos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistClasediagnostico(Clasediagnostico clasediagnostico) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeClasediagnostico(Clasediagnostico clasediagnostico) throws Exception;
	//******************************************************************
	// FIN Clase Diagnostico
	//******************************************************************
	//******************************************************************
	// Codigo Enfermedades
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Codigoenfermedade findCodigoenfermedadeById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Codigoenfermedade</code> entity.
	 */
	public List<Codigoenfermedade> findAllCodigoenfermedades() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCodigoenfermedade(Codigoenfermedade codigoenfermedade) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCodigoenfermedade(Codigoenfermedade codigoenfermedade) throws Exception;
	//******************************************************************
	// FIN Codigo Enfermedades
	//******************************************************************
	//******************************************************************
	// Diagnostico
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Diagnostico findDiagnosticoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Diagnostico</code> entity.
	 */
	public List<Diagnostico> findAllDiagnosticos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDiagnostico(Diagnostico diagnostico) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDiagnostico(Diagnostico diagnostico) throws Exception;
	//******************************************************************
	// FIN Diagnostico
	//******************************************************************
	//******************************************************************
	// Especificacion Parte Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Especificacionpartecuerpo findEspecificacionpartecuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Especificacionpartecuerpo</code> entity.
	 */
	public List<Especificacionpartecuerpo> findAllEspecificacionpartecuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception;
	//******************************************************************
	// FIN Especificacion Parte Cuerpo
	//******************************************************************
	//******************************************************************
	// Examen Optometria
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Examenoptometria findExamenoptometriaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Examenoptometria</code> entity.
	 */
	public List<Examenoptometria> findAllExamenoptometrias() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenoptometria(Examenoptometria examenoptometria) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenoptometria(Examenoptometria examenoptometria) throws Exception;
	//******************************************************************
	// FIN Examen Optometria
	//******************************************************************
	//******************************************************************
	// Finalidad
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Finalidad findFinalidadById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Finalidad</code> entity.
	 */
	public List<Finalidad> findAllFinalidads() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFinalidad(Finalidad finalidad) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFinalidad(Finalidad finalidad) throws Exception;
	//******************************************************************
	// FIN Finalidad
	//******************************************************************
	//******************************************************************
	// Formulacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Formulacion findFormulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Formulacion</code> entity.
	 */
	public List<Formulacion> findAllFormulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormulacion(Formulacion formulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormulacion(Formulacion formulacion) throws Exception;
	//******************************************************************
	// FIN Formulacion
	//******************************************************************
	//******************************************************************
	// Gafas
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Gafa findGafaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Gafa</code> entity.
	 */
	public List<Gafa> findAllGafas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistGafa(Gafa gafa) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeGafa(Gafa gafa) throws Exception;
	//******************************************************************
	// FIN Gafas
	//******************************************************************
	//******************************************************************
	// Medicamento
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Medicamento findMedicamentoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Medicamento</code> entity.
	 */
	public List<Medicamento> findAllMedicamentos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMedicamento(Medicamento medicamento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMedicamento(Medicamento medicamento) throws Exception;
	//******************************************************************
	// FIN Medicamento
	//******************************************************************
	//******************************************************************
	// Motivo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Motivo findMotivoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Motivo</code> entity.
	 */
	public List<Motivo> findAllMotivos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMotivo(Motivo motivo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMotivo(Motivo motivo) throws Exception;
	//******************************************************************
	// FIN Motivo
	//******************************************************************
	//******************************************************************
	// Odontograma
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Odontograma findOdontogramaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Odontograma</code> entity.
	 */
	public List<Odontograma> findAllOdontogramas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOdontograma(Odontograma odontograma) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOdontograma(Odontograma odontograma) throws Exception;
	//******************************************************************
	// FIN Odontograma
	//******************************************************************
	//******************************************************************
	// Opcion Respuesta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Opcionrespuesta findOpcionrespuestaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Opcionrespuesta</code> entity.
	 */
	public List<Opcionrespuesta> findAllOpcionrespuestas() throws Exception;
	public List<Opcionrespuesta> findAllOpcionrespuestas(long preg_id) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOpcionrespuesta(Opcionrespuesta opcionrespuesta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOpcionrespuesta(Opcionrespuesta opcionrespuesta) throws Exception;
	//******************************************************************
	// FIN Opcion Respuesta
	//******************************************************************
	//******************************************************************
	// Paciente
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Paciente findPacienteById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Paciente</code> entity.
	 */
	public List<Paciente> findAllPacientes() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPaciente(Paciente paciente) throws Exception;
	public long persistPacienteId(Paciente paciente) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePaciente(Paciente paciente) throws Exception;
	//******************************************************************
	// FIN Paciente
	//******************************************************************
	//******************************************************************
	// Parentesco
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Parentesco findParentescoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Parentesco</code> entity.
	 */
	public List<Parentesco> findAllParentescos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParentesco(Parentesco parentesco) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParentesco(Parentesco parentesco) throws Exception;
	//******************************************************************
	// FIN Parentesco
	//******************************************************************
	//******************************************************************
	// Parte Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Partecuerpo findPartecuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Partecuerpo</code> entity.
	 */
	public List<Partecuerpo> findAllPartecuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartecuerpo(Partecuerpo partecuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartecuerpo(Partecuerpo partecuerpo) throws Exception;
	//******************************************************************
	// FIN Parte Cuerpo
	//******************************************************************
	//******************************************************************
	// Posicion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Posicion findPosicionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Posicion</code> entity.
	 */
	public List<Posicion> findAllPosicions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPosicion(Posicion posicion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePosicion(Posicion posicion) throws Exception;
	//******************************************************************
	// FIN Posicion
	//******************************************************************
	//******************************************************************
	// Pregunta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Pregunta findPreguntaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Pregunta</code> entity.
	 */
	public List<Pregunta> findAllPreguntas() throws Exception;
	public List<Pregunta> findAllPreguntasXSegmentoAna(long seanId) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPregunta(Pregunta pregunta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePregunta(Pregunta pregunta) throws Exception;
	//******************************************************************
	// FIN Pregunta
	//******************************************************************
	//******************************************************************
	// Registro AVSC
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroavsc findRegistroavscById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroavsc</code> entity.
	 */
	public List<Registroavsc> findAllRegistroavscs() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroavsc(Registroavsc registroavsc) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroavsc(Registroavsc registroavsc) throws Exception;
	//******************************************************************
	// FIN Registro AVSC
	//******************************************************************
	//******************************************************************
	// Registro Cover Test
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registrocovertest findRegistrocovertestById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registrocovertest</code> entity.
	 */
	public List<Registrocovertest> findAllRegistrocovertests() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistrocovertest(Registrocovertest registrocovertest) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrocovertest(Registrocovertest registrocovertest) throws Exception;
	//******************************************************************
	// FIN Registro Covert Test
	//******************************************************************
	//******************************************************************
	// Registro Examen Simple
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroexamensimple findRegistroexamensimpleById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroexamensimple</code> entity.
	 */
	public List<Registroexamensimple> findAllRegistroexamensimples() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroexamensimple(Registroexamensimple registroexamensimple) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroexamensimple(Registroexamensimple registroexamensimple) throws Exception;
	//******************************************************************
	// FIN Registro Examen Simple
	//******************************************************************
	//******************************************************************
	// Registro Odontograma
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroodontograma findRegistroodontogramaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroodontograma</code> entity.
	 */
	public List<Registroodontograma> findAllRegistroodontogramas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroodontograma(Registroodontograma registroodontograma) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroodontograma(Registroodontograma registroodontograma) throws Exception;
	//******************************************************************
	// FIN Registro Odontograma
	//******************************************************************
	//******************************************************************
	// Registro Rx Uso
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registrorxuso findRegistrorxusoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registrorxuso</code> entity.
	 */
	public List<Registrorxuso> findAllRegistrorxusos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistrorxuso(Registrorxuso registrorxuso) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrorxuso(Registrorxuso registrorxuso) throws Exception;
	//******************************************************************
	// FIN Registro Rx Uso
	//******************************************************************
	//******************************************************************
	// Respuesta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Respuesta findRespuestaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Respuesta</code> entity.
	 */
	public List<Respuesta> findAllRespuestas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRespuesta(Respuesta respuesta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRespuesta(Respuesta respuesta) throws Exception;
	//******************************************************************
	// FIN Respuesta
	//******************************************************************
	//******************************************************************
	// Seccion Odon
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Seccionodon findSeccionodonById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Seccionodon</code> entity.
	 */
	public List<Seccionodon> findAllSeccionodons() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeccionodon(Seccionodon seccionodon) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeccionodon(Seccionodon seccionodon) throws Exception;
	//******************************************************************
	// FIN Seccion Odon
	//******************************************************************
	//******************************************************************
	// Segmento Anamnesis
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Segmentoanamnesi findSegmentoanamnesiById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Segmentoanamnesi</code> entity.
	 */
	public List<Segmentoanamnesi> findAllSegmentoanamnesis() throws Exception;
	public List<Segmentoanamnesi> findAllSegmentoanamnesis(long tiesId) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi) throws Exception;
	//******************************************************************
	// FIN Segmento Anamnesis
	//******************************************************************
	//******************************************************************
	// Seguridad Social
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Seguridadsocial findSeguridadsocialById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Seguridadsocial</code> entity.
	 */
	public List<Seguridadsocial> findAllSeguridadsocials() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception;
	//******************************************************************
	// FIN Seguridad Social
	//******************************************************************
	//******************************************************************
	// Servicio
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Servicio findServicioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Servicio</code> entity.
	 */
	public List<Servicio> findAllServicios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistServicio(Servicio servicio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeServicio(Servicio servicio) throws Exception;
	//******************************************************************
	// FIN Servicio
	//******************************************************************
	//******************************************************************
	// Tipo Diagnostico
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipodiagnostico findTipodiagnosticoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipodiagnostico</code> entity.
	 */
	public List<Tipodiagnostico> findAllTipodiagnosticos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception;
	//******************************************************************
	// FIN Tipo Diagnostico
	//******************************************************************
	//******************************************************************
	// Tipo Especialidad
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipoespecialidad findTipoespecialidadById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoespecialidad</code> entity.
	 */
	public List<Tipoespecialidad> findAllTipoespecialidads() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception;
	//******************************************************************
	// FIN Tipo Especialidad
	//******************************************************************
	//******************************************************************
	// Tipo Examen Opt
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipoexamenopt findTipoexamenoptById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoexamenopt</code> entity.
	 */
	public List<Tipoexamenopt> findAllTipoexamenopts() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoexamenopt(Tipoexamenopt tipoexamenopt) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoexamenopt(Tipoexamenopt tipoexamenopt) throws Exception;
	//******************************************************************
	// FIN Tipo Examen Opt
	//******************************************************************
	//******************************************************************
	// Tipo Formulacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipoformulacion findTipoformulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoformulacion</code> entity.
	 */
	public List<Tipoformulacion> findAllTipoformulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoformulacion(Tipoformulacion tipoformulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoformulacion(Tipoformulacion tipoformulacion) throws Exception;
	//******************************************************************
	// FIN Tipo Formulacion
	//******************************************************************
	//******************************************************************
	// Tipo Pregunta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipopregunta findTipopreguntaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipopregunta</code> entity.
	 */
	public List<Tipopregunta> findAllTipopreguntas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipopregunta(Tipopregunta tipopregunta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipopregunta(Tipopregunta tipopregunta) throws Exception;
	//******************************************************************
	// FIN Tipo Pregunta
	//******************************************************************
	//******************************************************************
	// Tipo Segmento
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tiposegmento findTiposegmentoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tiposegmento</code> entity.
	 */
	public List<Tiposegmento> findAllTiposegmentos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposegmento(Tiposegmento tiposegmento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposegmento(Tiposegmento tiposegmento) throws Exception;
	//******************************************************************
	// FIN Tipo Segmento
	//******************************************************************
	//******************************************************************
	// Tipo Servicio
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tiposervicio findTiposervicioById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tiposervicio</code> entity.
	 */
	public List<Tiposervicio> findAllTiposervicios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposervicio(Tiposervicio tiposervicio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposervicio(Tiposervicio tiposervicio) throws Exception;
	//******************************************************************
	// FIN Tipo Servicio
	//******************************************************************

	//******************************************************************
	// Examen Especialidad
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Examenespecialidad findExamenespecialidadById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Examenespecialidad</code> entity.
	 */
	public List<Examenespecialidad> findAllExamenespecialidads() throws Exception;
	public List<Examenespecialidad> findAllExamenespecialidads(long tipoEspecialidad) throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenespecialidad(Examenespecialidad examenespecialidad) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenespecialidad(Examenespecialidad examenespecialidad) throws Exception;
	//******************************************************************
	// FIN Examen Especialidad
	//******************************************************************
	
}
