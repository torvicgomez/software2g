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
					
					$("#claseDiag").change(function(event){
						var id = $("#claseDiag").find(':selected').val();
						var tidiIdDP = document.getElementById('seccionTidiIdDP');
						if(id=='P'){
							tidiIdDP.style.display = 'block';
						}else if(id=='R'){
							tidiIdDP.style.display = 'none';
						}
					});
					
					
					
				});
				
				function cargarDatosDignostico(id, diagnostico){
					if(diagnostico=='P'){
						var tipoDiag = document.getElementById('tidiIdDP').value;
						$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=0&tipoDiag='+tipoDiag);
					}else if(diagnostico=='R'){
						$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=1&tipoDiag=0');
					}
					var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'none';
					var seccionTidiIdDP = document.getElementById('seccionTidiIdDP');seccionTidiIdDP.style.display = 'none';
					var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'block';
					
				}
				
				function limpiar(obj){
					obj.value='';
				}
				
				function agregarDiagnostico(){
					var search = document.getElementById('searchDP');search.value = ''; 
					var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'block';
					var seccionTidiIdDP = document.getElementById('seccionTidiIdDP');seccionTidiIdDP.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'none';
				}
				
				function cambiarDiagnostico(pos){
					$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?posicion='+pos);
					var search = document.getElementById('searchDP');search.value = ''; 
					var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'block';
					var seccionTidiIdDP = document.getElementById('seccionTidiIdDP');seccionTidiIdDP.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'none';
				}
				
		</script>
		
	</head>
	<body id="dt_example">
		<div id="demo">
			<table cellpadding="0" cellspacing="0" border="0" class="display">
				<tr>
					<td class="leftLabel"><s:text name="diagnosticos.principal"></s:text></td>
					<td>
						<div id="campoFindDP" style="overflow:auto;width:auto;height:auto;display:block">
							<s:textfield id="searchDP" size="60" maxlength="30" cssClass="inputs" onfocus="javascript:limpiar(this);"></s:textfield>
							<s:select list="listClaseDiagnostico" listKey="key" listValue="valor" id="claseDiag" cssClass="inputs"/>
						</div>	
						<div id="repetirFindDP" style="overflow:auto;width:auto;height:auto;display:none">
							<input type="button" value="<s:text name="labelbutton.agregarDiag"></s:text>" onclick="agregarDiagnostico();" class="buttonSV"/>
						</div>
					</td>
					<td align="left">
						<div id="seccionTidiIdDP" style="overflow:auto;width:auto;height:auto;display:block">
							<s:select list="listTipoDiagnostico" id="tidiIdDP" listKey="tidiId" listValue="tidiNombre" cssClass="inputs"/>
						</div>
					</td>
				</tr>
				<tr>
					<td><div id="cambiarDiagnostico"></div></td>
					<td colspan="2">
						<div id="divDatosDiagnosticoPP">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td colspan="2">
										<s:if test="listDiagnostico!=null&&listDiagnostico.size()>0">
											<table cellpadding="0" cellspacing="0" border="0" class="display">
												<s:iterator value="listDiagnostico" id="data" status="stat">
													<tr>
														<td>[<s:property value="codigoenfermedade.coenCodigo"/>]&nbsp;<s:property value="codigoenfermedade.coenNombre"/></td>
														<td><s:property value="clasediagnostico.cldiNombre"/></td>
														<td><s:property value="tipodiagnostico.tidiNombre"/></td>
														<td><input type="button" value="Cambiar" onClick="cambiarDiagnostico('${stat.index}');" class="buttonSV"/></td>
													</tr>
												</s:iterator>
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
