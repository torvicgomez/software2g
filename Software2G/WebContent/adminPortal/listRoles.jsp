<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="x" uri="/struts-dojo-tags"%>
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
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT> 
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
	<script type="text/javascript" charset="ISO-8859-1"> 
	$(document).ready(function() {
			$('#listRolesTable').dataTable( { 
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
	
	</script>
</head>
<body id="dt_example">
		<s:form id="form">
		<div id="demo">
			<table border="0" width="100%" align="center">
				<tr>
					<td>
						<s:hidden name="estado"></s:hidden>	
						<h1><strong><s:text name="titulo.roles"></s:text></strong></h1>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarRoles'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="listRolesTable">
								<thead>
									<tr>
										<th align="left"  width="15%">
											<s:text name="columna.vincularfunc"></s:text>
										</th>
										<th align="left"  width="30%">
											<s:text name="roles.nombrerol"></s:text>
										</th>
										<th align="left"  width="30%">
											<s:text name="roles.descripcionrol"></s:text>
										</th>
										<th align="left"  width="10%">
											<s:text name="roles.fileconfigrol"></s:text>
										</th>
										<th align="left"  width="15%">
											<s:text name="roles.fechahoraregistro"></s:text>
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listPagare" id="data">
									<tr>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="pagaId"/>');">Editar</a>
										</td>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="pagaId"/>');">Ver</a>
										</td>
										<td width="20%">
											<s:property value="tipopagare.tipaDescripcion"/>&nbsp;(<s:property value="pagaId"/>)
										</td>
										<td width="10%">
											<s:if test="pagaEstado==\"1\"">ACTIVO</s:if>
											<s:elseif test="pagaEstado==\"0\"">INACTIVO</s:elseif>
											<!--<s:property value="pagaEstado"/>-->
										</td>
										<td width="35%">
											<s:property value="persona.pnombrePers"/>&nbsp;<s:property value="persona.snombrePers"/>&nbsp;<s:property value="persona.papellidoPers"/>&nbsp;<s:property value="persona.sapellidoPers"/>&nbsp;
											<s:property value="persona.documentoPers"/><s:property value="persona.tipodocumento.abreviaturaTidoc"/>
										</td>
										<td width="35%">
											<s:property value="pagaCodeudor"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
			</table>
			</div>
			<div class="spacer"></div>
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>
