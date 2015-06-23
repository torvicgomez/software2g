<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function registrar(frm){
		alert(document.getElementById("archivo").value);
		document.getElementById("fileSelect").value = document.getElementById("archivo").value; 
		if(confirm("¿Está seguro de agregar la información?")){
		  frm.action = "leerArchivo_reg.jsp";
		  frm.submit();
  		}	
	}
</script>
<body>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>Archivo
					<input type="hidden" id="fileSelect">
				</td>
				<td><input type="file" id="archivo"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Registrar" onclick="javascript:registrar(document.forms['form1']);"></td>
			</tr>
		</table>
	</form>
</body>
</html>