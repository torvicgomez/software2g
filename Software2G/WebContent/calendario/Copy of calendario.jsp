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
				'	<td>Tel�fono:</td> '+
				'	<td><input type="text" id="telefono" name="telefono"/></td> '+
				'  </tr> '+
				'  <tr> '+
				'	<td>Correo Electr�nico:</td> '+
				'	<td><input type="text" id="email" name="email"/></td> '+
				'  </tr> '+
				'</table>';
	
	var title_evento = '';
	var start_evento = '';
	var end_evento = '';
// 	var eventos = [];
// 	var eventos = [
// 	{
// 	  id: 12,
// 	  title: '75106199 CC',
// 	  start: '2015-01-26T08:00:00.000Z',
// 	  end: '2015-01-26T08:30:00.000Z',
// 	  url: 'rol.action?estado=all',
// 	  backgroundColor: '#DB7F7F'
// 	}];
// 	var eventos = [
// 				{
// 					title: 'All Day Event',
// 					start: '2014-06-01'
// 				},
// 				{
// 					title: 'Long Event',
// 					start: '2014-06-07',
// 					end: '2014-06-10'
// 				},
// 				{
// 					id: 999,
// 					title: 'Repeating Event',
// 					start: '2014-06-09T16:00:00'
// 				},
// 				{
// 					id: 999,
// 					title: 'Repeating Event',
// 					start: '2014-06-16T16:00:00'
// 				},
// 				{
// 					title: 'Meeting',
// 					start: '2014-06-12T10:30:00',
// 					end: '2014-06-12T12:30:00',
// 					className: 'fc-event-pediatria'
// 				},
// 				{
// 					title: 'Lunch',
// 					start: '2014-06-12T12:00:00',
// 					backgroundColor: '#ff0000'
// 				},
// 				{
// 					title: 'Birthday Party',
// 					start: '2014-06-13T07:00:00'
// 				},
// 				{
// 					title: 'Click for Google',
// 					url: 'http://google.com/',
// 					start: '2014-06-28'
// 				}
// 			]; 
	$(document).ready(function(){
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: new Date(), 
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				//alert('start:['+start+']');
				//alert('end:['+end+']');
				txt = txt1+'<input type="hidden" id="start" name="start" value="'+start+'"/><input type="hidden" id="end" name="end" value="'+end+'"/>';
				$.prompt(txt,{callback: mycallbackform, buttons: { Cancelar:0, Registrar:1}});
				//alert('title_evento:['+title_evento+']');
				//var title = title_evento;
				//var title = prompt(txt);
				//start_evento = start;
				//end_evento = end;
				//var eventData;
				//if (title) {
				//	eventData = {
				//		title: title,
				//		start: start,
				//		end: end
				//	};
				//	$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				//}
				//$('#calendar').fullCalendar('unselect');
			},
			editable: true,
			events: eventos
		});
		
	});

	

	function mycallbackform(v,m,f){
		//alert('v:['+v+']');
		//alert('m:['+m+']');
		if(v==0||v==undefined)
			return false;
		else if(v==1){
			
			//$('#calendar').fullCalendar('select', start, end);
			var dateStart = new Date(parseInt ( f.start , 10 ));
			start_evento = dateStart.toISOString();
			var dateEnd = new Date(parseInt ( f.end , 10 ));
			end_evento = dateEnd.toISOString();
			nameCompleto= f.pnombre+' '+f.snombre+' '+f.papellido+' '+f.sapellido;
			title_evento = f.nrodocumento+' '+f.tipodoc+' '+nameCompleto;
			fondo_evento = document.getElementById("fondo").value;
			url = 'rol.action?estado=all&funcPosicionado=Administracion Portal::>Roles';
			
			url_param = 'rol.action?estado%3Dall%26funcPosicionado%3DAdministracion%20Portal%3A%3A>Roles';
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
			
// 			alert('email:['+email+']');
// 			alert('nrodocumento:['+nrodocumento+']');
// 			alert('tipodoc:['+tipodoc+']');
			
			$("#divEventos").load('crearEventoCalendario.action?start='+start_evento+'&end='+end_evento+'&url='+url_param+'&backgroundColor='+fondo_evento_param+'&title='+title_evento_param+'&pnombre='+pnombre+'&snombre='+snombre+'&papellido='+papellido+'&sapellido='+sapellido+'&telefono='+telefono+'&email='+email+'&nrodocumento='+nrodocumento+'&tipodoc='+tipodoc);
			
			//alert('dateStart: ['+dateStrat+']');
			//alert('formato fecha ISO: ['++']');
			//start_evento = '2014-06-12T10:20:00';
			//end_evento = '2014-06-12T10:40:00';
			//alert('f.alertName: ['+f.alertName+']');
			//alert('f.start: ['+f.start+']');
			//alert('f.end: ['+f.end+']');
			//alert('title8_evento:['+title_evento+']');
			//$.prompt(v +' ' + f.alertName);
				var eventData;
				if (title_evento) {
					//alert('entra esta parte!!!!');
					eventData = {
						title: title_evento,
						start: start_evento,
						end: end_evento,
						url: url,
						backgroundColor: fondo_evento 
					};
					//alert('eventData:['+eventData+']');
					//alert('eventData:['+eventData.title+']');
					//alert('eventData:['+eventData.start+']');
					//alert('eventData:['+eventData.end+']');
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			//		renderEvent(eventData, true);
				}
			//	alert('sale!!!!!!');
				$('#calendar').fullCalendar('unselect');

			
		}
	}

	function evento(){
		$.prompt(txt,{callback: mycallbackform, buttons: { Cancelar:0, Registrar:1}});
	}

	function cambioProfesional(){
		var background = document.getElementById('fondo').value;
		background = background.replace("#", "%23");
		document.form.action="calendario.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&background="+background;
		document.form.submit();
	} 
