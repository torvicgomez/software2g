<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#rol').dataTable( {
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
				document.form.action="rol.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="rol.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="rol.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="rol.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
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
						<h1><s:text name="titulo.roles"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="rol">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<th><s:text name="roles.nombrerol"></s:text></th>
								<th><s:text name="roles.etiqueta"></s:text></th>
								<th><s:text name="roles.descripcionrol"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listRol" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="detalle('${data.idRol}');">
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18"> --%>
													Editar
											</a>
										</td>
									</s:if>
									<td><s:property value="nombreRol"/></td>
									<td><s:property value="etiquetaRol"/></td>
									<td><s:property value="descripcionRol"/></td>
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
							<td class="leftLabel"><s:text name="roles.nombrerol"></s:text></td>
							<td>
								<s:hidden name="rol.idRol" id="idRol"></s:hidden>
								<s:textfield name="rol.nombreRol" id="nombreRol" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="roles.etiqueta"></s:text></td>
							<td>
								<s:textfield name="rol.etiquetaRol" id="etiquetaRol" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="roles.descripcionrol"></s:text></td>
							<td>
								<s:textarea name="rol.descripcionRol" cols="100" rows="3" cssClass="inputs"></s:textarea>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="roles.estado"></s:text></td>
							<td>
								<s:select list="#{'1':'ACTIVO','0':'INACTIVO'}" name="rol.estadoRol" cssClass="inputs"/>
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
							<td class="leftLabel" width="130"><s:text name="roles.nombrerol"></s:text></td>
							<td class="text"><s:property value="rol.nombreRol"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="roles.etiqueta"></s:text></td>
							<td class="text"><s:property value="rol.etiquetaRol"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="roles.descripcionrol"></s:text></td>
							<td class="text"><s:property value="rol.descripcionRol"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="roles.estado"></s:text></td>
							<td class="text">
								<s:if test="rol.estadoRol==\'1\'"><s:text name="global.estadoActivo"></s:text></s:if> 
								<s:else><s:text name="global.estadoInactivo"></s:text></s:else>
							</td>
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