<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			jQuery(function($){
				$.datepicker.regional['es'] = {
					closeText: 'Cerrar',
					prevText: '&#x3c;Ant',
					nextText: 'Sig&#x3e;',
					currentText: 'Hoy',
					monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
					monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
					dayNames: ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
					dayNamesShort: ['Dom','Lun','Mar','Mi&eacute;','Juv','Vie','S&aacute;b'],
					dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S&aacute;'],
					weekHeader: 'Sm',
					dateFormat: 'dd/mm/yy',
					firstDay: 1,
					isRTL: false,
					showMonthAfterYear: false,
					yearSuffix: ''};
					$.datepicker.setDefaults($.datepicker.regional['es']);
				}
			);
			
			$(document).ready(function() {
				$('#agendaMedica').dataTable( {
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
	                                tipo : 'profesional'
	                        	},
	                        	dataType : "json",
	                        	success : function(data) {
	                                	response(data);
	                        	}
	                		});
        				}
					});
				});
				
				$("#agenFechaini").datepicker({numberOfMonths: 1,showButtonPanel: false, dateFormat: 'yy-mm-dd'});
				$("#agenFechafin").datepicker({numberOfMonths: 1,showButtonPanel: false, dateFormat: 'yy-mm-dd'});
				  
				$('#agenMintime').timepicker({
				    timeFormat: 'HH:mm:ss',
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty.
				    showCloseButton: true
				});
				$('#agenMaxtime').timepicker({ 
				    timeFormat: 'HH:mm:ss',
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty.
				    showCloseButton: true
				});
				$('#agenDuracionevento').timepicker({
				    timeFormat: 'HH:mm:ss',
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty.
				    showCloseButton: true
				});
				$('#agenScrolltime').timepicker({ 
				    timeFormat: 'HH:mm:ss',
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty.
				    showCloseButton: true
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
				document.form.action="agendamedica.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="agendamedica.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="agendamedica.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="agendamedica.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="agendamedica.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
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
						<h1><s:text name="titulo.agendamedica"></s:text></h1>
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="agendaMedica">
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
								<th><s:text name="agendamedica.fechainicial"></s:text></th>
								<th><s:text name="agendamedica.fechafinal"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listAgendaMedica" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.agenId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.agenId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="profesional.persona.nombreCompleto"/></td>
									<td><s:property value="profesional.persona.documentoPers"/>&nbsp;<s:property value="profesional.persona.tipodocumento.abreviaturaTidoc"/></td>
									<td><s:property value="agenFechaini"/></td>
									<td><s:property value="agenFechafin"/></td>
									<td><s:property value="agenFechacambio"/>&nbsp;<s:property value="agenHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="agendaMedica.agenId" id="agenId"></s:hidden>
						<s:hidden name="agendaMedica.profesional.profId" id="profId"></s:hidden>
						<s:hidden name="agendaMedica.profesional.persona.idPers" id="idPers"></s:hidden>
						<s:if test="estado=='add'||bandEstadoFunc=='addsave'">
							<tr>
								<td class="leftLabel"><s:text name="profesionalsalud.findpersona"></s:text></td>
								<td colspan="3">
									<s:set name="idPersona" value="agendaMedica.profesional.persona.idPers"></s:set>
									<input type="hidden" id="idAuxPersona" value="${idPersona}"/>
									<div id="campoFind" style="overflow:auto;width:auto;height:auto;display:block">
										<s:textfield name="dataAutoCompletado" id="search" size="60" maxlength="30" cssClass="inputs"></s:textfield>
									</div>
									<div id="repetirFind" style="overflow:auto;width:auto;height:auto;display:none">
										<input type="button" value="<s:text name="labelbutton.repetirfind"></s:text>" onclick="repetirBusqueda();" class="buttonSV"/>
									</div>
								</td>
							</tr>
						</s:if>
						<tr>
							<td colspan="4">
								<div id="divDatosPersona">
								<s:if test="agendaMedica.profesional.persona!=null&&agendaMedica.profesional.persona.idPers>0">
									<table cellpadding="0" cellspacing="0" border="0" class="display">
										<tr><td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.nombreCompleto"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.documento"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.documentoPers"/>&nbsp;<s:property value="agendaMedica.profesional.persona.tipodocumento.abreviaturaTidoc"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.fechanacimientoedad"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.fechanacimientoPers"/>&nbsp;<s:property value="agendaMedica.profesional.persona.edad"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.sexo"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.sexoPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.estadocivil"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.estadocivilPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.email"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.emailPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.telefonoPers"/></td>
										</tr>
										<tr><td class="leftLabel"><s:text name="personal.direccion"></s:text></td>
											<td><s:property value="agendaMedica.profesional.persona.ubicacionPersona"/>&nbsp;<s:property value="agendaMedica.profesional.persona.direccionPers"/></td>
										</tr>
									</table>
								</s:if>
								</div>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.fechainicial"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenFechaini" id="agenFechaini" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.fechafinal"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenFechafin" id="agenFechafin" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.horainici"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenMintime" id="agenMintime" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.horafin"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenMaxtime" id="agenMaxtime" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.duracion"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenDuracionevento" id="agenDuracionevento" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.scrolltime"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenScrolltime" id="agenScrolltime" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.alldayslot"></s:text></td>
							<td>
								<s:select list="#{'1':'ACTIVO','0':'INACTIVO'}" name="agendaMedica.agenAlldayslot" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"/>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.alldaytext"></s:text></td>
							<td>
								<s:textfield name="agendaMedica.agenAlldaytext" id="agenAlldaytext" size="30" maxlength="30" cssClass="inputs"></s:textfield>
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
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.nombreCompleto"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.documento"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.documentoPers"/>&nbsp;<s:property value="agendaMedica.profesional.persona.tipodocumento.abreviaturaTidoc"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.fechanacimientoedad"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.fechanacimientoPers"/>&nbsp;<s:property value="agendaMedica.profesional.persona.edad"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.sexo"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.sexoPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.estadocivil"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.estadocivilPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.email"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.emailPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.telefonoPers"/></td>
						</tr>
						<tr><td class="leftLabel"><s:text name="personal.direccion"></s:text></td>
							<td colspan="3"><s:property value="agendaMedica.profesional.persona.ubicacionPersona"/>&nbsp;<s:property value="agendaMedica.profesional.persona.direccionPers"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.fechainicial"></s:text></td>
							<td><s:property value="agendaMedica.agenFechaini"/></td>
							<td class="leftLabel"><s:text name="agendamedica.fechafinal"></s:text></td>
							<td><s:property value="agendaMedica.agenFechafin"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.horainici"></s:text></td>
							<td><s:property value="agendaMedica.agenMintime"/></td>
							<td class="leftLabel"><s:text name="agendamedica.horafin"></s:text></td>
							<td><s:property value="agendaMedica.agenMaxtime"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.duracion"></s:text></td>
							<td><s:property value="agendaMedica.agenDuracionevento"/></td>
							<td class="leftLabel"><s:text name="agendamedica.scrolltime"></s:text></td>
							<td><s:property value="agendaMedica.agenScrolltime"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.alldayslot"></s:text></td>
							<td><s:if test="agendaMedica.agenAlldayslot==\"1\"">ACTIVO</s:if><s:else>INACTIVO</s:else></td>
							<td class="leftLabel"><s:text name="agendamedica.alldaytext"></s:text></td>
							<td><s:property value="agendaMedica.agenAlldaytext"/></td>
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
<script type="text/javascript" charset="utf-8">validarView();</script>