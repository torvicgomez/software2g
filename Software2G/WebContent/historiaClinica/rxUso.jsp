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
						<h1><s:text name="servicioexamenopt.exaoptrxuso"></s:text></h1>
					</td></tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<s:hidden name="rxUsoOD.reruId" ></s:hidden>
					<s:hidden name="rxUsoOI.reruId" ></s:hidden>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.esfera"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruEsfera" id="reruEsfera" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.cilindro"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruCilindro" id="reruCilindro" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.eje"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruEje" id="reruEje" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruAvl" id="reruAvl" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td>
						<td><s:select list="listAVC" name="rxUsoOD.reruAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.esfera"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruEsfera" id="reruEsfera" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.cilindro"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruCilindro" id="reruCilindro" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.eje"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruEje" id="reruEje" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruAvl" id="reruAvl" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td>
						<td><s:select list="listAVC" name="rxUsoOI.reruAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
					</tr>
				</table>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
