package com.software2g.historia_clinica.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.historia_clinica.dao.IAcudienteDao;
import com.software2g.historia_clinica.dao.IAnamnesisDao;
import com.software2g.historia_clinica.dao.IAntecedentesFliaDao;
import com.software2g.historia_clinica.dao.IClaseDiagnosticoDao;
import com.software2g.historia_clinica.dao.ICodigoEnfermedadesDao;
import com.software2g.historia_clinica.dao.IConsultaDao;
import com.software2g.historia_clinica.dao.IConvenioDao;
import com.software2g.historia_clinica.dao.IDependenciaDao;
import com.software2g.historia_clinica.dao.IDiagnosticoDao;
import com.software2g.historia_clinica.dao.IDireccionDao;
import com.software2g.historia_clinica.dao.IEnfermedadDao;
import com.software2g.historia_clinica.dao.IEnfermedadSufridaDao;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
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

public class GestionFacadeHistoriaClinica implements IGestionFacadeHistoriaClinica {
	@Autowired
	IAcudienteDao acudienteDao; 
	@Autowired
	IAnamnesisDao anamnesisDao;
	@Autowired
	IAntecedentesFliaDao antecedentesFliaDao;
	@Autowired
	IClaseDiagnosticoDao claseDiagnosticoDao;
	@Autowired
	ICodigoEnfermedadesDao codigoEnfermedadesDao;
	@Autowired
	IConsultaDao consultaDao;
	@Autowired
	IConvenioDao convenioDao;
	@Autowired
	IDependenciaDao dependenciaDao;
	@Autowired
	IDiagnosticoDao diagnosticoDao;
	@Autowired
	IDireccionDao direccionDao;
	@Autowired
	IEnfermedadDao enfermedadDao;
	@Autowired
	IEnfermedadSufridaDao enfermedadSufridaDao;
	
