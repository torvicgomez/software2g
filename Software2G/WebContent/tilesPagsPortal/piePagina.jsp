<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
.fondo{
	/* IE10 Consumer Preview */ 
	background-image: -ms-linear-gradient(top, #FFFFFF 0%, #f3f3f3 100%);
	/* Mozilla Firefox */ 
	background-image: -moz-linear-gradient(top, #FFFFFF 0%, #f3f3f3 100%);
	/* Opera */ 
	background-image: -o-linear-gradient(top, #FFFFFF 0%, #f3f3f3 100%);
	/* Webkit (Safari/Chrome 10) */ 
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #FFFFFF), color-stop(1, #f3f3f3));
	/* Webkit (Chrome 11+) */ 
	background-image: -webkit-linear-gradient(top, #FFFFFF 0%, #f3f3f3 100%);
	/* W3C Markup, IE10 Release Preview */ 
	background-image: linear-gradient(to bottom, #FFFFFF 0%, #f3f3f3 100%);
	border: 2px solid #CECF9C;/*Borde del frame principal*/
	-moz-border-radius: 10px;/*Borde redondeado pata mozilla*/
    -webkit-border-radius: 10px;/*Borde redondeado*/
    behavior:url(border-radius.htc); 
}
</style>
<table width="100%" align="center" height="100%" border="0" class="fondo">
	<tr>
		<td valign="top" width="100%" height="100%">
			<div>
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</td>
	</tr>
</table>
