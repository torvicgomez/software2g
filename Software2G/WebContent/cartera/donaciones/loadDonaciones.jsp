<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" charset="ISO-8859-1">
	$(document).ready(function(){
        $("#selectDonacionesEntidades").change(function(event){ 
            var id = $("#selectDonacionesEntidades").find(':selected').val();
            $("#donacionDescrip").val($("#selectDonacionesEntidades").find(':selected').text());
            $("#montoDonado").load('valorDonacionesEnt.action?donacionVO.donaId='+id);
        });
	}); 
</script>
<s:if test="listDonaciones!=null&&listDonaciones.size>0">
	<s:select list="listDonaciones" name="donacionVO.donaId" id="selectDonacionesEntidades" listKey="donaId" listValue="donaDescripcion" headerKey="-1" headerValue=".::Seleccion::."/>
</s:if>
<s:if test="donacionVO!=null&&donacionVO.donaId>0">
	<strong><font size="2" color="#FF0000"><s:property value="donacionVO.donaValor"/></font></strong>
	<s:hidden name="donacionVO.donaValor"></s:hidden>
	<s:hidden name="donacionVO.donaFecha"></s:hidden>
</s:if>
<s:if test="listDonaciones==null&&donacionVO==null">
	<strong><font size="2" color="#FF0000">Seleccione una Entidad</font></strong>
</s:if>
<s:if test="listDonaciones==null&&donacionVO!=null&&donacionVO.donaId<=0&&donacionVO.entidaddonante.endoId>0">
	<strong><font size="2" color="#FF0000">0</font></strong>
</s:if>
