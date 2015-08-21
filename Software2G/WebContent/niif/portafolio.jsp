<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#portafolio').dataTable( {
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
				document.form.action="portafolio.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="portafolio.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="portafolio.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="portafolio.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="portafolio.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
				document.form.submit();
			}
			
			function vertodo(param){
// 				alert(param);
				document.form.action="portafolio.action?estado=<%=ConstantesAplicativo.constanteeEstadoVerTodo%>&id="+param;
				document.form.submit();
			}
			
		</script>
</head>
<body>
	<s:form id="form" enctype="multipart/form-data">
		<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<s:hidden name="sizeList"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.portafolios"></s:text></h1>
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
<%-- 				<s:if test="estado=='all'||estado=='query'"> --%>
<!-- 					<table cellpadding="0" cellspacing="0" border="0" class="display" id="portafolio"> -->
<!-- 						<thead> -->
<!-- 							<tr> -->
<%-- 								<s:if test="estado=='all'"> --%>
<%-- 									<th><s:text name="columna.edit"></s:text></th> --%>
<%-- 								</s:if> --%>
<%-- 								<s:if test="estado=='all'"> --%>
<%-- 									<th><s:text name="columna.dtll"></s:text></th> --%>
<%-- 								</s:if> --%>
<%-- 								<th><s:text name="portafolios.referencia"></s:text></th> --%>
<%-- 								<th><s:text name="portafolios.imagen"></s:text></th> --%>
<%-- 								<th><s:text name="portafolios.descripcion"></s:text></th> --%>
<%-- 								<th><s:text name="portafolios.valor"></s:text></th> --%>
<%-- 								<th><s:text name="portafolios.vervalor"></s:text></th> --%>
<%-- 								<th><s:text name="global.fecharegistra"></s:text></th> --%>
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->
<%-- 							<s:iterator value="listPortafolio" id="data"> --%>
<!-- 								<tr> -->
<%-- 									<s:if test="estado=='all'"> --%>
<!-- 										<td align="center"> -->
<%-- 											<a onclick="modificar('${data.portId}');"> --%>
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18"> --%>
<!-- 											</a> -->
<!-- 										</td> -->
<!-- 										<td align="center"> -->
<%-- 											<a onclick="detalle('${data.portId}');"> --%>
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18"> --%>
<!-- 											</a> -->
<!-- 										</td> -->
<%-- 									</s:if> --%>
<%-- 									<td><s:property value="portReferencia"/></td> --%>
<!-- 									<td> -->
<%-- 										<img id="img_destino" alt="FOTO" src="<%=request.getContextPath()%><s:property value="archivotabla.rutaAlterna"/>" width="150" height="100"> --%>
<!-- 									</td> -->
<%-- 									<td><s:property value="portDescripcion"/></td> --%>
<%-- 									<td><s:property value="portValor"/></td> --%>
<%-- 									<td><s:property value="portVervalor"/></td> --%>
<%-- 									<td><s:property value="portFechacambio"/>&nbsp;<s:property value="portHoracambio"/></td> --%>
<!-- 								</tr> -->
<%-- 							</s:iterator> --%>
<!-- 						</tbody> -->
<!-- 						<tfoot></tfoot> -->
<!-- 					</table> -->
<%-- 				</s:if> --%>
				<s:if test="estado=='all'||estado=='query'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="portafoliocategoria">
						<thead>
							<tr>
<%-- 								<s:if test="estado=='all'"> --%>
<%-- 									<th><s:text name="columna.edit"></s:text></th> --%>
<%-- 								</s:if> --%>
<%-- 								<s:if test="estado=='all'"> --%>
<%-- 									<th><s:text name="columna.dtll"></s:text></th> --%>
<%-- 								</s:if> --%>
								<th><s:text name="portafolioscategoria.referencia"></s:text></th>
								<th><s:text name="portafolioscategoria.imagen"></s:text></th>
								<th><s:text name="profesional.coloragenda"></s:text></th>
								<th><s:text name="portafolioscategoria.descripcion"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listPortafoliocategoria" id="data">
								<tr>
