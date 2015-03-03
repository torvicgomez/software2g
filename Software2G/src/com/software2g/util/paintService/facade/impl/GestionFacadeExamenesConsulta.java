package com.software2g.util.paintService.facade.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.software2g.historia_clinica.dao.IEspecificaExamenDao;
import com.software2g.util.paintService.facade.IGestionFacadeExamenesConsulta;

@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadeExamenesConsulta implements IGestionFacadeExamenesConsulta, ServletRequestAware {
	private HttpServletRequest request;
	private static final String SERVICE_BEAN_ID = "gestionFacadeExamenesConsulta";
	
//	@Autowired
//	IEspecificaExamenDao especificacionExamenDao;
//	
//	public IEspecificaExamenDao getEspecificacionExamenDao() {return especificacionExamenDao;}
//	public void setEspecificacionExamenDao(IEspecificaExamenDao especificacionExamenDao) {this.especificacionExamenDao = especificacionExamenDao;}
	
	
	public GestionFacadeExamenesConsulta() {
		super();
	}
	public static IGestionFacadeExamenesConsulta getInstance(ApplicationContext context) {
		return (IGestionFacadeExamenesConsulta)context.getBean(SERVICE_BEAN_ID);
	}
	
	/**
	 * Metodo que consulta los examenes aosiados a la institucion y especialidad corespondiente
	 * @return List<Object[]>
	 * @throws Exception
	 */
	public List<Object[]> findExamenesConsultaEspecialidad(long idInstitucion, long idEspecialidad)  throws Exception {
		try {
			return null;//getEspecificacionExamenDao().findExamenesConsultaEspecialidad(idInstitucion, idEspecialidad);
		} catch (Exception e) {
			System.out.println("ERROR ::> GestionFacadeExamenesConsulta ::> findExamenesConsultaEspecialidad ::> " + e.getMessage());
			return null;
		}
	}
	
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
}
