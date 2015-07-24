<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" charset="utf-8">
				$(function() {
	          		$("#searchDP").autocomplete({
	               		source : function(request, response) {
	                		$.ajax({
	                        	url : "SearchController",
	                        	type : "GET",
	                        	data : {
	                                term : request.term,
	                                tipo : 'diagnostico',
	                                especialidad: document.getElementById('profEspecialidad').value,
	                                diagnostico: document.getElementById('claseDiag').value
	                        	},
	                        	dataType : "json",
	                        	success : function(data) {
	                                	response(data);
	                        	}
	                		});
	       				}
					});
				});
				
				function cargarDatosDignostico(id, diagnostico){
					if(diagnostico=='P'){
						var tipoDiag = document.getElementById('tidiIdDP').value;
						$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=0&tipoDiag='+tipoDiag);
						//var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'none';
						//var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'block';
						//document.form.action="servicioclinico.action?estado=ConstantesAplicativo.constanteEstadoAddGrid%>&tipo="+tipoAdd+"#tabs-5";
						//document.form.submit();
					}else if(diagnostico=='R'){
						$("#divDatosDiagnosticoRL1").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=1&tipoDiag=0');
						//var campoFind = document.getElementById('campoFindDR1');campoFind.style.display = 'none';
						//var repetirFind = document.getElementById('repetirFindDR1');repetirFind.style.display = 'block';
					}
					var search = document.getElementById('searchDP');search.value = '';
				}
		</script>
		
	</head>
	<body id="dt_example">
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr>
					<td class="leftLabel"><s:text name="diagnosticos.principal"></s:text></td>
					<td>
						<s:textfield name="diagnostico." id="searchDP" size="60" maxlength="30" cssClass="inputs"></s:textfield>
						<s:select list="#{'P':'Principla','R':'Relacionado'}" id="claseDiag" cssClass="inputs"/>
						<s:select list="listTipoDiagnostico" id="tidiIdDP" listKey="tidiId" listValue="tidiNombre" cssClass="inputs"/>
					</td>
				</tr>
				<tr>
					<td><div id="cambiarDiagnostico"></div></td>
					<td>
						<div id="divDatosDiagnosticoPP">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td colspan="2">
										<s:if test="listDiagnostico!=null&&listDiagnostico.size()>0">
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
<!-- 												<tbody> -->
<%-- 													<s:iterator value="listDiagnostico" id="data" status="stat"> --%>
<!-- 														<tr> -->
<%-- 															<td>${stat.index+1}</td> --%>
<%-- 															<td><s:property value="mediMedicamento"/></td> --%>
<%-- 															<td><s:property value="mediPresentacion"/></td> --%>
<%-- 															<td><s:property value="mediCantidad"/></td> --%>
<%-- 															<td><s:property value="mediDosis"/></td> --%>
<%-- 															<td><s:property value="mediIntervalo"/></td> --%>
<%-- 															<td class="right"><input type="button" value="<s:text name="labelbutton.eliminarMedicamento"></s:text>" onclick="eliminarGrilla('${stat.index}','<%=ConstantesAplicativo.constanteTipoGridMedicamentos%>');" class="buttonSV"/></td> --%>
<!-- 														</tr> -->
<%-- 													</s:iterator> --%>
<!-- 												</tbody> -->
											</table>	
										</s:if>
										<s:else><s:text name="advertencia.noregistros"></s:text></s:else>	
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
