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
	List<Object[]> listExamenesConsulta = datos.obtenerExamenesConsulta(Long.parseLong(idInstitucion), Long.parseLong(idEspecialidad));
	System.out.println("listExamenesConsulta:["+listExamenesConsulta+"]");
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	Construccion!!!!
</body>
</html>