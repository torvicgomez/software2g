<%@page import="java.util.List"%>
<%@page import="com.software2g.util.UtilArchivo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String file = request.getParameter("archivo");
	String fileSelect = request.getParameter("fileSelect");
	System.out.println("file:["+file+"]");
	System.out.println("realPath:["+request.getRealPath("/")+"]");
	List<String> list = UtilArchivo.leerArchivoBecas(request.getRealPath("/")+"PruebasUtil\\"+file);
	for(String elem:list){
		System.out.println("linea:["+elem+"]");
	}
	
	
	
	
%>
<body>

</body>
</html>