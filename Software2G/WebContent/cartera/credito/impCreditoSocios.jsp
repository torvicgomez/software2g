<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.zefer.pd4ml.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/tldPDF/pdf.tld" prefix="pdf" %>

<%String formatPag="LEGAL";
String nomArchivo = "Credito";
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
	pageNumberAlignment="right"
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
							<table border="0" width="100%">
								<tr>
									<td valign="top">
										<table border="0" width="100%">
											<tr>
												<td valign="top">
													<table border="0" width="100%" style='font-family: Arial;font-size: 8px;'>
													<tr bgcolor='Silver'>
														<th class="text" align="left" valign="top" colspan="1" >
															INFORMACIÓN BÁSICA
														</th>
													</tr>
													<tr>
														<th class="text" align="left" valign="top">
															<s:text name="tipocredito.interescorriente"></s:text>
														</th>
														<td class="text" align="left" valign="top">
															<s:property value="creditoVO.tipocredito.ticrTasainteresvencido"/>&nbsp;%
														</td>
													</tr>
													<tr>
														<th class="text" align="left" valign="top" >
															<s:text name="tipocredito.interesmora"></s:text>
														</th>
														<td class="text" align="left" valign="top">
															<s:property value="creditoVO.tipocredito.ticrInteresmoramesven"/>&nbsp;%
														</td>
													</tr>
													<tr>
														<th class="text" align="left" valign="top">
															<s:text name="tipocredito.interesefectivoanual"></s:text>
														</th>
														<td class="text" align="left" valign="top">
															<s:property value="creditoVO.tipocredito.ticrInteresefectivoanual"/>&nbsp;%
														</td>
													</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
									<td valign="top">
										<table border="0">
											<tr>
												<td>
													<table border="0" width="100%" style='font-family: Arial;font-size: 8px;'>
														<tr bgcolor='Silver'>
															<th class="text" align="left" valign="top" colspan="1">
																INFORMACIÓN DE SU CRÉDITO
															</th>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<s:text name="creditossocios.nrochequedesmbolso"></s:text>
															</th>
															<td class="text" align="left" valign="top">
																<s:property value="creditoVO.credNrocheque"/>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<s:text name="creditossocios.montocredito"></s:text>
															</th>
															<td class="text" align="left" valign="top">
																<s:property value="creditoVO.credMontocreditoView"/>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
									<td valign="top">
										<table border="0">
											<tr>
												<td>
													<table border="0" width="100%" style='font-family: Arial;font-size: 8px;'>
														<tr bgcolor='Silver'>
															<th class="text" align="left" valign="top" colspan="1">
																INFORMACIÓN DE CORTE
															</th>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<s:text name="creditossocios.fechaultimopago"></s:text>
															</th>
															<td align="left" valign="top">
																<font color="#FF0000"><s:property value="creditoVO.credFechaultimopago"/></font>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<s:text name="creditossocios.fechadecorte"></s:text>
															</th>
															<td align="left" valign="top" >
																<font color="#FF0000"><s:text name="creditoVO.fechaALiquidar"></s:text></font>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<s:text name="creditossocios.diasliquidados"></s:text>
															</th>
															<td align="left" valign="top">
																<font color="#FF0000"><s:property value="abonoVO.diasLiquidados"/></font>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<s:text name="creditossocios.diasmora"></s:text>
															</th>
															<td align="left" valign="top">
																<font color="#FF0000"><s:property value="abonoVO.diasMora"/></font>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table border="0" width="100%" style='font-family: Arial;font-size: 8px;'>
								<tr bgcolor='Silver'>
									<th class="text" align="right" valign="top" colspan="8" >
										INFORMACIÓN DE SU PAGO ACTUAL
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" >
										<s:text name="creditossocios.saldo"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="creditoVO.credSaldoView"/></font>
									</td>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="tipocredito.interescorriente"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="abonoVO.abonValorinteresView"/></font>
									</td>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="tipocredito.interesmora"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="abonoVO.abonValorinteresmoraView"/></font>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="tipocredito.segurotipocredito"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="abonoVO.abonValorseguroView"/></font>
									</td>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="creditossocios.otroscargos"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="abonoVO.abonOtrocargoView"/></font>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="creditossocios.abonoacapitaladc"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="abonoVO.abonValorcapitaladicionalView"/></font>
									</td>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="creditossocios.abonoacapital"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#FF0000"><s:property value="abonoVO.abonValorcapitalView"/></font>
									</td>
									<th class="text" align="left" valign="top" colspan="">
										<s:text name="creditossocios.totolapagar"></s:text>
									</th>
									<td align="left" valign="top">
										<font color="#009500"><s:property value="abonoVO.abonValortotalView"/></font>
									</td>
								</tr>
								<tr><td><br></td></tr>
								<tr>
									<td class="text" align="right" valign="top" colspan="10" height='5' style='font-family: Arial;font-size: 8px;'>
										<s:property value="creditoVO.credFechamodificacion"/>/<s:property value="creditoVO.credHora"/>&nbsp;&nbsp;<s:property value="creditoVO.credRegistradopor"/>
									</td>
								</tr>
							</table>
							
			</div>
		</s:form>
	</body>
</html>
</pdf:transform>