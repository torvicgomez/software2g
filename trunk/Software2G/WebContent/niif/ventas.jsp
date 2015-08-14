<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				
				$( "#fechaexpdocPers" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				$( "#fechanacimientoPers" ).datepicker({
					changeYear: true,
					yearRange:'-90:+90',
					changeMonth: true
				});
				
				
			} );
			
			$(function() {
				$("#pestanas").tabs();
			});
			
			jQuery(function($){
				$.datepicker.regional['es'] = {
					closeText: 'Cerrar',
					prevText: '&#x3c;Ant',
					nextText: 'Sig&#x3e;',
					currentText: 'Hoy',
					monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
					monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
					dayNames: ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
					dayNamesShort: ['Dom','Lun','Mar','Mi&eacute;','Juv','Vie','S&aacute;b'],
					dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S&aacute;'],
					weekHeader: 'Sm',
					dateFormat: 'yy-mm-dd',
					firstDay: 1,
					isRTL: false,
					showMonthAfterYear: false,
					yearSuffix: ''};
					$.datepicker.setDefaults($.datepicker.regional['es']);
				}
			);
			
			function soloNumeros(e) {
				var key = e.keyCode || e.which;
				teclado = String.fromCharCode(key);
				numeros="0123456789.";
				especiales = ["9", "8","37","39","46"];//array 
				teclado_especial = false;
				for(var i=0;i<especiales.length;i++){
					if(key==especiales[i])
						teclado_especial = true;
				}
				if(numeros.indexOf(teclado)==-1 && !teclado_especial)
					return false;
			}
			
			function calcularTotalaPagar(){
				var totalaPagarDiv = document.getElementById('totalaPagarDiv');
				var total = document.getElementById('total').value;
				var descuento = document.getElementById('totalDes');
				var iva = document.getElementById('totalIva');
				var totalaPagar = 0.0;
				if(descuento!=null && descuento!='' && iva!=null && iva!=''){
					totalaPagar = ((parseFloat(total)+parseFloat(iva.value!=''?iva.value:0))-parseFloat(descuento.value!=''?descuento.value:0));
					document.getElementById('totalaPagar').value = totalaPagar;
					var divPagoTotal = document.getElementById('pagoTotal');divPagoTotal.innerHTML = '<font size="4"><strong>'+formatNumber.formato(total, '$ ')+'</strong></font>';
					var divPagoTotalDes = document.getElementById('pagoTotalDes');divPagoTotalDes.innerHTML = '<font size="4"><strong>'+formatNumber.formato(descuento.value, '$ ')+'</strong></font>';				
					var divPagoTotalIva = document.getElementById('pagoTotalIVa');divPagoTotalIva.innerHTML = '<font size="4"><strong>'+formatNumber.formato(iva.value, '$ ')+'</strong></font>';
					var divPagoTotalPag = document.getElementById('pagoTotalPag');divPagoTotalPag.innerHTML = '<font size="4"><strong>'+formatNumber.formato(totalaPagar, '$ ')+'</strong></font>';
				}
				totalaPagarDiv.innerHTML = formatNumber.formato(totalaPagar, '$ ');
			}
			
			function repetirBusqueda(){
				var divDatosPersona = document.getElementById('divDatosArticulo');
				divDatosPersona.innerHTML = '';
				var artiId = document.getElementById('artiId');
				artiId.value = 0;
				var campoFind = document.getElementById('campoFind');
				var repetirFind = document.getElementById('repetirFind');
				campoFind.style.display = 'block';
				repetirFind.style.display = 'none';
				var search = document.getElementById('search');
				search.value = '';
			}
			
			function agregarArticulo(pos){
				var posicion = pos;
				var cantidadArti = document.getElementById("cantidadArti")!=null?document.getElementById("cantidadArti").value:'';
				var valorUniArti = document.getElementById("valorUniArti")!=null?document.getElementById("valorUniArti").value:'';
				var totalDes = document.getElementById("totalDes")==null?0:document.getElementById("totalDes").value!=''?document.getElementById("totalDes").value:0;
				var totalIva = document.getElementById("totalIva")==null?0:document.getElementById("totalIva").value!=''?document.getElementById("totalIva").value:0;
				$("#detalleVenta").load('cargarDetalleCompra.action?posicion='+posicion+'&cantidadArti='+cantidadArti+'&valorUniArti='+valorUniArti+'&totalDes='+totalDes+'&totalIva='+totalIva+'&tipo=venta');
				if(posicion<0 && cantidadArti>0 && cantidadArti!='' && valorUniArti>0 && valorUniArti!=null ){
					var divDatosPersona = document.getElementById('divDatosArticulo');divDatosPersona.innerHTML = '';
					var artiId = document.getElementById('artiId');artiId.value = 0;
					var campoFind = document.getElementById('campoFind');campoFind.style.display = 'block';
					var repetirFind = document.getElementById('repetirFind');repetirFind.style.display = 'none';
					var search = document.getElementById('search');search.value = '';
					setTimeout(function () {cargarDatosPago(totalDes,totalIva);}, 3000);
				}
			}
			
			function cargarDatosPago(totalDes,totalIva){
				var divPagoTotal = document.getElementById('pagoTotal');divPagoTotal.innerHTML = '<font size="4"><strong>'+formatNumber.formato(document.getElementById("total").value, '$ ')+'</strong></font>';
				var divPagoTotalDes = document.getElementById('pagoTotalDes');divPagoTotalDes.innerHTML = '<font size="4"><strong>'+formatNumber.formato(totalDes, '$ ')+'</strong></font>';				
				var divPagoTotalIva = document.getElementById('pagoTotalIVa');divPagoTotalIva.innerHTML = '<font size="4"><strong>'+formatNumber.formato(totalIva, '$ ')+'</strong></font>';
				var divPagoTotalPag = document.getElementById('pagoTotalPag');divPagoTotalPag.innerHTML = '<font size="4"><strong>'+formatNumber.formato(document.getElementById("totalaPagar").value, '$ ')+'</strong></font>';
			}  
			
			var formatNumber = {
				 separador: ".", // separador para los miles
				 sepDecimal: ',', // separador para los decimales
				 formatear:function (num){
				  	num +='';
				  	var splitStr = num.split('.');
				  	var splitLeft = splitStr[0];
				  	var splitRight = splitStr.length > 1 ? this.sepDecimal + splitStr[1] : '';
				  	var regx = /(\d+)(\d{3})/;
				  	while (regx.test(splitLeft)) {
				  		splitLeft = splitLeft.replace(regx, '$1' + this.separador + '$2');
				  	}
				  	return this.simbol + splitLeft  +splitRight;
				 },
				 formato:function(num, simbol){
				  	this.simbol = simbol ||'';
				  	return this.formatear(num);
				 }
			}
		
			function buscar(){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoSearch%>";
				document.form.submit();
			}
			
			function resumen(param){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&idSol="+param;
				document.form.submit();
			}
			
			function registrar(){
				var total = document.getElementById('total')==null||document.getElementById('total').value==''?'0':document.getElementById('total').value;
				var descuento = document.getElementById('totalDes')==null||document.getElementById('totalDes').value==''?'0':document.getElementById('totalDes').value;
				var iva = document.getElementById('totalIva')==null||document.getElementById('totalIva').value==''?'0':document.getElementById('totalIva').value;
				var	totalaPagar = document.getElementById('totalaPagar')==null||document.getElementById('totalaPagar').value==''?'0':document.getElementById('totalaPagar').value;
				document.getElementById('ventTotal').value = total;
				document.getElementById('ventTotaldes').value = descuento;
				document.getElementById('ventTotaliva').value = iva;
				document.getElementById('ventTotalpag').value = totalaPagar;
				document.form.action="ordencompra.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function continuar(){
				document.form.action="venta.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="venta.action?estado=<%=ConstantesAplicativo.constanteEstadoAllTipoServicio%>";
				document.form.submit();
			}
			
			function agregarGrilla(tipoAdd){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoAddGrid%>&tipo="+tipoAdd+"#tabs-5";
				document.form.submit();
				
			}
			
			function eliminarGrilla(param, tipoDel){
				document.form.action="servicioclinico.action?estado=<%=ConstantesAplicativo.constanteEstadoDeleteGrid%>&posList="+param+"&tipo="+tipoDel+"#tabs-5";
				document.form.submit();
			}
			
			 
		</script>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<td>
							<h1><s:text name="titulo.ventas"></s:text></h1>
						</td>
					</tr>
					<s:if test="estado=='all'">
						<tr><td class="right">
							<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
						</td></tr>
					</s:if>
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'||estado=='addGrid'||estado=='delGrid'">
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
					<s:elseif test="estado=='alltiposervicio'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.continuar"></s:text>" onclick="continuar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="display">
