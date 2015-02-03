<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#color').dialog({
					autoOpen: false,
				});	 
				$(".click").click(function(event) {
					//input
					var objInput = $(this).find("input[name=cuadro]:hidden");
					//alert('objInput:['+objInput+']');
					var cuadro = $(this).find("input[name=cuadro]:hidden").val();//obtenemos el valor del cuadro al que le dimos click
					//alert('cuadro:['+cuadro+']--['+objInput.val()+']');
					//$("input[name=cuadro]:hidden").parent("cuadro_1_1").css('background-color', 'red');
					$("#color").dialog("option","position", [event.pageX,event.pageY]);//posicionamos el elemento donde dimos click			
					$('#color').dialog('open');
					$(".select").click(function(event){
						//.select
						var color = $(this).css('background-color');
						//objInput.css('background-color', color);
						var objetocu = document.getElementById("cuadro_"+cuadro);
						//alert('objetocu:['+objetocu+']');
						objetocu.style.backgroundColor  = color;
						//$("input[name=cuadro]:hidden").parent(".cuadro").css('background-color', color);
						//$("input[name=cuadro]:hidden").val(cuadro).parent(".cuadro").css('background-color', color);//establecemos el background a la clase cuadro
						//alert('color:['+color+']');
						//alert($("input[name=cuadro]:hidden").val(cuadro));
						//$("input[name=cuadro]:hidden").parent(".cuadro").css('background-color', color);//establecemos el background a la clase cuadro
						//$("input[name~='cuadro_1']").css("background-color", "yellow");
						//$("input[name=cuadro_"+cuadro+"]:hidden").css("background-color", "yellow");
					});
					return false;
				});
				return false;
			} );

			
			function agregar(){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoAdd%>";
				document.form.submit();
			}
			
			function registrar(){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoSave%>";
				document.form.submit();
			}
			
			function volver(){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoAll%>";
				document.form.submit();
			}
			
			function modificar(param){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoEdit%>&id="+param;
				document.form.submit();
			}
			
			function detalle(param){
				document.form.action="profesionalsalud.action?estado=<%=ConstantesAplicativo.constanteEstadoAbstract%>&id="+param;
				document.form.submit();
			}
			
		</script>
	<style type="text/css">
		.diente{
			position: relative;
			width: 0px;
			height: auto;
			margin-left: 50px;
			display: inline-block;
		}
		
		.cuadro{
			background-color: #FFFFFF;
			border: 1px solid #ccc;
			position: relative;
			width: 20px;
			height: 15px;
			left: 45px;
			-webkit-border-radius: 80px 80px 0px 15px;
			-moz-border-radius: 80px 80px 0px 15px;
			border-radius: 80px 80px 0px 15px;
		}
		.cuadro:hover{
			 background:rgba(117, 198, 243, 0.4);
			cursor: pointer;
		}
		.izquierdo{
			top: 1px !important;
			left: 28px !important;
			-webkit-transform: rotate(270deg);
			-moz-transform: rotate(270deg);
			-ms-transform: rotate(270deg);
			-o-transform: rotate(270deg);
			transform: rotate(270deg);
		}
		
		.debajo{
			top: 2px !important;
			left: 45px !important;
			-webkit-transform: rotate(180deg);
			-moz-transform: rotate(180deg);
			-ms-transform: rotate(180deg);
			-o-transform: rotate(180deg);
			transform: rotate(180deg);
		}
		.derecha{
			top: -33px !important;
			left: 61px !important;
			-webkit-transform: rotate(90deg);
			-moz-transform: rotate(90deg);
			-ms-transform: rotate(90deg);
			-o-transform: rotate(90deg);
			transform: rotate(90deg);
		}
		.centro{
			background: #F3F3F3;
			border: 1px solid #ccc;
			width: 20px;
			height: 18px;
			top:-51px;
			left: 45px;
			position: relative;
		}
		.centro:hover{
			border: 1px solid rgba(117, 198, 243, 0.4);
			background-color:rgba(117, 198, 243, 0.4);
			cursor: pointer;
		}
		.color{
			width: 200px;
			height: 200px;
			position: relative;
			margin: 0 auto;
			padding: 3px;
		}
		.select{
			width: 40px;
			height: 40px;
			margin: 2px;
			background-color: #FF00dd;
			display: inline-block;
			cursor: pointer;
		}
		.select:hover{
			border: 1px solid rgba(117, 198, 243, 0.4);
		}
		.content{
			position: absolute;
		}
		.ui-dialog{
			position: relative !important;
		}
	</style>
	</head>
	<body id="dt_example">
		<s:form id="form">
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<div id="demo">
				<table cellpadding="0" cellspacing="0" border="0" class="display">
					<tr><td>
						<h1><s:text name="titulo.odontograma"></s:text></h1>
					</td></tr>
					<s:if test="estado=='all'">
						<tr><td class="right">
