<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
	<body id="dt_example">
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr><td>
					<h1><input type="checkbox" id="examenExterno"/><s:text name="servicioexamenopt.exaoptexaexterno"></s:text></h1>
				</td></tr>
			</table>
			<div id="divExamenExterno" style="overflow:auto;width:auto;height:auto;display:none">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<s:hidden name="examenExternoOD.reesId" ></s:hidden>
					<s:hidden name="examenExternoOI.reesId" ></s:hidden>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.ojoderecho"></s:text></td>
						<td><s:textarea name="examenExternoOD.reesValor" cols="100" rows="3" cssClass="inputs"></s:textarea></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.ojoizquierdo"></s:text></td>
						<td><s:textarea name="examenExternoOI.reesValor" cols="100" rows="3" cssClass="inputs"></s:textarea></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
