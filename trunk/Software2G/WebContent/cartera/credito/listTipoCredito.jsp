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
			$('#tipoCreditoTable').dataTable( { 
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
						<h1><strong><s:text name="titulo.tipocredito"></s:text></strong></h1>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarTiposCreditos'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="tipoCreditoTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.item"></s:text>
										</th>
										<th align="left"  width="95%" colspan="7">
											<!--<s:text name="tipocredito.nombretipocredito"></s:text>-->
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listTipoCredito" id="data">
									<tr>
										<td width="5%" rowspan="4" align="center">1</td>
										<th width="15%">
											<s:text name="tipocredito.nombretipocredito"></s:text>
										</th>
										<th width="10%">
											<s:text name="tipocredito.estado"></s:text>
										</th>
										<th width="5%">
											<s:text name="tipocredito.tiempomeses"></s:text>
										</th>
										<th width="5%">
											<s:text name="tipocredito.tiempoano"></s:text>
										</th>
										<th width="20%">
											<s:text name="tipocredito.interescorriente"></s:text>
										</th>
										<th width="20%">
											<s:text name="tipocredito.interesmora"></s:text>
										</th>
										<th width="20%">
											<s:text name="tipocredito.interesefectivoanual"></s:text>
										</th>
									</tr>
									<tr>
										<td width="15%" align="center">
											<s:property value="ticrDescripcion"/>
										</td>
										<td width="10%" align="center">
											<s:if test="ticrEstado==\"1\"">ACTIVO</s:if>
											<s:elseif test="ticrEstado==\"0\"">INACTIVO</s:elseif>
										</td>
										<td width="5%" align="center">
											<s:property value="ticrTiempomes"/>
										</td>
										<td width="5%" align="center">
											<s:property value="ticrTiempoano"/>
										</td>
										<td width="20%" align="center">
											<s:property value="ticrTasainteresvencido"/>&nbsp;%
										</td>
										<td width="20%" align="center">
											<s:property value="ticrInteresmoramesven"/>&nbsp;%
										</td>
										<td width="20%" align="center">
											<s:property value="ticrInteresefectivoanual"/>&nbsp;%
										</td>
									</tr>
									<tr>
										<th width="50%" align="center" colspan="4">
											<s:text name="tipocredito.segurotipocredito"></s:text>
										</th>
										<th width="10%" align="center">
											<s:text name="tipocredito.estado"></s:text>
										</th>
										<th width="20%" align="center">
											<s:text name="tipocredito.peridocobro"></s:text>
										</th>
										<th width="20%" align="center">
											<s:text name="tipocredito.porcentajecobroseg"></s:text>
										</th>
									</tr>									
									<s:iterator value="tipocreditoseguroadquiridos" id="data1">
										<tr>
											<td width="50%" align="center" colspan="4">
												<s:property value="seguro.seguDescripcion"/>
											</td>
											<td width="10%" align="center">
												<s:if test="seguro.seguEstado==\"1\"">ACTIVO</s:if>
												<s:elseif test="seguro.seguEstado==\"0\"">INACTIVO</s:elseif>
											</td>
											<td width="20%" align="center">
												<s:property value="seguro.seguTiempo"/>
											</td>
											<td width="20%" align="center">
												<s:property value="seguro.seguValor"/>&nbsp;%
											</td>
										</tr>
									</s:iterator>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
			</table>
			</div>
			<div class="spacer"></div>
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>
