<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#portafoliocategoria').dataTable( {
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
				document.form.action="portafoliocategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="portafoliocategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="portafoliocategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="portafoliocategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="portafoliocategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
				document.form.submit();
			}
			
			
		</script>
</head>
<body>
	<s:form id="form" enctype="multipart/form-data">
		<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.portafolioscategoria"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="portafoliocategoria">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="portafolioscategoria.imagen"></s:text></th>
								<th><s:text name="portafolioscategoria.referencia"></s:text></th>
								<th><s:text name="portafolioscategoria.descripcion"></s:text></th>
								<th><s:text name="profesional.coloragenda"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listPortafoliocategoria" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.pocaId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.pocaId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><img id="img_poca" alt="FOTO" src="<%=request.getContextPath()%><s:property value="archivo.rutaAlterna"/>" width="150" height="100"></td>
									<td><s:property value="pocaReferencia"/></td>
									<td><s:property value="pocaDescripcion"/></td>
									<td bgcolor="<s:property value="pocaBackgroundcolor"/>"></td>
									<td><s:property value="pocaFechacambio"/>&nbsp;<s:property value="pocaHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="portafoliocategoria.pocaId" id="portId"></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="portafolioscategoria.referencia"></s:text></td>
							<td colspan="3">
								<s:textfield name="portafoliocategoria.pocaReferencia" id="pocaReferencia" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolioscategoria.descripcion"></s:text></td>
							<td>
								<s:textarea name="portafoliocategoria.pocaDescripcion" id="pocaDescripcion" cols="100"  rows="3" cssClass="inputs"></s:textarea>
							</td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="portafolioscategoria.imagen"></s:text></td>
							<td class="text"><s:file name="fileUpload"/></td>
							<td>
								<a href="<%=request.getContextPath()%><s:property value="archivotabla.rutaAlterna"/>">
									<s:property value="archivotabla.artaArchoriginal"/>
								</a>
							</td>
						</tr>
						
						<tr>
							<td class="leftLabel"><s:text name="profesionalsalud.coloragenda"></s:text></td>
							<td colspan="3">
								<s:textfield name="portafoliocategoria.pocaBackgroundcolor" id="pocaBackgroundcolor" size="30" maxlength="30" cssClass="inputs" onclick="startColorPicker(this)" onkeyup="maskedHex(this)"></s:textfield>
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
							<td class="leftLabel"><s:text name="portafolioscategoria.referencia"></s:text></td>
							<td colspan="3"><s:property value="portafoliocategoria.pocaReferencia"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolioscategoria.descripcion"></s:text></td>
							<td colspan="3"><s:property value="portafoliocategoria.pocaDescripcion"/></td>
						</tr>
						
						<s:if test="archivotabla.artaArchoriginal!=null||archivotabla.rutaAlterna!=null">
							<tr><td class="leftLabel" width="130"><s:text name="portafolioscategoria.imagen"></s:text></td>
								<td>
									<img id="img_poca" alt="FOTO" src="<%=request.getContextPath()%><s:property value="archivotabla.rutaAlterna"/>" width="150" height="100">
<%-- 									<a href="<%=request.getContextPath()%><s:property value="archivotabla.rutaAlterna"/>"> --%>
										<s:property value="archivotabla.artaArchoriginal"/>
<!-- 									</a> -->
								</td>
							</tr>
						</s:if>
						<s:else>
							<tr>
								<td class="leftLabel" colspan="2"><center><s:text name="portafolioscategoria.sinimagen"></s:text></center></td>
							</tr>
						</s:else>
						
						<tr>
							<td class="leftLabel" width="130"><s:text name="profesionalsalud.coloragenda"></s:text></td>
							<td colspan="3"><table border="0" width="70%"><tr> 
								<td bgcolor="<s:property value="portafoliocategoria.pocaBackgroundcolor"/>" width="15%"><s:property value="portafoliocategoria.pocaBackgroundcolor"/></td><td></td>
							</tr></table></td>
							
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