<%-- 									<s:if test="estado=='all'"> --%>
<!-- 										<td align="center"> -->
<%-- 											<a onclick="modificar('${data.pocaId}');"> --%>
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18"> --%>
<!-- 											</a> -->
<!-- 										</td> -->
<!-- 										<td align="center"> -->
<%-- 											<a onclick="detalle('${data.pocaId}');"> --%>
<%-- 												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18"> --%>
<!-- 											</a> -->
<!-- 										</td> -->
<%-- 									</s:if> --%>
									<td><s:property value="pocaReferencia"/></td>
									<td>
										<a onclick="vertodo('${data.pocaId}');">
											<img id="img_poca" alt="FOTO" src="<%=request.getContextPath()%><s:property value="archivo.rutaAlterna"/>" width="150" height="100"></td>
										</a>
									<td bgcolor="<s:property value="pocaBackgroundcolor"/>"></td>
									<td><s:property value="pocaDescripcion"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="portafolio.portId" id="portId"></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.categoria"></s:text></td>
							<td colspan="3">
<%-- 								<s:if test="listPortafoliocategoria!=null&&listPortafoliocategoria.size()>0">	 --%>
										<s:select list="listPortafoliocategoria" name="portafoliocategoria.pocaId" listKey="pocaId" listValue="pocaReferencia" headerKey="-1" headerValue=".::Seleccion::." cssClass="inputs"/>
<%-- 								</s:if> --%>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.referencia"></s:text></td>
							<td colspan="3">
								<s:textfield name="portafolio.portReferencia" id="portReferencia" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.descripcion"></s:text></td>
							<td>
								<s:textarea name="portafolio.portDescripcion" id="portDescripcion" cols="100"  rows="3" cssClass="inputs"></s:textarea>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.valor"></s:text></td>
							<td>
								<s:textfield name="portafolio.portValor" id="portValor" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.vervalor"></s:text></td>
							<td colspan="3">
								<s:select list="listEstado" id="portVervalor" name="portafolio.portVervalor" listKey="key" listValue="valor" cssClass="inputs"></s:select>
							</td>
						</tr>
						<tr>
						<td class="leftLabel" width="130"><s:text name="portafolios.imagen"></s:text></td>
						<td class="text"><s:file name="fileUpload"/></td>
						<td>
							<a href="<%=request.getContextPath()%><s:property value="archivotabla.rutaAlterna"/>">
								<s:property value="archivotabla.artaArchoriginal"/>
							</a>
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
							<td class="leftLabel"><s:text name="portafolios.referencia"></s:text></td>
							<td colspan="3"><s:property value="portafolio.portReferencia"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.descripcion"></s:text></td>
							<td colspan="3"><s:property value="portafolio.portDescripcion"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.valor"></s:text></td>
							<td><s:property value="portafolio.portValor"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolios.vervalor"></s:text></td>
							<td><s:property value="portafolio.portVervalor"/></td>
						</tr>
						<s:if test="archivotabla.artaArchoriginal!=null||archivotabla.rutaAlterna!=null">
						<tr><td class="leftLabel" width="130"><s:text name="portafolios.imagen"></s:text></td>
							<td>
								<a href="<%=request.getContextPath()%><s:property value="archivotabla.rutaAlterna"/>">
									<s:property value="archivotabla.artaArchoriginal"/>
								</a>
							</td>
						</tr>
						</s:if>
						<s:else>
							<tr>
<%-- 								<td class="leftLabel"><s:text name="portafolios.imagen"></s:text></td> --%>
								<td class="leftLabel" colspan="2"><center><s:text name="portafolios.sinimagen"></s:text></center></td>
							</tr>
						</s:else>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
				<s:elseif test="estado=='vertodo'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="portafolio">
						<thead>
							<tr>
								<th colspan="3"><s:text name="portafolios.imagen"></s:text></th>	
							</tr>
						</thead>
						<tbody><tr>
							<s:iterator value="listPortafolio" id="data">
								<td>
									<table>
										
										<tr>
											<td>
												<img id="img_port" alt="FOTO" src="<%=request.getContextPath()%><s:property value="archivo.rutaAlterna"/>" width="150" height="100"></td>
										</tr>
										<tr>
<!-- 											<td align="center"> -->
<%-- 												<a onclick="detalle('${data.portId}');"> --%>
<%-- 													<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18"> --%>
<!-- 												</a> -->
<!-- 											</td> -->
											<td><s:property value="portReferencia"/></td>
										</tr>
										<tr>
											<td><s:property value="portDescripcion"/></td>
										</tr>
									</table>
								</td>
							</s:iterator></tr>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
	</s:form>
</body>
</html>