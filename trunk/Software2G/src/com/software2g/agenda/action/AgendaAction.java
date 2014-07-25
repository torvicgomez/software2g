package com.software2g.agenda.action;

import java.util.Date;
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
import com.software2g.vo.Parametroscalendario;

public class AgendaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IGestionFacadeAgenda gestionFacadeAgenda;
	private String estado;
	private String funcPosicionado;

	private List<Parametroscalendario> listParametroCalendrio;
	private Parametroscalendario parametroCalendario;
	
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
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoAdd)){
    			System.out.println("Construcción!!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoSave)){
    			/*if(ValidaString.isNullOrEmptyString(costo.getCostNombre()))
    				addActionError(getText("validacion.requerido","costNombre","Nombre Costo"));
    			if(ValidaString.isNullOrEmptyString(costo.getCostDescripcion()))
    				addActionError(getText("validacion.requerido","costDescripcion","Descripcion"));
    			if(!hasActionErrors()){
    				usuarioLogin = (UsuarioLogin)request.getSession().getAttribute("UsuarioLogin");
        			costo.setCostRegistradopor(usuarioLogin.getIdUsuario());
        			costo.setCostFechacambio(new Date());
    				gestionFacadeAsigViajes.persistCosto(costo);
    				costo.setTipocosto(gestionFacadeAsigViajes.findTipocostoById(costo.getTipocosto().getTcosId()));
    				costo.setMecanismocriterioviaje(gestionFacadeAsigViajes.findMecanismocriterioviajeById(costo.getMecanismocriterioviaje().getMecaId()));
    				estado = ConstantesAplicativo.constanteEstadoAbstract;
    				addActionMessage(getText("accion.satisfactoria"));
    			}else{
    				listMecanismocriterioviajes = gestionFacadeAsigViajes.findAllMecanismocriterioviajes();
        			listTipoCosto = gestionFacadeAsigViajes.findAllTipocostos();
    			}*/
    			System.out.println("Construcción!!!!!!!");
    		}else if(estado.equals(ConstantesAplicativo.constanteEstadoEdit)||estado.equals(ConstantesAplicativo.constanteEstadoAbstract)){
    			/*listMecanismocriterioviajes = gestionFacadeAsigViajes.findAllMecanismocriterioviajes();
    			listTipoCosto = gestionFacadeAsigViajes.findAllTipocostos();
    			costo = gestionFacadeAsigViajes.findCostoById(getIdLong());
    			*/
    			System.out.println("Construcción!!!!!!!");
    		}
    			
    	} catch(Exception e){
    		e.printStackTrace();
    		addActionError(getText("error.aplicacion"));
    	}
    	System.out.println("######>>>>>>>AgendaAction>>>>paramCalendarioMethod>>>>estado salida-->>"+estado);
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
}
