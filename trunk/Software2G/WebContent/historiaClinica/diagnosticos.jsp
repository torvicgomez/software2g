<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" charset="utf-8">
			$(function() {
          		$("#search").autocomplete({
               		source : function(request, response) {
                		$.ajax({
                        	url : "SearchController",
                        	type : "GET",
                        	data : {
                                term : request.term,
                                tipo : 'diagnostico',
                                especialidad: '2',
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
					$("#divDatosDiagnosticoPP").load('cargarDatosDiagnostico.action?coenId='+id);
					var campoFind = document.getElementById('campoFind');
					var repetirFind = document.getElementById('repetirFind');
					campoFind.style.display = 'none';
					repetirFind.style.display = 'block';
				} 
			}
				
			function repetirBusqueda(){
				var divDatosDiagnosticoPP = document.getElementById('divDatosDiagnosticoPP');
				divDatosDiagnosticoPP.innerHTML = '';
				
				var campoFind = document.getElementById('campoFind');
				var repetirFind = document.getElementById('repetirFind');
				campoFind.style.display = 'block';
				repetirFind.style.display = 'none';
				var search = document.getElementById('search');
				search.value = '';
			}
	</script>
</head>
<body>
	<div id="demo">
		<table cellpadding="0" cellspacing="0" border="0" class="display">
			<tr>
				<td class="leftLabel"><s:text name="diagnosticos.principal"></s:text></td>
				<td>
					
					<div id="repetirFind" style="overflow:auto;width:auto;height:auto;display:none">
						<input type="button" value="<s:text name="labelbutton.repetirfind"></s:text>" onclick="repetirBusqueda();" class="buttonSV"/>
					</div>
					<div id="campoFind" style="overflow:auto;width:auto;height:auto;display:block">
						<s:textfield name="dataAutoCompletado" id="search" size="60" maxlength="30" cssClass="inputs"></s:textfield>
					</div>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="divDatosDiagnosticoPP">
						
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>