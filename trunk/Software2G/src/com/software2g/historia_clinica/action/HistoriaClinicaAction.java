package com.software2g.historia_clinica.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
import com.software2g.historia_clinica.facade.impl.GestionFacadeHistoriaClinica;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Examenespecialidad;
import com.software2g.vo.Finalidad;
import com.software2g.vo.Motivo;
import com.software2g.vo.Opcionrespuesta;
import com.software2g.vo.Persona;
import com.software2g.vo.Pregunta;
import com.software2g.vo.Segmentoanamnesi;
import com.software2g.vo.Seguridadsocial;
import com.software2g.vo.Servicio;
import com.software2g.vo.Tipoespecialidad;
import com.software2g.vo.Tipopregunta;
import com.software2g.vo.Tiposegmento;
import com.software2g.vo.Usuario;
import com.software2g.vo.UtilGenerico;

@ManagedBean(name="historiaClinica")
public class HistoriaClinicaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica;
	private String estado;
	private String funcPosicionado;
	private String id;
	private String dataAutoCompletado;
	
//	private List<Profesionalsalud> listProfesionalSalud;
//	private Profesionalsalud profesionalSalud;
	private InputStream strDatosPersona;
	
//	public List<Profesionalsalud> getListProfesionalSalud() {return listProfesionalSalud;}
//	public void setListProfesionalSalud(List<Profesionalsalud> listProfesionalSalud) {this.listProfesionalSalud = listProfesionalSalud;}
//	public Profesionalsalud getProfesionalSalud() {return profesionalSalud;}
//	public void setProfesionalSalud(Profesionalsalud profesionalSalud) {this.profesionalSalud = profesionalSalud;}
//	
	
	private List<Persona> listPersona;
	private Persona persona;
	private List<Finalidad> listFinalidad;
	private List<Motivo> listMotivo;
	private List<Seguridadsocial> listSeguridadSocial;
	private Finalidad finalidad;
	private Motivo motivo;
	private Seguridadsocial seguridadSocial;
	private Servicio servicio;
	
	public List<Persona> getListPersona() {return listPersona;}
	public void setListPersona(List<Persona> listPersona) {this.listPersona = listPersona;}
	public Persona getPersona() {return persona;}
	public void setPersona(Persona persona) {this.persona = persona;}
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
	public Servicio getServicio() {return servicio;}
	public void setServicio(Servicio servicio) {this.servicio = servicio;}
	
	
	private List<Tiposegmento> listTipoSegmento;
	private Tiposegmento tipoSegmento;
	private List<Tipopregunta> listTipoPregunta;
	private List<Tipopregunta> listTipoPreguntaJSF;
	private Tipopregunta tipoPregunta;
	private List<Segmentoanamnesi> listSegmentoAnamnesis;
	private Segmentoanamnesi segmentoAnamnesis;
	private List<Pregunta> listPregunta;
	private Pregunta pregunta;
	private List<Opcionrespuesta> listOpcionRespuesta;
	private Opcionrespuesta opcionRespuesta;
	private List<Tipoespecialidad> listTipoEspecialidad;
	private Examenespecialidad examenEspecialidad;
	private List<Examenespecialidad> listExamenEspecialidad;
	
	public List<Tiposegmento> getListTipoSegmento() {return listTipoSegmento;}
	public void setListTipoSegmento(List<Tiposegmento> listTipoSegmento) {this.listTipoSegmento = listTipoSegmento;}
	public Tiposegmento getTipoSegmento() {return tipoSegmento;}
	public void setTipoSegmento(Tiposegmento tipoSegmento) {this.tipoSegmento = tipoSegmento;}
	public List<Tipopregunta> getListTipoPregunta() {return listTipoPregunta;}
	public void setListTipoPregunta(List<Tipopregunta> listTipoPregunta) {this.listTipoPregunta = listTipoPregunta;}
	public Tipopregunta getTipoPregunta() {return tipoPregunta;}
	public void setTipoPregunta(Tipopregunta tipoPregunta) {this.tipoPregunta = tipoPregunta;}
	public List<Segmentoanamnesi> getListSegmentoAnamnesis() {return listSegmentoAnamnesis;}
	public void setListSegmentoAnamnesis(List<Segmentoanamnesi> listSegmentoAnamnesis) {this.listSegmentoAnamnesis = listSegmentoAnamnesis;}
	public Segmentoanamnesi getSegmentoAnamnesis() {return segmentoAnamnesis;}
	public void setSegmentoAnamnesis(Segmentoanamnesi segmentoAnamnesis) {this.segmentoAnamnesis = segmentoAnamnesis;}
	public List<Pregunta> getListPregunta() {return listPregunta;}
	public void setListPregunta(List<Pregunta> listPregunta) {this.listPregunta = listPregunta;}
	public Pregunta getPregunta() {return pregunta;}
	public void setPregunta(Pregunta pregunta) {this.pregunta = pregunta;}
	public List<Opcionrespuesta> getListOpcionRespuesta() {return listOpcionRespuesta;}
	public void setListOpcionRespuesta(List<Opcionrespuesta> listOpcionRespuesta) {this.listOpcionRespuesta = listOpcionRespuesta;}
	public Opcionrespuesta getOpcionRespuesta() {return opcionRespuesta;}
	public void setOpcionRespuesta(Opcionrespuesta opcionRespuesta) {this.opcionRespuesta = opcionRespuesta;}
	public List<Tipoespecialidad> getListTipoEspecialidad() {return listTipoEspecialidad;}
	public void setListTipoEspecialidad(List<Tipoespecialidad> listTipoEspecialidad) {this.listTipoEspecialidad = listTipoEspecialidad;}
	public Examenespecialidad getExamenEspecialidad() {return examenEspecialidad;}
	public void setExamenEspecialidad(Examenespecialidad examenEspecialidad) {this.examenEspecialidad = examenEspecialidad;}
	public List<Examenespecialidad> getListExamenEspecialidad() {return listExamenEspecialidad;}
	public void setListExamenEspecialidad(List<Examenespecialidad> listExamenEspecialidad) {this.listExamenEspecialidad = listExamenEspecialidad;}
	
	public List<UtilGenerico> getListEstado() {return ConstantesAplicativo.listEstado;}
	public List<UtilGenerico> getListObjetoView() {return ConstantesAplicativo.listObjetoView;}
	public List<UtilGenerico> getListOrden() {return ConstantesAplicativo.listOrden;}
	public List<UtilGenerico> getListTipoDato() {return ConstantesAplicativo.listTipoDato;}
	public List<UtilGenerico> getListRespObligatoria() {return ConstantesAplicativo.listRespObligatoria;}
	
	
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
	
	@SkipValidation
	public String servicioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>servicioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listPersona = null;//gestionFacadeHistoriaClinica.findAllPersonas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			System.out.println("entra esta parte!!!!!");
    			System.out.println("ID:["+this.getIdLong()+"]");
    			persona = null;//gestionFacadeHistoriaClinica.findPersonaById(this.getIdLong());
    			System.out.println("Edad: ["+persona.getEdad()+"]");
    			listFinalidad = gestionFacadeHistoriaClinica.findAllFinalidads();
    			listMotivo = gestionFacadeHistoriaClinica.findAllMotivos();
    			listSeguridadSocial = gestionFacadeHistoriaClinica.findAllSeguridadsocials();
    			System.out.println("listFinalidad:["+listFinalidad+"]");
