<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.zefer.pd4ml.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/tlds/plata.tld" prefix="pdf" %>

<pdf:transform 
	screenWidth="850" 
	pageFormat="A3"
	pageOrientation="portrait" 
	pageInsets="15,15,15,15,mm"
	enableImageSplit="false"
	inline="false"
	fileName="ejemplo.pdf"
>
<pdf:footer
	pageNumberTemplate="Pág. ${page}"
	pageNumberAlignment="right"
	color="#000000"
	initialPageNumber="1"
	pagesToSkip="0"
	fontSize="12"
	areaHeight="18"/>
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
								<table border="0" width="100%" height="50%">
								<tr>
									<th class="text" align="right" valign="top" colspan="3" height="5%">
										<%=ConstantesAplicativo.textomsgCredito%>&nbsp;-<s:property value="creditoVO.credEstado"/>- N°&nbsp;<s:property value="creditoVO.credId"/>
									</th>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="3" height="5%">
										<s:property value="creditoVO.tipocredito.ticrDescripcion"/>
									</th>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="3" height="5%">
									PAGARE N° <s:property value="creditoVO.pagare.pagaId"/>
									</th>
								</tr>
								<tr>
									<td class="text" align="right" valign="top" colspan="3" height="5%">
										<s:property value="creditoVO.credFechamodificacion"/>/<s:property value="creditoVO.credHora"/>&nbsp;&nbsp;<s:property value="creditoVO.credRegistradopor"/>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height="5%">
										Apreciado Cliente:
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height="5%">
										<s:property value="creditoVO.pagare.persona.pnombrePers"/> <s:property value="creditoVO.pagare.persona.snombrePers"/> <s:property value="creditoVO.pagare.persona.papellidoPers"/> <s:property value="creditoVO.pagare.persona.sapellidoPers"/> 
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height="5%">
										<s:property value="creditoVO.pagare.persona.tipodocumento.abreviaturaTidoc"/>. <s:property value="creditoVO.pagare.persona.documentoPers"/>
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="1" height="5%">
										<s:property value="creditoVO.pagare.persona.emailPers"/>
									</th>
								</tr>
								</table>
							</td>
							</tr>
							</table>
							<br>
							
							<table border="1" width="100%">
								<tr>
									<td>
										<table border="0" width="100%">
											<tr>
												<td>
													<table border="0" width="100%">
													<tr>
														<th class="text" align="left" valign="top" colspan="1">
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
														<th class="text" align="left" valign="top">
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
													<table border="0" width="100%">
														<tr>
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
													<table border="0" width="100%">
														<tr>
															<th class="text" align="left" valign="top" colspan="1" >
																INFORMACIÓN DE CORTE
															</th>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<font size="2"><s:text name="creditossocios.fechaultimopago"></s:text></font>
															</th>
															<td align="left" valign="top">
																<strong><font size="2" color="#FF0000"><s:property value="creditoVO.credFechaultimopago"/></font></strong>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<font size="2"><s:text name="creditossocios.fechadecorte"></s:text></font>
															</th>
															<td align="left" valign="top" >
																<strong><font size="2" color="#FF0000"><s:text name="creditoVO.fechaALiquidar"></s:text></font></strong>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<font size="2"><s:text name="creditossocios.diasliquidados"></s:text></font>
															</th>
															<td align="left" valign="top">
																<strong><font size="2" color="#FF0000"><s:property value="abonoVO.diasLiquidados"/></font></strong>
															</td>
														</tr>
														<tr>
															<th class="text" align="left" valign="top">
																<font size="2"><s:text name="creditossocios.diasmora"></s:text></font>
															</th>
															<td align="left" valign="top">
																<strong><font size="2" color="#FF0000"><s:property value="abonoVO.diasMora"/></font></strong>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table><br>
							<table border="0" width="80%">
								<tr>
									<th class="text" align="left" valign="top" colspan="8" >
										INFORMACIÓN DE SU PAGO ACTUAL
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" >
										<font size="2"><s:text name="creditossocios.saldo"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="creditoVO.credSaldoView"/></font></strong>
									</td>
									<td align="right" valign="top"> &nbsp;</td>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="tipocredito.interescorriente"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorinteresView"/></font></strong>
									</td>
									<td align="right" valign="top"> &nbsp;</td>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="tipocredito.interesmora"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorinteresmoraView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="tipocredito.segurotipocredito"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorseguroView"/></font></strong>
									</td>
									<td align="right" valign="top"> &nbsp;</td>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="creditossocios.otroscargos"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonOtrocargoView"/></font></strong>
									</td>
									
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="creditossocios.abonoacapitaladc"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorcapitaladicionalView"/></font></strong>
									</td>
									<td align="right" valign="top"> &nbsp;</td>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="creditossocios.abonoacapital"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorcapitalView"/></font></strong>
									</td>
									<td align="right" valign="top"> &nbsp;</td>
									<th class="text" align="left" valign="top" colspan="">
										<font size="2"><s:text name="creditossocios.totolapagar"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#009500"><s:property value="abonoVO.abonValortotalView"/></font></strong>
									</td>
								</tr>
							</table>
							
			</div>
		</s:form>
	</body>
</html>
</pdf:transform>