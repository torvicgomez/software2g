package com.software2g.service.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.historia_clinica.dao.IEspecificaExamenDao;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.service.facade.IGestionFacadeAutoCompletado;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.paintService.facade.IGestionFacadeExamenesConsulta;
import com.software2g.vo.Persona;

@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadeAutoCompletado implements IGestionFacadeAutoCompletado, ServletRequestAware{
	private HttpServletRequest request;
	private static final String SERVICE_BEAN_ID = "gestionFacadeAutoCompletado";
	
	@Autowired
	IPersonaDao personaDao;
	
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	
	public GestionFacadeAutoCompletado() {
		super();
	}
	
	public static IGestionFacadeAutoCompletado getInstance(ApplicationContext context) {
		return (IGestionFacadeAutoCompletado)context.getBean(SERVICE_BEAN_ID);
	}
	
	/**
	 * Metodo que consulta los examenes aosiados a la institucion y especialidad corespondiente
	 * @return List<Object[]>
	 * @throws Exception
	 */
	public List<String> findPersonaPortal(String datoFind)  throws Exception {
		try {
			List<Persona> listPersonas = getPersonaDao().findAllPersonas(datoFind);
			List<String> list = new ArrayList<String>();
			if(listPersonas!=null&&listPersonas.size()>0){
				for(Persona elem:listPersonas){
					list.add("["+elem.getDocumentoPers()+" "+elem.getTipodocumento().getAbreviaturaTidoc()+"] "+elem.getNombreCompleto()+" "+elem.getEmailPers() 
							+ConstantesAplicativo.constanteSplit+"onClick=\"javascript:cargarDatosPersona(\'"+elem.getIdPers()+"\')\"");
				}
			}
			return list;
		} catch (Exception e) {
			System.out.println("ERROR ::> GestionFacadeAutoCompletado ::> findPersonaPortal ::> " + e.getMessage());
			return null;
		}
	}
	
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	

}