//    			for(Finalidad elem: listFinalidad){
//    				System.out.println("Finalidad:["+elem.getCodfinalidad()+"]-["+elem.getNomfinalidad()+"]");
//    			}
    		}/*else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
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
    		}*/
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>servicioMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String tipoSegmentoAnamnesisMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoSegmentoAnamnesisMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listTipoSegmento = gestionFacadeHistoriaClinica.findAllTiposegmentos();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(tipoSegmento.getTisaNombre()))
    				addActionError(getText("validacion.requerido","tisaNombre","Nombre Tipo Segmento"));
    			if(ValidaString.isNullOrEmptyString(tipoSegmento.getTisaAbreviatura()))
    				addActionError(getText("validacion.requerido","tisaAbreviatura","Abreviatrua Tipo Segmento"));
    			if(!hasActionErrors()){
    				tipoSegmento.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(tipoSegmento);
    				gestionFacadeHistoriaClinica.persistTiposegmento(tipoSegmento);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			tipoSegmento = gestionFacadeHistoriaClinica.findTiposegmentoById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoSegmentoAnamnesisMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String tipoPreguntaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoPreguntaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listTipoPregunta = gestionFacadeHistoriaClinica.findAllTipopreguntas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(ValidaString.isNullOrEmptyString(tipoPregunta.getTiprNombre()))
    				addActionError(getText("validacion.requerido","tiprNombre","Nombre"));
    			if(ValidaString.isNullOrEmptyString(tipoPregunta.getTiprEtiqueta()))
    				addActionError(getText("validacion.requerido","tiprEtiqueta","Etiqueta"));
    			if(!hasActionErrors()){
    				tipoPregunta.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(tipoPregunta);
    				gestionFacadeHistoriaClinica.persistTipopregunta(tipoPregunta);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			tipoPregunta = gestionFacadeHistoriaClinica.findTipopreguntaById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoPreguntaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	public List<Tipopregunta> tipoPreguntaMethodJSF(){
    	try {
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoPreguntaMethodJSF>>>>estado entrada-->>"+estado);
    		listTipoPregunta = gestionFacadeHistoriaClinica.findAllTipopreguntas();
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoPreguntaMethodJSF>>>>estado salida-->>"+estado);
    	return listTipoPregunta;
	}
	
	public List<Tipopregunta> getListTipoPreguntaJSF() {
		try {
			System.out.println("this.gestionFacadeHistoriaClinica:["+this.gestionFacadeHistoriaClinica+"]");
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoPreguntaMethodJSF>>>>estado entrada-->>"+estado);
    		System.out.println("gestionFacadeHistoriaClinica:["+gestionFacadeHistoriaClinica+"]");
    		listTipoPreguntaJSF = gestionFacadeHistoriaClinica.findAllTipopreguntas();
    		System.out.println("listTipoPreguntaJSF:["+listTipoPreguntaJSF+"]");
    	} catch(Exception e){
    		System.out.println("Entra esta parte catch!!!!!!!!!");
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>tipoPreguntaMethodJSF>>>>estado salida-->>"+estado);
		return listTipoPreguntaJSF;
	}
	public void setListTipoPreguntaJSF(List<Tipopregunta> listTipoPreguntaJSF) {
		this.listTipoPreguntaJSF = listTipoPreguntaJSF;
	}
	
	
	@SkipValidation
	public String segmentoAnamnesisMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>segmentoAnamnesisMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listSegmentoAnamnesis = gestionFacadeHistoriaClinica.findAllSegmentoanamnesis();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listTipoSegmento = gestionFacadeHistoriaClinica.findAllTiposegmentos();
    			listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(segmentoAnamnesis.getTipoespecialidad().getTiesId()<=0)
    				addActionError(getText("validacion.requerido","tiesId","Tipo Especialidad"));
    			if(segmentoAnamnesis.getTiposegmento().getTisaId()<=0)
    				addActionError(getText("validacion.requerido","tisaId","Tipo Segmento"));
    			if(ValidaString.isNullOrEmptyString(segmentoAnamnesis.getSeanNombre()))
    				addActionError(getText("validacion.requerido","seanNombre","Nombre"));
    			if(ValidaString.isNullOrEmptyString(segmentoAnamnesis.getSeanEtiqueta()))
    				addActionError(getText("validacion.requerido","seanEtiqueta","Etiqueta"));
    			if(!hasActionErrors()){
    				segmentoAnamnesis.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(segmentoAnamnesis);
    				gestionFacadeHistoriaClinica.persistSegmentoanamnesi(segmentoAnamnesis);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				segmentoAnamnesis.setTiposegmento(gestionFacadeHistoriaClinica.findTiposegmentoById(segmentoAnamnesis.getTiposegmento().getTisaId()));
    				segmentoAnamnesis.setTipoespecialidad(gestionFacadeHistoriaClinica.findTipoespecialidadById(segmentoAnamnesis.getTipoespecialidad().getTiesId()));
    			}else{
    				listTipoSegmento = gestionFacadeHistoriaClinica.findAllTiposegmentos();
    				listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			segmentoAnamnesis = gestionFacadeHistoriaClinica.findSegmentoanamnesiById(getIdLong());
    			listTipoSegmento = gestionFacadeHistoriaClinica.findAllTiposegmentos();
        		listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>segmentoAnamnesisMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String preguntaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>preguntaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listPregunta = gestionFacadeHistoriaClinica.findAllPreguntas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listSegmentoAnamnesis = gestionFacadeHistoriaClinica.findAllSegmentoanamnesis();
    			listTipoPregunta = gestionFacadeHistoriaClinica.findAllTipopreguntas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(pregunta.getSegmentoanamnesi().getSeanId()<=0)
    				addActionError(getText("validacion.requerido","seanId","Segmento Anamnesis"));
    			if(pregunta.getTipopregunta().getTiprId()<=0)
    				addActionError(getText("validacion.requerido","tiprId","Tipo Pregunta"));
    			if(ValidaString.isNullOrEmptyString(pregunta.getPregPregunta()))
    				addActionError(getText("validacion.requerido","pregPregunta","Pregunta"));
    			if(ValidaString.isNullOrEmptyString(pregunta.getPregRespobligatoria()))
    				addActionError(getText("validacion.requerido","pregRespObligatoria","Respuesta Obligatoria"));
    			if(ValidaString.isNullOrEmptyString(pregunta.getPregEstado()))
    				addActionError(getText("validacion.requerido","pregEstado","Estado"));
    			if(ValidaString.isNullOrEmptyString(pregunta.getPregTipodato()))
    				addActionError(getText("validacion.requerido","pregTipoDato","Tipo de Dato"));
    			if(ValidaString.isNullOrEmptyString(pregunta.getPregObjetoview()))
    				addActionError(getText("validacion.requerido","pregObjetoView","Visualización Objeto"));
    			if(pregunta.getPregOrden()<=0)
    				addActionError(getText("validacion.requerido","pregOrden","Orden"));
    			if(!hasActionErrors()){
    				pregunta.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(pregunta);
    				gestionFacadeHistoriaClinica.persistPregunta(pregunta);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				pregunta.setSegmentoanamnesi(gestionFacadeHistoriaClinica.findSegmentoanamnesiById(pregunta.getSegmentoanamnesi().getSeanId()));
    				pregunta.setTipopregunta(gestionFacadeHistoriaClinica.findTipopreguntaById(pregunta.getTipopregunta().getTiprId()));
    			}else{
    				listSegmentoAnamnesis = gestionFacadeHistoriaClinica.findAllSegmentoanamnesis();
    				listTipoPregunta = gestionFacadeHistoriaClinica.findAllTipopreguntas();
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			pregunta = gestionFacadeHistoriaClinica.findPreguntaById(getIdLong());
    			listSegmentoAnamnesis = gestionFacadeHistoriaClinica.findAllSegmentoanamnesis();
    			listTipoPregunta = gestionFacadeHistoriaClinica.findAllTipopreguntas();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>preguntaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String opcionRespuestaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>opcionRespuestaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listOpcionRespuesta = gestionFacadeHistoriaClinica.findAllOpcionrespuestas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listPregunta = gestionFacadeHistoriaClinica.findAllPreguntas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(opcionRespuesta.getPregunta().getPregId()<=0)
    				addActionError(getText("validacion.requerido","pregId","Pregunta"));
    			if(ValidaString.isNullOrEmptyString(opcionRespuesta.getOpreEtiqueta()))
    				addActionError(getText("validacion.requerido","opreEtiqueta","Etiqueta"));
    			if(ValidaString.isNullOrEmptyString(opcionRespuesta.getOpreValor()))
    				addActionError(getText("validacion.requerido","opreValor","Valor"));
    			if(opcionRespuesta.getOpreOrden()<=0)
    				addActionError(getText("validacion.requerido","opreOrden","Orden"));
    			if(!hasActionErrors()){
    				opcionRespuesta.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(opcionRespuesta);
    				gestionFacadeHistoriaClinica.persistOpcionrespuesta(opcionRespuesta);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				opcionRespuesta.setPregunta(gestionFacadeHistoriaClinica.findPreguntaById(opcionRespuesta.getPregunta().getPregId()));
    			}else
    				listPregunta = gestionFacadeHistoriaClinica.findAllPreguntas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			opcionRespuesta = gestionFacadeHistoriaClinica.findOpcionrespuestaById(getIdLong());
    			listPregunta = gestionFacadeHistoriaClinica.findAllPreguntas();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>opcionRespuestaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String examenEspecialidadMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>examenEspecialidadMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listExamenEspecialidad = gestionFacadeHistoriaClinica.findAllExamenespecialidads();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(examenEspecialidad.getTipoEspecialidad().getTiesId()<=0)
    				addActionError(getText("validacion.requerido","tiesId","Tipo Especialidad"));
    			if(ValidaString.isNullOrEmptyString(examenEspecialidad.getExesNombre()))
    				addActionError(getText("validacion.requerido","exesNombre","Nombre Examen"));
    			if(ValidaString.isNullOrEmptyString(examenEspecialidad.getExesPaginajsp()))
    				addActionError(getText("validacion.requerido","exesPaginaJSP","Pagina Examen"));
    			if(ValidaString.isNullOrEmptyString(examenEspecialidad.getExesEstado()))
    				addActionError(getText("validacion.requerido","exesEstado","Estado"));
    			if(ValidaString.isNullOrEmptyString(examenEspecialidad.getExesPalabraclave()))
    				addActionError(getText("validacion.requerido","exesPalabraClave","Palabra Clave"));
    			if(examenEspecialidad.getExesOrden()<=0)
    				addActionError(getText("validacion.requerido","exesOrden","Orden"));
    			if(!hasActionErrors()){
    				examenEspecialidad.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(examenEspecialidad);
    				gestionFacadeHistoriaClinica.persistExamenespecialidad(examenEspecialidad);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    				examenEspecialidad.setTipoEspecialidad(gestionFacadeHistoriaClinica.findTipoespecialidadById(examenEspecialidad.getTipoEspecialidad().getTiesId()));
    			}else
    				listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			examenEspecialidad = gestionFacadeHistoriaClinica.findExamenespecialidadById(getIdLong());
    			listTipoEspecialidad = gestionFacadeHistoriaClinica.findAllTipoespecialidads();
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>examenEspecialidadMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}

	public HistoriaClinicaAction(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {ApplicationContext.CLASSPATH_ALL_URL_PREFIX+"applicationContext.xml"});
		this.gestionFacadeHistoriaClinica = GestionFacadeHistoriaClinica.getInstance(context);
	}
	
	public HistoriaClinicaAction(IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica) {
		this.gestionFacadeHistoriaClinica = gestionFacadeHistoriaClinica;
	}
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	public String getEstado() {return estado;}
	public void setEstado(String estado) {this.estado = estado;}
	public IGestionFacadeHistoriaClinica getGestionFacadeHistoriaClinica() {return gestionFacadeHistoriaClinica;}
	public void setGestionFacadeHistoriaClinica(IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica) {this.gestionFacadeHistoriaClinica = gestionFacadeHistoriaClinica;}
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
	public String getFechaHoraServicioSystem(){
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantesAplicativo.constanteFormatoFechaHora1);
		System.out.println("Fecha y Hora Servicio: ["+sdf.format(new Date())+"]");
		return sdf.format(new Date());
	}
	public String getDataAutoCompletado() {return dataAutoCompletado;}
	public void setDataAutoCompletado(String dataAutoCompletado) {this.dataAutoCompletado = dataAutoCompletado;}
	
	
	
}
