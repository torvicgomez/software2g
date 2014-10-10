package com.software2g.util.paintService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.software2g.util.paintService.facade.IGestionFacadeExamenesConsulta;
import com.software2g.util.paintService.facade.impl.GestionFacadeExamenesConsulta;
import com.software2g.vo.Especificaexamen;
import com.software2g.vo.Valorexamen;
import com.software2g.vo.Variableexamen;

public class CargarExamenesConsulta {
	public CargarExamenesConsulta(){}
	
	public List<Especificaexamen> obtenerExamenesConsulta(long idInstitucion, long idEspecialidad) throws Exception{
		System.out.println("******************************************************************************");
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {ApplicationContext.CLASSPATH_ALL_URL_PREFIX+"cargarExamenesConsulta.xml"});
		IGestionFacadeExamenesConsulta gestionFacadeExamenesConsulta = GestionFacadeExamenesConsulta.getInstance(context);
		List<Object[]> listExamenesConsulta = gestionFacadeExamenesConsulta.findExamenesConsultaEspecialidad(idInstitucion, idEspecialidad);
		List<Especificaexamen> listEspecificacionExamen = null;
		if(listExamenesConsulta!=null&&listExamenesConsulta.size()>0){
			listEspecificacionExamen = new ArrayList<Especificaexamen>();
			String idEspecificaExamen = null;
			String examen = null;
			String valoresExamen = null;
			Especificaexamen especificaExa = null;
			Variableexamen variableExamen = null;
			Valorexamen valorExamen = null;
			for(Object[] elem:listExamenesConsulta){
				
				if(idEspecificaExamen==null||!idEspecificaExamen.equals(elem[0].toString())){
					if(idEspecificaExamen!=null)
						listEspecificacionExamen.add(especificaExa);
					especificaExa = new Especificaexamen();
					especificaExa.setListVariableExamen(new ArrayList<Variableexamen>());
					especificaExa.setIdEspeciexam(Long.parseLong(elem[0].toString()));
					especificaExa.setAbreviatura(elem[1].toString());
					idEspecificaExamen = elem[0].toString();
				}
				
				if(examen==null||!examen.equals(elem[3])){
					variableExamen = new Variableexamen();
					variableExamen.setListValorExamen(new ArrayList<Valorexamen>());
					variableExamen.setNomvarexam(elem[3].toString());
					variableExamen.setAbrevaexamen(elem[4].toString());
					especificaExa.getListVariableExamen().add(variableExamen);
//					System.out.println("se adiciona exmaen");
					examen = elem[3].toString();
				}
//				else if(examen!=null&&examen.equals(elem[3])){
//					variableExamen = new Variableexamen();
//					variableExamen.setNomvarexam(elem[3].toString());
//					variableExamen.setAbrevaexamen(elem[4].toString());
//					especificaExa.getListVariableExamen().add(variableExamen);
//					System.out.println("se adiciona exmaen ");
//				}
				
				
				if(elem[6]!=null){
					if(valoresExamen==null||!valoresExamen.equals(elem[6].toString())){
						valorExamen = new Valorexamen();
						valorExamen.setValorexamen(elem[6].toString());
						variableExamen.getListValorExamen().add(valorExamen);
						valoresExamen = elem[6].toString();
//						System.out.println("se adiciona valores examens");
					}
//					else if(valoresExamen!=null&&valoresExamen.equals(elem[6].toString())){
//						valorExamen = new Valorexamen();
//						valorExamen.setValorexamen(elem[6].toString());
//						variableExamen.getListValorExamen().add(valorExamen);
//					}
				}
//				System.out.println("elem[0]:["+elem[0]+"]");
//				System.out.println("elem[1]:["+elem[1]+"]");
//				System.out.println("elem[2]:["+elem[2]+"]");
//				System.out.println("elem[3]:["+elem[3]+"]");
//				System.out.println("elem[4]:["+elem[4]+"]");
//				System.out.println("elem[5]:["+elem[5]+"]");
//				System.out.println("elem[6]:["+elem[6]+"]");
//				System.out.println("elem[7]:["+elem[7]+"]");
//				System.out.println("----------------------------------------------------");
			}
			listEspecificacionExamen.add(especificaExa);
		}else{
			System.out.println("Lista es Nula!!!!!!");
		}
		
//		for(Especificaexamen elem:listEspecificacionExamen){
//			System.out.println("* Especificacion Examen: ["+elem.getAbreviatura()+"]");
//			if(elem.getListVariableExamen()!=null&&elem.getListVariableExamen().size()>0){
//				for(Variableexamen elem1:elem.getListVariableExamen()){
//					System.out.println("* -----> Examen: ["+elem1.getNomvarexam()+"]-["+elem1.getAbrevaexamen()+"]");
//					if(elem1.getListValorExamen()!=null&&elem1.getListValorExamen().size()>0){
//						for(Valorexamen elem2:elem1.getListValorExamen()){
//							System.out.println("* ----------> Valor Examen: ["+elem2.getValorexamen()+"]");
//						}
//					}else{
//						System.out.println("* -----> Lista Valores Examenes es Nula!!");
//					}
//				}
//			}else{
//				System.out.println("* Lista Examenes es Nula!!");
//			}
//			System.out.println("***************************************************************************");
//			System.out.println("---------------------------------------------------------------------------");
//		}
		
		System.out.println("******************************************************************************");
		return listEspecificacionExamen;
	}
}
