<%@page import="com.software2g.vo.Pagare"%>
<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tldPDF/pdf.tld" prefix="pdf" %>

<%String formatPag="LEGAL";
String nomArchivo = "Pagare";
%>
<pdf:transform 
	screenWidth="930" 
	pageFormat= "<%=formatPag%>"
	pageOrientation="portrait" 
	pageInsets="25,15,20,15,points"
	enableImageSplit="false"
	inline="false"
	fileName="<%=nomArchivo%>">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/syntax/css/shCore.css'/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT> 
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
	
</head>
<body id="dt_example">
		<s:form id="form">
		<div id="demo">
			<table border="0" width="100%" align="center">
				
				<s:if test="estado==null||estado=='listarPagares'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="pagaresTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.dtll"></s:text>
										</th>
										<th align="left"  width="5%">
											<s:text name="columna.view"></s:text>
										</th>
										<th align="left"  width="10%">
											<s:text name="pagare.tipopagare"></s:text>
										</th>
										<th align="left"  width="10%">
											<s:text name="pagare.estado"></s:text>
										</th>
										<th align="left"  width="35%">
											<s:text name="pagare.deudor"></s:text>
										</th>
										<th align="left"  width="25%">
											<s:text name="pagare.codeudor"></s:text>
										</th>
									</tr>
								</thead>
							</table>
						</td>
					</tr>
				</s:if>
				
				<s:elseif test="estado=='editarPagare'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text"  valign="top">
										<p align="center">PAGARE N° <s:property value="pagareVO.pagaId"/> </p>
									</td>
									
								</tr>
								<tr>
									<td class="text"  valign="top">
										<p align="justify"><br><s:property value="pagareVO.tipopagare.tipaEncabezado"/></p>	
									</td>
								</tr>
								<tr> 
									<td class="text"  valign="top">
										<br>
									</td>
								</tr>
								<tr> 
									<td class="text"  valign="top">
										<p align="justify"><s:property value="pagareVO.tipopagare.tipaContenidocentral"/></p>
									</td>
								</tr>
								<tr> 
									<td class="text"  valign="top">
										<br>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<!--<p align="justify"><br><s:property value="pagareVO.tipopagare.tipaContenidofinal"/></p>-->
										<table width="80%" border="0">
											<tr>
												<td colspan="4">Se suscribe este título, en la ciudad de FRESNO a los <s:property value="diaPagare"/> días del mes <s:property value="mesPagare"/> del año <s:property value="anoPagare"/>.<br><br></td>
											</tr>
											<tr>
												<td width="10%">DEUDOR:</td>
												<td width="30%"><s:property value="pagareVO.persona.pnombrePers"/>&nbsp;<s:property value="pagareVO.persona.snombrePers"/>&nbsp;<s:property value="pagareVO.persona.papellidoPers"/>&nbsp;<s:property value="pagareVO.persona.sapellidoPers"/></td>
												<td width="10%">CODEUDOR:</td>
												<td width="30%"><s:property value="pagareVO.pagaCodeudor"/></td>
											</tr>
											<tr>
												<td>C.C O NIT:</td>
												<td><s:property value=" pagareVO.Persona.DocumentoPers"/></td>
												<td>C.C O NIT:</td>
												<td><s:property value=" "/></td>
											</tr>
											<tr>
												<td>DIRECCIÓN:</td>
												<td><s:property value="pagareVO.persona.direccionPers"/></td>
												<td>DIRECCIÓN:</td>
												<td><s:property value="pagareVO.pagaDircodeudor"/></td>
											</tr>
											<tr>
												<td>TELÉFONO:</td>
												<td><s:property value="pagareVO.persona.telefonoPers"/> </td>
												<td>TELÉFONO:</td>
												<td><s:property value="pagareVO.PagaTelcodeudor"/></td>
											</tr>
											<tr>
												<td><br><br></td>
											</tr>
											<tr>
												<td>Firma:</td>
												<td></td>
												<td>Firma:</td>
												<td></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:elseif>
			</table>
			</div>
			
		</s:form>
	</body>
</html>
</pdf:transform>