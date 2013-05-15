<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" charset="ISO-8859-1">
	$(document).ready(function(){
        $("#selectDeudorPagare").click(function(){ 
            var id = $("#selectDeudorPagare").find(':selected').val();
            if(id>0){
            	$("#findDeudor").val('');
            	$("#deudorPagare").load('cargarDeudor.action?idPersona='+id);
            }
        });
	}); 
</script>
<s:if test="listPersonas!=null&&listPersonas.size>0">
	<s:select list="listPersonas" name="donacionVO.donaId" id="selectDeudorPagare" listKey="idPers" 
	listValue="%{pnombrePers+' '+snombrePers+' '+papellidoPers+' '+sapellidoPers+'--'+documentoPers+' '+tipodocumento.abreviaturaTidoc}" size="5"/>
</s:if> 
<s:else>
	<s:if test="pagareVO.persona!=null&&pagareVO.persona.idPers>0">
		Deudor Pagare:&nbsp;<strong><font size="2" color="#FF0000">
			<s:property value="pagareVO.persona.pnombrePers"/>&nbsp;<s:property value="pagareVO.persona.snombrePers"/>&nbsp;<s:property value="pagareVO.persona.papellidoPers"/>&nbsp;<s:property value="pagareVO.persona.sapellidoPers"/>&nbsp;
			<s:property value="pagareVO.persona.documentoPers"/><s:property value="pagareVO.persona.tipodocumento.abreviaturaTidoc"/>&nbsp;<s:property value="pagareVO.persona.emailPers"/>
			<s:hidden name="pagareVO.persona.idPers"></s:hidden>
		</font></strong>
	</s:if>
	<s:else>
		<strong><font size="2" color="#FF0000">No se encontraron resultados</font></strong>
	</s:else>
</s:else>