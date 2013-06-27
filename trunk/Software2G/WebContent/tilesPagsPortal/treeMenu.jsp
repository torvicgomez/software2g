<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<style type="text/css">
.fondo{
	/* CSS3 Gradient */
	background-image: -webkit-gradient(radial, 0% 0%, 0% 100%, from(rgba(213,246,255,1)), to(rgba(213,246,255,0)));
	background-image: -webkit-radial-gradient(50% 50%, 40% 40%, rgba(213,246,255,1), rgba(213,246,255,0));
	background-image: -moz-radial-gradient(50% 50%, 50% 50%, rgba(213,246,255,1), rgba(213,246,255,0));
	background-image: -ms-radial-gradient(50% 50%, 50% 50%, rgba(213,246,255,1), rgba(213,246,255,0));
	background-image: -o-radial-gradient(50% 50%, 50% 50%, rgba(213,246,255,1), rgba(213,246,255,0));
	border: 2px solid #CECF9C;/*Borde del frame principal*/
	-moz-border-radius: 10px;/*Borde redondeado pata mozilla*/
    -webkit-border-radius: 10px;/*Borde redondeado*/
    behavior:url(border-radius.htc);
}
</style>
<table align="center" width="100%"  height="100%" class="fondo">
	<tr>
		<td valign="top" width="100%" height="100%">
			<jsp:include page="functionSecun.jsp"></jsp:include>
		</td>
	</tr>
</table>
			