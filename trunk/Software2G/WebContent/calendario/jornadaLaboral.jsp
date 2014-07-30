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
			$('#parametrosCalendario').dataTable( { 
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
	
	function agregar(){
		document.form.action="paramCalendario.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
		document.form.submit();
	}
	
	function registrar(){
		document.form.action="paramCalendario.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
		document.form.submit();
	}
	
	function volver(){
		document.form.action="paramCalendario.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
		document.form.submit();
	}
	
	function detalle(param){
		document.form.action="paramCalendario.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
		document.form.submit();
	}
	
	function resumen(param){
		document.form.action="paramCalendario.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
		document.form.submit();
	}
	
	</script>
</head>
<body id="dt_example">
		<s:form id="form">
		<s:hidden name="funcPosicionado"></s:hidden>
		<div id="demo">
				<table border="0" width="100%" align="center">
					<tr><td><h1><strong><s:text name="titulo.paramCalendario"></s:text></strong></h1></td></tr>
					<s:if test="estado=='all'">
						<tr><td class="css_right">
							<input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregar();" class="buttonSV"/>
						</td></tr>
					</s:if>
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="estado=='abstract'">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<s:if test="estado==null||estado=='all'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="parametrosCalendario">
						<thead>
							<tr>
								<th align="left"  width="30%"><s:text name="columna.edit"></s:text></th>
								<th align="left"  width="30%"><s:text name="paramCalendario.variable"></s:text></th>
								<th align="left"  width="10%"><s:text name="paramCalendario.valor"></s:text></th>
								<th align="left"  width="15%"><s:text name="paramCalendario.fechahoraregistro"></s:text></th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="listParametroCalendrio" id="data">
							<tr>
								<td width="5%"><a onclick="javascript:detalle('<s:property value="pacaId"/>');">Editar</a></td>
								<td width="20%"><s:property value="pacaVariable"/></td>
								<td width="20%"><s:property value="pacaValor"/></td>
								<td width="35%"><s:property value="pacaFechacambio"/> - <s:property value="pacaHoracambio"/></td>
							</tr>
						</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="paramCalendario.variable"></s:text></td>
							<td>
								<s:hidden name="parametroCalendario.pacaId" id="pacaId"></s:hidden>
								<s:textfield name="parametroCalendario.pacaVariable" id="pacaVariable" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="paramCalendario.valor"></s:text></td>
							<td>
								<s:textfield name="parametroCalendario.pacaValor" id="pacaValor" size="30" maxlength="30" cssClass="inputs"></s:textfield>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
				<s:elseif test="estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel" width="130"><s:text name="paramCalendario.variable"></s:text></td>
							<td class="text"><s:property value="parametroCalendario.pacaVariable"/></td>
						</tr>
						<tr>
							<td class="leftLabel" width="130"><s:text name="paramCalendario.valor"></s:text></td>
							<td class="text"><s:property value="parametroCalendario.pacaValor"/></td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="css_right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
			<script type="text/javascript" language="javascript" src="<s:url value='/syntax/js/shCore.js'/>"></script>
		</s:form>
	</body>
</html>
