<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.software2g.vo.Usuario"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	Usuario userLogin = (Usuario)request.getSession().getAttribute("usuarioVO");
 %>
<table width="100%" height="100%" border="0">
  <tr>
    <td align="right" valign="middle">
<%--     	<img src="<s:url value="/imagenes/Mujer.png"/>"> --%>
    	<strong><font size="2" color="31659C"><br>
    		<%=userLogin.getPersona().getNombreCompleto().toUpperCase()%><br>
   			<%=userLogin.getPersona().getEmailPers()%>&nbsp;&nbsp;-&nbsp;&nbsp;<%=userLogin.getLoginUsua()%><br>
   			<a href="/Software2G/salir.action" target="_parent">Salir</a>
   		</font></strong>
    </td>
   </tr>
</table>
