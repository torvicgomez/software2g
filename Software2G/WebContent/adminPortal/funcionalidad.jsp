<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#funcionalidad').dataTable( {
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
				document.form.action="funcionalidad.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="funcionalidad.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="funcionalidad.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="funcionalidad.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
		</script>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.funcionalidades"></s:text></h1>
					</td></tr>
					<s:if test="estado=='all'">
						<tr><td class="css_right">
							<input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregar();" class="buttonSV"/>
						</td></tr>
					</s:if> 
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="estado=='abstract'">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<s:if test="estado=='all'||estado=='query'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="funcionalidad">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<th><s:text name="funcionalidades.nombrefunc"></s:text></th>
								<th><s:text name="funcionalidades.etiquetafunc"></s:text></th>
								<th><s:text name="funcionalidades.descripcionfunc"></s:text></th>
								<th><s:text name="funcionalidades.estadofunc"></s:text></th>
								<th><s:text name="funcionalidades.fechahoraregistro"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listFuncionalidad" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="detalle('${data.idFunc}');">
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18"> --%>
													Editar
											</a>
										</td>
									</s:if>
									<td><s:property value="nombreFunc"/></td>
									<td><s:property value="etiquetaFunc"/></td>
									<td><s:property value="descripcionFunc"/></td>
									<td><s:property value="estadoFunc"/></td>
									<td><s:property value="fechacambio"/> <s:property value="horacambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.nombrefunc"></s:text></td>
							<td>
								<s:hidden name="funcionalidad.idFunc" id="idFunc"></s:hidden>
								<s:textfield name="funcionalidad.nombreFunc" id="nombreFunc" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.etiquetafunc"></s:text></td>
							<td>
								<s:textfield name="funcionalidad.etiquetaFunc" id="etiquetaFunc" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.accionfunc"></s:text></td>
							<td>
								<s:textfield name="funcionalidad.urlFunc" id="urlFunc" size="70" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.descripcionfunc"></s:text></td>
							<td>
								<s:textarea name="funcionalidad.descripcionFunc" cols="100" rows="3" cssClass="inputs"></s:textarea>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.estadofunc"></s:text></td>
							<td>
								<s:select list="#{'ACTIVO':'ACTIVO','INACTIVO':'INACTIVO'}" name="funcionalidad.estadoFunc" cssClass="inputs"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.funcionalidadPadres"></s:text></td>
							<td>
								<s:select list="listFuncionalidad" name="funcionalidad.funcionalidad.idFunc" listKey="idFunc" listValue="nombreFunc" headerKey="" headerValue="Función Padre" cssClass="inputs"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="funcionalidades.aplicacion"></s:text></td>
							<td>
								<s:select list="listAplicacion" name="funcionalidad.aplicacion.idApli" listKey="idApli" listValue="nombreApli" cssClass="inputs"/>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
				<s:elseif test="estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.nombrefunc"></s:text></td>
							<td class="text"><s:property value="funcionalidad.nombreFunc"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.etiquetafunc"></s:text></td>
							<td class="text"><s:property value="funcionalidad.etiquetaFunc"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.accionfunc"></s:text></td>
							<td class="text"><s:property value="funcionalidad.urlFunc"/></td>
						</tr> 
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.descripcionfunc"></s:text></td>
							<td class="text"><s:property value="funcionalidad.descripcionFunc"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.estadofunc"></s:text></td>
							<td class="text"><s:property value="funcionalidad.estadoFunc"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.funcionalidadPadres"></s:text></td>
							<td class="text"><s:property value="funcionalidad.funcionalidad.nombreFunc"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="funcionalidades.aplicacion"></s:text></td>
							<td class="text"><s:property value="funcionalidad.aplicacion.nombreApli"/></td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="css_right">
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