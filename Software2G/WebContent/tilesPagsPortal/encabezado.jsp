<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<table width="100%" align="center" border="0" height="100%">
	<tr>
		<td valign="top" width="100%" >
			<table align="center" width="100%" height="100%" border="0">
				<tr>
					<td valign="top" width="70%" height="100%">
						<div class="border">
							<jsp:include page="header.jsp"></jsp:include>
						</div>
					</td>
					<td valign="baseline" width="30%" height="100%">
						<div class="border">
							<jsp:include page="headerUser.jsp"></jsp:include>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
