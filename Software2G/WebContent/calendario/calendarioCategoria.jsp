<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:set name="constantesAgendaProfesional" value="constantesAgendaProfesional"></s:set>
<s:set name="eventoAgendaProfesional" value="eventoAgendaProfesional"></s:set>
<script type="text/javascript" src="<s:url value='/js/%{constantesAgendaProfesional}.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/constantesCalendario/%{eventoAgendaProfesional}.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/constantesAdicionales.js'/>"></script>
<link href="<s:url value='/js/fullcalendar.css'/>" rel="stylesheet" />
<link href="<s:url value='/js/fullcalendar.print.css'/>" rel="stylesheet" media="print" />
<script type="text/javascript" src="<s:url value='/js/lib/moment.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/lib/jquery.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/lib/jquery-ui.js'/>"></script> 
<script type="text/javascript" src="<s:url value='/js/fullcalendar.js'/>"></script>
<link rel="stylesheet" media="all" type="text/css" href="<s:url value='/js/Impromptu._files/screen.css'/>">
<link rel="stylesheet" media="all" type="text/css" href="<s:url value='/js/Impromptu._files/examples.css'/>">
<script type="text/javascript" src="<s:url value='/js/Impromptu._files/jquery-impromptu.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/Impromptu._files/common.js'/>"></script>
<script>
	var txt1 = '<table> '+
				'  <tr> '+
				'	<td>Tipo Documento:</td> '+
				'	<td> '+
				'	  <select id="tipodoc" name="tipodoc"> '+
				'		<option value="CC">CEDULA DE CIUDADANIA</option> '+
				'		<option value="TI">TARJETA DE IDENTIDAD</option> '+
				'		<option value="RC">REGISTRO CIVIL</option> '+
				'		<option value="CE">CEDULA EXTRANJERIA</option> '+
				'		<option value="PS">PASAPORTE</option> '+
				'		<option value="ASI">ADULTO SIN IDENTIFICACION</option> '+
				'		<option value="MSI">MENOR SIN IDENTIFICACION</option> '+
				'	  </select> '+
				'	</td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Nro Documento:</td> '+
				'	<td><input type="text" id="nrodocumento" name="nrodocumento"/></td> '+
				' </tr> '+
				'  <tr> '+
				'	<td>Primer Nombre:</td> '+
				'	<td><input type="text" id="pnombre" name="pnombre"/></td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Segundo Nombre:</td> '+
				'	<td><input type="text" id="snombre" name="snombre"/></td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Primer Apellido:</td> '+
				'	<td><input type="text" id="papellido" name="papellido"/></td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Segundo Apellido:</td> '+
				'	<td><input type="text" id="sapellido" name="sapellido"/></td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Teléfono:</td> '+
				'	<td><input type="text" id="telefono" name="telefono"/></td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Correo Electrónico:</td> '+
				'	<td><input type="text" id="email" name="email"/></td> '+
				'  </tr> '+
				'</table>';
	
	var title_evento = '';
	var start_evento = '';
	var end_evento = '';
	var url = '';
	var fondo_evento = ''; 
	$(document).ready(function(){
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: new Date(), 
			selectable: paca_selectable,
			selectHelper: true,
			select: function(start, end) {
				txt = txt1+'<input type="hidden" id="start" name="start" value="'+start+'"/><input type="hidden" id="end" name="end" value="'+end+'"/>';
				$.prompt(txt,{callback: mycallbackform, buttons: { Cancelar:0, Registrar:1}});
			},
			editable: paca_editable,
			events: eventos
		});
	});

	function mycallbackform(v,m,f){
		if(v==0||v==undefined)
			return false;
		else if(v==1){
			var dateStart = new Date(parseInt ( f.start , 10 ));
			start_evento = dateStart.toISOString();
			var dateEnd = new Date(parseInt ( f.end , 10 ));
			end_evento = dateEnd.toISOString();
			nameCompleto= f.pnombre+' '+f.snombre+' '+f.papellido+' '+f.sapellido;
			title_evento = f.nrodocumento+' '+f.tipodoc+' '+nameCompleto;
			fondo_evento = document.getElementById("fondo").value;
			title_evento_param = f.nrodocumento.trim()+'%20'+f.tipodoc+'%20'+f.pnombre.trim()+'%20'+f.snombre.trim()+'%20'+f.papellido.trim()+'%20'+f.sapellido.trim();
			fondo_evento_param = fondo_evento.replace("#", "%23");
			nrodocumento = f.nrodocumento.trim();
			tipodoc = f.tipodoc.trim();
			pnombre = f.pnombre.trim();
			snombre = f.snombre.trim();
			papellido = f.papellido.trim(); 
			sapellido = f.sapellido.trim();
			telefono = f.telefono.trim();
			email = f.email.replace('@', '%40');
			//'&url='+url_param+
			$("#divEventos").load('crearEventoCalendarioCate.action?start='+start_evento+'&end='+end_evento+'&backgroundColor='+fondo_evento_param+'&title='+title_evento_param+'&pnombre='+pnombre+'&snombre='+snombre+'&papellido='+papellido+'&sapellido='+sapellido+'&telefono='+telefono+'&email='+email+'&nrodocumento='+nrodocumento+'&tipodoc='+tipodoc);
			setTimeout(function () {geteventDataNew();}, 1200);
		}
	}

	function geteventDataNew(){
		var idEventoCreado = document.getElementById('idEventoCreado').value;
		url = 'calendarioCategoria.action?estado=legalizarcompromiso&funcPosicionado=Calendario/Informacion%20Cita&idEvento='+idEventoCreado;
		var eventData;
			if (title_evento) {
				eventData = {
					title: title_evento,
					start: start_evento,
					end: end_evento,
					url: url,
					backgroundColor: fondo_evento 
				};
				$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			}
			$('#calendar').fullCalendar('unselect');
	}
	function evento(){
		$.prompt(txt,{callback: mycallbackform, buttons: { Cancelar:0, Registrar:1}});
	}

	function cambioCategoria(){
		var background = document.getElementById('fondo').value;
		background = background.replace("#", "%23");
		document.form.action="calendarioCategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&background="+background;
		document.form.submit();
	} 
	
	function volver(){
		document.form.action="calendarioCategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>&funcPosicionado=Calendario/Prueba Calendario";
		document.form.submit();
	}
	
	function continuar(){
		var accionRealizar = document.getElementById('accionRealizar').value;
		if(accionRealizar == 'LS'){
			var evenId = document.getElementById('evenId').value;
			var partId = document.getElementById('partId').value;
			document.form.action="venta.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>&partId="+partId+"&idEvento="+evenId+"&funcPosicionado=NIIF::>Venta";
		}else if(accionRealizar == 'CC'){
			document.form.action="calendarioCategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoLegalizarCompromiso%>";
		}else if(accionRealizar == 'NA'){
			document.form.action="calendarioCategoria.action?estado=<%=ConstantesAplicativo.constanteEstadoLegalizarCompromiso%>";
		}
		document.form.submit();
	}
	
