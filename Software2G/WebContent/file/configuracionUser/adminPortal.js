var zNodes = [
//	{id:1000, pId:0, name:"Administracion Portal", open:true},
//	{id:1001, pId:1000, name:"Roles", file:"rol.action?estado=all&funcPosicionado=Administracion Portal::>Roles"},
//	{id:1002, pId:1000, name:"Funcionalidad", file:"funcionalidad.action?estado=all&funcPosicionado=Administracion Portal::>Funcionalidad"},
//	{id:2000, pId:0, name:"Calendario", open:true},
//	{id:2001, pId:2000, name:"Prueba Calendario", file:"calendario.action?estado=all&funcPosicionado=Calendario/Prueba Calendario"},
//	{id:2002, pId:2000, name:"Parametros Calendario", file:"paramCalendario.action?estado=all&funcPosicionado=Calendario/Parametros Calendario"},
//	{id:2003, pId:2000, name:"Jornada Laboral", file:"jornadaLaboral.action?estado=all&funcPosicionado=Calendario/Jornada Laboral"},
//	{id:3000, pId:0, name:"Historia Clinica", open:true},
	{id:3001, pId:3000, name:"Servicio", file:"servicio.action?estado=all&funcPosicionado=Historia Clinica/Servicio"},
	{id:3002, pId:3000, name:"Profesional Salud", file:"profesionalsalud.action?estado=all&funcPosicionado=Historia Clinica/Profesional Salud"},
	{id:3003, pId:3000, name:"Parametros Agenda Medica", file:"agendamedica.action?estado=all&funcPosicionado=Historia Clinica/Parametros Agenda Medica Profesional"},
	{id:3004, pId:3000, name:"Agenda Citas", file:"calendario.action?estado=all&funcPosicionado=Calendario/Agenda Citas"},
	{id:3005, pId:3000, name:"Odontograma", file:"odontograma.action?estado=all&funcPosicionado=Calendario/Odontograma"},
	{id:3006, pId:3000, name:"Tipo Procedimiento", file:"tipoProcedimiento.action?estado=all&funcPosicionado=Calendario/Tipo Procedimiento"},
	{id:3007, pId:3000, name:"Procedimiento", file:"procedimiento.action?estado=all&funcPosicionado=Calendario/Procedimiento"},
	{id:3008, pId:3000, name:"Servicio Clinico", file:"servicioclinico.action?estado=all&funcPosicionado=Calendario/Servicio Clinico"},
	
	{id:3014, pId:3000, name:"Servicio Clinico", file:"servicioclinico.action?estado=alltiposervicio&funcPosicionado=Calendario/Servicio Clinico"},
	
	{id:3009, pId:3000, name:"Tipo Segmento Anamnesis", file:"tiposeganamnesis.action?estado=all&funcPosicionado=Calendario/Tipo Segmento Anamnesis"},
	
	{id:3010, pId:3000, name:"Tipo Pregunta", file:"tipopregunta.action?estado=all&funcPosicionado=Calendario/Tipo Pregunta"},
	{id:3015, pId:3000, name:"Tipo Pregunta JSF", file:"historiaClinica/tipoPregunta.xhtml?estado=all&funcPosicionado=Calendario/Tipo Pregunta"},
	 
	{id:3011, pId:3000, name:"Segmentos Anamnesis", file:"segmentoanamnesis.action?estado=all&funcPosicionado=Calendario/Segmentos Anamnesis"},
	{id:3012, pId:3000, name:"Preguntas", file:"pregunta.action?estado=all&funcPosicionado=Calendario/Preguntas"},
	{id:3013, pId:3000, name:"Opciones Respuestas", file:"opcionrespuesta.action?estado=all&funcPosicionado=Calendario/Opciones Respuestas"},
	{id:3014, pId:3000, name:"Examenes Especialidad", file:"examenespecialidad.action?estado=all&funcPosicionado=Calendario/Examenes Especialidad"},
	
	
	{id:4000, pId:0, name:"Personal", open:true},
	{id:4001, pId:4000, name:"Administración Personal", file:"listPersonal.action?url=Personal::>Administración Personal"},
	{id:4002, pId:4000, name:"Cambiar Contraseña", file:"cambiarPassword.action?url=Personal::>Cambiar Contraseña"},
	
	{id:5000, pId:0, name:"NIIF", open:true}, 
	{id:5001, pId:5000, name:"Categoria Articulo", file:"categoriaart.action?estado=all&funcPosicionado=NIIF::>Categoria Artículos"},
	{id:5002, pId:5000, name:"Articulos", file:"articulo.action?estado=all&funcPosicionado=NIIF::>Artículos"},
	{id:5003, pId:5000, name:"Orden de Compra", file:"ordencompra.action?estado=all&funcPosicionado=NIIF::>Orden de Compra"},
	{id:5004, pId:5000, name:"Condicion de Pago", file:"condicionpago.action?estado=all&funcPosicionado=NIIF::>Condicion de Pago"},
	{id:5005, pId:5000, name:"Forma de Pago", file:"formapago.action?estado=all&funcPosicionado=NIIF::>Forma de Pago"},
	{id:5006, pId:5000, name:"Portafolio", file:"portafolio.action?estado=all&funcPosicionado=NIIF::>Portafolio"},
	{id:5007, pId:5000, name:"Portafolio Categoria", file:"portafoliocategoria.action?estado=all&funcPosicionado=NIIF::>Portafolio Categoria"},
	{id:5008, pId:5000, name:"Ventas", file:"venta.action?estado=alltiposervicio&funcPosicionado=NIIF::>Ventas"},
	{id:5009, pId:5000, name:"Consecutivos", file:"consecutivo.action?estado=all&funcPosicionado=NIIF::>Consecutivos de Ventas"},
	{id:5010, pId:5000, name:"Pagos", file:"pagos.action?estado=all&funcPosicionado=NIIF::>Pagos"},
	{id:5011, pId:5000, name:"Parametros Agenda Categorias", file:"agendacategoria.action?estado=all&funcPosicionado=NIIF::>Parametros Agenda Categorias"},
	{id:5012, pId:5000, name:"Agendar Compromisos", file:"calendarioCategoria.action?estado=all&funcPosicionado=NIIF::>/Agendar Compromisos"},
	
	{id:6000, pId:0, name:"Reportes", open:true},
	{id:6001, pId:6000, name:"Ventas", file:"ventareport.action?estado=all&funcPosicionado=Reportes::>Ventas"},
	{id:6002, pId:6000, name:"Cartera", file:"carterareport.action?estado=all&funcPosicionado=Reportes::>Cartera"},
	
//	{id:5000, pId:0, name:"Cartera", open:true},
//	{id:5001, pId:5000, name:"Parametricas", open:true, file:"inicioParametrica.action?url=Cartera::>Parametricas"},
//	{id:5002, pId:5001, name:"Sucursales", file:"listSucursales.action?url=Cartera::>Parametricas::>Sucursales"},
//	{id:5003, pId:53000, name:"Donaciones", open:true, file:"inicioDonaciones.action?url=Cartera::>Donaciones"},
//	{id:5004, pId:5003, name:"Entidad Donante", file:"listEntidadDonante.action?url=Cartera::>Donaciones::>Entidad Donante"},
//	{id:5005, pId:5003, name:"Donar", file:"listDonaciones.action?url=Cartera::>Donaciones::>Donar"},
//	{id:5006, pId:5003, name:"Productos", file:"listObjetos.action?url=Cartera::>Donaciones::>Productos"},
//	{id:5007, pId:5003, name:"Presupuesto", file:"listPresupuesto.action?url=Cartera::>Donaciones::>Presupuesto"},
//	{id:5008, pId:5000, name:"Creditos", open:true, file:"inicioCreditos.action?url=Cartera::>Creditos"},
//	{id:5009, pId:5008, name:"Pagare", file:"listPagare.action?url=Cartera::>Creditos::>Pagare"},
//	{id:5010, pId:5008, name:"Tipos de Creditos", file:"listTipoCredito.action?url=Cartera::>Creditos::>Tipos de Creditos"},
//	{id:5011, pId:5008, name:"Creditos Socios", file:"listCreditosSocios.action?url=Cartera::>Creditos::>Creditos Socios"},
//	{id:5012, pId:5008, name:"Anular Credito", file:"findRefCredito.action?url=Cartera::>Creditos::>Anular Credito"},
//	{id:6000, pId:0, name:"Reportes", open:true},
//	{id:6001, pId:6000, name:"Creditos por Cliente", file:"reportCredCliente.action?url=Instituciones::>Creditos por Cliente"}
]; 


