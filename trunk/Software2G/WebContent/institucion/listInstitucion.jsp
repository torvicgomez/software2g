<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
	<link href="<s:url value='/syntax/css/shCore.css'/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
	<script type="text/javascript" charset="ISO-8859-1"> 
	$(document).ready(function() {
			$('#institucionTable').dataTable( { 
				"sPaginationType": "full_numbers",
				"bLengthChange": true,
				"bFilter": true,
				"bSort": true,
				"bInfo": true,
				"bAutoWidth": true,
				"oLanguage": {
					//"sLengthMenu": "Mostrar MENU Registros por pagina",
					"sZeroRecords": "No se encontraron registros",
					//"sInfo": "Mostrando START a END de TOTAL registros",
					"sInfoEmpty": "Mostrando 0 a 0 de 0 registros",
					"sInfoFiltered": "(Filtrado desde MAX registros totales)",
					"sSearch": "Buscar: ",
					"oPaginate": {
						"sFirst": "Primero",
						"sLast": "Ultimo",
						"sNext": "Siguiente",
						"sPrevious": "Anterior"
					}
				}
			} );
	} );
	
	function editar(idPersona){
		document.form.action="editarPersonal.action?id="+idPersona;
		document.form.submit();
	}
	
	</script>
</head>
<body id="dt_example">
		<s:form id="form">
		<div id="demo">
			<table border="0" width="100%" align="center">
				<tr>
					<td>
						<h1><strong><s:text name="titulo.personal"></s:text></strong></h1>
						<s:submit value="Crear Institución" cssClass="button" action="crearPersona"></s:submit>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<table cellpadding="0" cellspacing="0" border="0" class="display" id="institucionTable">
							<thead>
								<tr>
									<th align="left"  width="5%">
										<s:text name="columna.dtll"></s:text>
									</th>
									<th align="left"  width="15%">
										<s:text name="personal.numerodocumento"></s:text>
									</th>
									<th align="left" width="55%">
										<s:text name="personal.nombreCompleto"></s:text>
									</th>
									<th align="left" width="25%">
										<s:text name="personal.email"></s:text>
									</th>
								</tr>
							</thead>
							<tbody>
							<s:iterator value="listInstitucion" id="data">
								<tr>
									<td width="5%">
										<a onclick="javascript:editar('<s:property value="idInst"/>');">Editar</a>
									</td>
									<td width="25%">
										<s:property value="documentoPers"/>&nbsp;<s:property value="tipodocumento.abreviaturaTidoc"/>
									</td>
									<td width="45%">
										<s:property value="pnombrePers"/>&nbsp;<s:property value="snombrePers"/>&nbsp;<s:property value="papellidoPers"/>&nbsp;<s:property value="sapellidoPers"/>
									</td>
									<td width="25%">
										<s:property value="emailPers"/>
									</td>
								</tr>
							</s:iterator>
							</tbody>
						</table>
					</td>
				</tr> 
			</table>
			</div>
			<div class="spacer"></div>
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>