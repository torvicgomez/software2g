package com.software2g.historia_clinica.facade;

import java.util.List;

import com.software2g.vo.Acudiente;
import com.software2g.vo.Anamnesi;
import com.software2g.vo.Antecesentesflia;
import com.software2g.vo.Clasediagnostico;
import com.software2g.vo.Codigoenfermedade;
import com.software2g.vo.Consulta;
import com.software2g.vo.Convenio;
import com.software2g.vo.Dependencia;
import com.software2g.vo.Diagnostico;
import com.software2g.vo.Direccion;
import com.software2g.vo.Enfermedad;
import com.software2g.vo.Enfermedadsufrida;
import com.software2g.vo.Especificacionformula;
import com.software2g.vo.Especificacionpartecuerpo;
import com.software2g.vo.Especificaexamen;
import com.software2g.vo.Estadocivil;
import com.software2g.vo.Estadomedicamento;
import com.software2g.vo.Examen;
import com.software2g.vo.Examenpartecuerpo;
import com.software2g.vo.Finalidad;
import com.software2g.vo.Formulacion;
import com.software2g.vo.Frecuencia;
import com.software2g.vo.Listaexamenconsulta;
import com.software2g.vo.Motivo;
import com.software2g.vo.Paciente;
import com.software2g.vo.Parentesco;
import com.software2g.vo.Partescuerpo;
import com.software2g.vo.Personapertenece;
import com.software2g.vo.Posicion;
import com.software2g.vo.Registroexamen;
import com.software2g.vo.Registroformulacion;
import com.software2g.vo.Remision;
import com.software2g.vo.Seguridadsocial;
import com.software2g.vo.Servicio;
import com.software2g.vo.Sintoma;
import com.software2g.vo.Sintomacomun;
import com.software2g.vo.Telefono;
import com.software2g.vo.Tipodato;
import com.software2g.vo.Tipodiagnostico;
import com.software2g.vo.Tipodocumentoinst;
import com.software2g.vo.Tipoespecialidad;
import com.software2g.vo.Tiposervicio;
import com.software2g.vo.Tipoubicacion;
import com.software2g.vo.Tipovirtuallink;
import com.software2g.vo.Tomasinodroga;
import com.software2g.vo.Ubicaciondireccion;
import com.software2g.vo.Ubicaciontelefono;
import com.software2g.vo.Ubicacionvirtual;
import com.software2g.vo.Unidade;
import com.software2g.vo.Variableexamen;
import com.software2g.vo.Variableformulacion;
import com.software2g.vo.Virtuallink;

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
	// Fin Acudiente
	//******************************************************************
	
	//******************************************************************
	// Anamnesis
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Anamnesi findAnamnesiById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Anamnesi</code> entity.
	 */
	public List<Anamnesi> findAllAnamnesis() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAnamnesi(Anamnesi anamnesi) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAnamnesi(Anamnesi anamnesi) throws Exception;
	//******************************************************************
	// Fin Anamnesis
	//******************************************************************
	
	//******************************************************************
	// Antecedentes Familiares
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Antecesentesflia findAntecesentesfliaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Antecesentesflia</code> entity.
	 */
	public List<Antecesentesflia> findAllAntecesentesflias() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAntecesentesflia(Antecesentesflia antecesentesflia) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAntecesentesflia(Antecesentesflia antecesentesflia) throws Exception;
	//******************************************************************
	// Fin Antecedentes Familiares
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
	// Fin Clase Diagnostico
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
	// Fin Codigo Enfermedades
	//******************************************************************	

	//******************************************************************
	// Consulta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Consulta findConsultaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Consulta</code> entity.
	 */
	public List<Consulta> findAllConsultas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConsulta(Consulta consulta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConsulta(Consulta consulta) throws Exception;
	//******************************************************************
	// Fin Consulta
	//******************************************************************	

	//******************************************************************
	// Convenio
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Convenio findConvenioById(com.software2g.vo.ConvenioPK id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Convenio</code> entity.
	 */
	public List<Convenio> findAllConvenios() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConvenio(Convenio convenio) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConvenio(Convenio convenio) throws Exception;
	//******************************************************************
	// Fin Convenio
	//******************************************************************	

	//******************************************************************
	// Dependencia
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Dependencia findDependenciaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Dependencia</code> entity.
	 */
	public List<Dependencia> findAllDependencias() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDependencia(Dependencia dependencia) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDependencia(Dependencia dependencia) throws Exception;
	//******************************************************************
	// Fin Dependencia
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
	// Fin Diagnostico
	//******************************************************************	

	//******************************************************************
	// Direccion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Direccion findDireccionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Direccion</code> entity.
	 */
	public List<Direccion> findAllDireccions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDireccion(Direccion direccion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDireccion(Direccion direccion) throws Exception;
	//******************************************************************
	// Fin Direccion
	//******************************************************************	

	//******************************************************************
	// Enfermedad
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Enfermedad findEnfermedadById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Enfermedad</code> entity.
	 */
	public List<Enfermedad> findAllEnfermedads() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEnfermedad(Enfermedad enfermedad) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEnfermedad(Enfermedad enfermedad) throws Exception;
	//******************************************************************
	// Fin Enfermedad
	//******************************************************************	

	//******************************************************************
	// Enfermedad Sufrida
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Enfermedadsufrida findEnfermedadsufridaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Enfermedadsufrida</code> entity.
	 */
	public List<Enfermedadsufrida> findAllEnfermedadsufridas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEnfermedadsufrida(Enfermedadsufrida enfermedadsufrida) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEnfermedadsufrida(Enfermedadsufrida enfermedadsufrida) throws Exception;
	//******************************************************************
	// Fin Enfermedad Sufrida
	//******************************************************************	

	//******************************************************************
	// Especificacion Formula
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Especificacionformula findEspecificacionformulaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Especificacionformula</code> entity.
	 */
	public List<Especificacionformula> findAllEspecificacionformulas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionformula(Especificacionformula especificacionformula) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionformula(Especificacionformula especificacionformula) throws Exception;
	//******************************************************************
	// Fin Especificacion Formula
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
	// Fin Especificacion Parte Cuerpo
	//******************************************************************	

	//******************************************************************
	// Especificacion Examen
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Especificaexamen findEspecificaexamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Especificaexamen</code> entity.
	 */
	public List<Especificaexamen> findAllEspecificaexamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificaexamen(Especificaexamen especificaexamen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificaexamen(Especificaexamen especificaexamen) throws Exception;
	//******************************************************************
	// Fin Especificacion Examen
	//******************************************************************	

	//******************************************************************
	// Estado Civil
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Estadocivil findEstadocivilById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Estadocivil</code> entity.
	 */
	public List<Estadocivil> findAllEstadocivils() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadocivil(Estadocivil estadocivil) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadocivil(Estadocivil estadocivil) throws Exception;
	//******************************************************************
	// Fin Estado Civil
	//******************************************************************	

	//******************************************************************
	// Estado Medicamento
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Estadomedicamento findEstadomedicamentoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Estadomedicamento</code> entity.
	 */
	public List<Estadomedicamento> findAllEstadomedicamentos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception;
	//******************************************************************
	// Fin Estado Medicamento
	//******************************************************************	

	//******************************************************************
	// Examen Parte Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Examenpartecuerpo findExamenpartecuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Examenpartecuerpo</code> entity.
	 */
	public List<Examenpartecuerpo> findAllExamenpartecuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception;
	//******************************************************************
	// Fin Examen Parte Cuerpo
	//******************************************************************	

	//******************************************************************
	// Examen
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Examen findExamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Examen</code> entity.
	 */
	public List<Examen> findAllExamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamen(Examen examen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamen(Examen examen) throws Exception;
	//******************************************************************
	// Fin Examen
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
	// Fin Finalidad
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
	// Fin Formulacion
	//******************************************************************	

	//******************************************************************
	// Frecuencia
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Frecuencia findFrecuenciaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Frecuencia</code> entity.
	 */
	public List<Frecuencia> findAllFrecuencias() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFrecuencia(Frecuencia frecuencia) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFrecuencia(Frecuencia frecuencia) throws Exception;
	//******************************************************************
	// Fin Frecuencia
	//******************************************************************	

	//******************************************************************
	// Lista Examen Consulta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Listaexamenconsulta findListaexamenconsultaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Listaexamenconsulta</code> entity.
	 */
	public List<Listaexamenconsulta> findAllListaexamenconsultas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception;
	//******************************************************************
	// Fin Lista Examen Consulta
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
	// Fin Motivo
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
	/**
	 * Remove the given persistent instance.
	 */
	public void removePaciente(Paciente paciente) throws Exception;
	//******************************************************************
	// Fin Paciente
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
	// Fin Parentesco
	//******************************************************************	

	//******************************************************************
	// Partes Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Partescuerpo findPartescuerpoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Partescuerpo</code> entity.
	 */
	public List<Partescuerpo> findAllPartescuerpos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartescuerpo(Partescuerpo partescuerpo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartescuerpo(Partescuerpo partescuerpo) throws Exception;
	//******************************************************************
	// Fin Partes Cuerpo
	//******************************************************************	

	//******************************************************************
	// Persona Pertenece
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Personapertenece findPersonaperteneceById(com.software2g.vo.PersonapertenecePK id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Personapertenece</code> entity.
	 */
	public List<Personapertenece> findAllPersonaperteneces() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonapertenece(Personapertenece personapertenece) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonapertenece(Personapertenece personapertenece) throws Exception;
	//******************************************************************
	// Fin Persona Pertenece
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
	// Fin Posicion
	//******************************************************************	

	//******************************************************************
	// Registro Examen
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroexamen findRegistroexamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroexamen</code> entity.
	 */
	public List<Registroexamen> findAllRegistroexamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroexamen(Registroexamen registroexamen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroexamen(Registroexamen registroexamen) throws Exception;
	//******************************************************************
	// Fin Registro Examen
	//******************************************************************	

	//******************************************************************
	// Registro Formulacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Registroformulacion findRegistroformulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Registroformulacion</code> entity.
	 */
	public List<Registroformulacion> findAllRegistroformulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroformulacion(Registroformulacion registroformulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroformulacion(Registroformulacion registroformulacion) throws Exception;
	//******************************************************************
	// Fin Registro Formulacion
	//******************************************************************	

	//******************************************************************
	// Remision
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Remision findRemisionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Remision</code> entity.
	 */
	public List<Remision> findAllRemisions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRemision(Remision remision) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRemision(Remision remision) throws Exception;
	//******************************************************************
	// Fin Remision
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
	// Fin Seguridad Social
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
	// Fin Servicio
	//******************************************************************
	
	//******************************************************************
	// Sintoma Comun
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Sintomacomun findSintomacomunById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Sintomacomun</code> entity.
	 */
	public List<Sintomacomun> findAllSintomacomuns() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintomacomun(Sintomacomun sintomacomun) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintomacomun(Sintomacomun sintomacomun) throws Exception;
	//******************************************************************
	// Fin Sintoma Comun
	//******************************************************************	

	//******************************************************************
	// Sintoma
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Sintoma findSintomaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Sintoma</code> entity.
	 */
	public List<Sintoma> findAllSintomas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintoma(Sintoma sintoma) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintoma(Sintoma sintoma) throws Exception;
	//******************************************************************
	// Fin Sintoma
	//******************************************************************

	//******************************************************************
	// Telefono
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Telefono findTelefonoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Telefono</code> entity.
	 */
	public List<Telefono> findAllTelefonos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTelefono(Telefono telefono) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTelefono(Telefono telefono) throws Exception;
	//******************************************************************
	// Fin Telefono
	//******************************************************************	

	//******************************************************************
	// Tipo Dato
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipodato findTipodatoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipodato</code> entity.
	 */
	public List<Tipodato> findAllTipodatos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodato(Tipodato tipodato) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodato(Tipodato tipodato) throws Exception;
	//******************************************************************
	// Fin Tipo Dato
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
	// Fin Tipo Diagnostico
	//******************************************************************	

	//******************************************************************
	// Tipo Documento Institucion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipodocumentoinst findTipodocumentoinstById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipodocumentoinst</code> entity.
	 */
	public List<Tipodocumentoinst> findAllTipodocumentoinsts() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception;
	//******************************************************************
	// Fin Tipo Documento Institucion
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
	// Fin Tipo Especialidad
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
	// Fin Tipo Servicio
	//******************************************************************
	
	//******************************************************************
	// Tipo Ubicacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipoubicacion findTipoubicacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipoubicacion</code> entity.
	 */
	public List<Tipoubicacion> findAllTipoubicacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoubicacion(Tipoubicacion tipoubicacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoubicacion(Tipoubicacion tipoubicacion) throws Exception;
	//******************************************************************
	// Fin Tipo Ubicacion 
	//******************************************************************
	
	//******************************************************************
	// Tipo Virtual Link
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tipovirtuallink findTipovirtuallinkById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tipovirtuallink</code> entity.
	 */
	public List<Tipovirtuallink> findAllTipovirtuallinks() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception;
	//******************************************************************
	// Fin Tipo Virtual Link
	//******************************************************************
	
	//******************************************************************
	// Toma Droga
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Tomasinodroga findTomasinodrogaById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Tomasinodroga</code> entity.
	 */
	public List<Tomasinodroga> findAllTomasinodrogas() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTomasinodroga(Tomasinodroga tomasinodroga) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTomasinodroga(Tomasinodroga tomasinodroga) throws Exception;
	//******************************************************************
	// Fin Toma Droga
	//******************************************************************
	
	//******************************************************************
	// Ubicacion Direccion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ubicaciondireccion findUbicaciondireccionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ubicaciondireccion</code> entity.
	 */
	public List<Ubicaciondireccion> findAllUbicaciondireccions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception;
	//******************************************************************
	// Fin Ubicacion Direccion 
	//******************************************************************
	
	//******************************************************************
	// Ubicacion Telefono
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ubicaciontelefono findUbicaciontelefonoById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ubicaciontelefono</code> entity.
	 */
	public List<Ubicaciontelefono> findAllUbicaciontelefonos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception;
	//******************************************************************
	// Fin Ubicacion Telefono
	//******************************************************************
	
	//******************************************************************
	// Ubicacion Virtual
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Ubicacionvirtual findUbicacionvirtualById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Ubicacionvirtual</code> entity.
	 */
	public List<Ubicacionvirtual> findAllUbicacionvirtuals() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception;
	//******************************************************************
	// Fin Ubicacion Virtual
	//******************************************************************

	//******************************************************************
	// Unidades
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Unidade findUnidadeById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Unidade</code> entity.
	 */
	public List<Unidade> findAllUnidades() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUnidade(Unidade unidade) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUnidade(Unidade unidade) throws Exception;
	//******************************************************************
	// Fin Unidades
	//******************************************************************
	
	//******************************************************************
	// Variable Examen
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Variableexamen findVariableexamenById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Variableexamen</code> entity.
	 */
	public List<Variableexamen> findAllVariableexamens() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableexamen(Variableexamen variableexamen) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableexamen(Variableexamen variableexamen) throws Exception;
	//******************************************************************
	// Fin Variable Examen
	//******************************************************************
	
	//******************************************************************
	// Variable Formualcion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Variableformulacion findVariableformulacionById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Variableformulacion</code> entity.
	 */
	public List<Variableformulacion> findAllVariableformulacions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableformulacion(Variableformulacion variableformulacion) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableformulacion(Variableformulacion variableformulacion) throws Exception;
	//******************************************************************
	// Fin Variable Formulacion
	//******************************************************************
	
	//******************************************************************
	// Virtual Link
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Virtuallink findVirtuallinkById(long id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Virtuallink</code> entity.
	 */
	public List<Virtuallink> findAllVirtuallinks() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVirtuallink(Virtuallink virtuallink) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVirtuallink(Virtuallink virtuallink) throws Exception;
	//******************************************************************
	// Fin Virtual Link
	//******************************************************************
		
}
