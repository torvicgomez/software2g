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
						<h1><input type="checkbox" id="coverTest"/><s:text name="servicioexamenopt.exaoptcovertest"></s:text></h1>
					</td></tr>
				</table>
				<div id="divCoverTest" style="overflow:auto;width:auto;height:auto;display:none">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="coverTest.rectId" ></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="servicioexamenopt.lejos"></s:text></td>
							<td><s:select list="listCoverTest" name="coverTest.rectLejos" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
							<td>
								<input type="checkbox"><s:text name="servicioexamenopt.ojoderecho"></s:text>
								<input type="checkbox"><s:text name="servicioexamenopt.ojoizquierdo"></s:text>
							</td>
							<td><input type="button" value="<s:text name="servicioexamenopt.vincularctlejos"></s:text>" onclick="aler('Construccion');" class="buttonSV"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="servicioexamenopt.cerca"></s:text></td>
							<td><s:select list="listCoverTest" name="coverTest.rectCerca" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td>
							<td>
								<input type="checkbox"><s:text name="servicioexamenopt.ojoderecho"></s:text>
								<input type="checkbox"><s:text name="servicioexamenopt.ojoizquierdo"></s:text>
							</td>
							<td><input type="button" value="<s:text name="servicioexamenopt.vincularctcerca"></s:text>" onclick="aler('Construccion');" class="buttonSV"/></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
