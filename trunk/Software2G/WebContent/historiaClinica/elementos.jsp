<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
	<body id="dt_example">
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<s:hidden name="gafaOD.gafaId" ></s:hidden>
				<s:hidden name="gafaOI.gafaId" ></s:hidden>
				<tr>
					<td class="leftLabel"><s:text name="servicioexamenopt.ojoderecho"></s:text></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.esfera"></s:text></td>
					<td><s:textfield name="gafaOD.gafaEsfera" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.cilindro"></s:text></td>
					<td><s:textfield name="gafaOD.gafaCilindro" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.eje"></s:text></td>
					<td><s:textfield name="gafaOD.gafaEje" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
					<td><s:textfield name="gafaOD.gafaAvl" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.add"></s:text></td>
					<td><s:textfield name="gafaOD.gafaAdd" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td class="leftLabel"><s:text name="servicioexamenopt.ojoizquierdo"></s:text></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.esfera"></s:text></td>
					<td><s:textfield name="gafaOI.gafaEsfera" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.cilindro"></s:text></td>
					<td><s:textfield name="gafaOI.gafaCilindro" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.eje"></s:text></td>
					<td><s:textfield name="gafaOI.gafaEje" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td>
					<td><s:textfield name="gafaOI.gafaAvl" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.add"></s:text></td>
					<td><s:textfield name="gafaOI.gafaAdd" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.progresivo"></s:text></td>
					<td><s:textfield name="gafaAmbosOjos.gafaProgresivo" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.distanciapupilar"></s:text></td>
					<td><s:textfield name="gafaAmbosOjos.gafaDistanciapupilar" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.materia"></s:text></td>
					<td><s:textfield name="gafaAmbosOjos.gafaMaterial" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.color"></s:text></td>
					<td><s:textfield name="gafaAmbosOjos.gafaColor" size="10" cssClass="inputs"></s:textfield></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.bifocal"></s:text></td>
					<td><s:textfield name="gafaAmbosOjos.gafaBifocal" size="10" cssClass="inputs"></s:textfield></td>
				</tr>
				<tr>
					<td></td>
					<td class="leftLabel"><s:text name="servicioexamenopt.observaciones"></s:text></td>
					<td colspan="7"><s:textarea name="gafaAmbosOjos.gafaObservaciones" cols="100" rows="3" cssClass="inputs"></s:textarea></td>
				</tr>
			</table>
	</div>
	</body>
</html>
