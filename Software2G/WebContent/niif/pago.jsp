<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
	<body id="dt_example">
		<div id="demo">
			<s:if test="estado=='all'||estado=='add'||estado=='edit'||estado=='save'">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
						<td align="right"><div id="pagoTotal"><s:property value="venta.ventTotalView"/></div></td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totaldescuento"></s:text></td>
						<td align="right"><div id="pagoTotalDes"><s:property value="venta.ventTotaldesView"/></div></td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totaliva"></s:text></td>
						<td align="right"><div id="pagoTotalIVa"><s:property value="venta.ventTotalivaView"/></div></td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
						<td align="right"><div id="pagoTotalPag"><s:property value="venta.ventTotalpagView"/></div></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
						<td align="right"><s:select list="listFormapago" name="listPago[0].formaPagoIdHelp" listKey="fopaId" listValue="fopaFormapago" headerKey="-1" headerValue=".::Selecione::." cssClass="inputs"/></td>
						<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
						<td align="right"><s:textfield name="listPago[0].pagoComprobante" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
						<td align="right"><s:textfield name="listPago[0].pagoValor" size="10" cssClass="inputs" style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
						<td align="right"><s:select list="listFormapago" name="listPago[1].formaPagoIdHelp" listKey="fopaId" listValue="fopaFormapago" headerKey="-1" headerValue=".::Selecione::." cssClass="inputs"/></td>
						<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
						<td align="right"><s:textfield name="listPago[1].pagoComprobante" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
						<td align="right"><s:textfield name="listPago[1].pagoValor" size="10" cssClass="inputs" style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield></td>
					</tr>
					<tr>
						<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
						<td align="right"><s:select list="listFormapago" name="listPago[2].formaPagoIdHelp" listKey="fopaId" listValue="fopaFormapago" headerKey="-1" headerValue=".::Selecione::." cssClass="inputs"/></td>
						<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
						<td align="right"><s:textfield name="listPago[2].pagoComprobante" size="10" cssClass="inputs"></s:textfield></td>
						<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
						<td align="right"><s:textfield name="listPago[2].pagoValor" size="10" cssClass="inputs" style="text-align:right" onKeyPress="return soloNumeros(event)" onpaste="return false"></s:textfield></td>
					</tr>
				</table>
			</s:if>
			<s:elseif test="estado=='abstract'">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totalarticulo"></s:text></td>
						<td align="right"><s:property value="venta.ventTotalView"/></td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totaldescuento"></s:text></td>
						<td align="right"><s:property value="venta.ventTotaldesView"/></td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totaliva"></s:text></td>
						<td align="right"><s:property value="venta.ventTotalivaView"/></td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td align="right" class="leftLabel"><s:text name="ordencompra.totalpagado"></s:text></td>
						<td align="right"><s:property value="venta.ventTotalpagView"/></td>
					</tr>
					<s:iterator value="listPago" id="data" status="stat">
						<s:if test="formapago.fopaId>0">
							<tr>
								<td class="leftLabel"><s:text name="formapago.formapago"></s:text></td>
								<td align="right"><s:property value="formapago.fopaFormapago"/></td>
								<td class="leftLabel"><s:text name="pagos.comprobante"></s:text></td>
								<td align="right"><s:property value="pagoComprobante"/></td>
								<td class="leftLabel"><s:text name="pagos.valor"></s:text></td>
								<td align="right"><s:property value="pagoValorView"/></td>
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</s:elseif>
		</div>
	</body>
</html>
