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

function formatDateTitle_es(s){
	var fecha_es = s;
	if(s.indexOf("Jan")>-1)
		fecha_es = s.replace("Jan", "Ene");
	else if(s.indexOf("Feb")>-1)
		fecha_es = s.replace("Feb", "Feb");
	else if(s.indexOf("Mar")>-1)
		fecha_es = s.replace("Mar", "Mar");
	else if(s.indexOf("Apr")>-1)
		fecha_es = s.replace("Apr", "Abr");
	else if(s.indexOf("May")>-1)
		fecha_es = s.replace("May", "May");
	else if(s.indexOf("Jun")>-1)
		fecha_es = s.replace("Jun", "Jun");
	else if(s.indexOf("Jul")>-1)
		fecha_es = s.replace("Jul", "Jul");
	else if(s.indexOf("Aug")>-1)
		fecha_es = s.replace("Aug", "Ago");
	else if(s.indexOf("Sep")>-1)
		fecha_es = s.replace("Sep", "Sep");
	else if(s.indexOf("Oct")>-1)
		fecha_es = s.replace("Oct", "Oct");
	else if(s.indexOf("Nov")>-1)
		fecha_es = s.replace("Nov", "Nov");
	else if(s.indexOf("Dec")>-1)
		fecha_es = s.replace("Dec", "Dic");
	return fecha_es;
}