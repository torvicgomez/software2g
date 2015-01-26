<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#profesionalSalud').dataTable( {
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
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
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
						<h1><s:text name="titulo.profesionalsalud"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="profesionalSalud">
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
								<th><s:text name="profesionalsalud.nrotarjetaprof"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listProfesional" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="detalle('${data.profId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.profId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="persona.nombreCompleto"/></td>
									<td><s:property value="persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/></td>
									<td><s:property value="profNrotarjetaprof"/></td>
									<td><s:property value="profFechacambio"/>&nbsp;<s:property value="profHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="profesionalsalud.findpersona"></s:text></td>
							<td colspan="3">
								<s:hidden name="profesional.profId" id="profId"></s:hidden>
								<s:hidden name="profesional.persona.idPers" id="idPers"></s:hidden>
								<div id="campoFind" style="overflow:auto;width:auto;height:auto;display:block">
									<s:textfield name="dataAutoCompletado" id="search" size="60" maxlength="30" cssClass="inputs"></s:textfield>
								</div>
								<div id="repetirFind" style="overflow:auto;width:auto;height:auto;display:none">
									<input type="button" value="<s:text name="labelbutton.repetirfind"></s:text>" onclick="repetirBusqueda();" class="buttonSV"/>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="4"><div id="divDatosPersona"></div></td>
						</tr>
						<tr>
							<td class="leftLabel" colspan="4"><s:text name="profesionalsalud.datosprofesional"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="profesionalsalud.profesion"></s:text></td>
							<td colspan="3">
								<s:textfield name="profesional.profEspecialidad" id="profEspecialidad" size="60" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="profesionalsalud.nrotarjetaprof"></s:text></td>
							<td>
								<s:textfield name="profesional.profNrotarjetaprof" id="profNrotarjetaprof" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="profesionalsalud.estado"></s:text></td>
							<td>
								<s:select list="#{'1':'ACTIVO','0':'INACTIVO'}" name="profesional.profEstado" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="profesionalsalud..coloragenda"></s:text></td>
							<td colspan="3">
								<s:textfield name="profesional.profBackgroundcoloragen" id="profBackgroundcoloragen" size="30" maxlength="30" cssClass="inputs" onclick="startColorPicker(this)" onkeyup="maskedHex(this)"></s:textfield>
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
							<td class="leftLabel" width="130"><s:text name="personal.nombre"></s:text></td>
							<td class="text"><s:property value="profesional.persona.nombreCompleto"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="personal.documento"></s:text></td>
							<td class="text"><s:property value="profesional.persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="profesionalsalud.profesion"></s:text></td>
							<td class="text"><s:property value="profesional.profEspecialidad"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="profesionalsalud.nrotarjetaprof"></s:text></td>
							<td class="text"><s:property value="profesional.profNrotarjetaprof"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="profesionalsalud.estado"></s:text></td>
							<td class="text"><s:if test="profesional.profEstado==\"1\"">ACTIVO</s:if><s:else>INACTIVO</s:else></td>
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