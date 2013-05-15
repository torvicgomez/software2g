<%@page import="com.software2g.util.ValidaString"%>
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
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT> 
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
	<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
	<script type="text/javascript" charset="ISO-8859-1"> 
	$(document).ready(function() {
			$('#presupuestosTable').dataTable( { 
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
	
	$(document).ready(function(){
        $("#selectEntidades").change(function(event){
            var id = $("#selectEntidades").find(':selected').val();
            $("#razonSocial").val($("#selectEntidades").find(':selected').text());
            $("#donacionDescrip").val('');
            $("#montoDonado").html("");
            $("#donacionEntidad").load('cmbDonacionesEnt.action?donacionVO.entidaddonante.endoId='+id);
        });
	});
	
	function editar(idPresupuesto){
		document.form.action="editarPresupuesto.action?id="+idPresupuesto;
		document.form.submit();
	}
	
	function eliminarPresupuestoDona(pos){
		document.form.action="delPresupuestoDonacion.action?pos="+pos;
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
						<s:hidden name="presupuestoVO.presId"></s:hidden>
						<h1><strong><s:text name="titulo.presupuesto"></s:text></strong></h1>
						<s:if test="estado==null||estado=='listarPresupuesto'">
							<s:submit value="Crear Presupuesto" cssClass="button" action="crearPresupuesto"></s:submit>
						</s:if>
						<s:elseif test="estado=='crearPresupuesto'">
							<s:submit value="Cancelar" action="listPresupuesto" cssClass="button"></s:submit>
							<s:submit value="Aplicar Cambios" action="savePresupuesto" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarPresupuesto'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="presupuestosTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.dtll"></s:text>
										</th>
										<th align="left"  width="5%">
											<s:text name="columna.vinculos"></s:text>
										</th>
										<th align="left"  width="45%">
											<s:text name="presupuesto.nombre"></s:text>
										</th>
										<th align="left"  width="25%">
											<s:text name="presupuesto.valor"></s:text>
										</th>
										<th align="left" width="20%">
											<s:text name="presupuesto.fechahoraregistro"></s:text>
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listPresupuesto" id="data">
									<tr>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="presId"/>');">Editar</a>
										</td>
										<td width="5%">
											<a onclick="javascript:editar('<s:property value="presId"/>');">Vincular</a>
										</td>
										<td width="55%">
											<s:property value="presDescripcion"/>
										</td>
										<td width="20%">
											<!--<s:property value="presValor"/>--><s:property value="presValorString"/>
										</td>
										<td width="20%">
											<s:property value="presFechamodificacion"/>/<s:property value="presHora"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				<s:elseif test="estado=='crearPresupuesto'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="presupuesto.nombre"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="presupuestoVO.presDescripcion" size="50" maxlength="40"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="presupuesto.valor"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<strong><font size="3" color="#FF0000"><s:property value="presupuestoVO.presValorString"/></font></strong>
										<s:hidden name="presupuestoVO.presValor"></s:hidden>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<h1><strong><s:text name="titulo.donacion"></s:text></strong></h1>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="donacionEntidadTable">
							<thead>
								<tr>
									<th align="left"  width="30%">
										<s:text name="presupuesto.entidaddonante"></s:text>
									</th>
									<th align="left"  width="45%">
										<s:text name="presupuesto.descripciondonacion"></s:text>
									</th>
									<th align="left"  width="15%">
										<s:text name="presupuesto.valor"></s:text>
									</th>
									<th align="left"  width="10%">
										<s:text name="columna.agregar"></s:text>
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="40%">
										<s:hidden name="donacionVO.entidaddonante.endoRazonsocial" id="razonSocial"></s:hidden>
										<s:hidden name="donacionVO.donaDescripcion" id="donacionDescrip"></s:hidden>
										<s:select list="listEntidades" name="donacionVO.entidaddonante.endoId" id="selectEntidades" listKey="endoId" listValue="endoRazonsocial" headerKey="-1" headerValue=".::Seleccion::."/>
									</td>
									<td width="40%">
										<div id="donacionEntidad" style="overflow:auto;width:auto;height:auto;display:block">
											<strong><font size="2" color="#FF0000">Seleccione una Entidad</font></strong>
										</div>
									</td>
									<td width="40%">
										<div id="montoDonado" style="overflow:auto;width:auto;height:auto;display:block">
											<s:property value="donacionVO.donaValor"/>
										</div>
									</td>
									<td width="40%">
										<s:submit value="Agregar" action="addPresupuestoDonacion" cssClass="button" id="addPresDonacion"></s:submit>
									</td>
								</tr>
							</tbody>
							<tr>
								<td colspan="4">
									<h1></h1>
									<table border="0" width="100%">
										<s:if test="listPresupuestoDonaVO!=null">
										<%int cont=0; %>
										<s:iterator value="listPresupuestoDonaVO" id="dataPresupuestoDona">
											<tr>
												<td width="40%" align="left" valign="top">
													<s:property value="donacion.entidaddonante.endoRazonsocial"/>
												</td>
												<td width="40%" align="left" valign="top">
													<s:property value="donacion.donaDescripcion"/>
												</td>
												<td width="40%" align="right" valign="top">
													<strong><font size="4" color="#FF0000">$<s:property value="prdoMontoStrig"/></font></strong>
												</td>
												<td width="20%" align="left" valign="top">
													<s:if test="presupuestoVO.presValor>=prdoMonto">
														<input type="button" value="Eliminar" class="button" onclick="javascript:eliminarPresupuestoDona('<%=cont%>')" />
													</s:if>
													<s:else>
														No Aplica
													</s:else>
												</td>
											</tr>
											<%cont++;%>
										</s:iterator>
										</s:if>
									</table>
								</td>
							<tr>
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
