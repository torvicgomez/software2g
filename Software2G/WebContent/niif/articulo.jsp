<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#articulo').dataTable( {
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
				document.form.action="articulo.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="articulo.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="articulo.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="articulo.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="articulo.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
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
						<h1><s:text name="titulo.articulos"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="articulo">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="articulos.referencia"></s:text></th>
								<th><s:text name="articulos.nombre"></s:text></th>
								<th><s:text name="articulos.stock"></s:text></th>
								<th><s:text name="articulos.estado"></s:text></th>
								<th><s:text name="articulos.precioventa"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listArticulo" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.artiId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.artiId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="artiReferencia"/></td>
									<td><s:property value="artiNombre"/></td>
									<td><s:property value="artiStock"/></td>
									<td><s:property value="artiEstado"/></td>
									<td><s:property value="artiPrecioventa"/></td>
									<td><s:property value="artiFechacambio"/>&nbsp;<s:property value="artiHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="articulo.artiId" id="artiId"></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="articulos.nombre"></s:text></td>
							<td colspan="3">
								<s:textfield name="articulo.artiNombre" id="artiNombre" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.categoria"></s:text></td>
							<td>
								<s:select list="listCategoria" name="categoria.cateId" listKey="cateId" listValue="cateNombre" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"></s:select>
							</td>
							<td class="leftLabel"><s:text name="articulos.marca"></s:text></td>
							<td>
								<s:textfield name="articulo.artiMarca" id="artiMarca" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.descripcion"></s:text></td>
							<td colspan="3">
								<s:textarea name="articulo.artiDescripcion" id="artiDescripcion" cols="100"  rows="3" cssClass="inputs"></s:textarea>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.referencia"></s:text></td>
							<td>
								<s:textfield name="articulo.artiReferencia" id="artiReferencia" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="articulos.estado"></s:text></td>
							<td>
								<s:select list="listEstadoArticulo" id="artiEstado" name="articulo.artiEstado" listKey="key" listValue="valor" cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.stock"></s:text></td>
							<td>
								<s:textfield name="articulo.artiStock" id="artiStock" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="articulos.puntoequilibrio"></s:text></td>
							<td>
								<s:textfield name="articulo.artiPuntoequilibrio" id="artiPuntoequilibrio" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.preciobase"></s:text></td>
							<td colspan="3">
								<s:textfield name="articulo.artiPreciobase" id="artiPreciobase" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.precioventa"></s:text></td>
							<td>
								<s:textfield name="articulo.artiPrecioventa" id="artiPrecioventa" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="articulos.porcentajeuti"></s:text></td>
							<td>
								<s:textfield name="articulo.artiPorcentajeutilidad" id="artiPorcentajeutilidad" size="60" maxlength="30" cssClass="inputs"></s:textfield>
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
							<td class="leftLabel"><s:text name="articulos.nombre"></s:text></td>
							<td colspan="3"><s:property value="articulo.artiNombre"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.categoria"></s:text></td>
							<td><s:property value="categoria.cateNombre"/></td>
							<td class="leftLabel"><s:text name="articulos.marca"></s:text></td>
							<td><s:property value="articulo.artiMarca"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.descripcion"></s:text></td>
							<td colspan="3"><s:property value="articulo.artiDescripcion"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.referencia"></s:text></td>
							<td><s:property value="articulo.artiReferencia"/></td>
							<td class="leftLabel"><s:text name="articulos.estado"></s:text></td>
							<td><s:property value="articulo.artiEstado"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.stock"></s:text></td>
							<td><s:property value="articulo.artiStock"/></td>
							<td class="leftLabel"><s:text name="articulos.puntoequilibrio"></s:text></td>
							<td><s:property value="articulo.artiPuntoequilibrio"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.preciobase"></s:text></td>
							<td colspan="3"><s:property value="articulo.artiPreciobase"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="articulos.precioventa"></s:text></td>
							<td><s:property value="articulo.artiPrecioventa"/></td>
							<td class="leftLabel"><s:text name="articulos.porcentajeuti"></s:text></td>
							<td><s:property value="articulo.artiPorcentajeutilidad"/></td>
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
