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
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************
}
