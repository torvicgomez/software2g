package com.software2g.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria", schema="niif")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIA_CATEID_GENERATOR", sequenceName="NIIF.SEQ_CATE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_CATEID_GENERATOR")
	@Column(name="cate_id")
	private long cateId;

	@Column(name="cate_descripcion")
	private String cateDescripcion;

	@Column(name="cate_estado")
	private String cateEstado;

	@Column(name="cate_fechacambio")
	private String cateFechacambio;

	@Column(name="cate_horacambio")
	private String cateHoracambio;

	@Column(name="cate_nombre")
	private String cateNombre;

	@Column(name="cate_registradopor")
	private String cateRegistradopor;

	//bi-directional many-to-one association to Articulo
	@OneToMany(mappedBy="categoria")
	private List<Articulo> articulos;

	public Categoria() {
	}

	public long getCateId() {
		return this.cateId;
	}

	public void setCateId(long cateId) {
		this.cateId = cateId;
	}

	public String getCateDescripcion() {
		return this.cateDescripcion;
	}

	public void setCateDescripcion(String cateDescripcion) {
		this.cateDescripcion = cateDescripcion;
	}

	public String getCateEstado() {
		return this.cateEstado;
	}

	public void setCateEstado(String cateEstado) {
		this.cateEstado = cateEstado;
	}

	public String getCateFechacambio() {
		return this.cateFechacambio;
	}

	public void setCateFechacambio(String cateFechacambio) {
		this.cateFechacambio = cateFechacambio;
	}

	public String getCateHoracambio() {
		return this.cateHoracambio;
	}

	public void setCateHoracambio(String cateHoracambio) {
		this.cateHoracambio = cateHoracambio;
	}

	public String getCateNombre() {
		return this.cateNombre;
	}

	public void setCateNombre(String cateNombre) {
		this.cateNombre = cateNombre;
	}

	public String getCateRegistradopor() {
		return this.cateRegistradopor;
	}

	public void setCateRegistradopor(String cateRegistradopor) {
		this.cateRegistradopor = cateRegistradopor;
	}

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public void setDatosAud(List<String> data){
		if(data!=null&&data.size()==3){
			this.cateRegistradopor=data.get(0);
			this.cateFechacambio=data.get(1);
			this.cateHoracambio=data.get(2);
		}
	}
}