</script>
<style>
/* 	body { */
/* 		margin: 0; */
/* 		padding: 0; */
/* 		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif; */
/* 		font-size: 14px; */
/* 	} */
</style>
</head>
<body id="dt_example">
	<s:form id="form">
		<s:hidden name="funcPosicionado"></s:hidden>
		<div id="demo">
			<s:if test="estado=='all'">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td align="left" colspan="2"><div id='divEventos'></div></td></tr>
					<tr>
						<td class="leftLabel"><s:text name="titulo.portafolioscategoria"></s:text></td>
						<td align="left">
							<s:select list="listPortafolioCategoria" name="agendaCategoria.portafolioCategoria.pocaBackgroundcolor" id="fondo" listKey="pocaBackgroundcolor" listValue="pocaReferencia" headerKey="" headerValue=".::Todos los Compromiso::." cssClass="inputs" onchange="cambioCategoria();"/>
						</td>
					</tr>
					<s:if test="agendaCategoria.portafolioCategoria.pocaId>0">
						<tr><td align="left" colspan="2">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:text name="portafolioscategoria.imagen"></s:text></td>
									<td colspan="3"><img id="img_poca" alt="FOTO" src="<%=request.getContextPath()%><s:property value="agendaCategoria.portafolioCategoria.archivo.rutaAlterna"/>" width="150" height="100"></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="titulo.portafolioscategoria"></s:text></td>
									<td><s:property value="agendaCategoria.portafolioCategoria.pocaReferencia"/></td>
									<td class="leftLabel"><s:text name="profesional.coloragenda"></s:text></td>
									<td><table border="0" width="70%"><tr> 
										<td bgcolor="<s:property value="agendaCategoria.portafolioCategoria.pocaBackgroundcolor"/>" width="15%"><s:property value="agendaCategoria.portafolioCategoria.pocaBackgroundcolor"/></td><td></td>
									</tr></table></td>
								</tr>
							</table>
						</td></tr>
					</s:if>
					<tr><td align="left" colspan="2"><div id='calendar'></div></td></tr> 
				</table>
			</s:if>
			<s:elseif test="estado=='operacioncita'">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<s:hidden name="evento.evenId" id="evenId"></s:hidden>
					<s:hidden name="participante.partId" id="partId"></s:hidden>
					<s:hidden name="participante.partDocumento" id="documentoPers"></s:hidden>
					<s:hidden name="participante.partTipodocumento" id="abreviaturaTidoc"></s:hidden>
					<tr><td align="left">
						<h1><s:text name="portafolioscategoria.informacioncompromiso"></s:text></h1>
					</td></tr>
					<tr>
						<td  align="right">
							<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							<input type="button" value="<s:text name="labelbutton.continuar"></s:text>" onclick="continuar();" class="buttonSV"/>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="display" align="left">
					<tr>
						<td class="leftLabel" colspan="4"><s:text name="ventas.datoscliente"></s:text></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="informacioncita.nombrepaciente"></s:text></td>
						<td colspan="3" align="left"><s:property value="participante.nombreCompleto"/></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="informacioncita.telefonopaciente"></s:text></td>
						<td align="left"><s:property value="participante.partTelefono"/></td>
						<td class="leftLabel"><s:text name="informacioncita.correoelectronicopaciente"></s:text></td>
						<td align="left"><s:property value="participante.partEmail"/></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="informacioncita.fechaatencion"></s:text></td>
						<td align="left"><s:property value="evento.evenStartViewFecha"/></td>
						<td class="leftLabel"><s:text name="informacioncita.horaatencion"></s:text></td>
						<td align="left"><s:property value="evento.evenStartViewHora"/></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="informacioncita.accionrealizar"></s:text></td>
						<td colspan="3"  align="left">
							<s:select list="#{'LS':'Legalizar Servicio','CC':'Cancelar Compromiso'}" name="evento.accion" id="accionRealizar" headerKey="NA" headerValue=".::Selecione::." cssClass="inputs"/>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<td class="right" align="right">
							<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							<input type="button" value="<s:text name="labelbutton.continuar"></s:text>" onclick="continuar();" class="buttonSV"/>
						</td>
					</tr>
				</table>
			</s:elseif>
		</div>
	</s:form>
</body>
</html>