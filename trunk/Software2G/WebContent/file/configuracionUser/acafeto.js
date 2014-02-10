var zNodes = [
	{id:1000, pId:0, name:"Personal", open:true},
	{id:1001, pId:1000, name:"Administración Personal", file:"listPersonal.action?url=Personal::>Administración Personal"},
	{id:1002, pId:1000, name:"Cambiar Contraseña", file:"cambiarPassword.action?url=Personal::>Cambiar Contraseña"},
	{id:3000, pId:0, name:"Cartera", open:true},
	{id:3001, pId:3000, name:"Parametricas", open:true, file:"inicioParametrica.action?url=Cartera::>Parametricas"},
	{id:3002, pId:3001, name:"Sucursales", file:"listSucursales.action?url=Cartera::>Parametricas::>Sucursales"},
	{id:3003, pId:3000, name:"Donaciones", open:true, file:"inicioDonaciones.action?url=Cartera::>Donaciones"},
	{id:3004, pId:3003, name:"Entidad Donante", file:"listEntidadDonante.action?url=Cartera::>Donaciones::>Entidad Donante"},
	{id:3005, pId:3003, name:"Donar", file:"listDonaciones.action?url=Cartera::>Donaciones::>Donar"},
	{id:3006, pId:3003, name:"Productos", file:"listObjetos.action?url=Cartera::>Donaciones::>Productos"},
	{id:3007, pId:3003, name:"Presupuesto", file:"listPresupuesto.action?url=Cartera::>Donaciones::>Presupuesto"},
	{id:3008, pId:3000, name:"Creditos", open:true, file:"inicioCreditos.action?url=Cartera::>Creditos"},
	{id:3009, pId:3008, name:"Pagare", file:"listPagare.action?url=Cartera::>Creditos::>Pagare"},
	{id:3010, pId:3008, name:"Tipos de Creditos", file:"listTipoCredito.action?url=Cartera::>Creditos::>Tipos de Creditos"},
	{id:3011, pId:3008, name:"Creditos Socios", file:"listCreditosSocios.action?url=Cartera::>Creditos::>Creditos Socios"},
	{id:3012, pId:3008, name:"Anular Credito", file:"findRefCredito.action?url=Cartera::>Creditos::>Anular Credito"},
	{id:4000, pId:0, name:"Reportes", open:true},
	{id:4001, pId:4000, name:"Creditos por Cliente", file:"reportCredCliente.action?url=Instituciones::>Creditos por Cliente"}
]; 


