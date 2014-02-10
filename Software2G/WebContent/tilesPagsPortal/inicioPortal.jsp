<%@ page import="com.software2g.vo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Usuario usuarioLogin = (Usuario) request.getSession().getAttribute("usuarioLogin");
	String nameFileFuncUser = "adminPortal";
	//String nameFileFuncUser = "acafeto";
	//String nameFileFuncUser = "inicial";
	//String nameFileFuncUser = "pruebasUtilidades"; 
	/*if(usuarioLogin.getNombreFileFunc()!=null&&!usuarioLogin.getNombreFileFunc().equals(""))
		nameFileFuncUser = usuarioLogin.getNombreFileFunc();
	else 
		nameFileFuncUser = "inicial";
	*/
 %>
<%-- <link href="<s:url value='/css/demo_page.css'/>" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="<s:url value='/css/scheme1.css'/>" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="<s:url value='/css/demo_table.css'/>" rel="stylesheet" type="text/css" />  --%>
<link href="<s:url value='/js/zTreeMenu/css/zTreeStyle/zTreeStyle.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery-1.4.4.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery.ztree.core-3.5.js'/>"></script>
<script type="text/javascript" src="file/configuracionUser/<%=nameFileFuncUser %>.js"></script>
  <style>
	body {
	background-color: white;
	margin:0; padding:0;
	text-align: center;
	}
	div, p, table, th, td {
		list-style:none; 
		margin:0; padding:0; 
		color:#333; font-size:12px; 
		font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
	}
	#testIframe {margin-left: 10px;}
  </style>
  
 <script type="text/javascript" >
  <!--
	var zTree;
	var demoIframe;
	

	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src",treeNode.file );
					return true;
				}
			}
		}
	};
	
	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
		//demoIframe.bind("load", loadReady);
		//var zTree = $.fn.zTree.getZTreeObj("tree");
		//zTree.selectNode(zTree.getNodeByParam("id", 101));
		//var sNodes = zTree.getSelectedNodes();
		//if (sNodes.length > 0) {
		//	var isOpen = sNodes[0].open;
		//}
		var treeObj = $.fn.zTree.getZTreeObj("tree");
		treeObj.expandAll(true);
	});

	/*function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}*/

  //-->
  </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="titulo.header"></s:text></title>
<link rel="icon" href="http://localhost:8080/Software2G/imagenes/acafeto.png" type="image/png" />
</head>
<body>
<s:form id="form">
	<table align="center" width="99%" height="100%">
		<tr>
			<td rowspan="3" width="15%" align="left" valign="top" style="BORDER-RIGHT: #999999 1px dashed">
	  			<ul id="tree" class="ztree"></ul>
	  		</td>	
			<td>
				<jsp:include page="piePagina.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="encabezado.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
	  			<iframe id="testIframe"
	  				name="testIframe"
	  				frameborder="0"
	  				scrolling="auto"
	  				width="100%"
	  				height="520px"
	  				src="<s:url value='/tilesPagsPortal/bienvenida.jsp'/>">
	  			</iframe>
	  		</td>
		</tr>
	</table>
</s:form>
</body>
</html>