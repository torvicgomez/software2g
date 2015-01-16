var paca_slotduration = '00:30:00';
var paca_scrolltime = '08:00:00';
var paca_mitime = '07:00:00';
var paca_maxtime = '14:00:00';
var paca_sloteventover = false;
var paca_alldayslot = true;
var paca_alldaytext = 'Todo el Dia';
var paca_meses_es = new Array ("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
var paca_diasSemana_es = new Array("Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado");
var paca_diasSemanaAbre_es = new Array("Dom","Lun","Mar","Mie","Jue","Vie","Sab");


function formatDate_es(s){
	var fecha_es = s;
	if(s.indexOf("Sun")>-1)
		fecha_es = s.replace("Sun", "Dom");
	else if(s.indexOf("Mon")>-1) 
		fecha_es = s.replace("Mon", "Lun");
	else if(s.indexOf("Tue")>-1)
		fecha_es = s.replace("Tue", "Mar");
	else if(s.indexOf("Wed")>-1)
		fecha_es = s.replace("Wed", "Mie");
	else if(s.indexOf("Thu")>-1)
		fecha_es = s.replace("Thu", "Jue");
	else if(s.indexOf("Fri")>-1)
		fecha_es = s.replace("Fri", "Vie");
	else if(s.indexOf("Sat")>-1)
		fecha_es = s.replace("Sat", "Sab");
	
	if(s.indexOf("Sunday")>-1)
		fecha_es = s.replace("Sunday", "Domingo");
	else if(s.indexOf("Monday")>-1)
		fecha_es = s.replace("Monday", "Lunes");
	else if(s.indexOf("Tuesday")>-1)
		fecha_es  = s.replace("Tuesday", "Martes");
	else if(s.indexOf("Wednesday")>-1)
		fecha_es = s.replace("Wednesday", "Miércoles");
	else if(s.indexOf("Thursday")>-1)
		fecha_es = s.replace("Thursday", "Jueves");
	else if(s.indexOf("Friday")>-1)
		fecha_es = s.replace("Friday", "Viernes");
	else if(s.indexOf("Saturday")>-1)
		fecha_es = s.replace("Saturday", "Sábado");
	
	if(s.indexOf("January")>-1)
		fecha_es = s.replace("January", "Enero");
	else if(s.indexOf("February")>-1)
		fecha_es = s.replace("February", "Febrero");
	else if(s.indexOf("March")>-1)
		fecha_es = s.replace("March", "Marzo");
	else if(s.indexOf("April")>-1)
		fecha_es = s.replace("April", "Abril");
	else if(s.indexOf("May")>-1)
		fecha_es = s.replace("May", "Mayo");
	else if(s.indexOf("June")>-1)
		fecha_es = s.replace("June", "Junio");
	else if(s.indexOf("July")>-1)
		fecha_es = s.replace("July", "Julio");
	else if(s.indexOf("August")>-1)
		fecha_es = s.replace("August", "Agosto");
	else if(s.indexOf("September")>-1)
		fecha_es = s.replace("September", "Septiembre");
	else if(s.indexOf("October")>-1)
		fecha_es = s.replace("October", "Octubre");
	else if(s.indexOf("November")>-1)
		fecha_es = s.replace("November", "Noviembre");
	else if(s.indexOf("December")>-1)
		fecha_es = s.replace("December", "Diciembre");
	return fecha_es;
}