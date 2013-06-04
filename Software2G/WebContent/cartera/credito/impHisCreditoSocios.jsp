<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tldPDF/pdf.tld" prefix="pdf" %>

<%String formatPag="LEGAL";
String nomArchivo = "HisCredito";
%>

<pdf:transform 
	screenWidth="930" 
	pageFormat= "<%=formatPag%>"
	pageOrientation="portrait" 
	pageInsets="25,15,20,15,points"
	enableImageSplit="false"
	inline="false"
	fileName="<%=nomArchivo%>">
<pdf:footer
	pageNumberTemplate="Pág. ${page}/${total}"
	pageNumberAlignment="left"
	color="#000000"
	initialPageNumber="1"
	pagesToSkip="0"
	fontSize="10"
	areaHeight="55"/>
		

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
		<table border="0" width="100%">
						<tr>
							<td valign="top">
								<table border="0" width="100%" style='font-family: Arial;font-size: 8px;'>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height='5' style='font-family: Arial;font-size: 8px;'>
										Apreciado Cliente:
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height='5' style='font-family: Arial;font-size: 8px;'>
										<s:property value="creditoVO.pagare.persona.pnombrePers"/> <s:property value="creditoVO.pagare.persona.snombrePers"/> <s:property value="creditoVO.pagare.persona.papellidoPers"/> <s:property value="creditoVO.pagare.persona.sapellidoPers"/> 
									</th>
									<th class="text" align="right" valign="top" colspan="3" height='5' style='font-family: Arial;font-size: 8px;'>
										<%=ConstantesAplicativo.textomsgCredito%>&nbsp;-<s:property value="creditoVO.credEstado"/>- N°&nbsp;<s:property value="creditoVO.credId"/>
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height='5' style='font-family: Arial;font-size: 8px;'>
										<s:property value="creditoVO.pagare.persona.tipodocumento.abreviaturaTidoc"/>. <s:property value="creditoVO.pagare.persona.documentoPers"/>
									</th>
									<th class="text" align="right" valign="top" colspan="3" height='5' style='font-family: Arial;font-size: 8px;'>
										<s:property value="creditoVO.tipocredito.ticrDescripcion"/>
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height='5' style='font-family: Arial;font-size: 8px;'>
										<s:property value="creditoVO.pagare.persona.emailPers"/>
									</th>
									<th class="text" align="right" valign="top" colspan="3" height='5' style='font-family: Arial;font-size: 8px;'>
										PAGARE N° <s:property value="creditoVO.pagare.pagaId"/>
									</th>
								</tr>
								</table>
							</td>
						</tr>
					</table>
			<table border="0" width="100%" align="center">
				<s:if test="estado==null||estado=='listarCreditosSocios'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="creditoSociosTable">
								
								<tbody>
								<s:iterator value="listCredito" id="data">
									<tr>
										<td width="5%">
											<a onclick="javascript:pagosCredito('<s:property value="credId"/>');">Pagos</a>
										</td>
										<td width="15%">
											<s:property value="credId"/>
										</td>
										<td width="50%">
											<s:property value="pagare.persona.pnombrePers"/>&nbsp;<s:property value="pagare.persona.snombrePers"/>&nbsp;<s:property value="pagare.persona.papellidoPers"/>&nbsp;<s:property value="pagare.persona.sapellidoPers"/>&nbsp;
											<s:property value="pagare.persona.documentoPers"/><s:property value="pagare.persona.tipodocumento.abreviaturaTidoc"/>
										</td>
										<td width="10%">
											<s:property value="credEstado"/>
										</td>
										<td width="10%" align="left">
											<s:property value="credSaldoView"/>
										</td>
										<td width="10%" align="left">
											<s:property value="credMontocreditoView"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				
				
				<s:elseif test="estado=='listPagosCredito'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<!--<tr>
									<td colspan="2" align="center" style='font-family: Arial;font-size: 14px;' bordercolor="Silver"><s:text name="creditossocios.historialpago"></s:text></td>
								</tr>-->
								<% int cont = 1;
									String width="100%"; 
								%>
								<s:iterator value="creditoVO.abonos" id="data">
								<%if(cont==1){%>
									<tr><td> 
								<%}else if((cont%2)==1){%>
									</td></tr><tr><td>
								<%}else if((cont%2)==0){ %>
									</td><td>
								<%}%>
								<s:if test="creditoVO.abonos.size==1"><%width="50%";%></s:if>
									<table border="0" width="<%=width%>" style='font-family: Arial;font-size: 8px;'>
											<tr bgcolor='Silver'>
												<th class="border">Periodo Liquidado</th>
												<th class="border">Dias Liquidados</th>
												<th class="border">Dias Mora</th>
											</tr>
											<tr>
												<td align="center"><s:property value="abonPeriodoliquidado"/></td>
												<td align="center"><s:property value="diasLiquidados"/></td>
												<td align="center"><s:property value="diasMora"/></td>
											</tr>
											<tr bgcolor='Silver'>
												<th class="border">Fecha Abono</th>
												<th class="border">Nro Comprobante</th>
												<th class="border">Registrado Por</th>
											</tr>
											<tr>
												<td align="center"><s:property value="abonFecha"/></td>
												<td align="center"><s:property value="abonNrocomprobante"/></td>
												<td align="center"><s:property value="abonRegistradopor"/></td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" width="100%" style='font-family: Arial;font-size: 8px;'>
														<tr>
															<th align="left" valign="top" bgcolor='Silver'>
																<s:text name="creditossocios.saldo"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="creditoVO.credSaldoView"/></font>
															</td>
														</tr>
														<tr>
															<th align="left" valign="top">
																<s:text name="tipocredito.interescorriente"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="abonValorinteresView"/></font>
															</td>
														</tr>
														<tr>
															<th align="left" valign="top" bgcolor='Silver'>
																<s:text name="tipocredito.interesmora"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="abonValorinteresmoraView"/></font>
															</td>
														</tr>
														<tr>
															<th align="left" valign="top">
																<s:text name="tipocredito.segurotipocredito"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="abonValorseguroView"/></font>
															</td>
														</tr>
														<tr>
															<th align="left" valign="top" bgcolor='Silver'>
																<s:text name="creditossocios.otroscargos"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="abonOtrocargoView"/></font>
															</td>
														</tr>
														<tr>
															<th align="left" valign="top" >
																<s:text name="creditossocios.abonoacapitaladc"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="abonValorcapitaladicionalView"/></font>
															</td>
														</tr>
														<tr>
															<th align="left" valign="top" bgcolor='Silver'>
																<s:text name="creditossocios.abonoacapital"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#FF0000"><s:property value="abonValorcapitalView"/></font>
															</td>
														</tr>
														
														<tr>
															<th align="left" valign="top" >
																<s:text name="creditossocios.totolapagar"></s:text>
															</th>
															<td align="right" valign="top">
																<font color="#009500"><s:property value="abonValortotalView"/></font>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									<%cont++;%>
								</s:iterator>
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