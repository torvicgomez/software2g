<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#abono').dataTable( {
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
				
				$(function() {
					$("#pestanas").tabs();
				});
				
			} );

			function soloNumeros(e) {
				var key = e.keyCode || e.which;
				teclado = String.fromCharCode(key);
				numeros="0123456789.";
				especiales = ["9", "8","37","39","46"];//array 
				teclado_especial = false;
				for(var i=0;i<especiales.length;i++){
					if(key==especiales[i])
						teclado_especial = true;
				}
				if(numeros.indexOf(teclado)==-1 && !teclado_especial)
					return false;
			}
			
			function agregar(){
				document.form.action="pagos.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="pagos.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>#tabs-2";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="pagos.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="pagos.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="pagos.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
				document.form.submit();
			}
			
		</script>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.pagos"></s:text></h1>
					</td></tr>
					<s:if test="estado=='edit'||estado=='save'||estado=='abstract'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<s:if test="venta.saldoPendiente>0">
									<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
								</s:if>
							</td>
						</tr>
					</s:if>
				</table>
				<s:if test="estado=='all'||estado=='query'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="abono">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="ventas.consecutivo"></s:text></th>
								<th><s:text name="pagos.cliente"></s:text></th>
								<th><s:text name="personal.documento"></s:text></th>
								<th><s:text name="pagos.estado"></s:text></th>
								<th><s:text name="ventas.fechahora"></s:text></th>
								<th><s:text name="ordencompra.totalarticulo"></s:text></th>
<%-- 								<th><s:text name="pagos.saldopendiente"></s:text></th> --%>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listVenta" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.ventId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.ventId}');">
												<s:text name="titulo.pagos"></s:text>
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18"> --%>
											</a>
										</td>
									</s:if>
									<td><s:property value="ventConsecutivo"/></td>
									<td><s:property value="cliente.persona.nombreCompleto"/></td>
									<td><s:property value="cliente.persona.documentoPers"/>&nbsp;<s:property value="cliente.persona.tipodocumento.abreviaturaTidoc"/></td>
									<td><s:property value="ventEstado"/></td>
									<td><s:property value="ventFecha"/>&nbsp;<s:property value="ventHora"/></td>
									<td align="right"><s:property value="ventTotalpagView"/></td>
