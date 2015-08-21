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
				$('#agendaCategoria').dataTable( {
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

			function agregar(){
				document.form.action="agendacategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="agendacategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="agendacategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="agendacategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="agendacategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
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
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="agendaCategoria">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="portafolioscategoria.imagen"></s:text></th>
								<th><s:text name="titulo.portafolioscategoria"></s:text></th>
								<th><s:text name="agendamedica.fechainicial"></s:text></th>
								<th><s:text name="agendamedica.fechafinal"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listAgendaCategoria" id="data">
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
									<td><img id="img_poca" alt="FOTO" src="<%=request.getContextPath()%><s:property value="portafolioCategoria.archivo.rutaAlterna"/>" width="150" height="100"></td>
									<td><s:property value="portafolioCategoria.pocaReferencia"/></td>
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
						<s:hidden name="agendaCategoria.agenId" id="agenId"></s:hidden>
<%-- 						<s:hidden name="agendaCategoria.portafolioCategoria.pocaId" id="pocaId"></s:hidden> --%>
						<tr>
							<td class="leftLabel"><s:text name="titulo.portafolioscategoria"></s:text></td>
							<td colspan="3">
								<s:select list="listPortafolioCategoria" name="agendaCategoria.portafolioCategoria.pocaId" listKey="pocaId" listValue="pocaReferencia" headerKey="-1" headerValue=".::Seleccion::." cssClass="inputs"/>
							</td>
						</tr>		
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.fechainicial"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenFechaini" id="agenFechaini" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.fechafinal"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenFechafin" id="agenFechafin" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.horainici"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenMintime" id="agenMintime" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.horafin"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenMaxtime" id="agenMaxtime" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.duracion"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenDuracionevento" id="agenDuracionevento" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.scrolltime"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenScrolltime" id="agenScrolltime" size="10" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.alldayslot"></s:text></td>
							<td>
								<s:select list="#{'1':'ACTIVO','0':'INACTIVO'}" name="agendaCategoria.agenAlldayslot" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"/>
							</td>
							<td class="leftLabel"><s:text name="agendamedica.alldaytext"></s:text></td>
							<td>
								<s:textfield name="agendaCategoria.agenAlldaytext" id="agenAlldaytext" size="30" maxlength="30" cssClass="inputs"></s:textfield>
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
							<td class="leftLabel"><s:text name="titulo.portafolioscategoria"></s:text></td>
							<td colspan="3"><s:property value="agendaCategoria.portafolioCategoria.pocaReferencia"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="portafolioscategoria.imagen"></s:text></td>
							<td colspan="3">
								<img id="img_poca" alt="FOTO" src="<%=request.getContextPath()%><s:property value="agendaCategoria.portafolioCategoria.archivo.rutaAlterna"/>" width="150" height="100">
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.fechainicial"></s:text></td>
							<td><s:property value="agendaCategoria.agenFechaini"/></td>
							<td class="leftLabel"><s:text name="agendamedica.fechafinal"></s:text></td>
							<td><s:property value="agendaCategoria.agenFechafin"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.horainici"></s:text></td>
							<td><s:property value="agendaCategoria.agenMintime"/></td>
							<td class="leftLabel"><s:text name="agendamedica.horafin"></s:text></td>
							<td><s:property value="agendaCategoria.agenMaxtime"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.duracion"></s:text></td>
							<td><s:property value="agendaCategoria.agenDuracionevento"/></td>
							<td class="leftLabel"><s:text name="agendamedica.scrolltime"></s:text></td>
							<td><s:property value="agendaCategoria.agenScrolltime"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="agendamedica.alldayslot"></s:text></td>
							<td><s:if test="agendaCategoria.agenAlldayslot==\"1\"">ACTIVO</s:if><s:else>INACTIVO</s:else></td>
							<td class="leftLabel"><s:text name="agendamedica.alldaytext"></s:text></td>
							<td><s:property value="agendaCategoria.agenAlldaytext"/></td>
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
