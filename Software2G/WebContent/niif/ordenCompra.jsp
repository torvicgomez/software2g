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
			} );

			function agregar(){
				document.form.action="ordencompra.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="ordencompra.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="ordencompra.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="ordencompra.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="ordencompra.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
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
						<h1><s:text name="titulo.ordencompra"></s:text></h1>
					</td></tr>
					<s:if test="estado=='all'">
						<tr><td class="right">
							<input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregar();" class="buttonSV"/>
						</td></tr>
					</s:if>
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="estado=='abstract'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<s:if test="estado=='all'||estado=='query'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="ordenCompra">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="ordencompra.nrocomprobante"></s:text></th>
								<th><s:text name="ordencompra.proveedor"></s:text></th>
								<th><s:text name="ordencompra.estado"></s:text></th>
								<th><s:text name="ordencompra.fechacompra"></s:text></th>
								<th><s:text name="ordencompra.totalpagado"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listOrdenCompra" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.orcoId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.orcoId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="orcoNrocomprobante"/></td>
									<td><s:property value="proveedor.provRazonsocial"/></td>
									<td><s:property value="orcoEstado"/></td>
									<td><s:property value="orcoFechacompra"/></td>
									<td><s:property value="orcoTotalpagado"/></td>
									<td><s:property value="orcoFechacambio"/>&nbsp;<s:property value="orcoHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="ordenCompra.orcoId" id="orcoId"></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="categoriaart.nombre"></s:text></td>
							<td colspan="3">
								<s:textfield name="categoria.cateNombre" id="cateNombre" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="categoriaart.estado"></s:text></td>
							<td colspan="3">
								<s:select list="listEstado" id="cateEstado" name="categoria.cateEstado" listKey="key" listValue="valor" cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="categoriaart.descripcion"></s:text></td>
							<td colspan="3">
								<s:textarea name="categoria.cateDescripcion" id="cateDescripcion" cols="100"  rows="3" cssClass="inputs"></s:textarea>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
				<s:elseif test="estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="categoriaart.nombre"></s:text></td>
							<td><s:property value="categoria.cateNombre"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="categoriaart.estado"></s:text></td>
							<td><s:if test="categoria.cateEstado==\"S\"">Activo</s:if><s:else>Inactivo</s:else></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="categoriaart.descripcion"></s:text></td>
							<td><s:property value="categoria.cateDescripcion"/></td>
						</tr>
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
