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
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.dataTables.js'/>"></script>
<LINK rel="stylesheet" type="text/css" media="all" href="<s:url value="/css/calendar-blue.css"/>" title="winter">
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
</head>
<body>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" >
		<tr>
			<td valign="top" width="100%">
				<table cellpadding="0" cellspacing="0" align="center" width="100%"  height="100%">
					<tr>
						<td valign="top" width="25%">
							<div class="border">
								<jsp:include page="functionSecun.jsp"></jsp:include>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>