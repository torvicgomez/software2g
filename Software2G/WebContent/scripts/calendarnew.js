var calendar = null; 
                     
function selected(cal, date) {
  cal.sel.value = date; 

  if (cal.sel.id == "sel1" || cal.sel.id == "sel3")
    cal.callCloseHandler();
}

function selectedTime(cal, date) {
  var time = cal.sel.value
  time = time.substring(10,22)
  cal.sel.value = date+time; 

  if (cal.sel.id == "sel1" || cal.sel.id == "sel3")
    cal.callCloseHandler();
}


function closeHandler(cal) {
  cal.hide();                        

  Calendar.removeEvent(document, "mousedown", checkCalendar);
}

function checkCalendar(ev) {
  var el = Calendar.is_ie ? Calendar.getElement(ev) : Calendar.getTargetElement(ev);
  for (; el != null; el = el.parentNode)
    if (el == calendar.element || el.tagName == "A") break;
  if (el == null) {
    calendar.callCloseHandler();
    Calendar.stopEvent(ev);
  }
}

function showCalendar(id, format) {
  var el = document.getElementById(id);
  if(el == null){
	 el=document.getElementsByName(id)[0]; 
  }
  if (calendar != null) {
    calendar.hide();             
  } else {
    
    var cal = new Calendar(true, null, selected, closeHandler);
    calendar = cal;                  
    cal.setRange(1900, 2070);        
    cal.create();
  }
  calendar.setDateFormat(format);    
  calendar.parseDate(el.value);     
  calendar.sel = el;               
  calendar.showAtElement(el);       

  Calendar.addEvent(document, "mousedown", checkCalendar);
  return false;
}

function showCalendarTime(id, format) {
  var el = document.getElementById(id);  
  if (calendar != null) {
    calendar.hide();             
  } else {
    
    var cal = new Calendar(true, null, selectedTime, closeHandler);
    calendar = cal;                  
    cal.setRange(1900, 2070);        
    cal.create();
  }
  calendar.setDateFormat(format);    
  calendar.parseDate(el.value);     
  calendar.sel = el;               
  calendar.showAtElement(el);       

  Calendar.addEvent(document, "mousedown", checkCalendar);
  return false;
}

var MINUTE = 60 * 1000;
var HOUR = 60 * MINUTE;
var DAY = 24 * HOUR;
var WEEK = 7 * DAY;

function isDisabled(date) {
  var today = new Date();
  return (Math.abs(date.getTime() - today.getTime()) / DAY) > 10;
}

function flatSelected(cal, date) {
  var el = document.getElementById("preview");
  el.innerHTML = date;
}

function tranSfer(previo, vlr) {
	eval("document.all."+previo+".value = \'"+vlr+"\'")
	return false
}

