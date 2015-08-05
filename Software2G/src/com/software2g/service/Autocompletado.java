package com.software2g.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.software2g.service.facade.IGestionFacadeAutoCompletado;
import com.software2g.service.facade.impl.GestionFacadeAutoCompletado;
import com.software2g.util.ConstantesAplicativo;


public class Autocompletado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/json");
            try {
                    String term = request.getParameter("term");
                    String tipo = request.getParameter("tipo");
                    String especialidad = request.getParameter("especialidad");
                    String diagnostico =  request.getParameter("diagnostico");
                    ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {ApplicationContext.CLASSPATH_ALL_URL_PREFIX+"autocompletado.xml"});
            		IGestionFacadeAutoCompletado gestionFacadeAutoCompletado = GestionFacadeAutoCompletado.getInstance(context);
            		List<String> list = new ArrayList<String>();
            		
            		if(tipo!=null&&tipo.equals(ConstantesAplicativo.constanteTipoSearchAutoComplProf))
            			list = gestionFacadeAutoCompletado.findAllPersonasProfesional(term);
            		else if (tipo!=null&&tipo.equals(ConstantesAplicativo.constanteTipoSearchAutoComplDiag))
            			list = gestionFacadeAutoCompletado.findAllCodigoEnfermedadEspecialidad(term, especialidad, diagnostico);
            		else if (tipo!=null&&tipo.equals(ConstantesAplicativo.constanteTipoSearchAutoArticulo))
            			list = gestionFacadeAutoCompletado.findAllArticulo(term);
            		else 
            			list = gestionFacadeAutoCompletado.findPersonaPortal(term);
                    
                    String searchList = new Gson().toJson(list);
                    response.getWriter().write(searchList);
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }
    }
}
