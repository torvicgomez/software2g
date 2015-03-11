<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<s:form id="form">
		<div id="demo">
			<s:iterator value="listSegmentoAnamnesis" id="data" var="segana" status="stat">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><input type="checkbox" id="segana_${stat.index}"/>
<%-- 						${data.seanEtiqueta} --%>
						<s:property value="#segana.seanEtiqueta"/>
						</h1>
					</td></tr>
				</table>
				<s:if test="#segana.preguntas!=null&&#segana.preguntas.size()>0">
					<s:iterator value="#segana.preguntas" id="dataPreg" var="preg" status="statPreg">
<%-- 						${data.pregPregunta} --%>
						<s:property value="#preg.pregPregunta"/>
						<s:property value="#preg.pregMensajeayuda"/>
						<s:property value="#preg.pregOrden"/>
						<s:property value="#preg.pregTipodato"/>
						
<!-- 					Creacion tipo pregunta abierta -->
						<s:if test="#preg.tipopregunta.tiprEtiqueta!=null&&#preg.tipopregunta.tiprEtiqueta==constanteTipoPregAbierta">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:property value="#preg.pregPregunta"/></td>
									<s:if test="#preg.pregObjetoview==constanteTipoObjetoViewTextArea">
										<td><s:textarea name="examenExternoOD.reesValor" cols="100" rows="3" cssClass="inputs"></s:textarea></td>
									</s:if>
									<s:elseif test="#preg.pregObjetoview==constanteTipoObjetoViewTextField">
										<td><s:textfield name="avscOD.avscAvl" id="avscAvl" size="10" cssClass="inputs"></s:textfield></td>
									</s:elseif>
									
								</tr>
							</table>							
						</s:if>
<!-- 					Creacion tipo pregunta multiple con multiple respuesta -->
						<s:elseif test="#preg.tipopregunta.tiprEtiqueta!=null&&#preg.tipopregunta.tiprEtiqueta==constanteTipoPregMultipleMR">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:property value="#preg.pregPregunta"/></td>
									<s:if test="#preg.pregObjetoview==constanteTipoObjetoViewCheckBox">
										<td>
											<s:iterator value="#preg.opcionrespuestas" id="dataOpcres" var="resp" status="statOpcr">
												<input type="checkbox"/><s:property value="#resp.opreEtiqueta"/>
											</s:iterator>
										</td>
									</s:if>
									<s:elseif test="#preg.pregObjetoview==constanteTipoObjetoViewSelect">
										<td><s:select list="#preg.opcionrespuestas" listKey="opreValor" listValue="opreEtiqueta" headerKey="" headerValue=".::Seleccione::."></s:select></td>
									</s:elseif>
								</tr>
							</table>
						</s:elseif>
						<s:if test="#preg.opcionrespuestas!=null&&#preg.opcionrespuestas.size()>0">
							<s:iterator value="#preg.opcionrespuestas" id="dataOpcres" var="resp" status="statOpcr">
								<s:property value="#resp.opreEtiqueta"/>
								<s:property value="#resp.opreOrden"/>
								<s:property value="#resp.opreValor"/>
							</s:iterator>
						</s:if>
					</s:iterator>
				</s:if>
			</s:iterator>
			
<%-- 			<s:iterator var="parent" value="parents"> --%>
<%-- 			    <s:iterator var="child" value="#parent.children"> --%>
<%-- 			        <s:property value="#child.name"/> --%>
<%-- 			    <s:iterator> --%>
<%-- 			<s:iterator> --%>
			
<!-- 			<div id="divAVSC" style="overflow:auto;width:auto;height:auto;display:none"> -->
<!-- 				<table cellpadding="0" cellspacing="0" border="0" class="display"> -->
<%-- 					<s:hidden name="avscOD.avscId" ></s:hidden> --%>
<%-- 					<s:hidden name="avscOI.avscId" ></s:hidden> --%>
<!-- 					<tr> -->
<%-- 						<td class="leftLabel"><s:text name="servicioexamenopt.ojoderecho"></s:text></td> --%>
<%-- 						<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td> --%>
<%-- 						<td><s:textfield name="avscOD.avscAvl" id="avscAvl" size="10" cssClass="inputs"></s:textfield></td> --%>
<%-- 						<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td> --%>
<%-- 						<td><s:select list="listAVC" name="avscOD.avscAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<%-- 						<td class="leftLabel"><s:text name="servicioexamenopt.ojoizquierdo"></s:text></td> --%>
<%-- 						<td class="leftLabel"><s:text name="servicioexamenopt.avl"></s:text></td> --%>
<%-- 						<td><s:textfield name="avscOI.reruAvl" id="avscAvl" size="10" cssClass="inputs"></s:textfield></td> --%>
<%-- 						<td class="leftLabel"><s:text name="servicioexamenopt.avc"></s:text></td> --%>
<%-- 						<td><s:select list="listAVC" name="avscOI.avscAvc" listKey="key" listValue="valor" headerKey="" headerValue=".::Selecione::." cssClass="inputs"/></td> --%>
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			</div> -->


		</div>
		<div class="spacer"></div>
	</s:form>
</body>
</html>