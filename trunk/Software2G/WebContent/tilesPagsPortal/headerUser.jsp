<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.software2g.vo.Usuario"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	Usuario userLogin = (Usuario)request.getSession().getAttribute("usuarioVO");
 %>
<table width="100%" height="100%" border="0">
  <!--<tr>
    <td align="center">
   		<strong>
   			<font size="2" color="#FF0000"><s:text name="messages.construction"></s:text></font>
   		</strong>
    </td>
  </tr>-->
  <tr>
    <!--background="<s:url value="/imagenes/imagenRight.gif"/>"-->
    <td align="right" valign="middle">
    	<strong><font size="2" color="#FFFFFF"><br><br>
    		<%=userLogin.getPersona().getNombreCompleto().toUpperCase()%><br>
   			<%=userLogin.getPersona().getEmailPers()%>&nbsp;&nbsp;-&nbsp;&nbsp;<%=userLogin.getLoginUsua()%><br>
   			<a href="salir.action" target="_parent">Salir</a>
   		</font></strong>
    </td>
   </tr>
</table>
