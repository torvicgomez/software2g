package com.software2g.historia_clinica.action;

import java.util.Arrays;
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
import com.software2g.vo.Usuario;

public class HistoriaClinicaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeHistoriaClinica gestionFacadeHistoriaClinica;
	private String estado;
	private String funcPosicionado;
	private String id;
	
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
    		/*if(estado.equals(ConstantesAplicativo.constanteEstadoAll) || estado.equals(ConstantesAplicativo.constanteEstadoQuery)){
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
    		}*/
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>HistoriaClinicaAction>>>>servicioMethod>>>>estado salida-->>"+estado);
    	return Action.SUCCESS;
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
}
