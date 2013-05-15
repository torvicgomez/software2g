<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head parseContent="true" />
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<title><tiles:insertAttribute name="title" ignore="true" />
</title>
<link href="<s:url value='css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.dataTables.js'/>"></script>
<LINK rel="stylesheet" type="text/css" media="all" href="<s:url value="/css/calendar-blue.css"/>" title="winter">
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>

<script language="JavaScript" type="text/JavaScript">
	function enviarMensaje(mensaje, form, action) {
		if (confirm(mensaje)) {
			document.forms[form].action = action;
			document.forms[form].submit();
			return true;
		} else {
			return false;
		}
	}
	function enviar(form, action) {
		document.forms[form].action = action;
		document.forms[form].submit();
	}
	function disableControls(name) {
		document.getElementById(name).childNodes[1].disable = 'true';
		document.getElementById(name).childNodes[1].readOnly = 'readonly';
		document.getElementById(name).childNodes[1].disable = '';
		document.getElementById(name).childNodes[1].style.color = '#009BB2';
	}
	function disableKeys() {
		var keyCode = (document.all) ? event.keyCode : e.which;
		if (keyCode == 9) {
			window.event.returnValue = true;
		} else {
			window.event.returnValue = false;
		}
	}
	function show_details() {
		dojo.event.topic.publish("show_detail");
	}
	function limpiar(name) {
		document.getElementsByName(name)[0].value = '';
	}
	function borrarGeneral(action, form) {
		if (confirm('¿Esta seguro de eliminar el registro?')) {
			document.forms[form].action = action;
			document.forms[form].submit();
		}
		return false;
	}

	/***FUNCION DEL MENU**/
	function cambiarPestana(id, tp) {
		document.getElementById('pestanasel').value = id;
		document.forms['formMenu'].action = document.getElementById('action'
				+ id).value;
		document.forms['formMenu'].submit();
	}
</script>
</head>
<body>
	<frameset cols="280,*"> 
	<frame name="tree" src="leftframe.htm"> 
	<frame name="content" src="rightframe.htm"> 
	</frameset>
	<table border="1" cellpadding="0" cellspacing="0" width="85%" align="center" >
		<tr>
			<td valign="top" width="95%" >
				<table border="1" cellpadding="0" cellspacing="0" align="center" width="100%" height="100%">
					<tr>
						<td valign="top" width="70%" height="100%">
							<div class="border">
								<tiles:insertAttribute name="header"/>
							</div>
						</td>
						<td valign="top" width="30%" height="100%">
							<div class="border">
								<tiles:insertAttribute name="headerUser"/>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top" width="95%">
				<div class="border"><tiles:insertAttribute name="functionPrinc"/></div>
				<s:if test="hasActionMessages()">
					<tr>
						<td align="center">
							<div class="border">
								<s:actionmessage />
								<s:actionerror />
								<s:fielderror />
							</div></td>
					</tr>
				</s:if>
				<s:elseif test="hasActionErrors()">
					<tr>
						<td align="center">
							<div class="border">
								<s:actionmessage />
								<s:actionerror />
								<s:fielderror />
							</div></td>
					</tr>
				</s:elseif>
				<s:elseif test="hasFieldErrors()">
					<tr>
						<td align="center">
							<div class="border">
								<s:actionmessage />
								<s:actionerror />
								<s:fielderror />
							</div></td>
					</tr>
				</s:elseif>
            </td>
		</tr>
		<tr>
			<td valign="top" width="95%">
				<table border="1" cellpadding="0" cellspacing="0" align="center" width="100%"  height="100%">
					<tr>
						<td valign="top" width="25%">
							<div class="border"><tiles:insertAttribute name="functionSecun" /></div>
						</td>
						<td valign="top" width="75%"  height="100%">
							<div class="border">
								<tiles:insertAttribute name="body" />
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top" width="95%">
				<div class="border"><tiles:insertAttribute name="footer" /></div>
			</td>
		</tr>
	</table>
	
</body>
</html>