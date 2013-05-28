<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<link href="<s:url value='css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.dataTables.js'/>"></script>
<LINK rel="stylesheet" type="text/css" media="all" href="<s:url value="/css/calendar-blue.css"/>" title="winter">
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
<style type="text/css">
.fondo{
	border: 2px solid #CECF9C;/*Borde del frame principal*/
	-moz-border-radius: 10px;/*Borde redondeado pata mozilla*/
    -webkit-border-radius: 10px;/*Borde redondeado*/
    behavior:url(border-radius.htc);
}
.fondoUbicacion{
	background-color: #F7F7E7;/*Fondo del frame principal*/
	-moz-border-radius: 10px;/*Borde redondeado pata mozilla*/
    -webkit-border-radius: 10px;/*Borde redondeado*/
    behavior:url(border-radius.htc);
}
.fondoError{
	border: 2px solid #CECF9C;/*Borde del frame principal*/
	-moz-border-radius: 10px;/*Borde redondeado pata mozilla*/
    -webkit-border-radius: 10px;/*Borde redondeado*/
    behavior:url(border-radius.htc);
}
</style>
<table cellpadding="0" cellspacing="0" width="100%" align="center" class="fondo">
	<tr>
		<td valign="top" width="100%">
			<div class="fondoUbicacion"><tiles:insertAttribute name="functionPrinc"/></div>
			<s:if test="hasActionMessages()">
				<tr>
					<td align="left">
						<div class="fondoError">
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
		<td valign="top" width="100%">
			<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%"  height="100%">
				<tr>
					<td valign="top" width="100%"  height="100%">
						<tiles:insertAttribute name="body" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
