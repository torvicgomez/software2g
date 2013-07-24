<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/syntax/css/shCore.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='js/jquery.js'/>"></script>
<script language="javascript" type="text/javascript">
	$(document).ready(function(){
        $("#selectPais").change(function(event){
            var id = $("#selectPais").find(':selected').val();
            if(id>0){
            	$("#viewSelectDpto").show("block");
            	$("#viewSelectMcpo").show("block");
            }else{
            	$("#viewSelectDpto").hide(1000);
            	$("#viewSelectMcpo").hide(1000);
            }
        });
        
        $("#selectDpto").change(function(event){
            var id = $("#selectDpto").find(':selected').val();
            $("#viewSelectMcpo").load('loadMunicipiosSucursal.action?sucursalVO.dptoId='+id);
        });
        
    });
</script>
<s:form name="form" id="form">
	<body id="dt_example">
		<div id="demo">
			<table border="0" width="100%">
				<tr>
					<td>
						<h1>
							<strong>
								<s:text name="titulo.sucursal"></s:text>
							</strong>
						</h1>
						<s:submit value="Cancelar" action="listSucursales" cssClass="button"></s:submit>
						<s:if test="sucursalVO.sucuId != null && sucursalVO.sucuId != 0">
							<s:hidden name="sucursalVO.sucuId"></s:hidden>
							<!--<s:submit value="Suprimir" action="portal"  cssClass="button"></s:submit>-->
							<s:submit value="Aplicar Cambios" action="saveSucursal" cssClass="button"></s:submit>
						</s:if>
						<s:else>
							<s:submit value="Crear" action="saveSucursal" cssClass="button"></s:submit>
						</s:else>
						
						<table border="0" width="100%">
							<tr>
								<td class="text" width="10%" align="left" valign="top">
									<s:text name="sucrusal.nombre"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text" width="90%" align="left"  valign="top">
									<s:textfield name="sucursalVO.sucuNombre" size="20" maxlength="15"></s:textfield>
								</td>
							</tr>
							<tr>
								<td class="text"  valign="top">
									<s:text name="sucursal.descripcion"></s:text>
								</td>
								<td class="text"  valign="top">
									<s:textarea name="sucursalVO.sucuDescripcion" cols="50" rows="3"></s:textarea>
								</td>
							</tr>
							<tr>
								<td class="text"  valign="top">
									<s:text name="sucursal.ubicacion"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text"  valign="top">
									<s:select list="listPais" name="sucursalVO.paisId" id="selectPais" listKey="paisId" listValue="nompais" headerKey="-1" headerValue=".::Seleccione::." />
									<s:if test="sucursalVO.paisId>0">
										<div id="viewSelectDpto" style="overflow:auto;width:auto;height:auto;display:block">
									</s:if>
									<s:else>
										<div id="viewSelectDpto" style="overflow:auto;width:auto;height:auto;display:none">
									</s:else>
										<s:select list="listDepartamento" name="sucursalVO.dptoId" id="selectDpto" listKey="dptoId" listValue="nomdpto" headerKey="-1" headerValue=".::Seleccione::." />
									</div>
									<div id="viewSelectMcpo">
										<s:if test="listMunicipio!=null&&listMunicipio.size>0">
											<s:select list="listMunicipio" name="sucursalVO.sucuUbicacion" listKey="mcpoId" listValue="nommunicipio" headerKey="-1" headerValue=".::Seleccione::." />
										</s:if>
									</div>
								</td>
							</tr>
						</table>
					</td>	
				</tr>
			</table>
		</div>	
	</body>
</s:form>