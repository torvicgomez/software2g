<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#ventaReport').dataTable( {
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
				
				$('#ventaReportMes').dataTable( {
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

			function volver(){
				document.form.action="ventareport.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function detalle(param, param1, param2){
				document.getElementById("formatoFechaReport").value = param1;
				document.getElementById("totalMesVentaReport").value = param2;
				document.form.action="ventareport.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
				document.form.submit();
			}
			
		</script>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="venta.formatoFechaReport" id="formatoFechaReport"></s:hidden>
			<s:hidden name="venta.totalMesVentaReport" id="totalMesVentaReport"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.ventareport"></s:text></h1>
					</td></tr>
					<s:if test="estado=='abstract'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:if>
				</table>
				<s:if test="estado=='all'||estado=='query'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="ventaReport">
						<thead>
							<tr>
								<th><s:text name="columna.dtll"></s:text></th>
								<th><s:text name="ventareport.mes"></s:text></th>
								<th><s:text name="ventareport.totalmes"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listVenta" id="data">
								<tr>
									<td align="center">
										<a onclick="detalle('${data.fechaReport}','${data.formatoFechaReport}','${data.totalMesVentaReport}');">
											<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
										</a>
									</td>
									<td><s:property value="formatoFechaReport"/></td>
									<td align="right"><s:property value="totalMesVentaReportView"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="ventareport.mes"></s:text></td>
							<td><s:property value="venta.formatoFechaReport"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ventareport.totalpago"></s:text></td>
							<td><s:property value="venta.totalMesVentaReportPagoView"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ventareport.totaldebe"></s:text></td>
							<td><s:property value="venta.totalMesVentaReportDebenView"/></td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="ventaReportMes">
						<thead>
							<tr>
								<th><s:text name="ventas.consecutivo"></s:text></th>
								<th><s:text name="pagos.estado"></s:text></th>
								<th><s:text name="ventas.fechahora"></s:text></th>
								<th><s:text name="ordencompra.totalarticulo"></s:text></th>
								<th><s:text name="pagos.saldoabonado"></s:text></th>
								<th><s:text name="pagos.saldopendiente"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listVenta" id="data">
								<tr>
									<td><s:property value="ventConsecutivo"/></td>
									<td><s:property value="ventEstado"/></td>
									<td><s:property value="ventFecha"/>/<s:property value="ventHora"/></td>
									<td align="right"><s:property value="ventTotalpagView"/></td>
									<td align="right"><s:property value="saldoAbonadoView"/></td>
									<td align="right"><s:property value="saldoPendienteView"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