<%-- 							<input type="button" value="<s:text name="labelbutton.agregar"></s:text>" onclick="agregar();" class="buttonSV"/> --%>
						</td></tr>
					</s:if>
					<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
					<s:elseif test="estado=='abstract'">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
							</td>
						</tr>
					</s:elseif>
				</table>
				<s:if test="estado=='all'||estado=='query'">
					Construccion Odontograma!!
					
					<table cellpadding="0" cellspacing="0" border="1" class="display">
						<tr>
							<td class="right">
								<div class="diente"><!--diente 1-->
									<input name="valor" type="hidden" value="1">
									
<!-- 									<div class="cuadro click"><input name="cuadro" type="hidden" value="1_1"></div> -->
<!-- 									<div class="cuadro izquierdo click"><input name="cuadro" type="hidden" value="1_2"></div> -->
<!-- 									<div class="cuadro debajo click"><input name="cuadro" type="hidden" value="1_3"></div> -->
<!-- 									<div class="cuadro derecha click"><input name="cuadro" type="hidden" value="1_4"></div> -->
<!-- 									<div class="centro click"><input name="cuadro" type="hidden" value="1_5"></div> -->

									<div class="cuadro click" id="cuadro_1_1" ><input name="cuadro" type="hidden" value="1_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_1_2" ><input name="cuadro" type="hidden" value="1_2"></div>
									<div class="cuadro debajo click" id="cuadro_1_3" ><input name="cuadro" type="hidden" value="1_3"></div>
									<div class="cuadro derecha click" id="cuadro_1_4" ><input name="cuadro" type="hidden" value="1_4"></div>
									<div class="centro click" id="cuadro_1_5" ><input name="cuadro" type="hidden" value="1_5"></div>									
								</div>
							</td>
						</tr>
						
						<tr>
							<td class="right">
								<div class="diente"><!--diente 1-->
									<input name="valor" type="hidden" value="1">
									<div class="cuadro click" id="cuadro_2_1" ><input name="cuadro" type="hidden" value="2_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_2_2" ><input name="cuadro" type="hidden" value="2_2"></div>
									<div class="cuadro debajo click" id="cuadro_2_3" ><input name="cuadro" type="hidden" value="2_3"></div>
									<div class="cuadro derecha click" id="cuadro_2_4" ><input name="cuadro" type="hidden" value="2_4"></div>
									<div class="centro click" id="cuadro_2_5"><input name="cuadro" type="hidden" value="2_5"></div>									
								</div>
							</td>
						</tr>
						
						<tr>
							<td class="right">
								<div id="color">
									<div class="select" style="background-color:#aa00dd;">A</div>
									<div class="select" style="background-color:#2211dd;">B</div>
									<div class="select" style="background-color:#bbccdd;">C</div>
									<div class="select" style="background-color:#3355dd;">D</div>
									<div class="select" style="background-color:#5859aa;">F</div>
									<div class="select" style="background-color:#ff0011;">G</div>
									<div class="select" style="background-color:#ee2255;">H</div>
									<div class="select" style="background-color:#889285;">I</div>
								</div>
							</td>
						</tr>
					</table>
					
					
					
				</s:if>
				<s:elseif test="estado=='add'||estado=='edit'||estado=='save'">
					<table cellpadding="0" cellspacing="0" border="0" class="display">
						<tr>
							<td class="right">
								<input type="button" value="<s:text name="labelbutton.volver"></s:text>" onclick="volver();" class="buttonSV"/>
								<input type="button" value="<s:text name="labelbutton.registrar"></s:text>" onclick="registrar();" class="buttonSV"/>
							</td>
						</tr>
					</table>
				</s:elseif>
			</div>
			<div class="spacer"></div>
		</s:form>
	</body>
</html>
