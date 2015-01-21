package com.software2g.historia_clinica.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Anamnesi;
import com.software2g.vo.Finalidad;
import com.software2g.vo.Motivo;
import com.software2g.vo.Persona;
import com.software2g.vo.Profesionalsalud;
import com.software2g.vo.Seguridadsocial;
import com.software2g.vo.Servicio;
import com.software2g.vo.Usuario;

public class HistoriaClinicaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica;
	private String estado;
	private String funcPosicionado;
	private String id;
	private String dataAutoCompletado;
	
	private List<Profesionalsalud> listProfesionalSalud;
	private Profesionalsalud profesionalSalud;
	private InputStream strDatosPersona;
	
	public List<Profesionalsalud> getListProfesionalSalud() {return listProfesionalSalud;}
	public void setListProfesionalSalud(List<Profesionalsalud> listProfesionalSalud) {this.listProfesionalSalud = listProfesionalSalud;}
	public Profesionalsalud getProfesionalSalud() {return profesionalSalud;}
	public void setProfesionalSalud(Profesionalsalud profesionalSalud) {this.profesionalSalud = profesionalSalud;}
	
	
	private List<Persona> listPersona;
	private Persona persona;
	private List<Finalidad> listFinalidad;
	private List<Motivo> listMotivo;
	private List<Seguridadsocial> listSeguridadSocial;
	private Finalidad finalidad;
	private Motivo motivo;
	private Seguridadsocial seguridadSocial;
	private Anamnesi anamnesis;
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
	public Anamnesi getAnamnesis() {return anamnesis;}
	public void setAnamnesis(Anamnesi anamnesis) {this.anamnesis = anamnesis;}
	public Servicio getServicio() {return servicio;}
	public void setServicio(Servicio servicio) {this.servicio = servicio;}
	
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
	public String profesionalSaludMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>profesionalSaludMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProfesionalSalud = gestionFacadeHistoriaClinica.findAllProfesionalsaluds();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(profesionalSalud.getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			if(ValidaString.isNullOrEmptyString(profesionalSalud.getPrfsProfesion()))
    				addActionError(getText("validacion.requerido","prfsProfesion","Profesi�n"));
    			if(ValidaString.isNullOrEmptyString(profesionalSalud.getPrfsNrotarjetaprof()))
    				addActionError(getText("validacion.requerido","prfsNroTarjetaProf","Nro Tarjeta Profesional"));
    			if(ValidaString.isNullOrEmptyString(profesionalSalud.getPrfsEstado()))
    				addActionError(getText("validacion.requerido","prfsEstado","Estado"));
    			if(!hasActionErrors()){
    				profesionalSalud.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(profesionalSalud);
    				gestionFacadeHistoriaClinica.persistProfesionalsalud(profesionalSalud);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}/*else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			parametroCalendario = gestionFacadeAgenda.findParametroscalendarioById(getIdLong());
    		}*/
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>profesionalSaludMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	
	@SkipValidation
	public String servicioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>servicioMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listPersona = gestionFacadeHistoriaClinica.findAllPersonas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			System.out.println("entra esta parte!!!!!");
    			System.out.println("ID:["+this.getIdLong()+"]");
    			persona = gestionFacadeHistoriaClinica.findPersonaById(this.getIdLong());
    			System.out.println("Edad: ["+persona.getEdad()+"]");
    			listFinalidad = gestionFacadeHistoriaClinica.findAllFinalidads();
    			listMotivo = gestionFacadeHistoriaClinica.findAllMotivos();
    			listSeguridadSocial = gestionFacadeHistoriaClinica.findAllSeguridadsocials();
    			System.out.println("listFinalidad:["+listFinalidad+"]");
    			for(Finalidad elem: listFinalidad){
    				System.out.println("Finalidad:["+elem.getCodfinalidad()+"]-["+elem.getNomfinalidad()+"]");
    			}
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
	
	public InputStream getStrDatosPersona() {
		try{
			String html = "";
			long idPersona = Long.parseLong(request.getParameter("idPersona"));
			System.out.println("idPrograma: ["+idPersona+"]");
			Persona persona = gestionFacadeHistoriaClinica.findPersonaById(idPersona);
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
	
	public HistoriaClinicaAction(IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica) {this.gestionFacadeHistoriaClinica = gestionFacadeHistoriaClinica;}
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
