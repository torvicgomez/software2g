<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$("#selectPais").change(function(event){
		            var id = $("#selectPais").find(':selected').val();
		            if(id>0){
		            	$("#viewSelectDpto").show("block");
		            	$("#viewSelectMcpo").show("block");
		            }else{
		            	$("#viewSelectDpto").hide(1000);
		            	$("#viewSelectMcpo").hide(1000);
		            }
		        });
		        
		        $("#selectDpto").change(function(event){
		            var id = $("#selectDpto").find(':selected').val();
		            $("#viewSelectMcpo").load('loadMunicipios.action?personaVO.municipio.departamento.dptoId='+id);
		        });
		        
				$( "#fechaexpdocPers" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#fechanacimientoPers" ).datepicker({
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
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<td>
							<h1><s:text name="atencioservicio.titulo"></s:text></h1>
						</td>
					</tr>
				</table>
				<s:if test="estado=='all'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<s:hidden name="profesional.profId" id="profId"></s:hidden>
							<td class="leftLabel" colspan="4"><s:text name="profesionalsalud.datosprofesional"></s:text></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
							<td align="left">
								<s:property value="profesional.persona.nombreCompleto"/>
							</td>
							<td class="leftLabel" width="130"><s:text name="profesionalsalud.profesion"></s:text></td>
							<td align="left">
								<s:property value="profesional.profEspecialidad"/>
							</td>
						</tr>
					</table> 
					<div id="pestanas">
						<ul>
							<li><a href="#tabs-0"><s:text name="atencioservicio.datospersonales"></s:text></a></li>
							<li><a href="#tabs-0-1"><s:text name="atencioservicio.anamnesis"></s:text></a></li>
							<li><a href="#tabs-1"><s:text name="atencioservicio.odontogramapro"></s:text></a></li>
							<li><a href="#tabs-2"><s:text name="atencioservicio.costotratamiento"></s:text></a></li>
							<li><a href="#tabs-3">Estado Gral Vehiculo</a></li>
						</ul>
						<div id="tabs-0">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								
								<tr>
									<td class="leftLabel"><s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text></td>
									<td>
										<s:if test="persona.existePaciente==\"S\"">
											<s:hidden name="persona.tipodocumento.idTidoc"></s:hidden>
											<s:property value="persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/>
										</s:if>
										<s:else>
											<s:textfield name="persona.documentoPers" size="20" maxlength="15" cssClass="inputs"></s:textfield><%--nombreTidoc --%>
											<s:select list="listTipoDoc" name="persona.tipodocumento.idTidoc" listKey="idTidoc" listValue="abreviaturaTidoc" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/>	
										</s:else>
									</td>
								</tr>
								
								<tr>
									<td class="leftLabel"><s:text name="personal.fechaexpedicion"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.fechaexpdocPers" id="fechaexpdocPers" size="15" maxlength="10" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.primernombre"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.pnombrePers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.segundonombre"></s:text></td>
									<td><s:textfield name="persona.snombrePers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.primerapellido"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.papellidoPers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.segundoapellido"></s:text></td>
									<td><s:textfield name="persona.sapellidoPers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.sexo"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:select list="#{'F':'Femenino','M':'Masculino'}" name="persona.sexoPers" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs" /></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.estadocivil"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:select list="listEstadoCivil" name="persona.estadocivilPers" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.fechanacimiento"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.fechanacimientoPers" id="fechanacimientoPers" size="15" maxlength="10" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.telefono"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.telefonoPers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.email"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.emailPers" size="35" maxlength="80" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.ubicaciongeo"></s:text><s:text name="campo.requerido"></s:text></td>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" class="display">
											<tr>
												<td align="left"><s:select list="listPais" name="persona.municipio.departamento.pais.paisId" id="selectPais" listKey="paisId" listValue="nompais" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/></td>
												<td align="left">
													<s:if test="persona.municipio.departamento.pais.paisId>0">
														<div id="viewSelectDpto" style="overflow:auto;width:auto;height:auto;display:block">
													</s:if>
													<s:else>
														<div id="viewSelectDpto" style="overflow:auto;width:auto;height:auto;display:none">
													</s:else>
														<s:select list="listDepartamento" name="persona.municipio.departamento.dptoId" id="selectDpto" listKey="dptoId" listValue="nomdpto" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/>
													</div>
												</td>
												<td align="left">
													<div id="viewSelectMcpo">
														<s:if test="listMunicipio!=null&&listMunicipio.size>0">
															<s:select list="listMunicipio" name="persona.municipio.mcpoId" listKey="mcpoId" listValue="nommunicipio" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/>
														</s:if>
													</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.direccion"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.direccionPers" size="35" maxlength="100" cssClass="inputs"></s:textfield></td>
								</tr>
							</table>
						</div>
						<div id="tabs-0-1">
							Construccion!!!
						</div>
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
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>