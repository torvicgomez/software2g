package com.software2g.historia_clinica.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.historia_clinica.dao.IAcudienteDao;
import com.software2g.historia_clinica.dao.IArchivoServicioDao;
import com.software2g.historia_clinica.dao.IClaseDiagnosticoDao;
import com.software2g.historia_clinica.dao.ICodigoEnfermedadDao;
import com.software2g.historia_clinica.dao.IDiagnosticoDao;
import com.software2g.historia_clinica.dao.IEspecificacionParteCuerpoDao;
import com.software2g.historia_clinica.dao.IExamenEspecialidadDao;
import com.software2g.historia_clinica.dao.IExamenOptometriaDao;
import com.software2g.historia_clinica.dao.IFinalidadDao;
import com.software2g.historia_clinica.dao.IFormulacionDao;
import com.software2g.historia_clinica.dao.IGafaDao;
import com.software2g.historia_clinica.dao.IMedicamentoDao;
import com.software2g.historia_clinica.dao.IMotivoDao;
import com.software2g.historia_clinica.dao.IOdontogramaDao;
import com.software2g.historia_clinica.dao.IOpcionRespuestaDao;
import com.software2g.historia_clinica.dao.IPacienteDao;
import com.software2g.historia_clinica.dao.IParentescoDao;
import com.software2g.historia_clinica.dao.IParteCuerpoDao;
import com.software2g.historia_clinica.dao.IPosicionDao;
import com.software2g.historia_clinica.dao.IPreguntaDao;
import com.software2g.historia_clinica.dao.IRegistroAVSCDao;
import com.software2g.historia_clinica.dao.IRegistroCoverTestDao;
import com.software2g.historia_clinica.dao.IRegistroExamenSimpleDao;
import com.software2g.historia_clinica.dao.IRegistroOdontogramaDao;
import com.software2g.historia_clinica.dao.IRegistroRxUsoDao;
import com.software2g.historia_clinica.dao.IRespuestaDao;
import com.software2g.historia_clinica.dao.ISeccionOdonDao;
import com.software2g.historia_clinica.dao.ISegmentoAnamnesisDao;
import com.software2g.historia_clinica.dao.ISeguridadSocialDao;
import com.software2g.historia_clinica.dao.IServicioDao;
import com.software2g.historia_clinica.dao.ITipoDiagnosticoDao;
import com.software2g.historia_clinica.dao.ITipoEspecialidadDao;
import com.software2g.historia_clinica.dao.ITipoExamenOptDao;
import com.software2g.historia_clinica.dao.ITipoFormulacionDao;
import com.software2g.historia_clinica.dao.ITipoPreguntaDao;
import com.software2g.historia_clinica.dao.ITipoSegmentoDao;
import com.software2g.historia_clinica.dao.ITipoServicioDao;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.util.ValidaString;
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

public class GestionFacadeHistoriaClinica implements IGestionFacadeHistoriaClinica {
	
	@Autowired
	IAcudienteDao acudienteDao; 
	@Autowired
	IArchivoServicioDao archivoServicioDao;
	@Autowired
	IClaseDiagnosticoDao claseDiagnosticoDao;
	@Autowired
	ICodigoEnfermedadDao codigoEnfermedadDao;
	@Autowired
	IDiagnosticoDao diagnosticoDao; 
	@Autowired
	IEspecificacionParteCuerpoDao especificacionParteCuerpoDao;
	@Autowired
	IExamenOptometriaDao examenOptometriaDao;
	@Autowired
	IFinalidadDao finalidadDao;
	@Autowired
	IFormulacionDao formulacionDao; 
	@Autowired
	IGafaDao gafaDao;
	@Autowired
	IMedicamentoDao medicamentoDao;
	@Autowired
	IMotivoDao motivoDao;
	@Autowired
	IOdontogramaDao odontogramaDao;
	@Autowired
	IOpcionRespuestaDao opcionRespuestaDao;
	@Autowired
	IPacienteDao pacienteDao;
	@Autowired
	IParentescoDao parentescoDao;
	@Autowired
	IParteCuerpoDao parteCuerpoDao ;
	@Autowired
	IPosicionDao posicionDao;
	@Autowired
	IPreguntaDao preguntaDao;
	@Autowired
	IRegistroAVSCDao registroAVSCDao;
	@Autowired
	IRegistroCoverTestDao registroCoverTestDao;
	@Autowired
	IRegistroExamenSimpleDao registroExamenSimpleDao;
	@Autowired
	IRegistroOdontogramaDao registroOdontogramaDao;
	@Autowired
	IRegistroRxUsoDao registroRxUsoDao;
	@Autowired
	IRespuestaDao respuestaDao;
	@Autowired
	ISeccionOdonDao seccionOdonDao;
	@Autowired
	ISegmentoAnamnesisDao segmentoAnamnesisDao;
	@Autowired
	ISeguridadSocialDao seguridadSocialDao;
	@Autowired
	IServicioDao servicioDao;
	@Autowired
	ITipoDiagnosticoDao tipoDiagnosticoDao;
	@Autowired
	ITipoEspecialidadDao tipoEspecialidadDao;
	@Autowired
	ITipoExamenOptDao tipoExamenOptDao;
	@Autowired
	ITipoFormulacionDao tipoFormulacionDao;
	@Autowired
	ITipoPreguntaDao tipoPreguntaDao;
	@Autowired
	ITipoSegmentoDao tipoSegmentoDao;
	@Autowired
	ITipoServicioDao tipoServicioDao;
	@Autowired
	IExamenEspecialidadDao examenEspecialidadDao;
	
