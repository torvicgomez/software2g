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
 <frameset rows="*,60" frameborder="no" border="0" framespacing="0">
	<frameset rows="140,*" cols="*" frameborder="no" border="0" framespacing="0" >
	  <frame src="tilesPagsPortal/encabezado.jsp" name="encabezado"  id="encabezado" noresize="noresize" />
	  <frameset rows="*" cols="250,*" frameborder="no" border="0" framespacing="0">
	    <frame src="tilesPagsPortal/treeMenu.jsp" name="treemenu" id="treemenu"  />
	    <frame src="tilesPagsPortal/bienvenida.jsp" name="body" id="body" />
	  </frameset>
	</frameset>
	<frame src="tilesPagsPortal/piePagina.jsp" name="piePagina"  id="piePagina" noresize="noresize" />
</frameset>
<noframes><body>
</body>
</noframes></html>