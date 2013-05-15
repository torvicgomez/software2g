<%@ taglib prefix="s" uri="/struts-tags"%>
<table border="0" width="100%">
	<s:iterator value="listDonancionObjeto" id="dataProdDona">
		<tr>
			<td width="40%" align="left" valign="top">
				<s:property value="id.objeId"/>
			</td>
			<td width="40%" align="left" valign="top">
				<s:property value="obdoEstado"/>
			</td>
			<td width="20%" align="left" valign="top">
				<s:submit value="Eliminar" action="addProductosDonacion" cssClass="button" id="addProdDonacion"></s:submit>
			</td>
	</s:iterator>
</table>
