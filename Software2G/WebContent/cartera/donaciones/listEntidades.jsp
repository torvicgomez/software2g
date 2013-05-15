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
			$('#entidadTable').dataTable( { 
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
	
	function editar(idSucursal){
		document.form.action="editarEntidad.action?id="+idSucursal;
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
						<s:hidden name="estado"></s:hidden>
						<h1><strong><s:text name="titulo.entidad"></s:text></strong></h1>
						<s:if test="estado==null||estado=='listarEntidades'">
							<s:submit value="Crear Entidad Donante" cssClass="button" action="crearEntidad"></s:submit>
						</s:if>
						<s:elseif test="estado=='crearEntidad'">
							<s:hidden name="entidadVO.endoId"></s:hidden>
							<s:submit value="Cancelar" action="listEntidadDonante" cssClass="button"></s:submit>
							<s:submit value="Aplicar Cambios" action="saveEntidad" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarEntidades'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="entidadTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.dtll"></s:text>
										</th>
										<th align="left" width="20%">
											<s:text name="entidad.nit"></s:text>
										</th>
										<th align="left"  width="30%">
											<s:text name="entidad.razonsocial"></s:text>
										</th>
										<th align="left" width="30%">
											<s:text name="entidad.representante"></s:text>
										</th>
										<th align="left" width="15%">
											<s:text name="entidad.fechahoraregistro"></s:text>
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listEntidades" id="data">
									<tr>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="endoId"/>');">Editar</a>
										</td>
										<td width="20%">
											<s:property value="endoNit"/>
										</td>
										<td width="30%">
											<s:property value="endoRazonsocial"/>
										</td>
										<td width="30%">
											<s:property value="endoRepresentantelegal"/>
										</td>
										<td width="15%">
											<s:property value="endoFechamodificacion"/>/<s:property value="endoHora"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				<s:elseif test="estado=='crearEntidad'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="entidad.nit"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="entidadVO.endoNit" size="20" maxlength="15"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text" align="left" valign="top">
										<s:text name="entidad.razonsocial"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" align="left"  valign="top">
										<s:textfield name="entidadVO.endoRazonsocial" size="40"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text" align="left" valign="top">
										<s:text name="entidad.representante"></s:text>
									</td>
									<td class="text" align="left"  valign="top">
										<s:textfield name="entidadVO.endoRepresentantelegal" size="40"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="entidad.descripcion"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:textarea name="entidadVO.endoDescripcion" cols="50" rows="3"></s:textarea>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:elseif>
			</table>
			</div>
			<div class="spacer"></div>
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>