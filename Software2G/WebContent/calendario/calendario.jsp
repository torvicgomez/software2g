<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<s:url value='/js/fullcalendar.css'/>" rel="stylesheet" />
<link href="<s:url value='/js/fullcalendar.print.css'/>" rel="stylesheet" media="print" />
<script type="text/javascript" src="<s:url value='/js/lib/moment.min.js'/>"></script>

<script type="text/javascript" src="<s:url value='/js/lib/jquery.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/lib/jquery-ui.js'/>"></script> 

<script type="text/javascript" src="<s:url value='/js/constantes.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/fullcalendar.js'/>"></script>

<link rel="stylesheet" media="all" type="text/css" href="<s:url value='/js/Impromptu._files/screen.css'/>">
<link rel="stylesheet" media="all" type="text/css" href="<s:url value='/js/Impromptu._files/examples.css'/>">
<script type="text/javascript" src="<s:url value='/js/Impromptu._files/jquery-impromptu.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/Impromptu._files/common.js'/>"></script>



<script>
	var txt1 = 'Tipo Documento:<select id="tipodoc" name="tipodoc"><option value="CC">Cedula Ciudadania</option><option value="TI">Tarjeta Identidad</option></select><br/>'+
		  'Nro Documento:<input type="text" id="nrodocumento" name="nrodocumento"/><br/>'+
		  'Primer Nombre:<input type="text" id="pnombre" name="pnombre"/><br/>'+
		  'Segundo Nombre:<input type="text" id="snombre" name="snombre"/><br/>'+
		  'Primer Apellido:<input type="text" id="papellido" name="papellido"/><br/>'+
		  'Segundo Apellido:<input type="text" id="sapellido" name="sapellido"/><br/>'+
		  'Sexo:<select id="sexo" name="sexo"><option value="M">Masculino</option><option value="F">Femenino</option></select>';
	
	var title_evento = '';
	var start_evento = '';
	var end_evento = '';
	var eventos = [
				{
					title: 'All Day Event',
					start: '2014-06-01'
				},
				{
					title: 'Long Event',
					start: '2014-06-07',
					end: '2014-06-10'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-06-09T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-06-16T16:00:00'
				},
				{
					title: 'Meeting',
					start: '2014-06-12T10:30:00',
					end: '2014-06-12T12:30:00',
					className: 'fc-event-pediatria'
				},
				{
					title: 'Lunch',
					start: '2014-06-12T12:00:00',
					backgroundColor: '#ff0000'
				},
				{
					title: 'Birthday Party',
					start: '2014-06-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2014-06-28'
				}
			]; 
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
						url: 'rol.action?estado=all&funcPosicionado=Administracion Portal::>Roles',
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

</script>
<style>

	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		width: 900px;
		margin: 40px auto;
	}

</style>
</head>
<body>
	<table align="center" width="99%" height="100%">
		<tr><td>
			<s:select list="listProfesional" name="agendaMedica.agenAlldayslot" id="fondo" listKey="profBackgroundcoloragen" listValue="viewProfesional" headerKey="" headerValue=".::Seleccion::." cssClass="inputs"/>
		</td></tr>
		<tr><td><div id='calendar'></div></td></tr>
	</table>
</body>
</html>