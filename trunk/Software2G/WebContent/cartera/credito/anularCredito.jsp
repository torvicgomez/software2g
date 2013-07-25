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
						<h1><strong><s:text name="Anular Credito"></s:text></strong></h1>
						
						<s:if test="estado==null||estado=='findRefCredito'">
							<s:submit value="Buscar" action="anularCredito" cssClass="button"></s:submit>
						</s:if>
						<s:elseif test="estado=='creditoAnular'">
							<s:submit value="Volver a Buscar" action="findRefCredito" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='findRefCredito'">
				<tr>
					<td class="text">
						<table cellpadding="0" cellspacing="0" border="0" width="70%">
							<tr>
								<td class="text">
									<s:text name="creditossocios.refcredito"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="creditoVO.credId" size="20" maxlength="15"></s:textfield>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				</s:if>
				<s:elseif test="estado=='creditoAnular'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" align="right" valign="top" colspan="6">
										<s:property value="creditoVO.credFechamodificacion"/>/<s:property value="creditoVO.credHora"/>&nbsp;&nbsp;<s:property value="creditoVO.credRegistradopor"/>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="6">
										<s:property value="creditoVO.credId"/>-<%=ConstantesAplicativo.textomsgCredito%>&nbsp;(<s:property value="creditoVO.credEstado"/>)
									</th>
								</tr>
								<tr>
									<th class="text" align="left" valign="top" colspan="6">
										[Nro Pagare <s:property value="creditoVO.pagare.pagaId"/>]&nbsp;
										<s:property value="creditoVO.pagare.persona.pnombrePers"/> <s:property value="creditoVO.pagare.persona.snombrePers"/> <s:property value="creditoVO.pagare.persona.papellidoPers"/> <s:property value="creditoVO.pagare.persona.sapellidoPers"/> 
										<s:property value="creditoVO.pagare.persona.documentoPers"/><s:property value="creditoVO.pagare.persona.tipodocumento.abreviaturaTidoc"/> <s:property value="creditoVO.pagare.persona.emailPers"/>
									</th>
								</tr>
								<tr><td colspan="6"><br></td></tr>
								<tr>
									<th class="text" align="left" valign="top">
										<s:text name="creditossocios.consecutivo"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.credId"/>
									</td>
									<th class="text" align="left" valign="top">
										<s:text name="creditossocios.estado"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.credEstado"/>
									</td>
									<th class="text" align="left" valign="top">
										<s:text name="creditossocios.tipocredito"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.tipocredito.ticrDescripcion"/>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top">
										<s:text name="creditossocios.presupuesto"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.presupuesto.presDescripcion"/>
									</td>
									<th class="text" align="left" valign="top">
										<s:text name="creditossocios.nrochequedesmbolso"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.credNrocheque"/>
									</td>
									<th class="text" align="left" valign="top">
										<s:text name="creditossocios.montocredito"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.credMontocreditoView"/>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top">
										<s:text name="tipocredito.interescorriente"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.tipocredito.ticrTasainteresvencido"/>&nbsp;%
									</td>
									<th class="text" align="left" valign="top">
										<s:text name="tipocredito.interesmora"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.tipocredito.ticrInteresmoramesven"/>&nbsp;%
									</td>
									<th class="text" align="left" valign="top">
										<s:text name="tipocredito.interesefectivoanual"></s:text>
									</th>
									<td class="text" align="left" valign="top">
										<s:property value="creditoVO.tipocredito.ticrInteresefectivoanual"/>&nbsp;%
									</td>
								</tr>
								<tr>
									<td align="center" valign="top" colspan="6">
										<s:if test="creditoVO.sepuedeAnular=='NO'">
											<strong><font color="#FF0000" size="4">NO SE PUEDE ANULAR EL CREDITO PORQUE POSEE PAGOS ASOCIADOS.</font></strong>
										</s:if>
										<s:elseif test="creditoVO.sepuedeAnular=='SI'">
											<s:submit value="Anular Credito" action="anularCredPag" cssClass="button"></s:submit>
										</s:elseif>
									</td>
								</tr>
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
