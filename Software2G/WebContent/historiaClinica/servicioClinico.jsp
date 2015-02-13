<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$( "#datepicker3" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#datepicker4" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#datepicker5" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#datepicker6" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#datepicker7" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#datepicker8" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
// 				$('.p2').collapser({
// 					mode: 'block',
// 					showText: 'Detalle',
// 					hideText: 'Cerrar',
// 					changeText: 0
// 				});
				$('#horaEntrega').timepicker({
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty.
				    showCloseButton: true
				});
				$('#horaSalida').timepicker({
				    showNowButton: true,
				    showDeselectButton: true,
				    defaultTime: '',  // removes the highlighted time for when the input is empty.
				    showCloseButton: true
				});
				$("#cargarGoogleMaps").dialog({
				    autoOpen: false,
				    modal: true,
				    open: function(ev, ui){
				    		 var $led = $("#cargarGoogleMaps");
				    		 $('#mapaIframe').attr('height','600px');
				    		 $('#mapaIframe').attr('width','950px');
				             $('#mapaIframe').attr('src','<%=url%>asigviajes/utilGoogleMaps.jsp?soviId='+$led.data('param'));
				          },
				    height: 'auto',
				    width: 'auto',
				    resizable: true,
				    title: 'Ruta Solicitud de Viaje',
				    position: [50,50]
				});
			} );
			
			$(function() {
				$( "#pestanas" ).tabs();
			});
			
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
			
			$(function() {
				$( "#slider-range-min" ).slider({
					range: "min",
					value: 1,
					min: 1,
					max: 99,
					slide: function( event, ui ) {
						$( "#amount" ).val( ui.value );
					}
				});
				if(document.form.amount.value <= 1){
					$( "#amount" ).val( $( "#slider-range-min" ).slider( "value" ) );
				}else{
					$( "#slider-range-min" ).slider({
						value: document.form.amount.value
					});
				}
			});
			
			function buscar(){
				document.form.action="planillaSalidaPractica.action?estado=<%=ConstantesAplicativo.constanteEstadoSearch%>";
				document.form.submit();
			}
			
			function resumen(param){
				document.form.action="planillaSalidaPractica.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&idSol="+param;
				document.form.submit();
			}
			
			function verMapaFuncion(param){
				$('#cargarGoogleMaps').data('param', param);
				$('#cargarGoogleMaps').dialog('open');
			}
			
			function registrar(){
				document.form.action="planillaSalidaPractica.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function desplegarInfo(pos){
				var despliegeInfo = document.getElementById('processCalendar_'+pos);
				if(despliegeInfo.style.display=='none')
					despliegeInfo.style.display = 'block';
				else
					despliegeInfo.style.display = 'none';
			}
			
// 			function selectCalendar(pos){
<%-- 				document.form.action="planillaSalidaPractica.action?estado=<%=ConstantesAplicativo.constanteEstadoSelectCalendar%>&posListCalendar="+pos; --%>
// 				document.form.submit();
// 			}
			
