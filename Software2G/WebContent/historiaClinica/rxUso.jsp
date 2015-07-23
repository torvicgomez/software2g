<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
	<body id="dt_example">
		<%String check = request.getParameter("check");%>
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr><td>
					<h1><input type="checkbox" id="rxUso" <%=check!=null&&check.equals("save")?"checked=\"checked\"":""%>/>
						<s:text name="servicioexamenopt.exaoptrxuso"></s:text>
					</h1>
				</td></tr>
			</table>
			<div id="divRxUso" style="overflow:auto;width:auto;height:auto;display:<%=check!=null&&check.equals("save")?"block":"none"%>">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<s:hidden name="rxUsoOD.reruId" ></s:hidden>
					<s:hidden name="rxUsoOI.reruId" ></s:hidden>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.ojoderecho"></s:text></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.esfera"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruEsfera" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.cilindro"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruCilindro" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.eje"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruEje" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
						<td><s:textfield name="rxUsoOD.reruAvl" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td>
						<td><s:select list="listAVC" name="rxUsoOD.reruAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.ojoizquierdo"></s:text></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.esfera"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruEsfera" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.cilindro"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruCilindro" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.eje"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruEje" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
						<td><s:textfield name="rxUsoOI.reruAvl" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td>
						<td><s:select list="listAVC" name="rxUsoOI.reruAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
					</tr>
					<tr>
						<td></td>
						<td class="leftLabel"><s:text name="servicioexamenopt.add"></s:text></td>
						<td colspan="9"><s:textfield name="rxUsoOI.reruAdd" size="10" cssClass="inputs"></s:textfield></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
