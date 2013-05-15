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
	<script type="text/javascript" charset="ISO-8859-1"> 
	$(document).ready(function() {
			$('#creditoSociosTable').dataTable( { 
				"sPaginationType": "full_numbers",
				"bLengthChange": true,
				"bFilter": true,
				"bSort": true,
				"bInfo": true,
				"bAutoWidth": true,
				"oLanguage": {
					//"sLengthMenu": "Mostrar MENU Registros por pagina",
					"sZeroRecords": "No se encontraron registros",
					//"sInfo": "Mostrando START a END de TOTAL registros",
					"sInfoEmpty": "Mostrando 0 a 0 de 0 registros",
					"sInfoFiltered": "(Filtrado desde MAX registros totales)",
					"sSearch": "Buscar: ",
					"oPaginate": {
						"sFirst": "Primero",
						"sLast": "Ultimo",
						"sNext": "Siguiente",
						"sPrevious": "Anterior"
					}
				}
			} );
	} );
	
	$(document).ready(function(){
        $("#findPagare").keyup(function(event){
            var datoFind = $("#findPagare").val();
            var tipoFind = $('input:radio[name=tipoFindPagare]:checked').val();
            $("#titularCredito").load('cmbPagare.action?datoFind='+datoFind+'&tipoFind='+tipoFind);
        });
        
        $("#selectTipoCredito").change(function(event){
        	var id = $("#selectTipoCredito").find(':selected').val();
            $("#infoTipoCredito").load('cmbTipoCredito.action?id='+id);
        });
        
        $("#selectPresupuesto").change(function(event){
        	var id = $("#selectPresupuesto").find(':selected').val();
            $("#infoPresupuesto").load('cmbPresupuesto.action?id='+id);
        });
        
	});
        
	function pagosCredito(idCredito){
		document.form.action="pagosCredito.action?id="+idCredito;
		document.form.submit();
	}
	
	</script>
