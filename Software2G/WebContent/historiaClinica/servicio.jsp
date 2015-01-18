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
			$('#servicio').dataTable( { 
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
		document.form.action="servicio.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
		document.form.submit();
	}
	
	function atenderServicio(param){
		document.form.action="servicio.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>&id="+param;
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
					<s:if test="estado=='add'||estado=='edit'||estado=='save'">
						<tr><td><h1><strong><s:text name="titulo.servicioclinicoopt"></s:text></strong></h1></td></tr>
					</s:if>
					<s:else>
						<tr><td><h1><strong><s:text name="titulo.servicioclinico"></s:text></strong></h1></td></tr>
					</s:else>
					
<%-- 					<s:if test="estado=='all'"> --%>
<!-- 						<tr><td class="css_right"> -->
<%-- 							<input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregar();" class="buttonSV"/> --%>
<!-- 						</td></tr> -->
<%-- 					</s:if> --%>
					<s:if test="estado=='add'||estado=='edit'||estado=='save'">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</s:if>
					<s:elseif test="estado=='abstract'">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<s:if test="estado==null||estado=='all'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="servicio">
						<thead>
							<tr>
								<th align="left"  width="20%"><s:text name="columna.servicio"></s:text></th>
								<th align="left"  width="20%"><s:text name="servicioclinico.nrohistoriaclinica"></s:text></th>
								<th align="left"  width="60%"><s:text name="servicioclinico.nombrepaciente"></s:text></th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="listPersona" id="data">
							<tr>
								<td width="20%"><a onclick="javascript:atenderServicio('<s:property value="idPers"/>');">Atender Servicio</a></td>
								<td width="20%"><s:property value="idPers"/>-<s:property value="documentoPers"/></td>
								<td width="60%"><s:property value="nombreCompleto"/></td>
							</tr>
						</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:if test="persona.idPers>0">
						<tr>
							<td colspan="2">
							<table align="center">
								<tr>
									<td align="center"><s:text name="servicioclinico.nrohistoriaclinica1"></s:text>&nbsp;<s:property value="persona.nroHistoriaClinica"/></td>
									<td align="center"><s:text name="personal.numerodocumento"></s:text>&nbsp;<s:property value="persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><h1><strong><s:property value="persona.nombreCompleto"/></strong></h1></td>
								</tr> 
								<tr>
									<td align="center"><s:text name="personal.fechanacimiento"></s:text>&nbsp;<s:property value="persona.fechanacimientoPers"/></td>
									<td align="center"><s:text name="servicioclinico.edadpaciente"></s:text>&nbsp;<s:property value="persona.edad"/></td>
								</tr>
								<tr>
									<td align="center"><s:text name="personal.sexo"></s:text>&nbsp;<s:if test="persona.sexoPers==\"M\"">Masculino</s:if><s:else>Femenino</s:else> </td>
									<td align="center"><s:text name="personal.estadocivil"></s:text>&nbsp;<s:property value="persona.estadocivilPers"/></td>
								</tr>
							</table>
							</td>
						</tr>
						</s:if>
						<tr>
							<td class="leftLabel"><s:text name="servicioclinico.fechahoraservicio"></s:text></td>
							<td><s:property value="fechaHoraServicioSystem"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioclinico.finalidad"></s:text></td>
							<td><s:select list="listFinalidad" name="finalidad.helpView" listKey="listKey" listValue="codfinalidad" headerKey="0" headerValue=".::Seleccione::." cssClass="inputs"></s:select> </td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioclinico.motivo"></s:text></td>
							<td><s:select list="listMotivo" name="motivo.helpView" listKey="listKey" listValue="codmotivo" headerKey="0" headerValue=".::Seleccione::." cssClass="inputs"></s:select> </td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioclinico.seguridadsocial"></s:text></td>
							<td><s:select list="listSeguridadSocial" name="seguridadSocial.idSeguridad" listKey="idSeguridad" listValue="nomsegur" headerKey="0" headerValue=".::Seleccione::." cssClass="inputs"></s:select> </td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioclinico.anamnesis"></s:text></td>
							<td><s:textarea name="anamnesis.anamnesis" rows="5" cols="70"></s:textarea></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioclinico.fechahoraservicio"></s:text></td>
							<td>
								<jsp:include page="utilExamenesConsulta.jsp" flush="true"> 
									<jsp:param value="1" name="idInstitucion"/>
									<jsp:param value="2" name="idEspecialidad"/>
								</jsp:include>
							</td>
						</tr> 
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
