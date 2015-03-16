<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="titulo.header"></s:text></title>
<link rel="icon" href="http://localhost:8080/Software2G/imagenes/acafeto.png" type="image/png" />
<!--STYLESHEETS-->
<link href="<s:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
<!--SCRIPTS-->
<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.min.js'/>"></script>

<style type="text/css">
 .fondo{ 
 	/* IE10 Consumer Preview */  
 	background-image: -ms-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%); 
 	/* Mozilla Firefox */ 
 	background-image: -moz-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%);
 	/* Opera */  
 	background-image: -o-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%); 
 	/* Webkit (Safari/Chrome 10) */  
 	background-image: -webkit-gradient(linear, left bottom, left top, color-stop(0, #FFFFFF), color-stop(1, #966A36)); 
 	/* Webkit (Chrome 11+) */  
 	background-image: -webkit-linear-gradient(bottom, #FFFFFF 0%, #966A36 100%); 
 	/* W3C Markup, IE10 Release Preview */  
 	background-image: linear-gradient(to top, #FFFFFF 0%, #966A36 100%); 
 } 
</style>

<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
</head>
<body >
<!--WRAPPER--> 
<div id="wrapper">

	<!--SLIDE-IN ICONS-->
    <div class="user-icon"></div>
    <div class="pass-icon"></div>
    <!--END SLIDE-IN ICONS-->

<!--LOGIN FORM-->

<form name="login-form" class="login-form" action="" method="post">
		<!--HEADER-->
	    <div class="header">
	    <!--TITLE--><h1>Login IngeSoft</h1><!--END TITLE-->
	    <!--DESCRIPTION-->
	   		<s:if test="hasActionMessages()">
				<div><strong><font color="#FF000">
					<s:actionmessage />
					<s:actionerror />
					<s:fielderror /></font></strong>
				</div>
			</s:if>
			<s:else>
	   			<span>Ingrese el usuario y contraseña para ingresar al sistema de información IngeSoft.</span>
	   		</s:else>
	    <!--END DESCRIPTION-->
	    </div>
	    <!--END HEADER-->
	    <!--CONTENT-->
		<div class="content">
		<!--USERNAME-->
			<s:textfield name="usuarioVO.loginUsua" size="20" maxlength="15" cssClass="input username" placeholder="Usuario"></s:textfield>
		<!--END USERNAME-->
    	<!--PASSWORD-->
    		<s:password name="usuarioVO.passwordUsua" size="20" maxlength="15" placeholder="Contraseña" cssClass="input password"></s:password>
    	<!--END PASSWORD-->
		</div>
		<!--END CONTENT-->
		<!--FOOTER-->
	    <div class="footer">
	    <!--LOGIN BUTTON-->
	    	<s:submit value="Ingresar" action="ingresarPortal"  cssClass="button"></s:submit>
	    <!--END LOGIN BUTTON-->
	    </div>
	    <!--END FOOTER-->
				 
</form>
<!--END LOGIN FORM-->

</div>
<!--END WRAPPER-->

<!--GRADIENT--<div class="gradient"></div><!--END GRADIENT-->

</body>
</html>