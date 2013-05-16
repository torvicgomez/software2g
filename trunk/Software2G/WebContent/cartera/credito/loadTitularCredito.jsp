<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" charset="ISO-8859-1">
	$(document).ready(function(){
        $("#selectTitularCredito").click(function(){ 
            var id = $("#selectTitularCredito").find(':selected').val();
            if(id>0){
            	$("#findPagare").val('');
            	$("#titularCredito").load('cargarTitularCredito.action?idPagare='+id);
            }
        });
	}); 
</script>
<s:if test="listPagare!=null&&listPagare.size>0">
	<s:select list="listPagare" name="creditoVO.pagare.pagaId" id="selectTitularCredito" listKey="pagaId" listValue="%{'['+pagaId+']--'+persona.pnombrePers+' '+persona.snombrePers+' '+persona.papellidoPers+' '+persona.sapellidoPers+'--'+persona.documentoPers+' '+persona.tipodocumento.abreviaturaTidoc}" size="5"/>
</s:if> 
<s:else>
	<s:if test="creditoVO.pagare.persona!=null&&creditoVO.pagare.persona.idPers>0">
		Titular Credito: <strong><font size="2" color="#FF0000">[Nro Pagare <s:property value="creditoVO.pagare.pagaId"/>]&nbsp;
			<s:property value="creditoVO.pagare.persona.pnombrePers"/> <s:property value="creditoVO.pagare.persona.snombrePers"/> <s:property value="creditoVO.pagare.persona.papellidoPers"/> <s:property value="creditoVO.pagare.persona.sapellidoPers"/> 
			<s:property value="creditoVO.pagare.persona.documentoPers"/><s:property value="creditoVO.pagare.persona.tipodocumento.abreviaturaTidoc"/> <s:property value="creditoVO.pagare.persona.emailPers"/>
			<s:hidden name="creditoVO.pagare.pagaId"/>
			<s:hidden name="creditoVO.pagare.pagaMonto" id="montoPagareCredito"/>
		</font></strong>
		<script type="text/javascript" charset="ISO-8859-1">
			document.getElementById("montoCredito").value = document.getElementById("montoPagareCredito").value;
		</script>
	</s:if>
	<s:else>
		<strong><font size="2" color="#FF0000">No se encontraron resultados</font></strong>
	</s:else>
</s:else>
