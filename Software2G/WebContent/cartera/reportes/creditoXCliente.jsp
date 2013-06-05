<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<tr>
					<td>
						<h1><strong><s:text name="creditossocios.creditoxcliente"></s:text></strong></h1>
						<s:if test="estado==null||estado=='findCreditoXCliente'">
							<s:submit value="Buscar" action="findReportCredCliente" cssClass="button"></s:submit>
						</s:if>
						<s:elseif test="estado=='listCreditoXCliente'">
							<s:submit value="Volver a Buscar" action="reportCredCliente" cssClass="button"></s:submit>
							<s:submit value="Imprimir" action="imprimirLiqHis" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='findCreditoXCliente'">
				<tr>
					<td class="text">
						<table cellpadding="0" cellspacing="0" border="0" width="70%">
							<tr>
								<td class="text">
									<s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.documentoPers" size="20" maxlength="15"></s:textfield>
									<s:select list="listTipoDoc" name="personaVO.tipodocumento.idTidoc" listKey="idTidoc" listValue="nombreTidoc" headerKey="-1" headerValue=".::Seleccione::." />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				</s:if>
				<s:elseif test="estado=='listCreditoXCliente'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" width="70%">
								<tr>
									<th class="text" align="left"><s:text name="personal.nombreCompleto"></s:text></th>
									<td ><s:property value="personaVO.nombreCompleto"/></td>
									<th class="text" align="left"><s:text name="personal.numerodocumento"></s:text></th>
									<td ><s:property value="personaVO.documentoPers"/>&nbsp;<s:property value="personaVO.tipodocumento.abreviaturaTidoc"/></td>
								</tr>
								<tr>
									<th class="text" align="left" colspan="1"><s:text name="personal.ubicaciongeo"></s:text></th>
									<td colspan="1"><s:property value="personaVO.ubicacionPersona"/></td>
									<td colspan="2"></td> 
								</tr>
								<tr>
									<th class="text" align="left" colspan="1"><s:text name="personal.direccion"></s:text></th>
									<td colspan="1"><s:property value="personaVO.direccionPers"/></td>
									<td colspan="2"></td> 
								</tr>
								<tr>
									<th class="text" align="left"><s:text name="personal.telefono"></s:text></th>
									<td><s:property value="personaVO.telefonoPers"/></td>
									<th class="text" align="left"><s:text name="personal.email"></s:text></th>
									<td><s:property value="personaVO.emailPers"/></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="creditoSociosTable">
								<thead>
									<tr>
										<th align="left">
											<s:text name="creditossocios.refcredito"></s:text>
										</th>
										<th align="left">
											<s:text name="tipocredito.nombretipocredito"></s:text>
										</th>
										<th align="left">
											<s:text name="pagare.nropagare"></s:text>
										</th>
										<th align="left">
											<s:text name="creditossocios.nrochequedesmbolso"></s:text>
										</th>
										<th align="left">
											<s:text name="creditossocios.estado"></s:text>
										</th>
										<th align="left">
											<s:text name="creditossocios.montocredito"></s:text>
										</th>
										<th align="left">
											<s:text name="creditossocios.saldo"></s:text>
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listCredito" id="data">
									<tr>
										<td>
											<s:property value="credId"/>
										</td>
										<td>
											<s:property value="tipocredito.ticrDescripcion"/>
										</td>
										<td>
											<s:property value="pagare.pagaId"/>
										</td>
										<td>
											<s:property value="credNrocheque"/>
										</td>
										<td>
											<s:property value="credEstado"/>
										</td>
										<td align="right">
											<s:property value="credMontocreditoView"/>
										</td>
										<td align="right">
											<s:property value="credSaldoView"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:elseif>
			</table>
			</div>
			<div class="spacer"></div>
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>
