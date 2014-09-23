<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="x" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" language="javascript" src="<s:url value='/js/jquery.js'/>"></script>
    <script type="text/javascript" language="javascript" src="<s:url value='/js/jquery-ui.js'/>"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
	    $("img[name=imagen0]").click(function (e) {
	    //$("img").click(function () {
	    //$("#idimagen").click(function () {
	    //$("img[class=claseimagen]").click(function () {
	    //$(".claseimagen").click(function () {
	        //alert("has hecho click en la imagen");
	        var offset = $(this).offset();
    		$('.coordenadas').html('X:'+(e.clientX - offset.left)+ ' - Y:'+ (e.clientY - offset.top));
	    });
	    
	    $("img[name=imagen1]").click(function (e) {
	    //$("img").click(function () {
	    //$("#idimagen").click(function () {
	    //$("img[class=claseimagen]").click(function () {
	    //$(".claseimagen").click(function () {
	        //alert("has hecho click en la imagen");
	        var offset = $(this).offset();
    		$('.coordenadas').html('X:'+(e.clientX - offset.left)+ ' - Y:'+ (e.clientY - offset.top));
	    });
	    
	    $("img[name=imagen2]").click(function (e) {
	    //$("img").click(function () {
	    //$("#idimagen").click(function () {
	    //$("img[class=claseimagen]").click(function () {
	    //$(".claseimagen").click(function () {
	        //alert("has hecho click en la imagen");
	        var offset = $(this).offset();
    		$('.coordenadas').html('X:'+(e.clientX - offset.left)+ ' - Y:'+ (e.clientY - offset.top));
	    });
	});
</script>
</head>
<body>
	<table border="1" width="100%">
		<tr><td><img name="imagen0" id="idimagen" align="left" height="200" src="../imagenes/acafeto.png"></td></tr>
		<tr><td align="center"><img name="imagen1" id="idimagen" height="200" src="../imagenes/acafeto.png"></td></tr>
		<tr><td><img name="imagen2" id="idimagen" align="right" height="200" src="../imagenes/acafeto.png"></td></tr>
	</table>
	<table>
		<tr>
			<td></td>
			<td align="center"><img name="odo1" id="idodo1" align="top" width="80px" height="40px" src="../imagenes/odonto/1.png"></td>
			<td></td>
		</tr>
		<tr>
			<td><img name="odo4" id="idodo4" align="right" width="40px" height="80px" src="../imagenes/odonto/4.png"></td>
			<td align="center"><img name="odo5" id="idodo5" src="../imagenes/odonto/5.png"></td>
			<td><img name="odo2" id="idodo2" align="left" width="40px" height="80px" src="../imagenes/odonto/2.png"></td>
		</tr>
		<tr>
			<td></td>
			<td align="center"><img name="odo3" id="idodo3" width="80px" height="40px" src="../imagenes/odonto/3.png"></td>
			<td></td>
		</tr>
	</table>
	<br><div class="coordenadas" style="font-size:22px; color:#F00; margin-top:20px;"></div>
</body>
</html>