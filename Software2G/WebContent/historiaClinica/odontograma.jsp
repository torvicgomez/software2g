<%@page import="com.software2g.util.ConstantesAplicativo"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#color').dialog({
					autoOpen: false,
					buttons: {
				        Ok: function() {
				          $( this ).dialog( "close" );
				        }
				    }
				});	 
				var cuadro = '';
				$(".select").click(function(event){
					var color = $(this).css('background-color');
					var imagen = $(this).css('background-image');
					//alert('color:['+color+']');
					//alert('imagen:['+imagen+']');
					var objetocu = null;
					objetocu = document.getElementById("cuadro_"+cuadro);
					if(imagen!='none'){
						objetocu.style.backgroundImage  = imagen;
					}else{
						objetocu.style.backgroundColor  = color;
					}	
					//objetocu.style.border =  "1px solid #FF0000";	
					//$("input[name=cuadro]:hidden").val(cuadro).parent(".cuadro").css('background-color', color);//establecemos el background a la clase cuadro
					color = color.replace('rgb(','');
					color = color.replace(')','');
					color = color.split(',');
					colorHexa = rgbToHex(parseInt(color[0].trim()), parseInt(color[1].trim()), parseInt(color[2].trim()) );
					document.getElementById("odontograma").value += cuadro+"$$$"+colorHexa+"&&&&";
				});
				
				$(".click").click(function(event) {
					var auxcuadro = '';
					auxcuadro = $(this).find("input[name=cuadro]:hidden").val();//obtenemos el valor del cuadro al que le dimos click
					cuadro = auxcuadro;
					$("#color").dialog("option","position", [event.pageX,event.pageY]);//posicionamos el elemento donde dimos click			
					$('#color').dialog('open');
					return false;
				});
				return false;
			} );

			function componentToHex(c) {
			    var hex = c.toString(16);
			    return hex.length == 1 ? "0" + hex : hex;
			}
			
			function rgbToHex(r, g, b) {
			    return "#" + componentToHex(r) + componentToHex(g) + componentToHex(b);
			}
			
			//alert( rgbToHex(0, 51, 255) );
			
		</script>
	<style type="text/css">
		.diente{
 			position: relative; 
			width: 0px;
			height: auto;
 			margin-left: 50px; 
 			display: inline-block;
		}
		
		.informacion{
 			position: relative; 
			width: 0px;
			height: auto;
 			left: 70px;  
		}
		
		.informacionimg{
 			position: relative; 
			width: 0px;
			height: auto;
 			left: 55px; 
 			margin-left: 30px;  
		}
		
		.informacionimghr{
 			position: relative; 
			width: 0px;
			height: auto;
 			left: 0px;  
		}
		
		.informacionimghrizq{
 			position: relative; 
			width: 0px;
			height: auto;
 			left: 90px;  
		}
		
		.informaciontexthrizq{
 			position: relative; 
			width: 0px;
			height: auto;
 			left: 155px;  
		}
		
		.cuadronro{
			background-color: #FFFFFF;
			position: relative;
			width: 20px;
			height: 25px;
			left: 45px;
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
<%-- 		<s:form id="form"> --%>
			<s:hidden name="funcPosicionado"></s:hidden>
			<s:hidden name="bandEstadoFunc"></s:hidden>
			<s:textfield name="odontograma" id="odontograma"></s:textfield>
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
<!-- 					<input name="valor" type="hidden" value="1"> -->
					<table border="0" align="left">
						<tr>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
							<td class="right"><div class="informacion">Vestibular</div></td>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
						</tr>
						<tr>
							<td class="right">
								<div class="diente"><!--diente 1-->
									<div class="cuadronro">18</div> 
									<div class="cuadro click" id="cuadro_18_1" ><input name="cuadro" type="hidden" value="18_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_18_2" ><input name="cuadro" type="hidden" value="18_2"></div>
									<div class="cuadro debajo click" id="cuadro_18_3" ><input name="cuadro" type="hidden" value="18_3"></div>
									<div class="cuadro derecha click" id="cuadro_18_4" ><input name="cuadro" type="hidden" value="18_4"></div>
									<div class="centro click" id="cuadro_18_5" ><input name="cuadro" type="hidden" value="18_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">17</div> 
									<div class="cuadro click" id="cuadro_17_1" ><input name="cuadro" type="hidden" value="17_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_17_2" ><input name="cuadro" type="hidden" value="17_2"></div>
									<div class="cuadro debajo click" id="cuadro_17_3" ><input name="cuadro" type="hidden" value="17_3"></div>
									<div class="cuadro derecha click" id="cuadro_17_4" ><input name="cuadro" type="hidden" value="17_4"></div>
									<div class="centro click" id="cuadro_17_5" ><input name="cuadro" type="hidden" value="17_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">16</div>
									<div class="cuadro click" id="cuadro_16_1" ><input name="cuadro" type="hidden" value="16_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_16_2" ><input name="cuadro" type="hidden" value="16_2"></div>
									<div class="cuadro debajo click" id="cuadro_16_3" ><input name="cuadro" type="hidden" value="16_3"></div>
									<div class="cuadro derecha click" id="cuadro_16_4" ><input name="cuadro" type="hidden" value="16_4"></div>
									<div class="centro click" id="cuadro_16_5" ><input name="cuadro" type="hidden" value="16_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">15</div>
									<div class="cuadro click" id="cuadro_15_1" ><input name="cuadro" type="hidden" value="15_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_15_2" ><input name="cuadro" type="hidden" value="15_2"></div>
									<div class="cuadro debajo click" id="cuadro_15_3" ><input name="cuadro" type="hidden" value="15_3"></div>
									<div class="cuadro derecha click" id="cuadro_15_4" ><input name="cuadro" type="hidden" value="15_4"></div>
									<div class="centro click" id="cuadro_15_5" ><input name="cuadro" type="hidden" value="15_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">14</div>
									<div class="cuadro click" id="cuadro_14_1" ><input name="cuadro" type="hidden" value="14_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_14_2" ><input name="cuadro" type="hidden" value="14_2"></div>
									<div class="cuadro debajo click" id="cuadro_14_3" ><input name="cuadro" type="hidden" value="14_3"></div>
									<div class="cuadro derecha click" id="cuadro_14_4" ><input name="cuadro" type="hidden" value="14_4"></div>
									<div class="centro click" id="cuadro_14_5" ><input name="cuadro" type="hidden" value="14_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">13</div>
									<div class="cuadro click" id="cuadro_13_1" ><input name="cuadro" type="hidden" value="13_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_13_2" ><input name="cuadro" type="hidden" value="13_2"></div>
									<div class="cuadro debajo click" id="cuadro_13_3" ><input name="cuadro" type="hidden" value="13_3"></div>
									<div class="cuadro derecha click" id="cuadro_13_4" ><input name="cuadro" type="hidden" value="13_4"></div>
									<div class="centro click" id="cuadro_13_5" ><input name="cuadro" type="hidden" value="13_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">12</div>
									<div class="cuadro click" id="cuadro_12_1" ><input name="cuadro" type="hidden" value="12_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_12_2" ><input name="cuadro" type="hidden" value="12_2"></div>
									<div class="cuadro debajo click" id="cuadro_12_3" ><input name="cuadro" type="hidden" value="12_3"></div>
									<div class="cuadro derecha click" id="cuadro_12_4" ><input name="cuadro" type="hidden" value="12_4"></div>
									<div class="centro click" id="cuadro_12_5" ><input name="cuadro" type="hidden" value="12_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">11</div>
									<div class="cuadro click" id="cuadro_11_1" ><input name="cuadro" type="hidden" value="11_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_11_2" ><input name="cuadro" type="hidden" value="11_2"></div>
									<div class="cuadro debajo click" id="cuadro_11_3" ><input name="cuadro" type="hidden" value="11_3"></div>
									<div class="cuadro derecha click" id="cuadro_11_4" ><input name="cuadro" type="hidden" value="11_4"></div>
									<div class="centro click" id="cuadro_11_5" ><input name="cuadro" type="hidden" value="11_5"></div>									
								</div>
							</td>
							<td class="right" rowspan="2"><div class="informacionimg"><img align="middle" src="<s:url value="/imagenes/imgodonto.png"/>"></div></td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">21</div>
									<div class="cuadro click" id="cuadro_21_1" ><input name="cuadro" type="hidden" value="21_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_21_2" ><input name="cuadro" type="hidden" value="21_2"></div>
									<div class="cuadro debajo click" id="cuadro_21_3" ><input name="cuadro" type="hidden" value="21_3"></div>
									<div class="cuadro derecha click" id="cuadro_21_4" ><input name="cuadro" type="hidden" value="21_4"></div>
									<div class="centro click" id="cuadro_21_5" ><input name="cuadro" type="hidden" value="21_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">22</div>
									<div class="cuadro click" id="cuadro_22_1" ><input name="cuadro" type="hidden" value="22_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_22_2" ><input name="cuadro" type="hidden" value="22_2"></div>
									<div class="cuadro debajo click" id="cuadro_22_3" ><input name="cuadro" type="hidden" value="22_3"></div>
									<div class="cuadro derecha click" id="cuadro_22_4" ><input name="cuadro" type="hidden" value="22_4"></div>
									<div class="centro click" id="cuadro_22_5" ><input name="cuadro" type="hidden" value="22_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">23</div>
									<div class="cuadro click" id="cuadro_23_1" ><input name="cuadro" type="hidden" value="23_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_23_2" ><input name="cuadro" type="hidden" value="23_2"></div>
									<div class="cuadro debajo click" id="cuadro_23_3" ><input name="cuadro" type="hidden" value="23_3"></div>
									<div class="cuadro derecha click" id="cuadro_23_4" ><input name="cuadro" type="hidden" value="23_4"></div>
									<div class="centro click" id="cuadro_23_5" ><input name="cuadro" type="hidden" value="23_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">24</div>
									<div class="cuadro click" id="cuadro_24_1" ><input name="cuadro" type="hidden" value="24_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_24_2" ><input name="cuadro" type="hidden" value="24_2"></div>
									<div class="cuadro debajo click" id="cuadro_24_3" ><input name="cuadro" type="hidden" value="24_3"></div>
									<div class="cuadro derecha click" id="cuadro_24_4" ><input name="cuadro" type="hidden" value="24_4"></div>
									<div class="centro click" id="cuadro_24_5" ><input name="cuadro" type="hidden" value="24_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">25</div>
									<div class="cuadro click" id="cuadro_25_1" ><input name="cuadro" type="hidden" value="25_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_25_2" ><input name="cuadro" type="hidden" value="25_2"></div>
									<div class="cuadro debajo click" id="cuadro_25_3" ><input name="cuadro" type="hidden" value="25_3"></div>
									<div class="cuadro derecha click" id="cuadro_25_4" ><input name="cuadro" type="hidden" value="25_4"></div>
									<div class="centro click" id="cuadro_25_5" ><input name="cuadro" type="hidden" value="25_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">26</div>
									<div class="cuadro click" id="cuadro_26_1" ><input name="cuadro" type="hidden" value="26_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_26_2" ><input name="cuadro" type="hidden" value="26_2"></div>
									<div class="cuadro debajo click" id="cuadro_26_3" ><input name="cuadro" type="hidden" value="26_3"></div>
									<div class="cuadro derecha click" id="cuadro_26_4" ><input name="cuadro" type="hidden" value="26_4"></div>
									<div class="centro click" id="cuadro_26_5" ><input name="cuadro" type="hidden" value="26_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">27</div>
									<div class="cuadro click" id="cuadro_27_1" ><input name="cuadro" type="hidden" value="27_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_27_2" ><input name="cuadro" type="hidden" value="27_2"></div>
									<div class="cuadro debajo click" id="cuadro_27_3" ><input name="cuadro" type="hidden" value="27_3"></div>
									<div class="cuadro derecha click" id="cuadro_27_4" ><input name="cuadro" type="hidden" value="27_4"></div>
									<div class="centro click" id="cuadro_27_5" ><input name="cuadro" type="hidden" value="27_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">28</div>
									<div class="cuadro click" id="cuadro_28_1" ><input name="cuadro" type="hidden" value="28_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_28_2" ><input name="cuadro" type="hidden" value="28_2"></div>
									<div class="cuadro debajo click" id="cuadro_28_3" ><input name="cuadro" type="hidden" value="28_3"></div>
									<div class="cuadro derecha click" id="cuadro_28_4" ><input name="cuadro" type="hidden" value="28_4"></div>
									<div class="centro click" id="cuadro_28_5" ><input name="cuadro" type="hidden" value="28_5"></div>									
								</div>
							</td>
						</tr>
						<tr>
							<td class="right"></td>
							<td class="right"></td>
							<td class="right"></td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">55</div>
									<div class="cuadro click" id="cuadro_55_1" ><input name="cuadro" type="hidden" value="55_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_55_2" ><input name="cuadro" type="hidden" value="55_2"></div>
									<div class="cuadro debajo click" id="cuadro_55_3" ><input name="cuadro" type="hidden" value="55_3"></div>
									<div class="cuadro derecha click" id="cuadro_55_4" ><input name="cuadro" type="hidden" value="55_4"></div>
									<div class="centro click" id="cuadro_55_5"><input name="cuadro" type="hidden" value="55_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">54</div>
									<div class="cuadro click" id="cuadro_54_1" ><input name="cuadro" type="hidden" value="54_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_54_2" ><input name="cuadro" type="hidden" value="54_2"></div>
									<div class="cuadro debajo click" id="cuadro_54_3" ><input name="cuadro" type="hidden" value="54_3"></div>
									<div class="cuadro derecha click" id="cuadro_54_4" ><input name="cuadro" type="hidden" value="54_4"></div>
									<div class="centro click" id="cuadro_54_5"><input name="cuadro" type="hidden" value="54_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">53</div>
									<div class="cuadro click" id="cuadro_53_1" ><input name="cuadro" type="hidden" value="53_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_53_2" ><input name="cuadro" type="hidden" value="53_2"></div>
									<div class="cuadro debajo click" id="cuadro_53_3" ><input name="cuadro" type="hidden" value="53_3"></div>
									<div class="cuadro derecha click" id="cuadro_53_4" ><input name="cuadro" type="hidden" value="53_4"></div>
									<div class="centro click" id="cuadro_53_5"><input name="cuadro" type="hidden" value="53_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">52</div>
									<div class="cuadro click" id="cuadro_52_1" ><input name="cuadro" type="hidden" value="52_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_52_2" ><input name="cuadro" type="hidden" value="52_2"></div>
									<div class="cuadro debajo click" id="cuadro_52_3" ><input name="cuadro" type="hidden" value="52_3"></div>
									<div class="cuadro derecha click" id="cuadro_52_4" ><input name="cuadro" type="hidden" value="52_4"></div>
									<div class="centro click" id="cuadro_52_5"><input name="cuadro" type="hidden" value="52_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">51</div>
									<div class="cuadro click" id="cuadro_51_1" ><input name="cuadro" type="hidden" value="51_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_51_2" ><input name="cuadro" type="hidden" value="51_2"></div>
									<div class="cuadro debajo click" id="cuadro_51_3" ><input name="cuadro" type="hidden" value="51_3"></div>
									<div class="cuadro derecha click" id="cuadro_51_4" ><input name="cuadro" type="hidden" value="51_4"></div>
									<div class="centro click" id="cuadro_51_5"><input name="cuadro" type="hidden" value="51_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">61</div>
									<div class="cuadro click" id="cuadro_61_1" ><input name="cuadro" type="hidden" value="61_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_61_2" ><input name="cuadro" type="hidden" value="61_2"></div>
									<div class="cuadro debajo click" id="cuadro_61_3" ><input name="cuadro" type="hidden" value="61_3"></div>
									<div class="cuadro derecha click" id="cuadro_61_4" ><input name="cuadro" type="hidden" value="61_4"></div>
									<div class="centro click" id="cuadro_61_5"><input name="cuadro" type="hidden" value="61_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">62</div>
									<div class="cuadro click" id="cuadro_62_1" ><input name="cuadro" type="hidden" value="62_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_62_2" ><input name="cuadro" type="hidden" value="62_2"></div>
									<div class="cuadro debajo click" id="cuadro_62_3" ><input name="cuadro" type="hidden" value="62_3"></div>
									<div class="cuadro derecha click" id="cuadro_62_4" ><input name="cuadro" type="hidden" value="62_4"></div>
									<div class="centro click" id="cuadro_62_5"><input name="cuadro" type="hidden" value="62_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">63</div>
									<div class="cuadro click" id="cuadro_63_1" ><input name="cuadro" type="hidden" value="63_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_63_2" ><input name="cuadro" type="hidden" value="63_2"></div>
									<div class="cuadro debajo click" id="cuadro_63_3" ><input name="cuadro" type="hidden" value="63_3"></div>
									<div class="cuadro derecha click" id="cuadro_63_4" ><input name="cuadro" type="hidden" value="63_4"></div>
									<div class="centro click" id="cuadro_63_5"><input name="cuadro" type="hidden" value="63_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">64</div>
									<div class="cuadro click" id="cuadro_64_1" ><input name="cuadro" type="hidden" value="64_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_64_2" ><input name="cuadro" type="hidden" value="64_2"></div>
									<div class="cuadro debajo click" id="cuadro_64_3" ><input name="cuadro" type="hidden" value="64_3"></div>
									<div class="cuadro derecha click" id="cuadro_64_4" ><input name="cuadro" type="hidden" value="64_4"></div>
									<div class="centro click" id="cuadro_64_5"><input name="cuadro" type="hidden" value="64_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">65</div>
									<div class="cuadro click" id="cuadro_65_1" ><input name="cuadro" type="hidden" value="65_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_65_2" ><input name="cuadro" type="hidden" value="65_2"></div>
									<div class="cuadro debajo click" id="cuadro_65_3" ><input name="cuadro" type="hidden" value="65_3"></div>
									<div class="cuadro derecha click" id="cuadro_65_4" ><input name="cuadro" type="hidden" value="65_4"></div>
									<div class="centro click" id="cuadro_65_5"><input name="cuadro" type="hidden" value="65_5"></div>									
								</div>
							</td>
						</tr>
						<tr>
							<td>Derecha</td>
							<td colspan="7"><div class="informacionimghr"><img align="middle" src="<s:url value="/imagenes/imgodontohr.png"/>"></div></td>
							<td><div class="informacion">Lingual</div></td>  
							<td colspan="7"><div class="informacionimghrizq"><img align="middle" src="<s:url value="/imagenes/imgodontohr.png"/>"></div></td>
							<td><div class="informaciontexthrizq">Izquierda</div></td>
						</tr>
						<tr>
							<td class="right"></td>
							<td class="right"></td>
							<td class="right"></td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">85</div>
									<div class="cuadro click" id="cuadro_85_1" ><input name="cuadro" type="hidden" value="85_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_85_2" ><input name="cuadro" type="hidden" value="85_2"></div>
									<div class="cuadro debajo click" id="cuadro_85_3" ><input name="cuadro" type="hidden" value="85_3"></div>
									<div class="cuadro derecha click" id="cuadro_85_4" ><input name="cuadro" type="hidden" value="85_4"></div>
									<div class="centro click" id="cuadro_85_5"><input name="cuadro" type="hidden" value="85_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">84</div>
									<div class="cuadro click" id="cuadro_84_1" ><input name="cuadro" type="hidden" value="84_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_84_2" ><input name="cuadro" type="hidden" value="84_2"></div>
									<div class="cuadro debajo click" id="cuadro_84_3" ><input name="cuadro" type="hidden" value="84_3"></div>
									<div class="cuadro derecha click" id="cuadro_84_4" ><input name="cuadro" type="hidden" value="84_4"></div>
									<div class="centro click" id="cuadro_84_5"><input name="cuadro" type="hidden" value="84_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">83</div>
									<div class="cuadro click" id="cuadro_83_1" ><input name="cuadro" type="hidden" value="83_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_83_2" ><input name="cuadro" type="hidden" value="83_2"></div>
									<div class="cuadro debajo click" id="cuadro_83_3" ><input name="cuadro" type="hidden" value="83_3"></div>
									<div class="cuadro derecha click" id="cuadro_83_4" ><input name="cuadro" type="hidden" value="83_4"></div>
									<div class="centro click" id="cuadro_83_5"><input name="cuadro" type="hidden" value="83_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">82</div>
									<div class="cuadro click" id="cuadro_82_1" ><input name="cuadro" type="hidden" value="82_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_82_2" ><input name="cuadro" type="hidden" value="82_2"></div>
									<div class="cuadro debajo click" id="cuadro_82_3" ><input name="cuadro" type="hidden" value="82_3"></div>
									<div class="cuadro derecha click" id="cuadro_82_4" ><input name="cuadro" type="hidden" value="82_4"></div>
									<div class="centro click" id="cuadro_82_5"><input name="cuadro" type="hidden" value="82_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">81</div>
									<div class="cuadro click" id="cuadro_81_1" ><input name="cuadro" type="hidden" value="81_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_81_2" ><input name="cuadro" type="hidden" value="81_2"></div>
									<div class="cuadro debajo click" id="cuadro_81_3" ><input name="cuadro" type="hidden" value="81_3"></div>
									<div class="cuadro derecha click" id="cuadro_81_4" ><input name="cuadro" type="hidden" value="81_4"></div>
									<div class="centro click" id="cuadro_81_5"><input name="cuadro" type="hidden" value="81_5"></div>									
								</div>
							</td>
							<td class="right" rowspan="2"><div class="informacionimg"><img align="middle" src="<s:url value="/imagenes/imgodonto.png"/>"></div></td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">71</div>
									<div class="cuadro click" id="cuadro_71_1" ><input name="cuadro" type="hidden" value="71_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_71_2" ><input name="cuadro" type="hidden" value="71_2"></div>
									<div class="cuadro debajo click" id="cuadro_71_3" ><input name="cuadro" type="hidden" value="71_3"></div>
									<div class="cuadro derecha click" id="cuadro_71_4" ><input name="cuadro" type="hidden" value="71_4"></div>
									<div class="centro click" id="cuadro_71_5"><input name="cuadro" type="hidden" value="71_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">72</div>
									<div class="cuadro click" id="cuadro_72_1" ><input name="cuadro" type="hidden" value="72_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_72_2" ><input name="cuadro" type="hidden" value="72_2"></div>
									<div class="cuadro debajo click" id="cuadro_72_3" ><input name="cuadro" type="hidden" value="72_3"></div>
									<div class="cuadro derecha click" id="cuadro_72_4" ><input name="cuadro" type="hidden" value="72_4"></div>
									<div class="centro click" id="cuadro_72_5"><input name="cuadro" type="hidden" value="72_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">73</div>
									<div class="cuadro click" id="cuadro_73_1" ><input name="cuadro" type="hidden" value="73_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_73_2" ><input name="cuadro" type="hidden" value="73_2"></div>
									<div class="cuadro debajo click" id="cuadro_73_3" ><input name="cuadro" type="hidden" value="73_3"></div>
									<div class="cuadro derecha click" id="cuadro_73_4" ><input name="cuadro" type="hidden" value="73_4"></div>
									<div class="centro click" id="cuadro_73_5"><input name="cuadro" type="hidden" value="73_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">74</div>
									<div class="cuadro click" id="cuadro_74_1" ><input name="cuadro" type="hidden" value="74_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_74_2" ><input name="cuadro" type="hidden" value="74_2"></div>
									<div class="cuadro debajo click" id="cuadro_74_3" ><input name="cuadro" type="hidden" value="74_3"></div>
									<div class="cuadro derecha click" id="cuadro_74_4" ><input name="cuadro" type="hidden" value="74_4"></div>
									<div class="centro click" id="cuadro_74_5"><input name="cuadro" type="hidden" value="74_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">75</div>
									<div class="cuadro click" id="cuadro_75_1" ><input name="cuadro" type="hidden" value="75_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_75_2" ><input name="cuadro" type="hidden" value="75_2"></div>
									<div class="cuadro debajo click" id="cuadro_75_3" ><input name="cuadro" type="hidden" value="75_3"></div>
									<div class="cuadro derecha click" id="cuadro_75_4" ><input name="cuadro" type="hidden" value="75_4"></div>
									<div class="centro click" id="cuadro_75_5"><input name="cuadro" type="hidden" value="75_5"></div>									
								</div>
							</td>
						</tr>
						<tr>
							<td class="right">
								<div class="diente"><!--diente 1-->
									<div class="cuadronro">48</div> 
									<div class="cuadro click" id="cuadro_48_1" ><input name="cuadro" type="hidden" value="48_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_48_2" ><input name="cuadro" type="hidden" value="48_2"></div>
									<div class="cuadro debajo click" id="cuadro_48_3" ><input name="cuadro" type="hidden" value="48_3"></div>
									<div class="cuadro derecha click" id="cuadro_48_4" ><input name="cuadro" type="hidden" value="48_4"></div>
									<div class="centro click" id="cuadro_48_5" ><input name="cuadro" type="hidden" value="48_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">47</div> 
									<div class="cuadro click" id="cuadro_47_1" ><input name="cuadro" type="hidden" value="47_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_47_2" ><input name="cuadro" type="hidden" value="47_2"></div>
									<div class="cuadro debajo click" id="cuadro_47_3" ><input name="cuadro" type="hidden" value="47_3"></div>
									<div class="cuadro derecha click" id="cuadro_47_4" ><input name="cuadro" type="hidden" value="47_4"></div>
									<div class="centro click" id="cuadro_47_5" ><input name="cuadro" type="hidden" value="47_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">46</div>
									<div class="cuadro click" id="cuadro_46_1" ><input name="cuadro" type="hidden" value="46_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_46_2" ><input name="cuadro" type="hidden" value="46_2"></div>
									<div class="cuadro debajo click" id="cuadro_46_3" ><input name="cuadro" type="hidden" value="46_3"></div>
									<div class="cuadro derecha click" id="cuadro_46_4" ><input name="cuadro" type="hidden" value="46_4"></div>
									<div class="centro click" id="cuadro_46_5" ><input name="cuadro" type="hidden" value="46_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">45</div>
									<div class="cuadro click" id="cuadro_45_1" ><input name="cuadro" type="hidden" value="45_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_45_2" ><input name="cuadro" type="hidden" value="45_2"></div>
									<div class="cuadro debajo click" id="cuadro_45_3" ><input name="cuadro" type="hidden" value="45_3"></div>
									<div class="cuadro derecha click" id="cuadro_45_4" ><input name="cuadro" type="hidden" value="45_4"></div>
									<div class="centro click" id="cuadro_45_5" ><input name="cuadro" type="hidden" value="45_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">44</div>
									<div class="cuadro click" id="cuadro_44_1" ><input name="cuadro" type="hidden" value="44_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_44_2" ><input name="cuadro" type="hidden" value="44_2"></div>
									<div class="cuadro debajo click" id="cuadro_44_3" ><input name="cuadro" type="hidden" value="44_3"></div>
									<div class="cuadro derecha click" id="cuadro_44_4" ><input name="cuadro" type="hidden" value="44_4"></div>
									<div class="centro click" id="cuadro_44_5" ><input name="cuadro" type="hidden" value="44_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">43</div>
									<div class="cuadro click" id="cuadro_43_1" ><input name="cuadro" type="hidden" value="43_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_43_2" ><input name="cuadro" type="hidden" value="43_2"></div>
									<div class="cuadro debajo click" id="cuadro_43_3" ><input name="cuadro" type="hidden" value="43_3"></div>
									<div class="cuadro derecha click" id="cuadro_43_4" ><input name="cuadro" type="hidden" value="43_4"></div>
									<div class="centro click" id="cuadro_43_5" ><input name="cuadro" type="hidden" value="43_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">42</div>
									<div class="cuadro click" id="cuadro_42_1" ><input name="cuadro" type="hidden" value="42_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_42_2" ><input name="cuadro" type="hidden" value="42_2"></div>
									<div class="cuadro debajo click" id="cuadro_42_3" ><input name="cuadro" type="hidden" value="42_3"></div>
									<div class="cuadro derecha click" id="cuadro_42_4" ><input name="cuadro" type="hidden" value="42_4"></div>
									<div class="centro click" id="cuadro_42_5" ><input name="cuadro" type="hidden" value="42_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">41</div>
									<div class="cuadro click" id="cuadro_41_1" ><input name="cuadro" type="hidden" value="41_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_41_2" ><input name="cuadro" type="hidden" value="41_2"></div>
									<div class="cuadro debajo click" id="cuadro_41_3" ><input name="cuadro" type="hidden" value="41_3"></div>
									<div class="cuadro derecha click" id="cuadro_41_4" ><input name="cuadro" type="hidden" value="41_4"></div>
									<div class="centro click" id="cuadro_41_5" ><input name="cuadro" type="hidden" value="41_5"></div>									
								</div>
							</td>
<!-- 							<td class="right">&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
							<td class="right">
								<div class="diente">
									<div class="cuadronro">31</div>
									<div class="cuadro click" id="cuadro_31_1" ><input name="cuadro" type="hidden" value="31_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_31_2" ><input name="cuadro" type="hidden" value="31_2"></div>
									<div class="cuadro debajo click" id="cuadro_31_3" ><input name="cuadro" type="hidden" value="31_3"></div>
									<div class="cuadro derecha click" id="cuadro_31_4" ><input name="cuadro" type="hidden" value="31_4"></div>
									<div class="centro click" id="cuadro_31_5" ><input name="cuadro" type="hidden" value="31_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">32</div>
									<div class="cuadro click" id="cuadro_32_1" ><input name="cuadro" type="hidden" value="32_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_32_2" ><input name="cuadro" type="hidden" value="32_2"></div>
									<div class="cuadro debajo click" id="cuadro_32_3" ><input name="cuadro" type="hidden" value="32_3"></div>
									<div class="cuadro derecha click" id="cuadro_32_4" ><input name="cuadro" type="hidden" value="32_4"></div>
									<div class="centro click" id="cuadro_32_5" ><input name="cuadro" type="hidden" value="32_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">33</div>
									<div class="cuadro click" id="cuadro_33_1" ><input name="cuadro" type="hidden" value="33_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_33_2" ><input name="cuadro" type="hidden" value="33_2"></div>
									<div class="cuadro debajo click" id="cuadro_33_3" ><input name="cuadro" type="hidden" value="33_3"></div>
									<div class="cuadro derecha click" id="cuadro_33_4" ><input name="cuadro" type="hidden" value="33_4"></div>
									<div class="centro click" id="cuadro_33_5" ><input name="cuadro" type="hidden" value="33_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">34</div>
									<div class="cuadro click" id="cuadro_34_1" ><input name="cuadro" type="hidden" value="34_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_34_2" ><input name="cuadro" type="hidden" value="34_2"></div>
									<div class="cuadro debajo click" id="cuadro_34_3" ><input name="cuadro" type="hidden" value="34_3"></div>
									<div class="cuadro derecha click" id="cuadro_34_4" ><input name="cuadro" type="hidden" value="34_4"></div>
									<div class="centro click" id="cuadro_34_5" ><input name="cuadro" type="hidden" value="34_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">35</div>
									<div class="cuadro click" id="cuadro_35_1" ><input name="cuadro" type="hidden" value="35_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_35_2" ><input name="cuadro" type="hidden" value="35_2"></div>
									<div class="cuadro debajo click" id="cuadro_35_3" ><input name="cuadro" type="hidden" value="35_3"></div>
									<div class="cuadro derecha click" id="cuadro_35_4" ><input name="cuadro" type="hidden" value="35_4"></div>
									<div class="centro click" id="cuadro_35_5" ><input name="cuadro" type="hidden" value="35_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">36</div>
									<div class="cuadro click" id="cuadro_36_1" ><input name="cuadro" type="hidden" value="36_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_36_2" ><input name="cuadro" type="hidden" value="36_2"></div>
									<div class="cuadro debajo click" id="cuadro_36_3" ><input name="cuadro" type="hidden" value="36_3"></div>
									<div class="cuadro derecha click" id="cuadro_36_4" ><input name="cuadro" type="hidden" value="36_4"></div>
									<div class="centro click" id="cuadro_36_5" ><input name="cuadro" type="hidden" value="36_5"></div>									
								</div>
							</td>
							<td class="right">
								<div class="diente">
									<div class="cuadronro">37</div>
									<div class="cuadro click" id="cuadro_37_1" ><input name="cuadro" type="hidden" value="37_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_37_2" ><input name="cuadro" type="hidden" value="37_2"></div>
									<div class="cuadro debajo click" id="cuadro_37_3" ><input name="cuadro" type="hidden" value="37_3"></div>
									<div class="cuadro derecha click" id="cuadro_37_4" ><input name="cuadro" type="hidden" value="37_4"></div>
									<div class="centro click" id="cuadro_37_5" ><input name="cuadro" type="hidden" value="37_5"></div>									
								</div>
							</td>
							<td class="right" >
								<div class="diente">
									<div class="cuadronro">38</div>
									<div class="cuadro click" id="cuadro_38_1" ><input name="cuadro" type="hidden" value="38_1"></div>
									<div class="cuadro izquierdo click" id="cuadro_38_2" ><input name="cuadro" type="hidden" value="38_2"></div>
									<div class="cuadro debajo click" id="cuadro_38_3" ><input name="cuadro" type="hidden" value="38_3"></div>
									<div class="cuadro derecha click" id="cuadro_38_4" ><input name="cuadro" type="hidden" value="38_4"></div>
									<div class="centro click" id="cuadro_38_5" ><input name="cuadro" type="hidden" value="38_5"></div>									
								</div>
							</td>
						</tr>
						<tr>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
							<td class="right"><div class="informacion">Vestibular</div></td>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
							<td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td><td class="right"><div class="diente"></div></td>
						</tr>
						<tr>
							<td class="right" >
								<div id="color">
								<s:iterator value="listProcedimiento" id="data">
									<div class="select" style="background-color:${data.prtoColor};"></div>
								</s:iterator>
<!-- 									<div class="select" style="background-color:#aa00dd;"></div> -->
<!-- 									<div class="select" style="background-color:#2211dd;"></div> -->
<!-- 									<div class="select" style="background-color:#bbccdd;"></div> -->
<!-- 									<div class="select" style="background-color:#3355dd;"></div> -->
<!-- 									<div class="select" style="background-color:#5859aa;"></div> -->
<!-- 									<div class="select" style="background-color:#ff0011;"></div> -->
<!-- 									<div class="select" style="background-color:#ee2255;"></div> -->
<!-- 									<div class="select" style="background-color:#889285;"></div> -->
<!-- 									<div class="select" style="background-image: url('/Software2G/imagenes/icon_edit.png');"></div> -->
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
<%-- 		</s:form> --%>
	</body>
</html>
