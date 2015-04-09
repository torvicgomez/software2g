<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                                diagnostico: '0'
                        	},
                        	dataType : "json",
                        	success : function(data) {
                                	response(data);
                        	}
                		});
       				}
				});
				
				$("#searchDR1").autocomplete({
               		source : function(request, response) {
                		$.ajax({
                        	url : "SearchController",
                        	type : "GET",
                        	data : {
                                term : request.term,
                                tipo : 'diagnostico',
                                especialidad: document.getElementById('profEspecialidad').value,
                                diagnostico: '1'
                        	},
                        	dataType : "json",
                        	success : function(data) {
                                	response(data);
                        	}
                		});
       				}
				});
				
				$("#searchDR2").autocomplete({
               		source : function(request, response) {
                		$.ajax({
                        	url : "SearchController",
                        	type : "GET",
                        	data : {
                                term : request.term,
                                tipo : 'diagnostico',
                                especialidad: document.getElementById('profEspecialidad').value,
                                diagnostico: '2'
                        	},
                        	dataType : "json",
                        	success : function(data) {
                                	response(data);
                        	}
                		});
       				}
				});
				
				$("#searchDR3").autocomplete({
               		source : function(request, response) {
                		$.ajax({
                        	url : "SearchController",
                        	type : "GET",
                        	data : {
                                term : request.term,
                                tipo : 'diagnostico',
                                especialidad: document.getElementById('profEspecialidad').value,
                                diagnostico: '3'
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
				if(diagnostico=='0'){
					var tipoDiag = document.getElementById('tidiIdDP').value;
					$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=0&tipoDiag='+tipoDiag);
					var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'none';
					var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'block';
				}else if(diagnostico=='1'){
					$("#divDatosDiagnosticoRL1").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=1&tipoDiag=0');
					var campoFind = document.getElementById('campoFindDR1');campoFind.style.display = 'none';
					var repetirFind = document.getElementById('repetirFindDR1');repetirFind.style.display = 'block';
				}else if(diagnostico=='2'){
					$("#divDatosDiagnosticoRL2").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=2&tipoDiag=0');
					var campoFind = document.getElementById('campoFindDR2');campoFind.style.display = 'none';
					var repetirFind = document.getElementById('repetirFindDR2');repetirFind.style.display = 'block';
				}else if(diagnostico=='3'){
					$("#divDatosDiagnosticoRL3").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=3&tipoDiag=0');
					var campoFind = document.getElementById('campoFindDR3');campoFind.style.display = 'none';
					var repetirFind = document.getElementById('repetirFindDR3');repetirFind.style.display = 'block';
				}   
			}
				
			function repetirBusqueda(diagnostico){
				if(diagnostico=='0'){
					var divDatosDiagnosticoPP = document.getElementById('divDatosDiagnosticoPP');divDatosDiagnosticoPP.innerHTML = '';
					var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'none';
					var search = document.getElementById('searchDP');search.value = '';
				}else if(diagnostico=='1'){
					var divDatosDiagnosticoPP = document.getElementById('divDatosDiagnosticoRL1');divDatosDiagnosticoPP.innerHTML = '';
					var campoFind = document.getElementById('campoFindDR1');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDR1');repetirFind.style.display = 'none';
					var search = document.getElementById('searchDR1');search.value = '';
				}else if(diagnostico=='2'){
					var divDatosDiagnosticoPP = document.getElementById('divDatosDiagnosticoRL2');divDatosDiagnosticoPP.innerHTML = '';
					var campoFind = document.getElementById('campoFindDR2');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDR2');repetirFind.style.display = 'none';
					var search = document.getElementById('searchDR2');search.value = '';
				}else if(diagnostico=='3'){
					var divDatosDiagnosticoPP = document.getElementById('divDatosDiagnosticoRL3');divDatosDiagnosticoPP.innerHTML = '';
					var campoFind = document.getElementById('campoFindDR3');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDR3');repetirFind.style.display = 'none';
					var search = document.getElementById('searchDR3');search.value = '';
				}
				$("#cambiarDiagnostico").load('cambiarDiagnostico.action?diagnostico='+diagnostico);
			}
	</script>
</head>
<body>
	<div id="demo">
		<table cellpadding="0" cellspacing="0" border="0" class="display">
			<tr>
				<td class="leftLabel"><s:text name="diagnosticos.principal"></s:text></td>
				<td>
					<s:if test="listDiagnostico[0].codigoenfermedade.coenId>0"><div id="repetirFindDP" style="overflow:auto;width:auto;height:auto;display:block"></s:if>
					<s:else><div id="repetirFindDP" style="overflow:auto;width:auto;height:auto;display:none"></s:else>
						<input type="button" value="<s:text name="labelbutton.cambiarDiagPP"></s:text>" onclick="repetirBusqueda(0);" class="buttonSV"/>
					</div>
					<s:if test="listDiagnostico[0].codigoenfermedade.coenId>0"><div id="campoFindDP" style="overflow:auto;width:auto;height:auto;display:none"></s:if>
					<s:else><div id="campoFindDP" style="overflow:auto;width:auto;height:auto;display:block"></s:else>
						<s:textfield name="dataAutoCompletado" id="searchDP" size="60" maxlength="30" cssClass="inputs"></s:textfield>
						<s:select list="listTipoDiagnostico" id="tidiIdDP" listKey="tidiId" listValue="tidiNombre" cssClass="inputs"/>
					</div>
				</td>
			</tr>
			<tr>
				<td><div id="cambiarDiagnostico"></div></td>
				<td>
					<div id="divDatosDiagnosticoPP">
						<table cellpadding="0" cellspacing="0" border="0" class="display">
							<tr>
								<td><s:property value="listDiagnostico[0].codigoenfermedade.coenCodigo"/>&nbsp;<s:property value="listDiagnostico[0].codigoenfermedade.coenNombre"/></td>
								<td><s:property value="listDiagnostico[0].tipodiagnostico.tidiNombre"/></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td class="leftLabel"><s:text name="diagnosticos.relacionado1"></s:text></td>
				<td>
					<s:if test="listDiagnostico[1].codigoenfermedade.coenId>0"><div id="repetirFindDR1" style="overflow:auto;width:auto;height:auto;display:block"></s:if>
					<s:else><div id="repetirFindDR1" style="overflow:auto;width:auto;height:auto;display:none"></s:else>
						<input type="button" value="<s:text name="labelbutton.cambiarDiagRL"></s:text>" onclick="repetirBusqueda(1);" class="buttonSV"/>
					</div>
					<s:if test="listDiagnostico[1].codigoenfermedade.coenId>0"><div id="campoFindDR1" style="overflow:auto;width:auto;height:auto;display:none"></s:if>
					<s:else><div id="campoFindDR1" style="overflow:auto;width:auto;height:auto;display:block"></s:else>
						<s:textfield name="dataAutoCompletado" id="searchDR1" size="60" maxlength="30" cssClass="inputs"></s:textfield>
					</div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="divDatosDiagnosticoRL1">
						<table cellpadding="0" cellspacing="0" border="0" class="display">
							<tr>
								<td><s:property value="listDiagnostico[1].codigoenfermedade.coenCodigo"/>&nbsp;<s:property value="listDiagnostico[1].codigoenfermedade.coenNombre"/></td>
								<td><s:property value="listDiagnostico[1].tipodiagnostico.tidiNombre"/></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td class="leftLabel"><s:text name="diagnosticos.relacionado2"></s:text></td>
				<td>
					<s:if test="listDiagnostico[2].codigoenfermedade.coenId>0"><div id="repetirFindDR2" style="overflow:auto;width:auto;height:auto;display:block"></s:if>
					<s:else><div id="repetirFindDR2" style="overflow:auto;width:auto;height:auto;display:none"></s:else>
						<input type="button" value="<s:text name="labelbutton.cambiarDiagRL"></s:text>" onclick="repetirBusqueda(2);" class="buttonSV"/>
					</div>
					<s:if test="listDiagnostico[2].codigoenfermedade.coenId>0"><div id="campoFindDR2" style="overflow:auto;width:auto;height:auto;display:none"></s:if>
					<s:else><div id="campoFindDR2" style="overflow:auto;width:auto;height:auto;display:block"></s:else>
						<s:textfield name="dataAutoCompletado" id="searchDR2" size="60" maxlength="30" cssClass="inputs"></s:textfield>
					</div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="divDatosDiagnosticoRL2">
						<table cellpadding="0" cellspacing="0" border="0" class="display">
							<tr>
								<td><s:property value="listDiagnostico[2].codigoenfermedade.coenCodigo"/>&nbsp;<s:property value="listDiagnostico[2].codigoenfermedade.coenNombre"/></td>
								<td><s:property value="listDiagnostico[2].tipodiagnostico.tidiNombre"/></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td class="leftLabel"><s:text name="diagnosticos.relacionado3"></s:text></td>
				<td>
					<s:if test="listDiagnostico[3].codigoenfermedade.coenId>0"><div id="repetirFindDR3" style="overflow:auto;width:auto;height:auto;display:block"></s:if>
					<s:else><div id="repetirFindDR3" style="overflow:auto;width:auto;height:auto;display:none"></s:else>
						<input type="button" value="<s:text name="labelbutton.cambiarDiagRL"></s:text>" onclick="repetirBusqueda(3);" class="buttonSV"/>
					</div>
					<s:if test="listDiagnostico[3].codigoenfermedade.coenId>0"><div id="campoFindDR3" style="overflow:auto;width:auto;height:auto;display:none"></s:if>
					<s:else><div id="campoFindDR3" style="overflow:auto;width:auto;height:auto;display:block"></s:else>
						<s:textfield name="dataAutoCompletado" id="searchDR3" size="60" maxlength="30" cssClass="inputs"></s:textfield>
					</div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="divDatosDiagnosticoRL3">
						<table cellpadding="0" cellspacing="0" border="0" class="display">
							<tr>
								<td><s:property value="listDiagnostico[3].codigoenfermedade.coenCodigo"/>&nbsp;<s:property value="listDiagnostico[3].codigoenfermedade.coenNombre"/></td>
								<td><s:property value="listDiagnostico[3].tipodiagnostico.tidiNombre"/></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>