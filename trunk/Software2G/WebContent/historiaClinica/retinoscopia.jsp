<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><input type="checkbox" id="retinoscopia"/><s:text name="servicioexamenopt.exaoptretinoscopia"></s:text></h1>
					</td></tr>
				</table>
				<div id="divRetinoscopia" style="overflow:auto;width:auto;height:auto;display:none">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="retinoscopiaOD.reesId" ></s:hidden>
						<s:hidden name="retinoscopiaOI.reesId" ></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="servicioexamenopt.ojoderecho"></s:text></td>
							<td><s:textfield name="retinoscopiaOD.reesValor" size="30" cssClass="inputs"></s:textfield></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioexamenopt.ojoizquierdo"></s:text></td>
							<td><s:textfield name="retinoscopiaOI.reesValor" size="30" cssClass="inputs"></s:textfield></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
