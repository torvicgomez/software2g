<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<sx:head parseContent="true" />
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
		<title>
			<tiles:insertAttribute name="title" ignore="true" />
		</title>
		
		<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/calendar-blue.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/jquery-ui.css'/>" rel="stylesheet" type="text/css" />
        <link href="<s:url value='/css/jquery.ui.timepicker.css'/>" rel="stylesheet" type="text/css" />
        
        <script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
        <script type="text/javascript" language="javascript" src="<s:url value='/js/jquery-ui.js'/>"></script>
		<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.ui.timepicker.js'/>"></script>
		<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
		<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
		<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.cookie.js'/>"></script>
<%-- 		<script type="text/javascript" language="javascript" src="<s:url value='/scripts/calendar-stripped.js'/>"></script> --%>
<%-- 		<script type="text/javascript" language="javascript" src="<s:url value='/scripts/calendar-en.js'/>"></script> --%>
<%-- 		<script type="text/javascript" language="javascript" src="<s:url value='/scripts/calendarnew.js'/>"></script> --%>
<%-- 		<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.chromatable.js'/>"></script> --%>
<%-- 		<script type="text/javascript" language="javascript" src="<s:url value='/js/util.js'/>"></script> --%>
<%-- 		<script type="text/javascript" language="javascript" src="<s:url value='/js/divUbicacion.js'/>"></script> --%>
	
		<link href="<s:url value='/js/zTreeMenu/css/zTreeStyle/zTreeStyle.css'/>" rel="stylesheet" type="text/css" />
<%-- 		<link href="<s:url value='/js/zTreeMenu/css/demo.css'/>" rel="stylesheet" type="text/css" /> --%>
<%-- 		<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery-1.4.4.min.js'/>"></script> --%>
		<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery.ztree.core-3.5.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery.ztree.excheck-3.5.js'/>"></script>
		<script language="JavaScript" type="text/JavaScript">
			function disableKeys() {
				var keyCode = (document.all) ? event.keyCode : e.which;
				if (keyCode == 9) {
					window.event.returnValue = true;
				} else {
					window.event.returnValue = false;
				}
			}
		</script>
	</head>
	
	<body id="dt_example">
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr>
				<td valign="top" width="100%">
					<div class="funcPosicion">
						<tiles:insertAttribute name="functionPrinc"/>
					</div>
					
					<s:if test="hasActionMessages()">
						<tr>
							<td align="left">
								<div class="actionProcess">
									<s:actionmessage />
									<s:actionerror />
									<s:fielderror />
								</div>
							</td>
						</tr>
					</s:if>
					<s:elseif test="hasActionErrors()">
						<tr>
							<td align="left">
								<div class="errors">
									<s:actionmessage />
									<s:actionerror />
									<s:fielderror />
								</div>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="hasFieldErrors()">
						<tr>
							<td align="left">
								<div class="errors">
									<s:actionmessage />
									<s:actionerror />
									<s:fielderror />
								</div>
							</td>
						</tr>
					</s:elseif>
				</td>
			</tr>
			<tr>
				<td valign="top" width="100%">
					<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" height="100%" >
						<tr>
							<td valign="top" width="100%" height="100%">
								<div class="borderSV"> 
									<tiles:insertAttribute name="body" />
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>