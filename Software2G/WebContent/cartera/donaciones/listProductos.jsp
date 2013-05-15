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
			$('#productosTable').dataTable( { 
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
	
	function editar(idObjeto){
		document.form.action="editarObjeto.action?id="+idObjeto;
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
						<h1><strong><s:text name="titulo.objeto"></s:text></strong></h1>
						<s:if test="estado==null||estado=='listarObjetos'">
							<s:submit value="Crear Productos Aplicar Donacion" cssClass="button" action="crearObjeto"></s:submit>
						</s:if>
						<s:elseif test="estado=='crearObjeto'">
							<s:hidden name="objetoVO.objeId"></s:hidden>
							<s:submit value="Cancelar" action="listObjetos" cssClass="button"></s:submit>
							<s:submit value="Aplicar Cambios" action="saveObjeto" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarObjetos'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="productosTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.dtll"></s:text>
										</th>
										<th align="left"  width="80%">
											<s:text name="objeto.motivo"></s:text>
										</th>
										<th align="left" width="15%">
											<s:text name="objeto.fechahoraregistro"></s:text>
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listObjetos" id="data">
									<tr>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="objeId"/>');">Editar</a>
										</td>
										<td width="80%">
											<s:property value="objeMotivo"/>
										</td>
										<td width="15%">
											<s:property value="objeFechamodificacion"/>/<s:property value="objeHora"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				<s:elseif test="estado=='crearObjeto'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="objeto.motivo"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="objetoVO.objeMotivo" size="30"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="objeto.descripcion"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:textarea name="objetoVO.objeDescripcion" cols="50" rows="3"></s:textarea>
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
