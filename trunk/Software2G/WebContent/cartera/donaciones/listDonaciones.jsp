<%@page import="com.software2g.util.ConstantesAplicativo"%>
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
			$('#donacionesTable').dataTable( { 
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
        $("#addProdDonacion").click(function(){
            $("#divProductosDonacion").load('addProductosDonacion.action');
        });
    });    
        
	function setNombreProc(obj){
		document.getElementById("nombreProc").value=obj.options[obj.selectedIndex].text;
	}     
	
	function setEstadoProc(obj){
		document.getElementById("estadoProc").value=obj.options[obj.selectedIndex].text;
	}
	
	function eliminarProc(pos){
		document.form.action="delProductosDonacion.action?pos="+pos;
		document.form.submit();
	}
	
	function editar(idDonacion){
		document.form.action="editarDonacion.action?id="+idDonacion;
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
						<s:hidden name="donacionVO.donaId"></s:hidden>
						<h1><strong><s:text name="titulo.donacion"></s:text></strong></h1>
						<s:if test="estado==null||estado=='listarDonanciones'">
							<s:submit value="Crear Donación" cssClass="button" action="crearDonacion"></s:submit>
						</s:if>
						<s:elseif test="estado=='crearDonacion'">
							<s:submit value="Cancelar" action="listDonaciones" cssClass="button"></s:submit>
							<s:submit value="Aplicar Cambios" action="saveDonacion" cssClass="button"></s:submit>
						</s:elseif>
						<s:elseif test="estado=='verDonacion'">
							<s:submit value="Volver" action="listDonaciones" cssClass="button"></s:submit>
						</s:elseif>
					</td>
				</tr>
				<s:if test="estado==null||estado=='listarDonanciones'">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="donacionesTable">
								<thead>
									<tr>
										<th align="left"  width="5%">
											<s:text name="columna.dtll"></s:text>
										</th>
										<th align="left"  width="35%">
											<s:text name="donacion.entidaddonante"></s:text>
										</th>
										<th align="left"  width="20%">
											<s:text name="donacion.productoest"></s:text>
										</th>
										<th align="left"  width="20%">
											<s:text name="donacion.valor"></s:text>
										</th>
										<th align="left" width="20%">
											<s:text name="donacion.fechahoraregistro"></s:text>
										</th>
									</tr>
								</thead>
								<tbody>
								<s:iterator value="listDonaciones" id="data">
									<tr>
										<td width="5%">
											<s:if test="donaEstado=='DONACION'">
												<a onclick="
												javascript:editar('<s:property value="donaId"/>');">Editar</a>
											</s:if>
											<s:elseif test="donaEstado=='PRESUPUESTO'">
												<a onclick="javascript:editar('<s:property value="donaId"/>');">Ver</a>
											</s:elseif>
										</td>
										<td width="35%">
											<s:property value="entidaddonante.endoRazonsocial"/>
										</td>
										<td width="20%">
											<s:property value="donaEstado"/>
										</td>
										<td width="20%">
											<s:property value="donaValor"/>
										</td>
										<td width="20%">
											<s:property value="donaFechamodificacion"/>/<s:property value="donaHora"/>
										</td>
									</tr>
								</s:iterator>
								</tbody>
							</table>
						</td>
					</tr>
				</s:if>
				<s:elseif test="estado=='crearDonacion'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="donacion.entidaddonante"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:select list="listEntidades" name="donacionVO.entidaddonante.endoId" listKey="endoId" listValue="endoRazonsocial" headerKey="-1" headerValue=".::Seleccione::." />
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="donacion.fechadonacion"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="donacionVO.donaFecha" id="fechadonacionEnt" size="15" maxlength="10"></s:textfield>
										<img alt="Fecha Donación" src="<s:url value="/imagenes/calendario.gif"/>" onclick="showCalendar('fechadonacionEnt', 'y-mm-dd');">(yyyy-mm-dd)
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="donacion.valor"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:textfield name="donacionVO.donaValor" size="30"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="donacion.descripcion"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:textarea name="donacionVO.donaDescripcion" cols="50" rows="3"></s:textarea>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<h1><strong><s:text name="donacion.productos"></s:text></strong></h1>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="productosDonacionTable">
							<thead>
								<tr>
									<th align="left"  width="40%">
										<s:text name="objeto.motivo"></s:text>
									</th>
									<th align="left"  width="40%">
										<s:text name="donacion.productoest"></s:text>
									</th>
									<th align="left"  width="20%">
										<s:text name="columna.agregar"></s:text>
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="40%">
									    <s:hidden name="donacionObjetoVO.nombreObjeto" id="nombreProc"></s:hidden>
									    <s:hidden name="donacionObjetoVO.estadoText" id="estadoProc"></s:hidden>
										<s:select list="listObjetos" name="donacionObjetoVO.id.objeId" listKey="objeId" listValue="objeMotivo" headerKey="-1" headerValue=".::Seleccione::." onchange="javascript:setNombreProc(this);"/>
									</td>
									<td width="40%">
										<s:select list="#{'1':'ACTIVA','0':'INACTIVA'}" name="donacionObjetoVO.obdoEstado" headerKey="-1" headerValue=".::Seleccion::." onchange="javascript:setEstadoProc(this);"/>
									</td>
									<td width="20%">
										<s:submit value="Agregar" action="addProductosDonacion" cssClass="button" id="addProdDonacion"></s:submit>
										<!--<input type="button" value="Agregar" class="button" id="addProdDonacion">-->
									</td>
								</tr>
							</tbody>
							<tr>
								<td colspan="3">
									<!-- <div id="divProductosDonacion" style="overflow:auto;width:auto;height:auto;display:none"></div>-->
									<h1></h1>
									<table border="0" width="100%">
									<!-- listDonancionObjeto -->
									<!-- donacionVO.donacionobjetos -->
										<s:if test="listDonancionObjeto!=null">
										<%int cont=0; %>
										<s:iterator value="listDonancionObjeto" id="dataProdDona">
											<tr>
												<td width="40%" align="left" valign="top">
													<s:property value="id.objeId"/>
													<s:if test="nombreObjeto==null">-&nbsp;<s:property value="objeto.objeMotivo"/></s:if>
													<s:else>-&nbsp;<s:property value="nombreObjeto"/></s:else>
												</td>
												<td width="40%" align="left" valign="top">
													<s:if test="estadoText==null">
														<s:if test="obdoEstado==1">ACTIVA</s:if>
														<s:elseif test="obdoEstado==0">INACTIVA</s:elseif>
													</s:if>
													<s:else><s:property value="estadoText"/></s:else>
												</td>
												<td width="20%" align="left" valign="top">
													<!--<s:submit value="Eliminar" action="addProductosDonacion" cssClass="button" id="addProdDonacion"></s:submit>-->
													<input type="button" value="Eliminar" class="button" onclick="javascript:eliminarProc('<%=cont%>')" />
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
				<s:elseif test="estado=='verDonacion'">
					<tr>
						<td valign="top">
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="donacion.entidaddonante"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:property value="donacionVO.entidaddonante.endoRazonsocial"/>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="donacion.fechadonacion"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:property value="donacionVO.donaFecha"/>
									</td>
								</tr>
								<tr>
									<td class="text" width="20%" align="left" valign="top">
										<s:text name="donacion.valor"></s:text>
									</td>
									<td class="text" width="80%" align="left"  valign="top">
										<s:property value="donacionVO.donaValorString"/>
									</td>
								</tr>
								<tr>
									<td class="text"  valign="top">
										<s:text name="donacion.descripcion"></s:text>
									</td>
									<td class="text"  valign="top">
										<s:property value="donacionVO.donaDescripcion"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<h1><strong><s:text name="donacion.productos"></s:text></strong></h1>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" class="display" id="productosDonacionTable">
							<thead>
								<tr>
									<th align="left"  width="40%">
										<s:text name="objeto.motivo"></s:text>
									</th>
								</tr>
							</thead>
							<tr>
								<td colspan="3">
									<h1></h1>
									<table border="0" width="100%">
										<s:if test="listDonancionObjeto!=null">
										<s:iterator value="listDonancionObjeto" id="dataProdDona">
											<tr>
												<td width="40%" align="left" valign="top">
													<s:property value="id.objeId"/>
													<s:if test="nombreObjeto==null">-&nbsp;<s:property value="objeto.objeMotivo"/></s:if>
													<s:else>-&nbsp;<s:property value="nombreObjeto"/></s:else>
												</td>
											</tr>
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
