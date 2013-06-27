<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="listMunicipio!=null&&listMunicipio.size>0">
	<s:select list="listMunicipio" name="sucursalVO.sucuUbicacion" listKey="mcpoId" listValue="nommunicipio" headerKey="-1" headerValue=".::Seleccione::." />
</s:if>
