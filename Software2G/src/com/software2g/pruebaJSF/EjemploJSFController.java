package com.software2g.pruebaJSF;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.software2g.vo.Procedimiento;
import com.software2g.vo.Tipoespecialidad;

@ManagedBean
@SessionScoped
public class EjemploJSFController {
	@EJB
	CustomerDAO customerDAO;

	@EJB
	PurchaseOrderDAO purchaseOrderDAO;

	String cadenaBusqueda;
	List<Procedimiento> listaClientes;
	Procedimiento clienteActual;
	List<Tipoespecialidad> listaPedidosClienteActual;
	Tipoespecialidad pedidoActual;
	
	public String getCadenaBusqueda() {return cadenaBusqueda;}
	public void setCadenaBusqueda(String cadenaBusqueda) {this.cadenaBusqueda = cadenaBusqueda;}
	public List<Procedimiento> getListaClientes() {return listaClientes;}
	public void setListaClientes(List<Procedimiento> listaClientes) {this.listaClientes = listaClientes;}
	public Procedimiento getClienteActual() {return clienteActual;}
	public void setClienteActual(Procedimiento clienteActual) {this.clienteActual = clienteActual;}
	public List<Tipoespecialidad> getListaPedidosClienteActual() {return listaPedidosClienteActual;}
	public void setListaPedidosClienteActual(List<Tipoespecialidad> listaPedidosClienteActual) {this.listaPedidosClienteActual = listaPedidosClienteActual;}
	public Tipoespecialidad getPedidoActual() {return pedidoActual;}
	public void setPedidoActual(Tipoespecialidad pedidoActual) {this.pedidoActual = pedidoActual;}

	@PostConstruct
	public void inicializar(){
		listaClientes = customerDAO.buscarTodos();
		clienteActual = listaClientes.get(0);
		listaPedidosClienteActual = purchaseOrderDAO.buscarPorCliente(clienteActual.getPrtoId());
		pedidoActual = null;
	}
	
	public String doVerPedidos(Procedimiento cliente) {
		clienteActual = cliente;
		listaPedidosClienteActual = purchaseOrderDAO.buscarPorCliente(cliente.getPrtoId());
		return "detalleCliente";
	}
	
	public String doBuscarCliente(){
		listaClientes = customerDAO.buscarPorNombre(cadenaBusqueda);
		clienteActual = listaClientes.get(0);
		return "index";
	}
	
	public String doNuevoCliente(){
		clienteActual = new Procedimiento();
		listaPedidosClienteActual = null;
		return "nuevoCliente";
	}

	public String doGuardarCliente(){
		customerDAO.crear(clienteActual);
		return "index";
	}
}