<%-- 					<s:set name="estadoCheck" value="estado"></s:set>  --%>
<%-- 						<s:hidden name="profesional.profId" id="profId"></s:hidden> --%>
<%-- 						<s:hidden name="profesional.profEspecialidad" id="profEspecialidad"></s:hidden> --%>
						<s:hidden name="venta.ventId"></s:hidden>
						<s:hidden name="venta.ventConsecutivo"></s:hidden>
						<s:hidden name="venta.ventFecha"></s:hidden>
						<s:hidden name="venta.ventHora"></s:hidden>
						<s:hidden name="persona.idPers"></s:hidden>
<%-- 						<s:hidden name="persona.existePaciente"></s:hidden> --%>
<%-- 						<s:hidden name="paciente.paciId"></s:hidden> --%>
					<tr>
						<td colspan="4" class="leftLabel"><s:text name="ventas.datosfacventa"></s:text></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="ventas.consecutivo"></s:text></td>
						<td>
							<s:property value="venta.ventConsecutivo"/>
						</td>
						<td class="leftLabel"><s:text name="ventas.fechahora"></s:text></td>
						<td>
							<s:property value="venta.ventFecha"/>/<s:property value="venta.ventHora"/>
						</td>
					</tr>
					<tr>
						<td class="leftLabel" colspan="4"><s:text name="ventas.datosvendedor"></s:text></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="personal.nombre"></s:text></td>
						<td align="left">
