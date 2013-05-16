<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<s:if test="tipoCreditoVO!=null&&tipoCreditoVO.ticrId">
	Interes Corriente&nbsp;<strong><font size="2" color="#FF0000"><s:property value="tipoCreditoVO.ticrTasainteresvencido"/>&nbsp;%</font></strong> 
	Interes Mora&nbsp;<strong><font size="2" color="#FF0000"><s:property value="tipoCreditoVO.ticrInteresmoramesven"/>&nbsp;%</font></strong>
	Interes Efectivo Anual&nbsp;<strong><font size="2" color="#FF0000"><s:property value="tipoCreditoVO.ticrInteresefectivoanual"/>&nbsp;%</font></strong>
	<s:hidden name="tipoCreditoVO.ticrId"></s:hidden>
</s:if>
