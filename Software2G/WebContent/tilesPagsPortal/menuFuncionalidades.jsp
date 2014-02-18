<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="com.software2g.vo.Usuario"%>
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
<link href="<s:url value='/js/zTreeMenu/css/zTreeStyle/zTreeStyle.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery-1.4.4.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/zTreeMenu/js/jquery.ztree.core-3.5.js'/>"></script>
<script type="text/javascript" src="../file/configuracionUser/<%=nameFileFuncUser %>.js"></script>
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
					bodyIframe.attr("src",treeNode.file );
					return true;
				}
			}
		}
	};
	
	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		bodyIframe = $("#bodyIframe");
		bodyIframe.bind("load", loadReady);
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.selectNode(zTree.getNodeByParam("id", 101));
	
	});

	function loadReady() {
		var bodyH = bodyIframe.contents().find("body").get(0).scrollHeight,
		htmlH = bodyIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = bodyIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		bodyIframe.height(h);
	}
  </script>
  <table border="0"  width="99%" align="center" >
  	<tr>
  		<td width="25%" align="left" valign="top" style="BORDER-RIGHT: #999999 1px dashed">
  			<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
  		</td>
  		<td width="70%">
  			<iframe id="bodyIframe"
  				name="bodyIframe"
  				frameborder="0"
  				scrolling="auto"
  				width="100%"
  				src="<s:url value='/tilesPagsPortal/bienvenida.jsp'/>">
  			</iframe>
  		</td>
  	</tr>
  </table>
  