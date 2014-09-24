package com.software2g.historia_clinica.action;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.software2g.historia_clinica.facade.IGestionFacadeHistoriaClinica;
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
