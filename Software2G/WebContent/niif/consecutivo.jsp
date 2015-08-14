<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#consecutivo').dataTable( {
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
				
				$("#consVigencia").datepicker({numberOfMonths: 1,showButtonPanel: false, dateFormat: 'yy-mm-dd'});
				
			} );

			function agregar(){
				document.form.action="consecutivo.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="consecutivo.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="consecutivo.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="consecutivo.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="consecutivo.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
				document.form.submit();
			}
			
			function soloNumeros(e) {
				var key = e.keyCode || e.which;
				teclado = String.fromCharCode(key);
				numeros="0123456789";
				especiales = ["9", "8","37","39","46"];//array 
				teclado_especial = false;
				for(var i=0;i<especiales.length;i++){
					if(key==especiales[i])
						teclado_especial = true;
				}
				if(numeros.indexOf(teclado)==-1 && !teclado_especial)
					return false;
			}
			
		</script>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.consecutivo"></s:text></h1>
					</td></tr>
					<s:if test="estado=='all'">
						<tr><td class="right">
							<input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregar();" class="buttonSV"/>
						</td></tr>
					</s:if>
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="estado=='abstract'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<s:if test="estado=='all'||estado=='query'">
					<table cellpadding="0" cellspacing="0" border="0" class="display" id="consecutivo">
						<thead>
							<tr>
								<s:if test="estado=='all'">
									<th><s:text name="columna.edit"></s:text></th>
								</s:if>
								<s:if test="estado=='all'">
									<th><s:text name="columna.dtll"></s:text></th>
								</s:if>
								<th><s:text name="consecutivo.consecutivoinicial"></s:text></th>
								<th><s:text name="consecutivo.consecutivofinal"></s:text></th>
								<th><s:text name="consecutivo.disponible"></s:text></th>
								<th><s:text name="consecutivo.vigencia"></s:text></th>
								<th><s:text name="global.fecharegistra"></s:text></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listConsecutivo" id="data">
								<tr>
									<s:if test="estado=='all'">
										<td align="center">
											<a onclick="modificar('${data.consId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_edit.png"/>" alt="Editar" width="18" height="18">
											</a>
										</td>
										<td align="center">
											<a onclick="detalle('${data.consId}');">
												<img align="middle" src="<s:url value="/imagenes/icon_detalle.png"/>" alt="Detalle" width="18" height="18">
											</a>
										</td>
									</s:if>
									<td><s:property value="consIniconsecutivo"/></td>
									<td><s:property value="consFinconsecutivo"/></td>
									<td><s:property value="consConsecutivodis"/></td>
									<td><s:property value="consVigencia"/></td>
									<td><s:property value="consFechacambio"/>&nbsp;<s:property value="consHoracambio"/></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot></tfoot>
					</table>
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<s:hidden name="consecutivo.consId" id="consId"></s:hidden>
						<tr>
							<td class="leftLabel"><s:text name="consecutivo.consecutivoinicial"></s:text></td>
							<td colspan="3">
								<s:textfield name="consecutivo.consIniconsecutivo" id="consIniconsecutivo" size="30" maxlength="30" cssClass="inputs" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="consecutivo.consecutivofinal"></s:text></td>
							<td colspan="3">
								<s:textfield name="consecutivo.consFinconsecutivo" id="consFinconsecutivo" size="30" maxlength="30" cssClass="inputs" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield>
							</td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="consecutivo.vigencia"></s:text></td>
							<td colspan="3">
								<s:textfield name="consecutivo.consVigencia" id="consVigencia" size="15" maxlength="10" cssClass="inputs"></s:textfield>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
				<s:elseif test="estado=='abstract'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="consecutivo.consecutivoinicial"></s:text></td>
							<td><s:property value="consecutivo.consIniconsecutivo"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="consecutivo.consecutivofinal"></s:text></td>
							<td><s:property value="consecutivo.consFinconsecutivo"/></td>
						</tr>
						<tr>
							<td class="leftLabel"><s:text name="consecutivo.vigencia"></s:text></td>
							<td><s:property value="consecutivo.consVigencia"/></td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
