package com.software2g.agenda.action;

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
import com.software2g.agenda.dao.impl.JornadaLaboralDAOImpl;
import com.software2g.agenda.facade.IGestionFacadeAgenda;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.ValidaString;
import com.software2g.vo.Jorandalaboral;
import com.software2g.vo.Parametroscalendario;
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
	
	public List<Parametroscalendario> getListParametroCalendrio() {return listParametroCalendrio;}
	public void setListParametroCalendrio(List<Parametroscalendario> listParametroCalendrio) {this.listParametroCalendrio = listParametroCalendrio;}
	public Parametroscalendario getParametroCalendario() {return parametroCalendario;}
	public void setParametroCalendario(Parametroscalendario parametroCalendario) {this.parametroCalendario = parametroCalendario;}
	public List<Jorandalaboral> getListJornadaLaboral() {return listJornadaLaboral;}
	public void setListJornadaLaboral(List<Jorandalaboral> listJornadaLaboral) {this.listJornadaLaboral = listJornadaLaboral;}
	public Jorandalaboral getJornadaLaboral() {return jornadaLaboral;}
	public void setJornadaLaboral(Jorandalaboral jornadaLaboral) {this.jornadaLaboral = jornadaLaboral;}
	
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
    	System.out.println("######>>>>>>>AgendaAction>>>>jornadaLaboralMethod>>>>estado salida-->>"+estado);
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
}