// 			function cambiarCalendarSelect(){
<%-- 				document.form.action="planillaSalidaPractica.action?estado=<%=ConstantesAplicativo.constanteEstadoUpdateSelectCalendar%>"; --%>
// 				document.form.submit();
// 			}
			
			function ValidaSoloNumeros() {
				if ((event.keyCode < 48) || (event.keyCode > 57))
					event.returnValue = false;
			}
		</script>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="processCalendar"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<td>
							<h1><s:text name="plsalidap.titulo"></s:text></h1>
						</td>
					</tr>
				</table>
				<s:if test="estado=='allaaa'">
					<table>
						<tr>
							<td>
								<h3><s:text name="plsalidap.solscontratadas"></s:text></h3>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<thead>
							<tr>
								<th><s:text name="columna.detalle"></s:text></th>
								<th><s:text name="plsalidap.tipoSolicitud"></s:text></th>
								<th><s:text name="plsalidap.programa"></s:text></th>
								<th><s:text name="plsalidap.fechaPrevista"></s:text></th>
								<th><s:text name="plsalidap.responsable"></s:text></th>
								<th><s:text name="labelbutton.vermapa"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:set name="tmpSol" value="0"/>
							<s:iterator value="listLugaresParada" id="data">
								<s:if test="%{#tmpSol!=solicitudviaje.soviId}">
									<s:set name="tmpSol" value="solicitudviaje.soviId"/>
									<tr class="p2">
										<td>
											<a onclick="resumen('${data.solicitudviaje.soviId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
										<td><s:property value="solicitudviaje.tiposolicitudviaje.tpsvDescripcion"/></td>
										<td><s:property value="solicitudviaje.programa.progNombre"/></td>
										<td><s:property value="solicitudviaje.soviFechaprevista"/></td>
										<td><s:property value="solicitudviaje.responsableviaje.rvijNombre"/></td>
										<td align="center"><input type="button" value="<s:text name="labelbutton.vermapa"></s:text>" name="verMapa" id="verMapa" class="buttonSV" onclick="verMapaFuncion('${data.solicitudviaje.soviId}');"/></td>
									</tr>
									<tr>
										<td colspan="6">
											<table border="1" width="100%" style="background-color: #C69898;">
												<tr>
													<th><s:text name="lugarParada.orden"></s:text></th>
													<th><s:text name="lugarParada.parada"></s:text></th>
													<th><s:text name="lugarParada.tipoParada"></s:text></th>
													<th><s:text name="lugarParada.motivoParada"></s:text></th>
												</tr>
												<s:iterator value="listLugaresParada" id="data2" status="stat">
													<s:set name="tmpSol2" value="solicitudviaje.soviId"/>
													<s:if test="%{#tmpSol==(#tmpSol2)}">
														<tr>
															<td><s:property value="lupaOrden"/></td>
															<td>
																<s:if test="lupaOrden==0"><s:property value="lupaOrigen"/></s:if>
																<s:elseif test="lupaOrden==99"><s:property value="lupaFinviaje"/></s:elseif>
																<s:else><s:property value="lupaParada"/></s:else>
															</td>
															<td>
																<s:if test="lupaOrden==0"><s:text name="lugarParada.labelGridOrigen"></s:text></s:if>
																<s:elseif test="lupaOrden==99"><s:text name="lugarParada.labelGridDestino"></s:text></s:elseif>
																<s:else><s:text name="lugarParada.labelGridParada"></s:text></s:else>
															</td>
															<td><s:property value="lupaMotivoparada"/></td>
														</tr>
													</s:if>
												</s:iterator>
											</table>
										</td>
									</tr>
								</s:if>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:if test="estado=='all'">
					<s:hidden name="fechaInicialProg"></s:hidden>
					<s:hidden name="fechaFinalProg"></s:hidden>
					<s:hidden name="programacionviaje.prviId"></s:hidden>
					<s:hidden name="programacionviaje.solicitudviaje.soviId"></s:hidden>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="Volver" class="buttonSV" onclick="buscar();"/>
								<input type="button" value="Guardar" class="buttonSV" onclick="registrar();"/>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel">
								<s:text name="plsalidap.facultad"></s:text>
							</td>
							<td width="35%">
								<s:iterator value="programacionviaje.solicitudviaje.lisUnidads" id="data">
									<s:property value="unidNombre"/>
									<br>
								</s:iterator>
							</td>
							<td class="leftLabel">
								<s:text name="plsalidap.asignatura"></s:text>
							</td>
							<td>
								<s:property value="lugaresParada.solicitudviaje.materia.mateNombre"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel">
								<s:text name="plsalidap.destino"></s:text>
							</td>
							<td>
								<s:property value="lugaresParada.lupaFinviaje"/>
							</td>
							<td class="leftLabel">
								<s:text name="plsalidap.numestudiantes"></s:text>
							</td>
							<td>
								<s:property value="programacionviaje.solicitudviaje.soviNrointegranteconfirmado"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel">
								<s:text name="plsalidap.docenterespon"></s:text>
							</td>
							<td>
								<s:property value="programacionviaje.solicitudviaje.responsableviaje.rvijNombre"/>
							</td>
							<td class="leftLabel">
								<s:text name="plsalidap.fecha"></s:text>
							</td>
							<td>
								<input type="text" id="fecha" readonly="readonly" class="inputs"/>
								<script>
									var fecha = new Date();
									document.form.fecha.value=fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+fecha.getFullYear();
								</script>
							</td>
						</tr>
						<tr>
							<td class="leftLabel">
								<s:text name="plsalidap.horaentregaauto"></s:text>
							</td>
							<td>
								<s:textfield name="planillasalidapractica.plspHoraentregavehi" id="horaEntrega" cssClass="inputs" readonly="true"></s:textfield>
							</td>
							<td class="leftLabel">
								<s:text name="plsalidap.horasalidauniv"></s:text>
							</td>
							<td>
								<s:textfield name="planillasalidapractica.plspHorasalidauniv" id="horaSalida" cssClass="inputs" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel">
								<s:text name="plsalidap.valorcontratado"></s:text>
							</td>
							<td colspan="3">
								<s:textfield name="planillasalidapractica.plspValorcontratado" id="valorContratado" cssClass="inputs" onkeypress="ValidaSoloNumeros();"></s:textfield>
							</td>
						</tr>
					</table>
					<div id="pestanas">
						<ul>
							<li><a href="#tabs-1">Datos Conductor</a></li>
							<li><a href="#tabs-2">Datos Vehiculo</a></li>
							<li><a href="#tabs-3">Estado Gral Vehiculo</a></li>
						</ul>
						<div id="tabs-1">
