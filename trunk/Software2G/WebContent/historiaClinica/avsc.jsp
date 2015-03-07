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
						<h1><input type="checkbox" id="avsc"/><s:text name="servicioexamenopt.exaoptavsc"></s:text></h1>
					</td></tr>
				</table>
				<div id="divAVSC" style="overflow:auto;width:auto;height:auto;display:none">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="avscOD.avscId" ></s:hidden>
						<s:hidden name="avscOI.avscId" ></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="servicioexamenopt.ojoderecho"></s:text></td>
							<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
							<td><s:textfield name="avscOD.avscAvl" id="avscAvl" size="10" cssClass="inputs"></s:textfield></td>
							<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td>
							<td><s:select list="listAVC" name="avscOD.avscAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioexamenopt.ojoizquierdo"></s:text></td>
							<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
							<td><s:textfield name="avscOI.reruAvl" id="avscAvl" size="10" cssClass="inputs"></s:textfield></td>
							<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td>
							<td><s:select list="listAVC" name="avscOI.avscAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
