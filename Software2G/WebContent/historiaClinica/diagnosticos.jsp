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
			});	
			
			
			function cargarDatosDignostico(id, diagnostico){
				if(diagnostico=='0'){
					var tipoDiag = document.getElementById('tidiIdDP').value;
					$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?coenId='+id+'&claseDiag=0&tipoDiag='+tipoDiag);
					var campoFind = document.getElementById('campoFindDP');
					var repetirFind = document.getElementById('repetirFindDP');
					campoFind.style.display = 'none';
					repetirFind.style.display = 'block';
				} 
			}
				
			function repetirBusqueda(diagnostico){
				if(diagnostico=='0'){
					var divDatosDiagnosticoPP = document.getElementById('divDatosDiagnosticoPP');divDatosDiagnosticoPP.innerHTML = '';
					var campoFind = document.getElementById('campoFindDP');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFindDP');repetirFind.style.display = 'none';
					var search = document.getElementById('searchDP');search.value = '';
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
					<div id="repetirFindDP" style="overflow:auto;width:auto;height:auto;display:none">
						<input type="button" value="<s:text name="labelbutton.cambiarDiagPP"></s:text>" onclick="repetirBusqueda(0);" class="buttonSV"/>
					</div>
					<div id="campoFindDP" style="overflow:auto;width:auto;height:auto;display:block">
						<s:textfield name="dataAutoCompletado" id="searchDP" size="60" maxlength="30" cssClass="inputs"></s:textfield>
						<s:select list="listTipoDiagnostico" id="tidiIdDP" listKey="tidiId" listValue="tidiNombre" cssClass="inputs"/>
					</div>
				</td>
			</tr>
			<tr>
				<td><div id="cambiarDiagnostico"></div></td>
				<td>
					<div id="divDatosDiagnosticoPP">
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>