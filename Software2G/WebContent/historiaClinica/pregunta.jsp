<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#pregunta').dataTable( {
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
				document.form.action="pregunta.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="pregunta.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="pregunta.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="pregunta.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="pregunta.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
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
						<h1><s:text name="titulo.pregunta"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="pregunta">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="pregunta.segmentoanamnesis"></s:text></th>
								<th><s:text name="pregunta.tipopregunta"></s:text></th>
								<th><s:text name="pregunta.pregunta"></s:text></th>
								<th><s:text name="pregunta.objetoview"></s:text></th>
								<th><s:text name="pregunta.estado"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listPregunta" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.pregId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.pregId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="segmentoanamnesi.seanNombre"/></td>
									<td><s:property value="tipopregunta.tiprNombre"/></td>
									<td><s:property value="pregPregunta"/></td>
									<td><s:property value="pregObjetoview"/></td> 
									<td><s:property value="pregEstado"/></td>
									<td><s:property value="pregFechacambio"/>&nbsp;<s:property value="pregHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="pregunta.pregId" id="pregId"></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.segmentoanamnesis"></s:text></td>
							<td colspan="3">
								<s:select list="listSegmentoAnamnesis" id="tipoSegmentoAnamnesis" name="pregunta.segmentoanamnesi.seanId" listKey="seanId" listValue="seanNombre" headerKey="-1" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.tipopregunta"></s:text></td>
							<td colspan="3">
								<s:select list="listTipoPregunta" id="tipoPregunta" name="pregunta.tipopregunta.tiprId" listKey="tiprId" listValue="tiprNombre" headerKey="-1" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.pregunta"></s:text></td>
							<td colspan="3">
								<s:textfield name="pregunta.pregPregunta" id="pregPregunta" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.respobligatoria"></s:text></td>
							<td colspan="3">
								<s:select list="listRespObligatoria" id="respObligatoria" name="pregunta.pregRespobligatoria" listKey="key" listValue="valor" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.objetoview"></s:text></td>
							<td>
								<s:select list="listObjetoView" id="objetoView" name="pregunta.pregObjetoview" listKey="key" listValue="valor" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
							<td class="leftLabel"><s:text name="pregunta.estado"></s:text></td>
							<td>
								<s:select list="listEstado" id="estado" name="pregunta.pregEstado" listKey="key" listValue="valor" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.orden"></s:text></td>
							<td>
								<s:select list="listOrden" id="orden" name="pregunta.pregOrden" listKey="key" listValue="valor" headerKey="-1" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
							<td class="leftLabel"><s:text name="pregunta.tipodato"></s:text></td>
							<td>
								<s:select list="listTipoDato" id="tipoDato" name="pregunta.pregTipodato" listKey="key" listValue="valor" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.mensajeayuda"></s:text></td>
							<td colspan="3">
								<s:textarea name="pregunta.pregMensajeayuda" id="pregMensajeayuda" cols="100"  rows="3" cssClass="inputs"></s:textarea>
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
							<td class="leftLabel" width="130"><s:text name="pregunta.segmentoanamnesis"></s:text></td>
							<td colspan="3"><s:property value="pregunta.segmentoanamnesi.seanNombre"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="pregunta.tiposegmento"></s:text></td>
							<td colspan="3"><s:property value="pregunta.tipopregunta.tiprNombre"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.pregunta"></s:text></td>
							<td colspan="3"><s:property value="pregunta.pregPregunta"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.respobligatoria"></s:text></td>
							<td colspan="3"><s:property value="pregunta.pregRespobligatoria"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.objetoview"></s:text></td>
							<td><s:property value="pregunta.pregObjetoview"/></td>
							<td class="leftLabel"><s:text name="pregunta.estado"></s:text></td>
							<td><s:property value="pregunta.pregEstado"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.orden"></s:text></td>
							<td><s:property value="pregunta.pregOrden"/></td>
							<td class="leftLabel"><s:text name="pregunta.tipodato"></s:text></td>
							<td><s:property value="pregunta.pregTipodato"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="pregunta.mensajeayuda"></s:text></td>
							<td colspan="3"><s:property value="pregunta.pregMensajeayuda"/></td>
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
