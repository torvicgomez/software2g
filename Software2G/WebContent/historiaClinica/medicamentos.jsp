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
				<tr>
					<td class="right" colspan="2"><input type="button" value="<s:text name="labelbutton.agregarMedicamento"></s:text>" onclick="agregarGrilla('<%=ConstantesAplicativo.constanteTipoGridMedicamentos%>');" class="buttonSV"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<s:if test="listMedicamento!=null&&listMedicamento.size()>0">
							<table cellpadding="0" cellspacing="0" border="1" class="display" id="paradasProgramadas"> 
								<thead>
									<tr>
										<th><s:text name="columna.item"></s:text></th>
										<th><s:text name="medicamentos.medicamento"></s:text></th>
										<th><s:text name="medicamentos.presentacion"></s:text></th>
										<th><s:text name="medicamentos.cantidad"></s:text></th>
										<th><s:text name="medicamentos.dosis"></s:text></th>
										<th><s:text name="medicamentos.intervalo"></s:text></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="listMedicamento" id="data" status="stat">
										<tr>
											<td>${stat.index+1}</td>
											<td><s:property value="mediMedicamento"/></td>
											<td><s:property value="mediPresentacion"/></td>
											<td><s:property value="mediCantidad"/></td>
											<td><s:property value="mediDosis"/></td>
											<td><s:property value="mediIntervalo"/></td>
											<td class="right"><input type="button" value="<s:text name="labelbutton.eliminarMedicamento"></s:text>" onclick="eliminarGrilla('${stat.index}','<%=ConstantesAplicativo.constanteTipoGridMedicamentos%>');" class="buttonSV"/></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>	
						</s:if>
						<s:else><s:text name="advertencia.noregistros"></s:text></s:else>	
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
