package com.software2g.agenda.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.agenda.facade.IGestionFacadeAgenda;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
import com.software2g.niif.facade.IGestionFacadeNIIF;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Agenda;
import com.software2g.vo.Archivotabla;
import com.software2g.vo.Codigoenfermedade;
import com.software2g.vo.Departamento;
import com.software2g.vo.Diagnostico;
import com.software2g.vo.Evento;
import com.software2g.vo.Examenespecialidad;
import com.software2g.vo.Examenoptometria;
import com.software2g.vo.Finalidad;
import com.software2g.vo.Formulacion;
import com.software2g.vo.Gafa;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Medicamento;
import com.software2g.vo.Motivo;
import com.software2g.vo.Municipio;
import com.software2g.vo.Opcionrespuesta;
import com.software2g.vo.Paciente;
import com.software2g.vo.Pais;
import com.software2g.vo.Parametroscalendario;
import com.software2g.vo.Participante;
import com.software2g.vo.Persona;
import com.software2g.vo.Portafoliocategoria;
import com.software2g.vo.Pregunta;
import com.software2g.vo.Procedimiento;
import com.software2g.vo.Profesional;
import com.software2g.vo.Registroavsc;
import com.software2g.vo.Registrocovertest;
import com.software2g.vo.Registroexamensimple;
import com.software2g.vo.Registrorxuso;
import com.software2g.vo.Respuesta;
import com.software2g.vo.Segmentoanamnesi;
import com.software2g.vo.Seguridadsocial;
import com.software2g.vo.Servicio;
import com.software2g.vo.Tipodiagnostico;
import com.software2g.vo.Tipodocumento;
import com.software2g.vo.Tipoespecialidad;
import com.software2g.vo.Tipoexamenopt;
import com.software2g.vo.Tipoprocedimiento;
import com.software2g.vo.Tiposervicio;
import com.software2g.vo.Usuario;
import com.software2g.vo.UtilGenerico;

