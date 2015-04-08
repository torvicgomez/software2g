package com.software2g.service.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software2g.historia_clinica.dao.ICodigoEnfermedadDao;
import com.software2g.historia_clinica.dao.IPreguntaDao;
import com.software2g.portal.dao.IPersonaDao;
import com.software2g.service.facade.IGestionFacadeAutoCompletado;
import com.software2g.util.ConstantesAplicativo;
import com.software2g.util.paintService.facade.IGestionFacadeExamenesConsulta;
import com.software2g.vo.Codigoenfermedade;
import com.software2g.vo.Persona;

@Transactional(propagation=Propagation.REQUIRED)
public class GestionFacadeAutoCompletado implements IGestionFacadeAutoCompletado, ServletRequestAware{
	private HttpServletRequest request;
	private static final String SERVICE_BEAN_ID = "gestionFacadeAutoCompletado";
	
	@Autowired
	IPersonaDao personaDao;
	@Autowired
	IPreguntaDao preguntaDao;
	@Autowired
	ICodigoEnfermedadDao codigoEnfermedadDao;
	
	public IPersonaDao getPersonaDao() {return personaDao;}
	public void setPersonaDao(IPersonaDao personaDao) {this.personaDao = personaDao;}
	public IPreguntaDao getPreguntaDao() {return preguntaDao;}
	public void setPreguntaDao(IPreguntaDao preguntaDao) {this.preguntaDao = preguntaDao;}
	public ICodigoEnfermedadDao getCodigoEnfermedadDao() {return codigoEnfermedadDao;}
	public void setCodigoEnfermedadDao(ICodigoEnfermedadDao codigoEnfermedadDao) {this.codigoEnfermedadDao = codigoEnfermedadDao;}
	
	public GestionFacadeAutoCompletado() {
		super();
	}
	
	public static IGestionFacadeAutoCompletado getInstance(ApplicationContext context) {
		return (IGestionFacadeAutoCompletado)context.getBean(SERVICE_BEAN_ID);
	}
	
	/**
	 * Metodo que consulta los examenes asociados a la institucion y especialidad corespondiente
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
	
	/**
	 * Metodo que consulta los examenes asociados a la institucion y especialidad corespondiente
	 * @return List<Object[]>
	 * @throws Exception
	 */
	public List<String> findAllPersonasProfesional(String datoFind)  throws Exception {
		try {
			List<Persona> listPersonas = getPersonaDao().findAllPersonasProfesional(datoFind);
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
	
	/**
	 * Metodo que consulta los codigos de enfermedades segun estandares internacionales segun especialidad
	 * @return List<Object[]>
	 * @throws Exception
	 */
	public List<String> findAllCodigoEnfermedadEspecialidad(String datoFind, String especialidad, String diagnostico)  throws Exception {
		try {
			List<Codigoenfermedade> listCodigoEnfermedad = getCodigoEnfermedadDao().findAllCodigoenfermedadesEspecialidad(datoFind, Long.parseLong(especialidad));
			List<String> list = new ArrayList<String>();
			if(listCodigoEnfermedad!=null&&listCodigoEnfermedad.size()>0){
				for(Codigoenfermedade elem:listCodigoEnfermedad){
					list.add("["+elem.getCoenCodigo()+"] "+elem.getCoenNombre() 
							+ConstantesAplicativo.constanteSplit+"onClick=\"javascript:cargarDatosDignostico(\'"+elem.getCoenId()+"\',\'"+diagnostico+"\')\"");
				}
			}
			return list;
		} catch (Exception e) {
			System.out.println("ERROR ::> GestionFacadeAutoCompletado ::> findAllCodigoEnfermedadEspecialidad ::> " + e.getMessage());
			return null;
		}
	}
	
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}
	

}