<%-- 									<td align="right"><s:property value="saldoPendienteView"/></td> --%>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='edit'||estado=='save'||estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="venta.ventId"></s:hidden>
						<s:hidden name="venta.saldoAbonado"></s:hidden>
						<s:hidden name="venta.saldoPendiente"></s:hidden>
						<tr>
							<td colspan="6" class="leftLabel"><s:text name="ventas.datosfacventa"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ventas.consecutivo"></s:text></td>
							<td>
								<s:property value="venta.ventConsecutivo"/>
							</td>
							<td class="leftLabel"><s:text name="ventas.fechahora"></s:text></td>
							<td>
								<s:property value="venta.ventFecha"/>/<s:property value="venta.ventHora"/>
							</td>
							<td class="leftLabel"><s:text name="pagos.estado"></s:text></td>
							<td>
								<s:property value="venta.ventEstado"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel" colspan="6"><s:text name="ventas.datosvendedor"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
							<td align="left" colspan="3">
								<s:property value="venta.vendedor.persona.nombreCompleto"/>
							</td>
							<td class="leftLabel" width="130"><s:text name="ventas.codigovendedor"></s:text></td>
							<td align="left">
								<s:property value="venta.vendedor.vendCodigo"/>
							</td>
						</tr>
					</table>
					<div id="pestanas">
						<ul>
							<li><a href="#tabs-0"><s:text name="ventas.cliente"></s:text></a></li>
							<li><a href="#tabs-1"><s:text name="ventas.productos"></s:text></a></li>
							<li><a href="#tabs-2"><s:text name="ventas.pagos"></s:text></a></li>
						</ul>
						<div id="tabs-0">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:text name="personal.numerodocumento"></s:text></td>
									<td>
										<s:property value="venta.cliente.persona.documentoPers"/>&nbsp;<s:property value="venta.cliente.persona.tipodocumento.abreviaturaTidoc"/>
									</td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.primernombre"></s:text></td>
									<td><s:property value="venta.cliente.persona.pnombrePers"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.segundonombre"></s:text></td>
									<td><s:property value="venta.cliente.persona.snombrePers"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.primerapellido"></s:text></td>
									<td><s:property value="venta.cliente.persona.papellidoPers"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.segundoapellido"></s:text></td>
									<td><s:property value="venta.cliente.persona.sapellidoPers"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
									<td><s:property value="venta.cliente.persona.telefonoPers"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.email"></s:text></td>
									<td><s:property value="venta.cliente.persona.emailPers"/></td>
								</tr>
							</table>
						</div>
						<div id="tabs-1">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td colspan="6" class="leftLabel"><s:text name="ventas.detalleventa"></s:text></td>
								</tr>
								<tr>
									<td colspan="6">
										<table cellpadding="0" cellspacing="0" border="0" class="display">
											<tr>
												<td colspan="6">
													<div id="detalleVenta">
														<table cellpadding="0" cellspacing="0" border="0" class="display">
															<tr>
																<td class="leftLabel" style="width:5%"><s:text name="columna.item"></s:text></td>
																<td class="leftLabel"><s:text name="articulos.referencia"></s:text></td>
																<td class="leftLabel"><s:text name="ordencompra.articulo"></s:text></td>
																<td class="leftLabel"><s:text name="ordencompra.cantidad"></s:text></td>
																<td class="leftLabel"><s:text name="ordencompra.valorunitario"></s:text></td>
																<td class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
															</tr>
															<s:iterator value="listDetalleVenta" id="data" status="stat">
																<tr>
																	<td align="center">${stat.index+1}</td>
																	<td><s:property value="articulo.artiReferencia"/></td>
																	<td><s:property value="articulo.artiNombre"/></td>
																	<td align="right"><s:property value="deveCantidad"/></td>
																	<td align="right"><s:property value="deveValorartvenView"/></td>
																	<td align="right"><s:property value="deveTotalartvenView"/></td>
																</tr>
															</s:iterator>
															<tr>
																<td colspan="4"></td>
																<td align="right" class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
																<td align="right"><s:property value="venta.ventTotalView"/></td>
															</tr>
															<tr>
																<td colspan="4"></td>
																<td align="right" class="leftLabel"><s:text name="ordencompra.totaldescuento"></s:text></td>
																<td align="right"><s:property value="venta.ventTotaldesView"/></td>
															</tr>
															<tr> 
																<td colspan="4"></td>
																<td align="right" class="leftLabel"><s:text name="ordencompra.totaliva"></s:text></td>
																<td align="right"><s:property value="venta.ventTotalivaView"/></td>
															</tr>
															<tr>
																<td colspan="4"></td>
																<td align="right" class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
																<td align="right"><s:property value="venta.ventTotalpagView"/></td>
															</tr>
														</table>
													</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
						<div id="tabs-2">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td colspan="2"  class="leftLabel"><s:text name="pagos.saldoabonado"></s:text></td>
									<td colspan="2"  class="leftLabel"><s:text name="pagos.saldopendiente"></s:text></td>
									<td align="right" class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
									<td align="right" width="15%"><s:property value="venta.ventTotalView"/></td>
								</tr>
								<tr>
									<td rowspan="3" colspan="2" align="right"><font size="16" color="#0000FF"><strong><s:property value="venta.saldoAbonadoView"/></strong></font></td>
									<td rowspan="3" colspan="2" align="right"><font size="16" color="#FF0000"><strong><s:property value="venta.saldoPendienteView"/></strong></font></td>
									<td align="right" class="leftLabel"><s:text name="ordencompra.totaldescuento"></s:text></td>
									<td align="right" width="15%"><s:property value="venta.ventTotaldesView"/></td>
								</tr>
								<tr>
									<td align="right" class="leftLabel"><s:text name="ordencompra.totaliva"></s:text></td>
									<td align="right" width="15%"><s:property value="venta.ventTotalivaView"/></td>
								</tr>
								<tr>
									<td align="right" class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
									<td align="right" width="15%"><s:property value="venta.ventTotalpagView"/></td>
								</tr>
								<tr>
									<td colspan="6" class="leftLabel"><s:text name="pagos.detallepagosrealizados"></s:text></td>
								</tr>
								<s:iterator value="listPago" id="data" status="stat">
									<tr>
										<td class="leftLabel"><s:text name="formapago.formapagofechahora"></s:text></td>
										<td align="right"><s:property value="formapago.fopaFormapago"/> - <s:property value="pagoFecha"/>/<s:property value="pagoHora"/></td>
										<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
										<td align="right"><s:property value="pagoComprobante"/></td>
										<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
										<td align="right"><s:property value="pagoValorView"/></td>
									</tr>
								</s:iterator>
								<s:if test="venta.saldoPendiente>0">
									<tr>
										<td colspan="6"  class="leftLabel"><s:text name="pagos.registropago"></s:text></td>
									</tr>
									<tr>
										<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
										<td align="right"><s:select list="listFormapago" name="listAbono[0].formaPagoIdHelp" listKey="fopaId" listValue="fopaFormapago" headerKey="-1" headerValue=".::Selecione::." cssClass="inputs"/></td>
										<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
										<td align="right"><s:textfield name="listAbono[0].pagoComprobante" size="10" cssClass="inputs"></s:textfield></td>
										<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
										<td align="right"><s:textfield name="listAbono[0].pagoValor" size="10" cssClass="inputs" style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield></td>
									</tr>
									<tr>
										<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
										<td align="right"><s:select list="listFormapago" name="listAbono[1].formaPagoIdHelp" listKey="fopaId" listValue="fopaFormapago" headerKey="-1" headerValue=".::Selecione::." cssClass="inputs"/></td>
										<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
										<td align="right"><s:textfield name="listAbono[1].pagoComprobante" size="10" cssClass="inputs"></s:textfield></td>
										<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
										<td align="right"><s:textfield name="listAbono[1].pagoValor" size="10" cssClass="inputs" style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield></td>
									</tr>
									<tr>
										<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
										<td align="right"><s:select list="listFormapago" name="listAbono[2].formaPagoIdHelp" listKey="fopaId" listValue="fopaFormapago" headerKey="-1" headerValue=".::Selecione::." cssClass="inputs"/></td>
										<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
										<td align="right"><s:textfield name="listAbono[2].pagoComprobante" size="10" cssClass="inputs"></s:textfield></td>
										<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
										<td align="right"><s:textfield name="listAbono[2].pagoValor" size="10" cssClass="inputs" style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield></td>
									</tr>
								</s:if>
							</table>
						</div>
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<s:if test="venta.saldoPendiente>0">
									<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
								</s:if>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
