<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="titulo.header"></s:text></title>
<link rel="icon" href="http://localhost:8080/Software2G/imagenes/acafeto.png" type="image/png" />
</head>
<body>
<s:form name="login" id="login">
	<body id="dt_example">
		<div id="demo">
			<table border="0" align="center">
				<tr>
					<td valign="top" width="100%">
						<s:if test="hasActionMessages()">
							<tr>
								<td align="left">
									<div class="border">
										<s:actionmessage />
										<s:actionerror />
										<s:fielderror />
									</div></td>
							</tr>
						</s:if>
						<s:elseif test="hasActionErrors()">
							<tr>
								<td align="center">
									<div class="border">
										<s:actionmessage />
										<s:actionerror />
										<s:fielderror />
									</div></td>
							</tr>
						</s:elseif>
						<s:elseif test="hasFieldErrors()">
							<tr>
								<td align="center">
									<div class="border">
										<s:actionmessage />
										<s:actionerror />
										<s:fielderror />
									</div></td>
							</tr>
						</s:elseif>
		            </td>
				</tr>
				<tr>
					<td class="border">
					<table border="0">
							<tr>
								<td class="text">
									<s:text name="login.usuario"></s:text>
								</td>
								<td class="text">
									<s:textfield name="usuarioVO.loginUsua" size="20" maxlength="15"></s:textfield>
								</td>
							</tr>
							<tr>
								<td class="text">
									<s:text name="login.password"></s:text>
								</td>
								<td class="text">
									<s:password name="usuarioVO.passwordUsua" size="20" maxlength="15"></s:password>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center" class="text">
									<s:submit value="Entrar" action="ingresarPortal"  cssClass="button"></s:submit>
									<s:submit value="Recuperar Contraseña" action="portal" cssClass="button"></s:submit>
								</td>
							</tr>
						</table>
					</td>	
				</tr>
			</table>
		</div>	
	</body>
</s:form>
</body>
</html>