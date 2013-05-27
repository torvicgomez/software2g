<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<style type="text/css">
.fondo{
	/* IE10 Consumer Preview */ 
	background-image: -ms-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%);
	/* Mozilla Firefox */ 
	background-image: -moz-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%);
	/* Opera */ 
	background-image: -o-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%);
	/* Webkit (Safari/Chrome 10) */ 
	background-image: -webkit-gradient(linear, left bottom, left top, color-stop(0, #FFFFFF), color-stop(1, #966A36));
	/* Webkit (Chrome 11+) */ 
	background-image: -webkit-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%);
	/* W3C Markup, IE10 Release Preview */ 
	background-image: linear-gradient(to top, #FFFFFF 0%, #966A36 100%);
}
</style>
<table width="100%" align="center" border="0" height="100%" class="fondo">
	<tr>
		<td valign="top" width="100%" >
			<table align="center" width="100%" height="100%" border="0">
				<tr>
					<td valign="top" width="70%" height="100%">
							<jsp:include page="header.jsp"></jsp:include>
					</td>
					<td valign="baseline" width="30%" height="100%">
							<jsp:include page="headerUser.jsp"></jsp:include>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