<!-- 							<table cellpadding="0" cellspacing="0" border="0" class="display"> -->
<!-- 								<tr> -->
<!-- 									<td> -->
										<jsp:include page="odontograma.jsp" flush="true"/>
<%-- 								<jsp:param value="${idSolicitud.soviId}" name="soviId"/> --%>
<%-- 								<jsp:param value="1" name="posibles_rutas"/>  --%>
<%-- 										</jsp:include> --%>
<!-- 									</td> -->
<!-- 								</tr> -->
<!-- 							</table> -->
						</div>
						<div id="tabs-2">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel">
										<s:text name="vehiculo.tipoVehiculo"></s:text>
									</td>
									<td>
<%-- 										<s:select list="listTipovehiculo" name="planilladatosvehiculo.tipovehiculo.tiveId" listKey="tiveId" listValue="tiveDescripcion" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/> --%>
									</td>
									<td colspan="2">
										<label for="amount"><s:text name="plsalidap.vehi.numPasajeros"></s:text></label>
										<s:textfield name="planilladatosvehiculo.pldvNumeropasajeros" id="amount" readonly="true" cssStyle="border:0; color:#FF0303; font-weight:bold;"></s:textfield>
										<div id="slider-range-min"></div>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.placa"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvPlaca" id="placa" size="30" maxlength="6" cssClass="inputs"></s:textfield>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.modelo"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvModelo" id="modelo" size="30" maxlength="50" cssClass="inputs"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.soat"></s:text>
									</td>
									<td>
										<s:radio name="planilladatosvehiculo.pldvSoat" list="#{'S':'Si','N':'No'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.fechavencimiento"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvFechavsoat" id="datepicker4" cssClass="inputs" readonly="true"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.rcextracontractual"></s:text>
									</td>
									<td>
										<s:radio name="planilladatosvehiculo.pldvRcextra" list="#{'S':'Si','N':'No'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.fechavencimiento"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvFechavrcex" id="datepicker5" cssClass="inputs" readonly="true"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.rcpasajeros"></s:text>
									</td>
									<td>
										<s:radio name="planilladatosvehiculo.pldvRcpasajeros" list="#{'S':'Si','N':'No'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.fechavencimiento"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvFechavrcpa" id="datepicker6" cssClass="inputs" readonly="true"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.revisiontecnico"></s:text>
									</td>
									<td>
										<s:radio name="planilladatosvehiculo.pldvRevisiontcm" list="#{'S':'Si','N':'No'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.fechavencimiento"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvFechavrevisiontcm" id="datepicker7" cssClass="inputs" readonly="true"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.tarjetaoperacion"></s:text>
									</td>
									<td>
										<s:radio name="planilladatosvehiculo.pldvTarjoperacion" list="#{'S':'Si','N':'No'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.fechavencimiento"></s:text>
									</td>
									<td>
										<s:textfield name="planilladatosvehiculo.pldvFechavtarjop" id="datepicker8" cssClass="inputs" readonly="true"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.tipocombustible"></s:text>
									</td>
									<td>
										<s:select list="#{'GASOLINA':'GASOLINA','ACPM':'ACPM','GAS':'GAS'}" name="planilladatosvehiculo.pldvTipocombustible" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.vehi.tarjetapropiedad"></s:text>
									</td>
									<td>
										<s:radio name="planilladatosvehiculo.pldvTarjpropiedad" list="#{'S':'Si','N':'No'}" cssClass="inputs"></s:radio>
									</td>
								</tr>
							</table>
						</div>
						<div id="tabs-3">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="centerLabel" colspan="2">
										<s:text name="plsalidap.estadogrl.parteinterna"></s:text>
									</td>
									<td class="centerLabel" colspan="2">
										<s:text name="plsalidap.estadogrl.parteexterna"></s:text>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.silleteria"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegSilleteria" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.latoneria"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegLatoneria" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.aseo"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegAseo" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.pintura"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegPintura" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.equipocarretera"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegEquipocarretera" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.ventanas"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegVentanas" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.equipoprimerosaux"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegPrimerosauxilios" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.llantas"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegLlantas" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.aspectoscarroceria"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegAspectoscarroceria" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.logotipos"></s:text>
									</td>
									<td>
										<s:radio name="planillaestadogrlvehiculo.plegLogotipos" list="#{'O':'Optimo','B':'Bueno','R':'Regular'}" cssClass="inputs"></s:radio>
									</td>
								</tr>
								<tr>
									<td class="leftLabel" colspan="2">
										<s:text name="plsalidap.estadogrl.razonsocial"></s:text>
									</td>
									<td colspan="2">
										<s:textfield name="planillaestadogrlvehiculo.plegRazonsocial" id="razonsocial" size="50" maxlength="50" cssClass="inputs"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="leftLabel">
										<s:text name="plsalidap.estadogrl.obserdocente"></s:text>
									</td>
									<td colspan="3">
										<s:textarea name="planillaestadogrlvehiculo.plegObservaciondocente" id="observaciones" cssClass="inputs" cols="90"></s:textarea>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="Volver" class="buttonSV" onclick="buscar();"/>
								<input type="button" value="Guardar" class="buttonSV" onclick="registrar();"/>
							</td>
						</tr>
					</table>
				</s:if>
				<s:if test="estado=='selectCalendar'">
					<table cellpadding="0" cellspacing="0" border="1" class="display">
						<thead>
							<tr>
								<th width="10%"><s:text name="calendarioPractica.item"></s:text></th>
								<th width="40%"><s:text name="calendarioPractica.fechaInicio"></s:text></th>
								<th width="40%"><s:text name="calendarioPractica.fechaFinal"></s:text></th>
								<th width="10%"></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listCalendarioPracticaSelect" id="data" status="statCalendar">
								<tr>
									<td align="center" class="text">${statCalendar.index+1}</td>
									<td align="center" class="text"><s:property value="caprFechainiView"/></td>
									<td align="center" class="text"><s:property value="caprFechafinView"/></td>
									<td align="center"><input type="button" value="<s:text name="labelbutton.seleccionar"></s:text>" onclick="selectCalendar('${statCalendar.index}');" class="buttonSV"/></td>
								</tr>
								<tr>
									<td class="leftLabel" colspan="4">
										<a onclick="javascript:desplegarInfo('${statCalendar.index+1}');"><img src="<s:url value='/imagenes/flecha_der.png'/>" alt="Mostrar" width="12" height="12"></a>
										<s:text name="calendarioPractica.procesopractica"></s:text>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<div id="processCalendar_${statCalendar.index+1}" style="overflow:auto;width:auto;height:auto;display:none">
											<s:if test="procesocalendariopracticas!=null&&procesocalendariopracticas.size()>0">
												<table cellpadding="0" cellspacing="0" border="1" class="display">
													<thead>
														<tr>
															<th><s:text name="procesopractica.procesopractica"></s:text></th>
															<th><s:text name="calendarioPractica.fechaInicio"></s:text></th>
															<th><s:text name="calendarioPractica.fechaFinal"></s:text></th>
														</tr>
													</thead> 
													<tbody>
														<s:iterator value="procesocalendariopracticas" id="data" status="statProcessCalendar">
															<tr>
																<td class="text"><s:property value="procesopractica.prprDescripcion"/></td>
																<td class="text"><s:property value="pcprFechainiView"/></td>
																<td class="text"><s:property value="pcprFechafinView"/></td>
															</tr>
														</s:iterator>
													</tbody>
												</table>	
											</s:if>
										</div>
									</td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
			</div>
			<div class="spacer"></div>
			<div id="cargarGoogleMaps"><iframe id="mapaIframe" src=""></iframe></div>
		</s:form>
	</body>
</html>