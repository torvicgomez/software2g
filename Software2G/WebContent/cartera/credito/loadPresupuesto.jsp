<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<s:if test="presupuestoVO!=null&&presupuestoVO.presId">
	Monto Disponible&nbsp;<strong><font size="2" color="#FF0000">$<s:property value="presupuestoVO.presValorString"/>&nbsp;</font></strong>
	<s:hidden name="presupuestoVO.presId"></s:hidden> 
	<s:hidden name="presupuestoVO.presValor"></s:hidden>
	<s:hidden name="presupuestoVO.presDescripcion"></s:hidden>
</s:if>
