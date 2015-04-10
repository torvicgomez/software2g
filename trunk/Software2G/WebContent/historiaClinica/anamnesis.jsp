<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" charset="utf-8">
		function cambioView(obj){
			var segmentoAnamnesis = document.getElementById("segmentoAnamnesis_"+obj);
			if($('input:checkbox[id=segana_'+obj+']:nth(0)').is(':checked')) {
				segmentoAnamnesis.style.display = 'block';
	    	}else{
	    		segmentoAnamnesis.style.display = 'none';
	    	}		
		}
		
		function registroCheck(obj,idPreg){
			var pregCheck = document.getElementById("pregCheck_"+idPreg);
			if(obj.checked){
				pregCheck.value +=  obj.value+'<%=ConstantesAplicativo.constanteSplit%>';
			}else{
				pregCheck.value = pregCheck.value.replace(obj.value+'<%=ConstantesAplicativo.constanteSplit%>',''); 
			}
		}
		
		
	</script>
</head>
<body>
	<div id="demo">
		<s:iterator value="listSegmentoAnamnesis" id="data" var="segana" status="stat">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr><td>
					<h1>
						<input type="checkbox" id="segana_${stat.index}" onchange="javascript:cambioView(${stat.index});"/>
						<s:property value="#segana.seanEtiqueta"/>
					</h1>
				</td></tr>
			</table>
			<div id="segmentoAnamnesis_${stat.index}" style="overflow:auto;width:auto;height:auto;display:none">
				<s:if test="#segana.preguntas!=null&&#segana.preguntas.size()>0">
					<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].seanEtiqueta" value="%{#segana.seanEtiqueta}"/>
					<s:iterator value="#segana.preguntas" id="dataPreg" var="preg" status="statPreg">
						<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].pregPregunta" value="%{#preg.pregPregunta}"/>
						<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].pregId" value="%{#preg.pregId}"/>
						<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].pregTipodato" value="%{#preg.pregTipodato}"/>
						<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].pregRespobligatoria" value="%{#preg.pregRespobligatoria}"/>
						<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].tipopregunta.tiprEtiqueta" value="%{#preg.tipopregunta.tiprEtiqueta}"/>
						<s:hidden name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].pregObjetoview" value="%{#preg.pregObjetoview}"/>
<!-- 						Creacion tipo pregunta abierta -->
						<s:if test="#preg.tipopregunta.tiprEtiqueta!=null&&#preg.tipopregunta.tiprEtiqueta==constanteTipoPregAbierta">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:property value="#preg.pregPregunta"/></td>
									<s:if test="#preg.pregObjetoview==constanteTipoObjetoViewTextArea">
										<td><s:textarea name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].respuestas[0].respRespuesta" cols="100" rows="3" cssClass="inputs"></s:textarea></td>
									</s:if>
									<s:elseif test="#preg.pregObjetoview==constanteTipoObjetoViewTextField">
										<td><s:textfield name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].respuestas[0].respRespuesta" size="10" cssClass="inputs"></s:textfield></td>
									</s:elseif>
								</tr>
							</table>							
						</s:if>
<!-- 						Creacion tipo pregunta multiple con multiple respuesta -->
						<s:elseif test="#preg.tipopregunta.tiprEtiqueta!=null&&#preg.tipopregunta.tiprEtiqueta==constanteTipoPregMultipleMR">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:property value="#preg.pregPregunta"/></td>
									<s:if test="#preg.pregObjetoview==constanteTipoObjetoViewCheckBox">
										<td>
											<s:hidden id="pregCheck_%{#preg.pregId}" name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].respuestas[0].respRespuesta"/> 
											<s:iterator value="#preg.opcionrespuestas" id="dataOpcres" var="resp" status="statOpcr">
												<input type="checkbox" onchange="javascrip:registroCheck(this,${preg.pregId});" value="${resp.opreValor}" ${resp.opcRespuestaCheck}/><s:property value="#resp.opreEtiqueta"/>
											</s:iterator>
										</td>
									</s:if>
								</tr>
							</table>
						</s:elseif>
<!-- 						Creacion tipo pregunta multiple con unica respuesta -->
						<s:elseif test="#preg.tipopregunta.tiprEtiqueta!=null&&#preg.tipopregunta.tiprEtiqueta==constanteTipoPregMultipleUR">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:property value="#preg.pregPregunta"/></td>
									<s:if test="#preg.pregObjetoview==constanteTipoObjetoViewSelect">
										<td><s:select name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].respuestas[0].respRespuesta" list="#preg.opcionrespuestas" listKey="opreValor" listValue="opreEtiqueta" headerKey="" headerValue=".::Seleccione::."></s:select></td>
									</s:if>
								</tr>
							</table>	
						</s:elseif>
<!-- 						Creacion tipo pregunta fecha -->
						<s:elseif test="#preg.tipopregunta.tiprEtiqueta!=null&&#preg.tipopregunta.tiprEtiqueta==constanteTipoPregFecha">							
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:property value="#preg.pregPregunta"/></td>
									<s:if test="#preg.pregObjetoview==constanteTipoObjetoViewCalendar">
										<td><s:textfield name="listSegmentoAnamnesis[%{#stat.index}].preguntas[%{#statPreg.index}].respuestas[0].respRespuesta" id="pregFecha_%{#preg.pregId}" size="15" maxlength="10" cssClass="inputs"></s:textfield></td>
										<script type="text/javascript" charset="utf-8">
											$("#pregFecha_${preg.pregId}").datepicker({changeYear: true,yearRange:'-90:+90',changeMonth: true});
										</script>
									</s:if>
								</tr>
							</table>
						</s:elseif>
					</s:iterator>
				</s:if>
			</div>
		</s:iterator>
	</div>
</body>
</html>