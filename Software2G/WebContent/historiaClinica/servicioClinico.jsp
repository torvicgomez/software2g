<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				
				$("#rxUso").click(function() {
					var divRxUso = document.getElementById("divRxUso");
					if($('input:checkbox[id=rxUso]:nth(0)').is(':checked')) {
						divRxUso.style.display = 'block';
			    	}else{
			    		divRxUso.style.display = 'none';
			    	}
		    	});
			
				$("#avsc").click(function() {
					var divAVSC = document.getElementById("divAVSC");
					if($('input:checkbox[id=avsc]:nth(0)').is(':checked')) {
						divAVSC.style.display = 'block';
			    	}else{
			    		divAVSC.style.display = 'none';
			    	}
		    	});
		    	
		    	$("#coverTest").click(function() {
					var divCoverTest = document.getElementById("divCoverTest");
					if($('input:checkbox[id=coverTest]:nth(0)').is(':checked')) {
						divCoverTest.style.display = 'block';
			    	}else{
			    		divCoverTest.style.display = 'none';
			    	}
		    	});
		    	
		    	$("#examenExterno").click(function() {
					var divExamenExterno = document.getElementById("divExamenExterno");
					if($('input:checkbox[id=examenExterno]:nth(0)').is(':checked')) {
						divExamenExterno.style.display = 'block';
			    	}else{
			    		divExamenExterno.style.display = 'none';
			    	}
		    	});
		    	
		    	$("#oftalmoscopia").click(function() {
					var divOftalmoscopia = document.getElementById("divOftalmoscopia");
					if($('input:checkbox[id=oftalmoscopia]:nth(0)').is(':checked')) {
						divOftalmoscopia.style.display = 'block';
			    	}else{
			    		divOftalmoscopia.style.display = 'none';
			    	}
		    	});
		    	
		    	$("#keratometria").click(function() {
					var divKeratometria = document.getElementById("divKeratometria");
					if($('input:checkbox[id=keratometria]:nth(0)').is(':checked')) {
						divKeratometria.style.display = 'block';
			    	}else{
			    		divKeratometria.style.display = 'none';
			    	}
		    	});
		    	
		    	$("#retinoscopia").click(function() {
					var divRetinoscopia = document.getElementById("divRetinoscopia");
					if($('input:checkbox[id=retinoscopia]:nth(0)').is(':checked')) {
						divRetinoscopia.style.display = 'block';
			    	}else{
			    		divRetinoscopia.style.display = 'none';
			    	}
		    	});
		    	
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
				
				
			} );
			
			$(function() {
				$("#pestanas").tabs();
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
					dateFormat: 'yy-mm-dd',
					firstDay: 1,
					isRTL: false,
					showMonthAfterYear: false,
					yearSuffix: ''};
					$.datepicker.setDefaults($.datepicker.regional['es']);
				}
			);
			
		
			function buscar(){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoSearch%>";
				document.form.submit();
			}
			
			function resumen(param){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&idSol="+param;
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function continuar(){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function agregarGrilla(tipoAdd){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoAddGrid%>&tipo="+tipoAdd+"#tabs-5";
				document.form.submit();
				
			}
			
			function eliminarGrilla(param, tipoDel){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoDeleteGrid%>&posList="+param+"&tipo="+tipoDel+"#tabs-5";
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
					<tr>
						<td>
							<h1><s:text name="atencioservicio.titulo"></s:text></h1>
						</td>
					</tr>
					<s:if test="estado=='all'">
						<tr><td class="right">
							<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
						</td></tr>
					</s:if>
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'||estado=='addGrid'||estado=='delGrid'">
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
					<s:elseif test="estado=='alltiposervicio'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.continuar"></s:text>" onclick="continuar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<s:set name="estadoCheck" value="estado"></s:set>
						<s:hidden name="profesional.profId" id="profId"></s:hidden>
						<s:hidden name="profesional.profEspecialidad" id="profEspecialidad"></s:hidden>
						<s:hidden name="persona.idPers"></s:hidden>
						<s:hidden name="persona.existePaciente"></s:hidden>
						<s:hidden name="paciente.paciId"></s:hidden>
						<td class="leftLabel" colspan="4"><s:text name="profesionalsalud.datosprofesional"></s:text></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
						<td align="left">
							<s:property value="profesional.persona.nombreCompleto"/>
						</td>
						<td class="leftLabel" width="130"><s:text name="profesionalsalud.profesion"></s:text></td>
						<td align="left">
							<s:property value="profesional.profEspecialidadView"/>
						</td>
					</tr>
				</table> 
				<s:if test="estado=='alltiposervicio'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="tiposervicio.tiposervicio"></s:text></td>
							<td align="left">
								<s:select list="listTipoServicio" name="tipoServicio.tiseId" listKey="tiseId" listValue="tiseNombre" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text></td>
							<td>
								<s:textfield name="persona.documentoPers" size="20" maxlength="15" cssClass="inputs"></s:textfield><%--nombreTidoc --%>
								<s:select list="listTipoDoc" name="persona.tipodocumento.abreviaturaTidoc" listKey="abreviaturaTidoc" listValue="abreviaturaTidoc" headerKey="" headerValue=".::Seleccione::." cssClass="inputs"/>	
							</td>
						</tr>
					</table> 
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.continuar"></s:text>" onclick="continuar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:if>
				<s:elseif test="estado=='all'||estado=='edit'||estado=='save'||estado=='addGrid'||estado=='delGrid'">
					<div id="pestanas">
						<ul>
							<li><a href="#tabs-0"><s:text name="atencioservicio.datospersonales"></s:text></a></li>
							<li><a href="#tabs-0-1"><s:text name="atencioservicio.anamnesis"></s:text></a></li>
							<s:if test="profesional.profEspecialidad==\"1\"">
								<li><a href="#tabs-1"><s:text name="atencioservicio.odontogramapro"></s:text></a></li>
								<li><a href="#tabs-2"><s:text name="atencioservicio.costotratamiento"></s:text></a></li>	
							</s:if>
							<s:elseif test="profesional.profEspecialidad==\"2\"">
								<li><a href="#tabs-4"><s:text name="atencioservicio.examenesopt"></s:text></a></li>
							</s:elseif>
							<li><a href="#tabs-5"><s:text name="atencioservicio.diagnosticos"></s:text></a></li>
						</ul>
						<div id="tabs-0">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text></td>
									<td>
										<s:if test="persona.existePaciente==\"S\"">
											<s:hidden name="persona.tipodocumento.idTidoc"></s:hidden>
											<s:hidden name="persona.documentoPers"></s:hidden>
											<s:property value="persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/>
										</s:if>
										<s:else>
											<s:textfield name="persona.documentoPers" size="20" maxlength="15" cssClass="inputs"></s:textfield><%--nombreTidoc --%>
											<s:select list="listTipoDoc" name="persona.tipodocumento.idTidoc" listKey="idTidoc" listValue="abreviaturaTidoc" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/>	
										</s:else>
									</td>
								</tr>
								
								<tr>
									<td class="leftLabel"><s:text name="personal.fechaexpedicion"></s:text></td>
									<td><s:textfield name="persona.fechaexpdocPers" id="fechaexpdocPers" size="15" maxlength="10" cssClass="inputs" placeholder="aaaa-mm-dd"></s:textfield></td>
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
									<td><s:select list="#{'F':'Femenino','M':'Masculino'}" name="persona.sexoPers" headerKey="" headerValue=".::Seleccione::." cssClass="inputs" /></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.estadocivil"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:select list="listEstadoCivil" name="persona.estadocivilPers" headerKey="" headerValue=".::Seleccione::." cssClass="inputs"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.fechanacimiento"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.fechanacimientoPers" id="fechanacimientoPers" size="15" maxlength="10" cssClass="inputs" placeholder="aaaa-mm-dd"></s:textfield></td>
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
															<s:select list="listMunicipio" name="persona.municipio.mcpoId" id="mcpoId" listKey="mcpoId" listValue="nommunicipio" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/>
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
								<tr>
									<td class="leftLabel"><s:text name="personal.ocupacion"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="paciente.paciOcupacion" size="35" maxlength="100" cssClass="inputs"></s:textfield></td>
								</tr>
							</table>
						</div>
						<div id="tabs-0-1">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:text name="servicioanamnesis.finalidad"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:select list="listFinalidad" name="finalidad.finaId" listKey="finaId" listValue="finaFinalidad" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="servicioanamnesis.motivo"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:select list="listMotivo" name="motivo.motiId" listKey="motiId" listValue="motiMotivo" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="servicioanamnesis.seguridadsocial"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:select list="listSeguridadSocial" name="seguridadSocial.seguId" listKey="seguId" listValue="seguNombre" headerKey="-1" headerValue=".::Seleccione::." cssClass="inputs"/></td>
								</tr>
								<tr>
									<td colspan="2">
										<jsp:include page="anamnesis.jsp" flush="true">
											<jsp:param value="${estadoCheck}" name="check"/>
										</jsp:include>
									</td>
								</tr>
							</table>
						</div>
						<s:if test="profesional.profEspecialidad==\"1\"">
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
						</s:if>
						<s:if test="profesional.profEspecialidad==\"1\"">
							<div id="tabs-2">
								<table cellpadding="0" cellspacing="0" border="0" class="display">
									<tr>
										<td class="leftLabel">
											Construccion!!!!
										</td>
									</tr>
								</table>
							</div>
						</s:if>
						<s:if test="profesional.profEspecialidad==\"2\"">
							<div id="tabs-4">
								<table cellpadding="0" cellspacing="0" border="0" class="display">
									<tr>
										<td>
											<s:iterator value="listExamenEspecialidad" id="data">
												<jsp:include page="${data.exesPaginajsp}" flush="true">
													<jsp:param value="${estadoCheck}" name="check"/>
												</jsp:include>
											</s:iterator>
										</td>
									</tr>
								</table>
							</div>
						</s:if>
						<div id="tabs-5">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td><h1><s:text name="atencioservicio.diagnosticos"></s:text></h1></td>
								</tr>
								<tr> 
									<td>
										<jsp:include page="diagnosticoGrid.jsp" flush="true"/>
									</td>
								</tr>
								<tr>
									<td><h1><s:text name="atencioservicio.medicamentos"></s:text></h1></td>
								</tr>
								<tr>
									<td>
										<jsp:include page="medicamentos.jsp" flush="true"/>
									</td>
								</tr>
								<s:if test="profesional.profEspecialidad==\"2\"">
									<tr>
										<td><h1><s:text name="atencioservicio.elementos"></s:text></h1></td>
									</tr>
									<tr>
										<td>
											<jsp:include page="elementos.jsp" flush="true"/>
										</td>
									</tr>
								</s:if>
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
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>