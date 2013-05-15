<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/syntax/css/shCore.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.dataTables.min.js'/>"></script>
<s:form name="form" id="form">
	<body id="dt_example">
		<div id="demo">
			<table border="0" width="100%">
				<tr>
					<td>
						<h1>
							<strong>
								<s:text name="titulo.personalcambiopass"></s:text>
							</strong>
						</h1>
						<s:hidden name="estado"></s:hidden>
						<s:if test="estado=='okCambioPass'">
							<s:submit value="Cambiar Contraseña" action="cambiarPassword" cssClass="button"></s:submit>
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left">
										<s:text name="personal.msgexitos"></s:text>
									</td>
								</tr>
							</table>
						</s:if>
						<s:else>
							<s:submit value="Aplicar Cambios" action="saveCambioPass" cssClass="button"></s:submit>
							<table border="0" width="100%">
								<tr>
									<td class="text" width="20%" align="left">
										<s:text name="personal.actualpass"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text" width="80%" align="left">
										<s:password name="usuarioVO.passwordUsua" size="20" maxlength="15"></s:password>
									</td>
								</tr>
								<tr>
									<td class="text">
										<s:text name="personal.nuevapass"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text">
										<s:password name="usuarioVO.newPassword" size="20" maxlength="15"></s:password>
									</td>
								</tr>
								<tr>
									<td class="text">
										<s:text name="personal.confirmarpass"></s:text><s:text name="campo.requerido"></s:text>
									</td>
									<td class="text">
										<s:password name="usuarioVO.confirmNewPassword" size="20" maxlength="15"></s:password>
									</td>
								</tr>
							</table>
						</s:else>
					</td>	
				</tr>
			</table>
		</div>	
	</body>
</s:form>