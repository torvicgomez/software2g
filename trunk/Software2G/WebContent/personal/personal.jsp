<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/syntax/css/shCore.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-stripped.js"/>"></SCRIPT> 
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendar-en.js"/>"></SCRIPT>
<SCRIPT type="text/javascript" src="<s:url value="/scripts/calendarnew.js"/>"></SCRIPT>
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
            $("#viewSelectMcpo").load('loadMunicipios.action?personaVO.municipio.departamento.dptoId='+id);
        });
        
    });
</script>
<s:form name="personal" id="personal">
	<body id="dt_example">
		<div id="demo">
			<table border="0" width="100%">
				<tr>
					<td>
						<h1>
							<strong>
								<s:text name="titulo.personal"></s:text>
							</strong>
						</h1>
						<s:submit value="Cancelar" action="listPersonal" cssClass="button"></s:submit>
						<s:if test="personaVO.idPers != null && personaVO.idPers != 0">
							<s:hidden name="personaVO.idPers"></s:hidden>
							<!--<s:submit value="Suprimir" action="portal"  cssClass="button"></s:submit>-->
							<s:submit value="Aplicar Cambios" action="savePersona" cssClass="button"></s:submit>
						</s:if>
						<s:else>
							<s:submit value="Crear" action="savePersona" cssClass="button"></s:submit>
						</s:else>
						
						<table border="0" width="100%">
							<tr>
								<td class="text">
									<s:text name="personal.numerodocumento"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.documentoPers" size="20" maxlength="15"></s:textfield>
									<s:select list="listTipoDoc" name="personaVO.tipodocumento.idTidoc" listKey="idTidoc" listValue="nombreTidoc" headerKey="-1" headerValue=".::Seleccione::." />
								</td>
								<td class="text">
									<s:text name="personal.fechaexpedicion"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.fechaexpdocPers" id="fechaexpdocPers" size="15" maxlength="10"></s:textfield>
									<img alt="Fecha Expedicion" src="<s:url value="/imagenes/calendario.gif"/>" onclick="showCalendar('fechaexpdocPers', 'y-mm-dd');">(yyyy-mm-dd)
								</td>
							</tr>
							<tr>
								<td class="text">
									<s:text name="personal.primernombre"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.pnombrePers" size="35" maxlength="30"></s:textfield>
								</td>
								<td class="text">
									<s:text name="personal.segundonombre"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.snombrePers" size="35" maxlength="30"></s:textfield>
								</td>
							</tr>
							<tr>
								<td class="text">
									<s:text name="personal.primerapellido"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.papellidoPers" size="35" maxlength="30"></s:textfield>
								</td>
								<td class="text">
									<s:text name="personal.segundoapellido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.sapellidoPers" size="35" maxlength="30"></s:textfield>
								</td>
							</tr>
							<tr>
								<td class="text">
									<s:text name="personal.sexo"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:select list="listSexo" name="personaVO.sexoPers" listKey="key" listValue="valor" headerKey="-1" headerValue=".::Seleccione::." />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<s:text name="personal.estadocivil"></s:text><s:text name="campo.requerido"></s:text>
									<s:select list="listEstadoCivil" name="personaVO.estadocivilPers" listKey="key" listValue="valor" headerKey="-1" headerValue=".::Seleccione::." />
								</td>
								<td class="text">
									<s:text name="personal.fechanacimiento"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.fechanacimientoPers" id="fechanacimientoPers" size="15" maxlength="10"></s:textfield>
									<img alt="Fecha Nacimiento" src="<s:url value="/imagenes/calendario.gif"/>" onclick="showCalendar('fechanacimientoPers', 'y-mm-dd');">(yyyy-mm-dd)
								</td>
							</tr>
							<tr>
								<td class="text">
									<s:text name="personal.telefono"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.telefonoPers" size="35" maxlength="30"></s:textfield>
								</td>
								<td class="text">
									<s:text name="personal.email"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.emailPers" size="35" maxlength="80"></s:textfield>
								</td>
							</tr>
							<tr>
								<td class="text">
									<s:text name="personal.ubicaciongeo"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:select list="listPais" name="personaVO.municipio.departamento.pais.paisId" id="selectPais" listKey="paisId" listValue="nompais" headerKey="-1" headerValue=".::Seleccione::." />
									<s:if test="personaVO.municipio.departamento.pais.paisId>0">
										<div id="viewSelectDpto" style="overflow:auto;width:auto;height:auto;display:block">
									</s:if>
									<s:else>
										<div id="viewSelectDpto" style="overflow:auto;width:auto;height:auto;display:none">
									</s:else>
										<s:select list="listDepartamento" name="personaVO.municipio.departamento.dptoId" id="selectDpto" listKey="dptoId" listValue="nomdpto" headerKey="-1" headerValue=".::Seleccione::." />
									</div>
									<div id="viewSelectMcpo">
										<s:if test="listMunicipio!=null&&listMunicipio.size>0">
											<s:select list="listMunicipio" name="personaVO.municipio.mcpoId" listKey="mcpoId" listValue="nommunicipio" headerKey="-1" headerValue=".::Seleccione::." />
										</s:if>
									</div>
								</td>
								<td class="text">
									<s:text name="personal.direccion"></s:text><s:text name="campo.requerido"></s:text>
								</td>
								<td class="text">
									<s:textfield name="personaVO.direccionPers" size="35" maxlength="100"></s:textfield>
								</td>
							</tr>
							
						</table>
					</td>	
				</tr>
			</table>
		</div>	
	</body>
</s:form>