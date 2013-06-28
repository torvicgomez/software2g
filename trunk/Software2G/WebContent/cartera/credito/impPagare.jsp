<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tldPDF/pdf.tld" prefix="pdf" %>

<%String formatPag="NOTE";
String nomArchivo = "Pagare";
%>

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
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.deudor"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:hidden name="pagareVO.persona.idPers"></s:hidden>
										<s:property value="pagareVO.persona.pnombrePers"/>&nbsp;<s:property value="pagareVO.persona.snombrePers"/>&nbsp;<s:property value="pagareVO.persona.papellidoPers"/>&nbsp;<s:property value="pagareVO.persona.sapellidoPers"/>&nbsp;
										<s:property value="pagareVO.persona.documentoPers"/><s:property value="pagareVO.persona.tipodocumento.abreviaturaTidoc"/>&nbsp;<s:property value="pagareVO.persona.emailPers"/>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.tipopagare"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:hidden name="pagareVO.tipopagare.tipaId"></s:hidden>
										<s:property value="pagareVO.tipopagare.tipaDescripcion"/>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.fechapago"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:hidden name="pagareVO.pagaFechapago"></s:hidden>
										<s:property value="pagareVO.pagaFechapago"/>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.valorprestamo"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:hidden name="pagareVO.pagaMonto"></s:hidden>
										<s:property value="pagareVO.pagaMontoView"/>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.nombrecodeudor"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:hidden name="pagareVO.pagaCodeudor"></s:hidden>
										<s:property value="pagareVO.pagaCodeudor"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="pagare.direccioncodeudor"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:hidden name="pagareVO.pagaDircodeudor"></s:hidden>
										<s:property value="pagareVO.pagaDircodeudor"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="pagare.telefonocodeudor"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:hidden name="pagareVO.pagaTelcodeudor"></s:hidden>
										<s:property value="pagareVO.pagaTelcodeudor"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="pagare.estado"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:property value="pagareVO.pagaEstado"/>
									</td>
								</tr>
								<tr>
									
									<td class="text"  valign="top">
										<s:text name="pagare"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:property value="pagareVO.tipopagare.tipaId"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="tipaEncabezado"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:property value="pagareVO.tipopagare.tipaEncabezado"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="tipaContenidocentral"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:property value="pagareVO.tipopagare.tipaContenidocentral"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="tipaContenidofinal"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:property value="pagareVO.tipopagare.tipaContenidofinal"/>
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
