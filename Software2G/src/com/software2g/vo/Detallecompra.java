package com.software2g.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the detallecompra database table.
 * 
 */
@Entity
@Table(name="detallecompra", schema="niif")
public class Detallecompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallecompraPK id;

	@Column(name="deco_cantidad")
	private int decoCantidad;

	@Column(name="deco_descuento")
	private double decoDescuento;

	@Column(name="deco_fechacambio")
	private String decoFechacambio;

	@Column(name="deco_horacambio")
	private String decoHoracambio;

	@Column(name="deco_ivaarticulo")
	private double decoIvaarticulo;

	@Column(name="deco_registradopor")
	private String decoRegistradopor;

	@Column(name="deco_valortotal")
	private double decoValortotal;

	@Column(name="deco_valorunitario")
	private double decoValorunitario;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="arti_id")
	private Articulo articulo;

	//bi-directional many-to-one association to Ordencompra
	@ManyToOne
	@JoinColumn(name="orco_id")
	private Ordencompra ordencompra;

	public Detallecompra() {
	}

	public DetallecompraPK getId() {
		return this.id;
	}

	public void setId(DetallecompraPK id) {
		this.id = id;
	}

	public int getDecoCantidad() {
		return this.decoCantidad;
	}

	public void setDecoCantidad(int decoCantidad) {
		this.decoCantidad = decoCantidad;
	}

	public double getDecoDescuento() {
		return this.decoDescuento;
	}

	public void setDecoDescuento(double decoDescuento) {
		this.decoDescuento = decoDescuento;
	}

	public String getDecoFechacambio() {
		return this.decoFechacambio;
	}

	public void setDecoFechacambio(String decoFechacambio) {
		this.decoFechacambio = decoFechacambio;
	}

	public String getDecoHoracambio() {
		return this.decoHoracambio;
	}

	public void setDecoHoracambio(String decoHoracambio) {
		this.decoHoracambio = decoHoracambio;
	}

	public double getDecoIvaarticulo() {
		return this.decoIvaarticulo;
	}

	public void setDecoIvaarticulo(double decoIvaarticulo) {
		this.decoIvaarticulo = decoIvaarticulo;
	}

	public String getDecoRegistradopor() {
		return this.decoRegistradopor;
	}

	public void setDecoRegistradopor(String decoRegistradopor) {
		this.decoRegistradopor = decoRegistradopor;
	}

	public double getDecoValortotal() {
		return this.decoValortotal;
	}

	public void setDecoValortotal(double decoValortotal) {
		this.decoValortotal = decoValortotal;
	}

	public double getDecoValorunitario() {
		return this.decoValorunitario;
	}

	public void setDecoValorunitario(double decoValorunitario) {
		this.decoValorunitario = decoValorunitario;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Ordencompra getOrdencompra() {
		return this.ordencompra;
	}

	public void setOrdencompra(Ordencompra ordencompra) {
		this.ordencompra = ordencompra;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.decoRegistradopor=data.get(0);
			this.decoFechacambio=data.get(1);
			this.decoHoracambio=data.get(2);
		}
	}
}