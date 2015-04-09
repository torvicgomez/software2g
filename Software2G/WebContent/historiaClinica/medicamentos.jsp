<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
	<body id="dt_example">
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr>
					<td class="leftLabel"><s:text name="medicamentos.medicamento"></s:text></td>
					<td><s:textfield name="medicamento.mediMedicamento" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td class="leftLabel"><s:text name="medicamentos.presentacion"></s:text></td>
					<td><s:textfield name="medicamento.mediPresentacion" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td class="leftLabel"><s:text name="medicamentos.cantidad"></s:text></td>
					<td><s:textfield name="medicamento.mediCantidad" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td class="leftLabel"><s:text name="medicamentos.dosis"></s:text></td>
					<td><s:textfield name="medicamento.mediDosis" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td class="leftLabel"><s:text name="medicamentos.intervalo"></s:text></td>
					<td><s:textfield name="medicamento.mediIntervalo" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
			</table>
		</div>
	</body>
</html>
