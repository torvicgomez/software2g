package com.software2g.historia_clinica.facade.impl;

import java.util.List;

import javax.persistence.Query;

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
import com.software2g.historia_clinica.dao.IEspecificaExamenDao;
import com.software2g.historia_clinica.dao.IEspecificacionFormulaDao;
import com.software2g.historia_clinica.dao.IEspecificacionParteCuerpoDao;
import com.software2g.historia_clinica.dao.IEstadoCivilDao;
import com.software2g.historia_clinica.dao.IEstadoMedicamentoDao;
import com.software2g.historia_clinica.dao.IExamenDao;
import com.software2g.historia_clinica.dao.IExamenParteCuerpoDao;
import com.software2g.historia_clinica.dao.IFinalidadDao;
import com.software2g.historia_clinica.dao.IFormulacionDao;
import com.software2g.historia_clinica.dao.IFrecuenciaDao;
import com.software2g.historia_clinica.dao.IListaExamenConsultaDao;
import com.software2g.historia_clinica.dao.IMotivoDao;
import com.software2g.historia_clinica.dao.IPacienteDao;
import com.software2g.historia_clinica.dao.IParentescoDao;
import com.software2g.historia_clinica.dao.IPartesCuerpoDao;
import com.software2g.historia_clinica.dao.IPersonaPerteneceDao;
import com.software2g.historia_clinica.dao.IPosicionDao;
import com.software2g.historia_clinica.dao.IRegistroExamenDao;
import com.software2g.historia_clinica.dao.IRegistroFormulacionDao;
import com.software2g.historia_clinica.dao.IRemisionDao;
import com.software2g.historia_clinica.dao.ISeguridadSocialDao;
import com.software2g.historia_clinica.dao.IServicioDao;
import com.software2g.historia_clinica.dao.ISintomaComunDao;
import com.software2g.historia_clinica.dao.ISintomaDao;
import com.software2g.historia_clinica.dao.ITelefonoDao;
import com.software2g.historia_clinica.dao.ITipoDatoDao;
import com.software2g.historia_clinica.dao.ITipoDiagnosticoDao;
import com.software2g.historia_clinica.dao.ITipoDocumentoInstitucionDao;
import com.software2g.historia_clinica.dao.ITipoEspecialidadDao;
import com.software2g.historia_clinica.dao.ITipoServicioDao;
import com.software2g.historia_clinica.dao.ITipoUbicacionDao;
import com.software2g.historia_clinica.dao.ITipoVirtualLinkDao;
import com.software2g.historia_clinica.dao.ITomaDrogaDao;
import com.software2g.historia_clinica.dao.IUbicacionDireccionDao;
import com.software2g.historia_clinica.dao.IUbicacionTelefonoDao;
import com.software2g.historia_clinica.dao.IUbicacionVirtualDao;
import com.software2g.historia_clinica.dao.IUnidadesDao;
import com.software2g.historia_clinica.dao.IVariableExamenDao;
import com.software2g.historia_clinica.dao.IVariableFormulacionDao;
import com.software2g.historia_clinica.dao.IVirtualLinkDao;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.util.ValidaString;
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
import com.software2g.vo.Persona;
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
	@Autowired
	IEspecificacionFormulaDao especificacionFormulaDao;
	@Autowired
	IEspecificacionParteCuerpoDao especificacionParteCuerpoDao;
	@Autowired
	IEspecificaExamenDao especificaExamenDao;
	@Autowired
	IEstadoCivilDao estadoCivilDao;
	@Autowired
	IEstadoMedicamentoDao estadoMedicamentoDao;
	@Autowired
	IExamenParteCuerpoDao examenParteCuerpoDao;
	@Autowired
	IExamenDao examenDao;
	@Autowired
	IFinalidadDao finalidadDao;
	@Autowired
	IFormulacionDao formulacionDao;
	@Autowired
	IFrecuenciaDao frecuenciaDao;
	@Autowired
	IListaExamenConsultaDao listaExamenConsultaDao;
	@Autowired
	IMotivoDao motivoDao;
	@Autowired
	IPacienteDao pacienteDao;
	@Autowired
	IParentescoDao parentescoDao;
	@Autowired
	IPartesCuerpoDao partesCuerpoDao;
	@Autowired
	IPersonaPerteneceDao personaPerteneceDao;
	@Autowired
	IPosicionDao posicionDao;
	@Autowired
	IRegistroExamenDao registroExamenDao;
	@Autowired
	IRegistroFormulacionDao registroFormulacionDao;
	@Autowired
	IRemisionDao remisionDao;
	@Autowired
	ISeguridadSocialDao seguridadSocialDao;
	@Autowired
	IServicioDao servicioDao;
	@Autowired
	ISintomaComunDao sintomaComunDao;
	@Autowired
	ISintomaDao sintomaDao;
	@Autowired
	ITelefonoDao telefonoDao;
	@Autowired
	ITipoDatoDao tipoDatoDao;
	@Autowired
	ITipoDiagnosticoDao tipoDiagnosticoDao;
	@Autowired
	ITipoDocumentoInstitucionDao tipoDocumentoInstitucionDao;
	@Autowired
	ITipoEspecialidadDao tipoEspecialidadDao;
	@Autowired
	ITipoServicioDao tipoServicioDao;
	@Autowired
	ITipoUbicacionDao tipoUbicacionDao;
	@Autowired
	ITipoVirtualLinkDao tipoVirtualLinkDao;
	@Autowired
	ITomaDrogaDao tomaDrogaDao;
	@Autowired
	IUbicacionDireccionDao ubicacionDireccionDao;
	@Autowired
	IUbicacionTelefonoDao ubicacionTelefonoDao;
	@Autowired
	IUbicacionVirtualDao ubicacionVirtualDao; 
	@Autowired
	IUnidadesDao unidadesDao;
	@Autowired
	IVariableExamenDao variableExamenDao;
	@Autowired
	IVariableFormulacionDao variableFormulacionDao;
	@Autowired
	IVirtualLinkDao virtualLinkDao;
	@Autowired
	IPersonaDao personaDao;
	
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
	public IEspecificacionFormulaDao getEspecificacionFormulaDao() {return especificacionFormulaDao;}
	public void setEspecificacionFormulaDao(IEspecificacionFormulaDao especificacionFormulaDao) {this.especificacionFormulaDao = especificacionFormulaDao;}
	public IEspecificacionParteCuerpoDao getEspecificacionParteCuerpoDao() {return especificacionParteCuerpoDao;}
	public void setEspecificacionParteCuerpoDao(IEspecificacionParteCuerpoDao especificacionParteCuerpoDao) {this.especificacionParteCuerpoDao = especificacionParteCuerpoDao;}
	public IEspecificaExamenDao getEspecificaExamenDao() {return especificaExamenDao;}
	public void setEspecificaExamenDao(IEspecificaExamenDao especificaExamenDao) {this.especificaExamenDao = especificaExamenDao;}
	public IEstadoCivilDao getEstadoCivilDao() {return estadoCivilDao;}
	public void setEstadoCivilDao(IEstadoCivilDao estadoCivilDao) {this.estadoCivilDao = estadoCivilDao;}
	public IEstadoMedicamentoDao getEstadoMedicamentoDao() {return estadoMedicamentoDao;}
	public void setEstadoMedicamentoDao(IEstadoMedicamentoDao estadoMedicamentoDao) {this.estadoMedicamentoDao = estadoMedicamentoDao;}
	public IExamenParteCuerpoDao getExamenParteCuerpoDao() {return examenParteCuerpoDao;}
	public void setExamenParteCuerpoDao(IExamenParteCuerpoDao examenParteCuerpoDao) {this.examenParteCuerpoDao = examenParteCuerpoDao;}
	public IExamenDao getExamenDao() {return examenDao;}
	public void setExamenDao(IExamenDao examenDao) {this.examenDao = examenDao;}
	public IFinalidadDao getFinalidadDao() {return finalidadDao;}
	public void setFinalidadDao(IFinalidadDao finalidadDao) {this.finalidadDao = finalidadDao;}
	public IFormulacionDao getFormulacionDao() {return formulacionDao;}
	public void setFormulacionDao(IFormulacionDao formulacionDao) {this.formulacionDao = formulacionDao;}
	public IFrecuenciaDao getFrecuenciaDao() {return frecuenciaDao;}
	public void setFrecuenciaDao(IFrecuenciaDao frecuenciaDao) {this.frecuenciaDao = frecuenciaDao;}
	public IListaExamenConsultaDao getListaExamenConsultaDao() {return listaExamenConsultaDao;}
	public void setListaExamenConsultaDao(IListaExamenConsultaDao listaExamenConsultaDao) {this.listaExamenConsultaDao = listaExamenConsultaDao;}
	public IMotivoDao getMotivoDao() {return motivoDao;}
	public void setMotivoDao(IMotivoDao motivoDao) {this.motivoDao = motivoDao;}
	public IPacienteDao getPacienteDao() {return pacienteDao;}
	public void setPacienteDao(IPacienteDao pacienteDao) {this.pacienteDao = pacienteDao;}
	public IParentescoDao getParentescoDao() {return parentescoDao;}
	public void setParentescoDao(IParentescoDao parentescoDao) {this.parentescoDao = parentescoDao;}
	public IPartesCuerpoDao getPartesCuerpoDao() {return partesCuerpoDao;}
	public void setPartesCuerpoDao(IPartesCuerpoDao partesCuerpoDao) {this.partesCuerpoDao = partesCuerpoDao;}
	public IPersonaPerteneceDao getPersonaPerteneceDao() {return personaPerteneceDao;}
	public void setPersonaPerteneceDao(IPersonaPerteneceDao personaPerteneceDao) {this.personaPerteneceDao = personaPerteneceDao;}
	public IPosicionDao getPosicionDao() {return posicionDao;}
	public void setPosicionDao(IPosicionDao posicionDao) {this.posicionDao = posicionDao;}
	public IRegistroExamenDao getRegistroExamenDao() {return registroExamenDao;}
	public void setRegistroExamenDao(IRegistroExamenDao registroExamenDao) {this.registroExamenDao = registroExamenDao;}
	public IRegistroFormulacionDao getRegistroFormulacionDao() {return registroFormulacionDao;}
	public void setRegistroFormulacionDao(IRegistroFormulacionDao registroFormulacionDao) {this.registroFormulacionDao = registroFormulacionDao;}
	public IRemisionDao getRemisionDao() {return remisionDao;}
	public void setRemisionDao(IRemisionDao remisionDao) {this.remisionDao = remisionDao;}
	public ISeguridadSocialDao getSeguridadSocialDao() {return seguridadSocialDao;}
	public void setSeguridadSocialDao(ISeguridadSocialDao seguridadSocialDao) {this.seguridadSocialDao = seguridadSocialDao;}
	public IServicioDao getServicioDao() {return servicioDao;}
	public void setServicioDao(IServicioDao servicioDao) {this.servicioDao = servicioDao;}
	public ISintomaComunDao getSintomaComunDao() {return sintomaComunDao;}
	public void setSintomaComunDao(ISintomaComunDao sintomaComunDao) {this.sintomaComunDao = sintomaComunDao;}
	public ISintomaDao getSintomaDao() {return sintomaDao;}
	public void setSintomaDao(ISintomaDao sintomaDao) {this.sintomaDao = sintomaDao;}
	public ITelefonoDao getTelefonoDao() {return telefonoDao;}
	public void setTelefonoDao(ITelefonoDao telefonoDao) {this.telefonoDao = telefonoDao;}
	public ITipoDatoDao getTipoDatoDao() {return tipoDatoDao;}
	public void setTipoDatoDao(ITipoDatoDao tipoDatoDao) {this.tipoDatoDao = tipoDatoDao;}
	public ITipoDiagnosticoDao getTipoDiagnosticoDao() {return tipoDiagnosticoDao;}
	public void setTipoDiagnosticoDao(ITipoDiagnosticoDao tipoDiagnosticoDao) {this.tipoDiagnosticoDao = tipoDiagnosticoDao;}
	public ITipoDocumentoInstitucionDao getTipoDocumentoInstitucionDao() {return tipoDocumentoInstitucionDao;}
	public void setTipoDocumentoInstitucionDao(ITipoDocumentoInstitucionDao tipoDocumentoInstitucionDao) {this.tipoDocumentoInstitucionDao = tipoDocumentoInstitucionDao;}
	public ITipoEspecialidadDao getTipoEspecialidadDao() {return tipoEspecialidadDao;}
	public void setTipoEspecialidadDao(ITipoEspecialidadDao tipoEspecialidadDao) {this.tipoEspecialidadDao = tipoEspecialidadDao;}
	public ITipoServicioDao getTipoServicioDao() {return tipoServicioDao;}
	public void setTipoServicioDao(ITipoServicioDao tipoServicioDao) {this.tipoServicioDao = tipoServicioDao;}
	public ITipoUbicacionDao getTipoUbicacionDao() {return tipoUbicacionDao;}
	public void setTipoUbicacionDao(ITipoUbicacionDao tipoUbicacionDao) {this.tipoUbicacionDao = tipoUbicacionDao;}
	public ITipoVirtualLinkDao getTipoVirtualLinkDao() {return tipoVirtualLinkDao;}
	public void setTipoVirtualLinkDao(ITipoVirtualLinkDao tipoVirtualLinkDao) {this.tipoVirtualLinkDao = tipoVirtualLinkDao;}
	public ITomaDrogaDao getTomaDrogaDao() {return tomaDrogaDao;}
	public void setTomaDrogaDao(ITomaDrogaDao tomaDrogaDao) {this.tomaDrogaDao = tomaDrogaDao;}
	public IUbicacionDireccionDao getUbicacionDireccionDao() {return ubicacionDireccionDao;}
	public void setUbicacionDireccionDao(IUbicacionDireccionDao ubicacionDireccionDao) {this.ubicacionDireccionDao = ubicacionDireccionDao;}
	public IUbicacionTelefonoDao getUbicacionTelefonoDao() {return ubicacionTelefonoDao;}
	public void setUbicacionTelefonoDao(IUbicacionTelefonoDao ubicacionTelefonoDao) {this.ubicacionTelefonoDao = ubicacionTelefonoDao;}
	public IUbicacionVirtualDao getUbicacionVirtualDao() {return ubicacionVirtualDao;}
	public void setUbicacionVirtualDao(IUbicacionVirtualDao ubicacionVirtualDao) {this.ubicacionVirtualDao = ubicacionVirtualDao;}
	public IUnidadesDao getUnidadesDao() {return unidadesDao;}
	public void setUnidadesDao(IUnidadesDao unidadesDao) {this.unidadesDao = unidadesDao;}
	public IVariableExamenDao getVariableExamenDao() {return variableExamenDao;}
	public void setVariableExamenDao(IVariableExamenDao variableExamenDao) {this.variableExamenDao = variableExamenDao;}
	public IVariableFormulacionDao getVariableFormulacionDao() {return variableFormulacionDao;}
	public void setVariableFormulacionDao(IVariableFormulacionDao variableFormulacionDao) {this.variableFormulacionDao = variableFormulacionDao;}
	public IVirtualLinkDao getVirtualLinkDao() {return virtualLinkDao;}
	public void setVirtualLinkDao(IVirtualLinkDao virtualLinkDao) {this.virtualLinkDao = virtualLinkDao;}
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	
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
	// Especificacion Formula
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificacionformula findEspecificacionformulaById(long id) throws Exception {
		try {
			return getEspecificacionFormulaDao().findEspecificacionformulaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificacionformulaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Especificacionformula</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Especificacionformula> findAllEspecificacionformulas() throws Exception {
		try {
			return getEspecificacionFormulaDao().findAllEspecificacionformulas();
		} catch (RuntimeException e) {
			throw new Exception("findAllEspecificacionformulas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificacionformula(Especificacionformula especificacionformula) throws Exception {
		try {
			getEspecificacionFormulaDao().persistEspecificacionformula(especificacionformula);
		} catch (RuntimeException e) {
			throw new Exception("persistEspecificacionformula failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificacionformula(Especificacionformula especificacionformula) throws Exception {
		try {
			getEspecificacionFormulaDao().removeEspecificacionformula(especificacionformula);
		} catch (RuntimeException e) {
			throw new Exception("removeEspecificacionformula failed: " + e.getMessage());
		}
	}
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
	// Especificacion Examen
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Especificaexamen findEspecificaexamenById(long id) throws Exception {
		try {
			return getEspecificaExamenDao().findEspecificaexamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEspecificaexamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Especificaexamen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Especificaexamen> findAllEspecificaexamens() throws Exception {
		try {
			return getEspecificaExamenDao().findAllEspecificaexamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllEspecificaexamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEspecificaexamen(Especificaexamen especificaexamen) throws Exception {
		try {
			getEspecificaExamenDao().persistEspecificaexamen(especificaexamen);
		} catch (RuntimeException e) {
			throw new Exception("persistEspecificaexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEspecificaexamen(Especificaexamen especificaexamen) throws Exception {
		try {
			getEspecificaExamenDao().removeEspecificaexamen(especificaexamen);
		} catch (RuntimeException e) {
			throw new Exception("removeEspecificaexamen failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Estadocivil findEstadocivilById(long id) throws Exception {
		try {
			return getEstadoCivilDao().findEstadocivilById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEstadocivilById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Estadocivil</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Estadocivil> findAllEstadocivils() throws Exception {
		try {
			return getEstadoCivilDao().findAllEstadocivils();
		} catch (RuntimeException e) {
			throw new Exception("findAllEstadocivils failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadocivil(Estadocivil estadocivil) throws Exception {
		try {
			getEstadoCivilDao().persistEstadocivil(estadocivil);
		} catch (RuntimeException e) {
			throw new Exception("persistEstadocivil failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadocivil(Estadocivil estadocivil) throws Exception {
		try {
			getEstadoCivilDao().removeEstadocivil(estadocivil);
		} catch (RuntimeException e) {
			throw new Exception("removeEstadocivil failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Estadomedicamento findEstadomedicamentoById(long id) throws Exception {
		try {
			return getEstadoMedicamentoDao().findEstadomedicamentoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findEstadomedicamentoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Estadomedicamento</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Estadomedicamento> findAllEstadomedicamentos() throws Exception {
		try {
			return getEstadoMedicamentoDao().findAllEstadomedicamentos();
		} catch (RuntimeException e) {
			throw new Exception("findAllEstadomedicamentos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception {
		try {
			getEstadoMedicamentoDao().persistEstadomedicamento(estadomedicamento);
		} catch (RuntimeException e) {
			throw new Exception("persistEstadomedicamento failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeEstadomedicamento(Estadomedicamento estadomedicamento) throws Exception {
		try {
			getEstadoMedicamentoDao().removeEstadomedicamento(estadomedicamento);
		} catch (RuntimeException e) {
			throw new Exception("removeEstadomedicamento failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Examenpartecuerpo findExamenpartecuerpoById(long id) throws Exception {
		try {
			return getExamenParteCuerpoDao().findExamenpartecuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findExamenpartecuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Examenpartecuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examenpartecuerpo> findAllExamenpartecuerpos() throws Exception {
		try {
			return getExamenParteCuerpoDao().findAllExamenpartecuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllExamenpartecuerpos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception {
		try {
			getExamenParteCuerpoDao().persistExamenpartecuerpo(examenpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistExamenpartecuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamenpartecuerpo(Examenpartecuerpo examenpartecuerpo) throws Exception {
		try {
			getExamenParteCuerpoDao().removeExamenpartecuerpo(examenpartecuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removeExamenpartecuerpo failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Examen findExamenById(long id) throws Exception {
		try {
			return getExamenDao().findExamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findExamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Examen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Examen> findAllExamens() throws Exception {
		try {
			return getExamenDao().findAllExamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllExamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistExamen(Examen examen) throws Exception {
		try {
			getExamenDao().persistExamen(examen);
		} catch (RuntimeException e) {
			throw new Exception("persistExamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeExamen(Examen examen) throws Exception {
		try {
			getExamenDao().removeExamen(examen);
		} catch (RuntimeException e) {
			throw new Exception("removeExamen failed: " + e.getMessage());
		}
	}
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
	// Frecuencia
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Frecuencia findFrecuenciaById(long id) throws Exception {
		try {
			return getFrecuenciaDao().findFrecuenciaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFrecuenciaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Frecuencia</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Frecuencia> findAllFrecuencias() throws Exception {
		try {
			return getFrecuenciaDao().findAllFrecuencias();
		} catch (RuntimeException e) {
			throw new Exception("findAllFrecuencias failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFrecuencia(Frecuencia frecuencia) throws Exception {
		try {
			getFrecuenciaDao().persistFrecuencia(frecuencia);
		} catch (RuntimeException e) {
			throw new Exception("persistFrecuencia failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFrecuencia(Frecuencia frecuencia) throws Exception {
		try {
			getFrecuenciaDao().removeFrecuencia(frecuencia);
		} catch (RuntimeException e) {
			throw new Exception("removeFrecuencia failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Listaexamenconsulta findListaexamenconsultaById(long id) throws Exception {
		try {
			return getListaExamenConsultaDao().findListaexamenconsultaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findListaexamenconsultaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Listaexamenconsulta</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Listaexamenconsulta> findAllListaexamenconsultas() throws Exception {
		try {
			return getListaExamenConsultaDao().findAllListaexamenconsultas();
		} catch (RuntimeException e) {
			throw new Exception("findAllListaexamenconsultas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception {
		try {
			getListaExamenConsultaDao().persistListaexamenconsulta(listaexamenconsulta);
		} catch (RuntimeException e) {
			throw new Exception("persistListaexamenconsulta failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeListaexamenconsulta(Listaexamenconsulta listaexamenconsulta) throws Exception {
		try {
			getListaExamenConsultaDao().removeListaexamenconsulta(listaexamenconsulta);
		} catch (RuntimeException e) {
			throw new Exception("removeListaexamenconsulta failed: " + e.getMessage());
		}
	}
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
	public void persistPaciente(Paciente paciente) throws Exception {
		try {
			getPacienteDao().persistPaciente(paciente);
		} catch (RuntimeException e) {
			throw new Exception("persistPaciente failed: " + e.getMessage());
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
	// Partes Cuerpo
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Partescuerpo findPartescuerpoById(long id) throws Exception {
		try {
			return getPartesCuerpoDao().findPartescuerpoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPartescuerpoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Partescuerpo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Partescuerpo> findAllPartescuerpos() throws Exception {
		try {
			return getPartesCuerpoDao().findAllPartescuerpos();
		} catch (RuntimeException e) {
			throw new Exception("findAllPartescuerpos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPartescuerpo(Partescuerpo partescuerpo) throws Exception {
		try {
			getPartesCuerpoDao().persistPartescuerpo(partescuerpo);
		} catch (RuntimeException e) {
			throw new Exception("persistPartescuerpo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePartescuerpo(Partescuerpo partescuerpo) throws Exception {
		try {
			getPartesCuerpoDao().removePartescuerpo(partescuerpo);
		} catch (RuntimeException e) {
			throw new Exception("removePartescuerpo failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Personapertenece findPersonaperteneceById(com.software2g.vo.PersonapertenecePK id) throws Exception {
		try {
			return getPersonaPerteneceDao().findPersonaperteneceById(id);
		} catch (RuntimeException e) {
			throw new Exception("findPersonaperteneceById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Personapertenece</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Personapertenece> findAllPersonaperteneces() throws Exception {
		try {
			return getPersonaPerteneceDao().findAllPersonaperteneces();
		} catch (RuntimeException e) {
			throw new Exception("findAllPersonaperteneces failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistPersonapertenece(Personapertenece personapertenece) throws Exception {
		try {
			getPersonaPerteneceDao().persistPersonapertenece(personapertenece);
		} catch (RuntimeException e) {
			throw new Exception("persistPersonapertenece failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removePersonapertenece(Personapertenece personapertenece) throws Exception {
		try {
			getPersonaPerteneceDao().removePersonapertenece(personapertenece);
		} catch (RuntimeException e) {
			throw new Exception("removePersonapertenece failed: " + e.getMessage());
		}
	}
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
	// Registro Examen
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroexamen findRegistroexamenById(long id) throws Exception {
		try {
			return getRegistroExamenDao().findRegistroexamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroexamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroexamen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroexamen> findAllRegistroexamens() throws Exception {
		try {
			return getRegistroExamenDao().findAllRegistroexamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroexamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroexamen(Registroexamen registroexamen) throws Exception {
		try {
			getRegistroExamenDao().persistRegistroexamen(registroexamen);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroexamen(Registroexamen registroexamen) throws Exception {
		try {
			getRegistroExamenDao().removeRegistroexamen(registroexamen);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroexamen failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Registroformulacion findRegistroformulacionById(long id) throws Exception {
		try {
			return getRegistroFormulacionDao().findRegistroformulacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRegistroformulacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Registroformulacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Registroformulacion> findAllRegistroformulacions() throws Exception {
		try {
			return getRegistroFormulacionDao().findAllRegistroformulacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllRegistroformulacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRegistroformulacion(Registroformulacion registroformulacion) throws Exception {
		try {
			getRegistroFormulacionDao().persistRegistroformulacion(registroformulacion);
		} catch (RuntimeException e) {
			throw new Exception("persistRegistroformulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRegistroformulacion(Registroformulacion registroformulacion) throws Exception {
		try {
			getRegistroFormulacionDao().removeRegistroformulacion(registroformulacion);
		} catch (RuntimeException e) {
			throw new Exception("removeRegistroformulacion failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Remision findRemisionById(long id) throws Exception {
		try {
			return getRemisionDao().findRemisionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRemisionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Remision</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Remision> findAllRemisions() throws Exception {
		try {
			return getRemisionDao().findAllRemisions();
		} catch (RuntimeException e) {
			throw new Exception("findAllRemisions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRemision(Remision remision) throws Exception {
		try {
			getRemisionDao().persistRemision(remision);
		} catch (RuntimeException e) {
			throw new Exception("persistRemision failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRemision(Remision remision) throws Exception {
		try {
			getRemisionDao().removeRemision(remision);
		} catch (RuntimeException e) {
			throw new Exception("removeRemision failed: " + e.getMessage());
		}
	}
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
	public void persistServicio(Servicio servicio) throws Exception {
		try {
			getServicioDao().persistServicio(servicio);
		} catch (RuntimeException e) {
			throw new Exception("persistServicio failed: " + e.getMessage());
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
	// Sintoma Comun
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Sintomacomun findSintomacomunById(long id) throws Exception {
		try {
			return getSintomaComunDao().findSintomacomunById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSintomacomunById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Sintomacomun</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Sintomacomun> findAllSintomacomuns() throws Exception {
		try {
			return getSintomaComunDao().findAllSintomacomuns();
		} catch (RuntimeException e) {
			throw new Exception("findAllSintomacomuns failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintomacomun(Sintomacomun sintomacomun) throws Exception {
		try {
			getSintomaComunDao().persistSintomacomun(sintomacomun);
		} catch (RuntimeException e) {
			throw new Exception("persistSintomacomun failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintomacomun(Sintomacomun sintomacomun) throws Exception {
		try {
			getSintomaComunDao().removeSintomacomun(sintomacomun);
		} catch (RuntimeException e) {
			throw new Exception("removeSintomacomun failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Sintoma findSintomaById(long id) throws Exception {
		try {
			return getSintomaDao().findSintomaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findSintomaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Sintoma</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Sintoma> findAllSintomas() throws Exception {
		try {
			return getSintomaDao().findAllSintomas();
		} catch (RuntimeException e) {
			throw new Exception("findAllSintomas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistSintoma(Sintoma sintoma) throws Exception {
		try {
			getSintomaDao().persistSintoma(sintoma);
		} catch (RuntimeException e) {
			throw new Exception("persistSintoma failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeSintoma(Sintoma sintoma) throws Exception {
		try {
			getSintomaDao().removeSintoma(sintoma);
		} catch (RuntimeException e) {
			throw new Exception("removeSintoma failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Telefono findTelefonoById(long id) throws Exception {
		try {
			return getTelefonoDao().findTelefonoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTelefonoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Telefono</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Telefono> findAllTelefonos() throws Exception {
		try {
			return getTelefonoDao().findAllTelefonos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTelefonos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTelefono(Telefono telefono) throws Exception {
		try {
			getTelefonoDao().persistTelefono(telefono);
		} catch (RuntimeException e) {
			throw new Exception("persistTelefono failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTelefono(Telefono telefono) throws Exception {
		try {
			getTelefonoDao().removeTelefono(telefono);
		} catch (RuntimeException e) {
			throw new Exception("removeTelefono failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodato findTipodatoById(long id) throws Exception {
		try {
			return getTipoDatoDao().findTipodatoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodatoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodato</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodato> findAllTipodatos() throws Exception {
		try {
			return getTipoDatoDao().findAllTipodatos();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodatos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodato(Tipodato tipodato) throws Exception {
		try {
			getTipoDatoDao().persistTipodato(tipodato);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodato failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodato(Tipodato tipodato) throws Exception {
		try {
			getTipoDatoDao().removeTipodato(tipodato);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodato failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodiagnostico findTipodiagnosticoById(long id) throws Exception {
		try {
			return getTipoDiagnosticoDao().findTipodiagnosticoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodiagnosticoById failed with the id " + id + ": " + e.getMessage());
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
	// Tipo Documento Institucion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipodocumentoinst findTipodocumentoinstById(long id) throws Exception {
		try {
			return getTipoDocumentoInstitucionDao().findTipodocumentoinstById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipodocumentoinstById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipodocumentoinst</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipodocumentoinst> findAllTipodocumentoinsts() throws Exception {
		try {
			return getTipoDocumentoInstitucionDao().findAllTipodocumentoinsts();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipodocumentoinsts failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception {
		try {
			getTipoDocumentoInstitucionDao().persistTipodocumentoinst(tipodocumentoinst);
		} catch (RuntimeException e) {
			throw new Exception("persistTipodocumentoinst failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipodocumentoinst(Tipodocumentoinst tipodocumentoinst) throws Exception {
		try {
			getTipoDocumentoInstitucionDao().removeTipodocumentoinst(tipodocumentoinst);
		} catch (RuntimeException e) {
			throw new Exception("removeTipodocumentoinst failed: " + e.getMessage());
		}
	}
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
	// Tipo Ubicacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipoubicacion findTipoubicacionById(long id) throws Exception {
		try {
			return getTipoUbicacionDao().findTipoubicacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipoubicacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipoubicacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipoubicacion> findAllTipoubicacions() throws Exception {
		try {
			return getTipoUbicacionDao().findAllTipoubicacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipoubicacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipoubicacion(Tipoubicacion tipoubicacion) throws Exception {
		try {
			getTipoUbicacionDao().persistTipoubicacion(tipoubicacion);
		} catch (RuntimeException e) {
			throw new Exception("persistTipoubicacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipoubicacion(Tipoubicacion tipoubicacion) throws Exception {
		try {
			getTipoUbicacionDao().removeTipoubicacion(tipoubicacion);
		} catch (RuntimeException e) {
			throw new Exception("removeTipoubicacion failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tipovirtuallink findTipovirtuallinkById(long id) throws Exception {
		try {
			return getTipoVirtualLinkDao().findTipovirtuallinkById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTipovirtuallinkById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tipovirtuallink</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tipovirtuallink> findAllTipovirtuallinks() throws Exception {
		try {
			return getTipoVirtualLinkDao().findAllTipovirtuallinks();
		} catch (RuntimeException e) {
			throw new Exception("findAllTipovirtuallinks failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception {
		try {
			getTipoVirtualLinkDao().persistTipovirtuallink(tipovirtuallink);
		} catch (RuntimeException e) {
			throw new Exception("persistTipovirtuallink failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTipovirtuallink(Tipovirtuallink tipovirtuallink) throws Exception {
		try {
			getTipoVirtualLinkDao().removeTipovirtuallink(tipovirtuallink);
		} catch (RuntimeException e) {
			throw new Exception("removeTipovirtuallink failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Tomasinodroga findTomasinodrogaById(long id) throws Exception {
		try {
			return getTomaDrogaDao().findTomasinodrogaById(id);
		} catch (RuntimeException e) {
			throw new Exception("findTomasinodrogaById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Tomasinodroga</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Tomasinodroga> findAllTomasinodrogas() throws Exception {
		try {
			return getTomaDrogaDao().findAllTomasinodrogas();
		} catch (RuntimeException e) {
			throw new Exception("findAllTomasinodrogas failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistTomasinodroga(Tomasinodroga tomasinodroga) throws Exception {
		try {
			getTomaDrogaDao().persistTomasinodroga(tomasinodroga);
		} catch (RuntimeException e) {
			throw new Exception("persistTomasinodroga failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeTomasinodroga(Tomasinodroga tomasinodroga) throws Exception {
		try {
			getTomaDrogaDao().removeTomasinodroga(tomasinodroga);
		} catch (RuntimeException e) {
			throw new Exception("removeTomasinodroga failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ubicaciondireccion findUbicaciondireccionById(long id) throws Exception {
		try {
			return getUbicacionDireccionDao().findUbicaciondireccionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUbicaciondireccionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ubicaciondireccion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ubicaciondireccion> findAllUbicaciondireccions() throws Exception {
		try {
			return getUbicacionDireccionDao().findAllUbicaciondireccions();
		} catch (RuntimeException e) {
			throw new Exception("findAllUbicaciondireccions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception {
		try {
			getUbicacionDireccionDao().persistUbicaciondireccion(ubicaciondireccion);
		} catch (RuntimeException e) {
			throw new Exception("persistUbicaciondireccion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciondireccion(Ubicaciondireccion ubicaciondireccion) throws Exception {
		try {
			getUbicacionDireccionDao().removeUbicaciondireccion(ubicaciondireccion);
		} catch (RuntimeException e) {
			throw new Exception("removeUbicaciondireccion failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ubicaciontelefono findUbicaciontelefonoById(long id) throws Exception {
		try {
			return getUbicacionTelefonoDao().findUbicaciontelefonoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUbicaciontelefonoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ubicaciontelefono</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ubicaciontelefono> findAllUbicaciontelefonos() throws Exception {
		try {
			return getUbicacionTelefonoDao().findAllUbicaciontelefonos();
		} catch (RuntimeException e) {
			throw new Exception("findAllUbicaciontelefonos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception {
		try {
			getUbicacionTelefonoDao().persistUbicaciontelefono(ubicaciontelefono);
		} catch (RuntimeException e) {
			throw new Exception("persistUbicaciontelefono failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicaciontelefono(Ubicaciontelefono ubicaciontelefono) throws Exception {
		try {
			getUbicacionTelefonoDao().removeUbicaciontelefono(ubicaciontelefono);
		} catch (RuntimeException e) {
			throw new Exception("removeUbicaciontelefono failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Ubicacionvirtual findUbicacionvirtualById(long id) throws Exception {
		try {
			return getUbicacionVirtualDao().findUbicacionvirtualById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUbicacionvirtualById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Ubicacionvirtual</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Ubicacionvirtual> findAllUbicacionvirtuals() throws Exception {
		try {
			return getUbicacionVirtualDao().findAllUbicacionvirtuals();
		} catch (RuntimeException e) {
			throw new Exception("findAllUbicacionvirtuals failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception {
		try {
			getUbicacionVirtualDao().persistUbicacionvirtual(ubicacionvirtual);
		} catch (RuntimeException e) {
			throw new Exception("persistUbicacionvirtual failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUbicacionvirtual(Ubicacionvirtual ubicacionvirtual) throws Exception {
		try {
			getUbicacionVirtualDao().removeUbicacionvirtual(ubicacionvirtual);
		} catch (RuntimeException e) {
			throw new Exception("removeUbicacionvirtual failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Unidade findUnidadeById(long id) throws Exception {
		try {
			return getUnidadesDao().findUnidadeById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUnidadeById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Unidade</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Unidade> findAllUnidades() throws Exception {
		try {
			return getUnidadesDao().findAllUnidades();
		} catch (RuntimeException e) {
			throw new Exception("findAllUnidades failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUnidade(Unidade unidade) throws Exception {
		try {
			getUnidadesDao().persistUnidade(unidade);
		} catch (RuntimeException e) {
			throw new Exception("persistUnidade failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUnidade(Unidade unidade) throws Exception {
		try {
			getUnidadesDao().removeUnidade(unidade);
		} catch (RuntimeException e) {
			throw new Exception("removeUnidade failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Variableexamen findVariableexamenById(long id) throws Exception {
		try {
			return getVariableExamenDao().findVariableexamenById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVariableexamenById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Variableexamen</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Variableexamen> findAllVariableexamens() throws Exception {
		try {
			return getVariableExamenDao().findAllVariableexamens();
		} catch (RuntimeException e) {
			throw new Exception("findAllVariableexamens failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableexamen(Variableexamen variableexamen) throws Exception {
		try {
			getVariableExamenDao().persistVariableexamen(variableexamen);
		} catch (RuntimeException e) {
			throw new Exception("persistVariableexamen failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableexamen(Variableexamen variableexamen) throws Exception {
		try {
			getVariableExamenDao().removeVariableexamen(variableexamen);
		} catch (RuntimeException e) {
			throw new Exception("removeVariableexamen failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Variable Examen
	//******************************************************************
	
	//******************************************************************
	// Variable Formulacion
	//******************************************************************
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Variableformulacion findVariableformulacionById(long id) throws Exception {
		try {
			return getVariableFormulacionDao().findVariableformulacionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVariableformulacionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Variableformulacion</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Variableformulacion> findAllVariableformulacions() throws Exception {
		try {
			return getVariableFormulacionDao().findAllVariableformulacions();
		} catch (RuntimeException e) {
			throw new Exception("findAllVariableformulacions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVariableformulacion(Variableformulacion variableformulacion) throws Exception {
		try {
			getVariableFormulacionDao().persistVariableformulacion(variableformulacion);
		} catch (RuntimeException e) {
			throw new Exception("persistVariableformulacion failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVariableformulacion(Variableformulacion variableformulacion) throws Exception {
		try {
			getVariableFormulacionDao().removeVariableformulacion(variableformulacion);
		} catch (RuntimeException e) {
			throw new Exception("removeVariableformulacion failed: " + e.getMessage());
		}
	}
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
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Virtuallink findVirtuallinkById(long id) throws Exception {
		try {
			return getVirtualLinkDao().findVirtuallinkById(id);
		} catch (RuntimeException e) {
			throw new Exception("findVirtuallinkById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Virtuallink</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Virtuallink> findAllVirtuallinks() throws Exception {
		try {
			return getVirtualLinkDao().findAllVirtuallinks();
		} catch (RuntimeException e) {
			throw new Exception("findAllVirtuallinks failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistVirtuallink(Virtuallink virtuallink) throws Exception {
		try {
			getVirtualLinkDao().persistVirtuallink(virtuallink);
		} catch (RuntimeException e) {
			throw new Exception("persistVirtuallink failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeVirtuallink(Virtuallink virtuallink) throws Exception {
		try {
			getVirtualLinkDao().removeVirtuallink(virtuallink);
		} catch (RuntimeException e) {
			throw new Exception("removeVirtuallink failed: " + e.getMessage());
		}
	}
	//******************************************************************
	// Fin Virtual Link
	//******************************************************************

	//******************************************************************
	// Persona
	//******************************************************************
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
	//******************************************************************
	// Fin Persona
	//******************************************************************	

}