	public IAcudienteDao getAcudienteDao() {return acudienteDao;}
	public void setAcudienteDao(IAcudienteDao acudienteDao) {this.acudienteDao = acudienteDao;}
	public IArchivoServicioDao getArchivoServicioDao() {return archivoServicioDao;}
	public void setArchivoServicioDao(IArchivoServicioDao archivoServicioDao) {this.archivoServicioDao = archivoServicioDao;}
	public IClaseDiagnosticoDao getClaseDiagnosticoDao() {return claseDiagnosticoDao;}
	public void setClaseDiagnosticoDao(IClaseDiagnosticoDao claseDiagnosticoDao) {this.claseDiagnosticoDao = claseDiagnosticoDao;}
	public ICodigoEnfermedadDao getCodigoEnfermedadDao() {return codigoEnfermedadDao;}
	public void setCodigoEnfermedadDao(ICodigoEnfermedadDao codigoEnfermedadDao) {this.codigoEnfermedadDao = codigoEnfermedadDao;}
	public IDiagnosticoDao getDiagnosticoDao() {return diagnosticoDao;}
	public void setDiagnosticoDao(IDiagnosticoDao diagnosticoDao) {this.diagnosticoDao = diagnosticoDao;}
	public IEspecificacionParteCuerpoDao getEspecificacionParteCuerpoDao() {return especificacionParteCuerpoDao;}
	public void setEspecificacionParteCuerpoDao(IEspecificacionParteCuerpoDao especificacionParteCuerpoDao) {this.especificacionParteCuerpoDao = especificacionParteCuerpoDao;}
	public IExamenOptometriaDao getExamenOptometriaDao() {return examenOptometriaDao;}
	public void setExamenOptometriaDao(IExamenOptometriaDao examenOptometriaDao) {this.examenOptometriaDao = examenOptometriaDao;}
	public IFinalidadDao getFinalidadDao() {return finalidadDao;}
	public void setFinalidadDao(IFinalidadDao finalidadDao) {this.finalidadDao = finalidadDao;}
	public IFormulacionDao getFormulacionDao() {return formulacionDao;}
	public void setFormulacionDao(IFormulacionDao formulacionDao) {this.formulacionDao = formulacionDao;}
	public IGafaDao getGafaDao() {return gafaDao;}
	public void setGafaDao(IGafaDao gafaDao) {this.gafaDao = gafaDao;}
	public IMedicamentoDao getMedicamentoDao() {return medicamentoDao;}
	public void setMedicamentoDao(IMedicamentoDao medicamentoDao) {this.medicamentoDao = medicamentoDao;}
	public IMotivoDao getMotivoDao() {return motivoDao;}
	public void setMotivoDao(IMotivoDao motivoDao) {this.motivoDao = motivoDao;}
	public IOdontogramaDao getOdontogramaDao() {return odontogramaDao;}
	public void setOdontogramaDao(IOdontogramaDao odontogramaDao) {this.odontogramaDao = odontogramaDao;}
	public IOpcionRespuestaDao getOpcionRespuestaDao() {return opcionRespuestaDao;}
	public void setOpcionRespuestaDao(IOpcionRespuestaDao opcionRespuestaDao) {this.opcionRespuestaDao = opcionRespuestaDao;}
	public IPacienteDao getPacienteDao() {return pacienteDao;}
	public void setPacienteDao(IPacienteDao pacienteDao) {this.pacienteDao = pacienteDao;}
	public IParentescoDao getParentescoDao() {return parentescoDao;}
	public void setParentescoDao(IParentescoDao parentescoDao) {this.parentescoDao = parentescoDao;}
	public IParteCuerpoDao getParteCuerpoDao() {return parteCuerpoDao;}
	public void setParteCuerpoDao(IParteCuerpoDao parteCuerpoDao) {this.parteCuerpoDao = parteCuerpoDao;}
	public IPosicionDao getPosicionDao() {return posicionDao;}
	public void setPosicionDao(IPosicionDao posicionDao) {this.posicionDao = posicionDao;}
	public IPreguntaDao getPreguntaDao() {return preguntaDao;}
	public void setPreguntaDao(IPreguntaDao preguntaDao) {this.preguntaDao = preguntaDao;}
	public IRegistroAVSCDao getRegistroAVSCDao() {return registroAVSCDao;}
	public void setRegistroAVSCDao(IRegistroAVSCDao registroAVSCDao) {this.registroAVSCDao = registroAVSCDao;}
	public IRegistroCoverTestDao getRegistroCoverTestDao() {return registroCoverTestDao;}
	public void setRegistroCoverTestDao(IRegistroCoverTestDao registroCoverTestDao) {this.registroCoverTestDao = registroCoverTestDao;}
	public IRegistroExamenSimpleDao getRegistroExamenSimpleDao() {return registroExamenSimpleDao;}
	public void setRegistroExamenSimpleDao(IRegistroExamenSimpleDao registroExamenSimpleDao) {this.registroExamenSimpleDao = registroExamenSimpleDao;}
	public IRegistroOdontogramaDao getRegistroOdontogramaDao() {return registroOdontogramaDao;}
	public void setRegistroOdontogramaDao(IRegistroOdontogramaDao registroOdontogramaDao) {this.registroOdontogramaDao = registroOdontogramaDao;}
	public IRegistroRxUsoDao getRegistroRxUsoDao() {return registroRxUsoDao;}
	public void setRegistroRxUsoDao(IRegistroRxUsoDao registroRxUsoDao) {this.registroRxUsoDao = registroRxUsoDao;}
	public IRespuestaDao getRespuestaDao() {return respuestaDao;}
	public void setRespuestaDao(IRespuestaDao respuestaDao) {this.respuestaDao = respuestaDao;}
	public ISeccionOdonDao getSeccionOdonDao() {return seccionOdonDao;}
	public void setSeccionOdonDao(ISeccionOdonDao seccionOdonDao) {this.seccionOdonDao = seccionOdonDao;}
	public ISegmentoAnamnesisDao getSegmentoAnamnesisDao() {return segmentoAnamnesisDao;}
	public void setSegmentoAnamnesisDao(ISegmentoAnamnesisDao segmentoAnamnesisDao) {this.segmentoAnamnesisDao = segmentoAnamnesisDao;}
	public ISeguridadSocialDao getSeguridadSocialDao() {return seguridadSocialDao;}
	public void setSeguridadSocialDao(ISeguridadSocialDao seguridadSocialDao) {this.seguridadSocialDao = seguridadSocialDao;}
	public IServicioDao getServicioDao() {return servicioDao;}
	public void setServicioDao(IServicioDao servicioDao) {this.servicioDao = servicioDao;}
	public ITipoDiagnosticoDao getTipoDiagnosticoDao() {return tipoDiagnosticoDao;}
	public void setTipoDiagnosticoDao(ITipoDiagnosticoDao tipoDiagnosticoDao) {this.tipoDiagnosticoDao = tipoDiagnosticoDao;}
	public ITipoEspecialidadDao getTipoEspecialidadDao() {return tipoEspecialidadDao;}
	public void setTipoEspecialidadDao(ITipoEspecialidadDao tipoEspecialidadDao) {this.tipoEspecialidadDao = tipoEspecialidadDao;}
	public ITipoExamenOptDao getTipoExamenOptDao() {return tipoExamenOptDao;}
	public void setTipoExamenOptDao(ITipoExamenOptDao tipoExamenOptDao) {this.tipoExamenOptDao = tipoExamenOptDao;}
	public ITipoFormulacionDao getTipoFormulacionDao() {return tipoFormulacionDao;}
	public void setTipoFormulacionDao(ITipoFormulacionDao tipoFormulacionDao) {this.tipoFormulacionDao = tipoFormulacionDao;}
	public ITipoPreguntaDao getTipoPreguntaDao() {return tipoPreguntaDao;}
	public void setTipoPreguntaDao(ITipoPreguntaDao tipoPreguntaDao) {this.tipoPreguntaDao = tipoPreguntaDao;}
	public ITipoSegmentoDao getTipoSegmentoDao() {return tipoSegmentoDao;}
	public void setTipoSegmentoDao(ITipoSegmentoDao tipoSegmentoDao) {this.tipoSegmentoDao = tipoSegmentoDao;}
	public ITipoServicioDao getTipoServicioDao() {return tipoServicioDao;}
	public void setTipoServicioDao(ITipoServicioDao tipoServicioDao) {this.tipoServicioDao = tipoServicioDao;}
	public IExamenEspecialidadDao getExamenEspecialidadDao() {return examenEspecialidadDao;}
	public void setExamenEspecialidadDao(IExamenEspecialidadDao examenEspecialidadDao) {this.examenEspecialidadDao = examenEspecialidadDao;}
	
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
	// Archivo Servicio
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Archivoservicio findArchivoservicioById(long id) throws Exception {
		try {
			return getArchivoServicioDao().findArchivoservicioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findArchivoservicioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Archivoservicio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Archivoservicio> findAllArchivoservicios() throws Exception {
		try {
			return getArchivoServicioDao().findAllArchivoservicios();
		} catch (RuntimeException e) {
			throw new Exception("findAllArchivoservicios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistArchivoservicio(Archivoservicio archivoservicio) throws Exception {
		try {
			getArchivoServicioDao().persistArchivoservicio(archivoservicio);
		} catch (RuntimeException e) {
			throw new Exception("persistArchivoservicio failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeArchivoservicio(Archivoservicio archivoservicio) throws Exception {
		try {
			getArchivoServicioDao().removeArchivoservicio(archivoservicio);
		} catch (RuntimeException e) {
			throw new Exception("removeArchivoservicio failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Archivo Servicio
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

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Clasediagnostico findClasediagnosticosXAbreviatura(String abrevitura) throws Exception {
		try {
			return getClaseDiagnosticoDao().findClasediagnosticosXAbreviatura(abrevitura);
		} catch (RuntimeException e) {
			throw new Exception("findClasediagnosticosXAbreviatura failed: " + e.getMessage());
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
			return getCodigoEnfermedadDao().findCodigoenfermedadeById(id);
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
			return getCodigoEnfermedadDao().findAllCodigoenfermedades();
		} catch (RuntimeException e) {
			throw new Exception("findAllCodigoenfermedades failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistCodigoenfermedade(Codigoenfermedade codigoenfermedade) throws Exception {
		try {
			getCodigoEnfermedadDao().persistCodigoenfermedade(codigoenfermedade);
		} catch (RuntimeException e) {
			throw new Exception("persistCodigoenfermedade failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeCodigoenfermedade(Codigoenfermedade codigoenfermedade) throws Exception {
		try {
			getCodigoEnfermedadDao().removeCodigoenfermedade(codigoenfermedade);
		} catch (RuntimeException e) {
			throw new Exception("removeCodigoenfermedade failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Codigo Enfermedades
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
	// Especificacion Parte Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificacionpartecuerpo findEspecificacionpartecuerpoById(long id) throws Exception {
		try {
			return getEspecificacionParteCuerpoDao().findEspecificacionpartecuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificacionpartecuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Especificacionpartecuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Especificacionpartecuerpo> findAllEspecificacionpartecuerpos() throws Exception {
		try {
			return getEspecificacionParteCuerpoDao().findAllEspecificacionpartecuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllEspecificacionpartecuerpos failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificacionpartecuerpo findEspecificacionpartecuerposXEtiqueta(String etiqueta) throws Exception {
		try {
			return getEspecificacionParteCuerpoDao().findEspecificacionpartecuerposXEtiqueta(etiqueta);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificacionpartecuerposXEtiqueta failed with the etiqueta " + etiqueta + ": " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception {
		try {
			getEspecificacionParteCuerpoDao().persistEspecificacionpartecuerpo(especificacionpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistEspecificacionpartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionpartecuerpo(Especificacionpartecuerpo especificacionpartecuerpo) throws Exception {
		try {
			getEspecificacionParteCuerpoDao().removeEspecificacionpartecuerpo(especificacionpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removeEspecificacionpartecuerpo failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Especificacion Parte Cuerpo
	//******************************************************************	
	//******************************************************************
	// Examen Optometria
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Examenoptometria findExamenoptometriaById(long id) throws Exception {
		try {
			return getExamenOptometriaDao().findExamenoptometriaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findExamenoptometriaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Examenoptometria</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examenoptometria> findAllExamenoptometrias() throws Exception {
		try {
			return getExamenOptometriaDao().findAllExamenoptometrias();
		} catch (RuntimeException e) {
			throw new Exception("findAllExamenoptometrias failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistExamenoptometria(Examenoptometria examenoptometria) throws Exception {
		try {
			getExamenOptometriaDao().persistExamenoptometria(examenoptometria);
		} catch (RuntimeException e) {
			throw new Exception("persistExamenoptometria failed: " + e.getMessage());
		}
	}
	
	@Transactional
	public long persistExamenoptometriaId(Examenoptometria examenoptometria) throws Exception {
		try {
			return getExamenOptometriaDao().persistExamenoptometriaId(examenoptometria);
		} catch (RuntimeException e) {
			//throw new Exception("persistExamenoptometria failed: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	@Transactional
	public void removeExamenoptometria(Examenoptometria examenoptometria) throws Exception {
		try {
			getExamenOptometriaDao().removeExamenoptometria(examenoptometria);
		} catch (RuntimeException e) {
			throw new Exception("removeExamenoptometria failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Examen Optometria
	//******************************************************************	
	//******************************************************************
	// Finalidad
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Finalidad findFinalidadById(long id) throws Exception {
		try {
			return getFinalidadDao().findFinalidadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFinalidadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Finalidad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Finalidad> findAllFinalidads() throws Exception {
		try {
			return getFinalidadDao().findAllFinalidads();
		} catch (RuntimeException e) {
			throw new Exception("findAllFinalidads failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFinalidad(Finalidad finalidad) throws Exception {
		try {
			getFinalidadDao().persistFinalidad(finalidad);
		} catch (RuntimeException e) {
			throw new Exception("persistFinalidad failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFinalidad(Finalidad finalidad) throws Exception {
		try {
			getFinalidadDao().removeFinalidad(finalidad);
		} catch (RuntimeException e) {
			throw new Exception("removeFinalidad failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Formulacion findFormulacionById(long id) throws Exception {
		try {
			return getFormulacionDao().findFormulacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFormulacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Formulacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Formulacion> findAllFormulacions() throws Exception {
		try {
			return getFormulacionDao().findAllFormulacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllFormulacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFormulacion(Formulacion formulacion) throws Exception {
		try {
			getFormulacionDao().persistFormulacion(formulacion);
		} catch (RuntimeException e) {
			throw new Exception("persistFormulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFormulacion(Formulacion formulacion) throws Exception {
		try {
			getFormulacionDao().removeFormulacion(formulacion);
		} catch (RuntimeException e) {
			throw new Exception("removeFormulacion failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Formulacion
	//******************************************************************	
	//******************************************************************
	// Gafas
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Gafa findGafaById(long id) throws Exception {
		try {
			return getGafaDao().findGafaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findGafaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Gafa</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Gafa> findAllGafas() throws Exception {
		try {
			return getGafaDao().findAllGafas();
		} catch (RuntimeException e) {
			throw new Exception("findAllGafas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistGafa(Gafa gafa) throws Exception {
		try {
			getGafaDao().persistGafa(gafa);
		} catch (RuntimeException e) {
			throw new Exception("persistGafa failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeGafa(Gafa gafa) throws Exception {
		try {
			getGafaDao().removeGafa(gafa);
		} catch (RuntimeException e) {
			throw new Exception("removeGafa failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Gafas
	//******************************************************************	
	//******************************************************************
	// Medicamento
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Medicamento findMedicamentoById(long id) throws Exception {
		try {
			return getMedicamentoDao().findMedicamentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findMedicamentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Medicamento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Medicamento> findAllMedicamentos() throws Exception {
		try {
			return getMedicamentoDao().findAllMedicamentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllMedicamentos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMedicamento(Medicamento medicamento) throws Exception {
		try {
			getMedicamentoDao().persistMedicamento(medicamento);
		} catch (RuntimeException e) {
			throw new Exception("persistMedicamento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMedicamento(Medicamento medicamento) throws Exception {
		try {
			getMedicamentoDao().removeMedicamento(medicamento);
		} catch (RuntimeException e) {
			throw new Exception("removeMedicamento failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Medicamento
	//******************************************************************	
	//******************************************************************
	// Motivo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Motivo findMotivoById(long id) throws Exception {
		try {
			return getMotivoDao().findMotivoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findMotivoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Motivo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Motivo> findAllMotivos() throws Exception {
		try {
			return getMotivoDao().findAllMotivos();
		} catch (RuntimeException e) {
			throw new Exception("findAllMotivos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistMotivo(Motivo motivo) throws Exception {
		try {
			getMotivoDao().persistMotivo(motivo);
		} catch (RuntimeException e) {
			throw new Exception("persistMotivo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeMotivo(Motivo motivo) throws Exception {
		try {
			getMotivoDao().removeMotivo(motivo);
		} catch (RuntimeException e) {
			throw new Exception("removeMotivo failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Motivo
	//******************************************************************	
	//******************************************************************
	// Odontograma
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Odontograma findOdontogramaById(long id) throws Exception {
		try {
			return getOdontogramaDao().findOdontogramaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findOdontogramaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Odontograma</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Odontograma> findAllOdontogramas() throws Exception {
		try {
			return getOdontogramaDao().findAllOdontogramas();
		} catch (RuntimeException e) {
			throw new Exception("findAllOdontogramas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistOdontograma(Odontograma odontograma) throws Exception {
		try {
			getOdontogramaDao().persistOdontograma(odontograma);
		} catch (RuntimeException e) {
			throw new Exception("persistOdontograma failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOdontograma(Odontograma odontograma) throws Exception {
		try {
			getOdontogramaDao().removeOdontograma(odontograma);
		} catch (RuntimeException e) {
			throw new Exception("removeOdontograma failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Odontograma
	//******************************************************************	
	//******************************************************************
	// Opcion Respuesta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Opcionrespuesta findOpcionrespuestaById(long id) throws Exception {
		try {
			return getOpcionRespuestaDao().findOpcionrespuestaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findOpcionrespuestaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Opcionrespuesta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Opcionrespuesta> findAllOpcionrespuestas() throws Exception {
		try {
			return getOpcionRespuestaDao().findAllOpcionrespuestas();
		} catch (RuntimeException e) {
			throw new Exception("findAllOpcionrespuestas failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Opcionrespuesta> findAllOpcionrespuestas(long pregId) throws Exception {
		try {
			System.out.println("Entra esta Parte!!!");
			System.out.println("preg_id:["+pregId+"]");
			return getOpcionRespuestaDao().findAllOpcionrespuestas(pregId);
		} catch (RuntimeException e) {
			//throw new Exception("findAllOpcionrespuestas failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistOpcionrespuesta(Opcionrespuesta opcionrespuesta) throws Exception {
		try {
			getOpcionRespuestaDao().persistOpcionrespuesta(opcionrespuesta);
		} catch (RuntimeException e) {
			throw new Exception("persistOpcionrespuesta failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeOpcionrespuesta(Opcionrespuesta opcionrespuesta) throws Exception {
		try {
			getOpcionRespuestaDao().removeOpcionrespuesta(opcionrespuesta);
		} catch (RuntimeException e) {
			throw new Exception("removeOpcionrespuesta failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Opcion Respuesta
	//******************************************************************	
	//******************************************************************
	// Paciente
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Paciente findPacienteById(long id) throws Exception {
		try {
			return getPacienteDao().findPacienteById(id);
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
			return getPacienteDao().findAllPacientes();
		} catch (RuntimeException e) {
			throw new Exception("findAllPacientes failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistPaciente(Paciente paciente) throws Exception {
		try {
			getPacienteDao().persistPaciente(paciente);
		} catch (RuntimeException e) {
			throw new Exception("persistPaciente failed: " + e.getMessage());
		}
	}
	
	@Transactional
	public long persistPacienteId(Paciente paciente) throws Exception {
		try {
			return getPacienteDao().persistPacienteId(paciente);
		} catch (RuntimeException e) {
			throw new Exception("persistPacienteId failed: " + e.getMessage());
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removePaciente(Paciente paciente) throws Exception {
		try {
			getPacienteDao().removePaciente(paciente);
		} catch (RuntimeException e) {
			throw new Exception("removePaciente failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Parentesco findParentescoById(long id) throws Exception {
		try {
			return getParentescoDao().findParentescoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findParentescoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Parentesco</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Parentesco> findAllParentescos() throws Exception {
		try {
			return getParentescoDao().findAllParentescos();
		} catch (RuntimeException e) {
			throw new Exception("findAllParentescos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistParentesco(Parentesco parentesco) throws Exception {
		try {
			getParentescoDao().persistParentesco(parentesco);
		} catch (RuntimeException e) {
			throw new Exception("persistParentesco failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeParentesco(Parentesco parentesco) throws Exception {
		try {
			getParentescoDao().removeParentesco(parentesco);
		} catch (RuntimeException e) {
			throw new Exception("removeParentesco failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Parentesco
	//******************************************************************	
	//******************************************************************
	// Parte Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Partecuerpo findPartecuerpoById(long id) throws Exception {
		try {
			return getParteCuerpoDao().findPartecuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPartecuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Partecuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Partecuerpo> findAllPartecuerpos() throws Exception {
		try {
			return getParteCuerpoDao().findAllPartecuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllPartecuerpos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartecuerpo(Partecuerpo partecuerpo) throws Exception {
		try {
			getParteCuerpoDao().persistPartecuerpo(partecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistPartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartecuerpo(Partecuerpo partecuerpo) throws Exception {
		try {
			getParteCuerpoDao().removePartecuerpo(partecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removePartecuerpo failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Parte Cuerpo
	//******************************************************************	
	//******************************************************************
	// Posicion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Posicion findPosicionById(long id) throws Exception {
		try {
			return getPosicionDao().findPosicionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPosicionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Posicion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Posicion> findAllPosicions() throws Exception {
		try {
			return getPosicionDao().findAllPosicions();
		} catch (RuntimeException e) {
			throw new Exception("findAllPosicions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPosicion(Posicion posicion) throws Exception {
		try {
			getPosicionDao().persistPosicion(posicion);
		} catch (RuntimeException e) {
			throw new Exception("persistPosicion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePosicion(Posicion posicion) throws Exception {
		try {
			getPosicionDao().removePosicion(posicion);
		} catch (RuntimeException e) {
			throw new Exception("removePosicion failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Posicion
	//******************************************************************	
	//******************************************************************
	// Pregunta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Pregunta findPreguntaById(long id) throws Exception {
		try {
			return getPreguntaDao().findPreguntaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPreguntaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Pregunta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pregunta> findAllPreguntas() throws Exception {
		try {
			return getPreguntaDao().findAllPreguntas();
		} catch (RuntimeException e) {
			throw new Exception("findAllPreguntas failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Pregunta> findAllPreguntasXSegmentoAna(long seanId) throws Exception {
		try {
			return getPreguntaDao().findAllPreguntasXSegmentoAna(seanId);
		} catch (RuntimeException e) {
			throw new Exception("findAllPreguntas failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistPregunta(Pregunta pregunta) throws Exception {
		try {
			getPreguntaDao().persistPregunta(pregunta);
		} catch (RuntimeException e) {
			throw new Exception("persistPregunta failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePregunta(Pregunta pregunta) throws Exception {
		try {
			getPreguntaDao().removePregunta(pregunta);
		} catch (RuntimeException e) {
			throw new Exception("removePregunta failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Pregunta
	//******************************************************************	
	//******************************************************************
	// Registro AVSC
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroavsc findRegistroavscById(long id) throws Exception {
		try {
			return getRegistroAVSCDao().findRegistroavscById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroavscById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroavsc</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroavsc> findAllRegistroavscs() throws Exception {
		try {
			return getRegistroAVSCDao().findAllRegistroavscs();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroavscs failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroavsc(Registroavsc registroavsc) throws Exception {
		try {
			getRegistroAVSCDao().persistRegistroavsc(registroavsc);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroavsc failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroavsc(Registroavsc registroavsc) throws Exception {
		try {
			getRegistroAVSCDao().removeRegistroavsc(registroavsc);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroavsc failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Registro AVSC
	//******************************************************************	
	//******************************************************************
	// Registro Cover Test
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registrocovertest findRegistrocovertestById(long id) throws Exception {
		try {
			return getRegistroCoverTestDao().findRegistrocovertestById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistrocovertestById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registrocovertest</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registrocovertest> findAllRegistrocovertests() throws Exception {
		try {
			return getRegistroCoverTestDao().findAllRegistrocovertests();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistrocovertests failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistrocovertest(Registrocovertest registrocovertest) throws Exception {
		try {
			getRegistroCoverTestDao().persistRegistrocovertest(registrocovertest);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistrocovertest failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrocovertest(Registrocovertest registrocovertest) throws Exception {
		try {
			getRegistroCoverTestDao().removeRegistrocovertest(registrocovertest);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistrocovertest failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Registro Cover Test
	//******************************************************************	
	//******************************************************************
	// Registro Examen Simple
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroexamensimple findRegistroexamensimpleById(long id) throws Exception {
		try {
			return getRegistroExamenSimpleDao().findRegistroexamensimpleById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroexamensimpleById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroexamensimple</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroexamensimple> findAllRegistroexamensimples() throws Exception {
		try {
			return getRegistroExamenSimpleDao().findAllRegistroexamensimples();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroexamensimples failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroexamensimple(Registroexamensimple registroexamensimple) throws Exception {
		try {
			getRegistroExamenSimpleDao().persistRegistroexamensimple(registroexamensimple);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroexamensimple failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroexamensimple(Registroexamensimple registroexamensimple) throws Exception {
		try {
			getRegistroExamenSimpleDao().removeRegistroexamensimple(registroexamensimple);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroexamensimple failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Registro Examen Simple
	//******************************************************************	
	//******************************************************************
	// Registro Odontograma
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroodontograma findRegistroodontogramaById(long id) throws Exception {
		try {
			return getRegistroOdontogramaDao().findRegistroodontogramaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroodontogramaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroodontograma</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroodontograma> findAllRegistroodontogramas() throws Exception {
		try {
			return getRegistroOdontogramaDao().findAllRegistroodontogramas();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroodontogramas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroodontograma(Registroodontograma registroodontograma) throws Exception {
		try {
			getRegistroOdontogramaDao().persistRegistroodontograma(registroodontograma);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroodontograma failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroodontograma(Registroodontograma registroodontograma) throws Exception {
		try {
			getRegistroOdontogramaDao().removeRegistroodontograma(registroodontograma);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroodontograma failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Registro Odontograma
	//******************************************************************	
	//******************************************************************
	// Registro Rx Uso
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registrorxuso findRegistrorxusoById(long id) throws Exception {
		try {
			return getRegistroRxUsoDao().findRegistrorxusoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistrorxusoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registrorxuso</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registrorxuso> findAllRegistrorxusos() throws Exception {
		try {
			return getRegistroRxUsoDao().findAllRegistrorxusos();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistrorxusos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistrorxuso(Registrorxuso registrorxuso) throws Exception {
		try {
			getRegistroRxUsoDao().persistRegistrorxuso(registrorxuso);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistrorxuso failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistrorxuso(Registrorxuso registrorxuso) throws Exception {
		try {
			getRegistroRxUsoDao().removeRegistrorxuso(registrorxuso);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistrorxuso failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Registro Rx Uso
	//******************************************************************	
	//******************************************************************
	// Respuesta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Respuesta findRespuestaById(long id) throws Exception {
		try {
			return getRespuestaDao().findRespuestaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRespuestaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Respuesta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Respuesta> findAllRespuestas() throws Exception {
		try {
			return getRespuestaDao().findAllRespuestas();
		} catch (RuntimeException e) {
			throw new Exception("findAllRespuestas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRespuesta(Respuesta respuesta) throws Exception {
		try {
			getRespuestaDao().persistRespuesta(respuesta);
		} catch (RuntimeException e) {
			throw new Exception("persistRespuesta failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRespuesta(Respuesta respuesta) throws Exception {
		try {
			getRespuestaDao().removeRespuesta(respuesta);
		} catch (RuntimeException e) {
			throw new Exception("removeRespuesta failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Respuesta
	//******************************************************************	
	//******************************************************************
	// Seccion Odon
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Seccionodon findSeccionodonById(long id) throws Exception {
		try {
			return getSeccionOdonDao().findSeccionodonById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSeccionodonById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Seccionodon</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Seccionodon> findAllSeccionodons() throws Exception {
		try {
			return getSeccionOdonDao().findAllSeccionodons();
		} catch (RuntimeException e) {
			throw new Exception("findAllSeccionodons failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeccionodon(Seccionodon seccionodon) throws Exception {
		try {
			getSeccionOdonDao().persistSeccionodon(seccionodon);
		} catch (RuntimeException e) {
			throw new Exception("persistSeccionodon failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeccionodon(Seccionodon seccionodon) throws Exception {
		try {
			getSeccionOdonDao().removeSeccionodon(seccionodon);
		} catch (RuntimeException e) {
			throw new Exception("removeSeccionodon failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Seccion Odon
	//******************************************************************	
	//******************************************************************
	// Segmento Anamnesis
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Segmentoanamnesi findSegmentoanamnesiById(long id) throws Exception {
		try {
			return getSegmentoAnamnesisDao().findSegmentoanamnesiById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSegmentoanamnesiById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Segmentoanamnesi</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Segmentoanamnesi> findAllSegmentoanamnesis() throws Exception {
		try {
			return getSegmentoAnamnesisDao().findAllSegmentoanamnesis();
		} catch (RuntimeException e) {
			throw new Exception("findAllSegmentoanamnesis failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Segmentoanamnesi> findAllSegmentoanamnesis(long tiesId) throws Exception {
		try {
			return getSegmentoAnamnesisDao().findAllSegmentoanamnesis(tiesId);
		} catch (RuntimeException e) {
			throw new Exception("findAllSegmentoanamnesis failed: " + e.getMessage());
		}
	}
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi) throws Exception {
		try {
			getSegmentoAnamnesisDao().persistSegmentoanamnesi(segmentoanamnesi);
		} catch (RuntimeException e) {
			throw new Exception("persistSegmentoanamnesi failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSegmentoanamnesi(Segmentoanamnesi segmentoanamnesi) throws Exception {
		try {
			getSegmentoAnamnesisDao().removeSegmentoanamnesi(segmentoanamnesi);
		} catch (RuntimeException e) {
			throw new Exception("removeSegmentoanamnesi failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Segmento Anamnesis
	//******************************************************************	
	//******************************************************************
	// Seguridad Social
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Seguridadsocial findSeguridadsocialById(long id) throws Exception {
		try {
			return getSeguridadSocialDao().findSeguridadsocialById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSeguridadsocialById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Seguridadsocial</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Seguridadsocial> findAllSeguridadsocials() throws Exception {
		try {
			return getSeguridadSocialDao().findAllSeguridadsocials();
		} catch (RuntimeException e) {
			throw new Exception("findAllSeguridadsocials failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception {
		try {
			getSeguridadSocialDao().persistSeguridadsocial(seguridadsocial);
		} catch (RuntimeException e) {
			throw new Exception("persistSeguridadsocial failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSeguridadsocial(Seguridadsocial seguridadsocial) throws Exception {
		try {
			getSeguridadSocialDao().removeSeguridadsocial(seguridadsocial);
		} catch (RuntimeException e) {
			throw new Exception("removeSeguridadsocial failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Servicio findServicioById(long id) throws Exception {
		try {
			return getServicioDao().findServicioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findServicioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Servicio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Servicio> findAllServicios() throws Exception {
		try {
			return getServicioDao().findAllServicios();
		} catch (RuntimeException e) {
			throw new Exception("findAllServicios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistServicio(Servicio servicio) throws Exception {
		try {
			getServicioDao().persistServicio(servicio);
		} catch (RuntimeException e) {
			throw new Exception("persistServicio failed: " + e.getMessage());
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public long persistServicioId(Servicio servicio) throws Exception {
		try {
			return getServicioDao().persistServicioId(servicio);
		} catch (RuntimeException e) {
			//throw new Exception("persistServicioId failed: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Remove the given persistent instance.
	 */
	public void removeServicio(Servicio servicio) throws Exception {
		try {
			getServicioDao().removeServicio(servicio);
		} catch (RuntimeException e) {
			throw new Exception("removeServicio failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Servicio
	//******************************************************************	
	//******************************************************************
	// Tipo Diagnostico
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodiagnostico findTipodiagnosticoById(long id) throws Exception {
		try {
			return getTipoDiagnosticoDao().findTipodiagnosticoById(id);
		} catch (RuntimeException e) {
			//throw new Exception("findTipodiagnosticoById failed with the id " + id + ": " + e.getMessage());
			return null;
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodiagnostico</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodiagnostico> findAllTipodiagnosticos() throws Exception {
		try {
			return getTipoDiagnosticoDao().findAllTipodiagnosticos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodiagnosticos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception {
		try {
			getTipoDiagnosticoDao().persistTipodiagnostico(tipodiagnostico);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodiagnostico failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodiagnostico(Tipodiagnostico tipodiagnostico) throws Exception {
		try {
			getTipoDiagnosticoDao().removeTipodiagnostico(tipodiagnostico);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodiagnostico failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Diagnostico
	//******************************************************************	
	//******************************************************************
	// Tipo Especialidad
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoespecialidad findTipoespecialidadById(long id) throws Exception {
		try {
			return getTipoEspecialidadDao().findTipoespecialidadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoespecialidadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoespecialidad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoespecialidad> findAllTipoespecialidads() throws Exception {
		try {
			return getTipoEspecialidadDao().findAllTipoespecialidads();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoespecialidads failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception {
		try {
			getTipoEspecialidadDao().persistTipoespecialidad(tipoespecialidad);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoespecialidad failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoespecialidad(Tipoespecialidad tipoespecialidad) throws Exception {
		try {
			getTipoEspecialidadDao().removeTipoespecialidad(tipoespecialidad);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoespecialidad failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Especialidad
	//******************************************************************	
	//******************************************************************
	// Tipo Examen Opt
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoexamenopt findTipoexamenoptById(long id) throws Exception {
		try {
			return getTipoExamenOptDao().findTipoexamenoptById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoexamenoptById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoexamenopt</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoexamenopt> findAllTipoexamenopts() throws Exception {
		try {
			return getTipoExamenOptDao().findAllTipoexamenopts();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoexamenopts failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoexamenopt(Tipoexamenopt tipoexamenopt) throws Exception {
		try {
			getTipoExamenOptDao().persistTipoexamenopt(tipoexamenopt);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoexamenopt failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoexamenopt(Tipoexamenopt tipoexamenopt) throws Exception {
		try {
			getTipoExamenOptDao().removeTipoexamenopt(tipoexamenopt);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoexamenopt failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Examen Opt
	//******************************************************************	
	//******************************************************************
	// Tipo Formulacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoformulacion findTipoformulacionById(long id) throws Exception {
		try {
			return getTipoFormulacionDao().findTipoformulacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoformulacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoformulacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoformulacion> findAllTipoformulacions() throws Exception {
		try {
			return getTipoFormulacionDao().findAllTipoformulacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoformulacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoformulacion(Tipoformulacion tipoformulacion) throws Exception {
		try {
			getTipoFormulacionDao().persistTipoformulacion(tipoformulacion);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoformulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoformulacion(Tipoformulacion tipoformulacion) throws Exception {
		try {
			getTipoFormulacionDao().removeTipoformulacion(tipoformulacion);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoformulacion failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Formulacion
	//******************************************************************	
	//******************************************************************
	// Tipo Pregunta
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipopregunta findTipopreguntaById(long id) throws Exception {
		try {
			return getTipoPreguntaDao().findTipopreguntaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipopreguntaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipopregunta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipopregunta> findAllTipopreguntas() throws Exception {
		try {
			return getTipoPreguntaDao().findAllTipopreguntas();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipopreguntas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistTipopregunta(Tipopregunta tipopregunta) throws Exception {
		try {
			getTipoPreguntaDao().persistTipopregunta(tipopregunta);
		} catch (RuntimeException e) {
			//throw new Exception("persistTipopregunta failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipopregunta(Tipopregunta tipopregunta) throws Exception {
		try {
			getTipoPreguntaDao().removeTipopregunta(tipopregunta);
		} catch (RuntimeException e) {
			throw new Exception("removeTipopregunta failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Pregunta
	//******************************************************************	
	//******************************************************************
	// Tipo Segmento
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tiposegmento findTiposegmentoById(long id) throws Exception {
		try {
			return getTipoSegmentoDao().findTiposegmentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTiposegmentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tiposegmento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tiposegmento> findAllTiposegmentos() throws Exception {
		try {
			return getTipoSegmentoDao().findAllTiposegmentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTiposegmentos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistTiposegmento(Tiposegmento tiposegmento) throws Exception {
		try {
			getTipoSegmentoDao().persistTiposegmento(tiposegmento);
		} catch (RuntimeException e) {
			throw new Exception("persistTiposegmento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposegmento(Tiposegmento tiposegmento) throws Exception {
		try {
			getTipoSegmentoDao().removeTiposegmento(tiposegmento);
		} catch (RuntimeException e) {
			throw new Exception("removeTiposegmento failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Segmento
	//******************************************************************	
	//******************************************************************
	// Tipo Servicio
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tiposervicio findTiposervicioById(long id) throws Exception {
		try {
			return getTipoServicioDao().findTiposervicioById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTiposervicioById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tiposervicio</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tiposervicio> findAllTiposervicios() throws Exception {
		try {
			return getTipoServicioDao().findAllTiposervicios();
		} catch (RuntimeException e) {
			throw new Exception("findAllTiposervicios failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTiposervicio(Tiposervicio tiposervicio) throws Exception {
		try {
			getTipoServicioDao().persistTiposervicio(tiposervicio);
		} catch (RuntimeException e) {
			throw new Exception("persistTiposervicio failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTiposervicio(Tiposervicio tiposervicio) throws Exception {
		try {
			getTipoServicioDao().removeTiposervicio(tiposervicio);
		} catch (RuntimeException e) {
			throw new Exception("removeTiposervicio failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Tipo Servicio
	//******************************************************************	

	//******************************************************************
	// Examen Especialidad
	//******************************************************************	
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Examenespecialidad findExamenespecialidadById(long id) throws Exception {
		try {
			return getExamenEspecialidadDao().findExamenespecialidadById(id);
		} catch (RuntimeException e) {
			throw new Exception("findExamenespecialidadById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Examenespecialidad</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examenespecialidad> findAllExamenespecialidads() throws Exception {
		try {
			return getExamenEspecialidadDao().findAllExamenespecialidads();
		} catch (RuntimeException e) {
			throw new Exception("findAllExamenespecialidads failed: " + e.getMessage());
		}
	}

	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examenespecialidad> findAllExamenespecialidads(long tipoEspecialidad) throws Exception {
		try {
			return getExamenEspecialidadDao().findAllExamenespecialidads(tipoEspecialidad);
		} catch (RuntimeException e) {
			//throw new Exception("findAllExamenespecialidads failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Make the given instance managed and persistent.
	 */
	@Transactional
	public void persistExamenespecialidad(Examenespecialidad examenespecialidad) throws Exception {
		try {
			getExamenEspecialidadDao().persistExamenespecialidad(examenespecialidad);
		} catch (RuntimeException e) {
			throw new Exception("persistExamenespecialidad failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	@Transactional
	public void removeExamenespecialidad(Examenespecialidad examenespecialidad) throws Exception {
		try {
			getExamenEspecialidadDao().removeExamenespecialidad(examenespecialidad);
		} catch (RuntimeException e) {
			throw new Exception("removeExamenespecialidad failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Examen Especialidad
	//******************************************************************	
	
}