public class AgendaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeAgenda gestionFacadeAgenda;
	private IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica;
	private IGestionFacadeNIIF gestionFacadeNIIF;
	private String estado;
	private String funcPosicionado;
	private String bandEstadoFunc;
	private String id;
	private String constantesAgendaProfesional;
	private String eventoAgendaProfesional;
	private String background;
	
	private String odontograma;

	private List<Parametroscalendario> listParametroCalendrio;
	private Parametroscalendario parametroCalendario;
	private List<Jorandalaboral> listJornadaLaboral;
	private Jorandalaboral jornadaLaboral;
	private Profesional profesional;
	private List<Profesional> listProfesional;
	private List<Persona> listPersona;
	private InputStream strProfesional;
	private Persona persona;
	private InputStream strDatosPersona;
	private List<Agenda> listAgendaMedica;
	private List<Agenda> listAgendaCategoria;
	private Agenda agendaMedica;
	private Agenda agendaCategoria;
	private InputStream strCrearEvento;
	private InputStream strCrearEventoCate;
	private Evento evento;
	private Participante participante;
	private Tipoprocedimiento tipoProcedimiento;
	private List<Tipoprocedimiento> listTipoProcedimiento;
	private Procedimiento procedimiento;
	private List<Procedimiento> listProcedimiento;
	private List<Tipodocumento> listTipoDoc;
	private List<String> listEstadoCivil;
	private List<Pais> listPais;
	private List<Departamento> listDepartamento; 
	private List<Municipio> listMunicipio;
	
	
	private List<Finalidad> listFinalidad;
	private Finalidad finalidad;
	private List<Motivo> listMotivo;
	private Motivo motivo;
	private List<Seguridadsocial> listSeguridadSocial;
	private Seguridadsocial seguridadSocial;
	private Registrorxuso rxUsoOD;
	private Registrorxuso rxUsoOI;
	private List<UtilGenerico> listAVC = ConstantesAplicativo.listAVC;
	private List<UtilGenerico> listCoverTest = ConstantesAplicativo.listCoverTest;
	private Registroavsc avscOD;
	private Registroavsc avscOI;
	private Registrocovertest coverTest;
	private Registroexamensimple examenExternoOD;
	private Registroexamensimple examenExternoOI;
	private Registroexamensimple oftalmoscopiaOD;
	private Registroexamensimple oftalmoscopiaOI;
	private Registroexamensimple keratometriaOD;
	private Registroexamensimple keratometriaOI;
	private Registroexamensimple retinoscopiaOD;
	private Registroexamensimple retinoscopiaOI;
	private List<Segmentoanamnesi> listSegmentoAnamnesis; 
	private List<Respuesta> listRespuesta;
	private Segmentoanamnesi segmentoAnamnesis;
	private Paciente paciente;
	private Tiposervicio tipoServicio;
	private List<Tiposervicio> listTipoServicio;
	private List<Tipoespecialidad> listTipoEspecialidad;
	private List<Examenespecialidad> listExamenEspecialidad;
	private Diagnostico diagnostico;
	private InputStream	strDatosDiagnostico;
	private List<Diagnostico> listDiagnostico;
	private List<Tipodiagnostico> listTipoDiagnostico;
	private List<UtilGenerico> listClaseDiagnostico = ConstantesAplicativo.listClaseDiagnostico;
	private InputStream	strCambiarDatosDiagnostico;
	private Medicamento medicamento;
	private List<Medicamento> listMedicamento;
	private Gafa gafaOD;
	private Gafa gafaOI;
	private Gafa gafaAmbosOjos;
	private Servicio servicio;
	private Examenoptometria examenOptometria;
	private InputStream strDatosCoverTest;
	private List<Registrocovertest> listRegistroCoverTestLejos;
	private List<Registrocovertest> listRegistroCoverTestCerca;
	
	private List<Portafoliocategoria> listPortafolioCategoria;
	private Archivotabla archivotabla;
	
	public List<Parametroscalendario> getListParametroCalendrio() {return listParametroCalendrio;}
	public void setListParametroCalendrio(List<Parametroscalendario> listParametroCalendrio) {this.listParametroCalendrio = listParametroCalendrio;}
	public Parametroscalendario getParametroCalendario() {return parametroCalendario;}
	public void setParametroCalendario(Parametroscalendario parametroCalendario) {this.parametroCalendario = parametroCalendario;}
	public List<Jorandalaboral> getListJornadaLaboral() {return listJornadaLaboral;}
	public void setListJornadaLaboral(List<Jorandalaboral> listJornadaLaboral) {this.listJornadaLaboral = listJornadaLaboral;}
	public Jorandalaboral getJornadaLaboral() {return jornadaLaboral;}
	public void setJornadaLaboral(Jorandalaboral jornadaLaboral) {this.jornadaLaboral = jornadaLaboral;}
	public Profesional getProfesional() {return profesional;}
	public void setProfesional(Profesional profesional) {this.profesional = profesional;}
	public List<Profesional> getListProfesional() {return listProfesional;}
	public void setListProfesional(List<Profesional> listProfesional) {this.listProfesional = listProfesional;}
	public Persona getPersona() {return persona;}
	public void setPersona(Persona persona) {this.persona = persona;}
	public List<Persona> getListPersona() {return listPersona;}
	public void setListPersona(List<Persona> listPersona) {this.listPersona = listPersona;}
	public List<Agenda> getListAgendaMedica() {return listAgendaMedica;}
	public void setListAgendaMedica(List<Agenda> listAgendaMedica) {this.listAgendaMedica = listAgendaMedica;}
	public List<Agenda> getListAgendaCategoria() {return listAgendaCategoria;}
	public void setListAgendaCategoria(List<Agenda> listAgendaCategoria) {this.listAgendaCategoria = listAgendaCategoria;}
	public Agenda getAgendaMedica() {return agendaMedica;}
	public void setAgendaMedica(Agenda agendaMedica) {this.agendaMedica = agendaMedica;}
	public Agenda getAgendaCategoria() {return agendaCategoria;}
	public void setAgendaCategoria(Agenda agendaCategoria) {this.agendaCategoria = agendaCategoria;}
	public String getConstantesAgendaProfesional() {return constantesAgendaProfesional;}
	public void setConstantesAgendaProfesional(String constantesAgendaProfesional) {this.constantesAgendaProfesional = constantesAgendaProfesional;}
	public String getEventoAgendaProfesional() {return eventoAgendaProfesional;}
	public void setEventoAgendaProfesional(String eventoAgendaProfesional) {this.eventoAgendaProfesional = eventoAgendaProfesional;}
	public Evento getEvento() {return evento;}
	public void setEvento(Evento evento) {this.evento = evento;}
	public Participante getParticipante() {return participante;}
	public void setParticipante(Participante participante) {this.participante = participante;}
	public Tipoprocedimiento getTipoProcedimiento() {return tipoProcedimiento;}
	public void setTipoProcedimiento(Tipoprocedimiento tipoProcedimiento) {this.tipoProcedimiento = tipoProcedimiento;}
	public List<Tipoprocedimiento> getListTipoProcedimiento() {return listTipoProcedimiento;}
	public void setListTipoProcedimiento(List<Tipoprocedimiento> listTipoProcedimiento) {this.listTipoProcedimiento = listTipoProcedimiento;}
	public Procedimiento getProcedimiento() {return procedimiento;}
	public void setProcedimiento(Procedimiento procedimiento) {this.procedimiento = procedimiento;}
	public List<Procedimiento> getListProcedimiento() {return listProcedimiento;}
	public void setListProcedimiento(List<Procedimiento> listProcedimiento) {this.listProcedimiento = listProcedimiento;}
	public List<Tipodocumento> getListTipoDoc() {return listTipoDoc;}
	public void setListTipoDoc(List<Tipodocumento> listTipoDoc) {this.listTipoDoc = listTipoDoc;}
	public List<String> getListEstadoCivil() {return listEstadoCivil;}
	public void setListEstadoCivil(List<String> listEstadoCivil) {this.listEstadoCivil = listEstadoCivil;}
	public List<Pais> getListPais() {return listPais;}
	public void setListPais(List<Pais> listPais) {this.listPais = listPais;}
	public List<Departamento> getListDepartamento() {return listDepartamento;}
	public void setListDepartamento(List<Departamento> listDepartamento) {this.listDepartamento = listDepartamento;}
	public List<Municipio> getListMunicipio() {return listMunicipio;}
	public void setListMunicipio(List<Municipio> listMunicipio) {this.listMunicipio = listMunicipio;}
	
	public List<Finalidad> getListFinalidad() {return listFinalidad;}
	public void setListFinalidad(List<Finalidad> listFinalidad) {this.listFinalidad = listFinalidad;}
	public List<Motivo> getListMotivo() {return listMotivo;}
	public void setListMotivo(List<Motivo> listMotivo) {this.listMotivo = listMotivo;}
	public List<Seguridadsocial> getListSeguridadSocial() {return listSeguridadSocial;}
	public void setListSeguridadSocial(List<Seguridadsocial> listSeguridadSocial) {this.listSeguridadSocial = listSeguridadSocial;}
	public Finalidad getFinalidad() {return finalidad;}
	public void setFinalidad(Finalidad finalidad) {this.finalidad = finalidad;}
	public Motivo getMotivo() {return motivo;}
	public void setMotivo(Motivo motivo) {this.motivo = motivo;}
	public Seguridadsocial getSeguridadSocial() {return seguridadSocial;}
	public void setSeguridadSocial(Seguridadsocial seguridadSocial) {this.seguridadSocial = seguridadSocial;}
	public Registrorxuso getRxUsoOD() {return rxUsoOD;}
	public void setRxUsoOD(Registrorxuso rxUsoOD) {this.rxUsoOD = rxUsoOD;}
	public Registrorxuso getRxUsoOI() {return rxUsoOI;}
	public void setRxUsoOI(Registrorxuso rxUsoOI) {this.rxUsoOI = rxUsoOI;}
	public List<UtilGenerico> getListAVC() {return listAVC;}
	public void setListAVC(List<UtilGenerico> listAVC) {this.listAVC = listAVC;}
	public List<UtilGenerico> getListCoverTest() {return listCoverTest;}
	public void setListCoverTest(List<UtilGenerico> listCoverTest) {this.listCoverTest = listCoverTest;}
	public Registroavsc getAvscOD() {return avscOD;}
	public void setAvscOD(Registroavsc avscOD) {this.avscOD = avscOD;}
	public Registroavsc getAvscOI() {return avscOI;}
	public void setAvscOI(Registroavsc avscOI) {this.avscOI = avscOI;}
	public Registrocovertest getCoverTest() {return coverTest;}
	public void setCoverTest(Registrocovertest coverTest) {this.coverTest = coverTest;}
	public Registroexamensimple getExamenExternoOD() {return examenExternoOD;}
	public void setExamenExternoOD(Registroexamensimple examenExternoOD) {this.examenExternoOD = examenExternoOD;}
	public Registroexamensimple getExamenExternoOI() {return examenExternoOI;}
	public void setExamenExternoOI(Registroexamensimple examenExternoOI) {this.examenExternoOI = examenExternoOI;}
	public Registroexamensimple getOftalmoscopiaOD() {return oftalmoscopiaOD;}
	public void setOftalmoscopiaOD(Registroexamensimple oftalmoscopiaOD) {this.oftalmoscopiaOD = oftalmoscopiaOD;}
	public Registroexamensimple getOftalmoscopiaOI() {return oftalmoscopiaOI;}
	public void setOftalmoscopiaOI(Registroexamensimple oftalmoscopiaOI) {this.oftalmoscopiaOI = oftalmoscopiaOI;}
	public Registroexamensimple getKeratometriaOD() {return keratometriaOD;}
	public void setKeratometriaOD(Registroexamensimple keratometriaOD) {this.keratometriaOD = keratometriaOD;}
	public Registroexamensimple getKeratometriaOI() {return keratometriaOI;}
	public void setKeratometriaOI(Registroexamensimple keratometriaOI) {this.keratometriaOI = keratometriaOI;}
	public Registroexamensimple getRetinoscopiaOD() {return retinoscopiaOD;}
	public void setRetinoscopiaOD(Registroexamensimple retinoscopiaOD) {this.retinoscopiaOD = retinoscopiaOD;}
	public Registroexamensimple getRetinoscopiaOI() {return retinoscopiaOI;}
	public void setRetinoscopiaOI(Registroexamensimple retinoscopiaOI) {this.retinoscopiaOI = retinoscopiaOI;}
	public List<Segmentoanamnesi> getListSegmentoAnamnesis() {return listSegmentoAnamnesis;}
	public void setListSegmentoAnamnesis(List<Segmentoanamnesi> listSegmentoAnamnesis) {this.listSegmentoAnamnesis = listSegmentoAnamnesis;}
	public Segmentoanamnesi getSegmentoAnamnesis() {return segmentoAnamnesis;}
	public void setSegmentoAnamnesis(Segmentoanamnesi segmentoAnamnesis) {this.segmentoAnamnesis = segmentoAnamnesis;}
	public Paciente getPaciente() {return paciente;}
	public void setPaciente(Paciente paciente) {this.paciente = paciente;}
	public Tiposervicio getTipoServicio() {return tipoServicio;}
	public void setTipoServicio(Tiposervicio tipoServicio) {this.tipoServicio = tipoServicio;}
	public List<Tiposervicio> getListTipoServicio() {return listTipoServicio;}
	public void setListTipoServicio(List<Tiposervicio> listTipoServicio) {this.listTipoServicio = listTipoServicio;}
	public List<UtilGenerico> getListEspecialidadSoportadas() {return ConstantesAplicativo.listEspecialidadSoportadas;}
	public List<Tipoespecialidad> getListTipoEspecialidad() {return listTipoEspecialidad;}
	public void setListTipoEspecialidad(List<Tipoespecialidad> listTipoEspecialidad) {this.listTipoEspecialidad = listTipoEspecialidad;}
	public List<Examenespecialidad> getListExamenEspecialidad() {return listExamenEspecialidad;}
	public void setListExamenEspecialidad(List<Examenespecialidad> listExamenEspecialidad) {this.listExamenEspecialidad = listExamenEspecialidad;}
	public Diagnostico getDiagnostico() {return diagnostico;}
	public void setDiagnostico(Diagnostico diagnostico) {this.diagnostico = diagnostico;}
	public List<Diagnostico> getListDiagnostico() {return listDiagnostico;}
	public void setListDiagnostico(List<Diagnostico> listDiagnostico) {this.listDiagnostico = listDiagnostico;}
	public List<Tipodiagnostico> getListTipoDiagnostico() {return listTipoDiagnostico;}
	public void setListTipoDiagnostico(List<Tipodiagnostico> listTipoDiagnostico) {this.listTipoDiagnostico = listTipoDiagnostico;}
	public List<UtilGenerico> getListClaseDiagnostico() {return listClaseDiagnostico;}
	public void setListClaseDiagnostico(List<UtilGenerico> listClaseDiagnostico) {this.listClaseDiagnostico = listClaseDiagnostico;}
	public Medicamento getMedicamento() {return medicamento;}
	public void setMedicamento(Medicamento medicamento) {this.medicamento = medicamento;}
	public List<Medicamento> getListMedicamento() {return listMedicamento;}
	public void setListMedicamento(List<Medicamento> listMedicamento) {this.listMedicamento = listMedicamento;}
	public Gafa getGafaOD() {return gafaOD;}
	public void setGafaOD(Gafa gafaOD) {this.gafaOD = gafaOD;}
	public Gafa getGafaOI() {return gafaOI;}
	public void setGafaOI(Gafa gafaOI) {this.gafaOI = gafaOI;}
	public Gafa getGafaAmbosOjos() {return gafaAmbosOjos;}
	public void setGafaAmbosOjos(Gafa gafaAmbosOjos) {this.gafaAmbosOjos = gafaAmbosOjos;}
	public Servicio getServicio() {return servicio;}
	public void setServicio(Servicio servicio) {this.servicio = servicio;}
	public Examenoptometria getExamenOptometria() {return examenOptometria;}
	public void setExamenOptometria(Examenoptometria examenOptometria) {this.examenOptometria = examenOptometria;}
	public List<Respuesta> getListRespuesta() {return listRespuesta;}
	public void setListRespuesta(List<Respuesta> listRespuesta) {this.listRespuesta = listRespuesta;}
	public List<Registrocovertest> getListRegistroCoverTestLejos() {return listRegistroCoverTestLejos;}
	public void setListRegistroCoverTestLejos(List<Registrocovertest> listRegistroCoverTestLejos) {this.listRegistroCoverTestLejos = listRegistroCoverTestLejos;}
	public List<Registrocovertest> getListRegistroCoverTestCerca() {return listRegistroCoverTestCerca;}
	public void setListRegistroCoverTestCerca(List<Registrocovertest> listRegistroCoverTestCerca) {this.listRegistroCoverTestCerca = listRegistroCoverTestCerca;}
	
	public List<Portafoliocategoria> getListPortafolioCategoria() {return listPortafolioCategoria;}
	public void setListPortafolioCategoria(List<Portafoliocategoria> listPortafolioCategoria) {this.listPortafolioCategoria = listPortafolioCategoria;}
	public Archivotabla getArchivotabla() {return archivotabla;}
	public void setArchivotabla(Archivotabla archivotabla) {this.archivotabla = archivotabla;}
	
	
	public String getConstanteTipoPregAbierta(){ return ConstantesAplicativo.constanteTipoPregAbierta;}
	public String getConstanteTipoPregMultipleMR(){ return ConstantesAplicativo.constanteTipoPregMultipleMR;}
	public String getConstanteTipoPregMultipleUR(){ return ConstantesAplicativo.constanteTipoPregMultipleUR;}
	public String getConstanteTipoPregFecha(){ return ConstantesAplicativo.constanteTipoPregFecha;}
	

	public String getConstanteTipoObjetoViewTextField(){ return ConstantesAplicativo.constanteTipoObjetoViewTextField;}
	public String getConstanteTipoObjetoViewCheckBox(){ return ConstantesAplicativo.constanteTipoObjetoViewCheckBox;}
	public String getConstanteTipoObjetoViewTextArea(){ return ConstantesAplicativo.constanteTipoObjetoViewTextArea;}
	public String getConstanteTipoObjetoViewSelect(){ return ConstantesAplicativo.constanteTipoObjetoViewSelect;}
	public String getConstanteTipoObjetoViewCalendar(){ return ConstantesAplicativo.constanteTipoObjetoViewCalendar;}
	
	
	
	@SkipValidation
	public String calendarioMethod(){
		String  result = Action.SUCCESS;
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>calendarioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionalAgenda();
    			constantesAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllAgendaProf;
    			eventoAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllEventoAgendaProf;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionalAgenda();
    			if(background==null||(background!=null&&background.equals(""))){
    				constantesAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllAgendaProf;
        			eventoAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllEventoAgendaProf;
    			}else{
	    			profesional = gestionFacadeAgenda.findProfesionalBackground(getBackground());
	    			agendaMedica = gestionFacadeAgenda.findIdAgenda(getBackground());
	    			constantesAgendaProfesional = "constantesCalendario/agenda/constanteAgendaProf_"+profesional.getProfId();
	    			eventoAgendaProfesional = "eventosAgenda/eventosagenda_"+agendaMedica.getAgenId();
    			}
    			estado = ConstantesAplicativo.constanteEstadoAll;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoOperacionCita)){
    			if(evento!=null&&evento.getAccion()!=null&&evento.getAccion().equals(ConstantesAplicativo.constanteNoAplica))
    				addActionError(getText("validacion.requerido","evenAccion","Accion a Realizar"));
    			if(profesional!=null&&profesional.getProfId()>0&&evento!=null&&evento.getEvenId()>0){
    				profesional = gestionFacadeAgenda.findProfesionalById(profesional.getProfId());
    				evento = gestionFacadeAgenda.findEventoById(evento.getEvenId());
    			}else{
    				long idProfesional = Long.parseLong(request.getParameter("idProfesional").toString());
	    			long idEvento = Long.parseLong(request.getParameter("idEvento").toString());
	    			profesional = gestionFacadeAgenda.findProfesionalById(idProfesional);
	    			evento = gestionFacadeAgenda.findEventoById(idEvento);
    			}
    			evento.setParticipantes(gestionFacadeAgenda.findAllParticipantes(evento.getEvenId()));
    			if(evento.getParticipantes()!=null&&evento.getParticipantes().size()>0)
    				participante = (Participante) evento.getParticipantes().get(0);
    			estado = ConstantesAplicativo.constanteEstadoOperacionCita;
    			evento.getEvenStartViewFecha();
    			evento.getEvenStartViewHora();
    		}
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
    	System.out.println("######>>>>>>>AgendaAction>>>>calendarioMethod>>>>estado salida-->>"+estado);
    	return result;
	}
	
	@SkipValidation
	public String calendarioCategoriaMethod(){
		String  result = Action.SUCCESS;
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>calendarioCategoriaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listPortafolioCategoria = gestionFacadeNIIF.findAllPortafoliocategorias();
    			constantesAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllAgendaProf;
    			eventoAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllEventoAgendaProf;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)){
    			listPortafolioCategoria = gestionFacadeNIIF.findAllPortafoliocategorias();
    			if(background==null||(background!=null&&background.equals(""))){
    				constantesAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllAgendaProf;
        			eventoAgendaProfesional = ConstantesAplicativo.constanteNameFileJSAllEventoAgendaProf;
    			}else{
	    			agendaCategoria = gestionFacadeAgenda.findIdAgenda(getBackground(), ConstantesAplicativo.constanteAgendaCategoria);
	    			agendaCategoria.setPortafolioCategoria(gestionFacadeNIIF.findCategoriaBackground(getBackground()));
	    			archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, agendaCategoria.getPortafolioCategoria().getPocaId()+"");
    				if(archivotabla!=null){
        				String rutaAlterna = "/";
        				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
        				archivotabla.setRutaAlterna(rutaAlterna);
        			}else{
        				archivotabla = new Archivotabla();
        			}
    				agendaCategoria.getPortafolioCategoria().setArchivo(archivotabla);
	    			constantesAgendaProfesional = "constantesCalendario/agenda/constanteAgendaCate_"+agendaCategoria.getPortafolioCategoria().getPocaId();
	    			eventoAgendaProfesional = "eventosAgenda/eventosagenda_"+agendaCategoria.getAgenId();
    			}
    			estado = ConstantesAplicativo.constanteEstadoAll;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoLegalizarCompromiso)){
    			
    			if(evento!=null&&evento.getAccion()!=null&&evento.getAccion().equals(ConstantesAplicativo.constanteNoAplica))
    				addActionError(getText("validacion.requerido","evenAccion","Accion a Realizar"));
    			if(evento!=null&&evento.getEvenId()>0){
    				evento = gestionFacadeAgenda.findEventoById(evento.getEvenId());
    			}else{
	    			long idEvento = Long.parseLong(request.getParameter("idEvento").toString());
	    			evento = gestionFacadeAgenda.findEventoById(idEvento);
    			}
    			evento.setParticipantes(gestionFacadeAgenda.findAllParticipantes(evento.getEvenId()));
    			if(evento.getParticipantes()!=null&&evento.getParticipantes().size()>0)
    				participante = (Participante) evento.getParticipantes().get(0);
    			estado = ConstantesAplicativo.constanteEstadoOperacionCita;
    			evento.getEvenStartViewFecha();
    			evento.getEvenStartViewHora();
    		}
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
    	System.out.println("######>>>>>>>AgendaAction>>>>calendarioCategoriaMethod>>>>estado salida-->>"+estado);
    	return result;
	}
	
	private void getFuncionPosicionado(){
		if(request.getSession().getAttribute("funcPosicionado")==null){
			request.getSession().setAttribute("funcPosicionado",funcPosicionado);
		}else{
			String funcCambio = (String) request.getSession().getAttribute("funcPosicionado");
			if(!funcPosicionado.equals(funcCambio))
				request.getSession().setAttribute("funcPosicionado",funcPosicionado);
		}
		System.out.println("######>>>>>>>funcPosicionado>>>>"+funcPosicionado);
	}
	
	private void getBandEstadoFuncion(){
		if(request.getSession().getAttribute("bandEstadoFunc")==null){
			request.getSession().setAttribute("bandEstadoFunc",bandEstadoFunc);
		}else{
			String funcCambio = (String) request.getSession().getAttribute("bandEstadoFunc");
			if(bandEstadoFunc!=null&&!bandEstadoFunc.equals(funcCambio))
				request.getSession().setAttribute("bandEstadoFunc",bandEstadoFunc);
		}
		System.out.println("######>>>>>>>bandEstadoFunc>>>>"+bandEstadoFunc);
	}
	
	@SkipValidation
	public String paramCalendarioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>paramCalendarioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listParametroCalendrio = gestionFacadeAgenda.findAllParametroscalendarios();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaVariable()))
    				addActionError(getText("validacion.requerido","pacaVariable","Variable"));
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaValor()))
    				addActionError(getText("validacion.requerido","pacaValor","Valor"));
    			if(!hasActionErrors()){
    				parametroCalendario.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(parametroCalendario);
    				gestionFacadeAgenda.persistParametroscalendario(parametroCalendario);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			parametroCalendario = gestionFacadeAgenda.findParametroscalendarioById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>paramCalendarioMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String jornadaLaboralMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>jornadaLaboralMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listJornadaLaboral = gestionFacadeAgenda.findAllJorandalaborals();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			String idPersona = request.getParameter("idPersona");
    			System.out.println("idPersona:["+idPersona+"]");
    			if(idPersona!=null&&!idPersona.equals("")){
    				persona = gestionFacadeAgenda.findPersonaById(Long.parseLong(idPersona));
    				if(persona!=null){
    					System.out.println("persona : ["+persona.getNombreCompleto()+"]");
    					persona.setProfesional(gestionFacadeAgenda.findAllProfesionalXIdPersona(persona.getIdPers()));
    					if(persona.getProfesional()!=null&&persona.getProfesional().size()>0){
    						for(Profesional elem:persona.getProfesional()){
    							System.out.println("ProfId:["+elem.getProfId()+"]");
    						}
    					}else
    						System.out.println("Persona no tiene profesiones asociadas");
    				}else
    					System.out.println("Persona Null!!!!!!!!");
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaVariable()))
    				addActionError(getText("validacion.requerido","pacaVariable","Variable"));
    			if(ValidaString.isNullOrEmptyString(parametroCalendario.getPacaValor()))
    				addActionError(getText("validacion.requerido","pacaValor","Valor"));
    			if(!hasActionErrors()){
    				parametroCalendario.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(parametroCalendario);
    				gestionFacadeAgenda.persistParametroscalendario(parametroCalendario);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			parametroCalendario = gestionFacadeAgenda.findParametroscalendarioById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>jornadaLaboralMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String profesionalSaludMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>profesionalSaludMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionals();
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoAddSave;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(profesional.getPersona().getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			else
    				profesional.setPersona(gestionFacadeAgenda.findPersonaById(profesional.getPersona().getIdPers()));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfEspecialidad()))
    				addActionError(getText("validacion.requerido","prfsProfesion","Profesi�n"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfNrotarjetaprof()))
    				addActionError(getText("validacion.requerido","prfsNroTarjetaProf","Nro Tarjeta Profesional"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfEstado()))
    				addActionError(getText("validacion.requerido","prfsEstado","Estado"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfBackgroundcoloragen()))
    				addActionError(getText("validacion.requerido","prfsBackgroundcoloragen","Color Representaci�n Agenda"));
    			else if(!gestionFacadeAgenda.validoBackgroundProf(profesional.getProfBackgroundcoloragen()))
    				addActionError(getText("validacion.requerido","prfsBackgroundcoloragen","Color Representaci�n Agenda ya esta asociado a otro profesional"));
    			if(!hasActionErrors()){
    				profesional.setPersona(gestionFacadeAgenda.findPersonaById(profesional.getPersona().getIdPers()));
    				profesional.setDatosAud(this.getDatosAud());
    				profesional.setProfEspecialidadView(((Tipoespecialidad)gestionFacadeHistoriaClinica.findTipoespecialidadById(Long.parseLong(profesional.getProfEspecialidad()))).getTiesEspecialidad());
    				ValidaString.imprimirObject(profesional);
    				gestionFacadeAgenda.persistProfesional(profesional);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				String nameFile = "eventos";
    				String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\"; 
    				boolean resultFile = gestionFacadeAgenda.crearFile(path, nameFile,   
    							ConstantesAplicativo.constanteExtensionFileJS, 
    							ConstantesAplicativo.constanteTipoFileJSConstantesEventos,
    							ConstantesAplicativo.constanteCrearFileJSEventosAll);
    			}else
    				listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			profesional = gestionFacadeAgenda.findProfesionalById(getIdLong());
    			profesional.setProfEspecialidadView(((Tipoespecialidad)gestionFacadeHistoriaClinica.findTipoespecialidadById(Long.parseLong(profesional.getProfEspecialidad()))).getTiesEspecialidad());
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoEditSave;
    			listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>profesionalSaludMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String agendaCategoriaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>agendaMedicaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listAgendaCategoria  = gestionFacadeAgenda.findAllAgendas(ConstantesAplicativo.constanteAgendaCategoria);
    			if(listAgendaCategoria!=null&&listAgendaCategoria.size()>0){
    				for(Agenda elem:listAgendaCategoria){
    					if(elem.getPortafolioCategoria()!=null&&elem.getPortafolioCategoria().getPocaId()>0){
    						archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, elem.getPortafolioCategoria().getPocaId()+"");
    	    				if(archivotabla!=null){
    	        				String rutaAlterna = "/";
    	        				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
    	        				archivotabla.setRutaAlterna(rutaAlterna);
    	        			}else{
    	        				archivotabla = new Archivotabla();
    	        			}
    	    				elem.getPortafolioCategoria().setArchivo(archivotabla);
    	    			}
    	    			archivotabla = null;
    				}
    			}
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoAddSave;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listPortafolioCategoria = gestionFacadeNIIF.findAllPortafoliocategorias();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			SimpleDateFormat sdf = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFecha4);
    			if(agendaCategoria.getPortafolioCategoria().getPocaId()<=0)
    				addActionError(getText("validacion.requerido","pocaId","Portafolio Catalogo"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenFechaini()))
    				addActionError(getText("validacion.requerido","agenfechaini","Fecha Apertura Agenda"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenFechafin()))
    				addActionError(getText("validacion.requerido","agenfechafin","Fecha Cierre Agenda"));
    			else if(!ValidaString.esFechaMayor(sdf.parse(agendaCategoria.getAgenFechafin()), sdf.parse(agendaCategoria.getAgenFechaini()), ConstantesAplicativo.constanteFormatoFecha4))
    				addActionError(getText("validacion.requerido","agenfechafin","Fecha Cierre Agenda debe ser mayor a Fecha Apertura Agenda"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenMintime()))
    				addActionError(getText("validacion.requerido","agenmintime","Hora Apertura Cita"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenMaxtime()))
    				addActionError(getText("validacion.requerido","agenmaxtime","Hora Cierre Cita"));
    			else if(!ValidaString.esHoraMayor(agendaCategoria.getAgenMaxtime(), agendaCategoria.getAgenMintime()))
    				addActionError(getText("validacion.requerido","agenmaxtime","Hora Cierre Cita debe ser mayor a Hora Apertura Cita"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenDuracionevento()))
    				addActionError(getText("validacion.requerido","agendiracionevento","Duraci�n Cita"));
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenScrolltime()))
    				addActionError(getText("validacion.requerido","agenscrolltime","Scroll Time"));
    			if(ValidaString.isNullOrEmptyString(agendaCategoria.getAgenAlldayslot()))
    				addActionError(getText("validacion.requerido","agenalldayslot","Evento Todo el Dia"));
    			else if(agendaCategoria.getAgenAlldayslot().equals("1") && ValidaString.isNullOrEmptyString(agendaCategoria.getAgenAlldaytext()))
    				addActionError(getText("validacion.requerido","agenalldaytext","Etiqueta Evento Todo el Dia"));
    			
    			if(!hasActionErrors()){
    				agendaCategoria.setPortafolioCategoria(gestionFacadeNIIF.findPortafoliocategoriaById(agendaCategoria.getPortafolioCategoria().getPocaId()));
    				String nameFile = "constanteAgendaCate_"+agendaCategoria.getPortafolioCategoria().getPocaId();
    				agendaCategoria.setAgenPathconstantes(nameFile);
    				agendaCategoria.setAddSegundos();
    				agendaCategoria.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(agendaCategoria);
    				long idAgenda = gestionFacadeAgenda.persistAgendaId(agendaCategoria);
    				if(idAgenda>0){
	    				String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\agenda\\"; 
	    				boolean resultFile = gestionFacadeAgenda.crearFile(path, nameFile,   
	    						ConstantesAplicativo.constanteExtensionFileJS, 
	    						ConstantesAplicativo.constanteTipoFileJSConstantesAgenda,
	    						idAgenda+"");
	    				//--------------------------------------------------------------------------------
	    				//21-08-2015 - Victor Gomez
	    				//Ajuste Para Creacion de Archivo de Eventos Agenda
	    				path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\eventosAgenda\\";	
	    				nameFile = "eventosagenda_"+idAgenda;
	    				gestionFacadeAgenda.crearFile(path, nameFile,   
	    						ConstantesAplicativo.constanteExtensionFileJS, 
	    						ConstantesAplicativo.constanteTipoFileJSConstantesEventosxAgenda,
	    						idAgenda+"");
	    				//--------------------------------------------------------------------------------
	    				agendaCategoria.setPortafolioCategoria(gestionFacadeNIIF.findPortafoliocategoriaById(agendaCategoria.getPortafolioCategoria().getPocaId()));
	    				archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, agendaCategoria.getPortafolioCategoria().getPocaId()+"");
	    				if(archivotabla!=null){
	        				String rutaAlterna = "/";
	        				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
	        				archivotabla.setRutaAlterna(rutaAlterna);
	        			}else{
	        				archivotabla = new Archivotabla();
	        			}
	    				agendaCategoria.getPortafolioCategoria().setArchivo(archivotabla);
    				}
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			agendaCategoria= gestionFacadeAgenda.findAgendaById(getIdLong());
    			archivotabla = gestionFacadeNIIF.findArchivotablaByTablaIdRegistro(ConstantesAplicativo.constanteNombreTablaPortafolioCategoria, agendaCategoria.getPortafolioCategoria().getPocaId()+"");
				if(archivotabla!=null){
    				String rutaAlterna = "/";
    				rutaAlterna += archivotabla.getArtaRuta().replace("\\", "/")+"/"+archivotabla.getArtaArchguardado();
    				archivotabla.setRutaAlterna(rutaAlterna);
    			}else{
    				archivotabla = new Archivotabla();
    			}
				agendaCategoria.getPortafolioCategoria().setArchivo(archivotabla);
				listPortafolioCategoria = gestionFacadeNIIF.findAllPortafoliocategorias();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>agendaMedicaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String agendaMedicaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>agendaMedicaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listAgendaMedica  = gestionFacadeAgenda.findAllAgendas(ConstantesAplicativo.constanteAgendaMedica);
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoAddSave;
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			SimpleDateFormat sdf = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFecha4);
    			if(agendaMedica.getProfesional().getPersona().getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			else
    				agendaMedica.setProfesional(gestionFacadeAgenda.findProfesionalIdPersona(agendaMedica.getProfesional().getPersona().getIdPers()));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenFechaini()))
    				addActionError(getText("validacion.requerido","agenfechaini","Fecha Apertura Agenda"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenFechafin()))
    				addActionError(getText("validacion.requerido","agenfechafin","Fecha Cierre Agenda"));
    			else if(!ValidaString.esFechaMayor(sdf.parse(agendaMedica.getAgenFechafin()), sdf.parse(agendaMedica.getAgenFechaini()), ConstantesAplicativo.constanteFormatoFecha4))
    				addActionError(getText("validacion.requerido","agenfechafin","Fecha Cierre Agenda debe ser mayor a Fecha Apertura Agenda"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenMintime()))
    				addActionError(getText("validacion.requerido","agenmintime","Hora Apertura Cita"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenMaxtime()))
    				addActionError(getText("validacion.requerido","agenmaxtime","Hora Cierre Cita"));
    			else if(!ValidaString.esHoraMayor(agendaMedica.getAgenMaxtime(), agendaMedica.getAgenMintime()))
    				addActionError(getText("validacion.requerido","agenmaxtime","Hora Cierre Cita debe ser mayor a Hora Apertura Cita"));
    			
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenDuracionevento()))
    				addActionError(getText("validacion.requerido","agendiracionevento","Duraci�n Cita"));
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenScrolltime()))
    				addActionError(getText("validacion.requerido","agenscrolltime","Scroll Time"));
    			if(ValidaString.isNullOrEmptyString(agendaMedica.getAgenAlldayslot()))
    				addActionError(getText("validacion.requerido","agenalldayslot","Evento Todo el Dia"));
    			else if(agendaMedica.getAgenAlldayslot().equals("1") && ValidaString.isNullOrEmptyString(agendaMedica.getAgenAlldaytext()))
    				addActionError(getText("validacion.requerido","agenalldaytext","Etiqueta Evento Todo el Dia"));
    			
    			if(!hasActionErrors()){
    				agendaMedica.setProfesional(gestionFacadeAgenda.findProfesionalIdPersona(agendaMedica.getProfesional().getPersona().getIdPers()));
    				String nameFile = "constanteAgendaProf_"+agendaMedica.getProfesional().getProfId();
    				agendaMedica.setAgenPathconstantes(nameFile);
    				agendaMedica.setAddSegundos();
    				agendaMedica.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(agendaMedica);
    				long idAgenda = gestionFacadeAgenda.persistAgendaId(agendaMedica);
    				if(idAgenda>0){
	    				String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\agenda\\"; 
	    				boolean resultFile = gestionFacadeAgenda.crearFile(path, nameFile,   
	    						ConstantesAplicativo.constanteExtensionFileJS, 
	    						ConstantesAplicativo.constanteTipoFileJSConstantesAgenda,
	    						idAgenda+"");
	    				//--------------------------------------------------------------------------------
	    				//21-08-2015 - Victor Gomez
	    				//Ajuste Para Creacion de Archivo de Eventos Agenda
	    				path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\eventosAgenda\\";	
	    				nameFile = "eventosagenda_"+idAgenda;
	    				gestionFacadeAgenda.crearFile(path, nameFile,   
	    						ConstantesAplicativo.constanteExtensionFileJS, 
	    						ConstantesAplicativo.constanteTipoFileJSConstantesEventosxAgenda,
	    						idAgenda+"");
	    				//--------------------------------------------------------------------------------
    				}
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			agendaMedica= gestionFacadeAgenda.findAgendaById(getIdLong());
    			bandEstadoFunc = ConstantesAplicativo.constanteEstadoEditSave;
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>agendaMedicaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	@SkipValidation
	public String odontogramaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>odontogramaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			System.out.println("Construccion!!!!!!!!!!");
    			listProcedimiento = gestionFacadeAgenda.findAllProcedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>odontogramaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String servicioClinicoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>servicioClinicoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			request.getSession().removeAttribute("listDiagnostico");
    			request.getSession().removeAttribute("listMedicamento");
    			request.getSession().removeAttribute("listSegmentoAnamnesis");
    			request.getSession().removeAttribute("listRegistroCoverTestLejos");
    			request.getSession().removeAttribute("listRegistroCoverTestCerca");
    			long idProfesional = request.getParameter("idProfesional")!=null?Long.parseLong(request.getParameter("idProfesional").toString()):0;
    			long idEvento = request.getParameter("idEvento")!=null?Long.parseLong(request.getParameter("idEvento").toString()):0;
    			System.out.println("********************************************");
    			System.out.println("********************************************");
    			System.out.println("idProfesional:["+idProfesional+"]");
    			System.out.println("idEvento:["+idEvento+"]");
    			System.out.println("Condicion:["+(idProfesional<=0)+"]");
    			System.out.println("********************************************");
    			System.out.println("********************************************");
    			if(idProfesional<=0){
    				System.out.println("--------------------------------------");
    				System.out.println("Entra Esta Parte!!!!!!!!!!!");
    				if(tipoServicio.getTiseId()<=0)
    					addActionError(getText("validacion.requerido","tiposervicio","Servicio a Realizar"));
    				if(ValidaString.isNullOrEmptyString(persona.getDocumentoPers()))
        				addActionError(getText("validacion.requerido","documentoPers","N�mero Documento"));
        			if(ValidaString.isNullOrEmptyString(persona.getTipodocumento().getAbreviaturaTidoc()))
        				addActionError(getText("validacion.requerido","documentoPers","Tipo Documento"));
        			if(!hasActionErrors()){
        				profesional = gestionFacadeAgenda.findProfesionalById(profesional.getProfId());
        				profesional.setProfEspecialidadView(((Tipoespecialidad)gestionFacadeHistoriaClinica.findTipoespecialidadById(Long.parseLong(profesional.getProfEspecialidad()))).getTiesEspecialidad());
        				String abrevTipoDoc = persona.getTipodocumento().getAbreviaturaTidoc();
        				String nroDocumento = persona.getDocumentoPers();
        				persona = gestionFacadeAgenda.findPersona(persona.getDocumentoPers(), persona.getTipodocumento().getAbreviaturaTidoc());
        				System.out.println("persona:["+persona+"]");
        				if(persona==null){
        					persona = new Persona();
        					Tipodocumento tipoDocumento = (Tipodocumento) gestionFacadeAgenda.findTipodocumentoAbrev(abrevTipoDoc); 
//        					ValidaString.imprimirObject(tipoDocumento);
        					persona.setMunicipio(new Municipio());
        					persona.setTipodocumento(tipoDocumento);
        					persona.setDocumentoPers(nroDocumento);
        					persona.setExistePaciente(ConstantesAplicativo.constanteCheckNo);
        				}else{
        					persona.setExistePaciente(ConstantesAplicativo.constanteCheckSi);
        					paciente = gestionFacadeHistoriaClinica.findPacienteByIdPersona(persona.getIdPers());
//        					if(paciente!=null)
//        						paciente.setExistePaciente(ConstantesAplicativo.constanteCheckSi);
//        					else
//        						paciente.setExistePaciente(ConstantesAplicativo.constanteCheckNo);
        				}
        				cargarDatosServicioClinico(profesional.getProfEspecialidad());
        			}else{
        				estado = ConstantesAplicativo.constanteEstadoAllTipoServicio;
            			listTipoDoc = gestionFacadeAgenda.findAllTipodocumentos();
            			listTipoServicio = gestionFacadeHistoriaClinica.findAllTiposervicios();
            			Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioVO");
            			System.out.println("getIdPers:["+usuario.getPersona().getIdPers()+"]");
            			profesional = gestionFacadeAgenda.findProfesionalIdPersona(usuario.getPersona().getIdPers());
        			}
        			System.out.println("--------------------------------------");
    			}else{
    				System.out.println("--------------------------------------");
    				System.out.println("Entra a la Parte del ELSE !!!!!!!!!!!!!!!!");
	    			profesional = idProfesional>0?gestionFacadeAgenda.findProfesionalById(idProfesional):new Profesional();
	    			profesional.setProfEspecialidadView(((Tipoespecialidad)gestionFacadeHistoriaClinica.findTipoespecialidadById(Long.parseLong(profesional.getProfEspecialidad()))).getTiesEspecialidad());
	    			persona = gestionFacadeAgenda.findPacienteAtencionServicio(idEvento);
	    			cargarDatosServicioClinico(profesional.getProfEspecialidad());
	    			System.out.println("--------------------------------------");
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAllTipoServicio)){
    			listTipoDoc = gestionFacadeAgenda.findAllTipodocumentos();
    			listTipoServicio = gestionFacadeHistoriaClinica.findAllTiposervicios();
    			Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioVO");
    			System.out.println("getIdPers:["+usuario.getPersona().getIdPers()+"]");
    			profesional = gestionFacadeAgenda.findProfesionalIdPersona(usuario.getPersona().getIdPers());
    			request.getSession().removeAttribute("listDiagnostico");
    			request.getSession().removeAttribute("listMedicamento");
    			request.getSession().removeAttribute("listSegmentoAnamnesis");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			System.out.println("Construccion!!!!!!!!!!");
    			System.out.println("Validacion por secciones segun orden prioritario");
    			System.out.println("-------------------------------------------------------");
    			System.out.println("-------------------------------------------------------");
    			System.out.println("Validacion Seccion 1 - Datos Personales");
    			if(ValidaString.isNullOrEmptyString(persona.getDocumentoPers()))
    				addActionError(getText("validacion.requeridoseccion","documentoPers",new ArrayList<String>(Arrays.asList("N�mero Documento", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(persona.getTipodocumento().getIdTidoc()<=0)
    				addActionError(getText("validacion.requeridoseccion","documentoPers",new ArrayList<String>(Arrays.asList("Tipo Documento", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(ValidaString.isNullOrEmptyString(persona.getPnombrePers()))
    				addActionError(getText("validacion.requeridoseccion","pnombrePers",new ArrayList<String>(Arrays.asList("Primer Nombre", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(ValidaString.isNullOrEmptyString(persona.getPapellidoPers()))
    				addActionError(getText("validacion.requeridoseccion","papellidoPers",new ArrayList<String>(Arrays.asList("Primer Apellido", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(ValidaString.isNullOrEmptyString(persona.getSexoPers()))
    				addActionError(getText("validacion.requeridoseccion","sexoPers",new ArrayList<String>(Arrays.asList("Sexo", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(ValidaString.isNullOrEmptyString(persona.getEstadocivilPers()))
    				addActionError(getText("validacion.requeridoseccion","estadoCivilPers",new ArrayList<String>(Arrays.asList("Estado Civil", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			
    			if(ValidaString.isNullOrEmptyString(persona.getFechanacimientoPers()))
    				addActionError(getText("validacion.requeridoseccion","fechaNacimientoPers",new ArrayList<String>(Arrays.asList("Fecha Nacimiento", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			else if(!ValidaString.validarFecha(persona.getFechanacimientoPers()))
    				addActionError(getText("validacion.requeridosecciontipodato","fechaNacimientoPers",new ArrayList<String>(Arrays.asList("Fecha Nacimiento", "Fecha", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));

    			if(ValidaString.isNullOrEmptyString(persona.getTelefonoPers()))
    				addActionError(getText("validacion.requeridoseccion","telefonoPers",new ArrayList<String>(Arrays.asList("Tel�fono", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(!ValidaString.isEmail(persona.getEmailPers()))
    				addActionError(getText("validacion.requeridoseccion","emailPers",new ArrayList<String>(Arrays.asList("Correo El�ctronico", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(persona.getMunicipio().getMcpoId()<=0)
    				addActionError(getText("validacion.requeridoseccion","ubicacionPers",new ArrayList<String>(Arrays.asList("Ubicaci�n Geogr�fica", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(ValidaString.isNullOrEmptyString(persona.getDireccionPers()))
    				addActionError(getText("validacion.requeridoseccion","direccionPers",new ArrayList<String>(Arrays.asList("Direcci�n", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			if(ValidaString.isNullOrEmptyString(paciente.getPaciOcupacion()))
    				addActionError(getText("validacion.requeridoseccion","paciOcupacion",new ArrayList<String>(Arrays.asList("Ocupaci�n", ConstantesAplicativo.constanteNombreSeccionDatosPersonales))));
    			System.out.println("-------------------------------------------------------");
    			System.out.println("-------------------------------------------------------");
    			
    			System.out.println("-------------------------------------------------------");
    			System.out.println("-------------------------------------------------------");
    			System.out.println("Validacion Seccion 2 - Datos Clinicos");
    			if(finalidad.getFinaId()<=0)
    				addActionError(getText("validacion.requeridoseccion","finaId",new ArrayList<String>(Arrays.asList("Finalidad", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    			if(motivo.getMotiId()<=0)
    				addActionError(getText("validacion.requeridoseccion","motiId",new ArrayList<String>(Arrays.asList("Motivo", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    			if(seguridadSocial.getSeguId()<=0)
    				addActionError(getText("validacion.requeridoseccion","seguId",new ArrayList<String>(Arrays.asList("Seguridad Social", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    			System.out.println("listSegmentoAnamnesis:["+listSegmentoAnamnesis+"]");
    			if(listSegmentoAnamnesis!=null&&listSegmentoAnamnesis.size()>0){
    				System.out.println("listSegmentoAnamnesis.size():["+listSegmentoAnamnesis.size()+"]");
    				for(Segmentoanamnesi elem:listSegmentoAnamnesis){
    					System.out.println("elem.getPreguntas():["+elem.getPreguntas()+"]");
    					if(elem.getPreguntas()!=null&&elem.getPreguntas().size()>0){
    						System.out.println("elem.getPreguntas().size():["+elem.getPreguntas().size()+"]");
    						for(Pregunta elem1:elem.getPreguntas()){
    							System.out.println("elem1.getRespuestas():["+elem1.getRespuestas()+"]");
    							if(elem1.getRespuestas()!=null&&elem1.getRespuestas().size()>0){
    								System.out.println("elem1.getRespuestas().size():["+elem1.getRespuestas().size()+"]");
    								for(Respuesta elem2:elem1.getRespuestas()){
    									System.out.println("elem1.getPregRespobligatoria():["+elem1.getPregRespobligatoria()+"]");
    									System.out.println("elem1.getRespRespuesta():["+elem2.getRespRespuesta()+"]");
    									if(elem1.getPregRespobligatoria().equals(ConstantesAplicativo.constanteRespObligatoriaSI)){
    										if(ValidaString.isNullOrEmptyString(elem2.getRespRespuesta()))
    						    				addActionError(getText("validacion.pregrequerida","respRespuesta",new ArrayList<String>(Arrays.asList(elem1.getPregPregunta(),elem.getSeanEtiqueta(), ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    									}
    									if(elem1.getPregTipodato().equals(ConstantesAplicativo.constanteTipoDatoAlfanumerico)){
    										if(!ValidaString.alfanumerico(elem2.getRespRespuesta()))
    											addActionError(getText("validacion.tipodato","respRespuesta",new ArrayList<String>(Arrays.asList(elem1.getPregPregunta(),"Alfanum�rico", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    									}else if(elem1.getPregTipodato().equals(ConstantesAplicativo.constanteTipoDatoNumerico)){
    										if(!ValidaString.isNumeric(elem2.getRespRespuesta()))
    											addActionError(getText("validacion.tipodato","respRespuesta",new ArrayList<String>(Arrays.asList(elem1.getPregPregunta(),"Num�rico", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    									}else if(elem1.getPregTipodato().equals(ConstantesAplicativo.constanteTipoDatoFecha)){
    										if(!ValidaString.validarFecha(elem2.getRespRespuesta()))
    											addActionError(getText("validacion.tipodato","respRespuesta",new ArrayList<String>(Arrays.asList(elem1.getPregPregunta(),"Fecha", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    									}else if(elem1.getPregTipodato().equals(ConstantesAplicativo.constanteTipoDatoEntero)){
    										if(!ValidaString.isEntero(elem2.getRespRespuesta()))
    											addActionError(getText("validacion.tipodato","respRespuesta",new ArrayList<String>(Arrays.asList(elem1.getPregPregunta(),"Entero", ConstantesAplicativo.constanteNombreSeccionDatosClinicos))));
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    			System.out.println("-------------------------------------------------------");
    			System.out.println("-------------------------------------------------------");
    			
    			
    			
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("Validacion Seccion 3 - Examenes especificos de cada especialidad");
    			//----------------------------------------------------------------//
    			//  Datos Especificos segun especialidad desempenada profesional  //
    			//----------------------------------------------------------------//
    			String especialidad = profesional.getProfEspecialidad();
    			if(especialidad!=null){
    				listExamenEspecialidad = gestionFacadeHistoriaClinica.findAllExamenespecialidads(Long.parseLong(especialidad));
    				if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadMedicinaGeneral)){
    					System.out.println("en Construcci�n");
    				}else if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadOdontologia)){
    					System.out.println("en Construcci�n");
    				}else if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadOptometria)){
    					for(Examenespecialidad elem:listExamenEspecialidad){	
    						if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveRXUSO)){
		    					// 1. Validacion Examen Rx en Uso
		    					//---Ojo Derecho -- OD -----
		    					if(ValidaString.isNullOrEmptyString(rxUsoOD.getReruEsfera()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruEsfera",new ArrayList<String>(Arrays.asList("Esfera OD", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOD.getReruCilindro()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruCilindro",new ArrayList<String>(Arrays.asList("Cilindro OD", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOD.getReruEje()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruEje",new ArrayList<String>(Arrays.asList("Eje OD", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOD.getReruAvl()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruAvl",new ArrayList<String>(Arrays.asList("AVL OD", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOD.getReruAvc()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruAvc",new ArrayList<String>(Arrays.asList("AVC OD", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//---Ojo Izquierdo -- OI -----
		    					if(ValidaString.isNullOrEmptyString(rxUsoOI.getReruEsfera()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruEsfera",new ArrayList<String>(Arrays.asList("Esfera OI", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOI.getReruCilindro()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruCilindro",new ArrayList<String>(Arrays.asList("Cilindro OI", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOI.getReruEje()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruEje",new ArrayList<String>(Arrays.asList("Eje OI", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOI.getReruAvl()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruAvl",new ArrayList<String>(Arrays.asList("AVL OI", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(rxUsoOI.getReruAvc()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruAvc",new ArrayList<String>(Arrays.asList("AVC OI", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					// Ambos Ojos
		    					if(ValidaString.isNullOrEmptyString(rxUsoOI.getReruAdd()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reruAdd",new ArrayList<String>(Arrays.asList("ADD", ConstantesAplicativo.constanteNombreExamenOptometriaRXUSO, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//------------------------------------------
		    					//------------------------------------------
    						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveAVSC)){
		    					// 2. Validacion Examen AVSC
		    					//---Ojo Derecho -- OD -----
		    					if(ValidaString.isNullOrEmptyString(avscOD.getAvscAvl()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","avscAvl",new ArrayList<String>(Arrays.asList("AVL OD", ConstantesAplicativo.constanteNombreExamenOptometriaAVSC, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(avscOD.getAvscAvc()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","avscAvc",new ArrayList<String>(Arrays.asList("AVC OD", ConstantesAplicativo.constanteNombreExamenOptometriaAVSC, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//---Ojo Izquierdo -- OI -----
		    					if(ValidaString.isNullOrEmptyString(avscOI.getAvscAvl()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","avscAvl",new ArrayList<String>(Arrays.asList("AVL OI", ConstantesAplicativo.constanteNombreExamenOptometriaAVSC, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					if(ValidaString.isNullOrEmptyString(avscOI.getAvscAvc()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","avscAvc",new ArrayList<String>(Arrays.asList("AVC OI", ConstantesAplicativo.constanteNombreExamenOptometriaAVSC, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//------------------------------------------
		    					//------------------------------------------
    						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveCoverTest)){
		    					// 3. Validacion Examen Cover Test
		    					System.out.println("En Construccion!!!!!!!");
		    					//------------------------------------------
		    					//------------------------------------------
    						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveExamenExterno)){
		    					// 4. Validacion Examen Externo
		    					//---Ojo Derecho -- OD -----
		    					if(ValidaString.isNullOrEmptyString(examenExternoOD.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OD", ConstantesAplicativo.constanteNombreExamenOptometriaExamenExterno, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//---Ojo Izquierdo -- OI -----
		    					//------------------------------------------
		    					if(ValidaString.isNullOrEmptyString(examenExternoOI.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OI", ConstantesAplicativo.constanteNombreExamenOptometriaExamenExterno, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//------------------------------------------
		    					//------------------------------------------
    						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveOftalmoscopia)){
		    					// 5. Validacion Examen Oftalmoscopia
		    					//---Ojo Derecho -- OD -----
		    					if(ValidaString.isNullOrEmptyString(oftalmoscopiaOD.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OD", ConstantesAplicativo.constanteNombreExamenOptometriaOftalmoscopia, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//---Ojo Izquierdo -- OI -----
		    					if(ValidaString.isNullOrEmptyString(oftalmoscopiaOI.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OI", ConstantesAplicativo.constanteNombreExamenOptometriaOftalmoscopia, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//------------------------------------------
		    					//------------------------------------------
    						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveKeratometria)){
		    					// 6. Validacion Examen Keratometria
		    					//---Ojo Derecho -- OD -----
		    					if(ValidaString.isNullOrEmptyString(keratometriaOD.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OD", ConstantesAplicativo.constanteNombreExamenOptometriaKeratometria, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//---Ojo Izquierdo -- OI -----
		    					//------------------------------------------
		    					if(ValidaString.isNullOrEmptyString(keratometriaOI.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OI", ConstantesAplicativo.constanteNombreExamenOptometriaKeratometria, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//------------------------------------------
		    					//------------------------------------------
    						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveRetinoscopia)){
		    					// 7. Validacion Examen Retinoscopia
		    					//---Ojo Derecho -- OD -----
		    					if(ValidaString.isNullOrEmptyString(retinoscopiaOD.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OD", ConstantesAplicativo.constanteNombreExamenOptometriaRetinoscopia, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
		    					//---Ojo Izquierdo -- OI -----
		    					//------------------------------------------
		    					if(ValidaString.isNullOrEmptyString(retinoscopiaOI.getReesValor()))
		    	    				addActionError(getText("validacion.requeridoseccionexamen","reesValor",new ArrayList<String>(Arrays.asList("OI", ConstantesAplicativo.constanteNombreExamenOptometriaRetinoscopia, ConstantesAplicativo.constanteNombreSeccionExamenesOptometria))));
    						}
    					}
    				}
    			}
    			//-------------------------------------------------------------------------//
    			//  Datos Especificos segun especialidad en realcion a los datos clinicos  //
    			//-------------------------------------------------------------------------//
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("----------------------------------------------------------------");
    			
    			
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("Validacion Seccion 4 - Diagnostico Principal y Relacional");
    			listDiagnostico = (List<Diagnostico>) request.getSession().getAttribute("listDiagnostico");
    			System.out.println("listDiagnostico:["+listDiagnostico+"]");
    			if(listDiagnostico==null){
    				listDiagnostico = new ArrayList<Diagnostico>();
    				addActionError(getText("validacion.requeridoseccion","documentoPers",new ArrayList<String>(Arrays.asList("Diagn�sticos", ConstantesAplicativo.constanteNombreSeccionDiagnostico))));
    			}else{
    				int bandDiagnostico = 0;
    				for(Diagnostico elem:listDiagnostico){
    					System.out.println("Codigo Enfermedad:["+(elem.getCodigoenfermedade()!=null?(elem.getCodigoenfermedade().getCoenId()+"-"+elem.getCodigoenfermedade().getCoenCodigo()):"NULL")+"]");
    					System.out.println("Clase Diagnostico:["+(elem.getClasediagnostico()!=null?(elem.getClasediagnostico().getCldiId()+"-"+elem.getClasediagnostico().getCldiNombre()):"NULL")+"]");
    					System.out.println("Tipo Diagnostico:["+(elem.getTipodiagnostico()!=null?(elem.getTipodiagnostico().getTidiId()+"-"+elem.getTipodiagnostico().getTidiNombre()):"NULL")+"]");
    					System.out.println("Orden Diagnostico:["+elem.getDiagOrden()+"]");
    					System.out.println("bandDiagnostico:["+bandDiagnostico+"]");
    					if(elem.getTipodiagnostico()!=null)
    						bandDiagnostico=5;
    					else
    						bandDiagnostico--;
    					System.out.println("bandDiagnostico:["+bandDiagnostico+"]");
    				}
    				if(bandDiagnostico<=0)
    					addActionError(getText("validacion.requeridoseccion","documentoPers",new ArrayList<String>(Arrays.asList("Diagn�stico Principal", ConstantesAplicativo.constanteNombreSeccionDiagnostico))));
    			}
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("----------------------------------------------------------------");	
    			
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("Validacion Seccion 4 - Elementos");
    			
    			System.out.println("----------------------------------------------------------------");
    			System.out.println("----------------------------------------------------------------");	
    			
    			
    			if(!hasActionErrors()){
    				persona.setDatosAud(getDatosAud());
//    				ValidaString.imprimirObject(persona);
//    				ValidaString.imprimirObject(persona.getMunicipio());
//    				ValidaString.imprimirObject(persona.getTipodocumento());
    				//0. Realizar la Insercion o Actualizacion si es el caso de la persona que actua como paciente
    				long idPersona = gestionFacadeAgenda.persistPersonaId(persona);
    				System.out.println("****************************");
    				System.out.println("idPersona:["+idPersona+"]");
    				System.out.println("****************************");
    				if(idPersona>0){
    					persona.setIdPers(idPersona);
    					paciente.setPersona(persona);
    					paciente.setDatosAud(getDatosAud());
    					ValidaString.imprimirObject(paciente);
    					long idPaciente = gestionFacadeHistoriaClinica.persistPacienteId(paciente);
    					System.out.println("****************************");
        				System.out.println("idPaciente:["+idPaciente+"]");
        				System.out.println("****************************");
        				if(idPaciente>0){
        					tipoServicio = gestionFacadeHistoriaClinica.findTiposervicioById(Long.parseLong(profesional.getProfEspecialidad()));
        					paciente.setPaciId(idPaciente);
        					//1. Realizar la Insercion del Servicio
        					
        					System.out.println("***************************************************");
        					System.out.println("***************************************************");
        					System.out.println("paciente.getPaciId():["+paciente.getPaciId()+"]");
        					System.out.println("profesional.getProfId():["+profesional.getProfId()+"]");
        					System.out.println("tipoServicio.getTiseId():["+tipoServicio.getTiseId()+"]");
        					System.out.println("motivo.getMotiId():["+motivo.getMotiId()+"]");
        					System.out.println("finalidad.getFinaId():["+finalidad.getFinaId()+"]");
        					System.out.println("seguridadSocial.getSeguId():["+seguridadSocial.getSeguId()+"]");
        					System.out.println("Fecha Hora Ingreso:["+ValidaString.fechaSystem()+" "+ValidaString.horaSystem()+"]");
        					System.out.println("Fecha Hora Salida:["+ValidaString.fechaSystem()+" "+ValidaString.horaSystem()+"]");
        					System.out.println("***************************************************");
        					System.out.println("***************************************************");
        					
        					servicio = new Servicio();
        					servicio.setProfesional(profesional);
        					servicio.setPaciente(paciente);
        					servicio.setTiposervicio(tipoServicio);
        					servicio.setMotivo(motivo);
        					servicio.setFinalidad(finalidad);
        					servicio.setSeguridadsocial(seguridadSocial);
        					servicio.setServFechahoraingreso(ValidaString.fechaSystem()+" "+ValidaString.horaSystem());
        					servicio.setServFechahorasalida(ValidaString.fechaSystem()+" "+ValidaString.horaSystem());
        					servicio.setDatosAud(getDatosAud());
//        					ValidaString.imprimirObject(servicio);
        					long idServicio = gestionFacadeHistoriaClinica.persistServicioId(servicio);
        					System.out.println("****************************");
            				System.out.println("idServicio:["+idServicio+"]");
            				System.out.println("****************************");
            				if(idServicio>0){
            					servicio.setServId(idServicio);
            					//2. Insercion Preguntas Historia Clinica
            					for(Segmentoanamnesi elem:listSegmentoAnamnesis){
            						System.out.println("Entra esta Parte!!!!!!");
            						System.out.println("Segmentoanamnesi elem:["+elem+"]");
            						if(elem.getPreguntas()!=null&&elem.getPreguntas().size()>0){
            							System.out.println("elem.getPreguntas().size():["+elem.getPreguntas().size()+"]");
            							for(Pregunta elem1:elem.getPreguntas()){
            								Respuesta resp =  (Respuesta)elem1.getRespuestas().get(0);
            								resp.setServicio(servicio);
            								resp.setPregunta(elem1);
            								resp.setDatosAud(getDatosAud());
            								System.out.println("Servicio:["+resp.getServicio().getServId()+"]");
            								System.out.println("Pregunta: ["+resp.getPregunta().getPregId()+"]");
            								System.out.println("Respuesta:["+resp.getRespRespuesta()+"]");
            								//gestionFacadeHistoriaClinica.persistRespuesta((Respuesta)elem1.getRespuestas().get(0));
            								ValidaString.imprimirObject(resp);
            								gestionFacadeHistoriaClinica.persistRespuesta(resp);
            							}
            						}
            					}
            					//3. Insercion examenes segun especialidad
                				if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadMedicinaGeneral)){
                					System.out.println("en Construcci�n");
                				}else if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadOdontologia)){
                					System.out.println("en Construcci�n");
                				}else if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadOptometria)){
                					long idExamOpt = 0;
                					for(Examenespecialidad elem:listExamenEspecialidad){
                						if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveRXUSO)){
                							examenOptometria = new Examenoptometria();
                							examenOptometria.setServicio(servicio);
                							examenOptometria.setDatosAud(getDatosAud());
                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
            		    					if(idExamenOpt>0){
            		    						examenOptometria.setExopId(idExamenOpt);
	            		    					//---Ojo Derecho -- OD -----
	                							rxUsoOD.setExamenoptometria(examenOptometria);
	                							rxUsoOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
	                							rxUsoOD.setDatosAud(getDatosAud());
	                							gestionFacadeHistoriaClinica.persistRegistrorxuso(rxUsoOD);
	            		    					//---Ojo Izquierdo -- OI -----
	                							rxUsoOI.setExamenoptometria(examenOptometria);
	                							rxUsoOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
	                							rxUsoOI.setDatosAud(getDatosAud());
	                							gestionFacadeHistoriaClinica.persistRegistrorxuso(rxUsoOI);
	                							// Ambos Ojos
	                							rxUsoOI.cleanAmbosOjos();
	                							rxUsoOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoODI));
	                							gestionFacadeHistoriaClinica.persistRegistrorxuso(rxUsoOI);
            		    					}
                						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveAVSC)){
                							examenOptometria = new Examenoptometria();
                							examenOptometria.setServicio(servicio);
                							examenOptometria.setDatosAud(getDatosAud());
                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
            		    					if(idExamenOpt>0){
            		    						examenOptometria.setExopId(idExamenOpt);
            		    						//---Ojo Derecho -- OD -----
            		    						avscOD.setExamenoptometria(examenOptometria);
            		    						avscOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
            		    						avscOD.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroavsc(avscOD);
            		    						//---Ojo Izquierdo -- OI -----
            		    						avscOI.setExamenoptometria(examenOptometria);
            		    						avscOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
            		    						avscOI.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroavsc(avscOI);
            		    					}
                						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveCoverTest)){
                							listRegistroCoverTestLejos = (List<Registrocovertest>) request.getSession().getAttribute("listRegistroCoverTestLejos");
                							listRegistroCoverTestCerca = (List<Registrocovertest>) request.getSession().getAttribute("listRegistroCoverTestCerca");
                							if((listRegistroCoverTestLejos!=null&&listRegistroCoverTestLejos.size()>0)||(listRegistroCoverTestCerca!=null&&listRegistroCoverTestCerca.size()>0)){
	                							examenOptometria = new Examenoptometria();
	                							examenOptometria.setServicio(servicio);
	                							examenOptometria.setDatosAud(getDatosAud());
	                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
	            		    					if(idExamenOpt>0){
	            		    						examenOptometria.setExopId(idExamenOpt);
	            		    						if(listRegistroCoverTestLejos!=null&&listRegistroCoverTestLejos.size()>0){
		            		    						for(Registrocovertest regCTLejos: listRegistroCoverTestLejos){
		            		    							regCTLejos.setExamenoptometria(examenOptometria);
		            		    							regCTLejos.setDatosAud(getDatosAud());
		            		    							gestionFacadeHistoriaClinica.persistRegistrocovertest(regCTLejos);
		            		    						}
	            		    						}
	            		    						if(listRegistroCoverTestCerca!=null&&listRegistroCoverTestCerca.size()>0){
	            		    							for(Registrocovertest regCTCerca: listRegistroCoverTestCerca){
	            		    								regCTCerca.setExamenoptometria(examenOptometria);
	            		    								regCTCerca.setDatosAud(getDatosAud());
		            		    							gestionFacadeHistoriaClinica.persistRegistrocovertest(regCTCerca);
		            		    						}
	            		    						}
	            		    					}
                							}
            		    					//------------------------------------------
            		    					//------------------------------------------
                						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveExamenExterno)){
                							examenOptometria = new Examenoptometria();
                							examenOptometria.setServicio(servicio);
                							examenOptometria.setDatosAud(getDatosAud());
                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
            		    					if(idExamenOpt>0){
            		    						examenOptometria.setExopId(idExamenOpt);
            		    						Tipoexamenopt tipoExOpt = gestionFacadeHistoriaClinica.findTipoexamenoptAbreviatura(ConstantesAplicativo.constantePalabraClaveExamenExterno);
	            		    					//---Ojo Derecho -- OD -----
            		    						examenExternoOD.setExamenoptometria(examenOptometria);
            		    						examenExternoOD.setTipoexamenopt(tipoExOpt);
            		    						examenExternoOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
            		    						examenExternoOD.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(examenExternoOD);
	            		    					//---Ojo Izquierdo -- OI -----
            		    						examenExternoOI.setExamenoptometria(examenOptometria);
            		    						examenExternoOI.setTipoexamenopt(tipoExOpt);
            		    						examenExternoOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
            		    						examenExternoOI.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(examenExternoOI);
            		    					}
                						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveOftalmoscopia)){
                							examenOptometria = new Examenoptometria();
                							examenOptometria.setServicio(servicio);
                							examenOptometria.setDatosAud(getDatosAud());
                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
            		    					if(idExamenOpt>0){
            		    						examenOptometria.setExopId(idExamenOpt);
            		    						Tipoexamenopt tipoExOpt = gestionFacadeHistoriaClinica.findTipoexamenoptAbreviatura(ConstantesAplicativo.constantePalabraClaveOftalmoscopia);
	            		    					//---Ojo Derecho -- OD -----
            		    						oftalmoscopiaOD.setExamenoptometria(examenOptometria);
            		    						oftalmoscopiaOD.setTipoexamenopt(tipoExOpt);
            		    						oftalmoscopiaOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
            		    						oftalmoscopiaOD.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(oftalmoscopiaOD);
	            		    					//---Ojo Izquierdo -- OI -----
            		    						oftalmoscopiaOI.setExamenoptometria(examenOptometria);
            		    						oftalmoscopiaOI.setTipoexamenopt(tipoExOpt);
            		    						oftalmoscopiaOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
            		    						oftalmoscopiaOI.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(oftalmoscopiaOI);
            		    					}
                						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveKeratometria)){
                							examenOptometria = new Examenoptometria();
                							examenOptometria.setServicio(servicio);
                							examenOptometria.setDatosAud(getDatosAud());
                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
            		    					if(idExamenOpt>0){
            		    						examenOptometria.setExopId(idExamenOpt);
            		    						Tipoexamenopt tipoExOpt = gestionFacadeHistoriaClinica.findTipoexamenoptAbreviatura(ConstantesAplicativo.constantePalabraClaveKeratometria);
	            		    					//---Ojo Derecho -- OD -----
            		    						keratometriaOD.setExamenoptometria(examenOptometria);
            		    						keratometriaOD.setTipoexamenopt(tipoExOpt);
            		    						keratometriaOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
            		    						keratometriaOD.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(keratometriaOD);
	            		    					//---Ojo Izquierdo -- OI -----
            		    						keratometriaOI.setExamenoptometria(examenOptometria);
            		    						keratometriaOI.setTipoexamenopt(tipoExOpt);
            		    						keratometriaOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
            		    						keratometriaOI.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(keratometriaOI);
            		    					}
                						}else if(elem.getExesPalabraclave().equals(ConstantesAplicativo.constantePalabraClaveRetinoscopia)){
                							examenOptometria = new Examenoptometria();
                							examenOptometria.setServicio(servicio);
                							examenOptometria.setDatosAud(getDatosAud());
                							long idExamenOpt = gestionFacadeHistoriaClinica.persistExamenoptometriaId(examenOptometria);
            		    					if(idExamenOpt>0){
            		    						examenOptometria.setExopId(idExamenOpt);
            		    						Tipoexamenopt tipoExOpt = gestionFacadeHistoriaClinica.findTipoexamenoptAbreviatura(ConstantesAplicativo.constantePalabraClaveRetinoscopia);
	            		    					//---Ojo Derecho -- OD -----
            		    						retinoscopiaOD.setExamenoptometria(examenOptometria);
            		    						retinoscopiaOD.setTipoexamenopt(tipoExOpt);
            		    						retinoscopiaOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
            		    						retinoscopiaOD.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(retinoscopiaOD);
	            		    					//---Ojo Izquierdo -- OI -----
            		    						retinoscopiaOI.setExamenoptometria(examenOptometria);
            		    						retinoscopiaOI.setTipoexamenopt(tipoExOpt);
            		    						retinoscopiaOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
            		    						retinoscopiaOI.setDatosAud(getDatosAud());
            		    						gestionFacadeHistoriaClinica.persistRegistroexamensimple(retinoscopiaOI);
            		    					}
                						}
                					}
                				}
            					
                				//4. Insercion Diagnosticos
                				long orden = 0;
                				for(Diagnostico elem: listDiagnostico){
                					elem.setServicio(servicio);
                					elem.setDiagOrden(orden);
                					elem.setDatosAud(getDatosAud());
                					gestionFacadeHistoriaClinica.persistDiagnostico(elem);
                					orden++;
                				}
                				
            					//5. Insercion de Formulacion
                				//5.0 Insercion Formulacion
                				//5.1 Insercion Medicamentos
                				//5.2 Insercion Elementos segun especialidad
                				listMedicamento = (ArrayList<Medicamento>)request.getSession().getAttribute("listMedicamento");
                				if(listMedicamento!=null&&listMedicamento.size()>0){
                					//Formulacion
                					Formulacion formulacionMedi = new Formulacion();
                					formulacionMedi.setServicio(servicio);
                					formulacionMedi.setTipoformulacion(gestionFacadeHistoriaClinica.findTipoformulacionById(ConstantesAplicativo.constanteIdTipoFormulacionMedi));
                					formulacionMedi.setDatosAud(getDatosAud());
                					long idFormulacionMedi = gestionFacadeHistoriaClinica.persistFormulacionId(formulacionMedi);
                					if(idFormulacionMedi>0){
                						formulacionMedi.setFormId(idFormulacionMedi);
                						//Insercion de Medicamentos
                						for(Medicamento elem:listMedicamento){
                							elem.setFormulacion(formulacionMedi);
                							elem.setDatosAud(getDatosAud());
                							gestionFacadeHistoriaClinica.persistMedicamento(elem);
                						}
                					}
                				}
                				
                				//Formulacion
            					Formulacion formulacionElem = new Formulacion();
            					formulacionElem.setServicio(servicio);
            					formulacionElem.setTipoformulacion(gestionFacadeHistoriaClinica.findTipoformulacionById(ConstantesAplicativo.constanteIdTipoFormulacionElem));
            					formulacionElem.setDatosAud(getDatosAud());
            					long idFormulacionElem = gestionFacadeHistoriaClinica.persistFormulacionId(formulacionElem);
            					if(idFormulacionElem>0){
            						formulacionElem.setFormId(idFormulacionElem);
            						//Insercion de Elemento Gafas
            						//---Ojo Derecho -- OD -----
        							gafaOD.setFormulacion(formulacionElem);
        							gafaOD.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOD));
        							gafaOD.setDatosAud(getDatosAud());
        							gestionFacadeHistoriaClinica.persistGafa(gafaOD);
        							//---Ojo Izquierdo -- OI -----
        							gafaOI.setFormulacion(formulacionElem);
        							gafaOI.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoOI));
        							gafaOI.setDatosAud(getDatosAud());
        							gestionFacadeHistoriaClinica.persistGafa(gafaOI);
        							// Ambos Ojos
        							gafaAmbosOjos.setFormulacion(formulacionElem);
        							gafaAmbosOjos.setEspecificacionpartecuerpo(gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(ConstantesAplicativo.constanteEspParteCuerpoODI));
        							gafaAmbosOjos.setDatosAud(getDatosAud());
        							gestionFacadeHistoriaClinica.persistGafa(gafaAmbosOjos);
            					}
                				
            				}
        				}
    					estado = ConstantesAplicativo.constanteEstadoAbstract;
    					addActionMessage(getText("accion.satisfactoria"));
    				}
    			}else{
    				System.out.println("Se requiere algun tipo de dato!!!!!!!!!!!!!!!!!");
    				long idProfesional = request.getParameter("idProfesional")!=null?Long.parseLong(request.getParameter("idProfesional").toString())
    						:profesional!=null&&profesional.getProfId()>0?profesional.getProfId():0;
        			long idEvento = request.getParameter("idEvento")!=null?Long.parseLong(request.getParameter("idEvento").toString()):0;
        			
        			System.out.println("----------------------------------------------------------");
        			System.out.println("idProfesional:["+idProfesional+"]");
        			System.out.println("idEvento:["+idEvento+"]");
        			System.out.println("getDocumentoPers:["+persona.getDocumentoPers()+"]");
        			System.out.println("getAbreviaturaTidoc:["+persona.getTipodocumento().getAbreviaturaTidoc()+"]");
        			System.out.println("----------------------------------------------------------");
        			
        			profesional = idProfesional>0?gestionFacadeAgenda.findProfesionalById(idProfesional):new Profesional();
        			//persona = idEvento>0?gestionFacadeAgenda.findPacienteAtencionServicio(idEvento):gestionFacadeAgenda.findPersona(persona.getDocumentoPers(), persona.getTipodocumento().getAbreviaturaTidoc());
        			cargarDatosServicioClinico(profesional.getProfEspecialidad());
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			System.out.println("Construccion!!!!!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAddGrid)||estado.equals(ConstantesAplicativo.constanteEstadoDeleteGrid)){
    			String posList = (String)request.getParameter("posList");
//    			String tipoGrid = (String)request.getParameter("tipo");
//    			if(tipoGrid!=null&&!tipoGrid.equals("")){
//    				if(tipoGrid.equals(ConstantesAplicativo.constanteTipoGridMedicamentos)){
		    			listMedicamento = (ArrayList<Medicamento>)request.getSession().getAttribute("listMedicamento");
		    			if(listMedicamento==null)
		    				listMedicamento = new ArrayList<Medicamento>();
		    			if(posList==null){//Agregar en Grilla 
		    				if(ValidaString.isNullOrEmptyString(medicamento.getMediMedicamento()))
		        				addActionError(getText("validacion.requerido","mediMedicamento","Medicamento"));
		    				if(ValidaString.isNullOrEmptyString(medicamento.getMediPresentacion()))
		        				addActionError(getText("validacion.requerido","mediPresentacion","Presentaci�n"));
		    				if(ValidaString.isNullOrEmptyString(medicamento.getMediCantidad()))
		        				addActionError(getText("validacion.requerido","mediCantidad","Cantidad"));
		    				if(ValidaString.isNullOrEmptyString(medicamento.getMediDosis()))
		        				addActionError(getText("validacion.requerido","mediDosis","Dosis"));
		    				if(ValidaString.isNullOrEmptyString(medicamento.getMediIntervalo()))
		        				addActionError(getText("validacion.requerido","mediIntervalo","Intervalo"));
		        			if(!hasActionErrors()){
		    					Medicamento obj = new Medicamento(); 
			    				obj.setMediMedicamento(medicamento.getMediMedicamento());
			    				obj.setMediPresentacion(medicamento.getMediPresentacion());
			    				obj.setMediCantidad(medicamento.getMediCantidad());
			    				obj.setMediDosis(medicamento.getMediDosis());
			    				obj.setMediIntervalo(medicamento.getMediIntervalo());
			    				listMedicamento.add(obj);
			    				medicamento = new Medicamento(); 
		    				}
		    			}else{//Eliminar en Grilla
		    				listMedicamento.remove(Integer.parseInt(posList));
		    			}
		    			request.getSession().setAttribute("listMedicamento", listMedicamento);
//    				}
//    			}
				long idProfesional = request.getParameter("idProfesional")!=null?Long.parseLong(request.getParameter("idProfesional").toString())
						:profesional!=null&&profesional.getProfId()>0?profesional.getProfId():0;
    			long idEvento = request.getParameter("idEvento")!=null?Long.parseLong(request.getParameter("idEvento").toString()):0;
    			profesional = idProfesional>0?gestionFacadeAgenda.findProfesionalById(idProfesional):new Profesional();
    			//persona = idEvento<=0?gestionFacadeAgenda.findPacienteAtencionServicio(idEvento):gestionFacadeAgenda.findPersona(persona.getDocumentoPers(), persona.getTipodocumento().getAbreviaturaTidoc());
    			cargarDatosServicioClinico(profesional.getProfEspecialidad());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>servicioClinicoMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	private void cargarDatosServicioClinico(String especialidad) throws Exception {
		listMedicamento = (ArrayList<Medicamento>)request.getSession().getAttribute("listMedicamento");
		listDiagnostico = (List<Diagnostico>) request.getSession().getAttribute("listDiagnostico");
		//------------------------------------------------------//
		//  Datos Genericos Para todo Tipo de Historia Clinica  //
		//------------------------------------------------------//
		listTipoDoc = gestionFacadeAgenda.findAllTipodocumentos();
		listEstadoCivil = ConstantesAplicativo.constanteEstadoCivil;
		listPais = gestionFacadeAgenda.findAllPaiss();
		listDepartamento = gestionFacadeAgenda.findAllDepartamentos();
		if(persona!=null&&persona.getExistePaciente().equals(ConstantesAplicativo.constanteCheckSi))
			listMunicipio = gestionFacadeAgenda.findAllMunicipios();
		listFinalidad = gestionFacadeHistoriaClinica.findAllFinalidads();
		listMotivo = gestionFacadeHistoriaClinica.findAllMotivos();
		listSeguridadSocial = gestionFacadeHistoriaClinica.findAllSeguridadsocials();
		listExamenEspecialidad = gestionFacadeHistoriaClinica.findAllExamenespecialidads(Long.parseLong(especialidad));
		listTipoDiagnostico = gestionFacadeHistoriaClinica.findAllTipodiagnosticos();
		
		//----------------------------------------------------------------//
		//  Datos Especificos segun especialidad desempenada profesional  //
		//----------------------------------------------------------------//		
		if(especialidad!=null){
			if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadMedicinaGeneral)){
				System.out.println("en Construcci�n");
			}else if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadOdontologia)){
				listProcedimiento = gestionFacadeAgenda.findAllProcedimientos();
			}else if(especialidad.equals(ConstantesAplicativo.constanteEspecialidadOptometria)){
				System.out.println("en Construcci�n");
			}
		}
		//-------------------------------------------------------------------------//
		//  Datos Especificos segun especialidad en realcion a los datos clinicos  //
		//-------------------------------------------------------------------------//
		//listSegmentoAnamnesis = (ArrayList<Segmentoanamnesi>)request.getSession().getAttribute("listSegmentoAnamnesis");
		System.out.println("listSegmentoAnamnesis:["+listSegmentoAnamnesis+"]");
		if(listSegmentoAnamnesis==null){
			listSegmentoAnamnesis = gestionFacadeHistoriaClinica.findAllSegmentoanamnesis(Long.parseLong(especialidad));
			if(listSegmentoAnamnesis!=null&&listSegmentoAnamnesis.size()>0){
				for(Segmentoanamnesi elem:listSegmentoAnamnesis){
					elem.setPreguntas(gestionFacadeHistoriaClinica.findAllPreguntasXSegmentoAna(elem.getSeanId()));
					Collections.sort(elem.getPreguntas());
					if(elem.getPreguntas()!=null&&elem.getPreguntas().size()>0){
						for(Pregunta elem1:elem.getPreguntas()){
							elem1.setRespuestas(new ArrayList<Respuesta>());
							elem1.setOpcionrespuestas(gestionFacadeHistoriaClinica.findAllOpcionrespuestas(elem1.getPregId()));
							if(elem1.getOpcionrespuestas()!=null&&elem1.getOpcionrespuestas().size()>0){
								Collections.sort(elem1.getOpcionrespuestas());
							}
						}
					}
				}
			}
		}else{
			for(Segmentoanamnesi elem:listSegmentoAnamnesis){
				if(elem.getPreguntas()!=null&&elem.getPreguntas().size()>0){
					for(Pregunta elem1:elem.getPreguntas()){
						elem1.setOpcionrespuestas(gestionFacadeHistoriaClinica.findAllOpcionrespuestas(elem1.getPregId()));
						if(elem1.getOpcionrespuestas()!=null&&elem1.getOpcionrespuestas().size()>0){
							Collections.sort(elem1.getOpcionrespuestas());
							String[] opcRespuestas = ((Respuesta)elem1.getRespuestas().get(0)).getRespRespuesta().split(ConstantesAplicativo.constanteSplit);
							if(opcRespuestas!=null&&opcRespuestas.length>0){
								for(String resp:opcRespuestas){
									for(Opcionrespuesta elem2:elem1.getOpcionrespuestas()){
										if(resp.equals(elem2.getOpreValor())){
											elem2.setOpcRespuestaCheck(ConstantesAplicativo.constanteChecked);
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		request.getSession().setAttribute("listSegmentoAnamnesis", listSegmentoAnamnesis);
	}
	
	@SkipValidation
	public String tipoProcedimientoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>tipoProcedimientoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(tipoProcedimiento.getTiprNombre()))
    				addActionError(getText("validacion.requerido","tiprNombre","Especialidad Agrupar Procedimientos"));
    			if(!hasActionErrors()){
    				tipoProcedimiento.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(tipoProcedimiento);
    				gestionFacadeAgenda.persistTipoprocedimiento(tipoProcedimiento);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			tipoProcedimiento = gestionFacadeAgenda.findTipoprocedimientoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>tipoProcedimientoMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String procedimientoMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>AgendaAction>>>>procedimientoMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProcedimiento = gestionFacadeAgenda.findAllProcedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(procedimiento.getTipoprocedimiento().getTiprId()<=0)
    				addActionError(getText("validacion.requerido","tiprId","Tipo Procedimiento"));
    			if(ValidaString.isNullOrEmptyString(procedimiento.getPrtoCodigo()))
    				addActionError(getText("validacion.requerido","prtoCodigo","C�digo Procedimiento"));
    			if(ValidaString.isNullOrEmptyString(procedimiento.getPrtoNombre()))
    				addActionError(getText("validacion.requerido","prtoNombre","Nombre Procedimiento"));
    			if(!hasActionErrors()){
    				procedimiento.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(procedimiento);
    				gestionFacadeAgenda.persistProcedimiento(procedimiento);
    				procedimiento.setTipoprocedimiento(gestionFacadeAgenda.findTipoprocedimientoById(procedimiento.getTipoprocedimiento().getTiprId()));
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else
    				listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			procedimiento = gestionFacadeAgenda.findProcedimientoById(getIdLong());
    			listTipoProcedimiento = gestionFacadeAgenda.findAllTipoprocedimientos();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>procedimientoMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	public AgendaAction(IGestionFacadeAgenda gestionFacadeAgenda, IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica, IGestionFacadeNIIF gestionFacadeNIIF) {
		this.gestionFacadeAgenda = gestionFacadeAgenda;
		this.gestionFacadeHistoriaClinica = gestionFacadeHistoriaClinica;
		this.gestionFacadeNIIF = gestionFacadeNIIF;
	}
	
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	public String getEstado() {return estado;}
	public void setEstado(String estado) {this.estado = estado;}
	public IGestionFacadeAgenda getGestionFacadeAgenda() {return gestionFacadeAgenda;}
	public void setGestionFacadeAgenda(IGestionFacadeAgenda gestionFacadeAgenda) {this.gestionFacadeAgenda = gestionFacadeAgenda;}
	public String getFuncPosicionado() {return funcPosicionado;}
	public void setFuncPosicionado(String funcPosicionado) {this.funcPosicionado = funcPosicionado;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public long getIdLong() {return Long.parseLong(id);}
	public Integer getIdInteger() {return Integer.parseInt(id);}
	public List<String> getDatosAud(){
		return Arrays.asList(((Usuario)request.getSession().getAttribute("usuarioVO")).getLoginUsua(),
				ValidaString.fechaSystem(),
				ValidaString.horaSystem());
	}
	public String getBandEstadoFunc() {return bandEstadoFunc;}
	public void setBandEstadoFunc(String bandEstadoFunc) {this.bandEstadoFunc = bandEstadoFunc;}
	public String getBackground() {return background;}
	public void setBackground(String background) {this.background = background;}
	
	public String getOdontograma() {return odontograma;}
	public void setOdontograma(String odontograma) {this.odontograma = odontograma;}
	
	public InputStream getStrProfesional() {
		try{
			String find = request.getParameter("find");
			String option = "";
			if(find!=null&&!find.equals("")){
				listPersona = gestionFacadeAgenda.findAllPersonasProfesionales(find);
				if(listPersona!=null){
					for(Persona elem:listPersona){
						option += "<div><a class=\"suggest-element\" data=\""+elem.getNombreCompleto()+" - "+elem.getEmailPers()+" - "+elem.getTelefonoPers()+"\" id=\""+elem.getIdPers()+"\">"+elem.getNombreCompleto()+" - "+elem.getEmailPers()+" - "+elem.getTelefonoPers()+"</a></div>";
					}
				}
			}
			this.strProfesional = new ByteArrayInputStream(option.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}
		return strProfesional;
	}
	
	public InputStream getStrDatosPersona() {
		try{
			String html = "";
			long idPersona = Long.parseLong(request.getParameter("idPersona"));
			Persona persona = gestionFacadeAgenda.findPersonaById(idPersona);
			html = "<s:textfield name=\"dataAutoCompletado\" id=\"search\" size=\"60\" maxlength=\"30\" cssClass=\"inputs\"></s:textfield><br>";
			html += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">"+
					"	<tr> " +
					"		<td class=\"leftLabel\">Nombre</td> " +
					"		<td>" + persona.getNombreCompleto() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Documento Identificaci�n</td> " +
					"		<td>" + persona.getDocumentoPers() + " " + persona.getTipodocumento().getAbreviaturaTidoc() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Fecha Nacimiento y Edad</td> " +
					"		<td>" + persona.getFechanacimientoPers() + "  /  " + persona.getEdad() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Sexo</td> " +
					"		<td>" + persona.getSexoPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Estado Civil</td> " +
					"		<td>" + persona.getEstadocivilPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Correo Electr�nico</td> " +
					"		<td>" + persona.getEmailPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Tel�fonos</td> " +
					"		<td>" + persona.getTelefonoPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Ubicaci�n</td> " +
					"		<td>" + persona.getUbicacionPersona() + " " + persona.getDireccionPers() + "</td> " +
					"	</tr> " +
					"</table>";
			strDatosPersona = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosPersona;
	}
	
	public InputStream getStrCrearEvento() {
		try{
			String html = "";
			String backgroundColor = String.valueOf(request.getParameter("backgroundColor"));
			Evento evento = new Evento();
			evento.setAgenda(gestionFacadeAgenda.findIdAgenda(backgroundColor));
			String title = String.valueOf(request.getParameter("title"));
			String start = String.valueOf(request.getParameter("start"));
			String end = String.valueOf(request.getParameter("end"));
			String url = "calendario.action?estado="+ConstantesAplicativo.constanteEstadoOperacionCita+"&funcPosicionado=Calendario/Informacion Cita&idProfesional="+evento.getAgenda().getProfesional().getProfId()+"&idEvento=";
			evento.setEvenTitle(title);
			evento.setEvenStart(start);
			evento.setEvenEnd(end);
			evento.setEvenUrl(url);
			evento.setEvenBackgroundcolor(backgroundColor);
			evento.setEvenEstado(ConstantesAplicativo.constanteEstadoEventoCreado);
			evento.setDatosAud(getDatosAud());
			ValidaString.imprimirObject(evento);
			long idEvento = gestionFacadeAgenda.persistEventoId(evento);
			if(idEvento>0){
				evento.setEvenId(idEvento);
				Participante participante = new Participante();
				participante.setEvento(evento);
				participante.setPartDocumento(String.valueOf(request.getParameter("nrodocumento")));
				participante.setPartTipodocumento(String.valueOf(request.getParameter("tipodoc")));
				participante.setPartPnombre(String.valueOf(request.getParameter("pnombre")));
				participante.setPartSnombre(String.valueOf(request.getParameter("snombre")));
				participante.setPartPapellido(String.valueOf(request.getParameter("papellido")));
				participante.setPartSapellido(String.valueOf(request.getParameter("sapellido")));
				participante.setPartTelefono(String.valueOf(request.getParameter("telefono")));
				participante.setPartEmail(String.valueOf(request.getParameter("email")));
				participante.setDatosAud(getDatosAud());
				ValidaString.imprimirObject(participante);
				gestionFacadeAgenda.persistParticipante(participante);
			}	
			String nameFile = "eventos";
			String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\"; 
			gestionFacadeAgenda.crearFile(path, nameFile,   
						ConstantesAplicativo.constanteExtensionFileJS, 
						ConstantesAplicativo.constanteTipoFileJSConstantesEventos,
						ConstantesAplicativo.constanteCrearFileJSEventosAll);
			path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\eventosAgenda\\";	
			nameFile = "eventosagenda_"+evento.getAgenda().getAgenId();
			gestionFacadeAgenda.crearFile(path, nameFile,   
					ConstantesAplicativo.constanteExtensionFileJS, 
					ConstantesAplicativo.constanteTipoFileJSConstantesEventosxAgenda,
					evento.getAgenda().getAgenId()+"");
			html = "<input type=\"hidden\" id=\"idEventoCreado\" value=\""+idEvento+"\"/>";
			strCrearEvento = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strCrearEvento;
	}
	
	public InputStream getStrCrearEventoCate() {
		try{
			String html = "";
			String backgroundColor = String.valueOf(request.getParameter("backgroundColor"));
			Evento evento = new Evento();
			evento.setAgenda(gestionFacadeAgenda.findIdAgenda(backgroundColor, ConstantesAplicativo.constanteAgendaCategoria));
			String title = String.valueOf(request.getParameter("title"));
			String start = String.valueOf(request.getParameter("start"));
			String end = String.valueOf(request.getParameter("end"));
			String url = "calendarioCategoria.action?estado="+ConstantesAplicativo.constanteEstadoLegalizarCompromiso+"&funcPosicionado=Calendario/Informacion Cita&idEvento=";
			evento.setEvenTitle(title);
			evento.setEvenStart(start);
			evento.setEvenEnd(end);
			evento.setEvenUrl(url);
			evento.setEvenBackgroundcolor(backgroundColor);
			evento.setEvenEstado(ConstantesAplicativo.constanteEstadoEventoCreado);
			evento.setDatosAud(getDatosAud());
			ValidaString.imprimirObject(evento);
			long idEvento = gestionFacadeAgenda.persistEventoId(evento);
			if(idEvento>0){
				evento.setEvenId(idEvento);
				Participante participante = new Participante();
				participante.setEvento(evento);
				participante.setPartDocumento(String.valueOf(request.getParameter("nrodocumento")));
				participante.setPartTipodocumento(String.valueOf(request.getParameter("tipodoc")));
				participante.setPartPnombre(String.valueOf(request.getParameter("pnombre")));
				participante.setPartSnombre(String.valueOf(request.getParameter("snombre")));
				participante.setPartPapellido(String.valueOf(request.getParameter("papellido")));
				participante.setPartSapellido(String.valueOf(request.getParameter("sapellido")));
				participante.setPartTelefono(String.valueOf(request.getParameter("telefono")));
				participante.setPartEmail(String.valueOf(request.getParameter("email")));
				participante.setDatosAud(getDatosAud());
				ValidaString.imprimirObject(participante);
				gestionFacadeAgenda.persistParticipante(participante);
			}	
			String nameFile = "eventos";
			String path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\"; 
			gestionFacadeAgenda.crearFile(path, nameFile,   
						ConstantesAplicativo.constanteExtensionFileJS, 
						ConstantesAplicativo.constanteTipoFileJSConstantesEventos,
						ConstantesAplicativo.constanteCrearFileJSEventosAll);
			path = request.getServletContext().getRealPath("/")+"js\\constantesCalendario\\eventosAgenda\\";	
			nameFile = "eventosagenda_"+evento.getAgenda().getAgenId();
			gestionFacadeAgenda.crearFile(path, nameFile,   
					ConstantesAplicativo.constanteExtensionFileJS, 
					ConstantesAplicativo.constanteTipoFileJSConstantesEventosxAgenda,
					evento.getAgenda().getAgenId()+"");
			html = "<input type=\"hidden\" id=\"idEventoCreado\" value=\""+idEvento+"\"/>";
			strCrearEventoCate = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strCrearEventoCate;
	}
	
	
	public InputStream getStrDatosDiagnostico() {
		try{
			boolean bandExistDxPP = false;
			String html = "";
			int posicion = request.getParameter("posicion")!=null?Integer.parseInt(request.getParameter("posicion")):-1;
			long coenId = request.getParameter("coenId")!=null?Long.parseLong(request.getParameter("coenId")):0;
			String claseDiagnostico = request.getParameter("claseDiag");
			String tipoDiagnostico = request.getParameter("tipoDiag");
			if(posicion<0){
				Diagnostico diagnostico = new Diagnostico(); 
				Codigoenfermedade codigoEnfermedad = gestionFacadeHistoriaClinica.findCodigoenfermedadeById(coenId);
				diagnostico.setCodigoenfermedade(codigoEnfermedad);
				diagnostico.setClasediagnostico(claseDiagnostico!=null?gestionFacadeHistoriaClinica.findClasediagnosticosXAbreviatura(Long.parseLong(claseDiagnostico)<=0?ConstantesAplicativo.constanteClaseDiagnosticoPP:ConstantesAplicativo.constanteClaseDiagnosticoRL):null);
				diagnostico.setDiagOrden(claseDiagnostico!=null?Long.parseLong(claseDiagnostico):0);
				diagnostico.setTipodiagnostico(claseDiagnostico!=null?gestionFacadeHistoriaClinica.findTipodiagnosticoById(Long.parseLong(tipoDiagnostico)):null);
				listDiagnostico = (List<Diagnostico>) request.getSession().getAttribute("listDiagnostico");
				if(listDiagnostico==null)
					listDiagnostico = new ArrayList<Diagnostico>();
//				if(claseDiagnostico!=null){
//					if(listDiagnostico.size()<Integer.parseInt(claseDiagnostico)){
//						for(int i=0;i<Integer.parseInt(claseDiagnostico);i++){
//							Diagnostico diagnosticoAux = null;
//							try{diagnosticoAux = (Diagnostico) listDiagnostico.get(i);}catch(Exception e){diagnosticoAux = null;}
//							if(diagnosticoAux==null||(diagnosticoAux!=null&&diagnosticoAux.getDiagOrden()!=i)){
//								Diagnostico diagnosticoAux1 = new Diagnostico();
//								diagnosticoAux1.setDiagOrden(i);
//								listDiagnostico.add(diagnosticoAux1);
//							}
//						}
//					}else{
//						int con=0;
//						for(Diagnostico elem:listDiagnostico){
//							if(elem.getCodigoenfermedade()==null){
//								listDiagnostico.remove(con);
//								break;
//							}
//							con++;
//						}
//					}
//					listDiagnostico.add(Integer.parseInt(claseDiagnostico), diagnostico);
//				}
//				listDiagnostico.add(Integer.parseInt(claseDiagnostico), diagnostico);
				if(diagnostico.getClasediagnostico().getCldiAbreviatura().equals(ConstantesAplicativo.constanteClaseDiagnosticoPP)){
					if(listDiagnostico!=null&&listDiagnostico.size()>0){
						for(Diagnostico elem:listDiagnostico){
							if(elem.getClasediagnostico().getCldiAbreviatura().equals(ConstantesAplicativo.constanteClaseDiagnosticoPP)){
								bandExistDxPP = true;
								break;
							}	
						}
						if(!bandExistDxPP)	
							listDiagnostico.add(diagnostico);
					}else
						listDiagnostico.add(diagnostico);
				}else
					listDiagnostico.add(diagnostico);
			}else{
				listDiagnostico = (List<Diagnostico>) request.getSession().getAttribute("listDiagnostico");
				listDiagnostico.remove(posicion);
			}
			Collections.sort(listDiagnostico);
			request.getSession().setAttribute("listDiagnostico", listDiagnostico);
			html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
			int cont = 0;
			html += bandExistDxPP?"<tr><td colspan=\"4\"><font size=\"2\" color=\"#FF0000\"><strong>Ya existe un Diagn�stico Principal Agregado lo puede cambiar</strong></font></td></tr>":"";
			for(Diagnostico elem: listDiagnostico){		
				html += "<tr> " +
					"		<td>[" + elem.getCodigoenfermedade().getCoenCodigo() + "] " + elem.getCodigoenfermedade().getCoenNombre() + "</td> " +
					"		<td>" + (elem.getClasediagnostico().getCldiNombre()) + "</td> " +
					"		<td>" + (elem.getTipodiagnostico()!=null?elem.getTipodiagnostico().getTidiNombre():"") + "</td> " +
					"		<td><input type=\"button\" value=\"Cambiar\" onClick=\"cambiarDiagnostico('"+cont+"');\" class=\"buttonSV\"/></td> " +
					"	</tr> ";
				cont++;
			}
			html += "</table>";
			strDatosDiagnostico = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosDiagnostico;
	}
	
	public InputStream getStrCambiarDatosDiagnostico() {
		try{
			String html = "";
			int diagnosticoPos = Integer.parseInt(request.getParameter("diagnostico"));
			listDiagnostico = (List<Diagnostico>) request.getSession().getAttribute("listDiagnostico");
			listDiagnostico.remove(diagnosticoPos);
			if(listDiagnostico.size()>0){
				for(int i=0;i<(listDiagnostico.get(listDiagnostico.size()-1)).getDiagOrden();i++){
					Diagnostico diagnosticoAux = listDiagnostico.size()==0?null:(Diagnostico) listDiagnostico.get(i);
					if(diagnosticoAux.getDiagOrden()!=i){
						Diagnostico diagnosticoAux1 = new Diagnostico();
						diagnosticoAux1.setDiagOrden(i);
						listDiagnostico.add(diagnosticoAux1);
					}
				}
			}
			Collections.sort(listDiagnostico);
			request.getSession().setAttribute("listDiagnostico", listDiagnostico);
			strCambiarDatosDiagnostico = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strCambiarDatosDiagnostico;
	}
	
	public InputStream getStrDatosCoverTest() {
		try{
			String html = "";
			int posicion = request.getParameter("posicion")!=null?Integer.parseInt(request.getParameter("posicion")):-1;
			String coverTest = request.getParameter("covertest");
			boolean ojoDer = Boolean.parseBoolean(request.getParameter("od"));
			boolean ojoIzq = Boolean.parseBoolean(request.getParameter("oi"));
			String tipo = request.getParameter("tipo");
//			System.out.println("**********************************************");
//			System.out.println("**********************************************");
//			System.out.println("posicion:["+posicion+"]");
//			System.out.println("coverTest:["+coverTest+"]");
//			System.out.println("ojoDer:["+ojoDer+"]");
//			System.out.println("ojoIzq:["+ojoIzq+"]");
//			System.out.println("tipo:["+tipo+"]");
//			System.out.println("**********************************************");
//			System.out.println("**********************************************");
			if(tipo!=null&&!tipo.equals("")){
				if(posicion<0){
					Registrocovertest registroCoverTest = new Registrocovertest();
					registroCoverTest.setEspecificacionpartecuerpo(
							!ojoDer&&!ojoIzq?null:gestionFacadeHistoriaClinica.findEspecificacionpartecuerposXEtiqueta(
									ojoDer&&!ojoIzq?ConstantesAplicativo.constanteEspParteCuerpoOD
									:!ojoDer&&ojoIzq?ConstantesAplicativo.constanteEspParteCuerpoOI
									:ojoDer&&ojoIzq?ConstantesAplicativo.constanteEspParteCuerpoODI:""));
					if(tipo.equals(ConstantesAplicativo.constanteCoverTestLejosAbre)){
						listRegistroCoverTestLejos = (List<Registrocovertest>) request.getSession().getAttribute("listRegistroCoverTestLejos");
						if(listRegistroCoverTestLejos==null)
							listRegistroCoverTestLejos = new ArrayList<Registrocovertest>();
						if(ojoDer||ojoIzq){
							registroCoverTest.setRectLejos(coverTest);
							listRegistroCoverTestLejos.add(registroCoverTest);
						}
						html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
						html += !ojoDer&&!ojoIzq?"<tr><td colspan=\"3\"><font size=\"2\" color=\"#FF0000\"><strong>Debe Seleccionar Un Ojo.</strong></font></td></tr>":"";
						int cont = 0;
						for(Registrocovertest elem: listRegistroCoverTestLejos){
							html += "<tr> " +
								"		<td>"+elem.getRectLejos()+"</td> " +
								"		<td>"+elem.getEspecificacionpartecuerpo().getEspcNombre()+"</td> " +
								"		<td><input type=\"button\" value=\"Desvincular Cover Test Lejos\" onClick=\"eliminarCoverTest('"+cont+"','"+tipo+"');\" class=\"buttonSV\"/></td> " +
								"	</tr> ";
							cont++;
						}
						html += "</table>";
						request.getSession().setAttribute("listRegistroCoverTestLejos", listRegistroCoverTestLejos);
					}else if(tipo.equals(ConstantesAplicativo.constanteCoverTestCercaAbre)){
						listRegistroCoverTestCerca = (List<Registrocovertest>) request.getSession().getAttribute("listRegistroCoverTestCerca");
						if(listRegistroCoverTestCerca==null)
							listRegistroCoverTestCerca = new ArrayList<Registrocovertest>();
						if(ojoDer||ojoIzq){
							registroCoverTest.setRectCerca(coverTest);
							listRegistroCoverTestCerca.add(registroCoverTest);
						}
						html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
						html += !ojoDer&&!ojoIzq?"<tr><td colspan=\"3\"><font size=\"2\" color=\"#FF0000\"><strong>Debe Seleccionar Un Ojo.</strong></font></td></tr>":"";
						int cont = 0;
						for(Registrocovertest elem: listRegistroCoverTestCerca){
							html += "<tr> " +
								"		<td>"+elem.getRectCerca()+"</td> " +
								"		<td>"+elem.getEspecificacionpartecuerpo().getEspcNombre()+"</td> " +
								"		<td><input type=\"button\" value=\"Desvincular Cover Test Lejos\" onClick=\"eliminarCoverTest('"+cont+"','"+tipo+"');\" class=\"buttonSV\"/></td> " +
								"	</tr> ";
							cont++;
						}
						html += "</table>";
						request.getSession().setAttribute("listRegistroCoverTestCerca", listRegistroCoverTestCerca);
					}
				}else{
					if(tipo.equals(ConstantesAplicativo.constanteCoverTestLejosAbre)){
						listRegistroCoverTestLejos = (List<Registrocovertest>) request.getSession().getAttribute("listRegistroCoverTestLejos");
						listRegistroCoverTestLejos.remove(posicion);
						html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
						int cont = 0;
						for(Registrocovertest elem: listRegistroCoverTestLejos){
							html += "<tr> " +
								"		<td>"+elem.getRectLejos()+"</td> " +
								"		<td>"+elem.getEspecificacionpartecuerpo().getEspcNombre()+"</td> " +
								"		<td><input type=\"button\" value=\"Desvincular Cover Test Lejos\" onClick=\"eliminarCoverTest('"+cont+"','"+tipo+"');\" class=\"buttonSV\"/></td> " +
								"	</tr> ";
							cont++;
						}
						html += "</table>";
						request.getSession().setAttribute("listRegistroCoverTestLejos", listRegistroCoverTestLejos);
					}else if(tipo.equals(ConstantesAplicativo.constanteCoverTestCercaAbre)){
						listRegistroCoverTestCerca = (List<Registrocovertest>) request.getSession().getAttribute("listRegistroCoverTestCerca");
						listRegistroCoverTestCerca.remove(posicion);
						html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
						int cont = 0;
						for(Registrocovertest elem: listRegistroCoverTestCerca){
							html += "<tr> " +
								"		<td>"+elem.getRectCerca()+"</td> " +
								"		<td>"+elem.getEspecificacionpartecuerpo().getEspcNombre()+"</td> " +
								"		<td><input type=\"button\" value=\"Desvincular Cover Test Cerca\" onClick=\"eliminarCoverTest('"+cont+"','"+tipo+"');\" class=\"buttonSV\"/></td> " +
								"	</tr> ";
							cont++;
						}
						html += "</table>";
						request.getSession().setAttribute("listRegistroCoverTestCerca", listRegistroCoverTestCerca);
					}
				}
			}else{
				html = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">";
				html += "<tr><td colspan=\"3\"><font size=\"2\" color=\"#FF0000\"><strong>Error. Comuniquese con el administrador.</strong></font></td></tr>";
				html += "</table>";
			}
//			System.out.println("html:["+html+"]");
			strDatosCoverTest = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosCoverTest;
	}
}
