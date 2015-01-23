package com.software2g.agenda.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.software2g.agenda.facade.IGestionFacadeAgenda;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Agenda;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Parametroscalendario;
import com.software2g.vo.Persona;
import com.software2g.vo.Profesional;
import com.software2g.vo.Usuario;

public class AgendaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeAgenda gestionFacadeAgenda;
	private String estado;
	private String funcPosicionado;
	private String id;

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
	private Agenda agendaMedica;
	
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
	public Agenda getAgendaMedica() {return agendaMedica;}
	public void setAgendaMedica(Agenda agendaMedica) {this.agendaMedica = agendaMedica;}
	
	
	@SkipValidation
	public String calendarioMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		System.out.println("En Construcción Agenda!!!!!");
    	} catch (Exception e) {
			addActionMessage(getText("error.aplicacion"));
			e.printStackTrace();
		}
		System.out.println("result Agenda: ["+result+"]");
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
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>profesionalSaludMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listProfesional = gestionFacadeAgenda.findAllProfesionals();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(profesional.getPersona().getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfEspecialidad()))
    				addActionError(getText("validacion.requerido","prfsProfesion","Profesión"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfNrotarjetaprof()))
    				addActionError(getText("validacion.requerido","prfsNroTarjetaProf","Nro Tarjeta Profesional"));
    			if(ValidaString.isNullOrEmptyString(profesional.getProfEstado()))
    				addActionError(getText("validacion.requerido","prfsEstado","Estado"));
    			if(!hasActionErrors()){
    				profesional.setPersona(gestionFacadeAgenda.findPersonaById(profesional.getPersona().getIdPers()));
    				profesional.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(profesional);
    				gestionFacadeAgenda.persistProfesional(profesional);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			profesional = gestionFacadeAgenda.findProfesionalById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>profesionalSaludMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	@SkipValidation
	public String agendaMedicaMethod(){
		String  result = Action.SUCCESS; 
    	try { 
    		getFuncionPosicionado();
    		System.out.println("######>>>>>>>HistoriaClinicaAction>>>>agendaMedicaMethod>>>>estado entrada-->>"+estado);
    		if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
    			listAgendaMedica  = gestionFacadeAgenda.findAllAgendas();
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			if(agendaMedica.getProfesional().getPersona().getIdPers()<=0)
    				addActionError(getText("validacion.requerido","prfsIdPers","Seleccione al Profesional de la Salud"));
    			
    			if(!hasActionErrors()){
    				agendaMedica.getProfesional().setPersona(gestionFacadeAgenda.findPersonaById(agendaMedica.getProfesional().getPersona().getIdPers()));
    				agendaMedica.setDatosAud(this.getDatosAud());
    				ValidaString.imprimirObject(agendaMedica);
    				gestionFacadeAgenda.persistAgenda(agendaMedica);
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			agendaMedica= gestionFacadeAgenda.findAgendaById(getIdLong());
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>agendaMedicaMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
	}
	
	public AgendaAction(IGestionFacadeAgenda gestionFacadeAgenda) {this.gestionFacadeAgenda = gestionFacadeAgenda;}
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
			System.out.println("idPrograma: ["+idPersona+"]");
			Persona persona = gestionFacadeAgenda.findPersonaById(idPersona);
			html = "<s:textfield name=\"dataAutoCompletado\" id=\"search\" size=\"60\" maxlength=\"30\" cssClass=\"inputs\"></s:textfield><br>";
			html += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">"+
					"	<tr> " +
					"		<td class=\"leftLabel\">Nombre</td> " +
					"		<td>" + persona.getNombreCompleto() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Documento Identificación</td> " +
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
					"		<td class=\"leftLabel\">Correo Electrónico</td> " +
					"		<td>" + persona.getEmailPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Teléfonos</td> " +
					"		<td>" + persona.getTelefonoPers() + "</td> " +
					"	</tr> " +
					"	<tr> " +
					"		<td class=\"leftLabel\">Ubicación</td> " +
					"		<td>" + persona.getUbicacionPersona() + " " + persona.getDireccionPers() + "</td> " +
					"	</tr> " +
					"</table>";
			strDatosPersona = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return strDatosPersona;
	}
}