	public IAcudienteDao getAcudienteDao() {return acudienteDao;}
	public void setAcudienteDao(IAcudienteDao acudienteDao) {this.acudienteDao = acudienteDao;}
	public IAnamnesisDao getAnamnesisDao() {return anamnesisDao;}
	public void setAnamnesisDao(IAnamnesisDao anamnesisDao) {this.anamnesisDao = anamnesisDao;}
	public IAntecedentesFliaDao getAntecedentesFliaDao() {return antecedentesFliaDao;}
	public void setAntecedentesFliaDao(IAntecedentesFliaDao antecedentesFliaDao) {this.antecedentesFliaDao = antecedentesFliaDao;}
	public IClaseDiagnosticoDao getClaseDiagnosticoDao() {return claseDiagnosticoDao;}
	public void setClaseDiagnosticoDao(IClaseDiagnosticoDao claseDiagnosticoDao) {this.claseDiagnosticoDao = claseDiagnosticoDao;}
	public ICodigoEnfermedadesDao getCodigoEnfermedadesDao() {return codigoEnfermedadesDao;}
	public void setCodigoEnfermedadesDao(ICodigoEnfermedadesDao codigoEnfermedadesDao) {this.codigoEnfermedadesDao = codigoEnfermedadesDao;}
	public IConsultaDao getConsultaDao() {return consultaDao;}
	public void setConsultaDao(IConsultaDao consultaDao) {this.consultaDao = consultaDao;}
	public IConvenioDao getConvenioDao() {return convenioDao;}
	public void setConvenioDao(IConvenioDao convenioDao) {this.convenioDao = convenioDao;}
	public IDependenciaDao getDependenciaDao() {return dependenciaDao;}
	public void setDependenciaDao(IDependenciaDao dependenciaDao) {this.dependenciaDao = dependenciaDao;}
	public IDiagnosticoDao getDiagnosticoDao() {return diagnosticoDao;}
	public void setDiagnosticoDao(IDiagnosticoDao diagnosticoDao) {this.diagnosticoDao = diagnosticoDao;}
	public IDireccionDao getDireccionDao() {return direccionDao;}
	public void setDireccionDao(IDireccionDao direccionDao) {this.direccionDao = direccionDao;}
	public IEnfermedadDao getEnfermedadDao() {return enfermedadDao;}
	public void setEnfermedadDao(IEnfermedadDao enfermedadDao) {this.enfermedadDao = enfermedadDao;}
	public IEnfermedadSufridaDao getEnfermedadSufridaDao() {return enfermedadSufridaDao;}
	public void setEnfermedadSufridaDao(IEnfermedadSufridaDao enfermedadSufridaDao) {this.enfermedadSufridaDao = enfermedadSufridaDao;}
	
	
	//******************************************************************
	// Acudiente
	//******************************************************************	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Acudiente findAcudienteById(long id) throws Exception {
		try {
			return getAcudienteDao().findAcudienteById(id);
		} catch (RuntimeException e) {
			throw new Exception("findAcudienteById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Acudiente</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Acudiente> findAllAcudientes() throws Exception {
		try {
			return getAcudienteDao().findAllAcudientes();
		} catch (RuntimeException e) {
			throw new Exception("findAllAcudientes failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAcudiente(Acudiente acudiente) throws Exception {
		try {
			getAcudienteDao().persistAcudiente(acudiente);
		} catch (RuntimeException e) {
			throw new Exception("persistAcudiente failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAcudiente(Acudiente acudiente) throws Exception {
		try {
			getAcudienteDao().removeAcudiente(acudiente);
		} catch (RuntimeException e) {
			throw new Exception("removeAcudiente failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Anamnesi findAnamnesiById(long id) throws Exception {
		try {
			return getAnamnesisDao().findAnamnesiById(id);
		} catch (RuntimeException e) {
			throw new Exception("findAnamnesiById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Anamnesi</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Anamnesi> findAllAnamnesis() throws Exception {
		try {
			return getAnamnesisDao().findAllAnamnesis();
		} catch (RuntimeException e) {
			throw new Exception("findAllAnamnesis failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAnamnesi(Anamnesi anamnesi) throws Exception {
		try {
			getAnamnesisDao().persistAnamnesi(anamnesi);
		} catch (RuntimeException e) {
			throw new Exception("persistAnamnesi failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAnamnesi(Anamnesi anamnesi) throws Exception {
		try {
			getAnamnesisDao().removeAnamnesi(anamnesi);
		} catch (RuntimeException e) {
			throw new Exception("removeAnamnesi failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Antecesentesflia findAntecesentesfliaById(long id) throws Exception {
		try {
			return getAntecedentesFliaDao().findAntecesentesfliaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findAntecesentesfliaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Antecesentesflia</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Antecesentesflia> findAllAntecesentesflias() throws Exception {
		try {
			return getAntecedentesFliaDao().findAllAntecesentesflias();
		} catch (RuntimeException e) {
			throw new Exception("findAllAntecesentesflias failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistAntecesentesflia(Antecesentesflia antecesentesflia) throws Exception {
		try {
			getAntecedentesFliaDao().persistAntecesentesflia(antecesentesflia);
		} catch (RuntimeException e) {
			throw new Exception("persistAntecesentesflia failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeAntecesentesflia(Antecesentesflia antecesentesflia) throws Exception {
		try {
			getAntecedentesFliaDao().removeAntecesentesflia(antecesentesflia);
		} catch (RuntimeException e) {
			throw new Exception("removeAntecesentesflia failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Clasediagnostico findClasediagnosticoById(long id) throws Exception {
		try {
			return getClaseDiagnosticoDao().findClasediagnosticoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findClasediagnosticoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Clasediagnostico</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Clasediagnostico> findAllClasediagnosticos() throws Exception {
		try {
			return getClaseDiagnosticoDao().findAllClasediagnosticos();
		} catch (RuntimeException e) {
			throw new Exception("findAllClasediagnosticos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistClasediagnostico(Clasediagnostico clasediagnostico) throws Exception {
		try {
			getClaseDiagnosticoDao().persistClasediagnostico(clasediagnostico);
		} catch (RuntimeException e) {
			throw new Exception("persistClasediagnostico failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeClasediagnostico(Clasediagnostico clasediagnostico) throws Exception {
		try {
			getClaseDiagnosticoDao().removeClasediagnostico(clasediagnostico);
		} catch (RuntimeException e) {
			throw new Exception("removeClasediagnostico failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Codigoenfermedade findCodigoenfermedadeById(long id) throws Exception {
		try {
			return getCodigoEnfermedadesDao().findCodigoenfermedadeById(id);
		} catch (RuntimeException e) {
			throw new Exception("findCodigoenfermedadeById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Codigoenfermedade</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Codigoenfermedade> findAllCodigoenfermedades() throws Exception {
		try {
			return getCodigoEnfermedadesDao().findAllCodigoenfermedades();
		} catch (RuntimeException e) {
			throw new Exception("findAllCodigoenfermedades failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCodigoenfermedade(Codigoenfermedade codigoenfermedade) throws Exception {
		try {
			getCodigoEnfermedadesDao().persistCodigoenfermedade(codigoenfermedade);
		} catch (RuntimeException e) {
			throw new Exception("persistCodigoenfermedade failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCodigoenfermedade(Codigoenfermedade codigoenfermedade) throws Exception {
		try {
			getCodigoEnfermedadesDao().removeCodigoenfermedade(codigoenfermedade);
		} catch (RuntimeException e) {
			throw new Exception("removeCodigoenfermedade failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Consulta findConsultaById(long id) throws Exception {
		try {
			return getConsultaDao().findConsultaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findConsultaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Consulta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Consulta> findAllConsultas() throws Exception {
		try {
			return getConsultaDao().findAllConsultas();
		} catch (RuntimeException e) {
			throw new Exception("findAllConsultas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConsulta(Consulta consulta) throws Exception {
		try {
			getConsultaDao().persistConsulta(consulta);
		} catch (RuntimeException e) {
			throw new Exception("persistConsulta failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConsulta(Consulta consulta) throws Exception {
		try {
			getConsultaDao().removeConsulta(consulta);
		} catch (RuntimeException e) {
			throw new Exception("removeConsulta failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Convenio findConvenioById(com.software2g.vo.ConvenioPK id) throws Exception {
		try {
			return getConvenioDao().findConvenioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findConvenioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Convenio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Convenio> findAllConvenios() throws Exception {
		try {
			return getConvenioDao().findAllConvenios();
		} catch (RuntimeException e) {
			throw new Exception("findAllConvenios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistConvenio(Convenio convenio) throws Exception {
		try {
			getConvenioDao().persistConvenio(convenio);
		} catch (RuntimeException e) {
			throw new Exception("persistConvenio failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeConvenio(Convenio convenio) throws Exception {
		try {
			getConvenioDao().removeConvenio(convenio);
		} catch (RuntimeException e) {
			throw new Exception("removeConvenio failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Convenio
	//******************************************************************	

	//******************************************************************
	// Dependnecia
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Dependencia findDependenciaById(long id) throws Exception {
		try {
			return getDependenciaDao().findDependenciaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDependenciaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Dependencia</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Dependencia> findAllDependencias() throws Exception {
		try {
			return getDependenciaDao().findAllDependencias();
		} catch (RuntimeException e) {
			throw new Exception("findAllDependencias failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDependencia(Dependencia dependencia) throws Exception {
		try {
			getDependenciaDao().persistDependencia(dependencia);
		} catch (RuntimeException e) {
			throw new Exception("persistDependencia failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDependencia(Dependencia dependencia) throws Exception {
		try {
			getDependenciaDao().removeDependencia(dependencia);
		} catch (RuntimeException e) {
			throw new Exception("removeDependencia failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Dependnecia
	//******************************************************************	

	//******************************************************************
	// Diagnostico
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Diagnostico findDiagnosticoById(long id) throws Exception {
		try {
			return getDiagnosticoDao().findDiagnosticoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDiagnosticoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Diagnostico</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Diagnostico> findAllDiagnosticos() throws Exception {
		try {
			return getDiagnosticoDao().findAllDiagnosticos();
		} catch (RuntimeException e) {
			throw new Exception("findAllDiagnosticos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDiagnostico(Diagnostico diagnostico) throws Exception {
		try {
			getDiagnosticoDao().persistDiagnostico(diagnostico);
		} catch (RuntimeException e) {
			throw new Exception("persistDiagnostico failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDiagnostico(Diagnostico diagnostico) throws Exception {
		try {
			getDiagnosticoDao().removeDiagnostico(diagnostico);
		} catch (RuntimeException e) {
			throw new Exception("removeDiagnostico failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Direccion findDireccionById(long id) throws Exception {
		try {
			return getDireccionDao().findDireccionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findDireccionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Direccion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Direccion> findAllDireccions() throws Exception {
		try {
			return getDireccionDao().findAllDireccions();
		} catch (RuntimeException e) {
			throw new Exception("findAllDireccions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistDireccion(Direccion direccion) throws Exception {
		try {
			getDireccionDao().persistDireccion(direccion);
		} catch (RuntimeException e) {
			throw new Exception("persistDireccion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeDireccion(Direccion direccion) throws Exception {
		try {
			getDireccionDao().removeDireccion(direccion);
		} catch (RuntimeException e) {
			throw new Exception("removeDireccion failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Enfermedad findEnfermedadById(long id) throws Exception {
		try {
			return getEnfermedadDao().findEnfermedadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEnfermedadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Enfermedad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Enfermedad> findAllEnfermedads() throws Exception {
		try {
			return getEnfermedadDao().findAllEnfermedads();
		} catch (RuntimeException e) {
			throw new Exception("findAllEnfermedads failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEnfermedad(Enfermedad enfermedad) throws Exception {
		try {
			getEnfermedadDao().persistEnfermedad(enfermedad);
		} catch (RuntimeException e) {
			throw new Exception("persistEnfermedad failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEnfermedad(Enfermedad enfermedad) throws Exception {
		try {
			getEnfermedadDao().removeEnfermedad(enfermedad);
		} catch (RuntimeException e) {
			throw new Exception("removeEnfermedad failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Enfermedadsufrida findEnfermedadsufridaById(long id) throws Exception {
		try {
			return getEnfermedadSufridaDao().findEnfermedadsufridaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEnfermedadsufridaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Enfermedadsufrida</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Enfermedadsufrida> findAllEnfermedadsufridas() throws Exception {
		try {
			return getEnfermedadSufridaDao().findAllEnfermedadsufridas();
		} catch (RuntimeException e) {
			throw new Exception("findAllEnfermedadsufridas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEnfermedadsufrida(Enfermedadsufrida enfermedadsufrida) throws Exception {
		try {
			getEnfermedadSufridaDao().persistEnfermedadsufrida(enfermedadsufrida);
		} catch (RuntimeException e) {
			throw new Exception("persistEnfermedadsufrida failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEnfermedadsufrida(Enfermedadsufrida enfermedadsufrida) throws Exception {
		try {
			getEnfermedadSufridaDao().removeEnfermedadsufrida(enfermedadsufrida);
		} catch (RuntimeException e) {
			throw new Exception("removeEnfermedadsufrida failed: " + e.getMessage());
		}
	}
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

	//******************************************************************
	// Acudiente
	//******************************************************************
	//******************************************************************
	// Fin Acudiente
	//******************************************************************	
	
}