</head>
<body id="dt_example">
		<s:form id="form">
		<div id="demo">
			<table border="0" width="100%" align="center">
				<tr>
					<td>
						<s:hidden name="estado"></s:hidden>	
						<s:hidden name="creditoVO.credId" id="idCredito"></s:hidden>
						<h1><strong><s:text name="titulo.creditossocios"></s:text></strong></h1>
						<s:if test="estado==null||estado=='listarCreditosSocios'">
							<s:submit value="Crear Credito Socio" cssClass="button" action="crearCreditoSocio"></s:submit>
						</s:if>
						<s:elseif test="estado=='crearCreditoSocio'">
							<s:submit value="Cancelar" action="listCreditosSocios" cssClass="button"></s:submit>
							<s:submit value="Aplicar Cambios" action="saveCreditoSocio" cssClass="button"></s:submit>
						</s:elseif>
						<s:elseif test="estado=='pagosCreditos'">
							<s:submit value="Cancelar" action="listCreditosSocios" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarCreditosSocios'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="creditoSociosTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.dtll"></s:text>
										</th>
										<th align="left"  width="15%">
											<s:text name="creditossocios.refcredito"></s:text>
										</th>
										<th align="left"  width="50%">
											<s:text name="creditossocios.titularcredito"></s:text>
										</th>
										<th align="left"  width="10%">
											<s:text name="creditossocios.estado"></s:text>
										</th>
										<th align="left"  width="10%">
											<s:text name="creditossocios.saldo"></s:text>
										</th>
										<th align="left" width="10%">
											<s:text name="creditossocios.montocredito"></s:text>
										</th>
									</tr>
								</thead>
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
										<td width="10%">
											<s:property value="credSaldoView"/>
										</td>
										<td width="10%">
											<s:property value="credMontocreditoView"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				<s:elseif test="estado=='crearCreditoSocio'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="creditossocios.findtitularcredito"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="creditoVO.findPagare" id="findPagare" size="30"></s:textfield>
										<input type="radio" name="tipoFindPagare" value="0" checked="checked"/>Nombre Socio
										<input type="radio" name="tipoFindPagare" value="1"/>Nro Pagare
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top"></td>
									<td class="text" width="80%" align="left"  valign="top">
										<div id="titularCredito">
											<s:if test="creditoVO.pagare.persona!=null&&creditoVO.pagare.persona.idPers>0">
												Titular Credito: <strong><font size="2" color="#FF0000">[Nro Pagare <s:property value="creditoVO.pagare.pagaId"/>]&nbsp;
													<s:property value="creditoVO.pagare.persona.pnombrePers"/> <s:property value="creditoVO.pagare.persona.snombrePers"/> <s:property value="creditoVO.pagare.persona.papellidoPers"/> <s:property value="creditoVO.pagare.persona.sapellidoPers"/> 
													<s:property value="creditoVO.pagare.persona.documentoPers"/><s:property value="creditoVO.pagare.persona.tipodocumento.abreviaturaTidoc"/> <s:property value="creditoVO.pagare.persona.emailPers"/>
													<s:hidden name="creditoVO.pagare.pagaId"/>
												</font></strong>
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="creditossocios.tipocredito"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:select list="listTipoCredito" id="selectTipoCredito" name="creditoVO.tipocredito.ticrId" listKey="ticrId" listValue="ticrDescripcion" headerKey="-1" headerValue=".::Seleccione::."></s:select>
										<div id="infoTipoCredito"></div>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="creditossocios.presupuesto"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:select list="listPresupuesto" id="selectPresupuesto" name="creditoVO.presupuesto.presId" listKey="presId" listValue="presDescripcion" headerKey="-1" headerValue=".::Seleccione::."></s:select>
										<div id="infoPresupuesto"></div>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="creditossocios.fechainiciocredito"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="creditoVO.credFechainiciacredito" id="fechaInicioCredito" size="15" maxlength="10"></s:textfield>
										<img alt="Fecha Inicio Credito" src="<s:url value="/imagenes/calendario.gif"/>" onclick="showCalendar('fechaInicioCredito', 'y-mm-dd');">(yyyy-mm-dd)
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="creditossocios.montocredito"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="creditoVO.credMontocredito" size="30" id="montoCredito" readonly="true"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="creditossocios.nrochequedesmbolso"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="creditoVO.credNrocheque" size="30"></s:textfield>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:elseif>
				<s:elseif test="estado=='pagosCreditos'">
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
									<th class="text" align="left" valign="top">
										<font size="3"><s:text name="creditossocios.fechaultimopago"></s:text></font>
									</th>
									<td align="left" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="creditoVO.credFechaultimopago"/></font></strong>
									</td>
									<th class="text" align="left" valign="top">
										<font size="3"><s:text name="creditossocios.fechadecorte"></s:text></font>
									</th>
									<td align="left" valign="top">
										<!--<strong><font size="3" color="#FF0000"><s:property value="creditoVO.fechaALiquidar"/></font></strong>-->
										<s:textfield name="creditoVO.fechaALiquidar" id="fechaCorte" size="15" maxlength="10"></s:textfield>
										<img alt="Fecha de Corte" src="<s:url value="/imagenes/calendario.gif"/>" onclick="showCalendar('fechaCorte', 'y-mm-dd');">(yyyy-mm-dd)
									</td>
									<td align="left" valign="top" colspan="2">
										<s:submit value="Recalcular Pagos" action="calcularPago" cssClass="button"></s:submit>
									</td>
								</tr>
								<tr>
									<th class="text" align="left" valign="top">
										<font size="3"><s:text name="creditossocios.diasliquidados"></s:text></font>
									</th>
									<td align="left" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.diasLiquidados"/></font></strong>
									</td>
									<th class="text" align="left" valign="top">
										<font size="3"><s:text name="creditossocios.diasmora"></s:text></font>
									</th>
									<td align="left" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.diasMora"/></font></strong>
									</td>
									<th class="text" align="right" valign="top">
										<font size="3"><s:text name="creditossocios.saldo"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="creditoVO.credSaldoView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="5">
										<font size="3"><s:text name="tipocredito.interescorriente"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorinteresView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="5">
										<font size="3"><s:text name="tipocredito.interesmora"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorinteresmoraView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="5">
										<font size="3"><s:text name="tipocredito.segurotipocredito"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorseguroView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="5">
										<font size="3"><s:text name="creditossocios.otroscargos"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonOtrocargoView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="5">
										<font size="3"><s:text name="creditossocios.abonoacapital"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValorcapitalView"/></font></strong>
									</td>
								</tr>
								<tr>
									<th class="text" align="right" valign="top" colspan="5">
										<font size="3"><s:text name="creditossocios.totolapagar"></s:text></font>
									</th>
									<td align="right" valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="abonoVO.abonValortotalView"/></font></strong>
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
