<!-- <!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%-- <%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %> --%>
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>
<%-- <% --%>
<!-- // 	String url = request.getSession().getAttribute("url")==null?"":(String)request.getSession().getAttribute("url"); -->
<%-- %>  --%>
<!-- <table width="100%"> -->
<!--   <tr> -->
<!--     <td align="left"> -->
<%--    		Ubicación:&nbsp;<strong><font size="2" color="#FF0000"><%=url%></font></strong> --%>
<!--     </td> -->
<!--   </tr> -->
<!-- </table> -->
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<table width="100%"><tr><td>Ubicación:&nbsp;<strong><s:property value="funcPosicionado"/></strong></td></tr></table>