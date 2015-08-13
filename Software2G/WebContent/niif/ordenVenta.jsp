<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#ordenCompra').dataTable( {
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
                	$("#search").autocomplete({
                		source : function(request, response) {
	                		$.ajax({
	                        	url : "SearchController",
	                        	type : "GET",
	                        	data : {
	                                term : request.term,
	                                tipo : 'articulo'
	                        	},
	                        	dataType : "json",
	                        	success : function(data) {
	                                	response(data);
	                        	}
	                		});
        				}
					});
				});
				
				$("#orcoFechavence").datepicker({numberOfMonths: 1,showButtonPanel: false, dateFormat: 'yy-mm-dd'});
				$("#orcoFechacompra").datepicker({numberOfMonths: 1,showButtonPanel: false, dateFormat: 'yy-mm-dd'});
				
			} );

			function soloNumeros(e) {
				var key = e.keyCode || e.which;
				teclado = String.fromCharCode(key);
				numeros="0123456789.";
				especiales = ["8","37","39","46"];//array
				teclado_especial = false;
				for(var i=0;i<especiales.length;i++){
					if(key==especiales[i])
						teclado_especial = true;
				}
				if(numeros.indexOf(teclado)==-1 && !teclado_especial)
					return false;
			}
			
			function calcularTotalaPagar(){
				var totalaPagarDiv = document.getElementById('totalaPagarDiv');
				var total = document.getElementById('total').value;
				var descuento = document.getElementById('totalDes');
				var iva = document.getElementById('totalIva');
				var totalaPagar = 0.0;
				if(descuento!=null && descuento!='' && iva!=null && iva!=''){
					totalaPagar = ((parseFloat(total)+parseFloat(iva.value!=''?iva.value:0))-parseFloat(descuento.value!=''?descuento.value:0));
					document.getElementById('totalaPagar').value = totalaPagar;
				}
				totalaPagarDiv.innerHTML = totalaPagar;
			}
			
			function cargarDatosArticulo(id){
				$("#divDatosArticulo").load('cargarDatosArticulo.action?idArticulo='+id+'&tipo=venta');
				var artiId = document.getElementById('artiId');
				artiId.value = id;
				var campoFind = document.getElementById('campoFind');
				var repetirFind = document.getElementById('repetirFind');
				campoFind.style.display = 'none';
				repetirFind.style.display = 'block';
			}				
			
			function validarView(){
				var idAuxPersona = document.getElementById('idAuxArticulo').value;
				if(idAuxPersona>0){
					var campoFind = document.getElementById('campoFind');
					var repetirFind = document.getElementById('repetirFind');
					campoFind.style.display = 'none';
					repetirFind.style.display = 'block';
				}else{
					var campoFind = document.getElementById('campoFind');
					var repetirFind = document.getElementById('repetirFind');
					campoFind.style.display = 'block';
					repetirFind.style.display = 'none';
					var search = document.getElementById('search');
					search.value = '';
				}
			}
			
			function repetirBusqueda(){
				var divDatosPersona = document.getElementById('divDatosArticulo');
				divDatosPersona.innerHTML = '';
				var artiId = document.getElementById('artiId');
				artiId.value = 0;
				var campoFind = document.getElementById('campoFind');
				var repetirFind = document.getElementById('repetirFind');
				campoFind.style.display = 'block';
				repetirFind.style.display = 'none';
				var search = document.getElementById('search');
				search.value = '';
			}
			
			function agregarArticulo(pos){
				var posicion = pos;
				var cantidadArti = document.getElementById("cantidadArti")!=null?document.getElementById("cantidadArti").value:'';
				var valorUniArti = document.getElementById("valorUniArti")!=null?document.getElementById("valorUniArti").value:'';
				var totalDes = document.getElementById("totalDes")==null?0:document.getElementById("totalDes").value!=''?document.getElementById("totalDes").value:0;
				var totalIva = document.getElementById("totalIva")==null?0:document.getElementById("totalIva").value!=''?document.getElementById("totalIva").value:0;
				$("#detalleVenta").load('cargarDetalleCompra.action?posicion='+posicion+'&cantidadArti='+cantidadArti+'&valorUniArti='+valorUniArti+'&totalDes='+totalDes+'&totalIva='+totalIva+'&tipo=venta');
				if(posicion<0 && cantidadArti>0 && cantidadArti!='' && valorUniArti>0 && valorUniArti!=null ){
					var divDatosPersona = document.getElementById('divDatosArticulo');divDatosPersona.innerHTML = '';
					var artiId = document.getElementById('artiId');artiId.value = 0;
					var campoFind = document.getElementById('campoFind');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFind');repetirFind.style.display = 'none';
					var search = document.getElementById('search');search.value = '';
				}
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
						<h1><s:text name="ventas.vincularproductos"></s:text></h1>
					</td></tr>
				</table>
				<s:if test="estado=='all'||estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="venta.ventId" id="ventId"></s:hidden>
						<s:hidden name="venta.ventTotal" id="ventTotal"></s:hidden>
						<s:hidden name="venta.ventTotaldes" id="ventTotaldes"></s:hidden>
						<s:hidden name="venta.ventTotaliva" id="ventTotaliva"></s:hidden>
						<s:hidden name="venta.ventTotalpag" id="ventTotalpag"></s:hidden>
						
						<s:hidden name="detalleVenta.articulo.artiId" id="artiId"></s:hidden>
						<s:hidden name="detalleVenta.id.artiId"></s:hidden>
						<s:hidden name="detalleVenta.id.ventId"></s:hidden>
						<tr>
							<td colspan="6" class="leftLabel"><s:text name="titulo.articulos"></s:text></td>
						</tr>
						<tr>
							<td colspan="6">
								<table cellpadding="0" cellspacing="0" border="0" class="display">
									<tr>
										<td class="leftLabel"><s:text name="ordencompra.findarticulo"></s:text></td>
										<td colspan="3">
											<s:set name="idArticulo" value="detalleVenta.articulo.artiId"></s:set>
											<input type="hidden" id="idAuxArticulo" value="${idArticulo}"/>
											<div id="repetirFind" style="overflow:auto;width:auto;height:auto;display:none">
												<input type="button" value="<s:text name="labelbutton.repetirfind"></s:text>" onclick="repetirBusqueda();" class="buttonSV"/>
												<input type="button" value="<s:text name="labelbutton.agregarArticulo"></s:text>" onclick="agregarArticulo(-1);" class="buttonSV"/>
											</div>
											<div id="campoFind" style="overflow:auto;width:auto;height:auto;display:block">
												<s:textfield name="dataAutoCompletado" id="search" size="60" maxlength="30" cssClass="inputs"></s:textfield>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<div id="divDatosArticulo">
												<s:if test="detalleVenta.articulo!=null&&detalleVenta.articulo.artiId>0">
												<table cellpadding="0" cellspacing="0" border="0" class="display">
													<tr><td class="leftLabel"><s:text name="ordencompra.articulo"></s:text></td>
														<td><s:property value="detalleVenta.articulo.artiNombre"/></td>
													</tr>
													<tr><td class="leftLabel"><s:text name="articulos.referencia"></s:text></td>
														<td><s:property value="detalleVenta.articulo.artiReferencia"/></td>
													</tr>
													<tr><td class="leftLabel"><s:text name="articulos.categoria"></s:text></td>
														<td><s:property value="detalleVenta.articulo.categoria.cateNombre"/></td>
													</tr>
													<tr><td class="leftLabel"><s:text name="articulos.marca"></s:text></td>
														<td><s:property value="detalleVenta.articulo.artiMarca"/></td>
													</tr>
												</table>
												</s:if>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="leftLabel"><s:text name="ordencompra.datosfaccompra"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ordencompra.nrocomprobante"></s:text></td>
							<td>
								<s:textfield name="ordenCompra.orcoNrocomprobante" id="orcoNrocomprobante" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="ordencompra.fechacompra"></s:text></td>
							<td>
								<s:textfield name="ordenCompra.orcoFechacompra" id="orcoFechacompra" size="15" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="ordencompra.fechavence"></s:text></td>
							<td>
								<s:textfield name="ordenCompra.orcoFechavence" id="orcoFechavence" size="15" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="leftLabel"><s:text name="ordencompra.detallecompra"></s:text></td>
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
															<td align="center"><a onclick="agregarArticulo('${stat.index}');"><s:text name="labelbutton.remover"></s:text></td>
															<td><s:property value="articulo.artiReferencia"/></td>
															<td><s:property value="articulo.artiNombre"/></td>
															<td align="right"><s:property value="deveCantidad"/></td>
															<td align="right"><s:property value="deveValorartven"/></td>
															<td align="right"><s:property value="deveTotalartven"/></td>
														</tr>
													</s:iterator>
													<tr>
														<td colspan="4"></td>
														<td align="right" class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
														<td align="right"><input type="hidden" id="total" value="<s:property value="venta.ventTotal"/>"/><s:property value="venta.ventTotalView"/></td>
													</tr>
													<tr>
														<td colspan="4"></td>
														<td align="right" class="leftLabel"><s:text name="ordencompra.totaldescuento"></s:text></td>
														<td align="right"><input type="text" id="totalDes" value="<s:property value="venta.ventTotaldes"/>"  class="inputs"  style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false" onblur="javascript:calcularTotalaPagar();"/></td>
													</tr>
													<tr> 
														<td colspan="4"></td>
														<td align="right" class="leftLabel"><s:text name="ordencompra.totaliva"></s:text></td>
														<td align="right"><input type="text" id="totalIva" value="<s:property value="venta.ventTotaliva"/>"  class="inputs"  style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false" onblur="javascript:calcularTotalaPagar();"/></td>
													</tr>
													<tr>
														<td colspan="4"></td>
														<td align="right" class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
														<td align="right"><input type="hidden" id="totalaPagar" value="<s:property value="venta.ventTotalpag"/>"/><div id="totalaPagarDiv"><s:property value="ordenCompra.ventTotalpagView"/></div></td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</s:if>
				<s:elseif test="estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td colspan="6" class="leftLabel"><s:text name="ordencompra.proveedor"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ordencompra.proveedor"></s:text></td>
							<td colspan="5"><s:property value="ordenCompra.proveedor.provRazonsocial"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ordencompra.contactoproveedor"></s:text></td>
							<td><s:property value="ordenCompra.proveedor.persona.nombreCompleto"/></td>
							<td class="leftLabel"><s:text name="personal.email"></s:text></td>
							<td><s:property value="ordenCompra.proveedor.persona.emailPers"/></td>
							<td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
							<td><s:property value="ordenCompra.proveedor.persona.telefonoPers"/></td>
						</tr>
						<tr>
							<td colspan="6" class="leftLabel"><s:text name="ordencompra.datosfaccompra"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="ordencompra.nrocomprobante"></s:text></td>
							<td><s:property value="ordenCompra.orcoNrocomprobante"/></td>
							<td class="leftLabel"><s:text name="ordencompra.fechacompra"></s:text></td>
							<td><s:property value="ordenCompra.orcoFechacompra"/></td>
							<td class="leftLabel"><s:text name="ordencompra.fechavence"></s:text></td>
							<td><s:property value="ordenCompra.orcoFechavence"/></td>
						</tr>
						<tr>	
							<td class="leftLabel"><s:text name="ordencompra.estado"></s:text></td>
							<td><s:property value="ordenCompra.orcoEstado"/></td>
							<td class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
							<td><s:property value="ordenCompra.orcoTotalapagarView"/></td>
							<td class="leftLabel"><s:text name="ordencompra.saldo"></s:text></td>
							<td><font size="2" color="#FF0000"><strong><s:property value="ordenCompra.orcoSaldoView"/></strong></font></td>
						</tr>
						<tr>
							<td colspan="6">
								<table cellpadding="0" cellspacing="0" border="0" class="display">
									<tr>
										<td class="leftLabel" style="width:5%"><s:text name="columna.item"></s:text></td>
										<td class="leftLabel"><s:text name="articulos.referencia"></s:text></td>
										<td class="leftLabel"><s:text name="ordencompra.articulo"></s:text></td>
										<td class="leftLabel"><s:text name="ordencompra.cantidad"></s:text></td>
										<td class="leftLabel"><s:text name="ordencompra.valorunitario"></s:text></td>
										<td class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
									</tr>
									<s:iterator value="listDetalleCompra" id="data" status="stat">
										<tr>
											<td align="center">${stat.index+1}</td>
											<td><s:property value="articulo.artiReferencia"/></td>
											<td><s:property value="articulo.artiNombre"/></td>
											<td align="right"><s:property value="decoCantidad"/></td>
											<td align="right"><s:property value="decoValorunitarioView"/></td>
											<td align="right"><s:property value="decoValortotalView"/></td>
										</tr>
									</s:iterator>
									<tr>
										<td colspan="4"></td>
										<td align="right" class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
										<td align="right"><s:property value="ordenCompra.orcoTotalcompraView"/></td>
									</tr>
									<tr>
										<td colspan="4"></td>
										<td align="right" class="leftLabel"><s:text name="ordencompra.totaldescuento"></s:text></td>
										<td align="right"><s:property value="ordenCompra.orcoTotaldescuentoView"/></td>
									</tr>
									<tr>
										<td colspan="4"></td>
										<td align="right" class="leftLabel"><s:text name="ordencompra.totaliva"></s:text></td>
										<td align="right"><s:property value="ordenCompra.orcoTotalivavenView"/></td>
									</tr>
									<tr>
										<td colspan="4"></td>
										<td align="right" class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
										<td align="right"><s:property value="ordenCompra.orcoTotalapagarView"/></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
<script type="text/javascript" charset="utf-8">validarView();</script>
