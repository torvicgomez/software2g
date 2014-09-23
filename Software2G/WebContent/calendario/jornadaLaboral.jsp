<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="x" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/syntax/css/shCore.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/css/jquery-ui.css'/>" rel="stylesheet" type="text/css" />
    <link href="<s:url value='/css/jquery.ui.timepicker.css'/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery-ui.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.ui.timepicker.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT> 
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
	<script type="text/javascript" charset="ISO-8859-1"> 
	$(document).ready(function() {
			$('#jornadaLaboral').dataTable( { 
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
			
			
			//Al escribr dentro del input con id="service"
		    $('#findProfesional').keyup(function(){
		        //Obtenemos el value del input
		        var service = $(this).val(); 
		        var dataString = 'service='+service;
		        //Le pasamos el valor del input al ajax
		        $.ajax({
		            type: "POST",
		            url: "autocompletadoProfesional.action?find="+service,
		            data: dataString,
		            success: function(data) {
		                //Escribimos las sugerencias que nos manda la consulta
		                $('#profesionales').fadeIn(1000).html(data);
		                //Al hacer click en algua de las sugerencias
		                $('.suggest-element').live('click', function(){
		                    //Obtenemos la id unica de la sugerencia pulsada
		                    var id = $(this).attr('id');
		                    //Editamos el valor del input con data de la sugerencia pulsada
		                    //$('#findProfesional').val($('#'+id).attr('data'));
		                    $('#findProfesional').val('');
		                    //Hacemos desaparecer el resto de sugerencias
		                    $('#profesionales').fadeOut(1000);
		                    cargarDatosPersonales(id);
		                });              
		            }
		        });
		    });
		    
		    $('#joraHoraingreso').timepicker({
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty. 
				    showCloseButton: true
			});
			
			$('#joraHorasalida').timepicker({
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty. 
				    showCloseButton: true
			});
		
			$('#joraHorarecesoini').timepicker({
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty. 
				    showCloseButton: true
			});
			
			$('#joraHorarecesofin').timepicker({
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty. 
				    showCloseButton: true
			}); 	
	} ); 
	
	function agregar(){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
		document.form.submit();
	}
	
	function cargarDatosPersonales(idPersona){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>&idPersona="+idPersona;
		document.form.submit();
	}
	
	function registrar(){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
		document.form.submit();
	}
	
	function volver(){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
		document.form.submit();
	}
	
	function detalle(param){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
		document.form.submit();
	}
	
	function resumen(param){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
		document.form.submit();
	}
	
	function agregarGrilla(){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoAddGrid%>";
		document.form.submit();
	}
	
	function eliminarGrilla(param){
		document.form.action="jornadaLaboral.action?estado=<%=ConstantesAplicativo.constanteEstadoDeleteGrid%>&posList="+param;
		document.form.submit();
	}
	</script>
</head>
<body id="dt_example">
		<s:form id="form">
		<s:hidden name="funcPosicionado"></s:hidden>
		<div id="demo">
				<table border="0" width="100%" align="center">
					<tr><td><h1><strong><s:text name="titulo.jornadaLaboral"></s:text></strong></h1></td></tr>
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
				<s:if test="estado==null||estado=='all'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="jornadaLaboral">
						<thead>
							<tr>
								<th align="left"  width="30%"><s:text name="columna.edit"></s:text></th>
								<th align="left"  width="30%"><s:text name="columna.dtll"></s:text></th>
								<th align="left"  width="10%"><s:text name="jornadaLaboral.profesional"></s:text></th>
								<th align="left"  width="15%"><s:text name="jornadaLaboral.fechahoraregistro"></s:text></th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="listJornadaLaboral" id="data">
							<tr>
								<td width="5%"><a onclick="javascript:detalle('<s:property value="pacaId"/>');">Editar</a></td>
								<td width="20%"><a onclick="javascript:detalle('<s:property value="pacaId"/>');">Detalle</a></td>
								<td width="20%"><s:property value="profesional.persId"/></td>
								<td width="35%"><s:property value="joraFechacambio"/> - <s:property value="joraHoracambio"/></td>
							</tr>
						</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="jornadaLaboral.findProfesional"></s:text></td>
							<td>
								<s:hidden name="persona.idPers"></s:hidden>
								<s:textfield name="profesional.findProfesional" id="findProfesional" size="100" cssClass="inputs"  placeholder="Nombre - Email - Teléfono" ></s:textfield>
								<br><div id="profesionales" style="display: none;"></div>
							</td>
						</tr>
						<s:if test="persona.idPers>0">
							<tr>
								<td colspan="2" class="leftLabel"><s:text name="jornadaLaboral.datosProfesional"></s:text></td>
							</tr>
							<tr>
								<td class="leftLabel"><s:text name="jornadaLaboral.profesional"></s:text></td>
								<td><s:property value="persona.nombreCompleto"/></td>
							</tr> 
							<tr>
								<td class="leftLabel"><s:text name="jornadaLaboral.emailProfesional"></s:text></td>
								<td><s:property value="persona.emailPers"/></td>
							</tr>
							<tr>
								<td class="leftLabel"><s:text name="jornadaLaboral.telefonoProfesional"></s:text></td>
								<td><s:property value="persona.telefonoPers"/></td>
							</tr>
							<tr>
								<td class="leftLabel"><s:text name="jornadaLaboral.especialidadProf"></s:text></td>
								<td>
									<table cellpadding="0" cellspacing="0" border="0" class="display">
										<s:iterator value="persona.profesional" id="data" status="stat">
											<tr>
												<td><s:checkbox name="persona.profesional[%{#stat.index}].selectProfesion"></s:checkbox><s:property value="profEspecialidad"/></td>
											</tr>
										</s:iterator>
									</table>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="leftLabel"><s:text name="titulo.jornadaLaboral"></s:text></td>
							</tr>
							<tr>
								<td colspan="2">
									<table cellpadding="0" cellspacing="0" border="0" class="display">
										<tr>
											<td class="leftLabel"><s:text name="jornadaLaboral.nombrejornada"></s:text></td>
											<td colspan="3"><s:textfield name="jornadaLaboral.joraNombre" id="joraNombre" cssClass="inputs" size="50"></s:textfield></td>
										</tr>
										<tr>
											<td class="leftLabel"><s:text name="jornadaLaboral.horainiciojor"></s:text></td>
											<td><s:textfield name="jornadaLaboral.joraHoraingreso" id="joraHoraingreso" cssClass="inputs"></s:textfield></td>
											<td class="leftLabel"><s:text name="jornadaLaboral.horafinaljor"></s:text></td>
											<td><s:textfield name="jornadaLaboral.joraHorasalida" id="joraHorasalida" cssClass="inputs"></s:textfield></td>
										</tr>
										<tr>
											<td class="leftLabel"><s:text name="jornadaLaboral.horainiciorecjor"></s:text></td>
											<td><s:textfield name="jornadaLaboral.joraHorarecesoini" id="joraHorarecesoini" cssClass="inputs"></s:textfield></td>
											<td class="leftLabel"><s:text name="jornadaLaboral.horafinalrecjor"></s:text></td>
											<td><s:textfield name="jornadaLaboral.joraHorarecesofin" id="joraHorarecesofin" cssClass="inputs"></s:textfield></td>
										</tr>
										<tr>
											<td class="leftLabel"><s:text name="jornadaLaboral.diasjornada"></s:text></td>
											<td colspan="3">
												<s:checkbox name="jornadaLaboral.listDiasSemana[0]"></s:checkbox>Lunes
												<s:checkbox name="jornadaLaboral.listDiasSemana[1]"></s:checkbox>Martes
												<s:checkbox name="jornadaLaboral.listDiasSemana[2]"></s:checkbox>Miércoles
												<s:checkbox name="jornadaLaboral.listDiasSemana[3]"></s:checkbox>Jueves
												<s:checkbox name="jornadaLaboral.listDiasSemana[4]"></s:checkbox>Viernes
												<s:checkbox name="jornadaLaboral.listDiasSemana[5]"></s:checkbox>Sábado
												<s:checkbox name="jornadaLaboral.listDiasSemana[6]"></s:checkbox>Domingo
											</td>
										</tr>
										<tr>
											<td></td><td></td><td></td>
											<td class="css_right"><input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregarGrilla();" class="buttonSV"/></td>
										</tr>
										<tr>
											<td colspan="4" class="text">
												<s:if test="listLugarDestino!=null&&listLugarDestino.size()>0">
													<table cellpadding="0" cellspacing="0" border="1" class="display" id="paradasProgramadas"> 
														<thead>
															<tr>
																<th><s:text name="lugarParada.orden"></s:text></th>
																<th><s:text name="lugarParada.parada"></s:text></th>
																<th><s:text name="lugarParada.tipoParada"></s:text></th>
																<th></th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="listLugarDestino" id="data" status="stat">
																<tr>
																	<td>${stat.index+1}</td>
																	<td>
																		<s:if test="ludeOrden==0"><s:property value="ludeOrigen"/></s:if>
																		<s:elseif test="ludeOrden==99"><s:property value="ludeFinviaje"/></s:elseif>
																		<s:else><s:property value="ludeParada"/></s:else>
																	</td>
																	<td>
																		<s:if test="ludeOrden==0"><s:text name="lugarParada.labelGridOrigen"></s:text></s:if>
																		<s:elseif test="ludeOrden==99"><s:text name="lugarParada.labelGridDestino"></s:text></s:elseif>
																		<s:else><s:text name="lugarParada.labelGridParada"></s:text></s:else>
																	</td>
																	<td class="right"><input type="button" value="<s:text name="labelbutton.eliminarGrilla"></s:text>" onclick="eliminarGrilla('${stat.index}');" class="buttonSV"/></td>
																</tr>
															</s:iterator>
														</tbody>
													</table>	
												</s:if>
												<s:else><s:text name="advertencia.noregistros"></s:text></s:else>	
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</s:if>
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
							<td class="leftLabel" width="130"><s:text name="paramCalendario.variable"></s:text></td>
							<td class="text"><s:property value="parametroCalendario.pacaVariable"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="paramCalendario.valor"></s:text></td>
							<td class="text"><s:property value="parametroCalendario.pacaValor"/></td>
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
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>