<%-- 							<s:property value="profesional.persona.nombreCompleto"/> --%>
								Construccion!!!				
						</td>
						<td class="leftLabel" width="130"><s:text name="ventas.codigovendedor"></s:text></td>
						<td align="left">
<%-- 							<s:property value="profesional.profEspecialidadView"/> --%>
								Construccion!!!
						</td>
					</tr>
				</table> 
				
				<s:if test="estado=='alltiposervicio'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="leftLabel"><s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text></td>
							<td>
								<s:textfield name="persona.documentoPers" size="20" maxlength="15" cssClass="inputs"></s:textfield><%--nombreTidoc --%>
								<s:select list="listTipoDoc" name="persona.tipodocumento.abreviaturaTidoc" listKey="abreviaturaTidoc" listValue="abreviaturaTidoc" cssClass="inputs"/>	
							</td>
						</tr>
					</table> 
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.continuar"></s:text>" onclick="continuar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:if>
				
				<s:elseif test="estado=='all'||estado=='edit'||estado=='save'||estado=='addGrid'||estado=='delGrid'">
					<div id="pestanas">
						<ul>
							<li><a href="#tabs-0"><s:text name="ventas.cliente"></s:text></a></li>
							<li><a href="#tabs-1"><s:text name="ventas.productos"></s:text></a></li>
							<li><a href="#tabs-2"><s:text name="ventas.pagos"></s:text></a></li>
						</ul>
						<div id="tabs-0">
							<table cellpadding="0" cellspacing="0" border="0" class="display">
								<tr>
									<td class="leftLabel"><s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text></td>
									<td>
										<s:if test="persona.existeCliente==\"S\"">
											<s:hidden name="persona.tipodocumento.idTidoc"></s:hidden>
											<s:hidden name="persona.documentoPers"></s:hidden>
											<s:property value="persona.documentoPers"/>&nbsp;<s:property value="persona.tipodocumento.abreviaturaTidoc"/>
										</s:if>
										<s:else>
											<s:textfield name="persona.documentoPers" size="20" maxlength="15" cssClass="inputs"></s:textfield><%--nombreTidoc --%>
											<s:select list="listTipoDoc" name="persona.tipodocumento.idTidoc" listKey="idTidoc" listValue="abreviaturaTidoc" cssClass="inputs"/>	
										</s:else>
									</td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.primernombre"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.pnombrePers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.segundonombre"></s:text></td>
									<td><s:textfield name="persona.snombrePers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.primerapellido"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.papellidoPers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.segundoapellido"></s:text></td>
									<td><s:textfield name="persona.sapellidoPers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.telefono"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.telefonoPers" size="35" maxlength="30" cssClass="inputs"></s:textfield></td>
								</tr>
								<tr>
									<td class="leftLabel"><s:text name="personal.email"></s:text><s:text name="campo.requerido"></s:text></td>
									<td><s:textfield name="persona.emailPers" size="35" maxlength="80" cssClass="inputs"></s:textfield></td>
								</tr>
							</table>
						</div>
						<div id="tabs-1">
							<jsp:include page="ordenVenta.jsp" flush="true"></jsp:include>
						</div>
						<div id="tabs-2">
							<jsp:include page="pago.jsp" flush="true"></jsp:include>
						</div>
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="Volver" class="buttonSV" onclick="volver();"/>
								<input type="button" value="Guardar" class="buttonSV" onclick="registrar();"/>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>

