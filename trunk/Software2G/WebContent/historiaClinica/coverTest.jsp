<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" charset="utf-8">
			function cargarDatosCoverTest(tipo){
				var covertest = '';
				var ojoDer = '';
				var ojoIzq = ''; 
				if(tipo=='<%=ConstantesAplicativo.constanteCoverTestLejosAbre%>'){
					covertest = document.getElementById("coverTestLejos").value;
					ojoDer = document.getElementById("ctlOD").checked;
					ojoIzq = document.getElementById("ctlOI").checked; 
					$("#divCoverTestLejos").load('cargarDatosCoverTest.action?covertest='+covertest+'&od='+ojoDer+'&oi='+ojoIzq+'&tipo='+tipo);
				}else if(tipo=='<%=ConstantesAplicativo.constanteCoverTestCercaAbre%>'){
					covertest = document.getElementById("coverTestCerca").value;
					ojoDer = document.getElementById("ctcOD").checked;
					ojoIzq = document.getElementById("ctcOI").checked; 
					$("#divCoverTestCerca").load('cargarDatosCoverTest.action?covertest='+covertest+'&od='+ojoDer+'&oi='+ojoIzq+'&tipo='+tipo);
				}
			}
			
			function eliminarCoverTest(pos,tipo){
				if(tipo=='<%=ConstantesAplicativo.constanteCoverTestLejosAbre%>'){
					$("#divCoverTestLejos").load('cargarDatosCoverTest.action?posicion='+pos+'&tipo='+tipo);
				}else if(tipo=='<%=ConstantesAplicativo.constanteCoverTestCercaAbre%>'){
					$("#divCoverTestCerca").load('cargarDatosCoverTest.action?posicion='+pos+'&tipo='+tipo);
				}
			} 
		</script>
	</head>
	<body id="dt_example">
		<%String check = request.getParameter("check");%>
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr><td>
					<h1><input type="checkbox" id="coverTest" <%=check!=null&&check.equals("save")?"checked=\"checked\"":""%>/>
						<s:text name="servicioexamenopt.exaoptcovertest"></s:text>
					</h1>
				</td></tr>
			</table>
			<div id="divCoverTest" style="overflow:auto;width:auto;height:auto;display:<%=check!=null&&check.equals("save")?"block":"none"%>">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<s:hidden name="coverTest.rectId" ></s:hidden>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.lejos"></s:text></td>
						<td>
							<s:select list="listCoverTest" name="coverTest.rectLejos" id="coverTestLejos" listKey="key" listValue="valor" cssClass="inputs"/>
							<input type="checkbox" id="ctlOD"><s:text name="servicioexamenopt.ojoderecho"></s:text>
							<input type="checkbox" id="ctlOI"><s:text name="servicioexamenopt.ojoizquierdo"></s:text>
						</td>
						<td><input type="button" value="<s:text name="servicioexamenopt.vincularctlejos"></s:text>" onclick="javascript:cargarDatosCoverTest('<%=ConstantesAplicativo.constanteCoverTestLejosAbre%>');" class="buttonSV"/></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2">
							<div id="divCoverTestLejos">
								<s:if test="listRegistroCoverTestLejos!=null&&listRegistroCoverTestLejos.size()>0">
									<table cellpadding="0" cellspacing="0" border="0" class="display">
										<s:iterator value="listRegistroCoverTestLejos" id="data" status="stat">
											<tr>
												<td><s:property value="rectLejos"/></td>
												<td><s:property value="especificacionpartecuerpo.espcNombre"/></td>
												<td><input type="button" value="<s:text name="servicioexamenopt.desvincularctlejos"></s:text>" onClick="eliminarCoverTest('${stat.index}','<%=ConstantesAplicativo.constanteCoverTestLejosAbre%>');" class="buttonSV"/></td>
											</tr>
										</s:iterator>
									</table>	
								</s:if>
								<s:else><s:text name="advertencia.noregistros"></s:text></s:else>
							</div>
						</td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="servicioexamenopt.cerca"></s:text></td>
						<td>
							<s:select list="listCoverTest" name="coverTest.rectCerca" id="coverTestCerca" listKey="key" listValue="valor" cssClass="inputs"/>
							<input type="checkbox" id="ctcOD"><s:text name="servicioexamenopt.ojoderecho"></s:text>
							<input type="checkbox" id="ctcOI"><s:text name="servicioexamenopt.ojoizquierdo"></s:text>
						</td>
						<td><input type="button" value="<s:text name="servicioexamenopt.vincularctcerca"></s:text>" onclick="javascript:cargarDatosCoverTest('<%=ConstantesAplicativo.constanteCoverTestCercaAbre%>');" class="buttonSV"/></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2">
							<div id="divCoverTestCerca">
								<s:if test="listRegistroCoverTestCerca!=null&&listRegistroCoverTestCerca.size()>0">
									<table cellpadding="0" cellspacing="0" border="0" class="display">
										<s:iterator value="listRegistroCoverTestCerca" id="data" status="stat">
											<tr>
												<td><s:property value="rectLejos"/></td>
												<td><s:property value="especificacionpartecuerpo.espcNombre"/></td>
												<td><input type="button" value="<s:text name="servicioexamenopt.desvincularctcerca"></s:text>" onClick="eliminarCoverTest('${stat.index}','<%=ConstantesAplicativo.constanteCoverTestCercaAbre%>');" class="buttonSV"/></td>
											</tr>
										</s:iterator>
									</table>	
								</s:if>
								<s:else><s:text name="advertencia.noregistros"></s:text></s:else>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
