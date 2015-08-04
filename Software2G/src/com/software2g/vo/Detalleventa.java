package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the detalleventa database table.
 * 
 */
@Entity
@Table(name="detalleventa", schema="niif")
public class Detalleventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleventaPK id;

	@Column(name="deve_cantidad")
	private int deveCantidad;

	@Column(name="deve_estadoartven")
	private String deveEstadoartven;

	@Column(name="deve_fechacambio")
	private String deveFechacambio;

	@Column(name="deve_horacambio")
	private String deveHoracambio;

	@Column(name="deve_ivaartven")
	private double deveIvaartven;

	@Column(name="deve_registradopor")
	private String deveRegistradopor;

	@Column(name="deve_totalartven")
	private double deveTotalartven;

	@Column(name="deve_valorartven")
	private double deveValorartven;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="arti_id", insertable=false, updatable=false)
	private Articulo articulo;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="vent_id", insertable=false, updatable=false)
	private Venta venta;

	public Detalleventa() {
	}

	public DetalleventaPK getId() {
		return this.id;
	}

	public void setId(DetalleventaPK id) {
		this.id = id;
	}

	public int getDeveCantidad() {
		return this.deveCantidad;
	}

	public void setDeveCantidad(int deveCantidad) {
		this.deveCantidad = deveCantidad;
	}

	public String getDeveEstadoartven() {
		return this.deveEstadoartven;
	}

	public void setDeveEstadoartven(String deveEstadoartven) {
		this.deveEstadoartven = deveEstadoartven;
	}

	public String getDeveFechacambio() {
		return this.deveFechacambio;
	}

	public void setDeveFechacambio(String deveFechacambio) {
		this.deveFechacambio = deveFechacambio;
	}

	public String getDeveHoracambio() {
		return this.deveHoracambio;
	}

	public void setDeveHoracambio(String deveHoracambio) {
		this.deveHoracambio = deveHoracambio;
	}

	public double getDeveIvaartven() {
		return this.deveIvaartven;
	}

	public void setDeveIvaartven(double deveIvaartven) {
		this.deveIvaartven = deveIvaartven;
	}

	public String getDeveRegistradopor() {
		return this.deveRegistradopor;
	}

	public void setDeveRegistradopor(String deveRegistradopor) {
		this.deveRegistradopor = deveRegistradopor;
	}

	public double getDeveTotalartven() {
		return this.deveTotalartven;
	}

	public void setDeveTotalartven(double deveTotalartven) {
		this.deveTotalartven = deveTotalartven;
	}

	public double getDeveValorartven() {
		return this.deveValorartven;
	}

	public void setDeveValorartven(double deveValorartven) {
		this.deveValorartven = deveValorartven;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.deveRegistradopor=data.get(0);
			this.deveFechacambio=data.get(1);
			this.deveHoracambio=data.get(2);
		}
	}
}