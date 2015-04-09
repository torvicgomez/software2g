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
					<td class="right" colspan="2"><input type="button" value="<s:text name="labelbutton.agregarMedicamento"></s:text>" onclick="agregarGrilla();" class="buttonSV"/></td>
				</tr>
				<tr>
					<td colspan="2" class="text">
						<s:if test="listLugarDestino!=null&&listLugarDestino.size()>0">
							<table cellpadding="0" cellspacing="0" border="1" class="display" id="paradasProgramadas"> 
								<thead>
									<tr>
										<th><s:text name="lugarParada.orden"></s:text></th>
										<th><s:text name="lugarParada.parada"></s:text></th>
										<th><s:text name="lugarParada.tipoParada"></s:text></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="listLugarDestino" id="data" status="stat">
										<tr>
											<td>${stat.index+1}</td>
											<td>
												<s:if test="ludeOrden==0"><s:property value="ludeOrigen"/></s:if>
												<s:elseif test="ludeOrden==99"><s:property value="ludeFinviaje"/></s:elseif>
												<s:else><s:property value="ludeParada"/></s:else>
											</td>
											<td>
												<s:if test="ludeOrden==0"><s:text name="lugarParada.labelGridOrigen"></s:text></s:if>
												<s:elseif test="ludeOrden==99"><s:text name="lugarParada.labelGridDestino"></s:text></s:elseif>
												<s:else><s:text name="lugarParada.labelGridParada"></s:text></s:else>
											</td>
											<td class="right"><input type="button" value="<s:text name="labelbutton.eliminarGrilla"></s:text>" onclick="eliminarGrilla('${stat.index}');" class="buttonSV"/></td>
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