</script>
<style>
	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}
/* 	#calendar { */
/* 		width: 900px; */
/* 		margin: 40px auto; */
/* 	} */
</style>
<!-- #calendar { -->
<!-- 		width: 900px; -->
<!-- 		margin: 40px auto; -->
<!-- 	} -->
</head>
<body>
	<s:form id="form">
		<s:hidden name="funcPosicionado"></s:hidden>
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr><td align="left"><div id='divEventos'></div></td></tr>
				<tr>
					<td align="left">
						<s:select list="listProfesional" name="profesional.profBackgroundcoloragen" id="fondo" listKey="profBackgroundcoloragen" listValue="viewProfesional" headerKey="" headerValue=".::Todas las Citas::." cssClass="inputs" onchange="cambioProfesional();"/>
					</td>
				</tr>
				<s:if test="profesional.persona!=null&&profesional.persona.idPers>0">
					<tr><td align="left">
						<table cellpadding="0" cellspacing="0" border="0" class="display">
							<tr><td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
								<td colspan="3"><s:property value="profesional.persona.nombreCompleto"/></td>
								<td class="leftLabel"><s:text name="personal.documento"></s:text></td>
								<td><s:property value="profesional.persona.documentoPers"/>&nbsp;<s:property value="profesional.persona.tipodocumento.abreviaturaTidoc"/></td>
							</tr>
							<tr><td class="leftLabel"><s:text name="personal.fechanacimientoedad"></s:text></td>
								<td><s:property value="profesional.persona.fechanacimientoPers"/>&nbsp;<s:property value="profesional.persona.edad"/></td>
								<td class="leftLabel"><s:text name="personal.sexo"></s:text></td>
								<td><s:property value="profesional.persona.sexoPers"/></td>
								<td class="leftLabel"><s:text name="personal.estadocivil"></s:text></td>
								<td><s:property value="profesional.persona.estadocivilPers"/></td>
							</tr>
							<tr><td class="leftLabel"><s:text name="personal.email"></s:text></td>
								<td><s:property value="profesional.persona.emailPers"/></td>
								<td class="leftLabel"><s:text name="personal.telefono"></s:text></td>
								<td><s:property value="profesional.persona.telefonoPers"/></td>
								<td class="leftLabel"><s:text name="personal.direccion"></s:text></td>
								<td><s:property value="profesional.persona.ubicacionPersona"/>&nbsp;<s:property value="profesional.persona.direccionPers"/></td>
							</tr>
							<tr>
								<td class="leftLabel" width="130"><s:text name="profesionalsalud.profesion"></s:text></td>
								<td><s:property value="profesional.profEspecialidad"/></td>
								<td class="leftLabel" width="130"><s:text name="profesionalsalud.nrotarjetaprof"></s:text></td>
								<td><s:property value="profesional.profNrotarjetaprof"/></td>
								<td class="leftLabel" width="130"><s:text name="profesionalsalud.coloragenda"></s:text></td>
								<td><table border="0" width="70%"><tr> 
									<td bgcolor="<s:property value="profesional.profBackgroundcoloragen"/>" width="15%"><s:property value="profesional.profBackgroundcoloragen"/></td><td></td>
								</tr></table></td>
							</tr>
						</table>
					</td></tr>
				</s:if>
				<tr><td align="left"><div id='calendar'></div></td></tr> 
			</table>
		</div>
	</s:form>
</body>
</html>