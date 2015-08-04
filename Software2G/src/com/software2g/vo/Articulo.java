package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.software2g.util.ConstantesAplicativo;

import java.util.List;


/**
 * The persistent class for the articulo database table.
 * 
 */
@Entity
@Table(name="articulo", schema="niif")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARTICULO_ARTIID_GENERATOR", sequenceName="NIIF.SEQ_ARTI_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARTICULO_ARTIID_GENERATOR")
	@Column(name="arti_id")
	private long artiId;

	@Column(name="arti_descripcion")
	private String artiDescripcion;

	@Column(name="arti_estado")
	private String artiEstado;

	@Column(name="arti_fechacambio")
	private String artiFechacambio;

	@Column(name="arti_horacambio")
	private String artiHoracambio;

	@Column(name="arti_marca")
	private String artiMarca;

	@Column(name="arti_nombre")
	private String artiNombre;

	@Column(name="arti_porcentajeutilidad")
	private double artiPorcentajeutilidad;

	@Column(name="arti_preciobase")
	private double artiPreciobase;

	@Column(name="arti_precioventa")
	private double artiPrecioventa;

	@Column(name="arti_puntoequilibrio")
	private int artiPuntoequilibrio;

	@Column(name="arti_referencia")
	private String artiReferencia;

	@Column(name="arti_registradopor")
	private String artiRegistradopor;

	@Column(name="arti_reqesptecnica")
	private String artiReqesptecnica = ConstantesAplicativo.constanteCheckNo;

	@Column(name="arti_reqformula")
	private String artiReqformula = ConstantesAplicativo.constanteCheckNo;

	@Column(name="arti_stock")
	private int artiStock;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="cate_id")
	private Categoria categoria;

	//bi-directional many-to-one association to Detallecompra
	@OneToMany(mappedBy="articulo")
	private List<Detallecompra> detallecompras;

	//bi-directional many-to-one association to Detalleventa
	@OneToMany(mappedBy="articulo")
	private List<Detalleventa> detalleventas;

	public Articulo() {
	}

	public long getArtiId() {
		return this.artiId;
	}

	public void setArtiId(long artiId) {
		this.artiId = artiId;
	}

	public String getArtiDescripcion() {
		return this.artiDescripcion;
	}

	public void setArtiDescripcion(String artiDescripcion) {
		this.artiDescripcion = artiDescripcion;
	}

	public String getArtiEstado() {
		return this.artiEstado;
	}

	public void setArtiEstado(String artiEstado) {
		this.artiEstado = artiEstado;
	}

	public String getArtiFechacambio() {
		return this.artiFechacambio;
	}

	public void setArtiFechacambio(String artiFechacambio) {
		this.artiFechacambio = artiFechacambio;
	}

	public String getArtiHoracambio() {
		return this.artiHoracambio;
	}

	public void setArtiHoracambio(String artiHoracambio) {
		this.artiHoracambio = artiHoracambio;
	}

	public String getArtiMarca() {
		return this.artiMarca;
	}

	public void setArtiMarca(String artiMarca) {
		this.artiMarca = artiMarca;
	}

	public String getArtiNombre() {
		return this.artiNombre;
	}

	public void setArtiNombre(String artiNombre) {
		this.artiNombre = artiNombre;
	}

	public double getArtiPorcentajeutilidad() {
		return this.artiPorcentajeutilidad;
	}

	public void setArtiPorcentajeutilidad(double artiPorcentajeutilidad) {
		this.artiPorcentajeutilidad = artiPorcentajeutilidad;
	}

	public double getArtiPreciobase() {
		return this.artiPreciobase;
	}

	public void setArtiPreciobase(double artiPreciobase) {
		this.artiPreciobase = artiPreciobase;
	}

	public double getArtiPrecioventa() {
		return this.artiPrecioventa;
	}

	public void setArtiPrecioventa(double artiPrecioventa) {
		this.artiPrecioventa = artiPrecioventa;
	}

	public int getArtiPuntoequilibrio() {
		return this.artiPuntoequilibrio;
	}

	public void setArtiPuntoequilibrio(int artiPuntoequilibrio) {
		this.artiPuntoequilibrio = artiPuntoequilibrio;
	}

	public String getArtiReferencia() {
		return this.artiReferencia;
	}

	public void setArtiReferencia(String artiReferencia) {
		this.artiReferencia = artiReferencia;
	}

	public String getArtiRegistradopor() {
		return this.artiRegistradopor;
	}

	public void setArtiRegistradopor(String artiRegistradopor) {
		this.artiRegistradopor = artiRegistradopor;
	}

	public String getArtiReqesptecnica() {
		return this.artiReqesptecnica;
	}

	public void setArtiReqesptecnica(String artiReqesptecnica) {
		this.artiReqesptecnica = artiReqesptecnica;
	}

	public String getArtiReqformula() {
		return this.artiReqformula;
	}

	public void setArtiReqformula(String artiReqformula) {
		this.artiReqformula = artiReqformula;
	}

	public int getArtiStock() {
		return this.artiStock;
	}

	public void setArtiStock(int artiStock) {
		this.artiStock = artiStock;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Detallecompra> getDetallecompras() {
		return this.detallecompras;
	}

	public void setDetallecompras(List<Detallecompra> detallecompras) {
		this.detallecompras = detallecompras;
	}

	public List<Detalleventa> getDetalleventas() {
		return this.detalleventas;
	}

	public void setDetalleventas(List<Detalleventa> detalleventas) {
		this.detalleventas = detalleventas;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.artiRegistradopor=data.get(0);
			this.artiFechacambio=data.get(1);
			this.artiHoracambio=data.get(2);
		}
	}
}