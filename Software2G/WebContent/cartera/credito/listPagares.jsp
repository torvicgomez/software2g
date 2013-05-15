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
			$('#pagaresTable').dataTable( { 
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
        $("#findDeudor").keyup(function(event){
            var datoFind = $("#findDeudor").val();
            var tipoFindDeudor = $('input:radio[name=tipoFindDeudor]:checked').val();
            $("#deudorPagare").load('cmbDeudor.action?datoFind='+datoFind+'&tipoFindDeudor='+tipoFindDeudor);
            
        });
	});
        
	function editar(idPagare){
		document.form.action="editarPagare.action?id="+idPagare;
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
						<s:hidden name="pagareVO.pagaId"></s:hidden>
						<h1><strong><s:text name="titulo.pagare"></s:text></strong></h1>
						<s:if test="estado==null||estado=='listarPagares'">
							<s:submit value="Crear Pagare" cssClass="button" action="crearPagare"></s:submit>
						</s:if>
						<s:elseif test="estado=='crearPagare'||estado=='editarPagare'">
							<s:submit value="Cancelar" action="listPagare" cssClass="button"></s:submit>
							<s:submit value="Aplicar Cambios" action="savePagare" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
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
								<tbody>
								<s:iterator value="listPagare" id="data">
									<tr>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="pagaId"/>');">Editar</a>
										</td>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="pagaId"/>');">Ver</a>
										</td>
										<td width="20%">
											<s:property value="tipopagare.tipaDescripcion"/>&nbsp;(<s:property value="pagaId"/>)
										</td>
										<td width="10%">
											<s:if test="pagaEstado==\"1\"">ACTIVO</s:if>
											<s:elseif test="pagaEstado==\"0\"">INACTIVO</s:elseif>
											<!--<s:property value="pagaEstado"/>-->
										</td>
										<td width="35%">
											<s:property value="persona.pnombrePers"/>&nbsp;<s:property value="persona.snombrePers"/>&nbsp;<s:property value="persona.papellidoPers"/>&nbsp;<s:property value="persona.sapellidoPers"/>&nbsp;
											<s:property value="persona.documentoPers"/><s:property value="persona.tipodocumento.abreviaturaTidoc"/>
										</td>
										<td width="35%">
											<s:property value="pagaCodeudor"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				<s:elseif test="estado=='crearPagare'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.finddeudor"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="pagareVO.findDeudor" id="findDeudor" size="30"></s:textfield>
										<input type="radio" name="tipoFindDeudor" value="0" checked="checked"/>Nombre
										<input type="radio" name="tipoFindDeudor" value="1"/>Documento
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top"></td>
									<td class="text" width="80%" align="left"  valign="top">
										<div id="deudorPagare"></div>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.tipopagare"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:select list="listTipoPagare" name="pagareVO.tipopagare.tipaId" listKey="tipaId" listValue="tipaDescripcion" headerKey="-1" headerValue=".::Seleccione::."></s:select>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.fechapago"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="pagareVO.pagaFechapago" id="fechaPagoPagare" size="15" maxlength="10"></s:textfield>
										<img alt="Fecha Pago Pagare" src="<s:url value="/imagenes/calendario.gif"/>" onclick="showCalendar('fechaPagoPagare', 'y-mm-dd');">(yyyy-mm-dd)
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.valorprestamo"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="pagareVO.pagaMonto" size="30"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="pagare.nombrecodeudor"></s:text><!--<s:text name="campo.requerido"></s:text>-->
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="pagareVO.pagaCodeudor" size="30"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="pagare.direccioncodeudor"></s:text><!--<s:text name="campo.requerido"></s:text>-->
									</td>
									<td class="text"  valign="top">
										<s:textfield name="pagareVO.pagaDircodeudor" size="30"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="pagare.telefonocodeudor"></s:text><!--<s:text name="campo.requerido"></s:text>-->
									</td>
									<td class="text"  valign="top">
										<s:textfield name="pagareVO.pagaTelcodeudor" size="30"></s:textfield>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:elseif>
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
										<s:select list="#{'1':'ACTIVO','0':'INACTIVO'}" name="pagareVO.pagaEstado"/>
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
