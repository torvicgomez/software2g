<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#vendedor').dataTable( {
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
	                                term : request.term
	                        	},
	                        	dataType : "json",
	                        	success : function(data) {
	                                	response(data);
	                        	}
	                		});
        				}
					});
				});
				
				
			} );

			function cargarDatosPersona(id){
				$("#divDatosPersona").load('cargarDatosPersona.action?idPersona='+id);
				var idPers = document.getElementById('idPers');
				idPers.value = id;
				var campoFind = document.getElementById('campoFind');
				var repetirFind = document.getElementById('repetirFind');
				campoFind.style.display = 'none';
				repetirFind.style.display = 'block';
			}				
			
			function validarView(){
				var idAuxPersona = document.getElementById('idAuxPersona').value;
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
				var divDatosPersona = document.getElementById('divDatosPersona');
				divDatosPersona.innerHTML = '';
				var idPers = document.getElementById('idPers');
				idPers.value = 0;
				var campoFind = document.getElementById('campoFind');
				var repetirFind = document.getElementById('repetirFind');
				campoFind.style.display = 'block';
				repetirFind.style.display = 'none';
				var search = document.getElementById('search');
				search.value = '';
			}
			
			function agregar(){
				document.form.action="vendedor.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="vendedor.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="vendedor.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="vendedor.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="vendedor.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
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
						<h1><s:text name="titulo.vendedor"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="vendedor">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="personal.nombre"></s:text></th>
								<th><s:text name="personal.documento"></s:text></th>
								<th><s:text name="vendedor.codigo"></s:text></th>
								<th><s:text name="vendedor.estado"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listVendedor" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.vendId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.vendId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="persona.nombreCompleto"/></td>
									<td><s:property value="persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/></td>
									<td><s:property value="vendCodigo"/></td>
									<td><s:property value="vendFechacambio"/>&nbsp;<s:property value="vendHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="vendedor.vendId" id="vendId"></s:hidden>
						<s:hidden name="vendedor.persona.idPers" id="idPers"></s:hidden>
						<s:if test="estado=='add'||bandEstadoFunc=='addsave'">
							<tr>
								<td class="leftLabel"><s:text name="vendedor.findpersona"></s:text></td>
								<td colspan="3">
									<s:set name="idPersona" value="vendedor.persona.idPers"></s:set>
									<input type="hidden" id="idAuxPersona" value="${idPersona}"/>
									<div id="repetirFind" style="overflow:auto;width:auto;height:auto;display:none">
										<input type="button" value="<s:text name="labelbutton.repetirfind"></s:text>" onclick="repetirBusqueda();" class="buttonSV"/>
									</div>
									<div id="campoFind" style="overflow:auto;width:auto;height:auto;display:block">
										<s:textfield name="dataAutoCompletado" id="search" size="60" maxlength="30" cssClass="inputs"></s:textfield>
									</div>
								</td>
							</tr>
						</s:if>
						<tr>
							<td colspan="4">
								<div id="divDatosPersona">
									<s:if test="vendedor.persona!=null&&vendedor.persona.idPers>0">
									<table cellpadding="0" cellspacing="0" border="0" class="display">
										<tr><td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
											<td><s:property value="vendedor.persona.nombreCompleto"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.documento"></s:text></td>
											<td><s:property value="vendedor.persona.documentoPers"/>&nbsp;<s:property value="profesional.persona.tipodocumento.abreviaturaTidoc"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.fechanacimientoedad"></s:text></td>
											<td><s:property value="vendedor.persona.fechanacimientoPers"/>&nbsp;<s:property value="profesional.persona.edad"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.sexo"></s:text></td>
											<td><s:property value="vendedor.persona.sexoPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.estadocivil"></s:text></td>
											<td><s:property value="vendedor.persona.estadocivilPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.email"></s:text></td>
											<td><s:property value="vendedor.persona.emailPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
											<td><s:property value="vendedor.persona.telefonoPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.direccion"></s:text></td>
											<td><s:property value="vendedor.persona.ubicacionPersona"/>&nbsp;<s:property value="vendedor.persona.direccionPers"/></td>
										</tr>
									</table>
									</s:if>
								</div>
							</td>
						</tr>
						<tr>
							<td class="leftLabel" colspan="4"><s:text name="vendedor.datosvendedor"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="vendedor.codigo"></s:text></td>
							<td><s:property value="vendedor.vendCodigo"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="vendedor.estado"></s:text></td>
							<td>
								<s:select list="#{'S':'ACTIVO','N':'INACTIVO'}" name="vendedor.vendEstado" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"/>
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
						<tr><td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
							<td><s:property value="vendedor.persona.nombreCompleto"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.documento"></s:text></td>
							<td><s:property value="vendedor.persona.documentoPers"/>&nbsp;<s:property value="profesional.persona.tipodocumento.abreviaturaTidoc"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.fechanacimientoedad"></s:text></td>
							<td><s:property value="vendedor.persona.fechanacimientoPers"/>&nbsp;<s:property value="profesional.persona.edad"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.sexo"></s:text></td>
							<td><s:property value="vendedor.persona.sexoPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.estadocivil"></s:text></td>
							<td><s:property value="vendedor.persona.estadocivilPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.email"></s:text></td>
							<td><s:property value="profesional.persona.emailPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
							<td><s:property value="vendedor.persona.telefonoPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.direccion"></s:text></td>
							<td><s:property value="vendedor.persona.ubicacionPersona"/>&nbsp;<s:property value="vendedor.persona.direccionPers"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="vendedor.codigo"></s:text></td>
							<td><s:property value="vendedor.vendCodigo"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="vendedor.estado"></s:text></td>
							<td><s:if test="vendedor.vendEstado==\"S\"">ACTIVO</s:if><s:else>INACTIVO</s:else></td>
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
	</s:form>
</body>
</html>
<script type="text/javascript" charset="utf-8">validarView();</script>