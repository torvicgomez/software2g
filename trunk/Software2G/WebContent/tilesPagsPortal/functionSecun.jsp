<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.software2g.vo.Usuario"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--<LINK REL=STYLESHEET TYPE="text/css" HREF="js/jpowered_style.css"> -->
<%
	Usuario usuarioLogin = (Usuario) request.getSession().getAttribute("usuarioLogin");
	String nameFileFuncUser = "inicial";
	//String nameFileFuncUser = "pruebasUtilidades"; 
	/*if(usuarioLogin.getNombreFileFunc()!=null&&!usuarioLogin.getNombreFileFunc().equals(""))
		nameFileFuncUser = usuarioLogin.getNombreFileFunc();
	else 
		nameFileFuncUser = "inicial";
	*/
 %>
<table width="100%" class="border">
  <tr>	
	<td valign="top">
     <applet name="TREEAPPLET" archive="<%=application.getContextPath()+"/tilesPagsPortal/Treemenu.jar"%>" code="TreeApplet.class" width="220" height="410" mayscript>
         <!-- Tree Properties -->
         <param name="backgroundColor" value="#FFFFFF">
         <param name="borderWidth" value="1">
         <param name="borderColor" value="#FFFFFF">
         <param name="underlineLinks" value="false">
         <param name="scrollBarBgColor" value="#FFFFFF">
         <param name="statusBar" value="false">
         <param name="connectingLines" value="true">
         <param name="connectingLinesColor" value="#887744">
         <param name="connectingLinesStyle" value="2">
         <param name="highTextColor" value="#FFFFFF">
         <param name="highBgColor" value="#0000FF">
         <param name="nodeOffset" value="25">
         <param name="nodegap" value="0">
         <!-- Default Node Settings -->
         <param name="defaultTarget" value="_top">
         <param name="defaultFont" value="Arial,N,12">
         <param name="defaultColor" value="#000000">
         <param name="defaultExpanded" value="false">
         <param name="defaultNormalImage"   value="document">
         <param name="defaultExpandedImage" value="document">
         <param name="defaultMouseImage"    value="point">
         <!-- Node File morenodes -->
         <param name="Nodedata" value="<%=application.getContextPath()%>/file/configuracionUser/<%=nameFileFuncUser%>.txt">
       </applet>
   </td>
  </tr>
</table>
