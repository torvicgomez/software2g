<%@page import="com.software2g.vo.Valorexamen"%>
<%@page import="com.software2g.vo.Variableexamen"%>
<%@page import="com.software2g.vo.Especificaexamen"%>
<%@page import="java.util.List"%>
<%@page import="com.software2g.util.paintService.CargarExamenesConsulta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String idInstitucion = request.getParameter("idInstitucion");
	String idEspecialidad = request.getParameter("idEspecialidad");
	System.out.println("**********************************************");
	System.out.println("idInstitucion:["+idInstitucion+"]");
	System.out.println("idEspecialidad:["+idEspecialidad+"]");
	System.out.println("**********************************************");
	CargarExamenesConsulta datos = new CargarExamenesConsulta(); 
	List<Especificaexamen> listExamenesConsulta = datos.obtenerExamenesConsulta(Long.parseLong(idInstitucion), Long.parseLong(idEspecialidad));
	datos = null;
	System.out.println("listExamenesConsulta:["+listExamenesConsulta+"]");
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	Construccion!!!!
	<%
		for(Especificaexamen elem:listExamenesConsulta){
			System.out.println("***************************************************************************");
			System.out.println("* Especificacion Examen: ["+elem.getAbreviatura()+"]");
	%>
			<br><input type="checkbox" id="<%=elem.getIdEspeciexam()%>"/><%=elem.getAbreviatura()%><br>
	<%
			if(elem.getListVariableExamen()!=null&&elem.getListVariableExamen().size()>0){
				for(Variableexamen elem1:elem.getListVariableExamen()){
					System.out.println("* -----> Examen: ["+elem1.getNomvarexam()+"]-["+elem1.getAbrevaexamen()+"]");
					if(elem1.getListValorExamen()!=null&&elem1.getListValorExamen().size()>0){
	%>
						<%=elem1.getNomvarexam()%><select id="<%=elem1.getNomvarexam()%>">			
	<%
						for(Valorexamen elem2:elem1.getListValorExamen()){
							System.out.println("* ----------> Valor Examen: ["+elem2.getValorexamen()+"]");
	%>
							<option value="<%=elem2.getValorexamen()%>"><%=elem2.getValorexamen()%></option>
	<%
						}
	%>
						</select>
	<%
					}else{
						System.out.println("* -----> Lista Valores Examenes es Nula!!");
	%>
					<%=elem1.getNomvarexam()%><input type="text" id="<%=elem1.getNomvarexam()%>" />				
	<%
					}
				}
			}else{
				System.out.println("* Lista Examenes es Nula!!");
			}
			System.out.println("***************************************************************************");
			System.out.println("---------------------------------------------------------------------------");
		}
	 %>
</body>
</html>